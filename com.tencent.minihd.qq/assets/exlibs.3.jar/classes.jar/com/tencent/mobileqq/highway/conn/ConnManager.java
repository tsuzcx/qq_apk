package com.tencent.mobileqq.highway.conn;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.segment.RequestWorker;
import com.tencent.mobileqq.highway.transaction.TransactionWorker;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.highway.utils.HwStatisticMgr;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ConnManager
  implements IHwManager, IConnectionListener
{
  public static boolean CONN_NUM_CUSTOM = false;
  public static final int CONN_TYPE_LONG = 1;
  public static final int CONN_TYPE_SHORT = 2;
  private static final int HB_RESP_COUNT_MAX = 4;
  public static final int IO_TYPE_SYNC = 1;
  public static AtomicInteger connSeq = new AtomicInteger(1);
  private long _connStartTime = -1L;
  private int connCount = -1;
  public ArrayList<ConnReportInfo> connInfoList = new ArrayList();
  private volatile int connType = 1;
  public volatile int connectedConn = 0;
  public ConcurrentHashMap<Integer, IConnection> connections = new ConcurrentHashMap();
  public HwEngine engine;
  public ConcurrentHashMap<Integer, EndPoint> heartBreakResp = new ConcurrentHashMap();
  public ConcurrentHashMap<Integer, Runnable> heartBreaks = new ConcurrentHashMap();
  private int ioType = 1;
  private ArrayList<EndPoint> mReportEndPoint;
  private int mReportFailCnt = 0;
  private boolean mReportHasStart = false;
  private long mReportStart = -1L;
  private int mReportSuccCnt = 0;
  public volatile AtomicLong vConnCost = new AtomicLong(-1L);
  public volatile int vConnErrCode = 0;
  
  public ConnManager(HwEngine paramHwEngine)
  {
    this.engine = paramHwEngine;
  }
  
  private void createNewConnectionIfNeed(int paramInt, boolean paramBoolean)
  {
    try
    {
      int j = (int)this.engine.getCurrentConfig().curConnNum;
      int i = j;
      if (!paramBoolean)
      {
        i = j;
        if (paramInt <= 1) {
          i = 1;
        }
      }
      synchronized (this.connections)
      {
        do
        {
          if (this.connections.size() >= i) {
            break;
          }
          j = HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType();
          if (j == 0)
          {
            BdhLogUtil.LogEvent("C", "CreateNewConnectionIfNeed : No network in networkCenter : ConnSize:" + this.connections.size() + " currentRequests:" + paramInt + " maxConnNum:" + i);
            HwNetworkCenter.getInstance(this.engine.getAppContext()).updateNetInfo(this.engine.getAppContext());
            this.engine.mRequestWorker.sendConnectRequest(5000L, false);
            return;
          }
        } while (openNewConnection(j));
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      BdhLogUtil.LogException("C", "Create Conn Error.", localException);
    }
  }
  
  private boolean openNewConnection(int paramInt)
  {
    Object localObject1 = ConfigManager.getInstance(this.engine.getAppContext(), this.engine.app, this.engine.appId, this.engine.currentUin).getNextSrvAddr(this.engine.getAppContext(), this.engine.app, this.engine.currentUin);
    if ((this.connectedConn <= 0) && (this._connStartTime == -1L)) {
      this._connStartTime = SystemClock.uptimeMillis();
    }
    for (;;)
    {
      synchronized (this.connections)
      {
        int i = this.connections.size();
        if (localObject1 == null)
        {
          BdhLogUtil.LogEvent("C", "OpenNewConnection : ep is Null, connSize:" + i);
          if (i == 0) {
            this.engine.mTransWorker.switchToBackupChannel();
          }
          return false;
        }
        if (((EndPoint)localObject1).protoType == 1) {
          this.connType = 1;
        }
        reportChannelStart((EndPoint)localObject1);
        ??? = new ConnReportInfo();
        if (this.ioType == 1)
        {
          if (paramInt == 1)
          {
            paramInt = 10000;
            localObject1 = new SyncTcpConnection(this, 32768, paramInt, 30000, connSeq.incrementAndGet(), this.connType, (EndPoint)localObject1, (ConnReportInfo)???);
            this.connections.put(Integer.valueOf(((IConnection)localObject1).getConnId()), localObject1);
            ((IConnection)localObject1).setConnectListener(this);
            ((IConnection)localObject1).connect();
          }
        }
        else {
          return true;
        }
      }
      paramInt = 20000;
    }
  }
  
  public long getConnCost()
  {
    return this.vConnCost.getAndSet(-1L);
  }
  
  public int getCurrentConnNum()
  {
    synchronized (this.connections)
    {
      int i = this.connections.size();
      return i;
    }
  }
  
  public String getHeartBreakInfo()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.heartBreakResp.values());
    this.heartBreakResp.clear();
    String str = "null";
    if (!localArrayList.isEmpty()) {
      str = Arrays.toString(localArrayList.toArray());
    }
    return str;
  }
  
  public boolean hasNet()
  {
    HwNetworkCenter localHwNetworkCenter = HwNetworkCenter.getInstance(this.engine.getAppContext());
    localHwNetworkCenter.updateNetInfo(this.engine.getAppContext());
    return localHwNetworkCenter.getNetType() != 0;
  }
  
  public void increaseDataFlowDw(long paramLong)
  {
    int i = HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType();
    if (i == 1) {
      this.engine.dwFlow_Wifi.addAndGet(paramLong);
    }
    while (i == 0) {
      return;
    }
    this.engine.dwFlow_Xg.addAndGet(paramLong);
  }
  
  public void increaseDataFlowUp(long paramLong)
  {
    int i = HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType();
    if (i == 1) {
      this.engine.upFlow_Wifi.addAndGet(paramLong);
    }
    while (i == 0) {
      return;
    }
    this.engine.upFlow_Xg.addAndGet(paramLong);
  }
  
  public void onConnect(boolean paramBoolean, int paramInt1, IConnection paramIConnection, EndPoint paramEndPoint, int paramInt2, ConnReportInfo paramConnReportInfo)
  {
    if (paramBoolean)
    {
      this.connectedConn += 1;
      this.engine.mRequestWorker.onConnConnected(paramInt1);
      if (paramIConnection.getConnType() != 2) {
        this.engine.mRequestWorker.sendHeartBreak(paramInt1, false, false, 0);
      }
      if (this._connStartTime >= 0L)
      {
        long l1 = SystemClock.uptimeMillis();
        long l2 = this._connStartTime;
        this._connStartTime = -1L;
        this.vConnCost.compareAndSet(-1L, l1 - l2);
      }
    }
    for (;;)
    {
      this.vConnErrCode = paramInt2;
      reportConnectResult(paramEndPoint, paramBoolean, paramInt2, paramConnReportInfo.connElapseTime);
      BdhLogUtil.LogEvent("C", "OnConnect :　connId:" + paramInt1 + " Size:" + this.connections.size() + " errno:" + paramInt2);
      return;
      this.connections.remove(Integer.valueOf(paramIConnection.getConnId()));
      paramIConnection = this.engine.getAppContext();
      if (paramIConnection != null) {
        ConfigManager.getInstance(paramIConnection, this.engine.app, this.engine.appId, this.engine.currentUin).onSrvAddrUnavailable(this.engine.getAppContext(), this.engine.app, this.engine.currentUin, paramEndPoint.host, paramInt2);
      }
      if (paramInt2 == 3) {
        this.engine.mRequestWorker.sendConnectRequest(5000L, false);
      } else {
        this.engine.mRequestWorker.sendConnectRequest(0L, false);
      }
    }
  }
  
  public void onConnectionIdle(int paramInt, boolean paramBoolean)
  {
    this.engine.mRequestWorker.sendHeartBreak(paramInt, false, paramBoolean, 60000);
  }
  
  public void onDecodeSucessfully(List<HwResponse> paramList)
  {
    this.engine.mRequestWorker.onReceiveResp(paramList);
  }
  
  public void onDestroy() {}
  
  public void onDisConnect(int paramInt, IConnection paramIConnection)
  {
    HwNetworkCenter.getInstance(this.engine.getAppContext()).updateNetInfo(this.engine.getAppContext());
    if ((IConnection)this.connections.remove(Integer.valueOf(paramIConnection.getConnId())) != null)
    {
      this.connectedConn -= 1;
      this.engine.mRequestWorker.onConnClose(paramInt);
      BdhLogUtil.LogEvent("C", "OnDisConnect :　connId:" + paramInt + " Size:" + this.connections.size());
    }
  }
  
  public void onHeartBreakResp(int paramInt, EndPoint paramEndPoint)
  {
    BdhLogUtil.LogEvent("C", "onHeartBreakResp : connId:" + paramInt);
    IConnection localIConnection = (IConnection)this.connections.get(Integer.valueOf(paramInt));
    if (localIConnection != null) {
      localIConnection.setUrgentFlag(false);
    }
    if (this.heartBreakResp.size() < 4) {
      this.heartBreakResp.put(Integer.valueOf(paramInt), paramEndPoint);
    }
  }
  
  public void onInit() {}
  
  public void onRecvInvalidData(EndPoint paramEndPoint)
  {
    Context localContext = this.engine.getAppContext();
    if ((paramEndPoint != null) && (localContext != null))
    {
      ConfigManager localConfigManager = ConfigManager.getInstance(localContext, this.engine.app, this.engine.appId, this.engine.currentUin);
      if (localConfigManager != null) {
        localConfigManager.onSrvAddrUnavailable(localContext, this.engine.app, this.engine.currentUin, paramEndPoint.host, 15);
      }
    }
  }
  
  public void onRequestTimeOut(int paramInt)
  {
    BdhLogUtil.LogEvent("C", "onRequestTimeOut : connId:" + paramInt);
    IConnection localIConnection = (IConnection)this.connections.get(Integer.valueOf(paramInt));
    if (localIConnection != null)
    {
      if (localIConnection.getProtoType() != 1) {
        break label62;
      }
      localIConnection.setUrgentFlag(true);
    }
    label62:
    while (localIConnection.getProtoType() != 2) {
      return;
    }
    Object localObject = this.engine.getAppContext();
    EndPoint localEndPoint = localIConnection.getEndPoint();
    if ((localEndPoint != null) && (localObject != null))
    {
      localObject = ConfigManager.getInstance((Context)localObject, this.engine.app, this.engine.appId, this.engine.currentUin);
      if (localObject != null) {
        ((ConfigManager)localObject).onSrvAddrUnavailable(this.engine.getAppContext(), this.engine.app, this.engine.currentUin, localEndPoint.host, 7);
      }
    }
    this.connType = 2;
    localIConnection.disConnect();
    createNewConnectionIfNeed(1, false);
  }
  
  public void onRequestWriteTimeout(int paramInt)
  {
    BdhLogUtil.LogEvent("C", "onRequestWriteTimeout : connId:" + paramInt);
    IConnection localIConnection = (IConnection)this.connections.get(Integer.valueOf(paramInt));
    if (localIConnection != null) {
      localIConnection.disConnect();
    }
  }
  
  public void onUrgentHeartBreakTimeout(int paramInt, EndPoint paramEndPoint)
  {
    BdhLogUtil.LogEvent("C", "onUrgentHeartBreakTimeout : connId:" + paramInt);
    Object localObject = (IConnection)this.connections.get(Integer.valueOf(paramInt));
    if (localObject != null) {
      ((IConnection)localObject).disConnect();
    }
    localObject = this.engine.getAppContext();
    if ((paramEndPoint != null) && (localObject != null))
    {
      localObject = ConfigManager.getInstance((Context)localObject, this.engine.app, this.engine.appId, this.engine.currentUin);
      if (localObject != null) {
        ((ConfigManager)localObject).onSrvAddrUnavailable(this.engine.getAppContext(), this.engine.app, this.engine.currentUin, paramEndPoint.host, 7);
      }
    }
    createNewConnectionIfNeed(1, false);
  }
  
  public HwRequest pullNextRequest(IConnection paramIConnection, boolean paramBoolean)
  {
    int i = 2;
    if (paramBoolean) {
      i = 0;
    }
    return this.engine.mRequestWorker.getMaxPriorityRequest(paramIConnection.getConnId(), i);
  }
  
  public void reportChannelStart(EndPoint paramEndPoint)
  {
    int i = this.connCount + 1;
    this.connCount = i;
    paramEndPoint.connIndex = i;
    if (this.mReportHasStart) {
      return;
    }
    this.mReportStart = SystemClock.uptimeMillis();
    this.mReportHasStart = true;
    this.mReportFailCnt = 0;
    this.mReportSuccCnt = 0;
    this.mReportEndPoint = new ArrayList();
  }
  
  public void reportChannelStop(boolean paramBoolean)
  {
    if (!this.mReportHasStart) {
      return;
    }
    this.mReportHasStart = false;
    if (paramBoolean) {
      this.connCount = -1;
    }
    int i = this.mReportFailCnt;
    int j = this.mReportSuccCnt;
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.mReportStart;
    HwStatisticMgr.doReportConnection(this.engine.appId, this.engine.currentUin, paramBoolean, i + j, this.mReportSuccCnt, this.mReportFailCnt, this.mReportEndPoint, l1 - l2);
  }
  
  public void reportConnectResult(EndPoint paramEndPoint, boolean paramBoolean, int paramInt, long paramLong)
  {
    paramEndPoint.connResult = paramInt;
    paramEndPoint.cost = paramLong;
    if (paramBoolean) {
      this.mReportSuccCnt += 1;
    }
    for (;;)
    {
      this.mReportEndPoint.add(paramEndPoint);
      if ((paramBoolean) || (this.mReportFailCnt >= 8)) {
        reportChannelStop(paramBoolean);
      }
      return;
      this.mReportFailCnt += 1;
    }
  }
  
  public void wakeupConnectionToWrite(int paramInt, boolean paramBoolean)
  {
    createNewConnectionIfNeed(paramInt, paramBoolean);
    synchronized (this.connections)
    {
      Iterator localIterator = this.connections.values().iterator();
      while (localIterator.hasNext())
      {
        IConnection localIConnection = (IConnection)localIterator.next();
        if (localIConnection.isWritable()) {
          localIConnection.wakeupChannel();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.ConnManager
 * JD-Core Version:    0.7.0.1
 */
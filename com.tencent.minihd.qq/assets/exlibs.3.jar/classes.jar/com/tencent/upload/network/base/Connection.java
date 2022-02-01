package com.tencent.upload.network.base;

import android.util.SparseArray;
import com.tencent.upload.common.StringUtils;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadLog;
import com.tencent.upload.network.route.DomainNameParser;
import com.tencent.upload.network.route.DomainNameParser.ParseResult;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Connection
  implements IConnection, IMsgCallback, IConnectionCallback
{
  private static final AtomicInteger PARAM_SEQUENCE = new AtomicInteger(0);
  private static final String TAG = "Connection";
  protected final WeakReference<IConnectionCallback> mCallback;
  protected String mConnectedIp;
  protected volatile boolean mIsConnected = false;
  protected final byte[] mLock = new byte[0];
  private ConnectionImpl mNativeConnection = null;
  protected SparseArray<Object> mParamMap = new SparseArray();
  
  public Connection(IConnectionCallback paramIConnectionCallback)
  {
    int i = UploadConfiguration.getDoNotFragment();
    this.mCallback = new WeakReference(paramIConnectionCallback);
    if (!ConnectionImpl.isLibraryPrepared())
    {
      UploadLog.e("Connection", "!isLibraryPrepared");
      return;
    }
    this.mNativeConnection = new ConnectionImpl(getProtocolCategory(), i);
    this.mNativeConnection.setCallback(this);
    this.mNativeConnection.setMsgCallback(this);
  }
  
  private static final int nextParamSequence()
  {
    return PARAM_SEQUENCE.incrementAndGet();
  }
  
  public boolean connectAsync(String arg1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    if (this.mNativeConnection == null) {
      return false;
    }
    paramString2 = new ConnectParam(???, paramInt1, paramString2, paramInt2, paramInt3);
    paramInt1 = nextParamSequence();
    synchronized (this.mLock)
    {
      this.mParamMap.put(paramInt1, paramString2);
      return this.mNativeConnection.PostMessage(0, null, paramInt1);
    }
  }
  
  public final String getConnectedIp()
  {
    return this.mConnectedIp;
  }
  
  public boolean isConnected()
  {
    return this.mIsConnected;
  }
  
  public boolean isRunning()
  {
    if (this.mNativeConnection == null) {
      return false;
    }
    return this.mNativeConnection.isRunning();
  }
  
  public void onConnect(IConnectionCallback paramIConnectionCallback, boolean paramBoolean, int paramInt, String paramString)
  {
    this.mIsConnected = paramBoolean;
    IConnectionCallback localIConnectionCallback = (IConnectionCallback)this.mCallback.get();
    if (localIConnectionCallback == null) {
      return;
    }
    localIConnectionCallback.onConnect(paramIConnectionCallback, paramBoolean, paramInt, paramString);
  }
  
  public void onDisconnect(IConnectionCallback paramIConnectionCallback)
  {
    this.mIsConnected = false;
    IConnectionCallback localIConnectionCallback = (IConnectionCallback)this.mCallback.get();
    if (localIConnectionCallback == null) {
      return;
    }
    localIConnectionCallback.onDisconnect(paramIConnectionCallback);
  }
  
  public void onError(IConnectionCallback paramIConnectionCallback, int paramInt)
  {
    IConnectionCallback localIConnectionCallback = (IConnectionCallback)this.mCallback.get();
    if (localIConnectionCallback == null) {
      return;
    }
    localIConnectionCallback.onError(paramIConnectionCallback, paramInt);
  }
  
  public void onMsgCallback(IMsgCallback arg1, int paramInt1, Object paramObject, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    synchronized (this.mLock)
    {
      paramObject = this.mParamMap.get(paramInt2);
      this.mParamMap.remove(paramInt2);
      switch (paramInt1)
      {
      }
    }
    if ((this.mNativeConnection != null) && ((paramObject instanceof ConnectParam)))
    {
      ConnectParam localConnectParam = (ConnectParam)paramObject;
      ??? = localConnectParam.ip;
      paramInt1 = UploadConfiguration.getMaxSegmentSize(???);
      if (!StringUtils.isIpv4String(localConnectParam.ip))
      {
        ??? = new DomainNameParser.ParseResult();
        DomainNameParser.parse(localConnectParam.ip, ???);
        paramObject = ???.paseredIp;
        ???.paseredIp = null;
        ??? = paramObject;
        if (paramObject == null)
        {
          this.mIsConnected = false;
          ??? = (IConnectionCallback)this.mCallback.get();
          if (??? == null) {
            return;
          }
          ???.onConnect(this, false, 558, paramObject);
          return;
        }
      }
      this.mNativeConnection.connect(???, localConnectParam.port, localConnectParam.proxyIp, localConnectParam.proxyPort, localConnectParam.timeout, paramInt1);
      this.mConnectedIp = ???;
    }
    else
    {
      ??? = new StringBuilder(" OperationMsg.CONNECT, obj instanceof ConnectParam:").append(paramObject instanceof ConnectParam).append("mNativeConnection != null:");
      if (this.mNativeConnection != null) {}
      for (;;)
      {
        UploadLog.w("Connection", bool1);
        return;
        bool1 = false;
      }
      if (this.mNativeConnection != null)
      {
        this.mNativeConnection.disconnect();
        return;
      }
      UploadLog.w("Connection", " OperationMsg.DISCONNECT, mNativeConnection == null");
      return;
      if ((this.mNativeConnection != null) && ((paramObject instanceof SendParam)))
      {
        ??? = (SendParam)paramObject;
        this.mNativeConnection.SendData(???.buf, ???.sendSequence, ???.sendTimeout, ???.recvTimeout);
        return;
      }
      ??? = new StringBuilder(" OperationMsg.SEND, obj instanceof ConnectParam:").append(paramObject instanceof SendParam).append("mNativeConnection != null:");
      if (this.mNativeConnection != null) {}
      for (bool1 = bool2;; bool1 = false)
      {
        UploadLog.w("Connection", bool1);
        return;
      }
    }
  }
  
  public void onRecv(IConnectionCallback paramIConnectionCallback, byte[] paramArrayOfByte)
  {
    IConnectionCallback localIConnectionCallback = (IConnectionCallback)this.mCallback.get();
    if (localIConnectionCallback == null) {
      return;
    }
    localIConnectionCallback.onRecv(paramIConnectionCallback, paramArrayOfByte);
  }
  
  public void onSendBegin(IConnectionCallback paramIConnectionCallback, int paramInt)
  {
    IConnectionCallback localIConnectionCallback = (IConnectionCallback)this.mCallback.get();
    if (localIConnectionCallback == null) {
      return;
    }
    localIConnectionCallback.onSendBegin(paramIConnectionCallback, paramInt);
  }
  
  public void onSendEnd(IConnectionCallback paramIConnectionCallback, int paramInt)
  {
    IConnectionCallback localIConnectionCallback = (IConnectionCallback)this.mCallback.get();
    if (localIConnectionCallback == null) {
      return;
    }
    localIConnectionCallback.onSendEnd(paramIConnectionCallback, paramInt);
  }
  
  public void onSendTimeOut(IConnectionCallback paramIConnectionCallback, int paramInt1, int paramInt2)
  {
    IConnectionCallback localIConnectionCallback = (IConnectionCallback)this.mCallback.get();
    if (localIConnectionCallback == null) {
      return;
    }
    localIConnectionCallback.onSendTimeOut(paramIConnectionCallback, paramInt1, paramInt2);
  }
  
  public void onStart(IConnectionCallback paramIConnectionCallback)
  {
    IConnectionCallback localIConnectionCallback = (IConnectionCallback)this.mCallback.get();
    if (localIConnectionCallback == null) {
      return;
    }
    localIConnectionCallback.onStart(paramIConnectionCallback);
  }
  
  public boolean sendAsync(byte[] arg1, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mNativeConnection == null) {
      return false;
    }
    SendParam localSendParam = new SendParam(???, paramInt1, paramInt2, paramInt3);
    paramInt1 = nextParamSequence();
    synchronized (this.mLock)
    {
      this.mParamMap.put(paramInt1, localSendParam);
      return this.mNativeConnection.PostMessage(2, null, paramInt1);
    }
  }
  
  public void setCallback(IConnectionCallback paramIConnectionCallback)
  {
    if (this.mNativeConnection == null) {
      return;
    }
    this.mNativeConnection.setCallback(paramIConnectionCallback);
  }
  
  public boolean start()
  {
    if (this.mNativeConnection == null) {
      return false;
    }
    if (this.mNativeConnection.isRunning())
    {
      UploadLog.w("Connection", "start, is running, return false");
      return false;
    }
    return this.mNativeConnection.start();
  }
  
  public boolean stop()
  {
    if (this.mNativeConnection == null) {
      return false;
    }
    this.mNativeConnection.removeAllSendData();
    boolean bool = this.mNativeConnection.stop();
    synchronized (this.mLock)
    {
      this.mParamMap.clear();
      return bool;
    }
  }
  
  public void wakeUp()
  {
    if (this.mNativeConnection == null) {
      return;
    }
    this.mNativeConnection.wakeUp();
  }
  
  private static final class ConnectParam
  {
    public final String ip;
    public final int port;
    public final String proxyIp;
    public final int proxyPort;
    public final int timeout;
    
    public ConnectParam(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
    {
      this.ip = paramString1;
      this.port = paramInt1;
      this.proxyIp = paramString2;
      this.proxyPort = paramInt2;
      this.timeout = paramInt3;
    }
  }
  
  public static final class OperationMsg
  {
    public static final int CONNECT = 0;
    public static final int DISCONNECT = 1;
    public static final int ERROR = 3;
    public static final int SEND = 2;
    public static final int TIMEOUT = 4;
    
    public static final String print(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "unknown OperationMsg";
      case 0: 
        return "connect";
      case 1: 
        return "disconnect";
      case 2: 
        return "send";
      case 3: 
        return "error";
      }
      return "timeout";
    }
  }
  
  private static final class SendParam
  {
    public final byte[] buf;
    public final int recvTimeout;
    public final int sendSequence;
    public final int sendTimeout;
    
    public SendParam(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    {
      this.buf = paramArrayOfByte;
      this.sendSequence = paramInt1;
      this.sendTimeout = paramInt2;
      this.recvTimeout = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.network.base.Connection
 * JD-Core Version:    0.7.0.1
 */
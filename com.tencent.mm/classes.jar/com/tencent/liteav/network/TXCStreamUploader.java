package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public class TXCStreamUploader
  extends com.tencent.liteav.basic.module.a
  implements b
{
  public static final int RTMPSENDSTRATEGY_LIVE = 1;
  public static final int RTMPSENDSTRATEGY_REALTIME_QUIC = 3;
  public static final int RTMPSENDSTRATEGY_REALTIME_TCP = 2;
  static final String TAG = "TXCStreamUploader";
  public static final int TXE_UPLOAD_MODE_AUDIO_ONLY = 1;
  public static final int TXE_UPLOAD_MODE_LINK_MIC = 2;
  public static final int TXE_UPLOAD_MODE_REAL_TIME = 0;
  public static final int TXE_UPLOAD_PROTOCOL_AV = 1;
  public static final int TXE_UPLOAD_PROTOCOL_RTMP = 0;
  private final int MSG_EVENT;
  private final int MSG_RECONNECT;
  private final int MSG_REPORT_STATUS;
  private final int MSG_RTMPPROXY_HEARTBEAT;
  private boolean mAudioMuted;
  private int mChannelType;
  private int mConnectCountQuic;
  private int mConnectCountTcp;
  private long mConnectSuccessTimeStamps;
  private Context mContext;
  private int mCurrentRecordIdx;
  private boolean mEnableNearestIP;
  private long mGoodPushTime;
  private Handler mHandler;
  private HandlerThread mHandlerThread;
  private c mIntelligentRoute;
  private ArrayList<a> mIpList;
  private boolean mIsPushing;
  private int mLastNetworkType;
  private long mLastTimeStamp;
  private UploadStats mLastUploadStats;
  HashMap<String, String> mMetaData;
  private WeakReference<com.tencent.liteav.basic.c.a> mNotifyListener;
  private h mParam;
  private boolean mQuicChannel;
  private int mRetryCount;
  private long mRtmpMsgRecvThreadInstance;
  private Object mRtmpMsgRecvThreadLock;
  private boolean mRtmpProxyEnable;
  private int mRtmpProxyIPIndex;
  private Vector<String> mRtmpProxyIPList;
  private long mRtmpProxyInstance;
  private Object mRtmpProxyLock;
  private a mRtmpProxyParam;
  private String mRtmpUrl;
  private Thread mThread;
  private Object mThreadLock;
  private j mUploadQualityReport;
  private long mUploaderInstance;
  private Vector<TXSNALPacket> mVecPendingNAL;
  
  static
  {
    AppMethodBeat.i(15385);
    d.f();
    AppMethodBeat.o(15385);
  }
  
  public TXCStreamUploader(Context paramContext, h paramh)
  {
    AppMethodBeat.i(15337);
    this.mUploaderInstance = 0L;
    this.mThread = null;
    this.mThreadLock = null;
    this.mIsPushing = false;
    this.mRtmpUrl = "";
    this.mQuicChannel = false;
    this.mChannelType = 0;
    this.mEnableNearestIP = true;
    this.mIntelligentRoute = null;
    this.mLastNetworkType = 0;
    this.mNotifyListener = null;
    this.mContext = null;
    this.mIpList = null;
    this.mCurrentRecordIdx = 0;
    this.mRetryCount = 0;
    this.mConnectSuccessTimeStamps = 0L;
    this.mGoodPushTime = 30000L;
    this.mHandlerThread = null;
    this.mHandler = null;
    this.MSG_RECONNECT = 101;
    this.MSG_EVENT = 102;
    this.MSG_REPORT_STATUS = 103;
    this.MSG_RTMPPROXY_HEARTBEAT = 104;
    this.mLastTimeStamp = 0L;
    this.mLastUploadStats = null;
    this.mVecPendingNAL = new Vector();
    this.mParam = null;
    this.mConnectCountQuic = 0;
    this.mConnectCountTcp = 0;
    this.mUploadQualityReport = null;
    this.mRtmpProxyEnable = false;
    this.mAudioMuted = false;
    this.mRtmpProxyParam = new a();
    this.mRtmpProxyIPList = new Vector();
    this.mRtmpProxyIPIndex = 0;
    this.mRtmpProxyInstance = 0L;
    this.mRtmpMsgRecvThreadInstance = 0L;
    this.mRtmpProxyLock = new Object();
    this.mRtmpMsgRecvThreadLock = new Object();
    this.mContext = paramContext;
    h localh = paramh;
    if (paramh == null)
    {
      localh = new h();
      localh.a = 0;
      localh.g = 3;
      localh.f = 3;
      localh.h = 40;
      localh.i = 1000;
      localh.j = true;
    }
    this.mParam = localh;
    this.mThreadLock = new Object();
    this.mIntelligentRoute = new c();
    this.mIntelligentRoute.a = this;
    this.mUploaderInstance = 0L;
    this.mRetryCount = 0;
    this.mCurrentRecordIdx = 0;
    this.mIpList = null;
    this.mIsPushing = false;
    this.mThread = null;
    this.mRtmpUrl = null;
    this.mLastNetworkType = 0;
    this.mHandlerThread = null;
    this.mUploadQualityReport = new j(paramContext);
    i.a().a(paramContext);
    AppMethodBeat.o(15337);
  }
  
  private String getAddressFromUrl(String paramString)
  {
    AppMethodBeat.i(15355);
    if (paramString != null)
    {
      int i = paramString.indexOf("://");
      if (i != -1)
      {
        paramString = paramString.substring(i + 3);
        i = paramString.indexOf("/");
        if (i != -1)
        {
          paramString = paramString.substring(0, i);
          AppMethodBeat.o(15355);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(15355);
    return "";
  }
  
  private boolean getNextRtmpProxyIP()
  {
    AppMethodBeat.i(15365);
    this.mRtmpProxyParam.f = 234L;
    this.mRtmpProxyParam.g = 80L;
    if ((this.mRtmpProxyIPList != null) && (this.mRtmpProxyIPList.size() > 0))
    {
      if (this.mRtmpProxyIPIndex >= this.mRtmpProxyIPList.size())
      {
        this.mRtmpProxyIPIndex = 0;
        AppMethodBeat.o(15365);
        return false;
      }
      Object localObject = this.mRtmpUrl.split("://");
      if (localObject.length < 2)
      {
        AppMethodBeat.o(15365);
        return false;
      }
      localObject = localObject[1].substring(localObject[1].indexOf("/"));
      String str = (String)this.mRtmpProxyIPList.get(this.mRtmpProxyIPIndex);
      this.mRtmpProxyParam.h = str;
      this.mRtmpUrl = ("room://" + str + (String)localObject);
      this.mQuicChannel = true;
      this.mRtmpProxyIPIndex += 1;
      AppMethodBeat.o(15365);
      return true;
    }
    AppMethodBeat.o(15365);
    return false;
  }
  
  private HashMap getParamsFromUrl(String paramString)
  {
    AppMethodBeat.i(15364);
    HashMap localHashMap = new HashMap();
    paramString = paramString.split("[?]");
    if ((paramString == null) || (paramString.length < 2) || (paramString[1] == null) || (paramString[1].length() == 0))
    {
      AppMethodBeat.o(15364);
      return localHashMap;
    }
    paramString = paramString[1].split("[&]");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = paramString[i];
      if (arrayOfString.indexOf("=") != -1)
      {
        arrayOfString = arrayOfString.split("[=]");
        if (arrayOfString.length == 2) {
          localHashMap.put(arrayOfString[0], arrayOfString[1]);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(15364);
    return localHashMap;
  }
  
  private b getRtmpRealConnectInfo()
  {
    int i = 1;
    AppMethodBeat.i(15353);
    if (!this.mEnableNearestIP)
    {
      localObject = new b(this.mRtmpUrl, false);
      AppMethodBeat.o(15353);
      return localObject;
    }
    if (this.mIpList == null)
    {
      localObject = new b(this.mRtmpUrl, false);
      AppMethodBeat.o(15353);
      return localObject;
    }
    if ((this.mCurrentRecordIdx >= this.mIpList.size()) || (this.mCurrentRecordIdx < 0))
    {
      localObject = new b(this.mRtmpUrl, false);
      AppMethodBeat.o(15353);
      return localObject;
    }
    Object localObject = (a)this.mIpList.get(this.mCurrentRecordIdx);
    String[] arrayOfString1 = this.mRtmpUrl.split("://");
    if (arrayOfString1.length < 2)
    {
      localObject = new b(this.mRtmpUrl, false);
      AppMethodBeat.o(15353);
      return localObject;
    }
    String[] arrayOfString2 = arrayOfString1[1].split("/");
    arrayOfString2[0] = (((a)localObject).a + ":" + ((a)localObject).b);
    StringBuilder localStringBuilder = new StringBuilder(arrayOfString2[0]);
    while (i < arrayOfString2.length)
    {
      localStringBuilder.append("/");
      localStringBuilder.append(arrayOfString2[i]);
      i += 1;
    }
    localObject = new b(arrayOfString1[0] + "://" + localStringBuilder.toString(), ((a)localObject).c);
    AppMethodBeat.o(15353);
    return localObject;
  }
  
  private Long getSpeed(long paramLong1, long paramLong2, long paramLong3)
  {
    long l = 0L;
    AppMethodBeat.i(15361);
    if (paramLong1 > paramLong2) {}
    for (;;)
    {
      paramLong1 = l;
      if (paramLong3 > 0L) {
        paramLong1 = 8L * paramLong2 * 1000L / (1024L * paramLong3);
      }
      AppMethodBeat.o(15361);
      return Long.valueOf(paramLong1);
      paramLong2 -= paramLong1;
    }
  }
  
  private void internalReconnect(boolean paramBoolean)
  {
    AppMethodBeat.i(15357);
    if (!this.mIsPushing)
    {
      AppMethodBeat.o(15357);
      return;
    }
    if (this.mRtmpProxyEnable)
    {
      if (this.mLastNetworkType != d.e(this.mContext))
      {
        TXCLog.e("TXCStreamUploader", "reconnect network switch from " + this.mLastNetworkType + " to " + d.e(this.mContext));
        this.mLastNetworkType = d.e(this.mContext);
        this.mRetryCount = 0;
        Monitor.a(2, "WebrtcRoom: need enter again by user", "", 0);
        sendNotifyEvent(1021, String.format("网络类型发生变化，需要重新进房", new Object[0]));
        AppMethodBeat.o(15357);
        return;
      }
      if (this.mRetryCount < this.mParam.f)
      {
        this.mRetryCount += 1;
        Monitor.a(2, String.format("Network: reconnecting to upload server with quic.[addr:%s][retryCount:%d][retryLimit:%d]", new Object[] { this.mRtmpProxyParam.h, Integer.valueOf(this.mRetryCount), Integer.valueOf(this.mParam.f) }), "", 0);
        TXCEventRecorderProxy.a(this.mRtmpUrl, 91003, -1L, -1L, "reconnect rtmp-proxy server(econnect retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f + ")", 0);
        sendNotifyEvent(1102);
        startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
        AppMethodBeat.o(15357);
        return;
      }
      if (getNextRtmpProxyIP())
      {
        this.mRetryCount = 0;
        Monitor.a(2, String.format("Network: reconnecting to upload server with quic.[addr:%s][retryCount:%d][retryLimit:%d]", new Object[] { this.mRtmpProxyParam.h, Integer.valueOf(this.mRetryCount), Integer.valueOf(this.mParam.f) }), "", 0);
        sendNotifyEvent(1102);
        startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
        AppMethodBeat.o(15357);
        return;
      }
      TXCEventRecorderProxy.a(this.mRtmpUrl, 91002, -1L, -1L, "connect rtmp-proxy server failed(try all addresses)", 0);
      sendNotifyEvent(-1324);
      AppMethodBeat.o(15357);
      return;
    }
    this.mUploadQualityReport.c();
    if ((this.mEnableNearestIP) && (this.mLastNetworkType != d.e(this.mContext)))
    {
      TXCLog.e("TXCStreamUploader", "reconnect network switch from " + this.mLastNetworkType + " to " + d.e(this.mContext));
      this.mLastNetworkType = d.e(this.mContext);
      this.mIntelligentRoute.a(this.mRtmpUrl, this.mChannelType);
      this.mRetryCount = 0;
      AppMethodBeat.o(15357);
      return;
    }
    if (!this.mEnableNearestIP) {
      paramBoolean = false;
    }
    if (this.mQuicChannel == true) {
      paramBoolean = true;
    }
    if ((paramBoolean == true) && (!nextRecordIdx(true)))
    {
      TXCLog.e("TXCStreamUploader", "reconnect: try all addresses failed");
      TXCEventRecorderProxy.a(this.mRtmpUrl, 91002, -1L, -1L, "connect upload server failed(try all addresses failed)", 0);
    }
    b localb = getRtmpRealConnectInfo();
    String str2 = getAddressFromUrl(localb.a);
    StringBuilder localStringBuilder = new StringBuilder("reconnect change ip: ").append(str2).append(" enableNearestIP: ").append(this.mEnableNearestIP).append(" last channel type: ");
    if (this.mQuicChannel) {}
    for (String str1 = "Q Channel";; str1 = "TCP")
    {
      TXCLog.e("TXCStreamUploader", str1);
      if (this.mQuicChannel != true) {
        break;
      }
      TXCLog.e("TXCStreamUploader", "reconnect last channel type is Q Channel，ignore retry limit");
      Monitor.a(2, String.format("Network: reconnecting to upload server with quic.[addr:%s]", new Object[] { str2 }), "", 0);
      startPushTask(localb.a, localb.b, 0);
      sendNotifyEvent(1102);
      AppMethodBeat.o(15357);
      return;
    }
    TXCLog.e("TXCStreamUploader", "reconnect retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f);
    if (this.mRetryCount < this.mParam.f)
    {
      this.mRetryCount += 1;
      Monitor.a(2, String.format("Network: reconnecting to upload server with tcp.[addr:%s][retryCount:%d][retryLimit:%d]", new Object[] { str2, Integer.valueOf(this.mRetryCount), Integer.valueOf(this.mParam.f) }), "", 0);
      TXCEventRecorderProxy.a(this.mRtmpUrl, 91003, -1L, -1L, "reconnect upload server:(retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f + ")", 0);
      startPushTask(localb.a, localb.b, 0);
      sendNotifyEvent(1102);
      AppMethodBeat.o(15357);
      return;
    }
    TXCLog.e("TXCStreamUploader", "reconnect: try all times failed");
    TXCEventRecorderProxy.a(this.mRtmpUrl, 91002, -1L, -1L, "connect upload server failed(try all times failed)", 0);
    sendNotifyEvent(-1324);
    AppMethodBeat.o(15357);
  }
  
  private boolean isQCloudStreamUrl(String paramString)
  {
    AppMethodBeat.i(15362);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(15362);
      return false;
    }
    int i = paramString.indexOf("://");
    if (i != -1)
    {
      paramString = paramString.substring("://".length() + i);
      if ((paramString != null) && (paramString.startsWith("cloud.tencent.com")))
      {
        AppMethodBeat.o(15362);
        return true;
      }
    }
    AppMethodBeat.o(15362);
    return false;
  }
  
  private native void nativeCacheJNIParams();
  
  private native void nativeEnableDrop(long paramLong, boolean paramBoolean);
  
  private native UploadStats nativeGetStats(long paramLong);
  
  private native long nativeInitRtmpMsgRecvThreadInstance(long paramLong1, long paramLong2);
  
  private native long nativeInitRtmpProxyInstance(long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2, long paramLong4, long paramLong5, String paramString3, boolean paramBoolean, String paramString4);
  
  private native long nativeInitUploader(String paramString1, String paramString2, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean2, int paramInt8, HashMap<String, String> paramHashMap);
  
  private native void nativeOnThreadRun(long paramLong);
  
  private native void nativePushAAC(long paramLong1, byte[] paramArrayOfByte, long paramLong2);
  
  private native void nativePushNAL(long paramLong1, byte[] paramArrayOfByte, int paramInt, long paramLong2, long paramLong3, long paramLong4);
  
  private native void nativeReleaseJNIParams();
  
  private native void nativeRtmpMsgRecvThreadStart(long paramLong);
  
  private native void nativeRtmpMsgRecvThreadStop(long paramLong);
  
  private native void nativeRtmpProxyEnterRoom(long paramLong);
  
  private native void nativeRtmpProxyLeaveRoom(long paramLong);
  
  private native void nativeRtmpProxySendHeartBeat(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11);
  
  private native void nativeSendRtmpProxyMsg(long paramLong, byte[] paramArrayOfByte);
  
  private native void nativeSetSendStrategy(long paramLong, int paramInt, boolean paramBoolean);
  
  private native void nativeSetVideoDropParams(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2);
  
  private native void nativeStopPush(long paramLong);
  
  private native void nativeUninitRtmpMsgRecvThreadInstance(long paramLong);
  
  private native void nativeUninitRtmpProxyInstance(long paramLong);
  
  private native void nativeUninitUploader(long paramLong);
  
  private boolean nextRecordIdx(boolean paramBoolean)
  {
    AppMethodBeat.i(15354);
    if ((this.mIpList == null) || (this.mIpList.size() == 0))
    {
      AppMethodBeat.o(15354);
      return false;
    }
    if (paramBoolean == true)
    {
      a locala = (a)this.mIpList.get(this.mCurrentRecordIdx);
      locala.e += 1;
    }
    if (this.mCurrentRecordIdx + 1 < this.mIpList.size())
    {
      this.mCurrentRecordIdx += 1;
      AppMethodBeat.o(15354);
      return true;
    }
    AppMethodBeat.o(15354);
    return false;
  }
  
  private void onRtmpProxyRoomEvent(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15369);
    if (paramInt1 == 1)
    {
      sendNotifyEvent(1018, String.format("已在房间中，[%d]", new Object[] { Integer.valueOf(paramInt2) }));
      AppMethodBeat.o(15369);
      return;
    }
    if (paramInt1 == 2) {
      sendNotifyEvent(1019, String.format("不在房间中，[%d]", new Object[] { Integer.valueOf(paramInt2) }));
    }
    AppMethodBeat.o(15369);
  }
  
  private void onRtmpProxyUserListPushed(RtmpProxyUserInfo[] paramArrayOfRtmpProxyUserInfo)
  {
    AppMethodBeat.i(15368);
    if (paramArrayOfRtmpProxyUserInfo == null)
    {
      AppMethodBeat.o(15368);
      return;
    }
    if (!this.mIsPushing)
    {
      AppMethodBeat.o(15368);
      return;
    }
    if ((!this.mRtmpProxyEnable) || (this.mRtmpProxyParam == null))
    {
      AppMethodBeat.o(15368);
      return;
    }
    for (;;)
    {
      JSONArray localJSONArray1;
      JSONArray localJSONArray2;
      int i;
      try
      {
        localJSONArray1 = new JSONArray();
        localJSONArray2 = new JSONArray();
        i = 0;
        if (i < paramArrayOfRtmpProxyUserInfo.length)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("userid", paramArrayOfRtmpProxyUserInfo[i].account);
          localJSONObject.put("playurl", paramArrayOfRtmpProxyUserInfo[i].playUrl);
          if (paramArrayOfRtmpProxyUserInfo[i].stmType == 0) {
            localJSONArray1.put(localJSONObject);
          } else {
            localJSONArray2.put(localJSONObject);
          }
        }
      }
      catch (Exception paramArrayOfRtmpProxyUserInfo)
      {
        AppMethodBeat.o(15368);
        return;
      }
      paramArrayOfRtmpProxyUserInfo = new JSONObject();
      paramArrayOfRtmpProxyUserInfo.put("userlist", localJSONArray1);
      paramArrayOfRtmpProxyUserInfo.put("userlist_aux", localJSONArray2);
      sendNotifyEvent(1020, paramArrayOfRtmpProxyUserInfo.toString());
      AppMethodBeat.o(15368);
      return;
      i += 1;
    }
  }
  
  private void onSendRtmpProxyMsg(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(15367);
    synchronized (this.mThreadLock)
    {
      if (this.mUploaderInstance != 0L) {
        nativeSendRtmpProxyMsg(this.mUploaderInstance, paramArrayOfByte);
      }
      AppMethodBeat.o(15367);
      return;
    }
  }
  
  /* Error */
  private void parseProxyInfo(String paramString)
  {
    // Byte code:
    //   0: sipush 15363
    //   3: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnull +20 -> 27
    //   10: aload_1
    //   11: invokevirtual 426	java/lang/String:length	()I
    //   14: ifeq +13 -> 27
    //   17: aload_1
    //   18: ldc_w 651
    //   21: invokevirtual 584	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   24: ifne +10 -> 34
    //   27: sipush 15363
    //   30: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: return
    //   34: aload_0
    //   35: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   38: aload_0
    //   39: aload_1
    //   40: invokespecial 653	com/tencent/liteav/network/TXCStreamUploader:isQCloudStreamUrl	(Ljava/lang/String;)Z
    //   43: putfield 655	com/tencent/liteav/network/TXCStreamUploader$a:i	Z
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 657	com/tencent/liteav/network/TXCStreamUploader:getParamsFromUrl	(Ljava/lang/String;)Ljava/util/HashMap;
    //   51: astore 6
    //   53: aload 6
    //   55: ifnonnull +10 -> 65
    //   58: sipush 15363
    //   61: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: return
    //   65: aload 6
    //   67: ldc_w 659
    //   70: invokevirtual 663	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   73: ifeq +27 -> 100
    //   76: aload_0
    //   77: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   80: aload 6
    //   82: ldc_w 659
    //   85: invokevirtual 666	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   88: checkcast 365	java/lang/String
    //   91: invokestatic 669	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   94: invokevirtual 673	java/lang/Long:longValue	()J
    //   97: putfield 675	com/tencent/liteav/network/TXCStreamUploader$a:a	J
    //   100: aload 6
    //   102: ldc_w 677
    //   105: invokevirtual 663	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   108: ifeq +25 -> 133
    //   111: aload 6
    //   113: ldc_w 622
    //   116: invokevirtual 663	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   119: ifeq +14 -> 133
    //   122: aload 6
    //   124: ldc_w 679
    //   127: invokevirtual 663	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   130: ifne +10 -> 140
    //   133: sipush 15363
    //   136: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: return
    //   140: aload_0
    //   141: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   144: aload 6
    //   146: ldc_w 677
    //   149: invokevirtual 666	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   152: checkcast 365	java/lang/String
    //   155: invokestatic 669	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   158: invokevirtual 673	java/lang/Long:longValue	()J
    //   161: putfield 682	com/tencent/liteav/network/TXCStreamUploader$a:d	J
    //   164: aload_0
    //   165: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   168: aload 6
    //   170: ldc_w 622
    //   173: invokevirtual 666	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   176: checkcast 365	java/lang/String
    //   179: putfield 684	com/tencent/liteav/network/TXCStreamUploader$a:c	Ljava/lang/String;
    //   182: aload 6
    //   184: ldc_w 686
    //   187: invokevirtual 663	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   190: ifeq +31 -> 221
    //   193: aload 6
    //   195: ldc_w 686
    //   198: invokevirtual 666	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   201: checkcast 365	java/lang/String
    //   204: astore 7
    //   206: aload_0
    //   207: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   210: aload 7
    //   212: ldc_w 688
    //   215: invokestatic 694	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   218: putfield 696	com/tencent/liteav/network/TXCStreamUploader$a:j	Ljava/lang/String;
    //   221: new 619	org/json/JSONObject
    //   224: dup
    //   225: aload 6
    //   227: ldc_w 679
    //   230: invokevirtual 666	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   233: checkcast 365	java/lang/String
    //   236: ldc_w 688
    //   239: invokestatic 694	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   242: invokespecial 697	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   245: astore 7
    //   247: aload_0
    //   248: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   251: lconst_0
    //   252: putfield 699	com/tencent/liteav/network/TXCStreamUploader$a:b	J
    //   255: aload 7
    //   257: ldc_w 701
    //   260: invokevirtual 704	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   263: istore_3
    //   264: iload_3
    //   265: ifne +10 -> 275
    //   268: sipush 15363
    //   271: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   274: return
    //   275: aload_0
    //   276: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   279: aload 7
    //   281: ldc_w 701
    //   284: invokevirtual 707	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   287: putfield 709	com/tencent/liteav/network/TXCStreamUploader$a:e	Ljava/lang/String;
    //   290: aload 7
    //   292: ldc_w 711
    //   295: invokevirtual 715	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   298: astore 6
    //   300: aload 6
    //   302: ifnull +45 -> 347
    //   305: aload 6
    //   307: ldc_w 717
    //   310: invokevirtual 704	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   313: ifeq +27 -> 340
    //   316: aload 6
    //   318: ldc_w 719
    //   321: invokevirtual 704	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   324: ifeq +16 -> 340
    //   327: aload 6
    //   329: ldc_w 721
    //   332: invokevirtual 704	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   335: istore_3
    //   336: iload_3
    //   337: ifne +10 -> 347
    //   340: sipush 15363
    //   343: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   346: return
    //   347: aload 7
    //   349: ldc_w 723
    //   352: invokevirtual 727	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   355: astore 7
    //   357: aload 7
    //   359: ifnull +140 -> 499
    //   362: aload 7
    //   364: invokevirtual 728	org/json/JSONArray:length	()I
    //   367: ifle +132 -> 499
    //   370: iconst_0
    //   371: istore_2
    //   372: iload_2
    //   373: aload 7
    //   375: invokevirtual 728	org/json/JSONArray:length	()I
    //   378: if_icmpge +121 -> 499
    //   381: aload 7
    //   383: iload_2
    //   384: invokevirtual 732	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   387: astore 8
    //   389: aload 8
    //   391: ifnull +327 -> 718
    //   394: aload 8
    //   396: ldc_w 717
    //   399: invokevirtual 704	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   402: ifeq +316 -> 718
    //   405: aload 8
    //   407: ldc_w 719
    //   410: invokevirtual 704	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   413: ifeq +305 -> 718
    //   416: aload 8
    //   418: ldc_w 721
    //   421: invokevirtual 704	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   424: ifeq +294 -> 718
    //   427: aload 8
    //   429: ldc_w 717
    //   432: invokevirtual 707	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   435: astore 9
    //   437: aload 8
    //   439: ldc_w 719
    //   442: invokevirtual 736	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   445: lstore 4
    //   447: aload 8
    //   449: ldc_w 721
    //   452: invokevirtual 736	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   455: ldc2_w 737
    //   458: lcmp
    //   459: ifne +259 -> 718
    //   462: aload_0
    //   463: getfield 202	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyIPList	Ljava/util/Vector;
    //   466: new 403	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 448	java/lang/StringBuilder:<init>	()V
    //   473: aload 9
    //   475: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: ldc_w 452
    //   481: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: lload 4
    //   486: invokevirtual 741	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   489: invokevirtual 416	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokevirtual 744	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   495: pop
    //   496: goto +222 -> 718
    //   499: aload_0
    //   500: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   503: getfield 655	com/tencent/liteav/network/TXCStreamUploader$a:i	Z
    //   506: istore_3
    //   507: iload_3
    //   508: ifeq +184 -> 692
    //   511: aload 6
    //   513: ifnonnull +10 -> 523
    //   516: sipush 15363
    //   519: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   522: return
    //   523: aload_1
    //   524: iconst_0
    //   525: aload_1
    //   526: ldc_w 746
    //   529: invokevirtual 369	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   532: invokevirtual 378	java/lang/String:substring	(II)Ljava/lang/String;
    //   535: astore_1
    //   536: new 403	java/lang/StringBuilder
    //   539: dup
    //   540: invokespecial 448	java/lang/StringBuilder:<init>	()V
    //   543: aload_0
    //   544: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   547: getfield 675	com/tencent/liteav/network/TXCStreamUploader$a:a	J
    //   550: invokevirtual 741	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   553: ldc_w 748
    //   556: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: aload_0
    //   560: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   563: getfield 682	com/tencent/liteav/network/TXCStreamUploader$a:d	J
    //   566: invokevirtual 741	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   569: ldc_w 748
    //   572: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: aload_0
    //   576: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   579: getfield 684	com/tencent/liteav/network/TXCStreamUploader$a:c	Ljava/lang/String;
    //   582: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: invokevirtual 416	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: astore 7
    //   590: aload_0
    //   591: new 403	java/lang/StringBuilder
    //   594: dup
    //   595: invokespecial 448	java/lang/StringBuilder:<init>	()V
    //   598: aload_1
    //   599: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: ldc_w 750
    //   605: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: aload 7
    //   610: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: ldc_w 752
    //   616: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: aload 6
    //   621: ldc_w 717
    //   624: invokevirtual 707	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   627: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: ldc_w 754
    //   633: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: aload 6
    //   638: ldc_w 719
    //   641: invokevirtual 736	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   644: invokevirtual 741	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   647: ldc_w 756
    //   650: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: aload_0
    //   654: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   657: getfield 699	com/tencent/liteav/network/TXCStreamUploader$a:b	J
    //   660: invokevirtual 741	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   663: ldc_w 758
    //   666: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: invokevirtual 416	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   672: putfield 136	com/tencent/liteav/network/TXCStreamUploader:mRtmpUrl	Ljava/lang/String;
    //   675: aload_0
    //   676: invokespecial 529	com/tencent/liteav/network/TXCStreamUploader:getNextRtmpProxyIP	()Z
    //   679: pop
    //   680: aload_0
    //   681: iconst_1
    //   682: putfield 193	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyEnable	Z
    //   685: sipush 15363
    //   688: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   691: return
    //   692: aload_0
    //   693: aload_1
    //   694: putfield 136	com/tencent/liteav/network/TXCStreamUploader:mRtmpUrl	Ljava/lang/String;
    //   697: aload_0
    //   698: iconst_0
    //   699: putfield 138	com/tencent/liteav/network/TXCStreamUploader:mQuicChannel	Z
    //   702: goto -22 -> 680
    //   705: astore_1
    //   706: sipush 15363
    //   709: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   712: return
    //   713: astore 7
    //   715: goto -494 -> 221
    //   718: iload_2
    //   719: iconst_1
    //   720: iadd
    //   721: istore_2
    //   722: goto -350 -> 372
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	725	0	this	TXCStreamUploader
    //   0	725	1	paramString	String
    //   371	351	2	i	int
    //   263	245	3	bool	boolean
    //   445	40	4	l	long
    //   51	586	6	localObject1	Object
    //   204	405	7	localObject2	Object
    //   713	1	7	localException	Exception
    //   387	61	8	localJSONObject	JSONObject
    //   435	39	9	str	String
    // Exception table:
    //   from	to	target	type
    //   221	264	705	java/lang/Exception
    //   275	300	705	java/lang/Exception
    //   305	336	705	java/lang/Exception
    //   347	357	705	java/lang/Exception
    //   362	370	705	java/lang/Exception
    //   372	389	705	java/lang/Exception
    //   394	496	705	java/lang/Exception
    //   499	507	705	java/lang/Exception
    //   523	680	705	java/lang/Exception
    //   680	685	705	java/lang/Exception
    //   692	702	705	java/lang/Exception
    //   193	221	713	java/lang/Exception
  }
  
  private void postReconnectMsg(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(15338);
    Message localMessage = new Message();
    localMessage.what = 101;
    localMessage.obj = paramString;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localMessage.arg1 = i;
      if (this.mHandler != null) {
        this.mHandler.sendMessageDelayed(localMessage, paramInt);
      }
      AppMethodBeat.o(15338);
      return;
    }
  }
  
  private void reconnect(final boolean paramBoolean)
  {
    AppMethodBeat.i(15356);
    stopPushTask();
    if (this.mHandler != null) {
      this.mHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15335);
          TXCStreamUploader.access$3000(TXCStreamUploader.this, paramBoolean);
          AppMethodBeat.o(15335);
        }
      }, this.mParam.g * 1000);
    }
    AppMethodBeat.o(15356);
  }
  
  private void reportNetStatus()
  {
    AppMethodBeat.i(15360);
    long l6 = TXCTimeUtil.getTimeTick();
    long l5 = l6 - this.mLastTimeStamp;
    UploadStats localUploadStats = getUploadStats();
    long l3 = 0L;
    long l2 = 0L;
    long l1 = 0L;
    long l4;
    if (localUploadStats != null)
    {
      if (this.mLastUploadStats == null) {
        break label513;
      }
      l4 = getSpeed(this.mLastUploadStats.inVideoBytes, localUploadStats.inVideoBytes, l5).longValue();
      l3 = getSpeed(this.mLastUploadStats.inAudioBytes, localUploadStats.inAudioBytes, l5).longValue();
      l2 = getSpeed(this.mLastUploadStats.outVideoBytes, localUploadStats.outVideoBytes, l5).longValue();
      l1 = getSpeed(this.mLastUploadStats.outAudioBytes, localUploadStats.outAudioBytes, l5).longValue();
    }
    for (;;)
    {
      setStatusValue(7005, Long.valueOf(localUploadStats.videoCacheLen));
      setStatusValue(7006, Long.valueOf(localUploadStats.audioCacheLen));
      setStatusValue(7007, Long.valueOf(localUploadStats.videoDropCount));
      setStatusValue(7008, Long.valueOf(localUploadStats.audioDropCount));
      setStatusValue(7021, Long.valueOf(localUploadStats.bandwidthEst));
      setStatusValue(7009, Long.valueOf(localUploadStats.startTS));
      setStatusValue(7010, Long.valueOf(localUploadStats.dnsTS));
      setStatusValue(7011, Long.valueOf(localUploadStats.connTS));
      setStatusValue(7012, String.valueOf(localUploadStats.serverIP));
      if (this.mQuicChannel)
      {
        l5 = 2L;
        setStatusValue(7013, Long.valueOf(l5));
        setStatusValue(7014, localUploadStats.connectionID);
        setStatusValue(7015, localUploadStats.connectionStats);
        this.mUploadQualityReport.a(localUploadStats.videoDropCount, localUploadStats.audioDropCount);
        this.mUploadQualityReport.b(localUploadStats.videoCacheLen, localUploadStats.audioCacheLen);
      }
      for (;;)
      {
        setStatusValue(7001, Long.valueOf(l4));
        setStatusValue(7002, Long.valueOf(l3));
        setStatusValue(7003, Long.valueOf(l2));
        setStatusValue(7004, Long.valueOf(l1));
        this.mLastTimeStamp = l6;
        this.mLastUploadStats = localUploadStats;
        if (this.mHandler != null) {
          this.mHandler.sendEmptyMessageDelayed(103, 2000L);
        }
        AppMethodBeat.o(15360);
        return;
        l5 = 1L;
        break;
        setStatusValue(7005, Long.valueOf(0L));
        setStatusValue(7006, Long.valueOf(0L));
        setStatusValue(7007, Long.valueOf(0L));
        setStatusValue(7008, Long.valueOf(0L));
        l4 = 0L;
      }
      label513:
      l4 = 0L;
    }
  }
  
  private void rtmpProxySendHeartBeat()
  {
    AppMethodBeat.i(15366);
    ??? = d.a();
    long l1 = ???[0] / 10;
    long l2 = ???[1] / 10;
    long l3 = TXCStatus.c(getID(), 7004);
    long l4 = TXCStatus.c(getID(), 7003);
    long l5 = TXCStatus.c(getID(), 1001);
    long l6 = TXCStatus.c(getID(), 4001);
    long l7 = TXCStatus.c(getID(), 7006);
    long l8 = TXCStatus.c(getID(), 7005);
    long l9 = TXCStatus.c(getID(), 7008);
    long l10 = TXCStatus.c(getID(), 7007);
    synchronized (this.mRtmpProxyLock)
    {
      nativeRtmpProxySendHeartBeat(this.mRtmpProxyInstance, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10);
      AppMethodBeat.o(15366);
      return;
    }
  }
  
  private void sendNotifyEvent(int paramInt)
  {
    AppMethodBeat.i(15359);
    if (paramInt == 0)
    {
      reconnect(false);
      AppMethodBeat.o(15359);
      return;
    }
    if (paramInt == 1)
    {
      reconnect(true);
      AppMethodBeat.o(15359);
      return;
    }
    if (paramInt == 1001) {
      this.mConnectSuccessTimeStamps = TXCTimeUtil.getTimeTick();
    }
    if (paramInt == 1026)
    {
      if (this.mRtmpProxyEnable) {
        synchronized (this.mRtmpMsgRecvThreadLock)
        {
          nativeRtmpMsgRecvThreadStart(this.mRtmpMsgRecvThreadInstance);
        }
      }
      synchronized (this.mRtmpProxyLock)
      {
        nativeRtmpProxyEnterRoom(this.mRtmpProxyInstance);
        if (this.mHandler != null) {
          this.mHandler.sendEmptyMessageDelayed(104, 2000L);
        }
        AppMethodBeat.o(15359);
        return;
        localObject2 = finally;
        AppMethodBeat.o(15359);
        throw localObject2;
      }
    }
    if (this.mNotifyListener != null)
    {
      ??? = new Bundle();
      switch (paramInt)
      {
      default: 
        ((Bundle)???).putString("EVT_MSG", "UNKNOWN");
      }
    }
    for (;;)
    {
      ((Bundle)???).putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      d.a(this.mNotifyListener, paramInt, (Bundle)???);
      AppMethodBeat.o(15359);
      return;
      ((Bundle)???).putString("EVT_MSG", "所有IP都已经尝试失败,可以放弃治疗");
      continue;
      ((Bundle)???).putString("EVT_MSG", "经连续多次重连失败，放弃重连");
      continue;
      ((Bundle)???).putString("EVT_MSG", "超过30s没有数据发送，主动断开连接");
      continue;
      ((Bundle)???).putString("EVT_MSG", "没有网络，请检测WiFi或移动数据是否开启");
      continue;
      ((Bundle)???).putString("EVT_MSG", "连接服务器失败");
      continue;
      ((Bundle)???).putString("EVT_MSG", "已经连接rtmp服务器");
      continue;
      ((Bundle)???).putString("EVT_MSG", "RTMP服务器握手失败");
      continue;
      ((Bundle)???).putString("EVT_MSG", "上行带宽不足，数据发送不及时");
      continue;
      ((Bundle)???).putString("EVT_MSG", "rtmp开始推流");
      continue;
      ((Bundle)???).putString("EVT_MSG", "服务器拒绝连接请求，可能是该推流地址已经被占用或过期，或者防盗链错误");
      continue;
      if (this.mRtmpProxyEnable) {
        synchronized (this.mRtmpMsgRecvThreadLock)
        {
          nativeRtmpMsgRecvThreadStart(this.mRtmpMsgRecvThreadInstance);
        }
      }
      synchronized (this.mRtmpProxyLock)
      {
        nativeRtmpProxyEnterRoom(this.mRtmpProxyInstance);
        if (this.mHandler != null) {
          this.mHandler.sendEmptyMessageDelayed(104, 2000L);
        }
        AppMethodBeat.o(15359);
        return;
        localObject4 = finally;
        AppMethodBeat.o(15359);
        throw localObject4;
      }
      ((Bundle)???).putString("EVT_MSG", "启动网络重连");
    }
  }
  
  private void sendNotifyEvent(int paramInt, String paramString)
  {
    AppMethodBeat.i(15358);
    if ((paramString == null) || (paramString.isEmpty())) {
      sendNotifyEvent(paramInt);
    }
    while (paramInt == 1002)
    {
      paramString = getUploadStats();
      if (paramString != null) {
        this.mUploadQualityReport.a(paramString.dnsparseTimeCost, paramString.connectTimeCost, paramString.handshakeTimeCost);
      }
      AppMethodBeat.o(15358);
      return;
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_MSG", paramString);
      localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      d.a(this.mNotifyListener, paramInt, localBundle);
    }
    if (paramInt == 1101) {
      this.mUploadQualityReport.d();
    }
    AppMethodBeat.o(15358);
  }
  
  private void startPushTask(final String paramString, final boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(15351);
    TXCLog.i("TXCStreamUploader", "start push task");
    if ((this.mQuicChannel != paramBoolean) && (this.mQuicChannel == true)) {
      Monitor.a(2, String.format("Network: switch push channel from quic to tcp.[retryCount:%d][retryLimit:%d]", new Object[] { Integer.valueOf(this.mRetryCount), Integer.valueOf(this.mParam.f) }), "", 0);
    }
    if (paramBoolean)
    {
      paramInt = this.mConnectCountQuic + 1;
      this.mConnectCountQuic = paramInt;
      setStatusValue(7017, Long.valueOf(paramInt));
    }
    for (;;)
    {
      this.mThread = new Thread("RTMPUpload")
      {
        public void run()
        {
          AppMethodBeat.i(15489);
          while (TXCStreamUploader.this.mUploaderInstance != 0L) {
            try
            {
              sleep(100L, 0);
            }
            catch (InterruptedException localInterruptedException) {}
          }
          TXCStreamUploader.this.mUploadQualityReport.b();
          TXCStreamUploader.this.mUploadQualityReport.a(TXCStreamUploader.this.mParam.m);
          TXCStreamUploader.this.mUploadQualityReport.a(TXCStreamUploader.this.mRtmpUrl);
          TXCStreamUploader.this.mUploadQualityReport.a(paramBoolean, TXCStreamUploader.access$800(TXCStreamUploader.this, paramString));
          for (;;)
          {
            synchronized (TXCStreamUploader.this.mThreadLock)
            {
              TXCStreamUploader.access$1002(TXCStreamUploader.this, paramBoolean);
              if (!TXCStreamUploader.this.mParam.m) {
                break label929;
              }
              if (!TXCStreamUploader.this.mQuicChannel) {
                break label924;
              }
              i = 3;
              if (!TXCStreamUploader.this.mRtmpProxyEnable)
              {
                if (TXCStreamUploader.this.mIpList == null) {
                  break label916;
                }
                j = i;
                if (TXCStreamUploader.this.mIpList.size() == 0) {
                  break label916;
                }
                TXCStreamUploader.this.setStatusValue(7020, Long.valueOf(j));
                TXCStreamUploader.access$402(TXCStreamUploader.this, TXCStreamUploader.access$1400(TXCStreamUploader.this, TXCStreamUploader.this.mRtmpUrl, paramString, paramBoolean, TXCStreamUploader.this.mParam.e, TXCStreamUploader.this.mParam.d, TXCStreamUploader.this.mParam.a, TXCStreamUploader.this.mParam.c, TXCStreamUploader.this.mParam.h, 16, j, TXCStreamUploader.this.mParam.n, TXCStreamUploader.this.mParam.o, TXCStreamUploader.this.mMetaData));
                if (TXCStreamUploader.this.mUploaderInstance == 0L) {
                  break label518;
                }
                TXCStreamUploader.access$1500(TXCStreamUploader.this, TXCStreamUploader.this.mUploaderInstance, TXCStreamUploader.this.mParam.j, TXCStreamUploader.this.mParam.h, TXCStreamUploader.this.mParam.i);
                i = 0;
                Iterator localIterator = TXCStreamUploader.this.mVecPendingNAL.iterator();
                if (localIterator.hasNext())
                {
                  TXSNALPacket localTXSNALPacket = (TXSNALPacket)localIterator.next();
                  if ((i != 0) || (localTXSNALPacket.nalType != 0)) {
                    break label913;
                  }
                  i = 1;
                  if (i == 0) {
                    break label921;
                  }
                  TXCStreamUploader.access$1700(TXCStreamUploader.this, TXCStreamUploader.this.mUploaderInstance, localTXSNALPacket.nalData, localTXSNALPacket.nalType, localTXSNALPacket.frameIndex, localTXSNALPacket.pts, localTXSNALPacket.dts);
                  break label921;
                }
              }
              else
              {
                j = i;
                if (!TXCStreamUploader.this.mAudioMuted) {
                  continue;
                }
                TXCStreamUploader.this.mParam.n = false;
                j = i;
              }
            }
            TXCStreamUploader.this.mVecPendingNAL.removeAllElements();
            label518:
            if (TXCStreamUploader.this.mRtmpProxyEnable) {}
            synchronized (TXCStreamUploader.this.mRtmpProxyLock)
            {
              TXCStreamUploader.access$1902(TXCStreamUploader.this, TXCStreamUploader.access$2100(TXCStreamUploader.this, TXCStreamUploader.this.mRtmpProxyParam.a, TXCStreamUploader.this.mRtmpProxyParam.b, TXCStreamUploader.this.mRtmpProxyParam.c, TXCStreamUploader.this.mRtmpProxyParam.d, TXCStreamUploader.this.mRtmpProxyParam.e, TXCStreamUploader.this.mRtmpProxyParam.f, TXCStreamUploader.this.mRtmpProxyParam.g, TXCStreamUploader.this.mRtmpProxyParam.h, TXCStreamUploader.this.mRtmpProxyParam.i, TXCStreamUploader.this.mRtmpProxyParam.j));
              synchronized (TXCStreamUploader.this.mRtmpMsgRecvThreadLock)
              {
                TXCStreamUploader.access$2302(TXCStreamUploader.this, TXCStreamUploader.access$2400(TXCStreamUploader.this, TXCStreamUploader.this.mRtmpProxyInstance, TXCStreamUploader.this.mUploaderInstance));
                TXCStreamUploader.access$2500(TXCStreamUploader.this, TXCStreamUploader.this.mUploaderInstance);
                if (TXCStreamUploader.this.mRtmpProxyEnable) {
                  synchronized (TXCStreamUploader.this.mRtmpMsgRecvThreadLock)
                  {
                    TXCStreamUploader.access$2600(TXCStreamUploader.this, TXCStreamUploader.this.mRtmpMsgRecvThreadInstance);
                    TXCStreamUploader.access$2700(TXCStreamUploader.this, TXCStreamUploader.this.mRtmpMsgRecvThreadInstance);
                    TXCStreamUploader.access$2302(TXCStreamUploader.this, 0L);
                    synchronized (TXCStreamUploader.this.mRtmpProxyLock)
                    {
                      TXCStreamUploader.access$2800(TXCStreamUploader.this, TXCStreamUploader.this.mRtmpProxyInstance);
                      TXCStreamUploader.access$1902(TXCStreamUploader.this, 0L);
                    }
                  }
                }
              }
            }
            synchronized (TXCStreamUploader.this.mThreadLock)
            {
              TXCStreamUploader.access$2900(TXCStreamUploader.this, TXCStreamUploader.this.mUploaderInstance);
              TXCStreamUploader.access$402(TXCStreamUploader.this, 0L);
              AppMethodBeat.o(15489);
              return;
              localObject3 = finally;
              AppMethodBeat.o(15489);
              throw localObject3;
              localObject4 = finally;
              AppMethodBeat.o(15489);
              throw localObject4;
              localObject5 = finally;
              AppMethodBeat.o(15489);
              throw localObject5;
              localObject6 = finally;
              AppMethodBeat.o(15489);
              throw localObject6;
            }
            label913:
            continue;
            label916:
            int j = 1;
            continue;
            label921:
            continue;
            label924:
            int i = 2;
            continue;
            label929:
            i = 1;
          }
        }
      };
      this.mThread.start();
      AppMethodBeat.o(15351);
      return;
      paramInt = this.mConnectCountTcp + 1;
      this.mConnectCountTcp = paramInt;
      setStatusValue(7018, Long.valueOf(paramInt));
    }
  }
  
  private void stopPushTask()
  {
    AppMethodBeat.i(15352);
    TXCLog.i("TXCStreamUploader", "stop push task");
    synchronized (this.mThreadLock)
    {
      this.mVecPendingNAL.removeAllElements();
      nativeStopPush(this.mUploaderInstance);
      AppMethodBeat.o(15352);
      return;
    }
  }
  
  private void tryResetRetryCount()
  {
    AppMethodBeat.i(15343);
    if ((this.mConnectSuccessTimeStamps != 0L) && (TXCTimeUtil.getTimeTick() - this.mConnectSuccessTimeStamps > this.mParam.f * (this.mParam.g + 13) * 1000))
    {
      this.mRetryCount = 0;
      this.mConnectSuccessTimeStamps = 0L;
      TXCLog.i("TXCStreamUploader", "reset retry count");
    }
    AppMethodBeat.o(15343);
  }
  
  public String getConfusionIP(String paramString)
  {
    AppMethodBeat.i(15340);
    if (paramString != null)
    {
      int i = paramString.indexOf(".");
      if (i != -1)
      {
        String str = paramString.substring(i + 1);
        i = str.indexOf(".");
        if (i != -1)
        {
          paramString = "A.B.".concat(String.valueOf(str.substring(i + 1)));
          AppMethodBeat.o(15340);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(15340);
    return paramString;
  }
  
  public UploadStats getUploadStats()
  {
    AppMethodBeat.i(15350);
    synchronized (this.mThreadLock)
    {
      UploadStats localUploadStats = nativeGetStats(this.mUploaderInstance);
      if (localUploadStats != null)
      {
        if (this.mQuicChannel == true)
        {
          l = 2L;
          localUploadStats.channelType = l;
        }
      }
      else
      {
        AppMethodBeat.o(15350);
        return localUploadStats;
      }
      long l = 1L;
    }
  }
  
  public int init()
  {
    return 0;
  }
  
  public void onFetchDone(int paramInt, ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(15339);
    if (!this.mIsPushing)
    {
      AppMethodBeat.o(15339);
      return;
    }
    if (paramArrayList != null)
    {
      TXCLog.e("TXCStreamUploader", "onFetchDone: code = " + paramInt + " ip count = " + paramArrayList.size());
      if (paramInt == 0)
      {
        this.mIpList = paramArrayList;
        paramInt = paramArrayList.size();
        this.mCurrentRecordIdx = 0;
      }
    }
    for (;;)
    {
      int i;
      if (paramInt > 0)
      {
        paramArrayList = "";
        Iterator localIterator = this.mIpList.iterator();
        paramInt = 0;
        if (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          i = paramInt;
          if (locala != null)
          {
            i = paramInt;
            if (locala.c)
            {
              i = paramInt;
              if (locala.a != null)
              {
                i = paramInt;
                if (locala.a.length() > 0) {
                  i = paramInt + 1;
                }
              }
            }
          }
          if (locala == null) {
            break label288;
          }
          paramArrayList = paramArrayList + " " + getConfusionIP(locala.a) + ":" + locala.b;
        }
      }
      label288:
      for (;;)
      {
        paramInt = i;
        break;
        setStatusValue(7016, Long.valueOf(paramInt));
        setStatusValue(7019, "{" + paramArrayList + " }");
        paramArrayList = getRtmpRealConnectInfo();
        postReconnectMsg(paramArrayList.a, paramArrayList.b, 0);
        AppMethodBeat.o(15339);
        return;
      }
      paramInt = 0;
    }
  }
  
  public void pushAAC(byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(15344);
    tryResetRetryCount();
    synchronized (this.mThreadLock)
    {
      if ((!this.mAudioMuted) || (!this.mRtmpProxyEnable)) {
        nativePushAAC(this.mUploaderInstance, paramArrayOfByte, paramLong);
      }
      AppMethodBeat.o(15344);
      return;
    }
  }
  
  public void pushNAL(TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(15345);
    tryResetRetryCount();
    synchronized (this.mThreadLock)
    {
      if (this.mUploaderInstance != 0L)
      {
        if ((paramTXSNALPacket != null) && (paramTXSNALPacket.nalData != null) && (paramTXSNALPacket.nalData.length > 0)) {
          nativePushNAL(this.mUploaderInstance, paramTXSNALPacket.nalData, paramTXSNALPacket.nalType, paramTXSNALPacket.frameIndex, paramTXSNALPacket.pts, paramTXSNALPacket.dts);
        }
        AppMethodBeat.o(15345);
        return;
      }
      if (paramTXSNALPacket.nalType == 0) {
        this.mVecPendingNAL.removeAllElements();
      }
      this.mVecPendingNAL.add(paramTXSNALPacket);
    }
  }
  
  public void setAudioInfo(int paramInt1, int paramInt2)
  {
    if (this.mParam != null)
    {
      this.mParam.d = paramInt2;
      this.mParam.e = paramInt1;
    }
  }
  
  public void setAudioMute(boolean paramBoolean)
  {
    AppMethodBeat.i(15346);
    synchronized (this.mThreadLock)
    {
      this.mAudioMuted = paramBoolean;
      if ((this.mRtmpProxyEnable) && (this.mUploaderInstance != 0L))
      {
        if (!this.mParam.m) {
          break label77;
        }
        if (!this.mQuicChannel) {
          break label72;
        }
      }
      label72:
      for (int i = 3;; i = 2)
      {
        nativeSetSendStrategy(this.mUploaderInstance, i, false);
        AppMethodBeat.o(15346);
        return;
      }
      label77:
      i = 1;
    }
  }
  
  public void setDropEanble(boolean paramBoolean)
  {
    AppMethodBeat.i(15347);
    StringBuilder localStringBuilder = new StringBuilder("drop enable ");
    if (paramBoolean) {
      ??? = "yes";
    }
    for (;;)
    {
      TXCLog.i("TXCStreamUploader", (String)???);
      synchronized (this.mThreadLock)
      {
        nativeEnableDrop(this.mUploaderInstance, paramBoolean);
        AppMethodBeat.o(15347);
        return;
        ??? = "no";
      }
    }
  }
  
  public void setMetaData(HashMap<String, String> paramHashMap)
  {
    this.mMetaData = paramHashMap;
  }
  
  public void setMode(int paramInt)
  {
    if (this.mParam != null) {
      this.mParam.a = paramInt;
    }
  }
  
  public void setNotifyListener(com.tencent.liteav.basic.c.a parama)
  {
    AppMethodBeat.i(15336);
    this.mNotifyListener = new WeakReference(parama);
    AppMethodBeat.o(15336);
  }
  
  public void setRetryInterval(int paramInt)
  {
    if (this.mParam != null) {
      this.mParam.g = paramInt;
    }
  }
  
  public void setRetryTimes(int paramInt)
  {
    if (this.mParam != null) {
      this.mParam.f = paramInt;
    }
  }
  
  public void setSendStrategy(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(15349);
    this.mParam.m = paramBoolean1;
    this.mParam.n = paramBoolean2;
    this.mUploadQualityReport.a(paramBoolean1);
    int i;
    if (paramBoolean1) {
      if (this.mQuicChannel) {
        i = 3;
      }
    }
    for (;;)
    {
      int j = i;
      if (!this.mRtmpProxyEnable) {
        if (this.mIpList != null)
        {
          j = i;
          if (this.mIpList.size() != 0) {}
        }
        else
        {
          j = 1;
        }
      }
      synchronized (this.mThreadLock)
      {
        if (this.mUploaderInstance != 0L) {
          nativeSetSendStrategy(this.mUploaderInstance, j, paramBoolean2);
        }
        setStatusValue(7020, Long.valueOf(j));
        AppMethodBeat.o(15349);
        return;
        i = 2;
        continue;
        i = 1;
      }
    }
  }
  
  public void setVideoDropParams(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15348);
    StringBuilder localStringBuilder = new StringBuilder("drop params wait i frame:");
    if (paramBoolean) {
      ??? = "yes";
    }
    for (;;)
    {
      TXCLog.i("TXCStreamUploader", (String)??? + " max video count:" + paramInt1 + " max video cache time: " + paramInt2 + " ms");
      synchronized (this.mThreadLock)
      {
        this.mParam.j = paramBoolean;
        this.mParam.h = paramInt1;
        this.mParam.i = paramInt2;
        if (this.mUploaderInstance != 0L) {
          nativeSetVideoDropParams(this.mUploaderInstance, this.mParam.j, this.mParam.h, this.mParam.i);
        }
        AppMethodBeat.o(15348);
        return;
        ??? = "no";
      }
    }
  }
  
  public String start(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(15341);
    if (this.mIsPushing == true)
    {
      paramString = this.mRtmpUrl;
      AppMethodBeat.o(15341);
      return paramString;
    }
    this.mIsPushing = true;
    this.mConnectSuccessTimeStamps = 0L;
    this.mRetryCount = 0;
    this.mRtmpUrl = paramString;
    this.mChannelType = paramInt;
    this.mConnectCountQuic = 0;
    this.mConnectCountTcp = 0;
    this.mRtmpProxyEnable = false;
    this.mRtmpProxyParam.a();
    this.mRtmpProxyIPList.clear();
    this.mRtmpProxyIPIndex = 0;
    this.mRtmpProxyInstance = 0L;
    this.mRtmpMsgRecvThreadInstance = 0L;
    setStatusValue(7016, Long.valueOf(0L));
    setStatusValue(7017, Long.valueOf(0L));
    setStatusValue(7018, Long.valueOf(0L));
    this.mUploadQualityReport.a();
    StringBuilder localStringBuilder = new StringBuilder("start push with url:").append(this.mRtmpUrl).append(" enable nearest ip:");
    if (paramBoolean) {}
    for (String str = "yes";; str = "no")
    {
      TXCLog.i("TXCStreamUploader", str + "channel type:" + paramInt);
      if (d.e(this.mContext) != 0) {
        break;
      }
      sendNotifyEvent(-1325);
      paramString = this.mRtmpUrl;
      AppMethodBeat.o(15341);
      return paramString;
    }
    this.mEnableNearestIP = paramBoolean;
    if (this.mHandlerThread == null)
    {
      this.mHandlerThread = new HandlerThread("RTMP_PUSH");
      this.mHandlerThread.start();
    }
    this.mHandler = new Handler(this.mHandlerThread.getLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(15408);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(15408);
          return;
          TXCStreamUploader localTXCStreamUploader = TXCStreamUploader.this;
          String str = (String)paramAnonymousMessage.obj;
          if (paramAnonymousMessage.arg1 == 2) {}
          for (boolean bool = true;; bool = false)
          {
            TXCStreamUploader.access$000(localTXCStreamUploader, str, bool, 0);
            AppMethodBeat.o(15408);
            return;
          }
          TXCStreamUploader.access$100(TXCStreamUploader.this);
          AppMethodBeat.o(15408);
          return;
          TXCStreamUploader.access$200(TXCStreamUploader.this);
          if (TXCStreamUploader.this.mHandler != null) {
            TXCStreamUploader.this.mHandler.sendEmptyMessageDelayed(104, 2000L);
          }
        }
      }
    };
    parseProxyInfo(paramString);
    if (this.mRtmpProxyEnable)
    {
      this.mLastNetworkType = d.e(this.mContext);
      nativeCacheJNIParams();
      startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
    }
    for (;;)
    {
      this.mHandler.sendEmptyMessageDelayed(103, 2000L);
      paramString = this.mRtmpUrl;
      AppMethodBeat.o(15341);
      return paramString;
      if ((!this.mEnableNearestIP) || (this.mLastNetworkType == d.e(this.mContext))) {
        break;
      }
      TXCLog.i("TXCStreamUploader", "fetching nearest ip list");
      this.mLastNetworkType = d.e(this.mContext);
      this.mIntelligentRoute.a(paramString, paramInt);
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(15342);
    if (!this.mIsPushing)
    {
      AppMethodBeat.o(15342);
      return;
    }
    this.mIsPushing = false;
    TXCLog.i("TXCStreamUploader", "stop push");
    if (this.mRtmpProxyEnable) {
      synchronized (this.mRtmpProxyLock)
      {
        nativeRtmpProxyLeaveRoom(this.mRtmpProxyInstance);
      }
    }
    synchronized (this.mThreadLock)
    {
      nativeStopPush(this.mUploaderInstance);
      if (this.mHandlerThread != null)
      {
        this.mHandlerThread.getLooper().quit();
        this.mHandlerThread = null;
      }
      if (this.mHandler != null) {
        this.mHandler = null;
      }
      if (this.mRtmpProxyEnable) {
        nativeReleaseJNIParams();
      }
      this.mUploadQualityReport.c();
      this.mUploadQualityReport.a();
      AppMethodBeat.o(15342);
      return;
      localObject2 = finally;
      AppMethodBeat.o(15342);
      throw localObject2;
    }
  }
  
  public class RtmpProxyUserInfo
  {
    public String account = "";
    public String playUrl = "";
    public int stmType = 0;
    
    public RtmpProxyUserInfo() {}
  }
  
  public class UploadStats
  {
    public long audioCacheLen;
    public long audioDropCount;
    public long bandwidthEst;
    public long channelType;
    public long connTS;
    public long connectTimeCost;
    public String connectionID;
    public String connectionStats;
    public long dnsTS;
    public long dnsparseTimeCost;
    public long handshakeTimeCost;
    public long inAudioBytes;
    public long inVideoBytes;
    public long outAudioBytes;
    public long outVideoBytes;
    public String serverIP;
    public long startTS;
    public long videoCacheLen;
    public long videoDropCount;
    
    public UploadStats() {}
  }
  
  public class a
  {
    public long a;
    public long b;
    public String c;
    public long d;
    public String e;
    public long f;
    public long g;
    public String h;
    public boolean i;
    public String j;
    
    public a() {}
    
    public void a()
    {
      this.a = 0L;
      this.b = 0L;
      this.c = "";
      this.d = 0L;
      this.e = "";
      this.f = 0L;
      this.g = 0L;
      this.i = false;
      this.j = "";
    }
  }
  
  class b
  {
    public String a = "";
    public boolean b = false;
    
    public b(String paramString, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.network.TXCStreamUploader
 * JD-Core Version:    0.7.0.1
 */
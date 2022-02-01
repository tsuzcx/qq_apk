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
  private WeakReference<com.tencent.liteav.basic.c.b> mNotifyListener;
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
    com.tencent.liteav.basic.util.h.f();
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
    if ((((a)localObject).a.split(":").length > 1) && (!((a)localObject).a.startsWith("["))) {
      arrayOfString2[0] = ("[" + ((a)localObject).a + "]:" + ((a)localObject).b);
    }
    StringBuilder localStringBuilder;
    for (;;)
    {
      localStringBuilder = new StringBuilder(arrayOfString2[0]);
      while (i < arrayOfString2.length)
      {
        localStringBuilder.append("/");
        localStringBuilder.append(arrayOfString2[i]);
        i += 1;
      }
      arrayOfString2[0] = (((a)localObject).a + ":" + ((a)localObject).b);
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
      if (this.mLastNetworkType != com.tencent.liteav.basic.util.h.e(this.mContext))
      {
        TXCLog.e("TXCStreamUploader", "reconnect network switch from " + this.mLastNetworkType + " to " + com.tencent.liteav.basic.util.h.e(this.mContext));
        this.mLastNetworkType = com.tencent.liteav.basic.util.h.e(this.mContext);
        this.mRetryCount = 0;
        Monitor.a(2, "WebrtcRoom: need enter again by user", "", 0);
        sendNotifyEvent(1021, String.format("Network type has changed. Need to re-enter the room", new Object[0]));
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
    if ((this.mEnableNearestIP) && (this.mLastNetworkType != com.tencent.liteav.basic.util.h.e(this.mContext)))
    {
      TXCLog.e("TXCStreamUploader", "reconnect network switch from " + this.mLastNetworkType + " to " + com.tencent.liteav.basic.util.h.e(this.mContext));
      this.mLastNetworkType = com.tencent.liteav.basic.util.h.e(this.mContext);
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
      sendNotifyEvent(1018, String.format("Already in room，[%d]", new Object[] { Integer.valueOf(paramInt2) }));
      AppMethodBeat.o(15369);
      return;
    }
    if (paramInt1 == 2) {
      sendNotifyEvent(1019, String.format("Not in the room，[%d]", new Object[] { Integer.valueOf(paramInt2) }));
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
        TXCLog.e("TXCStreamUploader", "build json object failed.", paramArrayOfRtmpProxyUserInfo);
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
    //   18: ldc_w 660
    //   21: invokevirtual 457	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   24: ifne +10 -> 34
    //   27: sipush 15363
    //   30: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: return
    //   34: aload_0
    //   35: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   38: aload_0
    //   39: aload_1
    //   40: invokespecial 662	com/tencent/liteav/network/TXCStreamUploader:isQCloudStreamUrl	(Ljava/lang/String;)Z
    //   43: putfield 664	com/tencent/liteav/network/TXCStreamUploader$a:i	Z
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 666	com/tencent/liteav/network/TXCStreamUploader:getParamsFromUrl	(Ljava/lang/String;)Ljava/util/HashMap;
    //   51: astore 6
    //   53: aload 6
    //   55: ifnonnull +10 -> 65
    //   58: sipush 15363
    //   61: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: return
    //   65: aload 6
    //   67: ldc_w 668
    //   70: invokevirtual 672	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   73: ifeq +27 -> 100
    //   76: aload_0
    //   77: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   80: aload 6
    //   82: ldc_w 668
    //   85: invokevirtual 675	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   88: checkcast 365	java/lang/String
    //   91: invokestatic 678	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   94: invokevirtual 682	java/lang/Long:longValue	()J
    //   97: putfield 684	com/tencent/liteav/network/TXCStreamUploader$a:a	J
    //   100: aload 6
    //   102: ldc_w 686
    //   105: invokevirtual 672	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   108: ifeq +25 -> 133
    //   111: aload 6
    //   113: ldc_w 626
    //   116: invokevirtual 672	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   119: ifeq +14 -> 133
    //   122: aload 6
    //   124: ldc_w 688
    //   127: invokevirtual 672	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   130: ifne +10 -> 140
    //   133: sipush 15363
    //   136: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: return
    //   140: aload_0
    //   141: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   144: aload 6
    //   146: ldc_w 686
    //   149: invokevirtual 675	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   152: checkcast 365	java/lang/String
    //   155: invokestatic 678	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   158: invokevirtual 682	java/lang/Long:longValue	()J
    //   161: putfield 691	com/tencent/liteav/network/TXCStreamUploader$a:d	J
    //   164: aload_0
    //   165: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   168: aload 6
    //   170: ldc_w 626
    //   173: invokevirtual 675	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   176: checkcast 365	java/lang/String
    //   179: putfield 693	com/tencent/liteav/network/TXCStreamUploader$a:c	Ljava/lang/String;
    //   182: aload 6
    //   184: ldc_w 695
    //   187: invokevirtual 672	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   190: ifeq +31 -> 221
    //   193: aload 6
    //   195: ldc_w 695
    //   198: invokevirtual 675	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   201: checkcast 365	java/lang/String
    //   204: astore 7
    //   206: aload_0
    //   207: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   210: aload 7
    //   212: ldc_w 697
    //   215: invokestatic 703	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   218: putfield 705	com/tencent/liteav/network/TXCStreamUploader$a:j	Ljava/lang/String;
    //   221: new 623	org/json/JSONObject
    //   224: dup
    //   225: aload 6
    //   227: ldc_w 688
    //   230: invokevirtual 675	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   233: checkcast 365	java/lang/String
    //   236: ldc_w 697
    //   239: invokestatic 703	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   242: invokespecial 706	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   245: astore 7
    //   247: aload_0
    //   248: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   251: lconst_0
    //   252: putfield 708	com/tencent/liteav/network/TXCStreamUploader$a:b	J
    //   255: aload 7
    //   257: ldc_w 710
    //   260: invokevirtual 713	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   263: istore_3
    //   264: iload_3
    //   265: ifne +25 -> 290
    //   268: sipush 15363
    //   271: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   274: return
    //   275: astore 7
    //   277: ldc 35
    //   279: ldc_w 715
    //   282: aload 7
    //   284: invokestatic 648	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   287: goto -66 -> 221
    //   290: aload_0
    //   291: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   294: aload 7
    //   296: ldc_w 710
    //   299: invokevirtual 718	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   302: putfield 720	com/tencent/liteav/network/TXCStreamUploader$a:e	Ljava/lang/String;
    //   305: aload 7
    //   307: ldc_w 722
    //   310: invokevirtual 726	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   313: astore 6
    //   315: aload 6
    //   317: ifnull +45 -> 362
    //   320: aload 6
    //   322: ldc_w 728
    //   325: invokevirtual 713	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   328: ifeq +27 -> 355
    //   331: aload 6
    //   333: ldc_w 730
    //   336: invokevirtual 713	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   339: ifeq +16 -> 355
    //   342: aload 6
    //   344: ldc_w 732
    //   347: invokevirtual 713	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   350: istore_3
    //   351: iload_3
    //   352: ifne +10 -> 362
    //   355: sipush 15363
    //   358: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   361: return
    //   362: aload 7
    //   364: ldc_w 734
    //   367: invokevirtual 738	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   370: astore 7
    //   372: aload 7
    //   374: ifnull +140 -> 514
    //   377: aload 7
    //   379: invokevirtual 739	org/json/JSONArray:length	()I
    //   382: ifle +132 -> 514
    //   385: iconst_0
    //   386: istore_2
    //   387: iload_2
    //   388: aload 7
    //   390: invokevirtual 739	org/json/JSONArray:length	()I
    //   393: if_icmpge +121 -> 514
    //   396: aload 7
    //   398: iload_2
    //   399: invokevirtual 743	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   402: astore 8
    //   404: aload 8
    //   406: ifnull +331 -> 737
    //   409: aload 8
    //   411: ldc_w 728
    //   414: invokevirtual 713	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   417: ifeq +320 -> 737
    //   420: aload 8
    //   422: ldc_w 730
    //   425: invokevirtual 713	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   428: ifeq +309 -> 737
    //   431: aload 8
    //   433: ldc_w 732
    //   436: invokevirtual 713	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   439: ifeq +298 -> 737
    //   442: aload 8
    //   444: ldc_w 728
    //   447: invokevirtual 718	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   450: astore 9
    //   452: aload 8
    //   454: ldc_w 730
    //   457: invokevirtual 747	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   460: lstore 4
    //   462: aload 8
    //   464: ldc_w 732
    //   467: invokevirtual 747	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   470: ldc2_w 748
    //   473: lcmp
    //   474: ifne +263 -> 737
    //   477: aload_0
    //   478: getfield 202	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyIPList	Ljava/util/Vector;
    //   481: new 403	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 462	java/lang/StringBuilder:<init>	()V
    //   488: aload 9
    //   490: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: ldc_w 451
    //   496: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: lload 4
    //   501: invokevirtual 752	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   504: invokevirtual 416	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokevirtual 755	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   510: pop
    //   511: goto +226 -> 737
    //   514: aload_0
    //   515: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   518: getfield 664	com/tencent/liteav/network/TXCStreamUploader$a:i	Z
    //   521: istore_3
    //   522: iload_3
    //   523: ifeq +184 -> 707
    //   526: aload 6
    //   528: ifnonnull +10 -> 538
    //   531: sipush 15363
    //   534: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   537: return
    //   538: aload_1
    //   539: iconst_0
    //   540: aload_1
    //   541: ldc_w 757
    //   544: invokevirtual 369	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   547: invokevirtual 378	java/lang/String:substring	(II)Ljava/lang/String;
    //   550: astore_1
    //   551: new 403	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 462	java/lang/StringBuilder:<init>	()V
    //   558: aload_0
    //   559: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   562: getfield 684	com/tencent/liteav/network/TXCStreamUploader$a:a	J
    //   565: invokevirtual 752	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   568: ldc_w 759
    //   571: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: aload_0
    //   575: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   578: getfield 691	com/tencent/liteav/network/TXCStreamUploader$a:d	J
    //   581: invokevirtual 752	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   584: ldc_w 759
    //   587: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: aload_0
    //   591: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   594: getfield 693	com/tencent/liteav/network/TXCStreamUploader$a:c	Ljava/lang/String;
    //   597: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: invokevirtual 416	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: astore 7
    //   605: aload_0
    //   606: new 403	java/lang/StringBuilder
    //   609: dup
    //   610: invokespecial 462	java/lang/StringBuilder:<init>	()V
    //   613: aload_1
    //   614: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: ldc_w 761
    //   620: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: aload 7
    //   625: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: ldc_w 763
    //   631: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: aload 6
    //   636: ldc_w 728
    //   639: invokevirtual 718	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   642: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: ldc_w 765
    //   648: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: aload 6
    //   653: ldc_w 730
    //   656: invokevirtual 747	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   659: invokevirtual 752	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   662: ldc_w 767
    //   665: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload_0
    //   669: getfield 200	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyParam	Lcom/tencent/liteav/network/TXCStreamUploader$a;
    //   672: getfield 708	com/tencent/liteav/network/TXCStreamUploader$a:b	J
    //   675: invokevirtual 752	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   678: ldc_w 769
    //   681: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: invokevirtual 416	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: putfield 136	com/tencent/liteav/network/TXCStreamUploader:mRtmpUrl	Ljava/lang/String;
    //   690: aload_0
    //   691: invokespecial 537	com/tencent/liteav/network/TXCStreamUploader:getNextRtmpProxyIP	()Z
    //   694: pop
    //   695: aload_0
    //   696: iconst_1
    //   697: putfield 193	com/tencent/liteav/network/TXCStreamUploader:mRtmpProxyEnable	Z
    //   700: sipush 15363
    //   703: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   706: return
    //   707: aload_0
    //   708: aload_1
    //   709: putfield 136	com/tencent/liteav/network/TXCStreamUploader:mRtmpUrl	Ljava/lang/String;
    //   712: aload_0
    //   713: iconst_0
    //   714: putfield 138	com/tencent/liteav/network/TXCStreamUploader:mQuicChannel	Z
    //   717: goto -22 -> 695
    //   720: astore_1
    //   721: ldc 35
    //   723: ldc_w 771
    //   726: aload_1
    //   727: invokestatic 648	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   730: sipush 15363
    //   733: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   736: return
    //   737: iload_2
    //   738: iconst_1
    //   739: iadd
    //   740: istore_2
    //   741: goto -354 -> 387
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	744	0	this	TXCStreamUploader
    //   0	744	1	paramString	String
    //   386	355	2	i	int
    //   263	260	3	bool	boolean
    //   460	40	4	l	long
    //   51	601	6	localObject1	Object
    //   204	52	7	localObject2	Object
    //   275	88	7	localException	Exception
    //   370	254	7	localObject3	Object
    //   402	61	8	localJSONObject	JSONObject
    //   450	39	9	str	String
    // Exception table:
    //   from	to	target	type
    //   193	221	275	java/lang/Exception
    //   221	264	720	java/lang/Exception
    //   290	315	720	java/lang/Exception
    //   320	351	720	java/lang/Exception
    //   362	372	720	java/lang/Exception
    //   377	385	720	java/lang/Exception
    //   387	404	720	java/lang/Exception
    //   409	511	720	java/lang/Exception
    //   514	522	720	java/lang/Exception
    //   538	695	720	java/lang/Exception
    //   695	700	720	java/lang/Exception
    //   707	717	720	java/lang/Exception
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
    ??? = com.tencent.liteav.basic.util.h.a();
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
      ((Bundle)???).putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
      com.tencent.liteav.basic.util.h.a(this.mNotifyListener, paramInt, (Bundle)???);
      AppMethodBeat.o(15359);
      return;
      ((Bundle)???).putString("EVT_MSG", "Failed to connect all IPs, abort connection.");
      continue;
      ((Bundle)???).putString("EVT_MSG", "failed to connect server for several times, abort connection");
      continue;
      ((Bundle)???).putString("EVT_MSG", "No data is sent for more than 30s. Actively disconnect");
      continue;
      ((Bundle)???).putString("EVT_MSG", "No internet. Please check if WiFi or mobile data is turned on");
      continue;
      ((Bundle)???).putString("EVT_MSG", "Failed to connect server");
      continue;
      ((Bundle)???).putString("EVT_MSG", "Already connected to rtmp server");
      continue;
      ((Bundle)???).putString("EVT_MSG", "RTMP servers handshake failed");
      continue;
      ((Bundle)???).putString("EVT_MSG", "Insufficient upstream bandwidth. Data transmission is not timely");
      continue;
      ((Bundle)???).putString("EVT_MSG", "rtmp start push stream");
      continue;
      ((Bundle)???).putString("EVT_MSG", "The server rejects the connection request. It may be that the push URL has been occupied or expired, or the anti-leech link is wrong.");
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
      ((Bundle)???).putString("EVT_MSG", "Enables network reconnection");
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
      localBundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
      com.tencent.liteav.basic.util.h.a(this.mNotifyListener, paramInt, localBundle);
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
  
  public void setNotifyListener(com.tencent.liteav.basic.c.b paramb)
  {
    AppMethodBeat.i(243102);
    this.mNotifyListener = new WeakReference(paramb);
    AppMethodBeat.o(243102);
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
      if (com.tencent.liteav.basic.util.h.e(this.mContext) != 0) {
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
      this.mLastNetworkType = com.tencent.liteav.basic.util.h.e(this.mContext);
      nativeCacheJNIParams();
      startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
    }
    for (;;)
    {
      this.mHandler.sendEmptyMessageDelayed(103, 2000L);
      paramString = this.mRtmpUrl;
      AppMethodBeat.o(15341);
      return paramString;
      if ((!this.mEnableNearestIP) || (this.mLastNetworkType == com.tencent.liteav.basic.util.h.e(this.mContext))) {
        break;
      }
      TXCLog.i("TXCStreamUploader", "fetching nearest ip list");
      this.mLastNetworkType = com.tencent.liteav.basic.util.h.e(this.mContext);
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
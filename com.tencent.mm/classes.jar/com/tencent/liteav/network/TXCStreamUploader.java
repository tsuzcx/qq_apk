package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
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
  public static final int TXE_UPLOAD_ERROR_ALLADDRESS_FAILED = 11011;
  public static final int TXE_UPLOAD_ERROR_NET_DISCONNECT = 11012;
  public static final int TXE_UPLOAD_ERROR_NET_RECONNECT = 11016;
  public static final int TXE_UPLOAD_ERROR_NO_DATA = 11013;
  public static final int TXE_UPLOAD_ERROR_NO_NETWORK = 11015;
  public static final int TXE_UPLOAD_ERROR_READ_FAILED = 11017;
  public static final int TXE_UPLOAD_ERROR_WRITE_FAILED = 11018;
  public static final int TXE_UPLOAD_INFO_CONNECT_FAILED = 11006;
  public static final int TXE_UPLOAD_INFO_CONNECT_SUCCESS = 11001;
  public static final int TXE_UPLOAD_INFO_HANDSHAKE_FAIL = 11005;
  public static final int TXE_UPLOAD_INFO_NET_BUSY = 11003;
  public static final int TXE_UPLOAD_INFO_PUBLISH_START = 11008;
  public static final int TXE_UPLOAD_INFO_PUSH_BEGIN = 11002;
  public static final int TXE_UPLOAD_INFO_ROOM_IN = 11021;
  public static final int TXE_UPLOAD_INFO_ROOM_NEED_REENTER = 11024;
  public static final int TXE_UPLOAD_INFO_ROOM_OUT = 11022;
  public static final int TXE_UPLOAD_INFO_ROOM_USERLIST = 11023;
  public static final int TXE_UPLOAD_INFO_SERVER_REFUSE = 11007;
  public static final int TXE_UPLOAD_MODE_AUDIO_ONLY = 1;
  public static final int TXE_UPLOAD_MODE_LINK_MIC = 2;
  public static final int TXE_UPLOAD_MODE_REAL_TIME = 0;
  public static final int TXE_UPLOAD_PROTOCOL_AV = 1;
  public static final int TXE_UPLOAD_PROTOCOL_RTMP = 0;
  private final int MSG_EVENT = 102;
  private final int MSG_RECONNECT = 101;
  private final int MSG_REPORT_STATUS = 103;
  private final int MSG_RTMPPROXY_HEARTBEAT = 104;
  private int mChannelType = 0;
  private int mConnectCountQuic = 0;
  private int mConnectCountTcp = 0;
  private long mConnectSuccessTimeStamps = 0L;
  private Context mContext = null;
  private int mCurrentRecordIdx = 0;
  private boolean mEnableNearestIP = true;
  private long mGoodPushTime = 30000L;
  private Handler mHandler = null;
  private HandlerThread mHandlerThread = null;
  private c mIntelligentRoute = null;
  private ArrayList<a> mIpList = null;
  private boolean mIsPushing = false;
  private int mLastNetworkType = 255;
  private long mLastTimeStamp = 0L;
  private TXCStreamUploader.UploadStats mLastUploadStats = null;
  private WeakReference<com.tencent.liteav.basic.c.a> mNotifyListener = null;
  private h mParam = null;
  private long mPushStartTS = 0L;
  private boolean mQuicChannel = false;
  private int mRetryCount = 0;
  private long mRtmpMsgRecvThreadInstance = 0L;
  private Object mRtmpMsgRecvThreadLock = new Object();
  private boolean mRtmpProxyEnable = false;
  private int mRtmpProxyIPIndex = 0;
  private Vector<String> mRtmpProxyIPList = new Vector();
  private long mRtmpProxyInstance = 0L;
  private Object mRtmpProxyLock = new Object();
  private TXCStreamUploader.a mRtmpProxyParam = new TXCStreamUploader.a(this);
  private String mRtmpUrl = "";
  private Thread mThread = null;
  private Object mThreadLock = null;
  private j mUploadQualityReport = null;
  private long mUploaderInstance = 0L;
  private Vector<com.tencent.liteav.basic.f.b> mVecPendingNAL = new Vector();
  
  static {}
  
  public TXCStreamUploader(Context paramContext, h paramh)
  {
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
    this.mLastNetworkType = 255;
    this.mHandlerThread = null;
    this.mUploadQualityReport = new j(paramContext);
    i.a().a(paramContext);
  }
  
  private String getAddressFromUrl(String paramString)
  {
    if (paramString != null)
    {
      int i = paramString.indexOf("://");
      if (i != -1)
      {
        paramString = paramString.substring(i + 3);
        i = paramString.indexOf("/");
        if (i != -1) {
          return paramString.substring(0, i);
        }
      }
    }
    return "";
  }
  
  private boolean getNextRtmpProxyIP()
  {
    this.mRtmpProxyParam.f = 234L;
    this.mRtmpProxyParam.g = 80L;
    if ((this.mRtmpProxyIPList != null) && (this.mRtmpProxyIPList.size() > 0))
    {
      if (this.mRtmpProxyIPIndex < this.mRtmpProxyIPList.size()) {
        break label58;
      }
      this.mRtmpProxyIPIndex = 0;
    }
    label58:
    do
    {
      return false;
      localObject = this.mRtmpUrl.split("://");
    } while (localObject.length < 2);
    Object localObject = localObject[1].substring(localObject[1].indexOf("/"));
    String str = (String)this.mRtmpProxyIPList.get(this.mRtmpProxyIPIndex);
    this.mRtmpProxyParam.h = str;
    this.mRtmpUrl = ("room://" + str + (String)localObject);
    this.mQuicChannel = true;
    this.mRtmpProxyIPIndex += 1;
    return true;
  }
  
  private HashMap getParamsFromUrl(String paramString)
  {
    HashMap localHashMap = new HashMap();
    paramString = paramString.split("[?]");
    if ((paramString == null) || (paramString.length < 2) || (paramString[1] == null) || (paramString[1].length() == 0)) {}
    for (;;)
    {
      return localHashMap;
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
    }
  }
  
  private TXCStreamUploader.b getRtmpRealConnectInfo()
  {
    int i = 1;
    if (!this.mEnableNearestIP) {
      return new TXCStreamUploader.b(this, this.mRtmpUrl, false);
    }
    if (this.mIpList == null) {
      return new TXCStreamUploader.b(this, this.mRtmpUrl, false);
    }
    if ((this.mCurrentRecordIdx >= this.mIpList.size()) || (this.mCurrentRecordIdx < 0)) {
      return new TXCStreamUploader.b(this, this.mRtmpUrl, false);
    }
    a locala = (a)this.mIpList.get(this.mCurrentRecordIdx);
    String[] arrayOfString1 = this.mRtmpUrl.split("://");
    if (arrayOfString1.length < 2) {
      return new TXCStreamUploader.b(this, this.mRtmpUrl, false);
    }
    String[] arrayOfString2 = arrayOfString1[1].split("/");
    arrayOfString2[0] = (locala.a + ":" + locala.b);
    StringBuilder localStringBuilder = new StringBuilder(arrayOfString2[0]);
    while (i < arrayOfString2.length)
    {
      localStringBuilder.append("/");
      localStringBuilder.append(arrayOfString2[i]);
      i += 1;
    }
    return new TXCStreamUploader.b(this, arrayOfString1[0] + "://" + localStringBuilder.toString(), locala.c);
  }
  
  private Long getSpeed(long paramLong1, long paramLong2, long paramLong3)
  {
    long l = 0L;
    if (paramLong1 > paramLong2) {}
    for (;;)
    {
      paramLong1 = l;
      if (paramLong3 > 0L) {
        paramLong1 = 8L * paramLong2 * 1000L / (1024L * paramLong3);
      }
      return Long.valueOf(paramLong1);
      paramLong2 -= paramLong1;
    }
  }
  
  private void internalReconnect(boolean paramBoolean)
  {
    if (!this.mIsPushing) {
      return;
    }
    if (this.mRtmpProxyEnable)
    {
      if (this.mLastNetworkType != com.tencent.liteav.basic.util.a.c(this.mContext))
      {
        TXCLog.e("TXCStreamUploader", "reconnect network switch from " + this.mLastNetworkType + " to " + com.tencent.liteav.basic.util.a.c(this.mContext));
        this.mLastNetworkType = com.tencent.liteav.basic.util.a.c(this.mContext);
        this.mRetryCount = 0;
        sendNotifyEvent(11024, String.format("网络类型发生变化，需要重新进房", new Object[0]));
        return;
      }
      if (this.mRetryCount < this.mParam.f)
      {
        this.mRetryCount += 1;
        TXCDRApi.reportEvent40003(this.mRtmpUrl, com.tencent.liteav.basic.datareport.a.F, "reconnect rtmp-proxy server", "reconnect retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f);
        sendNotifyEvent(11016);
        startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
        return;
      }
      if (getNextRtmpProxyIP())
      {
        this.mRetryCount = 0;
        TXCDRApi.reportEvent40003(this.mRtmpUrl, com.tencent.liteav.basic.datareport.a.F, "reconnect rtmp-proxy server", "reconnect retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f);
        sendNotifyEvent(11016);
        startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
        return;
      }
      TXCDRApi.reportEvent40003(this.mRtmpUrl, com.tencent.liteav.basic.datareport.a.E, "connect rtmp-proxy server failed", "try all addresses");
      sendNotifyEvent(11011);
      return;
    }
    this.mUploadQualityReport.c();
    if ((this.mEnableNearestIP) && (this.mLastNetworkType != com.tencent.liteav.basic.util.a.c(this.mContext)))
    {
      TXCLog.e("TXCStreamUploader", "reconnect network switch from " + this.mLastNetworkType + " to " + com.tencent.liteav.basic.util.a.c(this.mContext));
      this.mLastNetworkType = com.tencent.liteav.basic.util.a.c(this.mContext);
      this.mIntelligentRoute.a(this.mRtmpUrl, this.mChannelType);
      this.mRetryCount = 0;
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
      TXCDRApi.reportEvent40003(this.mRtmpUrl, com.tencent.liteav.basic.datareport.a.E, "connect upload server failed", "try all addresses failed");
    }
    TXCStreamUploader.b localb = getRtmpRealConnectInfo();
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
      TXCDRApi.reportEvent40003(this.mRtmpUrl, com.tencent.liteav.basic.datareport.a.F, "reconnect upload server:" + str2, "last channel type is Q Channel");
      startPushTask(localb.a, localb.b, 0);
      sendNotifyEvent(11016);
      return;
    }
    TXCLog.e("TXCStreamUploader", "reconnect retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f);
    if (this.mRetryCount < this.mParam.f)
    {
      this.mRetryCount += 1;
      TXCDRApi.reportEvent40003(this.mRtmpUrl, com.tencent.liteav.basic.datareport.a.F, "reconnect upload server:" + str2, "retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f);
      startPushTask(localb.a, localb.b, 0);
      sendNotifyEvent(11016);
      return;
    }
    TXCLog.e("TXCStreamUploader", "reconnect: try all times failed");
    TXCDRApi.reportEvent40003(this.mRtmpUrl, com.tencent.liteav.basic.datareport.a.E, "connect upload server failed", "try all times failed");
    sendNotifyEvent(11011);
  }
  
  private boolean isQCloudStreamUrl(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      int i;
      do
      {
        return false;
        i = paramString.indexOf("://");
      } while (i == -1);
      paramString = paramString.substring("://".length() + i);
    } while ((paramString == null) || (!paramString.startsWith("cloud.tencent.com")));
    return true;
  }
  
  private native void nativeCacheJNIParams();
  
  private native void nativeEnableDrop(long paramLong, boolean paramBoolean);
  
  private native TXCStreamUploader.UploadStats nativeGetStats(long paramLong);
  
  private native long nativeInitRtmpMsgRecvThreadInstance(long paramLong1, long paramLong2);
  
  private native long nativeInitRtmpProxyInstance(long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2, long paramLong4, long paramLong5, String paramString3, boolean paramBoolean, String paramString4);
  
  private native long nativeInitUploader(String paramString1, String paramString2, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean2);
  
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
    if ((this.mIpList == null) || (this.mIpList.size() == 0)) {
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
      return true;
    }
    return false;
  }
  
  private void onRtmpProxyRoomEvent(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      sendNotifyEvent(11021, String.format("已在房间中，[%d]", new Object[] { Integer.valueOf(paramInt2) }));
    }
    while (paramInt1 != 2) {
      return;
    }
    sendNotifyEvent(11022, String.format("不在房间中，[%d]", new Object[] { Integer.valueOf(paramInt2) }));
  }
  
  private void onRtmpProxyUserListPushed(TXCStreamUploader.RtmpProxyUserInfo[] paramArrayOfRtmpProxyUserInfo)
  {
    if (paramArrayOfRtmpProxyUserInfo == null) {}
    while ((!this.mIsPushing) || (!this.mRtmpProxyEnable) || (this.mRtmpProxyParam == null)) {
      return;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < paramArrayOfRtmpProxyUserInfo.length)
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("userid", paramArrayOfRtmpProxyUserInfo[i].account);
        localJSONObject.put("playurl", paramArrayOfRtmpProxyUserInfo[i].playUrl);
        localJSONArray.put(i, localJSONObject);
        i += 1;
      }
      paramArrayOfRtmpProxyUserInfo = new JSONObject();
      paramArrayOfRtmpProxyUserInfo.put("userlist", localJSONArray);
      sendNotifyEvent(11023, paramArrayOfRtmpProxyUserInfo.toString());
      return;
    }
    catch (Exception paramArrayOfRtmpProxyUserInfo) {}
  }
  
  private void onSendRtmpProxyMsg(byte[] paramArrayOfByte)
  {
    synchronized (this.mThreadLock)
    {
      if (this.mUploaderInstance != 0L) {
        nativeSendRtmpProxyMsg(this.mUploaderInstance, paramArrayOfByte);
      }
      return;
    }
  }
  
  private void parseProxyInfo(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (!paramString.startsWith("room"))) {}
    for (;;)
    {
      return;
      this.mRtmpProxyParam.i = isQCloudStreamUrl(paramString);
      Object localObject1 = getParamsFromUrl(paramString);
      if (localObject1 == null) {
        continue;
      }
      if (((HashMap)localObject1).containsKey("sdkappid")) {
        this.mRtmpProxyParam.a = Long.valueOf((String)((HashMap)localObject1).get("sdkappid")).longValue();
      }
      if ((!((HashMap)localObject1).containsKey("roomid")) || (!((HashMap)localObject1).containsKey("userid")) || (!((HashMap)localObject1).containsKey("roomsig"))) {
        continue;
      }
      this.mRtmpProxyParam.d = Long.valueOf((String)((HashMap)localObject1).get("roomid")).longValue();
      this.mRtmpProxyParam.c = ((String)((HashMap)localObject1).get("userid"));
      if (((HashMap)localObject1).containsKey("bizbuf")) {}
      try
      {
        localObject2 = (String)((HashMap)localObject1).get("bizbuf");
        this.mRtmpProxyParam.j = URLDecoder.decode((String)localObject2, "UTF-8");
      }
      catch (Exception localException)
      {
        try
        {
          label195:
          Object localObject2 = new JSONObject(URLDecoder.decode((String)((HashMap)localObject1).get("roomsig"), "UTF-8"));
          this.mRtmpProxyParam.b = 0L;
          if (!((JSONObject)localObject2).has("Key")) {
            continue;
          }
          this.mRtmpProxyParam.e = ((JSONObject)localObject2).optString("Key");
          localObject1 = ((JSONObject)localObject2).optJSONObject("RtmpProxy");
          if ((localObject1 != null) && ((!((JSONObject)localObject1).has("Ip")) || (!((JSONObject)localObject1).has("Port")) || (!((JSONObject)localObject1).has("Type")))) {
            continue;
          }
          localObject2 = ((JSONObject)localObject2).optJSONArray("AccessList");
          int i;
          if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
            i = 0;
          }
          for (;;)
          {
            if (i < ((JSONArray)localObject2).length())
            {
              JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
              if ((localJSONObject != null) && (localJSONObject.has("Ip")) && (localJSONObject.has("Port")) && (localJSONObject.has("Type")))
              {
                String str = localJSONObject.optString("Ip");
                long l = localJSONObject.optLong("Port");
                if (localJSONObject.optLong("Type") == 2L) {
                  this.mRtmpProxyIPList.add(str + ":" + l);
                }
              }
            }
            else
            {
              if (this.mRtmpProxyParam.i)
              {
                if (localObject1 == null) {
                  break;
                }
                paramString = paramString.substring(0, paramString.indexOf("?"));
                localObject2 = this.mRtmpProxyParam.a + "_" + this.mRtmpProxyParam.d + "_" + this.mRtmpProxyParam.c;
                this.mRtmpUrl = (paramString + "/webrtc/" + (String)localObject2 + "?real_rtmp_ip=" + ((JSONObject)localObject1).optString("Ip") + "&real_rtmp_port=" + ((JSONObject)localObject1).optLong("Port") + "&tinyid=" + this.mRtmpProxyParam.b + "&srctinyid=0");
                getNextRtmpProxyIP();
              }
              for (;;)
              {
                this.mRtmpProxyEnable = true;
                return;
                this.mRtmpUrl = paramString;
                this.mQuicChannel = false;
              }
              localException = localException;
              break label195;
            }
            i += 1;
          }
          return;
        }
        catch (Exception paramString) {}
      }
    }
  }
  
  private void postReconnectMsg(String paramString, boolean paramBoolean, int paramInt)
  {
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
      return;
    }
  }
  
  private void reconnect(boolean paramBoolean)
  {
    stopPushTask();
    if (this.mHandler != null) {
      this.mHandler.postDelayed(new TXCStreamUploader.3(this, paramBoolean), this.mParam.g * 1000);
    }
  }
  
  private void reportNetStatus()
  {
    long l6 = TXCTimeUtil.getTimeTick();
    long l5 = l6 - this.mLastTimeStamp;
    TXCStreamUploader.UploadStats localUploadStats = getUploadStats();
    long l3 = 0L;
    long l2 = 0L;
    long l1 = 0L;
    long l4;
    if (localUploadStats != null)
    {
      if (this.mLastUploadStats == null) {
        break label434;
      }
      l4 = getSpeed(this.mLastUploadStats.inVideoBytes, localUploadStats.inVideoBytes, l5).longValue();
      l3 = getSpeed(this.mLastUploadStats.inAudioBytes, localUploadStats.inAudioBytes, l5).longValue();
      l1 = getSpeed(this.mLastUploadStats.outVideoBytes, localUploadStats.outVideoBytes, l5).longValue();
      l5 = getSpeed(this.mLastUploadStats.outAudioBytes, localUploadStats.outAudioBytes, l5).longValue();
      l2 = l1;
      l1 = l5;
    }
    for (;;)
    {
      setStatusValue(7001, Long.valueOf(l4));
      setStatusValue(7002, Long.valueOf(l3));
      setStatusValue(7003, Long.valueOf(l2));
      setStatusValue(7004, Long.valueOf(l1));
      setStatusValue(7005, Long.valueOf(localUploadStats.videoCacheLen));
      setStatusValue(7006, Long.valueOf(localUploadStats.audioCacheLen));
      setStatusValue(7007, Long.valueOf(localUploadStats.videoDropCount));
      setStatusValue(7008, Long.valueOf(localUploadStats.audioDropCount));
      setStatusValue(7009, Long.valueOf(localUploadStats.startTS));
      setStatusValue(7010, Long.valueOf(localUploadStats.dnsTS));
      setStatusValue(7011, Long.valueOf(localUploadStats.connTS));
      setStatusValue(7012, String.valueOf(localUploadStats.serverIP));
      if (this.mQuicChannel) {}
      for (l1 = 2L;; l1 = 1L)
      {
        setStatusValue(7013, Long.valueOf(l1));
        setStatusValue(7014, localUploadStats.connectionID);
        setStatusValue(7015, localUploadStats.connectionStats);
        this.mUploadQualityReport.a(localUploadStats.videoDropCount, localUploadStats.audioDropCount);
        this.mUploadQualityReport.b(localUploadStats.videoCacheLen, localUploadStats.audioCacheLen);
        this.mLastTimeStamp = l6;
        this.mLastUploadStats = localUploadStats;
        if (this.mHandler != null) {
          this.mHandler.sendEmptyMessageDelayed(103, 2000L);
        }
        return;
      }
      label434:
      l4 = 0L;
    }
  }
  
  private void rtmpProxySendHeartBeat()
  {
    ??? = com.tencent.liteav.basic.util.a.a();
    long l1 = ???[0] / 10;
    long l2 = ???[1] / 10;
    long l3 = TXCStatus.d(getID(), 7004);
    long l4 = TXCStatus.d(getID(), 7003);
    long l5 = TXCStatus.d(getID(), 1001);
    long l6 = TXCStatus.d(getID(), 4001);
    long l7 = TXCStatus.d(getID(), 7006);
    long l8 = TXCStatus.d(getID(), 7005);
    long l9 = TXCStatus.d(getID(), 7008);
    long l10 = TXCStatus.d(getID(), 7007);
    synchronized (this.mRtmpProxyLock)
    {
      nativeRtmpProxySendHeartBeat(this.mRtmpProxyInstance, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10);
      return;
    }
  }
  
  private void sendNotifyEvent(int paramInt)
  {
    if (paramInt == 0) {
      reconnect(false);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        reconnect(true);
        return;
      }
      if (paramInt == 11001) {
        this.mConnectSuccessTimeStamps = TXCTimeUtil.getTimeTick();
      }
    } while (this.mNotifyListener == null);
    ??? = new Bundle();
    switch (paramInt)
    {
    case 11004: 
    case 11009: 
    case 11010: 
    case 11014: 
    default: 
      ((Bundle)???).putString("EVT_MSG", "UNKNOWN");
    }
    for (;;)
    {
      for (;;)
      {
        ((Bundle)???).putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        com.tencent.liteav.basic.util.a.a(this.mNotifyListener, paramInt, (Bundle)???);
        return;
        ((Bundle)???).putString("EVT_MSG", "所有IP都已经尝试失败,可以放弃治疗");
        paramInt = -1307;
        continue;
        ((Bundle)???).putString("EVT_MSG", "经连续多次重连失败，放弃重连");
        paramInt = -1307;
        continue;
        ((Bundle)???).putString("EVT_MSG", "超过30s没有数据发送，主动断开连接");
        paramInt = -1307;
        continue;
        ((Bundle)???).putString("EVT_MSG", "没有网络，请检测WiFi或移动数据是否开启");
        paramInt = -1307;
        continue;
        ((Bundle)???).putString("EVT_MSG", "连接服务器失败");
        paramInt = 3002;
        continue;
        paramInt = 1001;
        ((Bundle)???).putString("EVT_MSG", "已经连接rtmp服务器");
        continue;
        paramInt = 3003;
        ((Bundle)???).putString("EVT_MSG", "RTMP服务器握手失败");
        continue;
        ((Bundle)???).putString("EVT_MSG", "上行带宽不足，数据发送不及时");
        paramInt = 1101;
        continue;
        paramInt = 1002;
        ((Bundle)???).putString("EVT_MSG", "rtmp开始推流");
        continue;
        paramInt = 3004;
        ((Bundle)???).putString("EVT_MSG", "服务器拒绝连接请求，可能是该推流地址已经被占用");
        continue;
        if (!this.mRtmpProxyEnable) {
          break;
        }
        synchronized (this.mRtmpMsgRecvThreadLock)
        {
          nativeRtmpMsgRecvThreadStart(this.mRtmpMsgRecvThreadInstance);
        }
        synchronized (this.mRtmpProxyLock)
        {
          nativeRtmpProxyEnterRoom(this.mRtmpProxyInstance);
          if (this.mHandler == null) {
            break;
          }
          this.mHandler.sendEmptyMessageDelayed(104, 2000L);
          return;
          localObject2 = finally;
          throw localObject2;
        }
      }
      paramInt = 1102;
      ((Bundle)???).putString("EVT_MSG", "启动网络重连");
    }
  }
  
  private void sendNotifyEvent(int paramInt, String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty()))
    {
      sendNotifyEvent(paramInt);
      if (paramInt != 11002) {
        break label205;
      }
      paramString = getUploadStats();
      if (paramString != null) {
        this.mUploadQualityReport.a(paramString.dnsparseTimeCost, paramString.connectTimeCost, paramString.handshakeTimeCost);
      }
    }
    label205:
    while (paramInt != 11003)
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_MSG", paramString);
      localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      switch (paramInt)
      {
      }
      for (;;)
      {
        com.tencent.liteav.basic.util.a.a(this.mNotifyListener, paramInt, localBundle);
        break;
        paramInt = 3002;
        continue;
        paramInt = 3005;
        continue;
        paramInt = 3005;
        continue;
        paramInt = 1018;
        continue;
        paramInt = 1019;
        continue;
        paramInt = 1020;
        continue;
        paramInt = 1021;
      }
    }
    this.mUploadQualityReport.d();
  }
  
  private void startPushTask(String paramString, boolean paramBoolean, int paramInt)
  {
    TXCLog.d("TXCStreamUploader", "start push task");
    if ((this.mQuicChannel != paramBoolean) && (this.mQuicChannel == true)) {
      TXCDRApi.reportEvent40003(this.mRtmpUrl, com.tencent.liteav.basic.datareport.a.M, "switch video push channel from quic to tcp", "limits:" + this.mParam.f + " current:" + this.mRetryCount);
    }
    if (paramBoolean)
    {
      paramInt = this.mConnectCountQuic + 1;
      this.mConnectCountQuic = paramInt;
      setStatusValue(7017, Long.valueOf(paramInt));
    }
    for (;;)
    {
      this.mThread = new TXCStreamUploader.2(this, "RTMPUpload", paramBoolean, paramString);
      this.mThread.start();
      return;
      paramInt = this.mConnectCountTcp + 1;
      this.mConnectCountTcp = paramInt;
      setStatusValue(7018, Long.valueOf(paramInt));
    }
  }
  
  private void stopPushTask()
  {
    TXCLog.d("TXCStreamUploader", "stop push task");
    synchronized (this.mThreadLock)
    {
      this.mVecPendingNAL.removeAllElements();
      nativeStopPush(this.mUploaderInstance);
      return;
    }
  }
  
  private void tryResetRetryCount()
  {
    if ((this.mConnectSuccessTimeStamps != 0L) && (TXCTimeUtil.getTimeTick() - this.mConnectSuccessTimeStamps > this.mParam.f * (this.mParam.g + 13) * 1000))
    {
      this.mRetryCount = 0;
      this.mConnectSuccessTimeStamps = 0L;
      TXCLog.d("TXCStreamUploader", "reset retry count");
    }
  }
  
  public String getConfusionIP(String paramString)
  {
    String str1 = paramString;
    if (paramString != null)
    {
      int i = paramString.indexOf(".");
      str1 = paramString;
      if (i != -1)
      {
        String str2 = paramString.substring(i + 1);
        i = str2.indexOf(".");
        str1 = paramString;
        if (i != -1)
        {
          paramString = str2.substring(i + 1);
          str1 = "A.B." + paramString;
        }
      }
    }
    return str1;
  }
  
  public TXCStreamUploader.UploadStats getUploadStats()
  {
    for (;;)
    {
      synchronized (this.mThreadLock)
      {
        TXCStreamUploader.UploadStats localUploadStats = nativeGetStats(this.mUploaderInstance);
        if (localUploadStats != null)
        {
          if (this.mQuicChannel == true)
          {
            l = 2L;
            localUploadStats.channelType = l;
          }
        }
        else {
          return localUploadStats;
        }
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
    if (!this.mIsPushing) {
      return;
    }
    if (paramArrayList != null)
    {
      TXCLog.e("TXCStreamUploader", "onFetchDone: code = " + paramInt + " ip count = " + paramArrayList.size());
      if (paramInt == 0)
      {
        this.mIpList = paramArrayList;
        this.mCurrentRecordIdx = 0;
      }
    }
    int i;
    if ((this.mIpList != null) && (this.mIpList.size() > 0))
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
          break label278;
        }
        paramArrayList = paramArrayList + " " + getConfusionIP(locala.a) + ":" + locala.b;
      }
    }
    label278:
    for (;;)
    {
      paramInt = i;
      break;
      setStatusValue(7016, Long.valueOf(paramInt));
      setStatusValue(7019, "{" + paramArrayList + " }");
      paramArrayList = getRtmpRealConnectInfo();
      postReconnectMsg(paramArrayList.a, paramArrayList.b, 0);
      return;
    }
  }
  
  public void pushAAC(byte[] paramArrayOfByte, long paramLong)
  {
    tryResetRetryCount();
    synchronized (this.mThreadLock)
    {
      if (this.mPushStartTS == 0L) {
        this.mPushStartTS = (paramLong - 3600000L);
      }
      nativePushAAC(this.mUploaderInstance, paramArrayOfByte, paramLong - this.mPushStartTS);
      return;
    }
  }
  
  public void pushNAL(com.tencent.liteav.basic.f.b paramb)
  {
    tryResetRetryCount();
    synchronized (this.mThreadLock)
    {
      if (this.mUploaderInstance != 0L)
      {
        if (this.mPushStartTS == 0L) {
          this.mPushStartTS = (paramb.h - 3600000L);
        }
        if ((paramb != null) && (paramb.a != null) && (paramb.a.length > 0)) {
          nativePushNAL(this.mUploaderInstance, paramb.a, paramb.b, paramb.e, paramb.g - this.mPushStartTS, paramb.h - this.mPushStartTS);
        }
        return;
      }
      if (paramb.b == 0) {
        this.mVecPendingNAL.removeAllElements();
      }
      this.mVecPendingNAL.add(paramb);
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
  
  public void setDropEanble(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("drop enable ");
    if (paramBoolean) {
      ??? = "yes";
    }
    for (;;)
    {
      TXCLog.d("TXCStreamUploader", (String)???);
      synchronized (this.mThreadLock)
      {
        nativeEnableDrop(this.mUploaderInstance, paramBoolean);
        return;
        ??? = "no";
      }
    }
  }
  
  public void setMode(int paramInt)
  {
    if (this.mParam != null) {
      this.mParam.a = paramInt;
    }
  }
  
  public void setNotifyListener(com.tencent.liteav.basic.c.a parama)
  {
    this.mNotifyListener = new WeakReference(parama);
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
        return;
        i = 2;
        continue;
        i = 1;
      }
    }
  }
  
  public void setVideoDropParams(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder("drop params wait i frame:");
    if (paramBoolean) {
      ??? = "yes";
    }
    for (;;)
    {
      TXCLog.d("TXCStreamUploader", (String)??? + " max video count:" + paramInt1 + " max video cache time: " + paramInt2 + " ms");
      synchronized (this.mThreadLock)
      {
        this.mParam.j = paramBoolean;
        this.mParam.h = paramInt1;
        this.mParam.i = paramInt2;
        if (this.mUploaderInstance != 0L) {
          nativeSetVideoDropParams(this.mUploaderInstance, this.mParam.j, this.mParam.h, this.mParam.i);
        }
        return;
        ??? = "no";
      }
    }
  }
  
  public String start(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.mIsPushing == true) {
      return this.mRtmpUrl;
    }
    this.mIsPushing = true;
    this.mConnectSuccessTimeStamps = 0L;
    this.mRetryCount = 0;
    this.mRtmpUrl = paramString;
    this.mChannelType = paramInt;
    this.mPushStartTS = 0L;
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
      TXCLog.d("TXCStreamUploader", str + "channel type:" + paramInt);
      if (com.tencent.liteav.basic.util.a.c(this.mContext) != 255) {
        break;
      }
      sendNotifyEvent(11015);
      return this.mRtmpUrl;
    }
    this.mEnableNearestIP = paramBoolean;
    if (this.mHandlerThread == null)
    {
      this.mHandlerThread = new HandlerThread("RTMP_PUSH");
      this.mHandlerThread.start();
    }
    this.mHandler = new TXCStreamUploader.1(this, this.mHandlerThread.getLooper());
    parseProxyInfo(paramString);
    if (this.mRtmpProxyEnable)
    {
      this.mLastNetworkType = com.tencent.liteav.basic.util.a.c(this.mContext);
      nativeCacheJNIParams();
      startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
    }
    for (;;)
    {
      this.mHandler.sendEmptyMessageDelayed(103, 2000L);
      return this.mRtmpUrl;
      if ((!this.mEnableNearestIP) || (this.mLastNetworkType == com.tencent.liteav.basic.util.a.c(this.mContext))) {
        break;
      }
      TXCLog.d("TXCStreamUploader", "fetching nearest ip list");
      this.mLastNetworkType = com.tencent.liteav.basic.util.a.c(this.mContext);
      this.mIntelligentRoute.a(paramString, paramInt);
    }
  }
  
  public void stop()
  {
    if (!this.mIsPushing) {
      return;
    }
    this.mIsPushing = false;
    TXCLog.d("TXCStreamUploader", "stop push");
    if (this.mRtmpProxyEnable) {
      synchronized (this.mRtmpProxyLock)
      {
        nativeRtmpProxyLeaveRoom(this.mRtmpProxyInstance);
      }
    }
    synchronized (this.mThreadLock)
    {
      nativeStopPush(this.mUploaderInstance);
      this.mPushStartTS = 0L;
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
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.network.TXCStreamUploader
 * JD-Core Version:    0.7.0.1
 */
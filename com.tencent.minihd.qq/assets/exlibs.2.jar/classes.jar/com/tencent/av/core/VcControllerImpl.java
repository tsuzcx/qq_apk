package com.tencent.av.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.config.ConfigInfo;
import com.tencent.av.mediacodec.AndroidCodec;
import com.tencent.av.service.AVPbInfo;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.qav.channel.VideoChannelInterface;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.reporter.DeviceMonitor;
import com.tencent.qav.utils.DeviceInfoUtil;
import java.io.UnsupportedEncodingException;

public class VcControllerImpl
{
  private static String DEFAULT_CAMERA_PREVIEW_PARAM = "preview-size-values=320x240,640x480;";
  public static final int EM_SDK_EVENT_ACCEPT_VIDEO_MODE = 106;
  public static final int EM_SDK_EVENT_CANCEL_VIDEO_MODE = 108;
  public static final int EM_SDK_EVENT_ID_AUDIO_RECORD = 117;
  public static final int EM_SDK_EVENT_ID_CUSTOM_COMMAND = 119;
  public static final int EM_SDK_EVENT_ID_DETAIL_NET_STATE_CHECK = 100;
  public static final int EM_SDK_EVENT_ID_DEVICE_ATTR = 110;
  public static final int EM_SDK_EVENT_ID_GROUND_GLASS_SWITCH = 113;
  public static final int EM_SDK_EVENT_ID_GROUND_GLASS_WAIT_TIME = 114;
  public static final int EM_SDK_EVENT_ID_NETWORK_CHECK_REQ = 118;
  public static final int EM_SDK_EVENT_ID_PSTN_CALL = 95;
  public static final int EM_SDK_EVENT_ID_RECV_AVFUNCHATRMSG = 111;
  public static final int EM_SDK_EVENT_ID_REOPEN_CAMERA_NFPS = 116;
  public static final int EM_SDK_EVENT_ID_SMARTDEVICE_AUDIO_DATA = 96;
  public static final int EM_SDK_EVENT_REJECT_VIDEO_MODE = 107;
  public static final int EM_SDK_EVENT_REQUEST_VIDEO_MODE = 105;
  public static final int EM_VOIP_AUDIOENGINE_READY = 83;
  public static final int EM_VOIP_SEND_FIRST_AUDIO_DATA = 71;
  public static final int EV_M2MVIDEO_DEC_FRAME_DATA = 15;
  public static final int EV_VOIP_ANOTHERISRING = 25;
  public static final int EV_VOIP_ANOTHERRINGDISCONNECTED = 26;
  public static final int EV_VOIP_ANOTHER_HAVEDACCEPT = 13;
  public static final int EV_VOIP_ANOTHER_HAVEDREJECT = 14;
  public static final int EV_VOIP_AUDIO_REQUEST = 2;
  public static final int EV_VOIP_AUDIO_SWITCH = 50;
  public static final int EV_VOIP_CAN_RECV_AUDIO_DATA = 63;
  public static final int EV_VOIP_CLOSED = 4;
  public static final int EV_VOIP_CLOSED_SWITCH_GROUP = 69;
  public static final int EV_VOIP_CONFIGSYS_DEAL_DONE = 18;
  public static final int EV_VOIP_CONNFAIL = 24;
  public static final int EV_VOIP_FRIEND_ACCEPTED = 3;
  public static final int EV_VOIP_HAS_GETTED_SHARP_CONFIG_PAYLOAD = 93;
  public static final int EV_VOIP_HAS_RECV_FIRST_AUDIO_PACKET = 64;
  public static final int EV_VOIP_HAS_RECV_FIRST_VIDEOFRAME = 66;
  public static final int EV_VOIP_InviteReached = 68;
  public static final int EV_VOIP_LOCAL_AUDIO_LESS_DATA = 92;
  public static final int EV_VOIP_LOCAL_AUDIO_NO_DATA = 91;
  public static final int EV_VOIP_MEDIA_CAMERA_NOTIFY = 65;
  public static final int EV_VOIP_MOBILE_AUDIO_REQ = 60;
  public static final int EV_VOIP_MOBILE_VIDEO_REQ = 61;
  public static final int EV_VOIP_NETWORK_BAD = 11;
  public static final int EV_VOIP_NETWORK_GOOD = 12;
  public static final int EV_VOIP_NETWORK_MONITOR_INFO = 16;
  public static final int EV_VOIP_NOT_RECV_AUDIO_DATA = 62;
  public static final int EV_VOIP_OTHER_TER_CHATING_STAUTS = 72;
  public static final int EV_VOIP_PAUSEAUDIO = 7;
  public static final int EV_VOIP_PAUSEVIDEO = 8;
  public static final int EV_VOIP_PEER_NET_STATE_CHECK = 67;
  public static final int EV_VOIP_PEER_SWITCH_FAIL = 76;
  public static final int EV_VOIP_PEER_SWITCH_TERMINAL = 73;
  public static final int EV_VOIP_RECEIVER_RECEIVED_REQ = 17;
  public static final int EV_VOIP_RECEIVE_RELAYASVR_INFO = 5;
  public static final int EV_VOIP_RELAY_SVR_CONNECTED = 6;
  public static final int EV_VOIP_RESUMEAUDIO = 9;
  public static final int EV_VOIP_RESUMEVIDEO = 10;
  public static final int EV_VOIP_SWITCHAUDIO = 19;
  public static final int EV_VOIP_SWITCHVIDEO = 20;
  public static final int EV_VOIP_SWITCHVIDEOCANCEL = 22;
  public static final int EV_VOIP_SWITCHVIDEOCONFIRM = 21;
  public static final int EV_VOIP_SWITCH_TERMINAL_SUCCESS = 74;
  public static final int EV_VOIP_SYNC_OTHER_TERMINAL_CHAT_STATUS = 75;
  public static final int EV_VOIP_VIDEO_REQUEST = 1;
  private static final String KEY_BATTERY_TEMPERATURE = "battery_temperatrue";
  private static final String KEY_CPU_TEMPERATURE = "cpu_temperature";
  private static final String KEY_IS_SESSION_OFFLINE = "is_offline_session";
  private static final String KEY_SOCKET_RECONNECT = "enable_reconnect";
  private static final String KEY_SOCKET_RECONNECT_TIMEOUT = "reconnect_timeout";
  public static int NATIVE_ERR_NOT_INI = 0;
  public static int NATIVE_ERR_NO_ENV = 0;
  public static int NATIVE_ERR_NULL_PARA = 0;
  public static int NATIVE_ERR_OUT_MEM = -101;
  private static final String TAG = "VcControllerImpl";
  public static final int VOIP_REASON_CALL_TYPE_NOT_SUIT = 17;
  public static final int VOIP_REASON_CANCLE_BY_REQUESTER_BEFORECALLING = 18;
  public static final int VOIP_REASON_CAPA_EXCHANGE_FAILED = 15;
  public static final int VOIP_REASON_CLOSED_BY_FRIEND = 1;
  public static final int VOIP_REASON_CLOSED_BY_SELF = 0;
  public static final int VOIP_REASON_CLOSED_BY_SELF_IGNORE = 16;
  public static final int VOIP_REASON_CLOSED_BY_SWITCHTOGROUP = 20;
  public static final int VOIP_REASON_CONFLICT = 6;
  public static final int VOIP_REASON_FRIEND_CONFLICT = 7;
  public static final int VOIP_REASON_FRIEND_OFFLINE = 14;
  public static final int VOIP_REASON_FRIEND_VERSION_NOT_SUPPORT = 5;
  public static final int VOIP_REASON_FRIEND_WAIT_RELAYINFO_TIMEOUT = 10;
  public static final int VOIP_REASON_FRIEND_WAIT_RELAY_CONNECT_TIMEOUT = 11;
  public static final int VOIP_REASON_NETWORK_DISCONNECT = 13;
  public static final int VOIP_REASON_NETWORK_ERROR = 12;
  public static final int VOIP_REASON_OTHERS = 30;
  public static final int VOIP_REASON_REJECT_BY_FRIEND = 2;
  public static final int VOIP_REASON_REJECT_BY_SELF = 3;
  public static final int VOIP_REASON_SELF_OFFLINE = 19;
  public static final int VOIP_REASON_SELF_VERSION_NOT_SUPPORT = 4;
  public static final int VOIP_REASON_SELF_WAIT_RELAYINFO_TIMEOUT = 8;
  public static final int VOIP_REASON_SELF_WAIT_RELAY_CONNECT_TIMEOUT = 9;
  private boolean mAudio2VideoFlag = true;
  private NativeEventHandler mEventHandler;
  private IVideoEventListener mEventListener;
  private String mMcc = "";
  private String mMnc = "";
  private VideoChannelInterface mVideoChannelInterface;
  
  static
  {
    NATIVE_ERR_NOT_INI = -102;
    NATIVE_ERR_NO_ENV = -103;
    NATIVE_ERR_NULL_PARA = -104;
  }
  
  public VcControllerImpl(Context paramContext, VideoChannelInterface paramVideoChannelInterface, IVideoEventListener paramIVideoEventListener, int paramInt1, int paramInt2)
  {
    ConfigInfo.instance();
    initDeviceInfo(paramContext, paramInt1, paramInt2, AndroidCodec.checkSupportMediaCodecFeature(paramContext));
    initEventHandler();
    if (getSdkVersion() < 18) {
      throw new UnsatisfiedLinkError();
    }
    cacheMethodIds();
    this.mVideoChannelInterface = paramVideoChannelInterface;
    this.mEventListener = paramIVideoEventListener;
    VcSystemInfo.sScreenWidth = paramInt1;
    VcSystemInfo.sScreenHeight = paramInt2;
    paramContext = DeviceInfoUtil.getIMSI();
    if ((!TextUtils.isEmpty(paramContext)) && (paramContext.length() >= 5)) {
      this.mMnc = paramContext.substring(3, 5);
    }
  }
  
  private static native void cacheMethodIds();
  
  private void callbackDataTransfered(int paramInt, long paramLong)
  {
    if (this.mEventListener != null) {
      this.mEventListener.dataTransfered(paramInt, paramLong);
    }
  }
  
  private int callbackGetAPAndGateWayIP()
  {
    if (this.mEventListener != null) {
      return this.mEventListener.getAPAndGateWayIP();
    }
    return -1;
  }
  
  private String callbackGetCustomInfo(long paramLong, String paramString)
  {
    try
    {
      if ("enable_reconnect".equals(paramString)) {
        return String.valueOf(0);
      }
      if ("reconnect_timeout".equals(paramString)) {
        return String.valueOf(5000);
      }
      if ("is_offline_session".equals(paramString))
      {
        if ((this.mEventListener == null) || (this.mEventListener.IsOfflineSession(String.valueOf(paramLong)) != 1)) {
          break label105;
        }
        return "true";
      }
      if ("battery_temperatrue".equals(paramString)) {
        return DeviceMonitor.getInstance().getDeviceTemperature();
      }
      if ("cpu_temperature".equals(paramString))
      {
        paramString = DeviceMonitor.getInstance().getCpuTemperature();
        return paramString;
      }
    }
    catch (Throwable paramString) {}
    return "";
    label105:
    return "false";
  }
  
  private long callbackGetMSFInviteMessageTimeStamp(long paramLong)
  {
    if (this.mEventListener != null) {
      return this.mEventListener.getMsfInviteTimeStamp(paramLong);
    }
    return 0L;
  }
  
  private int callbackIsOfflineSession(long paramLong)
  {
    if (this.mEventListener != null) {
      return this.mEventListener.IsOfflineSession(String.valueOf(paramLong));
    }
    return 0;
  }
  
  private void callbackOnEvent(int paramInt1, byte[] paramArrayOfByte1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString, int paramInt2, int paramInt3, byte[] paramArrayOfByte2)
  {
    if (this.mEventListener == null) {
      AVLog.e("VcControllerImpl", "mEventListener is null");
    }
    while (this.mEventHandler == null) {
      return;
    }
    if (paramInt1 == 117)
    {
      this.mEventListener.onRecordAudio(paramArrayOfByte1, paramInt2, paramInt3);
      return;
    }
    NativeEventParams localNativeEventParams = new NativeEventParams(null);
    localNativeEventParams.detail = paramArrayOfByte1;
    localNativeEventParams.info = paramLong1;
    localNativeEventParams.fromUin = paramLong2;
    localNativeEventParams.extraParam0 = paramLong3;
    localNativeEventParams.extraParam1 = paramLong4;
    localNativeEventParams.extraParam2 = paramString;
    localNativeEventParams.extraParam3 = paramInt2;
    localNativeEventParams.extraParam4 = paramInt3;
    localNativeEventParams.extraBuf = paramArrayOfByte2;
    paramArrayOfByte1 = this.mEventHandler.obtainMessage(paramInt1, 0, 0, localNativeEventParams);
    this.mEventHandler.sendMessage(paramArrayOfByte1);
  }
  
  private void callbackSendConfigReq(byte[] paramArrayOfByte)
  {
    if (this.mVideoChannelInterface != null) {}
  }
  
  private void callbackTcpSendSharpCMD(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.mVideoChannelInterface != null) {
      this.mVideoChannelInterface.sendSharpVideoMsg(paramLong, paramArrayOfByte);
    }
  }
  
  private int changeBusyType(int paramInt)
  {
    if (paramInt == 0) {}
    while (paramInt != 1) {
      return 1;
    }
    return 2;
  }
  
  private void changePreviewSize(int paramInt1, int paramInt2) {}
  
  private void initDeviceInfo(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = "PRODUCT=" + Build.PRODUCT + ";";
    str = str + "CPU_ABI=" + Build.CPU_ABI + ";";
    str = str + "TAGS=" + Build.TAGS + ";";
    str = str + "VERSION_CODES_BASE=1;";
    str = str + "MODEL=" + Build.MODEL + ";";
    str = str + "SDK=" + Build.VERSION.SDK_INT + ";";
    str = str + "VERSION_RELEASE=" + Build.VERSION.RELEASE + ";";
    str = str + "DEVICE=" + Build.DEVICE + ";";
    str = str + "DISPLAY=" + Build.DISPLAY + ";";
    str = str + "BRAND=" + Build.BRAND + ";";
    str = str + "BOARD=" + Build.BOARD + ";";
    str = str + "FINGERPRINT=" + Build.FINGERPRINT + ";";
    str = str + "ID=" + Build.ID + ";";
    str = str + "MANUFACTURER=" + Build.MANUFACTURER + ";";
    str = str + "USER=" + Build.USER + ";";
    if (paramInt3 > 0) {
      if ((paramInt3 & 0x1) == 1)
      {
        str = str + "HWAVCDEC=1;";
        if ((paramInt3 & 0x2) != 2) {
          break label816;
        }
        str = str + "HWAVCENC=1;";
        label575:
        if ((paramInt3 & 0x4) != 4) {
          break label842;
        }
        str = str + "HWHEVCDEC=1;";
        label606:
        if ((paramInt3 & 0x8) != 8) {
          break label868;
        }
        str = str + "HWHEVCENC=1;";
        label639:
        paramContext = paramContext.getApplicationInfo();
        str = str + "DATADIR=" + paramContext.dataDir + ";";
        if (Build.VERSION.SDK_INT < 9) {
          break label989;
        }
      }
    }
    label816:
    label842:
    label989:
    for (paramContext = str + "LIBDIR=" + paramContext.nativeLibraryDir + ";";; paramContext = str + "LIBDIR=" + paramContext.dataDir + "/lib;")
    {
      paramContext = paramContext + "W=" + paramInt1 + ";";
      setupDeviceInfos(paramContext + "H=" + paramInt2 + ";");
      return;
      str = str + "HWAVCDEC=0;";
      break;
      str = str + "HWAVCENC=0;";
      break label575;
      str = str + "HWHEVCDEC=0;";
      break label606;
      label868:
      str = str + "HWHEVCENC=0;";
      break label639;
      str = str + "HWAVCENC=0;";
      str = str + "HWAVCDEC=0;";
      str = str + "HWHEVCENC=0;";
      str = str + "HWHEVCDEC=0;";
      break label639;
    }
  }
  
  private void initEventHandler()
  {
    if (this.mEventHandler == null)
    {
      localLooper = Looper.getMainLooper();
      if (localLooper != null) {
        this.mEventHandler = new NativeEventHandler(localLooper);
      }
    }
    else
    {
      return;
    }
    Looper localLooper = Looper.myLooper();
    if (localLooper != null)
    {
      this.mEventHandler = new NativeEventHandler(localLooper);
      return;
    }
    this.mEventHandler = null;
  }
  
  private void onRecvRequest(int paramInt, NativeEventParams paramNativeEventParams)
  {
    byte[] arrayOfByte1 = paramNativeEventParams.detail;
    int i = (int)paramNativeEventParams.extraParam0;
    String str1 = paramNativeEventParams.extraParam2;
    int j = paramNativeEventParams.extraParam3;
    int k = paramNativeEventParams.extraParam4;
    if (k == 3124) {
      i = 26;
    }
    String str2 = CharacterUtil.asUnsignedDecimalString(paramNativeEventParams.fromUin);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (i)
    {
    default: 
      localObject1 = localObject2;
    case 1: 
    case 2: 
    case 3: 
    case 6: 
    case 7: 
    case 11: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 28: 
      if ((paramInt == 2) || (paramInt == 60)) {
        this.mEventListener.onRequestVideo(i, str2, (String)localObject1, paramNativeEventParams.extraBuf, true, str1, j, k);
      }
      break;
    }
    while ((paramInt != 1) && (paramInt != 61))
    {
      return;
      localObject1 = null;
      break;
      localObject1 = localObject2;
      if (arrayOfByte1 == null) {
        break;
      }
      int m = arrayOfByte1[0];
      localObject1 = null;
      Object localObject3 = localObject1;
      if (arrayOfByte1.length > m + 1)
      {
        byte[] arrayOfByte2 = new byte[m];
        localObject3 = localObject1;
        if (arrayOfByte2 != null)
        {
          System.arraycopy(arrayOfByte1, 1, arrayOfByte2, 0, m);
          localObject3 = new String(arrayOfByte2);
        }
      }
      int n = arrayOfByte1[(m + 1)];
      localObject1 = localObject2;
      if (arrayOfByte1.length <= m + n + 2) {
        break;
      }
      localObject2 = new byte[n];
      localObject1 = null;
      if (localObject2 != null)
      {
        System.arraycopy(arrayOfByte1, m + 2, localObject2, 0, n);
        localObject1 = new String((byte[])localObject2);
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (localObject3 != null) {
          localObject2 = (String)localObject3 + (String)localObject1;
        }
      }
      localObject1 = localObject2;
      break;
      localObject1 = String.valueOf(paramNativeEventParams.extraParam1);
      break;
    }
    this.mEventListener.onRequestVideo(i, str2, (String)localObject1, paramNativeEventParams.extraBuf, false, str1, j, k);
  }
  
  private String queryCameraParameters()
  {
    try
    {
      String str = DEFAULT_CAMERA_PREVIEW_PARAM;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private native void sendTransferMsg(long paramLong, int paramInt, byte[] paramArrayOfByte);
  
  private void setCarrierType(long paramLong)
  {
    setCarrierType(paramLong, this.mMcc, this.mMnc);
  }
  
  private native int setGatewayTestResult(int paramInt1, int paramInt2, int paramInt3);
  
  private native int setupDeviceInfos(String paramString);
  
  public String GetManufacture()
  {
    return Build.MANUFACTURER;
  }
  
  public String GetOsName()
  {
    return Build.VERSION.RELEASE;
  }
  
  public String GetRomInfo()
  {
    return Build.VERSION.INCREMENTAL;
  }
  
  public native int PauseVideo(long paramLong);
  
  public native boolean QuaReport(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
  
  public native int ResumeVideo(long paramLong);
  
  public native void SetAudioDataSendByDefault(boolean paramBoolean);
  
  public native void SetAudioDataSink(boolean paramBoolean);
  
  public int SetNetIPAndPort(String paramString, int paramInt)
  {
    return setNetIpAndPort(paramString, paramInt);
  }
  
  public native int SetOutputFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public int UpdateSelfUin(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.parseBigIntegerPositive(paramString);
      return setSelfUin(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  native int accept(long paramLong, int paramInt1, int paramInt2);
  
  public int acceptVideo(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      paramLong = CharacterUtil.parseBigIntegerPositive(paramString);
      setApType(paramInt1);
      paramInt1 = accept(paramLong, paramInt2, paramInt3);
      setCarrierType(paramLong);
      return paramInt1;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  native int acceptVideoMode(long paramLong);
  
  public int acceptVideoMode(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.parseBigIntegerPositive(paramString);
      return acceptVideoMode(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  native int cancelVideoMode(long paramLong);
  
  public int cancelVideoMode(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.parseBigIntegerPositive(paramString);
      return cancelVideoMode(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  native int close(long paramLong, int paramInt);
  
  public int closeVideo(String paramString, int paramInt)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.parseBigIntegerPositive(paramString);
      paramInt = close(l, paramInt);
      setCarrierType(l);
      return paramInt;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  public byte[] createTLVpackage(long paramLong, String paramString, byte paramByte, int paramInt)
  {
    int i3 = 0;
    try
    {
      paramString = paramString.getBytes("utf-8");
      i4 = paramString.length;
      i3 = i4;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i4;
        byte[] arrayOfByte;
        int i;
        int j;
        int k;
        int m;
        int n;
        int i1;
        int i2;
        paramString = new byte[0];
      }
    }
    arrayOfByte = new byte[6 + (i3 + 12 + 3 + 6)];
    arrayOfByte[0] = 1;
    i4 = 0 + 1;
    arrayOfByte[i4] = 1;
    i4 += 1;
    arrayOfByte[i4] = 1;
    i4 += 1;
    arrayOfByte[i4] = 2;
    i4 += 1;
    arrayOfByte[i4] = 1;
    i4 += 1;
    arrayOfByte[i4] = 1;
    i4 += 1;
    arrayOfByte[i4] = 3;
    i4 += 1;
    arrayOfByte[i4] = 8;
    i4 += 1;
    i = (byte)(int)(0xFF & paramLong);
    j = (byte)(int)(paramLong >> 8 & 0xFF);
    k = (byte)(int)(paramLong >> 16 & 0xFF);
    m = (byte)(int)(paramLong >> 24 & 0xFF);
    n = (byte)(int)(paramLong >> 32 & 0xFF);
    i1 = (byte)(int)(paramLong >> 40 & 0xFF);
    i2 = (byte)(int)(paramLong >> 48 & 0xFF);
    System.arraycopy(new byte[] { (byte)(int)(paramLong >> 56 & 0xFF), i2, i1, n, m, k, j, i }, 0, arrayOfByte, i4, 8);
    i4 += 8;
    arrayOfByte[i4] = 4;
    i4 += 1;
    arrayOfByte[i4] = ((byte)i3);
    if (i3 > 0) {
      System.arraycopy(paramString, 0, arrayOfByte, i4 + 1, 8);
    }
    i3 += 18;
    arrayOfByte[i3] = 5;
    i3 += 1;
    arrayOfByte[i3] = 1;
    i3 += 1;
    arrayOfByte[i3] = paramByte;
    i3 += 1;
    arrayOfByte[i3] = 6;
    i3 += 1;
    arrayOfByte[i3] = 4;
    i3 += 1;
    paramByte = (byte)(paramInt & 0xFF);
    i = (byte)(paramInt >> 8 & 0xFF);
    j = (byte)(paramInt >> 16 & 0xFF);
    System.arraycopy(new byte[] { (byte)(paramInt >> 24 & 0xFF), j, i, paramByte }, 0, arrayOfByte, i3, 4);
    return arrayOfByte;
  }
  
  native int doQuaReport(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  public native boolean enableLoopback(boolean paramBoolean);
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      uninit();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  native int getBusiTypeFromCmdPkg(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt);
  
  public int getCameraFacing()
  {
    return VcSystemInfo.getCameraFacing();
  }
  
  public native long getChatRoomID(long paramLong);
  
  native int getCmdTypeFromCmdPkg(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt);
  
  public int getCpuArchitecture()
  {
    return VcSystemInfo.getCpuArchitecture();
  }
  
  public int getCpuMaxFrequency()
  {
    return (int)VcSystemInfo.getMaxCpuFreq();
  }
  
  public String getDeviceName()
  {
    return VcSystemInfo.getDeviceName();
  }
  
  public int getDispHeight()
  {
    return VcSystemInfo.sDisplayHeight;
  }
  
  public int getDispWidth()
  {
    return VcSystemInfo.sDisplayWidth;
  }
  
  public native int getEncodeFrameFunctionPtrFunPtr();
  
  native byte[] getInterestingString(long paramLong);
  
  public byte[] getInterestingString(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.parseBigIntegerPositive(paramString);
      return getInterestingString(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.e("VcControllerImpl", paramString.getMessage());
    }
    return null;
  }
  
  public int getNumCores()
  {
    return VcSystemInfo.getNumCores();
  }
  
  public native int getOnPeerFrameRenderEndFunctionPtr();
  
  public int getOsType()
  {
    return VcSystemInfo.getOsType();
  }
  
  native int getPeerSdkVersion(long paramLong);
  
  native int getPeerTerminalType(long paramLong);
  
  public int getPeerTerminalType(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.parseBigIntegerPositive(paramString);
      return getPeerTerminalType(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  public int getScreenHeight()
  {
    return VcSystemInfo.sScreenHeight;
  }
  
  public int getScreenWidth()
  {
    return VcSystemInfo.sScreenWidth;
  }
  
  public native int getSdkVersion();
  
  native long getTrafficSize(long paramLong);
  
  public native int getVolume(boolean paramBoolean);
  
  public native int hasAVShiftAbility(long paramLong);
  
  native int ignore(long paramLong);
  
  public int ignoreVideo(String paramString, int paramInt)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.parseBigIntegerPositive(paramString);
      setApType(paramInt);
      paramInt = ignore(l);
      setCarrierType(l);
      return paramInt;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  public native int init(Context paramContext, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, int paramInt, String paramString12, SDKConfigInfo paramSDKConfigInfo);
  
  public native boolean isEnableLoopback();
  
  public native boolean isEngineActive();
  
  native int notifyAnotherSelfIsRing(long paramLong, boolean paramBoolean);
  
  public int notifyAnotherSelfIsRing(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.parseBigIntegerPositive(paramString);
      return notifyAnotherSelfIsRing(l, paramBoolean);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  public native int notifyAnotherTerChatStatus(long paramLong, int paramInt);
  
  public native int onLogOutByKicked();
  
  public native void onProcessExit();
  
  public native int onRecvVideoCallBytesForSharp(byte[] paramArrayOfByte);
  
  public native int onRecvVideoCallBytesForSharpC2SACK(byte[] paramArrayOfByte);
  
  native int onRecvVideoCloudConfig(byte[] paramArrayOfByte);
  
  native byte[] postData(long paramLong, byte[] paramArrayOfByte);
  
  public native AVPbInfo processQCallPush(byte[] paramArrayOfByte, AVPbInfo paramAVPbInfo);
  
  public DeviceCMDTLV receiveTransferMsg(String paramString, byte[] paramArrayOfByte)
  {
    return unpackTLV(paramArrayOfByte);
  }
  
  public native int registerDAudioDataCallback(int paramInt, boolean paramBoolean);
  
  native int reject(long paramLong, int paramInt);
  
  public int rejectVideo(String paramString, int paramInt1, int paramInt2)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.parseBigIntegerPositive(paramString);
      setApType(paramInt1);
      paramInt1 = reject(l, paramInt2);
      setCarrierType(l);
      return paramInt1;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  native int rejectVideoMode(long paramLong);
  
  public int rejectVideoMode(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.parseBigIntegerPositive(paramString);
      return rejectVideoMode(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  native int request(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  native int requestByMobileNo(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, byte[] paramArrayOfByte, String paramString4, int paramInt4, int paramInt5);
  
  native int requestFromQQToUnQQ(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString, int paramInt3);
  
  native int requestFromTempChat(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt4, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6);
  
  native int requestReConnect(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
  
  native int requestSharp(long paramLong, int paramInt1, int paramInt2);
  
  native int requestSwitchTerminal(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
  
  native int requestUnQQ(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public int requestVideo(String paramString1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, String paramString2, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return -1;
    }
    for (;;)
    {
      try
      {
        long l = CharacterUtil.parseBigIntegerPositive(paramString1);
        setApType(paramInt1);
        if (paramInt3 == 1)
        {
          changeBusyType(paramInt2);
          paramInt1 = requestFromQQToUnQQ(l, paramInt2, paramInt3, paramArrayOfByte, paramString2, paramInt4);
          setCarrierType(l);
          return paramInt1;
        }
      }
      catch (NumberFormatException paramString1)
      {
        return -1;
      }
    }
  }
  
  public int requestVideo(String paramString1, long paramLong1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, int paramInt4, String paramString5, String paramString6, long paramLong2, byte[] paramArrayOfByte, String paramString7, String paramString8, String paramString9, int paramInt5, int paramInt6)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "0";
    }
    paramString1 = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      paramString1 = "0";
    }
    paramString5 = paramString6;
    if (TextUtils.isEmpty(paramString6)) {
      paramString5 = "0";
    }
    paramString6 = paramString7;
    if (TextUtils.isEmpty(paramString7)) {
      paramString6 = "";
    }
    paramString7 = paramString8;
    if (TextUtils.isEmpty(paramString8)) {
      paramString7 = "";
    }
    long l1;
    long l2;
    try
    {
      paramLong1 = CharacterUtil.parseBigIntegerPositive(str);
      l1 = Long.parseLong(paramString1);
      l2 = Long.parseLong(paramString5);
      setApType(paramInt1);
      if (paramLong2 != 0L)
      {
        paramInt1 = requestSwitchTerminal(paramLong1, paramInt2, paramInt3, paramLong2);
        setCarrierType(paramLong1);
        return paramInt1;
      }
    }
    catch (NumberFormatException paramString1)
    {
      paramString1.printStackTrace();
      AVLog.e("VcControllerImpl", paramString1.getMessage());
      return -1;
    }
    if ((paramString4 != null) && (paramString4.length() != 0))
    {
      changeBusyType(paramInt2);
      paramInt1 = requestByMobileNo(paramLong1, paramInt2, paramInt3, paramString2, paramString3, paramString4, paramInt4, paramString6.getBytes(), paramString9, paramInt5, paramInt6);
      setCarrierType(paramLong1);
      return paramInt1;
    }
    if (4 == paramInt3) {
      try
      {
        paramInt1 = changeBusyType(paramInt2);
        if ((l1 == 0L) && (l2 == 9L) && (paramInt1 == 1)) {}
        paramInt1 = requestFromTempChat(paramLong1, paramInt2, paramInt3, paramInt4, l1, l2, paramArrayOfByte, paramString6.getBytes(), paramString7.getBytes("utf-8"), 0, null, null, null);
        setCarrierType(paramLong1);
        return paramInt1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1.printStackTrace();
        AVLog.e("VcControllerImpl", paramString1.getMessage());
        return -1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        AVLog.e("VcControllerImpl", paramString1.getMessage());
        return -1;
      }
    }
    try
    {
      changeBusyType(paramInt2);
      paramInt1 = request(paramLong1, paramInt2, paramInt3, paramString6.getBytes(), paramString7.getBytes("utf-8"));
      setCarrierType(paramLong1);
      return paramInt1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
      AVLog.e("VcControllerImpl", paramString1.getMessage());
      return -1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      AVLog.e("VcControllerImpl", paramString1.getMessage());
    }
    return -1;
  }
  
  public int requestVideo(String paramString1, long paramLong1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, int paramInt4, String paramString5, String paramString6, long paramLong2, byte[] paramArrayOfByte, String paramString7, String paramString8, String paramString9, int paramInt5, int paramInt6, String paramString10)
  {
    paramString10 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString10 = "0";
    }
    paramString1 = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      paramString1 = "0";
    }
    paramString5 = paramString6;
    if (TextUtils.isEmpty(paramString6)) {
      paramString5 = "0";
    }
    paramString6 = paramString7;
    if (TextUtils.isEmpty(paramString7)) {
      paramString6 = "";
    }
    paramString7 = paramString8;
    if (TextUtils.isEmpty(paramString8)) {
      paramString7 = "";
    }
    long l1;
    long l2;
    try
    {
      paramLong1 = CharacterUtil.parseBigIntegerPositive(paramString10);
      l1 = Long.parseLong(paramString1);
      l2 = Long.parseLong(paramString5);
      setApType(paramInt1);
      if (paramLong2 != 0L)
      {
        paramInt1 = requestSwitchTerminal(paramLong1, paramInt2, paramInt3, paramLong2);
        setCarrierType(paramLong1);
        return paramInt1;
      }
    }
    catch (NumberFormatException paramString1)
    {
      paramString1.printStackTrace();
      AVLog.e("VcControllerImpl", paramString1.getMessage());
      return -1;
    }
    if ((paramString4 != null) && (paramString4.length() != 0))
    {
      changeBusyType(paramInt2);
      paramInt1 = requestByMobileNo(paramLong1, paramInt2, paramInt3, paramString2, paramString3, paramString4, paramInt4, paramString6.getBytes(), paramString9, paramInt5, paramInt6);
      setCarrierType(paramLong1);
      return paramInt1;
    }
    if (4 == paramInt3)
    {
      if (29 == paramInt4) {}
      try
      {
        paramInt1 = changeBusyType(paramInt2);
        if ((l1 == 0L) && (l2 == 9L) && (paramInt1 == 1)) {}
        paramInt1 = requestFromTempChat(paramLong1, paramInt2, paramInt3, paramInt4, l1, l2, paramArrayOfByte, paramString6.getBytes(), paramString7.getBytes("utf-8"), 1013, null, null, null);
        setCarrierType(paramInt1);
        return paramInt1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1.printStackTrace();
        AVLog.e("VcControllerImpl", paramString1.getMessage());
        return -1;
        paramInt1 = changeBusyType(paramInt2);
        if ((l1 == 0L) && (l2 == 9L) && (paramInt1 == 1)) {}
        paramInt1 = requestFromTempChat(paramLong1, paramInt2, paramInt3, paramInt4, l1, l2, paramArrayOfByte, paramString6.getBytes(), paramString7.getBytes("utf-8"), 0, null, null, null);
        setCarrierType(paramLong1);
        return paramInt1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        AVLog.e("VcControllerImpl", paramString1.getMessage());
        return -1;
      }
    }
    try
    {
      changeBusyType(paramInt2);
      paramInt1 = request(paramLong1, paramInt2, paramInt3, paramString6.getBytes(), paramString7.getBytes("utf-8"));
      setCarrierType(paramLong1);
      return paramInt1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
      AVLog.e("VcControllerImpl", paramString1.getMessage());
      return -1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      AVLog.e("VcControllerImpl", paramString1.getMessage());
    }
    return -1;
  }
  
  native int requestVideoMode(long paramLong);
  
  public int requestVideoMode(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.parseBigIntegerPositive(paramString);
      return requestVideoMode(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  public native int sendAVFunChatMsg(long paramLong, int paramInt, byte[] paramArrayOfByte);
  
  public int sendAVFunChatMsg(String paramString1, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return -1;
    }
    String str = paramString1;
    if (paramString1.startsWith("+")) {
      str = paramString1.substring(1);
    }
    try
    {
      long l = CharacterUtil.parseBigIntegerPositive(str);
      return sendAVFunChatMsg(l, paramInt, paramString2.getBytes());
    }
    catch (NumberFormatException paramString1)
    {
      paramString1.printStackTrace();
      AVLog.e("VcControllerImpl", paramString1.getMessage());
    }
    return -1;
  }
  
  public int sendAVFunChatMsg(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return -1;
    }
    if (TextUtils.isEmpty(paramString))
    {
      AVLog.e("VcControllerImpl", "uin is " + paramString);
      return -1;
    }
    String str = paramString;
    if (paramString.startsWith("+")) {
      str = paramString.substring(1);
    }
    try
    {
      long l = Long.parseLong(str);
      return sendAVFunChatMsg(l, paramInt, paramArrayOfByte);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public native int sendAudioData(byte[] paramArrayOfByte, int paramInt);
  
  public native int sendDTMFMessage(long paramLong, char paramChar);
  
  public native int sendQueryRoomInfoRequest(long paramLong1, long paramLong2);
  
  public native int sendRecordingRequest(long paramLong1, boolean paramBoolean, NetAddr[] paramArrayOfNetAddr, long paramLong2);
  
  public void sendTransferMsg(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      long l = Long.parseLong(paramString);
      sendTransferMsg(l, paramInt1, createTLVpackage(l, "", (byte)paramInt2, paramInt3));
      return;
    }
    catch (Exception paramString) {}
  }
  
  public native int setApType(int paramInt);
  
  public native void setAudioOpt(boolean paramBoolean);
  
  public native int setAudioOutputMode(int paramInt);
  
  public int setAudioSpeakerVolume(int paramInt)
  {
    return 0;
  }
  
  public native void setCarrierType(long paramLong, String paramString1, String paramString2);
  
  native int setGatewayIp(String paramString);
  
  public native int setGroundGlassSwitch(long paramLong, int paramInt);
  
  public int setGroundGlassSwitch(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString.startsWith("+")) {
      str = paramString.substring(1);
    }
    try
    {
      long l = Long.parseLong(str);
      return setGroundGlassSwitch(l, paramInt);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  native int setNetIpAndPort(String paramString, int paramInt);
  
  public native void setProcessDecoderFrameFunctionptr(int paramInt);
  
  native int setProductId(int paramInt);
  
  native int setSelfUin(long paramLong);
  
  public native void setVideoJitterLength(int paramInt);
  
  public native void setVideoReceiver(boolean paramBoolean);
  
  public native int setVoiceType(int paramInt);
  
  public native int startAudioRecv();
  
  public native int startAudioSend();
  
  public native int startVideoSend();
  
  public native int stopAudioRecv();
  
  public native int stopAudioSend();
  
  public native int stopVideoSend();
  
  native int switchAudio(long paramLong);
  
  public int switchAudio(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.parseBigIntegerPositive(paramString);
      int i = switchAudio(l);
      if (i == -1) {
        this.mAudio2VideoFlag = false;
      }
      return i;
    }
    catch (NumberFormatException paramString) {}
    return -1;
  }
  
  native int switchVideo(long paramLong);
  
  public int switchVideo(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.parseBigIntegerPositive(paramString);
      int i = switchVideo(l);
      if (i == -1) {
        this.mAudio2VideoFlag = false;
      }
      return i;
    }
    catch (NumberFormatException paramString) {}
    return -1;
  }
  
  public native int uninit();
  
  public DeviceCMDTLV unpackTLV(byte[] paramArrayOfByte)
  {
    Object localObject = "";
    byte[] arrayOfByte = new byte[8];
    System.arraycopy(paramArrayOfByte, 8, arrayOfByte, 0, 8);
    long l1 = arrayOfByte[0];
    long l2 = arrayOfByte[1];
    long l3 = arrayOfByte[2];
    long l4 = arrayOfByte[3];
    long l5 = arrayOfByte[4];
    long l6 = arrayOfByte[5];
    long l7 = arrayOfByte[6];
    long l8 = arrayOfByte[7];
    int i = 8 + 8 + 1;
    int k = paramArrayOfByte[i];
    int j = i + 1;
    i = j;
    if (k > 0)
    {
      localObject = new byte[k];
      System.arraycopy(paramArrayOfByte, j, localObject, 0, k);
    }
    try
    {
      localObject = new String((byte[])localObject, "utf-8");
      i = k + 18;
      j = i + 2;
      i = paramArrayOfByte[j];
      arrayOfByte = new byte[4];
      System.arraycopy(paramArrayOfByte, j + 1 + 2, arrayOfByte, 0, 4);
      j = arrayOfByte[3];
      k = arrayOfByte[2];
      int m = arrayOfByte[1];
      int n = arrayOfByte[0];
      paramArrayOfByte = new DeviceCMDTLV();
      paramArrayOfByte.uin = ((l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8 | (l8 & 0xFF) << 0);
      paramArrayOfByte.nickname = ((String)localObject);
      paramArrayOfByte.operation = i;
      paramArrayOfByte.opvalue = (j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16 | (n & 0xFF) << 24);
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        String str = "";
      }
    }
  }
  
  public native int unregisterDAudioDataCallback(int paramInt, boolean paramBoolean);
  
  public native int unregisterDAudioDataCallbackAll();
  
  public native int updateConfigInfo();
  
  public native int updateNetworkTestResult(long paramLong, int paramInt);
  
  public native int updateProcessInfo(long paramLong, String paramString1, String paramString2);
  
  public class DeviceCMDTLV
  {
    String nickname;
    public int operation;
    public int opvalue;
    public long uin;
    
    public DeviceCMDTLV() {}
  }
  
  private class NativeEventHandler
    extends Handler
  {
    private static final String TAG_HANDLER = "VcControllerImpl_NativeEventHandler";
    
    public NativeEventHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i;
      byte[] arrayOfByte1;
      long l;
      String str;
      for (;;)
      {
        byte[] arrayOfByte2;
        try
        {
          i = paramMessage.what;
          paramMessage = (VcControllerImpl.NativeEventParams)paramMessage.obj;
          if (paramMessage == null)
          {
            AVLog.e("VcControllerImpl_NativeEventHandler", "p is null");
            return;
          }
          arrayOfByte1 = paramMessage.detail;
          l = paramMessage.info;
          str = CharacterUtil.asUnsignedDecimalString(paramMessage.fromUin);
          arrayOfByte2 = paramMessage.extraBuf;
          if ((i == 16) || (i == 100) || (i == 117)) {
            break;
          }
          AVLog.d("VcControllerImpl_NativeEventHandler", "handleMessage eventId: " + i + ", info: " + l + ", fromUin:" + str);
        }
        finally {}
        VcControllerImpl.this.onRecvRequest(i, paramMessage);
        continue;
        VcControllerImpl.this.mEventListener.onAcceptedVideo(str);
        continue;
        if (l > 1000L) {
          VcControllerImpl.access$202(VcControllerImpl.this, true);
        }
        for (;;)
        {
          VcControllerImpl.this.mEventListener.onChannelReady(str);
          break;
          VcControllerImpl.access$202(VcControllerImpl.this, false);
        }
        if (l == 1L)
        {
          VcControllerImpl.this.mEventListener.onNetworkMonitorInfo(str, arrayOfByte1, 1L, arrayOfByte2);
        }
        else
        {
          VcControllerImpl.this.mEventListener.onNetworkMonitorInfo(str, arrayOfByte1, 0L, null);
          continue;
          label248:
          VcControllerImpl.this.mEventListener.onCloseVideo(str, i, paramMessage.extraParam0);
          continue;
          VcControllerImpl.this.mEventListener.onNetworkDisconnect(str);
          continue;
          VcControllerImpl.this.mEventListener.onCloseVideo(str, 12, 0L);
          continue;
          VcControllerImpl.this.mEventListener.onPauseVideo(str);
          continue;
          VcControllerImpl.this.mEventListener.onResumeVideo(str);
          continue;
          VcControllerImpl.this.mEventListener.onPauseAudio(str);
          continue;
          VcControllerImpl.this.mEventListener.onResumeAudio(str);
          continue;
          VcControllerImpl.this.mEventListener.onAnotherHaveAccept(str);
          continue;
          VcControllerImpl.this.mEventListener.onAnotherHaveReject(str);
          continue;
          VcControllerImpl.this.mEventListener.onConfigSysDealDone(str);
          continue;
          VcControllerImpl.this.mEventListener.onAVShiftEvent(i - 19, str);
          continue;
          VcControllerImpl.this.mEventListener.onAnotherIsRing(str, true);
          continue;
          VcControllerImpl.this.mEventListener.onAnotherIsRing(str, false);
          continue;
          VcControllerImpl.this.mEventListener.onRequestVideoMode(str);
          continue;
          VcControllerImpl.this.mEventListener.onAcceptVideoMode(str);
          continue;
          VcControllerImpl.this.mEventListener.onRejectVideoMode(str);
          continue;
          VcControllerImpl.this.mEventListener.onCancelVideoMode(str);
          continue;
          VcControllerImpl.this.mEventListener.onNotRecvAudioData(true);
          continue;
          VcControllerImpl.this.mEventListener.onNotRecvAudioData(false);
          continue;
          VcControllerImpl.this.mEventListener.onRecvFirstAudioData(true);
          continue;
          VcControllerImpl.this.mEventListener.onMediaCameraNotify(arrayOfByte1, l);
          continue;
          VcControllerImpl.this.mEventListener.onReceiveFirstVideoFrame(str);
          continue;
          VcControllerImpl.this.mEventListener.onPstnCallConnected(str, (int)l, paramMessage.extraParam0, paramMessage.detail);
          continue;
          VcControllerImpl.this.mEventListener.onInviteReached(str, (int)l, paramMessage.extraParam0, paramMessage.detail);
          continue;
          VcControllerImpl.this.mEventListener.onNetworkInfo_S2C(str, arrayOfByte1, l);
          continue;
          VcControllerImpl.this.mEventListener.onSwitchGroup(str, arrayOfByte1, l);
          continue;
          switch ((int)paramMessage.extraParam0)
          {
          default: 
            label756:
            VcControllerImpl.this.mEventListener.onOtherTerminalChatingStatus(str, paramMessage.extraParam1, i);
            continue;
            VcControllerImpl.this.mEventListener.onPeerSwitchTerninal(str);
            continue;
            VcControllerImpl.this.mEventListener.onSyncOtherTerminalChatStatus(str, (int)l);
            continue;
            VcControllerImpl.this.mEventListener.onSwitchTerminalSuccess(str, (int)l);
            continue;
            VcControllerImpl.this.mEventListener.onPeerSwitchTerminalFail(str, (int)l);
            continue;
            VcControllerImpl.this.mEventListener.onSendC2CMsg(str);
            VcControllerImpl.this.mEventListener.onDetectAudioDataIssue(2048);
            continue;
            VcControllerImpl.this.mEventListener.onDetectAudioDataIssue(3);
            continue;
            VcControllerImpl.this.mEventListener.onDetectAudioDataIssue(4);
            continue;
            VcControllerImpl.this.mEventListener.onNetLevel_S2C(str, l, arrayOfByte1);
            continue;
            VcControllerImpl.this.mEventListener.receiveTransferMsg(str, (int)l, paramMessage.detail);
          }
        }
      }
      for (;;)
      {
        VcControllerImpl.this.mEventListener.onReceiveC2CMsg(str, (int)l, arrayOfByte1);
        break;
        VcControllerImpl.this.mEventListener.onReceiveSubtitleChanged((int)l, new String(arrayOfByte1));
        break;
        VcControllerImpl.this.mEventListener.onReceiveMagicface((int)l, new String(arrayOfByte1));
        break;
        VcControllerImpl.this.mEventListener.onReceiveDoodle(arrayOfByte1);
        break;
        VcControllerImpl.this.mEventListener.onReceiveFucMultiMode(new String(arrayOfByte1));
        break;
        VcControllerImpl.this.mEventListener.onReceiveFucMultiVolumeExp(new String(arrayOfByte1));
        break;
        VcControllerImpl.this.mEventListener.onReceiveFucMultiFaceExp(new String(arrayOfByte1));
        break;
        VcControllerImpl.this.mEventListener.onReceiveRecordMsg(str, new String(arrayOfByte1));
        break;
        i = (int)l;
        VcControllerImpl.this.mEventListener.onGroundGlassSwitch(str, i);
        break;
        i = (int)l;
        VcControllerImpl.this.mEventListener.onGroundGlassWaitTimeChange(str, i);
        break;
        i = (int)l;
        VcControllerImpl.this.mEventListener.onFpsChange(i);
        break;
        VcControllerImpl.this.mEventListener.onSDKCustomCommand(str, paramMessage.extraParam0, paramMessage.extraParam1, paramMessage.extraParam4);
        break;
        VcControllerImpl.this.mEventListener.checkNetStatus();
        break;
        switch (i)
        {
        case 71: 
        case 93: 
        case 96: 
        case 1: 
        case 2: 
        case 60: 
        case 61: 
        case 3: 
        case 6: 
        case 16: 
        case 24: 
        case 8: 
        case 10: 
        case 7: 
        case 9: 
        case 13: 
        case 14: 
        case 18: 
        case 19: 
        case 20: 
        case 21: 
        case 22: 
        case 25: 
        case 26: 
        case 105: 
        case 106: 
        case 107: 
        case 108: 
        case 62: 
        case 63: 
        case 64: 
        case 65: 
        case 66: 
        case 95: 
        case 68: 
        case 67: 
        case 69: 
        case 72: 
        case 73: 
        case 75: 
        case 74: 
        case 76: 
        case 83: 
        case 91: 
        case 92: 
        case 100: 
        case 110: 
        case 113: 
        case 114: 
        case 116: 
        case 119: 
        case 118: 
        case 5: 
        case 11: 
        case 12: 
        case 15: 
        case 17: 
        case 23: 
        case 27: 
        case 28: 
        case 29: 
        case 30: 
        case 31: 
        case 32: 
        case 33: 
        case 34: 
        case 35: 
        case 36: 
        case 37: 
        case 38: 
        case 39: 
        case 40: 
        case 41: 
        case 42: 
        case 43: 
        case 44: 
        case 45: 
        case 46: 
        case 47: 
        case 48: 
        case 49: 
        case 50: 
        case 51: 
        case 52: 
        case 53: 
        case 54: 
        case 55: 
        case 56: 
        case 57: 
        case 58: 
        case 59: 
        case 70: 
        case 77: 
        case 78: 
        case 79: 
        case 80: 
        case 81: 
        case 82: 
        case 84: 
        case 85: 
        case 86: 
        case 87: 
        case 88: 
        case 89: 
        case 90: 
        case 94: 
        case 97: 
        case 98: 
        case 99: 
        case 101: 
        case 102: 
        case 103: 
        case 104: 
        case 109: 
        case 112: 
        case 115: 
        case 117: 
        default: 
          break;
        case 4: 
          i = (int)l;
          switch (i)
          {
          }
          break label248;
          i = 0;
          break label756;
          i = 2;
          break label756;
          i = 1;
          break;
        case 111: 
          switch ((int)l)
          {
          }
          break;
        }
      }
    }
  }
  
  private class NativeEventParams
  {
    public byte[] detail;
    public byte[] extraBuf;
    public long extraParam0;
    public long extraParam1;
    public String extraParam2;
    public int extraParam3;
    public int extraParam4;
    public long fromUin;
    public long info;
    
    private NativeEventParams() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.core.VcControllerImpl
 * JD-Core Version:    0.7.0.1
 */
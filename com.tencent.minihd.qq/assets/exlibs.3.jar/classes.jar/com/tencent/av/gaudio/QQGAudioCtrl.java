package com.tencent.av.gaudio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.config.Common;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.mediacodec.AndroidCodec;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qav.log.AVLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import tencent.im.groupvideo.memposinfo.memposinfo.AccountExtInfo;
import tencent.im.groupvideo.memposinfo.memposinfo.AccountExtInfoList;
import tencent.im.groupvideo.memposinfo.memposinfo.CommonInfo;

public class QQGAudioCtrl
{
  static final int EM_SDK_EVENT_ID_ALL_CAN_GO_ON_STAGE = 103;
  static final int EM_SDK_EVENT_ID_ALL_MEM_UPDATE = 44;
  static final int EM_SDK_EVENT_ID_ALL_ONLINE_NOTICE = 16;
  static final int EM_SDK_EVENT_ID_CAMERAQOS_FPS_CHANGE = 171;
  static final int EM_SDK_EVENT_ID_CHANGE_MIC_ORDER = 151;
  static final int EM_SDK_EVENT_ID_CONN_TIMEOUT = 39;
  static final int EM_SDK_EVENT_ID_CREATE_FAIL = 31;
  static final int EM_SDK_EVENT_ID_CREATE_ROOM_FAILED = 138;
  static final int EM_SDK_EVENT_ID_CREATE_SUC = 30;
  static final int EM_SDK_EVENT_ID_CREATE_TIMEOUT = 32;
  static final int EM_SDK_EVENT_ID_DESTORY = 11;
  static final int EM_SDK_EVENT_ID_DETECT_USER_AUDIO_HOWLING = 153;
  static final int EM_SDK_EVENT_ID_DETECT_USER_AUDIO_NOISY = 145;
  static final int EM_SDK_EVENT_ID_ENTER_FAIL = 34;
  static final int EM_SDK_EVENT_ID_ENTER_ROOM_FAILED = 139;
  static final int EM_SDK_EVENT_ID_ENTER_SUC = 33;
  static final int EM_SDK_EVENT_ID_ENTER_TIMEOUT = 35;
  static final int EM_SDK_EVENT_ID_GET_MUL_ROOM_INFO = 9;
  static final int EM_SDK_EVENT_ID_GET_ROOM_INFO = 8;
  static final int EM_SDK_EVENT_ID_GO_OFF_STAGE_FAIL = 94;
  static final int EM_SDK_EVENT_ID_GO_OFF_STAGE_SUC = 93;
  static final int EM_SDK_EVENT_ID_GO_OFF_STAGE_TIMEOUT = 95;
  static final int EM_SDK_EVENT_ID_GO_ON_STAGE_FAIL = 91;
  static final int EM_SDK_EVENT_ID_GO_ON_STAGE_SUC = 90;
  static final int EM_SDK_EVENT_ID_GO_ON_STAGE_TIMEOUT = 92;
  static final int EM_SDK_EVENT_ID_GROUP_VIDEO_MODE_FREE_MODE = 107;
  static final int EM_SDK_EVENT_ID_GROUP_VIDEO_MODE_MIC_ORDER_MODE = 108;
  static final int EM_SDK_EVENT_ID_GROUP_VIDEO_SRC_TYPE_CHANGE = 109;
  static final int EM_SDK_EVENT_ID_HAS_GETTED_SHARP_CONFIG_PAYLOAD = 123;
  static final int EM_SDK_EVENT_ID_KickOut_FAIL = 22;
  static final int EM_SDK_EVENT_ID_KickOut_SUC = 21;
  static final int EM_SDK_EVENT_ID_MEETINGCONTROLMODE_CHANGE = 142;
  static final int EM_SDK_EVENT_ID_MEM_AUDIO_IN = 141;
  static final int EM_SDK_EVENT_ID_MEM_AUDIO_OUT = 140;
  static final int EM_SDK_EVENT_ID_MEM_BAN_AUDIO = 74;
  static final int EM_SDK_EVENT_ID_MEM_CANCEL_BAN_AUDIO = 75;
  static final int EM_SDK_EVENT_ID_MEM_GET_OUT = 71;
  static final int EM_SDK_EVENT_ID_MEM_KICKED_OUT = 45;
  static final int EM_SDK_EVENT_ID_MEM_POS_CHANGE = 80;
  static final int EM_SDK_EVENT_ID_MEM_PPT_IN = 76;
  static final int EM_SDK_EVENT_ID_MEM_PPT_OUT = 77;
  static final int EM_SDK_EVENT_ID_MEM_SCREEN_IN = 78;
  static final int EM_SDK_EVENT_ID_MEM_SCREEN_OUT = 79;
  static final int EM_SDK_EVENT_ID_MEM_VIDEO_IN = 72;
  static final int EM_SDK_EVENT_ID_MEM_VIDEO_OUT = 73;
  static final int EM_SDK_EVENT_ID_MICOFFBYSELF_NOTIFY = 157;
  static final int EM_SDK_EVENT_ID_MICONBYADMINFAIL_NOTIFY = 158;
  static final int EM_SDK_EVENT_ID_NEW_GET_IN = 70;
  static final int EM_SDK_EVENT_ID_NEW_SPEAKING = 42;
  static final int EM_SDK_EVENT_ID_OFFLINE_RECV_INVITE = 5;
  static final int EM_SDK_EVENT_ID_OLD_STOP_SPEAKING = 43;
  static final int EM_SDK_EVENT_ID_ONLINE_NOTICE = 13;
  static final int EM_SDK_EVENT_ID_ONLY_MANAGER_CAN_GO_ON_STAGE = 102;
  static final int EM_SDK_EVENT_ID_ONLY_MANAGER_STAGER_CAN_SPEAK = 104;
  static final int EM_SDK_EVENT_ID_OTHER_TERM_ENTER = 12;
  static final int EM_SDK_EVENT_ID_PBInvite_Rsp = 20;
  static final int EM_SDK_EVENT_ID_PBInvite_Rsp_CALL_BACK = 24;
  static final int EM_SDK_EVENT_ID_PLAY_MEDIA_FILE = 105;
  static final int EM_SDK_EVENT_ID_PPT_UPLOAD_STATE = 110;
  static final int EM_SDK_EVENT_ID_PROTOCOL_ERR = 7;
  static final int EM_SDK_EVENT_ID_PSTN_BILL = 19;
  static final int EM_SDK_EVENT_ID_QUIT_FAIL = 37;
  static final int EM_SDK_EVENT_ID_QUIT_SUC = 36;
  static final int EM_SDK_EVENT_ID_QUIT_TIMEOUT = 38;
  static final int EM_SDK_EVENT_ID_RECV_INVITE = 6;
  static final int EM_SDK_EVENT_ID_RECV_INVITE_SWITCH_FROM_P2PAV = 25;
  static final int EM_SDK_EVENT_ID_RECV_INVITE_SWITCH_FROM_P2PSHARE = 26;
  static final int EM_SDK_EVENT_ID_RECV_MEETING_TIME = 124;
  static final int EM_SDK_EVENT_ID_RECV_NET_TRAFFIC_DATA_SIZE = 50;
  static final int EM_SDK_EVENT_ID_REQUEST_MICDATA = 150;
  static final int EM_SDK_EVENT_ID_ROOM_INFO_CHANGE = 10;
  static final int EM_SDK_EVENT_ID_SEND_EMBED_CHNNEL = 152;
  static final int EM_SDK_EVENT_ID_SEND_NET_TRAFFIC_DATA_SIZE = 51;
  static final int EM_SDK_EVENT_ID_SERVER_REFUSED = 46;
  static final int EM_SDK_EVENT_ID_SETMICBYADMIN_NOTIFY = 143;
  static final int EM_SDK_EVENT_ID_SETMICFAIL_NOTIFY = 144;
  static final int EM_SDK_EVENT_ID_SPEAK_MODE_PRESS_SPEAK = 101;
  static final int EM_SDK_EVENT_ID_START_REMOTE_VIDEO_FAIL = 97;
  static final int EM_SDK_EVENT_ID_START_REMOTE_VIDEO_SUC = 96;
  static final int EM_SDK_EVENT_ID_START_REMOTE_VIDEO_TIMEOUT = 98;
  static final int EM_SDK_EVENT_ID_STOP_PLAY_MEDIA_FILE = 106;
  static final int EM_SDK_EVENT_ID_TOTAL_NET_TRAFFIC_DATA_SIZE = 52;
  static final int EM_SDK_EVENT_ID_VIDEOCHANNEL_CTRL_CHANGE = 172;
  static final int EM_SDK_EVENT_ID_VIDEO_DEC_FRAME_DATA = 61;
  static final int EV_GA_SDK_DETECT_AUDIO_DATA_LESS = 122;
  static final int EV_GA_SDK_DETECT_AUDIO_DATA_NULL = 121;
  private static String SPDEFVALUE = "preview-size-values=320x240,640x480;";
  private static String SPKEY;
  private static String SPNAME = "AV_CameraParameters";
  private static final String TAG = "QQGAudioCtrl";
  private static String mCameraParameters = null;
  private int appid;
  private Context mContext;
  private NativeEventHandler mEventHandler;
  private long mGroupId = 0L;
  public Vector<Long> mInviteGAudioUinList = new Vector();
  public boolean mIsSwitchGroup = false;
  private QQGAudioCtrlCallback mVideoController;
  
  static
  {
    SPKEY = "CP";
  }
  
  public QQGAudioCtrl(Context paramContext)
  {
    this.mContext = paramContext;
    regCallbacks();
    mCameraParameters = this.mContext.getSharedPreferences(SPNAME, 0).getString(SPKEY, SPDEFVALUE);
    int i = AndroidCodec.checkSupportMediaCodecFeature(this.mContext);
    init_deviceinfos(this.mContext, i);
    if (this.mEventHandler == null)
    {
      paramContext = Looper.getMainLooper();
      if (paramContext != null) {
        this.mEventHandler = new NativeEventHandler(paramContext);
      }
    }
    else
    {
      return;
    }
    paramContext = Looper.myLooper();
    if (paramContext != null)
    {
      this.mEventHandler = new NativeEventHandler(paramContext);
      return;
    }
    this.mEventHandler = null;
  }
  
  private native int accept(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  private native int commonRequest(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString, int paramInt7, byte[] paramArrayOfByte);
  
  private ArrayList<AVUserInfo> getAVInfoListFromByte(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      localObject = null;
    }
    int i;
    int j;
    ArrayList localArrayList;
    do
    {
      return localObject;
      if (paramInt == 0) {
        return null;
      }
      i = paramArrayOfByte.length;
      if (i % paramInt != 0) {
        return null;
      }
      j = i / paramInt;
      localArrayList = new ArrayList();
      i = 0;
      localObject = localArrayList;
    } while (i >= j);
    Object localObject = new byte[paramInt];
    System.arraycopy(paramArrayOfByte, i * paramInt, localObject, 0, paramInt);
    localObject = getAVInfoFromByte((byte[])localObject, paramInt);
    if (localObject == null)
    {
      AVLog.e("QQGAudioCtrl", "Can not get AVUserInfo...Error");
      return null;
    }
    if ((((AVUserInfo)localObject).accountType == 1) && (((AVUserInfo)localObject).pstnStatus != 3)) {}
    for (;;)
    {
      i += 1;
      break;
      localArrayList.add(localObject);
    }
  }
  
  private ArrayList<AVUserInfo> getAVInfoListFromByte2(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject3 = null;
    AVUserInfo localAVUserInfo = null;
    Object localObject2 = localObject3;
    if (paramArrayOfByte != null)
    {
      localObject1 = localAVUserInfo;
      localObject2 = localObject3;
      label161:
      for (;;)
      {
        label69:
        try
        {
          if (paramArrayOfByte.length == paramInt)
          {
            localObject1 = localAVUserInfo;
            localObject2 = new memposinfo.AccountExtInfoList();
            localObject1 = localAVUserInfo;
            ((memposinfo.AccountExtInfoList)localObject2).mergeFrom(paramArrayOfByte);
            localObject1 = localAVUserInfo;
            localObject2 = ((memposinfo.AccountExtInfoList)localObject2).msg_account_ext_info.get().iterator();
            paramArrayOfByte = null;
          }
        }
        catch (Exception paramArrayOfByte) {}
      }
    }
    try
    {
      if (!((Iterator)localObject2).hasNext()) {
        return paramArrayOfByte;
      }
      localObject1 = (memposinfo.AccountExtInfo)((Iterator)localObject2).next();
      if (!((memposinfo.AccountExtInfo)localObject1).msg_common_info.has()) {
        break label202;
      }
      localObject1 = (memposinfo.CommonInfo)((memposinfo.AccountExtInfo)localObject1).msg_common_info.get();
      localAVUserInfo = new AVUserInfo();
      localAVUserInfo.account = ((memposinfo.CommonInfo)localObject1).uint64_account.get();
      localAVUserInfo.openId = ((memposinfo.CommonInfo)localObject1).bytes_account.get().toStringUtf8();
      if (paramArrayOfByte != null) {
        break label199;
      }
      localObject1 = new ArrayList();
      paramArrayOfByte = (byte[])localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = paramArrayOfByte;
        paramArrayOfByte = localException;
      }
      break label161;
      break label170;
    }
    Object localObject1 = paramArrayOfByte;
    paramArrayOfByte.add(localAVUserInfo);
    label170:
    break label69;
    AVLog.e("QQGAudioCtrl", "getAVInfoListFromByte2 fail.", paramArrayOfByte);
    localObject2 = localObject1;
    return localObject2;
    label199:
    label202:
    return paramArrayOfByte;
  }
  
  private int getIntFromByte(byte[] paramArrayOfByte)
  {
    int j = 0;
    int i = 0;
    while (i < 4)
    {
      j |= (paramArrayOfByte[(3 - i)] & 0xFF) << (3 - i) * 4;
      i += 1;
    }
    return j;
  }
  
  private long[] getUinListFromBuf(byte[] paramArrayOfByte)
  {
    long[] arrayOfLong2 = null;
    long[] arrayOfLong1 = arrayOfLong2;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length >= 8) {
        break label25;
      }
      arrayOfLong1 = arrayOfLong2;
    }
    label25:
    int i;
    do
    {
      return arrayOfLong1;
      i = paramArrayOfByte.length;
      arrayOfLong1 = arrayOfLong2;
    } while (i % 8 != 0);
    arrayOfLong2 = new long[i / 8];
    byte[] arrayOfByte = new byte[8];
    int j = 0;
    for (;;)
    {
      arrayOfLong1 = arrayOfLong2;
      if (i < 8) {
        break;
      }
      System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, 8);
      long l = getLongFromByte(arrayOfByte);
      arrayOfLong1 = arrayOfLong2;
      if (l == 0L) {
        break;
      }
      arrayOfLong2[(j / 8)] = l;
      j += 8;
      i -= 8;
    }
  }
  
  private void init_deviceinfos(Context paramContext, int paramInt)
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
    paramContext = paramContext.getApplicationInfo();
    str = str + "DATADIR=" + paramContext.dataDir + ";";
    if (Build.VERSION.SDK_INT >= 9)
    {
      paramContext = str + "LIBDIR=" + paramContext.nativeLibraryDir + ";";
      if (paramInt <= 0) {
        break label866;
      }
      if ((paramInt & 0x1) != 1) {
        break label770;
      }
      paramContext = paramContext + "HWAVCDEC=1;";
      label592:
      if ((paramInt & 0x2) != 2) {
        break label794;
      }
      paramContext = paramContext + "HWAVCENC=1;";
      label620:
      if ((paramInt & 0x4) != 4) {
        break label818;
      }
      paramContext = paramContext + "HWHEVCDEC=1;";
      label648:
      if ((paramInt & 0x8) != 8) {
        break label842;
      }
      paramContext = paramContext + "HWHEVCENC=1;";
      label678:
      if (1 != 0) {
        break label953;
      }
      paramContext = paramContext + "SHARP_VIDEO=0;";
    }
    for (;;)
    {
      AVLog.d("QQGAudioCtrl", "init_deviceinfos --> PhoneInfo = " + paramContext);
      setandroidapppath(paramContext);
      return;
      paramContext = str + "LIBDIR=" + paramContext.dataDir + "/lib;";
      break;
      label770:
      paramContext = paramContext + "HWAVCDEC=0;";
      break label592;
      label794:
      paramContext = paramContext + "HWAVCENC=0;";
      break label620;
      label818:
      paramContext = paramContext + "HWHEVCDEC=0;";
      break label648;
      label842:
      paramContext = paramContext + "HWHEVCENC=0;";
      break label678;
      label866:
      paramContext = paramContext + "HWAVCENC=0;";
      paramContext = paramContext + "HWAVCDEC=0;";
      paramContext = paramContext + "HWHEVCENC=0;";
      paramContext = paramContext + "HWHEVCDEC=0;";
      break label678;
      label953:
      if (VcSystemInfo.getCpuArchitecture() > 2) {
        paramContext = paramContext + "SHARP_VIDEO=1;";
      } else {
        paramContext = paramContext + "SHARP_VIDEO=2;";
      }
    }
  }
  
  private void onRecvDoubleVideoMeeting(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.mVideoController == null) {
      AVLog.e("QQGAudioCtrl", "onRecvDoubleVideoMeeting-->mVideoController is null");
    }
    do
    {
      return;
      AVLog.d("QQGAudioCtrl", "onRecvDoubleVideoMeeting-->eventId=" + paramInt1 + " ,relationType=" + paramInt2 + " ,inviteUin=" + paramLong);
      if (paramInt1 == 6)
      {
        this.mVideoController.onDoubleVideoMeetingInvite(paramLong);
        return;
      }
    } while ((paramInt1 == 44) || (paramInt1 != 5));
  }
  
  private void onRecvUserList(int paramInt1, int paramInt2, long paramLong1, ArrayList<AVUserInfo> paramArrayList, long paramLong2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.mVideoController == null) {
      AVLog.e("QQGAudioCtrl", "onRecvUserList --> mVideoController is null");
    }
    do
    {
      return;
      AVLog.w("QQGAudioCtrl", "onRecvUserList.GET_ROOM_INFO, evtId[" + paramInt1 + "], relationType[" + paramInt2 + "], relationId[" + paramLong1 + "], inviteUin[" + paramLong2 + "], multiAVType[" + paramInt4 + "], multiSubType[" + paramInt3 + "], userCount[" + paramInt5 + "]");
    } while (paramInt1 != 44);
    this.mVideoController.onGAudioMemAllUpdate(paramLong1, paramArrayList, paramInt4, paramInt5);
  }
  
  private void onRecvUserList(int paramInt1, int paramInt2, long paramLong1, long[] paramArrayOfLong, long paramLong2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.mVideoController == null) {
      AVLog.e("QQGAudioCtrl", "onRecvUserList --> mVideoController is null");
    }
    label186:
    do
    {
      return;
      int i = 0;
      if (paramArrayOfLong != null) {
        i = paramArrayOfLong.length;
      }
      StringBuilder localStringBuilder = new StringBuilder().append("onRecvUserList, evtId[").append(paramInt1).append("], relationType[").append(paramInt2).append("], relationId[").append(paramLong1).append("], inviteUin[").append(paramLong2).append("], multiAVType[").append(paramInt3).append("], multiSubType[").append(paramInt4).append("], userListSize[").append(i).append("], userList[");
      if (paramArrayOfLong != null) {}
      for (boolean bool = true;; bool = false)
      {
        AVLog.w("QQGAudioCtrl", bool + "]");
        if ((paramArrayOfLong == null) && (paramInt2 == 2)) {
          break;
        }
        if (paramInt1 != 44) {
          break label186;
        }
        this.mVideoController.onGAudioMemAllUpdate(paramLong1, paramArrayOfLong, paramInt3, paramInt5);
        return;
      }
      if (paramInt1 == 6)
      {
        this.mVideoController.onGAudioInvite(paramInt2, paramLong1, paramLong2, paramArrayOfLong, false, paramInt3, paramInt4);
        return;
      }
    } while (paramInt1 != 5);
    this.mVideoController.onGAudioInvite(paramInt2, paramLong1, paramLong2, paramArrayOfLong, true, paramInt3, paramInt4);
  }
  
  private void onRecvUserListFail(int paramInt, long paramLong1, long paramLong2)
  {
    AVLog.w("QQGAudioCtrl", "onRecvUserListFail, relationType[" + paramInt + "], relationId[" + paramLong1 + "], errCode[" + paramLong2 + "]");
    this.mVideoController.onGAudioRoomDistroy(paramInt, paramLong1);
  }
  
  /* Error */
  private String queryCameraParameters()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 227	com/tencent/av/gaudio/QQGAudioCtrl:mCameraParameters	Ljava/lang/String;
    //   5: ifnull +11 -> 16
    //   8: getstatic 227	com/tencent/av/gaudio/QQGAudioCtrl:mCameraParameters	Ljava/lang/String;
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: getstatic 225	com/tencent/av/gaudio/QQGAudioCtrl:SPDEFVALUE	Ljava/lang/String;
    //   19: astore_1
    //   20: goto -8 -> 12
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	QQGAudioCtrl
    //   11	9	1	str	String
    //   23	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	23	finally
    //   16	20	23	finally
  }
  
  protected static native void regCallbacks();
  
  private native int request(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public static void setCameraParameters(Context paramContext, String paramString, boolean paramBoolean)
  {
    mCameraParameters = paramString;
    if (paramBoolean)
    {
      paramContext = paramContext.getSharedPreferences(SPNAME, 0).edit();
      paramContext.putString(SPKEY, paramString);
      paramContext.commit();
    }
  }
  
  protected static native void setandroidapppath(String paramString);
  
  private native int stopVideoSend();
  
  private native int updateRoomInfo(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public byte[] GetConfigInfoFromFile()
  {
    return Common.readFile(this.mContext, "VideoConfigInfo");
  }
  
  public native int GetInviteStrategy(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2);
  
  public native int GetOutputFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public String GetSharpConfigPayloadFromFile()
  {
    Object localObject1 = Common.readFile(this.mContext, "SharpConfigPayload");
    if (localObject1 != null)
    {
      String str2 = new String((byte[])localObject1);
      int i = str2.indexOf('|');
      localObject1 = "";
      Object localObject2 = "";
      try
      {
        str1 = str2.substring(0, i);
        localObject1 = str1;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          String str1;
          label66:
          AVLog.e("QQGAudioCtrl", "GetSharpConfigPayloadFromFile fail.", localException1);
        }
      }
      try
      {
        str1 = str2.substring(i + 1);
        localObject2 = str1;
      }
      catch (Exception localException2)
      {
        AVLog.e("QQGAudioCtrl", "GetSharpConfigPayloadFromFile fail.", localException2);
        break label66;
      }
      AVLog.d("QQGAudioCtrl", "GetSharpConfigPayloadFromFile version:" + (String)localObject1 + ", payload:" + (String)localObject2);
      return localObject2;
    }
    return "";
  }
  
  public int GetSharpConfigVersionFromFile()
  {
    try
    {
      Object localObject = Common.readFile(this.mContext, "SharpConfigPayload");
      if (localObject != null)
      {
        String str = new String((byte[])localObject);
        if (!TextUtils.isEmpty(str))
        {
          int i = str.indexOf('|');
          localObject = str.substring(0, i);
          str = str.substring(i + 1);
          AVLog.d("QQGAudioCtrl", "GetSharpConfigVersionFromFile version:" + (String)localObject + ", payload:" + str);
          return Integer.parseInt((String)localObject);
        }
        AVLog.w("QQGAudioCtrl", "GetSharpConfigVersionFromFile, payloadBufTmp[" + str + "]");
        return 0;
      }
    }
    catch (Exception localException)
    {
      AVLog.e("QQGAudioCtrl", "GetSharpConfigVersionFromFile fail.", localException);
    }
    return 0;
  }
  
  public native int Invite(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4);
  
  public native int InvitePstn(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2);
  
  public native int KickOutPstnUsers();
  
  public native void LockVideoMaxQP(int paramInt);
  
  public native int ReadDataFromTRAE(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public native void SetAudioDataSendByDefault(boolean paramBoolean);
  
  public native void SetAudioDataSink(boolean paramBoolean);
  
  public native int SetOutputFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public void SetVideoController(QQGAudioCtrlCallback paramQQGAudioCtrlCallback)
  {
    this.mVideoController = paramQQGAudioCtrlCallback;
  }
  
  public native void SetVideoDataSendByDefault(boolean paramBoolean);
  
  public native void SetVideoDataSink(boolean paramBoolean);
  
  public native int WriteDataToTRAE(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public native boolean enableLoopback(boolean paramBoolean);
  
  public native String getAVGQuality();
  
  protected AVUserInfo getAVInfoFromByte(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {}
    while (paramArrayOfByte.length != paramInt) {
      return null;
    }
    byte[] arrayOfByte = new byte[8];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 8);
    long l = getLongFromByte(arrayOfByte);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, 8, arrayOfByte, 0, 4);
    paramInt = getIntFromByte(arrayOfByte);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, 12, arrayOfByte, 0, 4);
    int i = getIntFromByte(arrayOfByte);
    paramArrayOfByte = new AVUserInfo();
    paramArrayOfByte.account = l;
    paramArrayOfByte.accountType = paramInt;
    paramArrayOfByte.pstnStatus = i;
    return paramArrayOfByte;
  }
  
  public String getAppId()
  {
    try
    {
      int i = this.appid;
      return String.valueOf(i);
    }
    catch (Exception localException)
    {
      AVLog.e("QQGAudioCtrl", "getAppId fail.", localException);
    }
    return "";
  }
  
  public String getDeviceName()
  {
    return VcSystemInfo.getDeviceName();
  }
  
  public native int getEncodeFrameFunctionPtrFunPtr();
  
  public native long getEnterRoomTime();
  
  protected long getLongFromByte(byte[] paramArrayOfByte)
  {
    long l = 0L;
    int i = 0;
    while (i < 8)
    {
      l |= (paramArrayOfByte[(7 - i)] & 0xFF) << (7 - i) * 8;
      i += 1;
    }
    return l;
  }
  
  public native int getNetLevel();
  
  public native int getNetState();
  
  public native long getNetTrafficSize(long paramLong);
  
  public String getRELEASEVERSION()
  {
    return Build.VERSION.RELEASE;
  }
  
  public native long getRoomId();
  
  public native int getVideoAbilityLevel();
  
  public native int getVolume();
  
  public native int ignore(int paramInt1, long paramLong, int paramInt2);
  
  public void init(Context paramContext, long paramLong, int paramInt)
  {
    init(paramContext, paramLong, paramInt, "8.0.5");
  }
  
  public native void init(Context paramContext, long paramLong, int paramInt, String paramString);
  
  public native int invite(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3);
  
  public native boolean isEnableLoopback();
  
  public native int modifyGroupAdmin(long paramLong, boolean paramBoolean);
  
  public void onGAudioNativeEvent(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, byte[] paramArrayOfByte, int paramInt5, long paramLong2)
  {
    NativeEventParams localNativeEventParams;
    if (this.mEventHandler != null)
    {
      localNativeEventParams = new NativeEventParams();
      localNativeEventParams.detail = paramArrayOfByte;
      localNativeEventParams.info = paramLong2;
      localNativeEventParams.groupId = paramLong1;
      localNativeEventParams.relationType = paramInt2;
      localNativeEventParams.multiAVType = paramInt3;
      localNativeEventParams.multiSubType = paramInt4;
      if (paramArrayOfByte != null) {
        break label108;
      }
    }
    label108:
    for (paramInt2 = 0;; paramInt2 = paramArrayOfByte.length)
    {
      localNativeEventParams.bufferLen = paramInt2;
      paramArrayOfByte = this.mEventHandler.obtainMessage();
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte.what = paramInt1;
        paramArrayOfByte.obj = localNativeEventParams;
        this.mEventHandler.sendMessage(paramArrayOfByte);
      }
      return;
    }
  }
  
  public native int onRecvGAudioCMD(int paramInt, byte[] paramArrayOfByte);
  
  public native int postData(long paramLong, byte[] paramArrayOfByte);
  
  public native int quit(int paramInt);
  
  public native int registerTRAE(int paramInt);
  
  public native int requestCamera(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4);
  
  public native int requestMemPosInfoList();
  
  public native int sendAudioData(byte[] paramArrayOfByte, int paramInt);
  
  public void sendGAudioCMD(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    this.mVideoController.sendMultiVideoCMD(paramLong1, paramLong2, paramArrayOfByte);
  }
  
  public native void sendTransferMsg(long[] paramArrayOfLong, byte[] paramArrayOfByte);
  
  public native int setApType(int paramInt);
  
  public void setAppid(int paramInt)
  {
    this.appid = paramInt;
  }
  
  public native boolean setAudioNoiseCtrlParam(int paramInt1, int paramInt2, int paramInt3);
  
  public native int setAudioOutputMode(int paramInt);
  
  public native int setHowlingDetectEnable(boolean paramBoolean);
  
  public void setInviteUserList(long paramLong, long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      if (this.mInviteGAudioUinList.size() > 0) {
        this.mInviteGAudioUinList.clear();
      }
      int j = paramArrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfLong[i] != paramLong) {
          this.mInviteGAudioUinList.add(Long.valueOf(paramArrayOfLong[i]));
        }
        i += 1;
      }
    }
  }
  
  public native boolean setMicByAdmin(long paramLong, boolean paramBoolean);
  
  public native boolean setMicMode(int paramInt);
  
  public native int setNetIPAndPort(String paramString, int paramInt);
  
  public native void setProcessDecoderFrameFunctionptr(int paramInt);
  
  public native void setVideoJitterLength(int paramInt);
  
  public native int setVoiceType(int paramInt);
  
  public native int startAudioRecv();
  
  public int startAudioSend()
  {
    return startAudioSend(false);
  }
  
  public native int startAudioSend(boolean paramBoolean);
  
  public int startCommonGAudio(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString, int paramInt4, byte[] paramArrayOfByte)
  {
    int j = -1;
    if ((paramInt1 != 11) || (paramInt2 != 14) || (paramInt3 != 1))
    {
      AVLog.e("QQGAudioCtrl", "startCommonGAudio type error!");
      return -1;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("startCommonGAudio emAVRelationType:").append(paramInt1).append(" emMultiAVType:").append(paramInt2).append(" emMultiAVSubType:").append(paramInt3).append(" roomId:").append(paramLong1).append(" selfUin:").append(paramLong2).append(" llAppid:").append(paramInt4).append(" nConfig:").append(0).append(" maxShowVideo:").append(5).append(" openId:").append(paramString).append(" sourceId:").append(paramInt4).append(" commonSig.length:");
    if (paramArrayOfByte != null) {}
    for (i = paramArrayOfByte.length;; i = 0)
    {
      AVLog.d("QQGAudioCtrl", i);
      i = j;
      try
      {
        paramInt1 = commonRequest(paramInt1, paramLong1, paramInt2, paramInt3, paramInt4, 0, 5, paramString, paramInt4, paramArrayOfByte);
        i = paramInt1;
        AVLog.d("QQGAudioCtrl", "startCommonGAudio result:" + paramInt1);
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          AVLog.e("QQGAudioCtrl", "startCommonGAudio fail.", paramString);
          paramInt1 = i;
        }
      }
      return paramInt1;
    }
  }
  
  public native int startVideoRecv(long[] paramArrayOfLong, int paramInt);
  
  public native int startVideoSend();
  
  public native int stopAudioRecv();
  
  public native int stopAudioSend(boolean paramBoolean);
  
  public native int stopVideoRecv();
  
  public native int switchToAudioMode();
  
  public native void uninit();
  
  public native int unregisterTRAE(int paramInt);
  
  public static abstract interface DataEvent
  {
    public static final int destroyRoom = 1;
    public static final int getRoomId = 3;
    public static final int kickoutPstnUsers = 2;
  }
  
  @SuppressLint({"HandlerLeak"})
  class NativeEventHandler
    extends Handler
  {
    public NativeEventHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage == null) {}
      int n;
      Object localObject;
      long l3;
      long l1;
      int j;
      int k;
      int i1;
      int i;
      label221:
      long l2;
      label564:
      label589:
      boolean bool;
      for (;;)
      {
        return;
        try
        {
          if (QQGAudioCtrl.this.mVideoController == null) {
            continue;
          }
          n = paramMessage.what;
          paramMessage = (QQGAudioCtrl.NativeEventParams)paramMessage.obj;
          if (paramMessage == null)
          {
            AVLog.e("QQGAudioCtrl", "handleMessage-->NativeEventParams is null");
            continue;
          }
        }
        finally {}
        localObject = paramMessage.detail;
        l3 = paramMessage.info;
        l1 = paramMessage.groupId;
        j = paramMessage.multiAVType;
        int m = paramMessage.multiSubType;
        k = paramMessage.relationType;
        i1 = paramMessage.bufferLen;
        if ((n == 61) || (n == 43)) {
          break;
        }
        StringBuilder localStringBuilder = new StringBuilder().append("handleMessage, groupId[").append(l1).append("], multiAVType[").append(j).append("], multiSubType[").append(m).append("], relationType[").append(k).append("], info[").append(l3).append("], detail[");
        if (localObject == null) {
          break label2555;
        }
        i = localObject.length;
        AVLog.w("QQGAudioCtrl", i + "], eventId[" + n + "], buflen[" + i1 + "]");
        break;
        AVLog.e("QQGAudioCtrl", "Wrong type of eventid=" + n);
        continue;
        if (localObject != null)
        {
          paramMessage = QQGAudioCtrl.this.getAVInfoFromByte((byte[])localObject, i1);
          if (paramMessage == null)
          {
            AVLog.e("QQGAudioCtrl", "handleMessage, fail, empty userInfo");
          }
          else if ((paramMessage.accountType == 0) || ((paramMessage.accountType == 1) && (paramMessage.pstnStatus == 3) && (n == 70)) || ((paramMessage.accountType == 1) && (n == 71)))
          {
            QQGAudioCtrl.this.mVideoController.onMAVMemberInOrOut(paramMessage, l1, n, k, l3, new int[] { j });
            continue;
            if ((localObject != null) && (localObject.length >= 8))
            {
              paramMessage = QQGAudioCtrl.this.getUinListFromBuf((byte[])localObject);
              if (paramMessage == null)
              {
                AVLog.e("QQGAudioCtrl", "handleMessage, fail, empty uinList");
              }
              else
              {
                QQGAudioCtrl.this.mVideoController.onMultiVideoChatMembersInfoChange(l1, paramMessage, n, k, l3, j);
                continue;
                QQGAudioCtrl.this.mVideoController.onGroupChatModeChange(l1, k, n);
                continue;
                if ((localObject != null) && (localObject.length >= 8) && (k == 1))
                {
                  l2 = QQGAudioCtrl.this.getLongFromByte((byte[])localObject);
                  if (j != 10)
                  {
                    QQGAudioCtrl.this.mVideoController.onVideoSrcChange((int)l3, k, l2, l1);
                    continue;
                    if ((localObject != null) && (localObject.length >= 8))
                    {
                      l2 = QQGAudioCtrl.this.getLongFromByte((byte[])localObject);
                      QQGAudioCtrl.this.mVideoController.onPPTInOrOut(l1, l2, k, (int)l3);
                      continue;
                      for (;;)
                      {
                        QQGAudioCtrl.this.mVideoController.onGroupSecurityLimit(l1, l3, paramMessage);
                        if (i == 0) {
                          break;
                        }
                        QQGAudioCtrl.this.mVideoController.onGroupVideoClosed(k, l1, i, j);
                        break;
                        paramMessage = new String((byte[])localObject);
                      }
                      label1028:
                      if ((paramMessage.detail != null) && (paramMessage.detail.length == 16))
                      {
                        paramMessage = QQGAudioCtrl.this.getAVInfoFromByte(paramMessage.detail, paramMessage.detail.length);
                        if (n != 140) {
                          break label2722;
                        }
                        bool = true;
                        label647:
                        if (paramMessage != null)
                        {
                          QQGAudioCtrl.this.mVideoController.onGAudioMemberMicChanged(paramMessage.account, paramMessage.accountType, paramMessage.pstnStatus, bool);
                          continue;
                          l2 = 0L;
                          l1 = l2;
                          if (paramMessage.detail == null) {
                            break label2728;
                          }
                          if (paramMessage.detail.length != 8)
                          {
                            l1 = l2;
                            break label2728;
                            label711:
                            QQGAudioCtrl.this.mVideoController.onGAudioRoomMicModeChanged(l1, bool);
                          }
                          else
                          {
                            l1 = QQGAudioCtrl.this.getLongFromByte(paramMessage.detail);
                            break label2728;
                            label746:
                            l1 = l2;
                            if (paramMessage.detail != null) {
                              if (paramMessage.detail.length == 8) {
                                break label790;
                              }
                            }
                            label790:
                            for (l1 = l2;; l1 = QQGAudioCtrl.this.getLongFromByte(paramMessage.detail))
                            {
                              QQGAudioCtrl.this.mVideoController.onGAudioMicSetByAdmin(l1, bool);
                              break;
                            }
                            i = (int)l3;
                            if ((paramMessage.detail != null) && (paramMessage.detail.length == i << 4))
                            {
                              paramMessage = QQGAudioCtrl.this.getAVInfoListFromByte(paramMessage.detail, 16);
                              if ((paramMessage != null) && (paramMessage.size() == i))
                              {
                                QQGAudioCtrl.this.mVideoController.onGAudioSetMicFailed(i, paramMessage);
                                continue;
                                if ((paramMessage.detail != null) && (paramMessage.detail.length == 16))
                                {
                                  l1 = QQGAudioCtrl.this.getLongFromByte(paramMessage.detail);
                                  localObject = new byte[4];
                                  System.arraycopy(paramMessage.detail, 12, localObject, 0, 4);
                                  i = QQGAudioCtrl.this.getIntFromByte((byte[])localObject);
                                  if (l3 != 1L) {
                                    break label2769;
                                  }
                                  bool = true;
                                  label939:
                                  QQGAudioCtrl.this.mVideoController.onGAudioUserAudioSuspectNoisy(l1, bool, i);
                                  continue;
                                  QQGAudioCtrl.this.mVideoController.onCreateRoomSuc(k, l1, j);
                                  continue;
                                  paramMessage = QQGAudioCtrl.this.getUinListFromBuf((byte[])localObject);
                                  if (k == 2) {
                                    break label2775;
                                  }
                                  if (k == 1)
                                  {
                                    break label2775;
                                    for (;;)
                                    {
                                      label1005:
                                      QQGAudioCtrl.this.onRecvUserList(6, k, l1, paramMessage, l3, j, m, i);
                                      break;
                                      i = paramMessage.length;
                                    }
                                  }
                                  if (k == 3)
                                  {
                                    QQGAudioCtrl.this.onRecvDoubleVideoMeeting(n, k, l3);
                                    continue;
                                    QQGAudioCtrl.this.mVideoController.onGAudioTerminalEnterRoom(k, l1, new int[] { j });
                                    continue;
                                    QQGAudioCtrl.this.mVideoController.onGAudioRoomDistroy(k, l1);
                                    continue;
                                    QQGAudioCtrl.this.mVideoController.onGAudioSDKError(k, l1, 17, (int)paramMessage.info);
                                    continue;
                                    QQGAudioCtrl.this.mVideoController.onGAudioSDKError(k, l1, 16, (int)paramMessage.info);
                                    continue;
                                    QQGAudioCtrl.this.mVideoController.onGAudioSDKError(k, l1, 15, (int)paramMessage.info);
                                    continue;
                                    paramMessage = QQGAudioCtrl.this.getUinListFromBuf((byte[])localObject);
                                    if (paramMessage == null) {}
                                    for (i = 0;; i = paramMessage.length)
                                    {
                                      QQGAudioCtrl.this.onRecvUserList(44, k, l1, paramMessage, 0L, j, 0, i);
                                      break;
                                    }
                                    QQGAudioCtrl.this.mVideoController.onGAudioKickOut(l1, k, j);
                                    continue;
                                    i = (int)l3;
                                    if (i >= 0)
                                    {
                                      paramMessage = QQGAudioCtrl.this.getAVInfoListFromByte((byte[])localObject, 16);
                                      if (paramMessage != null) {
                                        QQGAudioCtrl.this.onRecvUserList(44, k, l1, paramMessage, 0L, 0, j, i);
                                      } else {
                                        QQGAudioCtrl.this.onRecvUserListFail(k, l1, -99L);
                                      }
                                    }
                                    else
                                    {
                                      QQGAudioCtrl.this.onRecvUserListFail(k, l1, i);
                                      continue;
                                      QQGAudioCtrl.this.mVideoController.onEnterSuc(l1, k, j);
                                      continue;
                                      QQGAudioCtrl.this.mVideoController.onRemoteVideoDataComeIn(61, l3, k);
                                      continue;
                                      QQGAudioCtrl.this.mVideoController.onGaGoOnStageResult(n, l3, l1, k);
                                      continue;
                                      QQGAudioCtrl.this.mVideoController.onGaGoOffStageResult(n, l3, l1, k);
                                      continue;
                                      QQGAudioCtrl.this.mVideoController.onGaSwitchVideoResult(n, l3, l1, k);
                                      continue;
                                      QQGAudioCtrl.this.mVideoController.onDetectAudioDataIssue(3);
                                      continue;
                                      QQGAudioCtrl.this.mVideoController.onDetectAudioDataIssue(4);
                                      continue;
                                      if (l3 != 0L) {
                                        break label2784;
                                      }
                                      localObject = AVInviteAccount.getListFromBuffer((byte[])localObject, i1);
                                      QQGAudioCtrl.this.mVideoController.onGAudioInviteResp((ArrayList)localObject);
                                      if (((j == 10) || (j == 1)) && (localObject != null))
                                      {
                                        l2 = QQGAudioCtrl.this.mVideoController.getGAudioRoomId(k, j, l1);
                                        paramMessage = new ArrayList(((ArrayList)localObject).size());
                                        l3 = System.currentTimeMillis() / 1000L;
                                        localObject = ((ArrayList)localObject).iterator();
                                        while (((Iterator)localObject).hasNext()) {
                                          paramMessage.add(new Memberinfo(((AVInviteAccount)((Iterator)localObject).next()).uint64_account, l3));
                                        }
                                        QQGAudioCtrl.this.mVideoController.dealInviteMemberRsp(l1, l2, paramMessage);
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        QQGAudioCtrl.this.mVideoController.onGAudioInviteRespFail(l1, l3, paramMessage);
        break;
        label1636:
        paramMessage = new String((byte[])localObject);
      }
      for (;;)
      {
        label1649:
        QQGAudioCtrl.this.mVideoController.onKickOutSuc(l1, k, j, (int)l3, paramMessage);
        break;
        label1673:
        paramMessage = new String((byte[])localObject);
      }
      for (;;)
      {
        label1686:
        QQGAudioCtrl.this.mVideoController.onKickOutFail(l1, k, j, (int)l3, paramMessage);
        break;
        label2555:
        do
        {
          paramMessage = new String((byte[])localObject);
          break label1686;
          QQGAudioCtrl.this.mVideoController.onHowling();
          break;
          QQGAudioCtrl.this.mVideoController.onOpenMicFail();
          break;
          if (localObject == null) {
            break;
          }
          QQGAudioCtrl.this.mVideoController.onSetMicBySelf(QQGAudioCtrl.this.getLongFromByte((byte[])localObject));
          break;
          if (l3 == 0L) {
            break;
          }
          i = (int)l3;
          QQGAudioCtrl.this.mVideoController.onFpsChange(i);
          break;
          if (localObject == null) {
            break;
          }
          QQGAudioCtrl.this.mVideoController.onGVideoDownloadChannelCtlChanged((byte[])localObject);
          break;
          paramMessage = QQGAudioCtrl.this.getAVInfoListFromByte2((byte[])localObject, i1);
          if (paramMessage == null) {
            break;
          }
          QQGAudioCtrl.this.mVideoController.onMemberPosChanged(l1, paramMessage);
          break;
          switch (n)
          {
          case 7: 
          case 13: 
          case 36: 
          case 37: 
          case 38: 
          case 123: 
          case 9: 
          case 10: 
          case 14: 
          case 15: 
          case 16: 
          case 17: 
          case 18: 
          case 19: 
          case 23: 
          case 24: 
          case 25: 
          case 26: 
          case 27: 
          case 28: 
          case 29: 
          case 40: 
          case 41: 
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
          case 60: 
          case 62: 
          case 63: 
          case 64: 
          case 65: 
          case 66: 
          case 67: 
          case 68: 
          case 69: 
          case 81: 
          case 82: 
          case 83: 
          case 84: 
          case 85: 
          case 86: 
          case 87: 
          case 88: 
          case 89: 
          case 99: 
          case 100: 
          case 105: 
          case 106: 
          case 111: 
          case 112: 
          case 113: 
          case 114: 
          case 115: 
          case 116: 
          case 117: 
          case 118: 
          case 119: 
          case 120: 
          case 124: 
          case 125: 
          case 126: 
          case 127: 
          case 128: 
          case 129: 
          case 130: 
          case 131: 
          case 132: 
          case 133: 
          case 134: 
          case 135: 
          case 136: 
          case 137: 
          case 146: 
          case 147: 
          case 148: 
          case 149: 
          case 150: 
          case 151: 
          case 152: 
          case 154: 
          case 155: 
          case 156: 
          case 159: 
          case 160: 
          case 161: 
          case 162: 
          case 163: 
          case 164: 
          case 165: 
          case 166: 
          case 167: 
          case 168: 
          case 169: 
          case 170: 
          case 70: 
          case 71: 
          case 42: 
          case 43: 
          case 72: 
          case 73: 
          case 74: 
          case 75: 
          case 76: 
          case 77: 
          case 78: 
          case 79: 
          case 101: 
          case 102: 
          case 103: 
          case 104: 
          case 107: 
          case 108: 
          case 109: 
          case 110: 
          case 140: 
          case 141: 
          case 142: 
          case 144: 
          case 145: 
          case 30: 
          case 5: 
          case 6: 
          case 12: 
          case 11: 
          case 31: 
          case 32: 
          case 34: 
          case 35: 
          case 39: 
          case 44: 
          case 45: 
          case 8: 
          case 33: 
          case 61: 
          case 90: 
          case 91: 
          case 92: 
          case 93: 
          case 94: 
          case 95: 
          case 96: 
          case 97: 
          case 98: 
          case 121: 
          case 122: 
          case 20: 
          case 153: 
          case 158: 
          case 157: 
          case 171: 
          case 172: 
          case 80: 
          default: 
            break label221;
            i = -1;
            break;
          case 138: 
          case 139: 
            i = 0;
            switch ((int)l3)
            {
            default: 
              if ((l3 > 200L) && (l3 < 300L))
              {
                if (localObject != null) {
                  break label589;
                }
                paramMessage = "";
              }
              break;
            case 8: 
              if (k != 1) {
                break label564;
              }
              i = 1;
              break;
            case 7: 
              i = 2;
              break;
            case 32: 
              i = 7;
              break;
            case 35: 
              i = 35;
              break;
            case 42: 
              i = 42;
              break;
            case 43: 
              i = 43;
              break;
            case 3: 
            case 15: 
              i = 3;
              break label564;
              i = (int)l3;
              break label564;
              bool = false;
              break label647;
              if (l3 == 0L)
              {
                bool = false;
                break label711;
              }
              bool = true;
            }
            break;
          case 143: 
            l2 = 0L;
            if (l3 == 0L)
            {
              bool = false;
              break label746;
            }
            bool = true;
            break label746;
            bool = false;
            break label939;
            if (paramMessage != null) {
              break label1028;
            }
            i = 0;
            break label1005;
            if (localObject != null) {
              break label1636;
            }
            paramMessage = "";
            break;
          case 21: 
            if (localObject != null) {
              break label1673;
            }
            paramMessage = "";
            break label1649;
          }
        } while (localObject != null);
        label2722:
        label2728:
        label2769:
        label2775:
        label2784:
        paramMessage = "";
      }
    }
  }
  
  class NativeEventParams
  {
    public int bufferLen;
    public byte[] detail;
    @Deprecated
    public Object extraObj;
    public long groupId;
    public long info;
    public int multiAVType;
    public int multiSubType;
    @Deprecated
    public int param4;
    public int relationType;
    
    NativeEventParams() {}
  }
  
  class UserStateInfo
  {
    public int chatState;
    public long enterTime;
    public long uin;
    
    UserStateInfo() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.gaudio.QQGAudioCtrl
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.av.config;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.qav.log.AVLog;

public class ConfigSystemImpl
{
  public static final byte DEFLECT_ANGLE_0 = 0;
  public static final byte DEFLECT_ANGLE_180 = 2;
  public static final byte DEFLECT_ANGLE_270 = 3;
  public static final byte DEFLECT_ANGLE_90 = 1;
  private static final String TAG = "ConfigSystemImpl";
  static byte angle_landscape_local_back;
  static byte angle_landscape_local_front;
  static int angle_landscape_mini_sdk;
  static byte angle_landscape_remote_back_0;
  static byte angle_landscape_remote_back_180;
  static byte angle_landscape_remote_back_270;
  static byte angle_landscape_remote_back_90;
  static byte angle_landscape_remote_front_0;
  static byte angle_landscape_remote_front_180;
  static byte angle_landscape_remote_front_270;
  static byte angle_landscape_remote_front_90;
  static byte angle_landscape_sensor;
  static byte angle_local_background;
  static byte angle_local_front = 0;
  static int angle_mini_sdk;
  static byte angle_remote_background_0;
  static byte angle_remote_background_180;
  static byte angle_remote_background_270;
  static byte angle_remote_background_90;
  static byte angle_remote_front_0;
  static byte angle_remote_front_180;
  static byte angle_remote_front_270;
  static byte angle_remote_front_90;
  static byte angle_sensor;
  static byte bace_camera_format;
  static byte dAudioEnable;
  private static byte dAudioHowlingEnable = 0;
  private static byte dSmallScreenEnable;
  private static boolean dSwitchInfoRead = false;
  static byte front_camera_format;
  static volatile boolean isReadDone;
  static int systemSensor;
  static volatile boolean usingNewConfig;
  private String mAppId = null;
  private byte[] mConfigMsg = null;
  private Context mContext = null;
  private ConfigPBProtocol mProtocol;
  private VcSystemInfo mSystemInfo;
  
  static
  {
    angle_local_background = 0;
    angle_remote_front_0 = 0;
    angle_remote_front_90 = 0;
    angle_remote_front_180 = 0;
    angle_remote_front_270 = 0;
    angle_remote_background_0 = 0;
    angle_remote_background_90 = 0;
    angle_remote_background_180 = 0;
    angle_remote_background_270 = 0;
    angle_sensor = 0;
    angle_mini_sdk = 1;
    angle_landscape_local_front = 0;
    angle_landscape_local_back = 0;
    angle_landscape_remote_front_0 = 0;
    angle_landscape_remote_front_90 = 0;
    angle_landscape_remote_front_180 = 0;
    angle_landscape_remote_front_270 = 0;
    angle_landscape_remote_back_0 = 0;
    angle_landscape_remote_back_90 = 0;
    angle_landscape_remote_back_180 = 0;
    angle_landscape_remote_back_270 = 0;
    angle_landscape_sensor = 0;
    angle_landscape_mini_sdk = 1;
    front_camera_format = 0;
    bace_camera_format = 0;
    isReadDone = false;
    dAudioEnable = 1;
    usingNewConfig = false;
    systemSensor = -1;
    dSmallScreenEnable = 1;
  }
  
  public ConfigSystemImpl(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.mAppId = paramString;
    this.mSystemInfo = new VcSystemInfo();
    this.mProtocol = new ConfigPBProtocol();
    if ((Build.MANUFACTURER.equals("Kido")) && (Build.MODEL.equals("W920")))
    {
      angle_remote_front_0 = 2;
      AVLog.d("ConfigSystemImpl", "angle_remote_front_0 set to 2");
    }
  }
  
  public static int getAngleForCamera(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, byte paramByte, boolean paramBoolean3)
  {
    int j = getCameraAngleConfig(paramContext, false, paramBoolean1, paramBoolean2, paramByte, paramBoolean3);
    int i = j;
    if (paramBoolean3)
    {
      i = j;
      if (!usingNewConfig) {
        i = (byte)getSystemSenorProperty(paramContext);
      }
    }
    return i;
  }
  
  private static byte getCameraAngleConfig(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, byte paramByte, boolean paramBoolean4)
  {
    if (!isReadDone) {}
    label59:
    label71:
    do
    {
      do
      {
        try
        {
          if (!isReadDone)
          {
            getCameraAngleInfo(paramContext);
            isReadDone = true;
          }
          byte b = 0;
          if (!paramBoolean3) {
            break label71;
          }
          if (!paramBoolean2) {
            break label59;
          }
          if (paramBoolean1)
          {
            b = angle_landscape_local_front;
            return b;
          }
        }
        finally {}
        return angle_local_front;
        if (paramBoolean1) {
          return angle_landscape_local_back;
        }
        return angle_local_background;
        if (paramBoolean4)
        {
          if (paramBoolean1) {
            return angle_landscape_sensor;
          }
          return angle_sensor;
        }
        if (!paramBoolean2) {
          break;
        }
        if (paramByte == 0)
        {
          if (paramBoolean1) {
            return angle_landscape_remote_front_0;
          }
          return angle_remote_front_0;
        }
        if (paramByte == 1)
        {
          if (paramBoolean1) {
            return angle_landscape_remote_front_90;
          }
          return angle_remote_front_90;
        }
        if (paramByte == 2)
        {
          if (paramBoolean1) {
            return angle_landscape_remote_front_180;
          }
          return angle_remote_front_180;
        }
      } while (paramByte != 3);
      if (paramBoolean1) {
        return angle_landscape_remote_front_270;
      }
      return angle_remote_front_270;
      if (paramByte == 0)
      {
        if (paramBoolean1) {
          return angle_landscape_remote_back_0;
        }
        return angle_remote_background_0;
      }
      if (paramByte == 1)
      {
        if (paramBoolean1) {
          return angle_landscape_remote_back_90;
        }
        return angle_remote_background_90;
      }
      if (paramByte == 2)
      {
        if (paramBoolean1) {
          return angle_landscape_remote_back_180;
        }
        return angle_remote_background_180;
      }
    } while (paramByte != 3);
    if (paramBoolean1) {
      return angle_landscape_remote_back_270;
    }
    return angle_remote_background_270;
  }
  
  private static void getCameraAngleInfo(Context paramContext)
  {
    boolean bool1 = false;
    Object localObject = ConfigManager.getInstance(paramContext).getParser();
    if (!((BaseConfigParser)localObject).isEmpty())
    {
      CameraConfigParser localCameraConfigParser = new CameraConfigParser();
      usingNewConfig = localCameraConfigParser.parseConfig((BaseConfigParser)localObject);
      if (usingNewConfig)
      {
        angle_local_front = localCameraConfigParser.value_local_front;
        angle_local_background = localCameraConfigParser.value_local_back;
        angle_remote_front_0 = localCameraConfigParser.value_remote_front_0;
        angle_remote_front_90 = localCameraConfigParser.value_remote_front_90;
        angle_remote_front_180 = localCameraConfigParser.value_remote_front_180;
        angle_remote_front_270 = localCameraConfigParser.value_remote_front_270;
        angle_remote_background_0 = localCameraConfigParser.value_remote_back_0;
        angle_remote_background_90 = localCameraConfigParser.value_remote_back_90;
        angle_remote_background_180 = localCameraConfigParser.value_remote_back_180;
        angle_remote_background_270 = localCameraConfigParser.value_remote_back_270;
        angle_sensor = localCameraConfigParser.value_sensor;
        angle_mini_sdk = localCameraConfigParser.value_minisdk;
        AVLog.d("ConfigSystemImpl", "angle_local_front: " + angle_local_front + ", angle_local_background: " + angle_local_background + ", angle_remote_front_0: " + angle_remote_front_0 + ", angle_remote_front_90: " + angle_remote_front_90 + ", angle_remote_front_180: " + angle_remote_front_180 + ", angle_remote_front_270: " + angle_remote_front_270 + ", angle_remote_background_0: " + angle_remote_background_0 + ", angle_remote_background_90: " + angle_remote_background_90 + ", angle_remote_background_180: " + angle_remote_background_180 + ", angle_remote_background_270: " + angle_remote_background_270 + ", angle_sensor: " + angle_sensor + ", angle_mini_sdk:" + angle_mini_sdk);
      }
      boolean bool2 = localCameraConfigParser.parseLandscapeConfig((BaseConfigParser)localObject);
      bool1 = bool2;
      if (bool2)
      {
        angle_landscape_local_front = localCameraConfigParser.value_landscape_local_front;
        angle_landscape_local_back = localCameraConfigParser.value_landscape_local_back;
        angle_landscape_remote_front_0 = localCameraConfigParser.value_landscape_remote_front_0;
        angle_landscape_remote_front_90 = localCameraConfigParser.value_landscape_remote_front_90;
        angle_landscape_remote_front_180 = localCameraConfigParser.value_landscape_remote_front_180;
        angle_landscape_remote_front_270 = localCameraConfigParser.value_landscape_remote_front_270;
        angle_landscape_remote_back_0 = localCameraConfigParser.value_landscape_remote_back_0;
        angle_landscape_remote_back_90 = localCameraConfigParser.value_landscape_remote_back_90;
        angle_landscape_remote_back_180 = localCameraConfigParser.value_landscape_remote_back_180;
        angle_landscape_remote_back_270 = localCameraConfigParser.value_landscape_remote_back_270;
        angle_landscape_sensor = localCameraConfigParser.value_landscape_sensor;
        angle_landscape_mini_sdk = localCameraConfigParser.value_landscape_minisdk;
        AVLog.d("ConfigSystemImpl", "angle_landscape_local_front: " + angle_landscape_local_front + ", angle_landscape_local_back: " + angle_landscape_local_back + ", angle_landscape_remote_front_0: " + angle_landscape_remote_front_0 + ", angle_landscape_remote_front_90: " + angle_landscape_remote_front_90 + ", angle_landscape_remote_front_180: " + angle_landscape_remote_front_180 + ", angle_landscape_remote_front_270: " + angle_landscape_remote_front_270 + ", angle_landscape_remote_back_0: " + angle_landscape_remote_back_0 + ", angle_landscape_remote_back_90: " + angle_landscape_remote_back_90 + ", angle_landscape_remote_back_180: " + angle_landscape_remote_back_180 + ", angle_landscape_remote_back_270: " + angle_landscape_remote_back_270 + ", angle_landscape_sensor: " + angle_landscape_sensor + ", angle_landscape_mini_sdk:" + angle_landscape_mini_sdk);
        bool1 = bool2;
      }
    }
    AVLog.d("ConfigSystemImpl", String.format("getCameraAngleInfo usingNewConfig=%s usingNewLandscapeConfig=%s", new Object[] { Boolean.valueOf(usingNewConfig), Boolean.valueOf(bool1) }));
    if (usingNewConfig) {}
    do
    {
      do
      {
        do
        {
          return;
          paramContext = Common.readFile(paramContext, "VideoConfigInfo");
        } while (paramContext == null);
        localObject = new ConfigPBProtocol();
      } while (((ConfigPBProtocol)localObject).UnpackPBConfigInfo(paramContext) != 0);
      paramContext = ((ConfigPBProtocol)localObject).GetConfigSysInfoNew();
    } while (paramContext == null);
    angle_local_front = paramContext.m_cameraInfo.m_FrontCameraAngleForLocalPreview;
    angle_local_background = paramContext.m_cameraInfo.m_FrontCameraAngleForLocalPreview;
    angle_remote_front_0 = paramContext.m_cameraInfo.m_FrontCameraAngleForRemote_0;
    angle_remote_front_90 = paramContext.m_cameraInfo.m_FrontCameraAngleForRemote_90;
    angle_remote_front_180 = paramContext.m_cameraInfo.m_FrontCameraAngleForRemote_180;
    angle_remote_front_270 = paramContext.m_cameraInfo.m_FrontCameraAngleForRemote_270;
    angle_remote_background_0 = paramContext.m_cameraInfo.m_BackCameraAngleForRemote_0;
    angle_remote_background_90 = paramContext.m_cameraInfo.m_BackCameraAngleForRemote_90;
    angle_remote_background_180 = paramContext.m_cameraInfo.m_BackCameraAngleForRemote_180;
    angle_remote_background_270 = paramContext.m_cameraInfo.m_BackCameraAngleForRemote_270;
    front_camera_format = paramContext.m_cameraInfo.m_FrontCameraFormat;
    bace_camera_format = paramContext.m_cameraInfo.m_BackCameraFormat;
    AVLog.d("ConfigSystemImpl", "angle_local_front: " + angle_local_front + ", angle_local_background: " + angle_local_background + ", angle_remote_front_0: " + angle_remote_front_0 + ", angle_remote_front_90: " + angle_remote_front_90 + ", angle_remote_front_180: " + angle_remote_front_180 + ", angle_remote_front_270: " + angle_remote_front_270 + ", angle_remote_background_0: " + angle_remote_background_0 + ", angle_remote_background_90: " + angle_remote_background_90 + ", angle_remote_background_180: " + angle_remote_background_180 + ", angle_remote_background_270: " + angle_remote_background_270);
  }
  
  private byte[] getConfigRequestPackage(long paramLong)
  {
    Object localObject = this.mProtocol;
    localObject.getClass();
    localObject = new ConfigPBProtocol.TerminalInfo((ConfigPBProtocol)localObject);
    ((ConfigPBProtocol.TerminalInfo)localObject).deviceType = 201;
    ((ConfigPBProtocol.TerminalInfo)localObject).osType = VcSystemInfo.getOsType();
    ((ConfigPBProtocol.TerminalInfo)localObject).chip = VcSystemInfo.getCpuArchitecture();
    ((ConfigPBProtocol.TerminalInfo)localObject).numOfCore = VcSystemInfo.getNumCores();
    ((ConfigPBProtocol.TerminalInfo)localObject).cpuFreq = ((int)(VcSystemInfo.getMaxCpuFreq() / 1000L));
    ((ConfigPBProtocol.TerminalInfo)localObject).angleForCamera = 0;
    ((ConfigPBProtocol.TerminalInfo)localObject).maxEncodeFrame = 0;
    ((ConfigPBProtocol.TerminalInfo)localObject).maxDecodeFrame = 0;
    ((ConfigPBProtocol.TerminalInfo)localObject).screenWidth = VcSystemInfo.sScreenWidth;
    ((ConfigPBProtocol.TerminalInfo)localObject).screenHeight = VcSystemInfo.sScreenHeight;
    ((ConfigPBProtocol.TerminalInfo)localObject).openslInfo = 22;
    ((ConfigPBProtocol.TerminalInfo)localObject).sharpConfigVersion = ConfigInfo.getSharpConfigVersionFromFile(this.mContext);
    ((ConfigPBProtocol.TerminalInfo)localObject).sharpSDKVersion = 37;
    ((ConfigPBProtocol.TerminalInfo)localObject).appID = this.mAppId;
    ((ConfigPBProtocol.TerminalInfo)localObject).os_version = ("android_" + Build.VERSION.RELEASE);
    ((ConfigPBProtocol.TerminalInfo)localObject).deviceName = VcSystemInfo.getDeviceNameForConfigSystem();
    ((ConfigPBProtocol.TerminalInfo)localObject).romInfo = Build.VERSION.INCREMENTAL;
    ((ConfigPBProtocol.TerminalInfo)localObject).appVersion = Common.getVersion(this.mContext);
    this.mProtocol.Init(paramLong, (ConfigPBProtocol.TerminalInfo)localObject);
    AVLog.d("ConfigSystemImpl", String.format("getConfigRequestPackage selfUin=%s terminalInfo=%s", new Object[] { Long.valueOf(paramLong), localObject }));
    return this.mProtocol.GetConfigRequest();
  }
  
  public static byte[] getConfigRequestPackage(Context paramContext, String paramString, long paramLong)
  {
    return new ConfigSystemImpl(paramContext, paramString).getConfigRequestPackage(paramLong);
  }
  
  public static String getHWCodecTestPayload(Context paramContext)
  {
    paramContext = Common.readFile(paramContext, "VideoConfigInfo");
    if (paramContext == null) {
      return "";
    }
    ConfigPBProtocol localConfigPBProtocol = new ConfigPBProtocol();
    if (localConfigPBProtocol.UnpackPBConfigInfo(paramContext) != 0) {
      return "";
    }
    paramContext = localConfigPBProtocol.GetConfigSysInfoNew();
    if (paramContext != null) {
      return paramContext.m_hwcodecTestPayload;
    }
    return "";
  }
  
  public static int getLandscapeAngleForCamera(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, byte paramByte, boolean paramBoolean3)
  {
    int i = getCameraAngleConfig(paramContext, true, paramBoolean1, paramBoolean2, paramByte, paramBoolean3);
    if ((!paramBoolean3) || (usingNewConfig)) {
      return i;
    }
    return getSystemSenorProperty(paramContext);
  }
  
  private String getSharpConfigPayload(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    ConfigPBProtocol localConfigPBProtocol = new ConfigPBProtocol();
    if (localConfigPBProtocol.UnpackPBConfigInfo(paramArrayOfByte) != 0) {
      return "";
    }
    paramArrayOfByte = localConfigPBProtocol.GetConfigSysInfoNew();
    if (paramArrayOfByte != null) {
      return paramArrayOfByte.m_sharpConfigPayload;
    }
    return "";
  }
  
  public static int getSystemSenorProperty(Context paramContext)
  {
    if (systemSensor >= 0) {
      return systemSensor;
    }
    if (systemSensor < 0) {
      systemSensor = 0;
    }
    return systemSensor;
  }
  
  public static boolean isAudioHowlingEnable(Context paramContext)
  {
    boolean bool = true;
    if (!dSwitchInfoRead) {
      updateAVSwitchTypeTLV(paramContext, null);
    }
    if (dAudioHowlingEnable == 1) {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isDAudioEnable(Context paramContext)
  {
    AVLog.d("ConfigSystemImpl", "isDAudioEnable:" + dAudioEnable);
    return dAudioEnable == 1;
  }
  
  public static boolean isSupportSmallScreen(Context paramContext)
  {
    if (!dSwitchInfoRead) {
      updateAVSwitchTypeTLV(paramContext, null);
    }
    return dSmallScreenEnable == 1;
  }
  
  public static void receiveConfigResponsePackage(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      paramContext = new ConfigSystemImpl(paramContext, paramString);
      paramContext.setConfigMsg(paramArrayOfByte);
      paramContext.writeConfigInfoToFile();
    }
  }
  
  private void setConfigMsg(byte[] paramArrayOfByte)
  {
    this.mConfigMsg = paramArrayOfByte;
  }
  
  private static void updateAVSwitchTypeTLV(Context paramContext, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = Common.readFile(paramContext, "VideoConfigInfo");
    }
    paramContext = localObject;
    if (arrayOfByte != null)
    {
      paramArrayOfByte = new ConfigPBProtocol();
      paramContext = localObject;
      if (paramArrayOfByte.UnpackPBConfigInfo(arrayOfByte) == 0)
      {
        paramArrayOfByte = paramArrayOfByte.GetConfigSysInfoNew();
        paramContext = localObject;
        if (paramArrayOfByte != null) {
          paramContext = paramArrayOfByte.m_SwitchInfo;
        }
      }
    }
    if (paramContext != null)
    {
      dAudioEnable = paramContext.m_isAudioEnable;
      dSmallScreenEnable = paramContext.m_isSupportSmallScreen;
      dAudioHowlingEnable = paramContext.m_isAudioHowlingEnable;
      dSwitchInfoRead = true;
      AVLog.d("ConfigSystemImpl", String.format("updateAVSwitchTypeTLV dAudioEnable=%s dSmallScreenEnable=%s dAudioHowlingEnable=%s", new Object[] { Byte.valueOf(dAudioEnable), Byte.valueOf(dSmallScreenEnable), Byte.valueOf(dAudioHowlingEnable) }));
    }
  }
  
  private void writeConfigInfoToFile()
  {
    String str1;
    String str2;
    if ((this.mConfigMsg != null) && (this.mConfigMsg.length > 0))
    {
      Common.writeFile(this.mContext, "VideoConfigInfo", this.mConfigMsg);
      dAudioEnable = 1;
      updateAVSwitchTypeTLV(this.mContext, this.mConfigMsg);
      str1 = getSharpConfigPayload(this.mConfigMsg);
      if ((str1 == null) || (str1.length() <= 0)) {
        break label145;
      }
      str2 = str1.substring(0, 1);
      AVLog.d("ConfigSystemImpl", String.format("writeConfigInfoToFile sharpConfigType=%s", new Object[] { str2 }));
      if (!str2.equals("0")) {
        break label111;
      }
      writeConfigInfoToFile("".getBytes());
    }
    label111:
    do
    {
      return;
      if (str2.equals("1"))
      {
        writeConfigInfoToFile(str1.substring(2).getBytes());
        return;
      }
    } while (!str2.equals("2"));
    return;
    label145:
    writeConfigInfoToFile("".getBytes());
  }
  
  private void writeConfigInfoToFile(byte[] paramArrayOfByte)
  {
    Common.writeFile(this.mContext, "SharpConfigPayload", paramArrayOfByte);
    paramArrayOfByte = new Intent("com.tencent.av.ACTION_WRITE_CONFIG_INFO_TO_FILE");
    this.mContext.sendBroadcast(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.config.ConfigSystemImpl
 * JD-Core Version:    0.7.0.1
 */
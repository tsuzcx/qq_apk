package com.tencent.av.config;

import android.os.Build.VERSION;
import com.tencent.qav.log.AVLog;

public class CameraConfigParser
{
  private static final String KEY_CAMERA_ANGLE_LANDSCAPE_ROOT = "sharp/camera_angle_landscape/";
  private static final String KEY_CAMERA_ANGLE_ROOT = "sharp/camera_angle/";
  private static final String STR_BRANCH_BACK = "back/";
  private static final String STR_BRANCH_FRONT = "front/";
  private static final String STR_BRANCH_LOCAL = "local/";
  private static final String STR_BRANCH_REMOTE = "remote/";
  private static final String STR_NODE_0 = "0";
  private static final String STR_NODE_180 = "180";
  private static final String STR_NODE_270 = "270";
  private static final String STR_NODE_90 = "90";
  private static final String STR_NODE_BACK = "back";
  private static final String STR_NODE_ENABLE = "enable";
  private static final String STR_NODE_FRONT = "front";
  private static final String STR_NODE_MINISDK = "mini_sdk";
  private static final String STR_NODE_SENSOR = "sensor";
  private static final String TAG = "CameraConfigParser";
  private static String key_enable = null;
  private static String key_landscape_enable;
  private static String key_landscape_local_back;
  private static String key_landscape_local_front;
  private static String key_landscape_minisdk;
  private static String key_landscape_remote_back_0;
  private static String key_landscape_remote_back_180;
  private static String key_landscape_remote_back_270;
  private static String key_landscape_remote_back_90;
  private static String key_landscape_remote_front_0;
  private static String key_landscape_remote_front_180;
  private static String key_landscape_remote_front_270;
  private static String key_landscape_remote_front_90;
  private static String key_landscape_sensor;
  private static String key_local_back;
  private static String key_local_front = null;
  private static String key_minisdk;
  private static String key_remote_back_0;
  private static String key_remote_back_180;
  private static String key_remote_back_270;
  private static String key_remote_back_90;
  private static String key_remote_front_0;
  private static String key_remote_front_180;
  private static String key_remote_front_270;
  private static String key_remote_front_90;
  private static String key_sensor;
  public int value_enable = 0;
  public int value_landscape_enable = 0;
  public byte value_landscape_local_back = 0;
  public byte value_landscape_local_front = 0;
  public int value_landscape_minisdk = 0;
  public byte value_landscape_remote_back_0 = 0;
  public byte value_landscape_remote_back_180 = 0;
  public byte value_landscape_remote_back_270 = 0;
  public byte value_landscape_remote_back_90 = 0;
  public byte value_landscape_remote_front_0 = 0;
  public byte value_landscape_remote_front_180 = 0;
  public byte value_landscape_remote_front_270 = 0;
  public byte value_landscape_remote_front_90 = 0;
  public byte value_landscape_sensor = 0;
  public byte value_local_back = 0;
  public byte value_local_front = 0;
  public int value_minisdk = 0;
  public byte value_remote_back_0 = 0;
  public byte value_remote_back_180 = 0;
  public byte value_remote_back_270 = 0;
  public byte value_remote_back_90 = 0;
  public byte value_remote_front_0 = 0;
  public byte value_remote_front_180 = 0;
  public byte value_remote_front_270 = 0;
  public byte value_remote_front_90 = 0;
  public byte value_sensor = 0;
  
  static
  {
    key_local_back = null;
    key_remote_front_0 = null;
    key_remote_front_90 = null;
    key_remote_front_180 = null;
    key_remote_front_270 = null;
    key_remote_back_0 = null;
    key_remote_back_90 = null;
    key_remote_back_180 = null;
    key_remote_back_270 = null;
    key_sensor = null;
    key_minisdk = null;
    key_landscape_enable = null;
    key_landscape_local_front = null;
    key_landscape_local_back = null;
    key_landscape_remote_front_0 = null;
    key_landscape_remote_front_90 = null;
    key_landscape_remote_front_180 = null;
    key_landscape_remote_front_270 = null;
    key_landscape_remote_back_0 = null;
    key_landscape_remote_back_90 = null;
    key_landscape_remote_back_180 = null;
    key_landscape_remote_back_270 = null;
    key_landscape_sensor = null;
    key_landscape_minisdk = null;
    StringBuilder localStringBuilder = new StringBuilder();
    key_enable = "sharp/camera_angle/" + "enable";
    localStringBuilder.setLength(0);
    key_local_front = "sharp/camera_angle/" + "local/" + "front";
    localStringBuilder.setLength(0);
    key_local_back = "sharp/camera_angle/" + "local/" + "back";
    localStringBuilder.setLength(0);
    key_remote_front_0 = "sharp/camera_angle/" + "remote/" + "front/" + "0";
    localStringBuilder.setLength(0);
    key_remote_front_90 = "sharp/camera_angle/" + "remote/" + "front/" + "90";
    localStringBuilder.setLength(0);
    key_remote_front_180 = "sharp/camera_angle/" + "remote/" + "front/" + "180";
    localStringBuilder.setLength(0);
    key_remote_front_270 = "sharp/camera_angle/" + "remote/" + "front/" + "270";
    localStringBuilder.setLength(0);
    key_remote_back_0 = "sharp/camera_angle/" + "remote/" + "back/" + "0";
    localStringBuilder.setLength(0);
    key_remote_back_90 = "sharp/camera_angle/" + "remote/" + "back/" + "90";
    localStringBuilder.setLength(0);
    key_remote_back_180 = "sharp/camera_angle/" + "remote/" + "back/" + "180";
    localStringBuilder.setLength(0);
    key_remote_back_270 = "sharp/camera_angle/" + "remote/" + "back/" + "270";
    localStringBuilder.setLength(0);
    key_sensor = "sharp/camera_angle/" + "sensor";
    localStringBuilder.setLength(0);
    key_minisdk = "sharp/camera_angle/" + "mini_sdk";
    localStringBuilder.setLength(0);
    key_landscape_enable = "sharp/camera_angle_landscape/" + "enable";
    localStringBuilder.setLength(0);
    key_landscape_local_front = "sharp/camera_angle_landscape/" + "local/" + "front";
    localStringBuilder.setLength(0);
    key_landscape_local_back = "sharp/camera_angle_landscape/" + "local/" + "back";
    localStringBuilder.setLength(0);
    key_landscape_remote_front_0 = "sharp/camera_angle_landscape/" + "remote/" + "front/" + "0";
    localStringBuilder.setLength(0);
    key_landscape_remote_front_90 = "sharp/camera_angle_landscape/" + "remote/" + "front/" + "90";
    localStringBuilder.setLength(0);
    key_landscape_remote_front_180 = "sharp/camera_angle_landscape/" + "remote/" + "front/" + "180";
    localStringBuilder.setLength(0);
    key_landscape_remote_front_270 = "sharp/camera_angle_landscape/" + "remote/" + "front/" + "270";
    localStringBuilder.setLength(0);
    key_landscape_remote_back_0 = "sharp/camera_angle_landscape/" + "remote/" + "back/" + "0";
    localStringBuilder.setLength(0);
    key_landscape_remote_back_90 = "sharp/camera_angle_landscape/" + "remote/" + "back/" + "90";
    localStringBuilder.setLength(0);
    key_landscape_remote_back_180 = "sharp/camera_angle_landscape/" + "remote/" + "back/" + "180";
    localStringBuilder.setLength(0);
    key_landscape_remote_back_270 = "sharp/camera_angle_landscape/" + "remote/" + "back/" + "270";
    localStringBuilder.setLength(0);
    key_landscape_sensor = "sharp/camera_angle_landscape/" + "sensor";
    localStringBuilder.setLength(0);
    key_landscape_minisdk = "sharp/camera_angle_landscape/" + "mini_sdk";
    localStringBuilder.setLength(0);
  }
  
  private byte int2byte(int paramInt)
    throws IllegalArgumentException
  {
    if ((paramInt < -128) || (paramInt > 127)) {
      throw new IllegalArgumentException(paramInt + " out of the range of byte");
    }
    return (byte)paramInt;
  }
  
  public boolean isConfigEnabled(BaseConfigParser paramBaseConfigParser)
  {
    return paramBaseConfigParser.getIntValue(key_enable, this.value_enable) >= 1;
  }
  
  public boolean isLandscapeConfigEnabled(BaseConfigParser paramBaseConfigParser)
  {
    return paramBaseConfigParser.getIntValue(key_landscape_enable, this.value_landscape_enable) >= 1;
  }
  
  public boolean parseConfig(BaseConfigParser paramBaseConfigParser)
  {
    boolean bool2 = false;
    boolean bool3 = isConfigEnabled(paramBaseConfigParser);
    bool1 = bool2;
    if (bool3) {}
    try
    {
      this.value_minisdk = paramBaseConfigParser.getIntValue(key_minisdk, this.value_minisdk);
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= this.value_minisdk)
      {
        this.value_local_front = int2byte(paramBaseConfigParser.getIntValue(key_local_front, this.value_local_front));
        this.value_local_back = int2byte(paramBaseConfigParser.getIntValue(key_local_back, this.value_local_back));
        this.value_remote_front_0 = int2byte(paramBaseConfigParser.getIntValue(key_remote_front_0, this.value_remote_front_0));
        this.value_remote_front_90 = int2byte(paramBaseConfigParser.getIntValue(key_remote_front_90, this.value_remote_front_90));
        this.value_remote_front_180 = int2byte(paramBaseConfigParser.getIntValue(key_remote_front_180, this.value_remote_front_180));
        this.value_remote_front_270 = int2byte(paramBaseConfigParser.getIntValue(key_remote_front_270, this.value_remote_front_270));
        this.value_remote_back_0 = int2byte(paramBaseConfigParser.getIntValue(key_remote_back_0, this.value_remote_back_0));
        this.value_remote_back_90 = int2byte(paramBaseConfigParser.getIntValue(key_remote_back_90, this.value_remote_back_90));
        this.value_remote_back_180 = int2byte(paramBaseConfigParser.getIntValue(key_remote_back_180, this.value_remote_back_180));
        this.value_remote_back_270 = int2byte(paramBaseConfigParser.getIntValue(key_remote_back_270, this.value_remote_back_270));
        this.value_sensor = int2byte(paramBaseConfigParser.getIntValue(key_sensor, this.value_sensor));
        bool1 = true;
      }
    }
    catch (Exception paramBaseConfigParser)
    {
      for (;;)
      {
        AVLog.e("CameraConfigParser", "parseConfig fail.", paramBaseConfigParser);
        this.value_local_front = 0;
        this.value_local_back = 0;
        this.value_remote_front_0 = 0;
        this.value_remote_front_90 = 0;
        this.value_remote_front_180 = 0;
        this.value_remote_front_270 = 0;
        this.value_remote_back_0 = 0;
        this.value_remote_back_90 = 0;
        this.value_remote_back_180 = 0;
        this.value_remote_back_270 = 0;
        this.value_sensor = 0;
        this.value_minisdk = 0;
        bool1 = false;
      }
    }
    AVLog.d("CameraConfigParser", "parseConfig isConfigEnabled:" + bool3 + ", value_local_front:" + this.value_local_front + ", value_local_back:" + this.value_local_back + ", value_remote_front_0:" + this.value_remote_front_0 + ", value_remote_front_90:" + this.value_remote_front_90 + ", value_remote_front_180:" + this.value_remote_front_180 + ", value_remote_front_270:" + this.value_remote_front_270 + ", value_remote_back_0:" + this.value_remote_back_0 + ", value_remote_back_90:" + this.value_remote_back_90 + ", value_remote_back_180:" + this.value_remote_back_180 + ", value_remote_back_270:" + this.value_remote_back_270 + ", value_sensor:" + this.value_sensor + ", value_minisdk:" + this.value_minisdk);
    return bool1;
  }
  
  public boolean parseLandscapeConfig(BaseConfigParser paramBaseConfigParser)
  {
    boolean bool2 = false;
    boolean bool3 = isLandscapeConfigEnabled(paramBaseConfigParser);
    bool1 = bool2;
    if (bool3) {}
    try
    {
      this.value_landscape_minisdk = paramBaseConfigParser.getIntValue(key_landscape_minisdk, this.value_landscape_minisdk);
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= this.value_landscape_minisdk)
      {
        this.value_landscape_local_front = int2byte(paramBaseConfigParser.getIntValue(key_landscape_local_front, this.value_landscape_local_front));
        this.value_landscape_local_back = int2byte(paramBaseConfigParser.getIntValue(key_landscape_local_back, this.value_landscape_local_back));
        this.value_landscape_remote_front_0 = int2byte(paramBaseConfigParser.getIntValue(key_landscape_remote_front_0, this.value_landscape_remote_front_0));
        this.value_landscape_remote_front_90 = int2byte(paramBaseConfigParser.getIntValue(key_landscape_remote_front_90, this.value_landscape_remote_front_90));
        this.value_landscape_remote_front_180 = int2byte(paramBaseConfigParser.getIntValue(key_landscape_remote_front_180, this.value_landscape_remote_front_180));
        this.value_landscape_remote_front_270 = int2byte(paramBaseConfigParser.getIntValue(key_landscape_remote_front_270, this.value_landscape_remote_front_270));
        this.value_landscape_remote_back_0 = int2byte(paramBaseConfigParser.getIntValue(key_landscape_remote_back_0, this.value_landscape_remote_back_0));
        this.value_landscape_remote_back_90 = int2byte(paramBaseConfigParser.getIntValue(key_landscape_remote_back_90, this.value_landscape_remote_back_90));
        this.value_landscape_remote_back_180 = int2byte(paramBaseConfigParser.getIntValue(key_landscape_remote_back_180, this.value_landscape_remote_back_180));
        this.value_landscape_remote_back_270 = int2byte(paramBaseConfigParser.getIntValue(key_landscape_remote_back_270, this.value_landscape_remote_back_270));
        this.value_landscape_sensor = int2byte(paramBaseConfigParser.getIntValue(key_landscape_sensor, this.value_landscape_sensor));
        bool1 = true;
      }
    }
    catch (Exception paramBaseConfigParser)
    {
      for (;;)
      {
        AVLog.e("CameraConfigParser", "parseLandscapeConfig fail.", paramBaseConfigParser);
        this.value_landscape_local_front = 0;
        this.value_landscape_local_back = 0;
        this.value_landscape_remote_front_0 = 0;
        this.value_landscape_remote_front_90 = 0;
        this.value_landscape_remote_front_180 = 0;
        this.value_landscape_remote_front_270 = 0;
        this.value_landscape_remote_back_0 = 0;
        this.value_landscape_remote_back_90 = 0;
        this.value_landscape_remote_back_180 = 0;
        this.value_landscape_remote_back_270 = 0;
        this.value_landscape_sensor = 0;
        this.value_landscape_minisdk = 0;
        bool1 = false;
      }
    }
    AVLog.d("CameraConfigParser", "isLandscapeConfigEnabled:" + bool3 + ", value_landscape_local_front:" + this.value_landscape_local_front + ", value_landscape_local_back:" + this.value_landscape_local_back + ", value_landscape_remote_front_0:" + this.value_landscape_remote_front_0 + ", value_landscape_remote_front_90:" + this.value_landscape_remote_front_90 + ", value_landscape_remote_front_180:" + this.value_landscape_remote_front_180 + ", value_landscape_remote_front_270:" + this.value_landscape_remote_front_270 + ", value_landscape_remote_back_0:" + this.value_landscape_remote_back_0 + ", value_landscape_remote_back_90:" + this.value_landscape_remote_back_90 + ", value_landscape_remote_back_180:" + this.value_landscape_remote_back_180 + ", value_landscape_remote_back_270:" + this.value_landscape_remote_back_270 + ", value_landscape_sensor:" + this.value_landscape_sensor + ", value_landscape_minisdk:" + this.value_landscape_minisdk);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.config.CameraConfigParser
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ConfigurationService$DeviceInfo
  extends MessageMicro
{
  public static final int BRAND_FIELD_NUMBER = 1;
  public static final int CAMERA_FIELD_NUMBER = 8;
  public static final int CPU_FIELD_NUMBER = 4;
  public static final int MEMORY_FIELD_NUMBER = 5;
  public static final int MODEL_FIELD_NUMBER = 2;
  public static final int OS_FIELD_NUMBER = 3;
  public static final int SCREEN_FIELD_NUMBER = 7;
  public static final int STORAGE_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "brand", "model", "os", "cpu", "memory", "storage", "screen", "camera" }, new Object[] { "", "", null, null, null, null, null, null }, DeviceInfo.class);
  public final PBStringField brand = PBField.initString("");
  public ConfigurationService.Camera camera = new ConfigurationService.Camera();
  public ConfigurationService.CPU cpu = new ConfigurationService.CPU();
  public ConfigurationService.Memory memory = new ConfigurationService.Memory();
  public final PBStringField model = PBField.initString("");
  public ConfigurationService.OS os = new ConfigurationService.OS();
  public ConfigurationService.Screen screen = new ConfigurationService.Screen();
  public ConfigurationService.Storage storage = new ConfigurationService.Storage();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */
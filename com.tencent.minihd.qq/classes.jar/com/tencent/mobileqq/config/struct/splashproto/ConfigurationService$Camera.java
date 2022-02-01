package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ConfigurationService$Camera
  extends MessageMicro
{
  public static final int FLASH_FIELD_NUMBER = 3;
  public static final int PRIMARY_FIELD_NUMBER = 1;
  public static final int SECONDARY_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "primary", "secondary", "flash" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false) }, Camera.class);
  public final PBBoolField flash = PBField.initBool(false);
  public final PBUInt64Field primary = PBField.initUInt64(0L);
  public final PBUInt64Field secondary = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Camera
 * JD-Core Version:    0.7.0.1
 */
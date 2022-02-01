package com.tencent.pb.getbusiinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BusinessInfoCheckUpdate$AppSetting
  extends MessageMicro
{
  public static final int APPID_FIELD_NUMBER = 1;
  public static final int MODIFY_TS_FIELD_NUMBER = 3;
  public static final int SETTING_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "appid", "setting", "modify_ts" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Long.valueOf(0L) }, AppSetting.class);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBUInt64Field modify_ts = PBField.initUInt64(0L);
  public final PBBoolField setting = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting
 * JD-Core Version:    0.7.0.1
 */
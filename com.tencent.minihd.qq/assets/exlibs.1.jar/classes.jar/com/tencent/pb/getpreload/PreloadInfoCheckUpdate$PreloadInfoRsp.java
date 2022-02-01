package com.tencent.pb.getpreload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class PreloadInfoCheckUpdate$PreloadInfoRsp
  extends MessageMicro
{
  public static final int APPLIST_FIELD_NUMBER = 5;
  public static final int CLICK_RAM_FIELD_NUMBER = 7;
  public static final int HEAD_FIELD_NUMBER = 1;
  public static final int INTERVAL_FIELD_NUMBER = 4;
  public static final int PRELOAD_FIELD_NUMBER = 3;
  public static final int PRELOAD_SWITCH_FIELD_NUMBER = 2;
  public static final int RED_RAM_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 48, 56 }, new String[] { "head", "preload_switch", "preload", "interval", "applist", "red_ram", "click_ram" }, new Object[] { null, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, PreloadInfoRsp.class);
  public final PBRepeatField applist = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt32Field click_ram = PBField.initInt32(0);
  public PreloadInfoCheckUpdate.ControlRspHead head = new PreloadInfoCheckUpdate.ControlRspHead();
  public final PBInt32Field interval = PBField.initInt32(0);
  public final PBBoolField preload = PBField.initBool(false);
  public final PBInt32Field preload_switch = PBField.initInt32(0);
  public final PBInt32Field red_ram = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.getpreload.PreloadInfoCheckUpdate.PreloadInfoRsp
 * JD-Core Version:    0.7.0.1
 */
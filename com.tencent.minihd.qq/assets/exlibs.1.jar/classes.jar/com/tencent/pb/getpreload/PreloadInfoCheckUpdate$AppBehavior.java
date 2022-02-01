package com.tencent.pb.getpreload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PreloadInfoCheckUpdate$AppBehavior
  extends MessageMicro
{
  public static final int APPID_FIELD_NUMBER = 1;
  public static final int CLICK_NUM_FIELD_NUMBER = 2;
  public static final int CLICK_RED_NUM_FIELD_NUMBER = 3;
  public static final int RED_STATE_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "appid", "click_num", "click_red_num", "red_state" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, AppBehavior.class);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBInt32Field click_num = PBField.initInt32(0);
  public final PBInt32Field click_red_num = PBField.initInt32(0);
  public final PBInt32Field red_state = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.getpreload.PreloadInfoCheckUpdate.AppBehavior
 * JD-Core Version:    0.7.0.1
 */
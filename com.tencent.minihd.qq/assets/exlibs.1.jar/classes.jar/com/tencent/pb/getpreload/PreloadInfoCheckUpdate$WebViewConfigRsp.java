package com.tencent.pb.getpreload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class PreloadInfoCheckUpdate$WebViewConfigRsp
  extends MessageMicro
{
  public static final int HEAD_FIELD_NUMBER = 1;
  public static final int INTERVAL_FIELD_NUMBER = 5;
  public static final int JS_REPORT_FIELD_NUMBER = 4;
  public static final int URL_CHECK_FIELD_NUMBER = 2;
  public static final int URL_LIST_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "head", "url_check", "url_list", "js_report", "interval" }, new Object[] { null, Boolean.valueOf(false), "", Boolean.valueOf(false), Integer.valueOf(0) }, WebViewConfigRsp.class);
  public PreloadInfoCheckUpdate.ControlRspHead head = new PreloadInfoCheckUpdate.ControlRspHead();
  public final PBInt32Field interval = PBField.initInt32(0);
  public final PBBoolField js_report = PBField.initBool(false);
  public final PBBoolField url_check = PBField.initBool(false);
  public final PBRepeatField url_list = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.getpreload.PreloadInfoCheckUpdate.WebViewConfigRsp
 * JD-Core Version:    0.7.0.1
 */
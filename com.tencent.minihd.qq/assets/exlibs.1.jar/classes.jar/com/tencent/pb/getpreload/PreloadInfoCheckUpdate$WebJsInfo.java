package com.tencent.pb.getpreload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class PreloadInfoCheckUpdate$WebJsInfo
  extends MessageMicro
{
  public static final int ERR_FILE_FIELD_NUMBER = 3;
  public static final int ERR_LINE_FIELD_NUMBER = 4;
  public static final int ERR_MESSAGE_FIELD_NUMBER = 5;
  public static final int ERR_PAGE_URL_FIELD_NUMBER = 2;
  public static final int ERR_TIMESTAMP_FIELD_NUMBER = 6;
  public static final int HEAD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48 }, new String[] { "head", "err_page_url", "err_file", "err_line", "err_message", "err_timestamp" }, new Object[] { null, "", "", "", "", Long.valueOf(0L) }, WebJsInfo.class);
  public final PBStringField err_file = PBField.initString("");
  public final PBStringField err_line = PBField.initString("");
  public final PBStringField err_message = PBField.initString("");
  public final PBStringField err_page_url = PBField.initString("");
  public final PBInt64Field err_timestamp = PBField.initInt64(0L);
  public PreloadInfoCheckUpdate.ControlReqHead head = new PreloadInfoCheckUpdate.ControlReqHead();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.getpreload.PreloadInfoCheckUpdate.WebJsInfo
 * JD-Core Version:    0.7.0.1
 */
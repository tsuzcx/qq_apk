package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class mobileqq_mp$WebviewWhiteListResponse
  extends MessageMicro
{
  public static final int DATA_FIELD_NUMBER = 3;
  public static final int RET_INFO_FIELD_NUMBER = 1;
  public static final int VERSION_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "ret_info", "version", "data" }, new Object[] { null, "", "" }, WebviewWhiteListResponse.class);
  public final PBStringField data = PBField.initString("");
  public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.WebviewWhiteListResponse
 * JD-Core Version:    0.7.0.1
 */
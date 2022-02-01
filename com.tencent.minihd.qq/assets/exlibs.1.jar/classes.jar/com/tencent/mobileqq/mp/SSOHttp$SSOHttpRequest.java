package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SSOHttp$SSOHttpRequest
  extends MessageMicro
{
  public static final int BODY_FIELD_NUMBER = 3;
  public static final int HEADER_FIELD_NUMBER = 2;
  public static final int URI_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "uri", "header", "body" }, new Object[] { "", "", "" }, SSOHttpRequest.class);
  public final PBStringField body = PBField.initString("");
  public final PBStringField header = PBField.initString("");
  public final PBStringField uri = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mp.SSOHttp.SSOHttpRequest
 * JD-Core Version:    0.7.0.1
 */
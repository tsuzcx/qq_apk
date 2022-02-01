package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SSOHttp$GdtAdRequest
  extends MessageMicro
{
  public static final int PARAMS_FIELD_NUMBER = 3;
  public static final int PUBLICACCOUNT_FIELD_NUMBER = 1;
  public static final int URL_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "publicAccount", "url", "params" }, new Object[] { "", "", "" }, GdtAdRequest.class);
  public final PBStringField params = PBField.initString("");
  public final PBStringField publicAccount = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mp.SSOHttp.GdtAdRequest
 * JD-Core Version:    0.7.0.1
 */
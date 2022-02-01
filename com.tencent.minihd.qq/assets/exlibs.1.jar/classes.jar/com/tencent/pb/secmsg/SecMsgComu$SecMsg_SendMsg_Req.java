package com.tencent.pb.secmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SecMsgComu$SecMsg_SendMsg_Req
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 2;
  public static final int SSID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ssid", "content" }, new Object[] { "", "" }, SecMsg_SendMsg_Req.class);
  public final PBStringField content = PBField.initString("");
  public final PBStringField ssid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.secmsg.SecMsgComu.SecMsg_SendMsg_Req
 * JD-Core Version:    0.7.0.1
 */
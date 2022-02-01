package com.tencent.pb.chatbgInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class chatbgInfo$Platform_Comm_Req
  extends MessageMicro
{
  public static final int IMPLAT_FIELD_NUMBER = 1;
  public static final int MQQVER_FIELD_NUMBER = 3;
  public static final int OSVER_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ImPlat", "osver", "mqqver" }, new Object[] { Long.valueOf(0L), "", "" }, Platform_Comm_Req.class);
  public final PBInt64Field ImPlat = PBField.initInt64(0L);
  public final PBStringField mqqver = PBField.initString("");
  public final PBStringField osver = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.chatbgInfo.chatbgInfo.Platform_Comm_Req
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.IndividPub;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class IndividPub$Platform_Comm_Req
  extends MessageMicro
{
  public static final int MQQVER_FIELD_NUMBER = 3;
  public static final int OSVER_FIELD_NUMBER = 2;
  public static final int PLATFORM_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "platForm", "osver", "mqqver" }, new Object[] { Long.valueOf(0L), "", "" }, Platform_Comm_Req.class);
  public final PBStringField mqqver = PBField.initString("");
  public final PBStringField osver = PBField.initString("");
  public final PBInt64Field platForm = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.IndividPub.IndividPub.Platform_Comm_Req
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.IndividPub;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class IndividPub$expTips_Pull_Rsp
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 2;
  public static final int EXPFLAG_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "expFlag", "content" }, new Object[] { Integer.valueOf(0), "" }, expTips_Pull_Rsp.class);
  public final PBStringField content = PBField.initString("");
  public final PBUInt32Field expFlag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.IndividPub.IndividPub.expTips_Pull_Rsp
 * JD-Core Version:    0.7.0.1
 */
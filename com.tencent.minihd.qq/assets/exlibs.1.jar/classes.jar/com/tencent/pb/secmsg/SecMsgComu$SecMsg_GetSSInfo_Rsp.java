package com.tencent.pb.secmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SecMsgComu$SecMsg_GetSSInfo_Rsp
  extends MessageMicro
{
  public static final int SSINFO_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ssinfo" }, new Object[] { null }, SecMsg_GetSSInfo_Rsp.class);
  public final PBRepeatMessageField ssinfo = PBField.initRepeatMessage(SecMsgComu.SecMsg_SSInfo_Item.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.secmsg.SecMsgComu.SecMsg_GetSSInfo_Rsp
 * JD-Core Version:    0.7.0.1
 */
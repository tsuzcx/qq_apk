package com.tencent.pb.secmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class SecMsgComu$SecMsg_CreateSS_Req
  extends MessageMicro
{
  public static final int PAPER_ID_FIELD_NUMBER = 2;
  public static final int TITLE_FIELD_NUMBER = 3;
  public static final int TOUIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "touin", "paper_id", "title" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "" }, SecMsg_CreateSS_Req.class);
  public final PBInt64Field paper_id = PBField.initInt64(0L);
  public final PBStringField title = PBField.initString("");
  public final PBInt64Field touin = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.secmsg.SecMsgComu.SecMsg_CreateSS_Req
 * JD-Core Version:    0.7.0.1
 */
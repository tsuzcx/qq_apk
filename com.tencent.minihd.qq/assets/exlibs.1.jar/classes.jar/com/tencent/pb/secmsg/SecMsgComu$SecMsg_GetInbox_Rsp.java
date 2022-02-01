package com.tencent.pb.secmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SecMsgComu$SecMsg_GetInbox_Rsp
  extends MessageMicro
{
  public static final int FLAG_FIELD_NUMBER = 1;
  public static final int MSG_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "flag", "msg" }, new Object[] { Long.valueOf(0L), null }, SecMsg_GetInbox_Rsp.class);
  public final PBUInt64Field flag = PBField.initUInt64(0L);
  public final PBRepeatMessageField msg = PBField.initRepeatMessage(SecMsgComu.SecMsg_Msg_Item.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.secmsg.SecMsgComu.SecMsg_GetInbox_Rsp
 * JD-Core Version:    0.7.0.1
 */
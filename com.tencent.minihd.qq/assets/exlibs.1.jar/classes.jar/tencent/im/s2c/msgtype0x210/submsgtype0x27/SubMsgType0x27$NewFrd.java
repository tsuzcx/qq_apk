package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SubMsgType0x27$NewFrd
  extends MessageMicro
{
  public static final int RPT_MSG_ONE_NEW_FRD_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 26 }, new String[] { "rpt_msg_one_new_frd" }, new Object[] { null }, NewFrd.class);
  public final PBRepeatMessageField rpt_msg_one_new_frd = PBField.initRepeatMessage(SubMsgType0x27.OneNewFrd.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.NewFrd
 * JD-Core Version:    0.7.0.1
 */
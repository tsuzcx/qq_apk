package tencent.im.s2c.msgtype0x210.submsgtype0x76;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SubMsgType0x76$BirthdayNotify
  extends MessageMicro
{
  public static final int RPT_MSG_ONE_FRIEND_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_one_friend" }, new Object[] { null }, BirthdayNotify.class);
  public final PBRepeatMessageField rpt_msg_one_friend = PBField.initRepeatMessage(SubMsgType0x76.OneBirthdayFriend.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.BirthdayNotify
 * JD-Core Version:    0.7.0.1
 */
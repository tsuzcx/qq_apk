package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class im_msg_head$InstCtrl
  extends MessageMicro
{
  public static final int MSG_FROM_INST_FIELD_NUMBER = 3;
  public static final int RPT_MSG_EXCLUDE_INST_FIELD_NUMBER = 2;
  public static final int RPT_MSG_SEND_TO_INST_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "rpt_msg_send_to_inst", "rpt_msg_exclude_inst", "msg_from_inst" }, new Object[] { null, null, null }, InstCtrl.class);
  public im_msg_head.InstInfo msg_from_inst = new im_msg_head.InstInfo();
  public final PBRepeatMessageField rpt_msg_exclude_inst = PBField.initRepeatMessage(im_msg_head.InstInfo.class);
  public final PBRepeatMessageField rpt_msg_send_to_inst = PBField.initRepeatMessage(im_msg_head.InstInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_head.InstCtrl
 * JD-Core Version:    0.7.0.1
 */
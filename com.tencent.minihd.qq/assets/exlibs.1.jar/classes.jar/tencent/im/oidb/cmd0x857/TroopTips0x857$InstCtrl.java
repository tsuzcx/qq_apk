package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class TroopTips0x857$InstCtrl
  extends MessageMicro
{
  public static final int MSG_FROM_INST_FIELD_NUMBER = 3;
  public static final int RPT_MSG_EXCLUDE_INST_FIELD_NUMBER = 2;
  public static final int RPT_MSG_SEND_TO_INST_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "rpt_msg_send_to_inst", "rpt_msg_exclude_inst", "msg_from_inst" }, new Object[] { null, null, null }, InstCtrl.class);
  public TroopTips0x857.InstInfo msg_from_inst = new TroopTips0x857.InstInfo();
  public final PBRepeatMessageField rpt_msg_exclude_inst = PBField.initRepeatMessage(TroopTips0x857.InstInfo.class);
  public final PBRepeatMessageField rpt_msg_send_to_inst = PBField.initRepeatMessage(TroopTips0x857.InstInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.InstCtrl
 * JD-Core Version:    0.7.0.1
 */
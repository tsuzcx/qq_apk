package tencent.im.oidb.cmd0x7d0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x7d0$RspLoginCard
  extends MessageMicro
{
  public static final int RPT_MSG_LOGIN_CARD_FIELD_NUMBER = 4;
  public static final int UINT32_EXPIRED_TIME_FIELD_NUMBER = 2;
  public static final int UINT32_HAS_MORE_FIELD_NUMBER = 3;
  public static final int UINT32_SEQUENCE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_sequence", "uint32_expired_time", "uint32_has_more", "rpt_msg_login_card" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, RspLoginCard.class);
  public final PBRepeatMessageField rpt_msg_login_card = PBField.initRepeatMessage(oidb_cmd0x7d0.one_login_card.class);
  public final PBUInt32Field uint32_expired_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_has_more = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7d0.oidb_cmd0x7d0.RspLoginCard
 * JD-Core Version:    0.7.0.1
 */
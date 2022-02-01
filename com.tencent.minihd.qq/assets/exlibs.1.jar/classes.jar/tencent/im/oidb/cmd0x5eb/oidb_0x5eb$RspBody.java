package tencent.im.oidb.cmd0x5eb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5eb$RspBody
  extends MessageMicro
{
  public static final int RPT_MSG_UIN_DATA_FIELD_NUMBER = 11;
  public static final int RPT_UINT64_UNFINISHED_UINS_FIELD_NUMBER = 12;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 96 }, new String[] { "rpt_msg_uin_data", "rpt_uint64_unfinished_uins" }, new Object[] { null, Long.valueOf(0L) }, RspBody.class);
  public final PBRepeatMessageField rpt_msg_uin_data = PBField.initRepeatMessage(oidb_0x5eb.UdcUinData.class);
  public final PBRepeatField rpt_uint64_unfinished_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody
 * JD-Core Version:    0.7.0.1
 */
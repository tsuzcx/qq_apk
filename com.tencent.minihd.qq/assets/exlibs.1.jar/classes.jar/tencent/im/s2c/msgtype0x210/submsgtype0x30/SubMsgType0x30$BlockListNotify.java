package tencent.im.s2c.msgtype0x210.submsgtype0x30;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x30$BlockListNotify
  extends MessageMicro
{
  public static final int RPT_MSG_BLOCK_UIN_INFO_FIELD_NUMBER = 1;
  public static final int RPT_UINT64_DEL_UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_msg_block_uin_info", "rpt_uint64_del_uin" }, new Object[] { null, Long.valueOf(0L) }, BlockListNotify.class);
  public final PBRepeatMessageField rpt_msg_block_uin_info = PBField.initRepeatMessage(SubMsgType0x30.BlockUinInfo.class);
  public final PBRepeatField rpt_uint64_del_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x30.SubMsgType0x30.BlockListNotify
 * JD-Core Version:    0.7.0.1
 */
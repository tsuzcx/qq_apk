package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x27$SnsUpateBuffer
  extends MessageMicro
{
  public static final int RPT_MSG_SNS_UPDATE_ITEM_FIELD_NUMBER = 400;
  public static final int RPT_UINT32_IDLIST_FIELD_NUMBER = 401;
  public static final int UINT64_CODE_FIELD_NUMBER = 2;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 3202, 3208 }, new String[] { "uint64_uin", "uint64_code", "rpt_msg_sns_update_item", "rpt_uint32_idlist" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null, Integer.valueOf(0) }, SnsUpateBuffer.class);
  public final PBRepeatMessageField rpt_msg_sns_update_item = PBField.initRepeatMessage(SubMsgType0x27.SnsUpdateItem.class);
  public final PBRepeatField rpt_uint32_idlist = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt64Field uint64_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpateBuffer
 * JD-Core Version:    0.7.0.1
 */
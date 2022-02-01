package tencent.im.s2c.msgtype0x210.submsgtype0x26;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x26$MsgBody$SubCmd0x2UpdateAppList
  extends MessageMicro
{
  public static final int RPT_MSG_APP_ID_FIELD_NUMBER = 1;
  public static final int RPT_UINT32_TIME_STAMP_FIELD_NUMBER = 2;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "rpt_msg_app_id", "rpt_uint32_time_stamp", "uint64_group_code" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L) }, SubCmd0x2UpdateAppList.class);
  public final PBRepeatMessageField rpt_msg_app_id = PBField.initRepeatMessage(submsgtype0x26.AppID.class);
  public final PBRepeatField rpt_uint32_time_stamp = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x2UpdateAppList
 * JD-Core Version:    0.7.0.1
 */
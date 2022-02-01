package tencent.im.longconn.longmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LongMsg$ReqBody
  extends MessageMicro
{
  public static final int RPT_MSG_DOWN_REQ_FIELD_NUMBER = 5;
  public static final int RPT_MSG_UP_REQ_FIELD_NUMBER = 4;
  public static final int UINT32_PLATFORM_TYPE_FIELD_NUMBER = 3;
  public static final int UINT32_SUBCMD_FIELD_NUMBER = 1;
  public static final int UINT32_TERM_TYPE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "uint32_subcmd", "uint32_term_type", "uint32_platform_type", "rpt_msg_up_req", "rpt_msg_down_req" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null }, ReqBody.class);
  public final PBRepeatMessageField rpt_msg_down_req = PBField.initRepeatMessage(LongMsg.MsgDownReq.class);
  public final PBRepeatMessageField rpt_msg_up_req = PBField.initRepeatMessage(LongMsg.MsgUpReq.class);
  public final PBUInt32Field uint32_platform_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_term_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.longconn.longmsg.LongMsg.ReqBody
 * JD-Core Version:    0.7.0.1
 */
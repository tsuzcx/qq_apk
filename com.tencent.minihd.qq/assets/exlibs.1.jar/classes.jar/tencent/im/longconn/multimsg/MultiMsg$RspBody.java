package tencent.im.longconn.multimsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MultiMsg$RspBody
  extends MessageMicro
{
  public static final int RPT_MULTIMSG_APPLYDOWN_RSP_FIELD_NUMBER = 3;
  public static final int RPT_MULTIMSG_APPLYUP_RSP_FIELD_NUMBER = 2;
  public static final int UINT32_SUBCMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_subcmd", "rpt_multimsg_applyup_rsp", "rpt_multimsg_applydown_rsp" }, new Object[] { Integer.valueOf(0), null, null }, RspBody.class);
  public final PBRepeatMessageField rpt_multimsg_applydown_rsp = PBField.initRepeatMessage(MultiMsg.MultiMsgApplyDownRsp.class);
  public final PBRepeatMessageField rpt_multimsg_applyup_rsp = PBField.initRepeatMessage(MultiMsg.MultiMsgApplyUpRsp.class);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.longconn.multimsg.MultiMsg.RspBody
 * JD-Core Version:    0.7.0.1
 */
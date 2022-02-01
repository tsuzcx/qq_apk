package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x345$RspBody
  extends MessageMicro
{
  public static final int MSG_SUBCMD_0X1_RSP_BODY_FIELD_NUMBER = 3;
  public static final int MSG_SUBCMD_0X2_RSP_BODY_FIELD_NUMBER = 4;
  public static final int MSG_SUBCMD_0X3_RSP_BODY_FIELD_NUMBER = 5;
  public static final int MSG_SUBCMD_0X4_RSP_BODY_FIELD_NUMBER = 6;
  public static final int MSG_SUBCMD_0X5_RSP_BODY_FIELD_NUMBER = 7;
  public static final int MSG_SUBCMD_0X6_RSP_BODY_FIELD_NUMBER = 8;
  public static final int MSG_SUBCMD_0X7_RSP_BODY_FIELD_NUMBER = 9;
  public static final int UINT32_RETURN_CODE_FIELD_NUMBER = 2;
  public static final int UINT32_SUB_CMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74 }, new String[] { "uint32_sub_cmd", "uint32_return_code", "msg_subcmd_0x1_rsp_body", "msg_subcmd_0x2_rsp_body", "msg_subcmd_0x3_rsp_body", "msg_subcmd_0x4_rsp_body", "msg_subcmd_0x5_rsp_body", "msg_subcmd_0x6_rsp_body", "msg_subcmd_0x7_rsp_body" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, null }, RspBody.class);
  public cmd0x345.RspBody.SubCmd0x1RspBody msg_subcmd_0x1_rsp_body = new cmd0x345.RspBody.SubCmd0x1RspBody();
  public cmd0x345.RspBody.SubCmd0x2RspBody msg_subcmd_0x2_rsp_body = new cmd0x345.RspBody.SubCmd0x2RspBody();
  public cmd0x345.RspBody.SubCmd0x3RspBody msg_subcmd_0x3_rsp_body = new cmd0x345.RspBody.SubCmd0x3RspBody();
  public cmd0x345.RspBody.SubCmd0x4RspBody msg_subcmd_0x4_rsp_body = new cmd0x345.RspBody.SubCmd0x4RspBody();
  public cmd0x345.RspBody.SubCmd0x5RspBody msg_subcmd_0x5_rsp_body = new cmd0x345.RspBody.SubCmd0x5RspBody();
  public cmd0x345.RspBody.SubCmd0x6RspBody msg_subcmd_0x6_rsp_body = new cmd0x345.RspBody.SubCmd0x6RspBody();
  public cmd0x345.RspBody.SubCmd0x7RspBody msg_subcmd_0x7_rsp_body = new cmd0x345.RspBody.SubCmd0x7RspBody();
  public final PBUInt32Field uint32_return_code = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x345.cmd0x345.RspBody
 * JD-Core Version:    0.7.0.1
 */
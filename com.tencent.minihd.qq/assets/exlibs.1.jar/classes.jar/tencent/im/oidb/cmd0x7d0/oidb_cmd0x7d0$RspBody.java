package tencent.im.oidb.cmd0x7d0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x7d0$RspBody
  extends MessageMicro
{
  public static final int MSG_RSP_BASIC_INFO_FIELD_NUMBER = 3;
  public static final int MSG_RSP_LOGIN_CARD_FIELD_NUMBER = 5;
  public static final int MSG_RSP_LOGIN_INFO_FIELD_NUMBER = 4;
  public static final int STR_ERROR_MSG_FIELD_NUMBER = 2;
  public static final int UINT32_RESULT_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uint32_result", "str_error_msg", "msg_rsp_basic_info", "msg_rsp_login_info", "msg_rsp_login_card" }, new Object[] { Integer.valueOf(0), "", null, null, null }, RspBody.class);
  public oidb_cmd0x7d0.RspBasicInfo msg_rsp_basic_info = new oidb_cmd0x7d0.RspBasicInfo();
  public oidb_cmd0x7d0.RspLoginCard msg_rsp_login_card = new oidb_cmd0x7d0.RspLoginCard();
  public oidb_cmd0x7d0.RspLoginInfo msg_rsp_login_info = new oidb_cmd0x7d0.RspLoginInfo();
  public final PBStringField str_error_msg = PBField.initString("");
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7d0.oidb_cmd0x7d0.RspBody
 * JD-Core Version:    0.7.0.1
 */
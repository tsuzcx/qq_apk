package tencent.im.oidb.cmd0x7d0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x7d0$ReqBody
  extends MessageMicro
{
  public static final int MSG_REQ_BASIC_INFO_FIELD_NUMBER = 1;
  public static final int MSG_REQ_LOGIN_CARD_FIELD_NUMBER = 3;
  public static final int UINT32_REQ_LOGIN_INFO_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_req_basic_info", "uint32_req_login_info", "msg_req_login_card" }, new Object[] { null, Integer.valueOf(0), null }, ReqBody.class);
  public oidb_cmd0x7d0.ReqBasicInfo msg_req_basic_info = new oidb_cmd0x7d0.ReqBasicInfo();
  public oidb_cmd0x7d0.ReqLoginCard msg_req_login_card = new oidb_cmd0x7d0.ReqLoginCard();
  public final PBUInt32Field uint32_req_login_info = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7d0.oidb_cmd0x7d0.ReqBody
 * JD-Core Version:    0.7.0.1
 */
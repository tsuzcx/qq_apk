package tencent.im.oidb.cmd0x7d0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x7d0$RspLoginInfo
  extends MessageMicro
{
  public static final int MSG_LOGIN_DATE_INFO_FIELD_NUMBER = 2;
  public static final int UINT32_SEQUENCE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_sequence", "msg_login_date_info" }, new Object[] { Integer.valueOf(0), null }, RspLoginInfo.class);
  public oidb_cmd0x7d0.login_date_info msg_login_date_info = new oidb_cmd0x7d0.login_date_info();
  public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7d0.oidb_cmd0x7d0.RspLoginInfo
 * JD-Core Version:    0.7.0.1
 */
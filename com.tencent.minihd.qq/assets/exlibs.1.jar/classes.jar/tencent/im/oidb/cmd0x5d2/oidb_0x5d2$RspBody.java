package tencent.im.oidb.cmd0x5d2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x5d2$RspBody
  extends MessageMicro
{
  public static final int RSP_GET_INFO_FIELD_NUMBER = 3;
  public static final int RSP_GET_LIST_FIELD_NUMBER = 2;
  public static final int SUB_CMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "sub_cmd", "rsp_get_list", "rsp_get_info" }, new Object[] { Integer.valueOf(0), null, null }, RspBody.class);
  public oidb_0x5d2.RspGetInfo rsp_get_info = new oidb_0x5d2.RspGetInfo();
  public oidb_0x5d2.RspGetList rsp_get_list = new oidb_0x5d2.RspGetList();
  public final PBUInt32Field sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5d2.oidb_0x5d2.RspBody
 * JD-Core Version:    0.7.0.1
 */
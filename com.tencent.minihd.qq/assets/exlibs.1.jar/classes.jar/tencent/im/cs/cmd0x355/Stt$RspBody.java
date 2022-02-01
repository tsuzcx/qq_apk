package tencent.im.cs.cmd0x355;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Stt$RspBody
  extends MessageMicro
{
  public static final int MSG_C2C_PTT_RESP_FIELD_NUMBER = 3;
  public static final int MSG_GROUP_PTT_RESP_FIELD_NUMBER = 2;
  public static final int UINT32_SUB_CMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_sub_cmd", "msg_group_ptt_resp", "msg_c2c_ptt_resp" }, new Object[] { Integer.valueOf(0), null, null }, RspBody.class);
  public Stt.TransC2CPttResp msg_c2c_ptt_resp = new Stt.TransC2CPttResp();
  public Stt.TransGroupPttResp msg_group_ptt_resp = new Stt.TransGroupPttResp();
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x355.Stt.RspBody
 * JD-Core Version:    0.7.0.1
 */
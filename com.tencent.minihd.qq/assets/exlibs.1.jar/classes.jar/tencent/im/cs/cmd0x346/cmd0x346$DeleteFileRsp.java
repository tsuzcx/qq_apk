package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0x346$DeleteFileRsp
  extends MessageMicro
{
  public static final int INT32_RET_CODE_FIELD_NUMBER = 10;
  public static final int STR_RET_MSG_FIELD_NUMBER = 20;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162 }, new String[] { "int32_ret_code", "str_ret_msg" }, new Object[] { Integer.valueOf(0), "" }, DeleteFileRsp.class);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBStringField str_ret_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.DeleteFileRsp
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0x345$RspBody$SubCmd0x6RspBody
  extends MessageMicro
{
  public static final int STR_FILE_ID_FIELD_NUMBER = 2;
  public static final int STR_RET_MSG_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_ret_msg", "str_file_id" }, new Object[] { "", "" }, SubCmd0x6RspBody.class);
  public final PBStringField str_file_id = PBField.initString("");
  public final PBStringField str_ret_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x6RspBody
 * JD-Core Version:    0.7.0.1
 */
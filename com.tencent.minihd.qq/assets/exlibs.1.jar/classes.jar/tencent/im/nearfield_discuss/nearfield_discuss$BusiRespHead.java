package tencent.im.nearfield_discuss;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class nearfield_discuss$BusiRespHead
  extends MessageMicro
{
  public static final int INT32_REPLY_CODE_FIELD_NUMBER = 3;
  public static final int INT32_SEQ_FIELD_NUMBER = 2;
  public static final int INT32_VERSION_FIELD_NUMBER = 1;
  public static final int STR_RESULT_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "int32_version", "int32_seq", "int32_reply_code", "str_result" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), "" }, BusiRespHead.class);
  public final PBInt32Field int32_reply_code = PBField.initInt32(0);
  public final PBInt32Field int32_seq = PBField.initInt32(0);
  public final PBInt32Field int32_version = PBField.initInt32(1);
  public final PBStringField str_result = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.nearfield_discuss.nearfield_discuss.BusiRespHead
 * JD-Core Version:    0.7.0.1
 */
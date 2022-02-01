package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x345$RspBody$SubCmd0x3RspBody
  extends MessageMicro
{
  public static final int BYTES_SHA_FIELD_NUMBER = 9;
  public static final int INT32_RET_CODE_FIELD_NUMBER = 7;
  public static final int STR_CHECK_SUM_FIELD_NUMBER = 3;
  public static final int STR_COOKIE_FIELD_NUMBER = 4;
  public static final int STR_HOST_FIELD_NUMBER = 1;
  public static final int STR_RET_MSG_FIELD_NUMBER = 6;
  public static final int STR_SUGGEST_FILE_NAME_FIELD_NUMBER = 8;
  public static final int UINT32_COSTOM_ID_FIELD_NUMBER = 5;
  public static final int UINT32_PORT_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBStringField str_check_sum = PBField.initString("");
  public final PBStringField str_cookie = PBField.initString("");
  public final PBStringField str_host = PBField.initString("");
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBStringField str_suggest_file_name = PBField.initString("");
  public final PBUInt32Field uint32_costom_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_port = PBField.initUInt32(80);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 50, 56, 66, 74 }, new String[] { "str_host", "uint32_port", "str_check_sum", "str_cookie", "uint32_costom_id", "str_ret_msg", "int32_ret_code", "str_suggest_file_name", "bytes_sha" }, new Object[] { "", Integer.valueOf(80), "", "", Integer.valueOf(0), "", Integer.valueOf(0), "", localByteStringMicro }, SubCmd0x3RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x3RspBody
 * JD-Core Version:    0.7.0.1
 */
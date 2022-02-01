package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x346$ApplyForwardFileRsp
  extends MessageMicro
{
  public static final int BYTES_UUID_FIELD_NUMBER = 50;
  public static final int INT32_RET_CODE_FIELD_NUMBER = 10;
  public static final int STR_RET_MSG_FIELD_NUMBER = 20;
  public static final int UINT64_TOTAL_SPACE_FIELD_NUMBER = 30;
  public static final int UINT64_USED_SPACE_FIELD_NUMBER = 40;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_used_space = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 240, 320, 402 }, new String[] { "int32_ret_code", "str_ret_msg", "uint64_total_space", "uint64_used_space", "bytes_uuid" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, ApplyForwardFileRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.ApplyForwardFileRsp
 * JD-Core Version:    0.7.0.1
 */
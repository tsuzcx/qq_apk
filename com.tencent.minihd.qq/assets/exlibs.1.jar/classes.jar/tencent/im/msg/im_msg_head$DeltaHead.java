package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_head$DeltaHead
  extends MessageMicro
{
  public static final int BYTES_ACK_COOKIE_FIELD_NUMBER = 5;
  public static final int BYTES_COOKIE_FIELD_NUMBER = 4;
  public static final int UINT32_FLAGS_FIELD_NUMBER = 7;
  public static final int UINT32_RESULT_FIELD_NUMBER = 6;
  public static final int UINT64_ACK_OFFSET_FIELD_NUMBER = 3;
  public static final int UINT64_OFFSET_FIELD_NUMBER = 2;
  public static final int UINT64_TOTAL_LEN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ack_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_flags = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt64Field uint64_ack_offset = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_offset = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_total_len = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56 }, new String[] { "uint64_total_len", "uint64_offset", "uint64_ack_offset", "bytes_cookie", "bytes_ack_cookie", "uint32_result", "uint32_flags" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, DeltaHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_head.DeltaHead
 * JD-Core Version:    0.7.0.1
 */
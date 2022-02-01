package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class im_msg_body$ElemFlags
  extends MessageMicro
{
  public static final int BYTES_BUSINESS_DATA_FIELD_NUMBER = 2;
  public static final int BYTES_FLAGS1_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_business_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_flags1 = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_flags1", "bytes_business_data" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, ElemFlags.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.ElemFlags
 * JD-Core Version:    0.7.0.1
 */
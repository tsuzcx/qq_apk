package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$MsgDecodeTestBufElem
  extends MessageMicro
{
  public static final int BUF_FIELD_NUMBER = 5;
  public static final int ENCODE_FIELD_NUMBER = 6;
  public static final int FLAGS_FIELD_NUMBER = 4;
  public static final int FMT_FIELD_NUMBER = 1;
  public static final int LINE_FIELD_NUMBER = 3;
  public static final int MSG_TYPE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBoolField encode = PBField.initBool(false);
  public final PBUInt32Field flags = PBField.initUInt32(0);
  public final PBUInt32Field fmt = PBField.initUInt32(0);
  public final PBUInt32Field line = PBField.initUInt32(0);
  public final PBUInt32Field msg_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "fmt", "msg_type", "line", "flags", "buf", "encode" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Boolean.valueOf(false) }, MsgDecodeTestBufElem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.MsgDecodeTestBufElem
 * JD-Core Version:    0.7.0.1
 */
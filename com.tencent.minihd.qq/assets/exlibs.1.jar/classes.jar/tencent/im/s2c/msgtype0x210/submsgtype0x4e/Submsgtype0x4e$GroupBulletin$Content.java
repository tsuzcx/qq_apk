package tencent.im.s2c.msgtype0x210.submsgtype0x4e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Submsgtype0x4e$GroupBulletin$Content
  extends MessageMicro
{
  public static final int BYTES_FEEDID_FIELD_NUMBER = 1;
  public static final int UINT32_TIME_FIELD_NUMBER = 3;
  public static final int UINT64_UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_feedid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFixed32Field uint32_time = PBField.initFixed32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 29 }, new String[] { "bytes_feedid", "uint64_uin", "uint32_time" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0) }, Content.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.GroupBulletin.Content
 * JD-Core Version:    0.7.0.1
 */
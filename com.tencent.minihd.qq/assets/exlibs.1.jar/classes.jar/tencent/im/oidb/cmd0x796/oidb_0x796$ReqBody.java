package tencent.im.oidb.cmd0x796;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x796$ReqBody
  extends MessageMicro
{
  public static final int FEEDSID_FIELD_NUMBER = 1;
  public static final int STLASTINFO_FIELD_NUMBER = 5;
  public static final int UINT32_SEQ_FIELD_NUMBER = 6;
  public static final int UINT32_TYPE_FIELD_NUMBER = 4;
  public static final int UINT64_TIME_FIELD_NUMBER = 2;
  public static final int UINT64_UIN_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField feedsid = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x796.ItemInfo stLastInfo = new oidb_0x796.ItemInfo();
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 48 }, new String[] { "feedsid", "uint64_time", "uint64_uin", "uint32_type", "stLastInfo", "uint32_seq" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x796.oidb_0x796.ReqBody
 * JD-Core Version:    0.7.0.1
 */
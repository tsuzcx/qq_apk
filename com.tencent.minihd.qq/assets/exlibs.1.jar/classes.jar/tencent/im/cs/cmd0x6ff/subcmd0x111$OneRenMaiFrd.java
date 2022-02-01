package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class subcmd0x111$OneRenMaiFrd
  extends MessageMicro
{
  public static final int BYTES_NICK_FIELD_NUMBER = 4;
  public static final int BYTES_REMARK_FIELD_NUMBER = 3;
  public static final int UINT32_CLOSENESS_FIELD_NUMBER = 5;
  public static final int UINT32_GROUP_FIELD_NUMBER = 6;
  public static final int UINT32_UPDATE_TIME_FIELD_NUMBER = 2;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_closeness = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48 }, new String[] { "uint64_uin", "uint32_update_time", "bytes_remark", "bytes_nick", "uint32_closeness", "uint32_group" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, OneRenMaiFrd.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x111.OneRenMaiFrd
 * JD-Core Version:    0.7.0.1
 */
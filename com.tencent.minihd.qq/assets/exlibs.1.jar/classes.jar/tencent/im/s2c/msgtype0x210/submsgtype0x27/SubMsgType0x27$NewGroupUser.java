package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x27$NewGroupUser
  extends MessageMicro
{
  public static final int BYTES_DISTANCE_FIELD_NUMBER = 5;
  public static final int INT32_AGE_FIELD_NUMBER = 3;
  public static final int INT32_SEX_FIELD_NUMBER = 2;
  public static final int STR_NICK_FIELD_NUMBER = 4;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_distance = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_age = PBField.initInt32(0);
  public final PBInt32Field int32_sex = PBField.initInt32(0);
  public final PBStringField str_nick = PBField.initString("");
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "uint64_uin", "int32_sex", "int32_age", "str_nick", "bytes_distance" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro }, NewGroupUser.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.NewGroupUser
 * JD-Core Version:    0.7.0.1
 */
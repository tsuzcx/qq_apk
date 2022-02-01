package tencent.im.fanpaizi;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FanPaiZi$UserProfile
  extends MessageMicro
{
  public static final int BYTES_FACE_URL_FIELD_NUMBER = 2;
  public static final int BYTES_SIG_FIELD_NUMBER = 8;
  public static final int INT32_AGE_FIELD_NUMBER = 4;
  public static final int INT32_PRISED_FIELD_NUMBER = 6;
  public static final int INT32_SEX_FIELD_NUMBER = 3;
  public static final int STR_NICK_FIELD_NUMBER = 5;
  public static final int UINT64_TINYID_FIELD_NUMBER = 1;
  public static final int UINT64_UIN_FIELD_NUMBER = 7;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_face_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_age = PBField.initInt32(0);
  public final PBInt32Field int32_prised = PBField.initInt32(0);
  public final PBInt32Field int32_sex = PBField.initInt32(0);
  public final PBStringField str_nick = PBField.initString("");
  public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48, 56, 66 }, new String[] { "uint64_tinyid", "bytes_face_url", "int32_sex", "int32_age", "str_nick", "int32_prised", "uint64_uin", "bytes_sig" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2 }, UserProfile.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.fanpaizi.FanPaiZi.UserProfile
 * JD-Core Version:    0.7.0.1
 */
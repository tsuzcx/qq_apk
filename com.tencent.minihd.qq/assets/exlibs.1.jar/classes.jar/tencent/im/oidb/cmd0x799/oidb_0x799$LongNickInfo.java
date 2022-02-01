package tencent.im.oidb.cmd0x799;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x799$LongNickInfo
  extends MessageMicro
{
  public static final int DWCREATETIME_FIELD_NUMBER = 4;
  public static final int DWDELTIME_FIELD_NUMBER = 6;
  public static final int DWMODITIME_FIELD_NUMBER = 5;
  public static final int STRNICK_FIELD_NUMBER = 2;
  public static final int STRTOPICID_FIELD_NUMBER = 1;
  public static final int TYPE_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField StrNick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField StrTopicId = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field Type = PBField.initUInt32(0);
  public final PBUInt32Field dwCreateTime = PBField.initUInt32(0);
  public final PBUInt32Field dwDelTime = PBField.initUInt32(0);
  public final PBUInt32Field dwModiTime = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48 }, new String[] { "StrTopicId", "StrNick", "Type", "dwCreateTime", "dwModiTime", "dwDelTime" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, LongNickInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x799.oidb_0x799.LongNickInfo
 * JD-Core Version:    0.7.0.1
 */
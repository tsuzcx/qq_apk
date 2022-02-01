package tencent.im.s2c.msgtype0x211.submsgtype0x9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class C2CType0x211_SubC2CType0x9$MsgBody$SupportFileInfo
  extends MessageMicro
{
  public static final int STR_FILE_SUFFIX_FIELD_NUMBER = 1;
  public static final int UINT32_COPIES_FIELD_NUMBER = 2;
  public static final int UINT32_DUPLEX_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "str_file_suffix", "uint32_copies", "uint32_duplex" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, SupportFileInfo.class);
  public final PBStringField str_file_suffix = PBField.initString("");
  public final PBUInt32Field uint32_copies = PBField.initUInt32(0);
  public final PBUInt32Field uint32_duplex = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo
 * JD-Core Version:    0.7.0.1
 */
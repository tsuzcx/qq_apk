package tencent.im.oidb.cmd0x5f9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0x5f9$ReqBody
  extends MessageMicro
{
  public static final int BYTES_COOKIE_FIELD_NUMBER = 2;
  public static final int STR_KEYWORD_FIELD_NUMBER = 1;
  public static final int STR_SRCCITY_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_keyword = PBField.initString("");
  public final PBStringField str_srccity = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_keyword", "bytes_cookie", "str_srccity" }, new Object[] { "", localByteStringMicro, "" }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5f9.cmd0x5f9.ReqBody
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.s2c.msgtype0x210.submsgtype0x71;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Submsgtype0x71$RedTypeInfo
  extends MessageMicro
{
  public static final int STR_RED_CONTENT_FIELD_NUMBER = 2;
  public static final int STR_RED_DESC_FIELD_NUMBER = 3;
  public static final int UINT32_RED_PRIORITY_FIELD_NUMBER = 4;
  public static final int UINT32_RED_TYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint32_red_type", "str_red_content", "str_red_desc", "uint32_red_priority" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0) }, RedTypeInfo.class);
  public final PBStringField str_red_content = PBField.initString("");
  public final PBStringField str_red_desc = PBField.initString("");
  public final PBUInt32Field uint32_red_priority = PBField.initUInt32(0);
  public final PBUInt32Field uint32_red_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x71.Submsgtype0x71.RedTypeInfo
 * JD-Core Version:    0.7.0.1
 */
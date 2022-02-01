package tencent.im.group;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_member_info$CustomEntry
  extends MessageMicro
{
  public static final int BOOL_CLICKED_FIELD_NUMBER = 3;
  public static final int STR_NAME_FIELD_NUMBER = 1;
  public static final int STR_URL_FIELD_NUMBER = 4;
  public static final int STR_VALUE_FIELD_NUMBER = 2;
  public static final int UINT64_REPORT_ID_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_clicked = PBField.initBool(false);
  public final PBBytesField str_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_value = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_report_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "str_name", "str_value", "bool_clicked", "str_url", "uint64_report_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Boolean.valueOf(false), localByteStringMicro3, Long.valueOf(0L) }, CustomEntry.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.group.group_member_info.CustomEntry
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x8b4$GroupInfo
  extends MessageMicro
{
  public static final int STR_FACE_URL_FIELD_NUMBER = 3;
  public static final int STR_GROUP_NAME_FIELD_NUMBER = 2;
  public static final int UINT32_SET_DISPLAY_TIME_FIELD_NUMBER = 4;
  public static final int UINT64_GC_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint64_gc", "str_group_name", "str_face_url", "uint32_set_display_time" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0) }, GroupInfo.class);
  public final PBStringField str_face_url = PBField.initString("");
  public final PBStringField str_group_name = PBField.initString("");
  public final PBUInt32Field uint32_set_display_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_gc = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8b4.GroupInfo
 * JD-Core Version:    0.7.0.1
 */
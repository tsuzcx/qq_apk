package tencent.im.nearby.entrance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class nearby_entrance_common$NearbyEntranceContent
  extends MessageMicro
{
  public static final int BG_COLOR_FIELD_NUMBER = 10;
  public static final int INT32_ID_TYPE_FIELD_NUMBER = 2;
  public static final int INT32_PIC_TYPE_FIELD_NUMBER = 4;
  public static final int INT32_SUB_PIC_TYPE_FIELD_NUMBER = 5;
  public static final int INT64_ID_FIELD_NUMBER = 1;
  public static final int LOGO_URL_FIELD_NUMBER = 12;
  public static final int PIC_URL_FIELD_NUMBER = 9;
  public static final int STR_CONTENT2_FIELD_NUMBER = 8;
  public static final int STR_CONTENT_FIELD_NUMBER = 7;
  public static final int STR_TITLE_FIELD_NUMBER = 6;
  public static final int STR_URL_FIELD_NUMBER = 3;
  public static final int TXT_COLOR_FIELD_NUMBER = 11;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50, 58, 66, 74, 82, 90, 98 }, new String[] { "int64_id", "int32_id_type", "str_url", "int32_pic_type", "int32_sub_pic_type", "str_title", "str_content", "str_content2", "pic_url", "bg_color", "txt_color", "logo_url" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", "", "" }, NearbyEntranceContent.class);
  public final PBStringField bg_color = PBField.initString("");
  public final PBInt32Field int32_id_type = PBField.initInt32(0);
  public final PBInt32Field int32_pic_type = PBField.initInt32(0);
  public final PBInt32Field int32_sub_pic_type = PBField.initInt32(0);
  public final PBInt64Field int64_id = PBField.initInt64(0L);
  public final PBStringField logo_url = PBField.initString("");
  public final PBStringField pic_url = PBField.initString("");
  public final PBStringField str_content = PBField.initString("");
  public final PBStringField str_content2 = PBField.initString("");
  public final PBStringField str_title = PBField.initString("");
  public final PBStringField str_url = PBField.initString("");
  public final PBStringField txt_color = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.nearby.entrance.nearby_entrance_common.NearbyEntranceContent
 * JD-Core Version:    0.7.0.1
 */
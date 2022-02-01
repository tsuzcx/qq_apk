package tencent.im.oidb.cmd0x89a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x89a$groupinfo
  extends MessageMicro
{
  public static final int MSG_GROUP_GEO_INFO_FIELD_NUMBER = 20;
  public static final int RPT_STRING_GROUP_TAG_FIELD_NUMBER = 19;
  public static final int STRING_CERTIFICATION_TEXT_FIELD_NUMBER = 12;
  public static final int STRING_GROUP_AIO_SKIN_URL_FIELD_NUMBER = 6;
  public static final int STRING_GROUP_BOARD_SKIN_URL_FIELD_NUMBER = 7;
  public static final int STRING_GROUP_CLASS_TEXT_FIELD_NUMBER = 22;
  public static final int STRING_GROUP_COVER_SKIN_URL_FIELD_NUMBER = 8;
  public static final int STRING_GROUP_FINGER_MEMO_FIELD_NUMBER = 5;
  public static final int STRING_GROUP_MEMO_FIELD_NUMBER = 4;
  public static final int STRING_GROUP_NAME_FIELD_NUMBER = 3;
  public static final int STRING_GROUP_RICH_FINGER_MEMO_FIELD_NUMBER = 13;
  public static final int ST_GROUP_NEWGUIDELINES_FIELD_NUMBER = 14;
  public static final int UINT32_ACTIVE_MEMBER_NUM_FIELD_NUMBER = 10;
  public static final int UINT32_ADD_OPTION_FIELD_NUMBER = 16;
  public static final int UINT32_APP_PRIVILEGE_FLAG_FIELD_NUMBER = 23;
  public static final int UINT32_APP_PRIVILEGE_MASK_FIELD_NUMBER = 24;
  public static final int UINT32_CERTIFICATION_TYPE_FIELD_NUMBER = 11;
  public static final int UINT32_FLAG_FIELD_NUMBER = 2;
  public static final int UINT32_GROUP_CLASS_EXT_FIELD_NUMBER = 21;
  public static final int UINT32_GROUP_EXT_ADM_NUM_FIELD_NUMBER = 1;
  public static final int UINT32_GROUP_FACE_FIELD_NUMBER = 15;
  public static final int UINT32_GROUP_GRADE_FIELD_NUMBER = 9;
  public static final int UINT32_GROUP_TYPE_FLAG_FIELD_NUMBER = 18;
  public static final int UINT32_SHUTUP_TIME_FIELD_NUMBER = 17;
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_0x89a.GroupGeoInfo msg_group_geo_info = new oidb_0x89a.GroupGeoInfo();
  public final PBRepeatField rpt_string_group_tag = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public oidb_0x89a.GroupNewGuidelinesInfo st_group_newguidelines = new oidb_0x89a.GroupNewGuidelinesInfo();
  public final PBBytesField string_certification_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_aio_skin_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_board_skin_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_class_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_cover_skin_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_finger_memo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_memo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_rich_finger_memo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_active_member_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_add_option = PBField.initUInt32(0);
  public final PBUInt32Field uint32_app_privilege_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_app_privilege_mask = PBField.initUInt32(0);
  public final PBUInt32Field uint32_certification_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_class_ext = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_ext_adm_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_face = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_grade = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_type_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_shutup_time = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 72, 80, 88, 98, 106, 114, 120, 128, 136, 144, 154, 162, 168, 178, 184, 192 }, new String[] { "uint32_group_ext_adm_num", "uint32_flag", "string_group_name", "string_group_memo", "string_group_finger_memo", "string_group_aio_skin_url", "string_group_board_skin_url", "string_group_cover_skin_url", "uint32_group_grade", "uint32_active_member_num", "uint32_certification_type", "string_certification_text", "string_group_rich_finger_memo", "st_group_newguidelines", "uint32_group_face", "uint32_add_option", "uint32_shutup_time", "uint32_group_type_flag", "rpt_string_group_tag", "msg_group_geo_info", "uint32_group_class_ext", "string_group_class_text", "uint32_app_privilege_flag", "uint32_app_privilege_mask" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, localByteStringMicro8, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro9, null, Integer.valueOf(0), localByteStringMicro10, Integer.valueOf(0), Integer.valueOf(0) }, groupinfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x89a.oidb_0x89a.groupinfo
 * JD-Core Version:    0.7.0.1
 */
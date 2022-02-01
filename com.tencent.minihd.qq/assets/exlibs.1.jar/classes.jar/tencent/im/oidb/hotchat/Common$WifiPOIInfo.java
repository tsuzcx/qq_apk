package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Common$WifiPOIInfo
  extends MessageMicro
{
  public static final int BYTES_NAME_FIELD_NUMBER = 2;
  public static final int BYTES_SIG_FIELD_NUMBER = 4;
  public static final int BYTES_UID_FIELD_NUMBER = 1;
  public static final int FACE_URL_FIELD_NUMBER = 12;
  public static final int HOT_THEME_GROUP_FLAG_FIELD_NUMBER = 13;
  public static final int UINT32_DISTANCE_FIELD_NUMBER = 10;
  public static final int UINT32_FACE_ID_FIELD_NUMBER = 3;
  public static final int UINT32_GROUP_CODE_FIELD_NUMBER = 5;
  public static final int UINT32_GROUP_UIN_FIELD_NUMBER = 6;
  public static final int UINT32_IS_MEMBER_FIELD_NUMBER = 9;
  public static final int UINT32_MSG_TAB_SWITCH_OFF_FIELD_NUMBER = 11;
  public static final int UINT32_VISITOR_NUM_FIELD_NUMBER = 7;
  public static final int UINT32_WIFI_POI_TYPE_FIELD_NUMBER = 8;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_uid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField face_url = PBField.initString("");
  public final PBUInt32Field hot_theme_group_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_distance = PBField.initUInt32(0);
  public final PBUInt32Field uint32_face_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_code = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_uin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_member = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_tab_switch_off = PBField.initUInt32(0);
  public final PBUInt32Field uint32_visitor_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_wifi_poi_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 56, 64, 72, 80, 88, 98, 104 }, new String[] { "bytes_uid", "bytes_name", "uint32_face_id", "bytes_sig", "uint32_group_code", "uint32_group_uin", "uint32_visitor_num", "uint32_wifi_poi_type", "uint32_is_member", "uint32_distance", "uint32_msg_tab_switch_off", "face_url", "hot_theme_group_flag" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, WifiPOIInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.hotchat.Common.WifiPOIInfo
 * JD-Core Version:    0.7.0.1
 */
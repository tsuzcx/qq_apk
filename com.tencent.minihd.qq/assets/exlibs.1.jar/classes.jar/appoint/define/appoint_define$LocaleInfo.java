package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class appoint_define$LocaleInfo
  extends MessageMicro
{
  public static final int MSG_GPS_FIELD_NUMBER = 7;
  public static final int STR_ADDRESS_FIELD_NUMBER = 8;
  public static final int STR_CITY_FIELD_NUMBER = 4;
  public static final int STR_COUNTRY_FIELD_NUMBER = 2;
  public static final int STR_NAME_FIELD_NUMBER = 1;
  public static final int STR_POI_FIELD_NUMBER = 6;
  public static final int STR_PROVINCE_FIELD_NUMBER = 3;
  public static final int STR_REGION_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "str_name", "str_country", "str_province", "str_city", "str_region", "str_poi", "msg_gps", "str_address" }, new Object[] { "", "", "", "", "", "", null, "" }, LocaleInfo.class);
  public appoint_define.GPS msg_gps = new appoint_define.GPS();
  public final PBStringField str_address = PBField.initString("");
  public final PBStringField str_city = PBField.initString("");
  public final PBStringField str_country = PBField.initString("");
  public final PBStringField str_name = PBField.initString("");
  public final PBStringField str_poi = PBField.initString("");
  public final PBStringField str_province = PBField.initString("");
  public final PBStringField str_region = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     appoint.define.appoint_define.LocaleInfo
 * JD-Core Version:    0.7.0.1
 */
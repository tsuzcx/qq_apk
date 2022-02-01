package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class publicaccount_recommend$BusinessRecommendRequest
  extends MessageMicro
{
  public static final int BASE_STATION_FIELD_NUMBER = 5;
  public static final int CATEGORYN_FIELD_NUMBER = 1;
  public static final int CITY_INFO_FIELD_NUMBER = 6;
  public static final int CITY_LOCATION_FIELD_NUMBER = 9;
  public static final int ICON_TYPE_FIELD_NUMBER = 10;
  public static final int LATITUDE_FIELD_NUMBER = 3;
  public static final int LONGITUDE_FIELD_NUMBER = 4;
  public static final int MOBILE_VERSION_FIELD_NUMBER = 8;
  public static final int PLATFORM_FIELD_NUMBER = 7;
  public static final int RECOMEND_COUNT_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 56, 64, 74, 80 }, new String[] { "categoryn", "recomend_count", "latitude", "longitude", "base_station", "city_info", "platform", "mobile_version", "city_location", "icon_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, BusinessRecommendRequest.class);
  public final PBStringField base_station = PBField.initString("");
  public final PBUInt32Field categoryn = PBField.initUInt32(0);
  public final PBStringField city_info = PBField.initString("");
  public final PBStringField city_location = PBField.initString("");
  public final PBUInt32Field icon_type = PBField.initUInt32(0);
  public final PBStringField latitude = PBField.initString("");
  public final PBStringField longitude = PBField.initString("");
  public final PBUInt32Field mobile_version = PBField.initUInt32(0);
  public final PBUInt32Field platform = PBField.initUInt32(0);
  public final PBUInt32Field recomend_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mp.publicaccount_recommend.BusinessRecommendRequest
 * JD-Core Version:    0.7.0.1
 */
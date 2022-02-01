package tencent.im.troop_search_userinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class userinfo$UserInfo
  extends MessageMicro
{
  public static final int APP_INFO_FIELD_NUMBER = 7;
  public static final int ATTR_FIELD_NUMBER = 6;
  public static final int GPS_FIELD_NUMBER = 3;
  public static final int RPT_CELL_FIELD_NUMBER = 5;
  public static final int RPT_WIFI_FIELD_NUMBER = 4;
  public static final int SKEY_FIELD_NUMBER = 2;
  public static final int UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58 }, new String[] { "uin", "skey", "gps", "rpt_wifi", "rpt_cell", "attr", "app_info" }, new Object[] { Long.valueOf(0L), "", null, null, null, null, null }, UserInfo.class);
  public userinfo.AppInfo app_info = new userinfo.AppInfo();
  public userinfo.DevAttr attr = new userinfo.DevAttr();
  public userinfo.GPS gps = new userinfo.GPS();
  public final PBRepeatMessageField rpt_cell = PBField.initRepeatMessage(userinfo.Cell.class);
  public final PBRepeatMessageField rpt_wifi = PBField.initRepeatMessage(userinfo.Wifi.class);
  public final PBStringField skey = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.troop_search_userinfo.userinfo.UserInfo
 * JD-Core Version:    0.7.0.1
 */
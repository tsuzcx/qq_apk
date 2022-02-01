package com.tencent.pb.getbusiinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class BusinessInfoCheckUpdate$AppInfo
  extends MessageMicro
{
  public static final int APPSET_FIELD_NUMBER = 9;
  public static final int BUFFER_FIELD_NUMBER = 5;
  public static final int ICON_FLAG_FIELD_NUMBER = 12;
  public static final int ICON_TYPE_FIELD_NUMBER = 13;
  public static final int ICON_URL_FIELD_NUMBER = 11;
  public static final int INEWFLAG_FIELD_NUMBER = 3;
  public static final int MISSIONS_FIELD_NUMBER = 8;
  public static final int MISSION_LEVEL_FIELD_NUMBER = 15;
  public static final int MODIFY_TS_FIELD_NUMBER = 7;
  public static final int NUM_FIELD_NUMBER = 10;
  public static final int PATH_FIELD_NUMBER = 6;
  public static final int PUSH_RED_TS_FIELD_NUMBER = 14;
  public static final int RED_DISPLAY_INFO_FIELD_NUMBER = 16;
  public static final int TYPE_FIELD_NUMBER = 4;
  public static final int UIAPPID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 24, 32, 42, 50, 56, 66, 72, 80, 90, 96, 104, 112, 120, 130 }, new String[] { "uiAppId", "iNewFlag", "type", "buffer", "path", "modify_ts", "missions", "appset", "num", "icon_url", "icon_flag", "icon_type", "push_red_ts", "mission_level", "red_display_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, AppInfo.class);
  public final PBInt32Field appset = PBField.initInt32(0);
  public final PBStringField buffer = PBField.initString("");
  public final PBInt32Field iNewFlag = PBField.initInt32(0);
  public final PBInt32Field icon_flag = PBField.initInt32(0);
  public final PBInt32Field icon_type = PBField.initInt32(0);
  public final PBStringField icon_url = PBField.initString("");
  public final PBInt32Field mission_level = PBField.initInt32(0);
  public final PBRepeatField missions = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field modify_ts = PBField.initUInt32(0);
  public final PBInt32Field num = PBField.initInt32(0);
  public final PBStringField path = PBField.initString("");
  public final PBUInt32Field push_red_ts = PBField.initUInt32(0);
  public BusinessInfoCheckUpdate.RedDisplayInfo red_display_info = new BusinessInfoCheckUpdate.RedDisplayInfo();
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt32Field uiAppId = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo
 * JD-Core Version:    0.7.0.1
 */
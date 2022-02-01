package com.tencent.pb.getbusiinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BusinessInfoCheckUpdate$ReportReqBody
  extends MessageMicro
{
  public static final int APPID_FIELD_NUMBER = 5;
  public static final int BUFFER_FIELD_NUMBER = 7;
  public static final int CLIENTVER_FIELD_NUMBER = 3;
  public static final int MISSIONID_FIELD_NUMBER = 6;
  public static final int PLATID_FIELD_NUMBER = 2;
  public static final int PLATVER_FIELD_NUMBER = 4;
  public static final int REPORTDATA_FIELD_NUMBER = 8;
  public static final int UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 58, 66 }, new String[] { "uin", "platid", "clientver", "platver", "appid", "missionid", "buffer", "reportdata" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", null }, ReportReqBody.class);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBStringField buffer = PBField.initString("");
  public final PBStringField clientver = PBField.initString("");
  public final PBRepeatField missionid = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field platid = PBField.initUInt32(0);
  public final PBStringField platver = PBField.initString("");
  public final PBRepeatMessageField reportdata = PBField.initRepeatMessage(BusinessInfoCheckUpdate.ReportStaticsData.class);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportReqBody
 * JD-Core Version:    0.7.0.1
 */
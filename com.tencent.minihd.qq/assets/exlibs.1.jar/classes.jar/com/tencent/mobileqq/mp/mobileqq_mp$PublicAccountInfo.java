package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$PublicAccountInfo
  extends MessageMicro
{
  public static final int ACCOUNT_FLAG_FIELD_NUMBER = 11;
  public static final int CERTIFIED_GRADE_FIELD_NUMBER = 7;
  public static final int CONFIG_GROUP_INFO_FIELD_NUMBER = 13;
  public static final int CONFIG_GROUP_INFO_NEW_FIELD_NUMBER = 14;
  public static final int DISPLAY_NUMBER_FIELD_NUMBER = 3;
  public static final int GROUP_ID_FIELD_NUMBER = 9;
  public static final int IS_RECV_MSG_FIELD_NUMBER = 5;
  public static final int IS_RECV_PUSH_FIELD_NUMBER = 6;
  public static final int IS_SYNC_LBS_FIELD_NUMBER = 8;
  public static final int LUIN_FIELD_NUMBER = 12;
  public static final int NAME_FIELD_NUMBER = 2;
  public static final int SHOW_FLAG_FIELD_NUMBER = 10;
  public static final int SUMMARY_FIELD_NUMBER = 4;
  public static final int UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 56, 64, 72, 80, 88, 96, 106, 114 }, new String[] { "uin", "name", "display_number", "summary", "is_recv_msg", "is_recv_push", "certified_grade", "is_sync_lbs", "group_id", "show_flag", "account_flag", "luin", "config_group_info", "config_group_info_new" }, new Object[] { Integer.valueOf(0), "", "", "", Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, null }, PublicAccountInfo.class);
  public final PBUInt32Field account_flag = PBField.initUInt32(0);
  public final PBUInt32Field certified_grade = PBField.initUInt32(0);
  public final PBRepeatMessageField config_group_info = PBField.initRepeatMessage(mobileqq_mp.ConfigGroupInfo.class);
  public final PBRepeatMessageField config_group_info_new = PBField.initRepeatMessage(mobileqq_mp.ConfigGroupInfo.class);
  public final PBStringField display_number = PBField.initString("");
  public final PBUInt32Field group_id = PBField.initUInt32(0);
  public final PBBoolField is_recv_msg = PBField.initBool(false);
  public final PBBoolField is_recv_push = PBField.initBool(false);
  public final PBBoolField is_sync_lbs = PBField.initBool(false);
  public final PBUInt64Field luin = PBField.initUInt64(0L);
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field show_flag = PBField.initUInt32(0);
  public final PBStringField summary = PBField.initString("");
  public final PBUInt32Field uin = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.PublicAccountInfo
 * JD-Core Version:    0.7.0.1
 */
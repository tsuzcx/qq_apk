package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_mp$ButtonInfo
  extends MessageMicro
{
  public static final int ACTIONINFO_FIELD_NUMBER = 12;
  public static final int AUTH_NONE = 0;
  public static final int AUTH_SID = 1;
  public static final int AUTH_TYPE_FIELD_NUMBER = 5;
  public static final int AUTH_VKEY = 2;
  public static final int CLICK = 1;
  public static final int EVENT = 3;
  public static final int EVENT_ID_FIELD_NUMBER = 8;
  public static final int EVENT_PARAM_FIELD_NUMBER = 9;
  public static final int ID_FIELD_NUMBER = 1;
  public static final int IS_NEED_LBS_FIELD_NUMBER = 10;
  public static final int ITEM_ID_FIELD_NUMBER = 11;
  public static final int KEY_FIELD_NUMBER = 3;
  public static final int NAME_FIELD_NUMBER = 2;
  public static final int SUB_BUTTON_FIELD_NUMBER = 7;
  public static final int TYPE_FIELD_NUMBER = 6;
  public static final int URL = 2;
  public static final int URL_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58, 64, 74, 80, 88, 98 }, new String[] { "id", "name", "key", "url", "auth_type", "type", "sub_button", "event_id", "event_param", "is_need_lbs", "item_id", "actionInfo" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(1), null, Integer.valueOf(1), null, Boolean.valueOf(false), Integer.valueOf(0), null }, ButtonInfo.class);
  public mobileqq_mp.ActionInfo actionInfo = new mobileqq_mp.ActionInfo();
  public final PBEnumField auth_type = PBField.initEnum(0);
  public final PBEnumField event_id = PBField.initEnum(1);
  public final PBRepeatMessageField event_param = PBField.initRepeatMessage(mobileqq_mp.ButtonInfo_EventInfoParam.class);
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBBoolField is_need_lbs = PBField.initBool(false);
  public final PBUInt32Field item_id = PBField.initUInt32(0);
  public final PBStringField key = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBRepeatMessageField sub_button = PBField.initRepeatMessage(ButtonInfo.class);
  public final PBEnumField type = PBField.initEnum(1);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo
 * JD-Core Version:    0.7.0.1
 */
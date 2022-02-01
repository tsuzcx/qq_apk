package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_mp$GetEqqAccountDetailInfoResponse
  extends MessageMicro
{
  public static final int ACCOUNTINFO_FIELD_NUMBER = 2;
  public static final int ADDRESS_FIELD_NUMBER = 3;
  public static final int CONFIG_GROUP_INFO_FIELD_NUMBER = 9;
  public static final int FOLLOW_TYPE_FIELD_NUMBER = 8;
  public static final int IS_RECV_MSG_FIELD_NUMBER = 7;
  public static final int LAT_FIELD_NUMBER = 5;
  public static final int LNG_FIELD_NUMBER = 4;
  public static final int PHONE_NUMBER_FIELD_NUMBER = 6;
  public static final int RET_INFO_FIELD_NUMBER = 1;
  public static final int SEQNO_FIELD_NUMBER = 10;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 64, 74, 80 }, new String[] { "ret_info", "accountInfo", "address", "lng", "lat", "phone_number", "is_recv_msg", "follow_type", "config_group_info", "seqno" }, new Object[] { null, null, "", "", "", "", Boolean.valueOf(false), Integer.valueOf(0), null, Integer.valueOf(0) }, GetEqqAccountDetailInfoResponse.class);
  public mobileqq_mp.EqqAccountInfo accountInfo = new mobileqq_mp.EqqAccountInfo();
  public final PBStringField address = PBField.initString("");
  public final PBRepeatMessageField config_group_info = PBField.initRepeatMessage(mobileqq_mp.ConfigGroupInfo.class);
  public final PBUInt32Field follow_type = PBField.initUInt32(0);
  public final PBBoolField is_recv_msg = PBField.initBool(false);
  public final PBStringField lat = PBField.initString("");
  public final PBStringField lng = PBField.initString("");
  public final PBStringField phone_number = PBField.initString("");
  public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  public final PBUInt32Field seqno = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse
 * JD-Core Version:    0.7.0.1
 */
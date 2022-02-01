package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$GetPublicAccountMenuResponse
  extends MessageMicro
{
  public static final int BUTTON_INFO_FIELD_NUMBER = 4;
  public static final int LUIN_FIELD_NUMBER = 6;
  public static final int RET_INFO_FIELD_NUMBER = 1;
  public static final int SEQNO_FIELD_NUMBER = 2;
  public static final int UIN_FIELD_NUMBER = 3;
  public static final int UPDATE_TYPE_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48 }, new String[] { "ret_info", "seqno", "uin", "button_info", "update_type", "luin" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Long.valueOf(0L) }, GetPublicAccountMenuResponse.class);
  public final PBRepeatMessageField button_info = PBField.initRepeatMessage(mobileqq_mp.ButtonInfo.class);
  public final PBUInt64Field luin = PBField.initUInt64(0L);
  public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  public final PBUInt32Field seqno = PBField.initUInt32(0);
  public final PBUInt32Field uin = PBField.initUInt32(0);
  public final PBUInt32Field update_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse
 * JD-Core Version:    0.7.0.1
 */
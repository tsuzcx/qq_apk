package com.tencent.pb.secmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SecMsgComu$SecMsg_GetBaseInfo_Rsp
  extends MessageMicro
{
  public static final int APPSTATE_FIELD_NUMBER = 7;
  public static final int DSS_FIELD_NUMBER = 4;
  public static final int F_DISABLE_FIELD_NUMBER = 3;
  public static final int F_FORBID_FIELD_NUMBER = 1;
  public static final int F_WHITEUSER_FIELD_NUMBER = 2;
  public static final int NEWEST_SEQ_FIELD_NUMBER = 5;
  public static final int NOWTS_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 56 }, new String[] { "f_forbid", "f_whiteuser", "f_disable", "dss", "newest_seq", "nowts", "appstate" }, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, SecMsg_GetBaseInfo_Rsp.class);
  public final PBInt64Field appstate = PBField.initInt64(0L);
  public final PBRepeatField dss = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBBoolField f_disable = PBField.initBool(false);
  public final PBBoolField f_forbid = PBField.initBool(false);
  public final PBBoolField f_whiteuser = PBField.initBool(false);
  public final PBInt64Field newest_seq = PBField.initInt64(0L);
  public final PBInt64Field nowts = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.secmsg.SecMsgComu.SecMsg_GetBaseInfo_Rsp
 * JD-Core Version:    0.7.0.1
 */
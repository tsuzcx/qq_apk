package com.tencent.biz.bmqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_bmqq$CorpcardRspBody
  extends MessageMicro
{
  public static final int CORPNAME_FIELD_NUMBER = 10;
  public static final int EMAIL_FIELD_NUMBER = 9;
  public static final int FLAG_FIELD_NUMBER = 11;
  public static final int JOBS_FIELD_NUMBER = 6;
  public static final int MOBILE_FIELD_NUMBER = 7;
  public static final int NICKNAME_FIELD_NUMBER = 4;
  public static final int PHONE_FIELD_NUMBER = 8;
  public static final int REMARKNAME_FIELD_NUMBER = 5;
  public static final int RETINFO_FIELD_NUMBER = 1;
  public static final int UINT64_KFUIN_FIELD_NUMBER = 3;
  public static final int UINT64_QQUIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 58, 66, 74, 82, 88 }, new String[] { "retInfo", "uint64_qquin", "uint64_kfuin", "nickname", "remarkname", "jobs", "mobile", "phone", "email", "corpname", "flag" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), "", "", "", "", "", "", "", Integer.valueOf(0) }, CorpcardRspBody.class);
  public final PBStringField corpname = PBField.initString("");
  public final PBStringField email = PBField.initString("");
  public final PBUInt32Field flag = PBField.initUInt32(0);
  public final PBStringField jobs = PBField.initString("");
  public final PBStringField mobile = PBField.initString("");
  public final PBStringField nickname = PBField.initString("");
  public final PBStringField phone = PBField.initString("");
  public final PBStringField remarkname = PBField.initString("");
  public mobileqq_bmqq.RetInfo retInfo = new mobileqq_bmqq.RetInfo();
  public final PBUInt64Field uint64_kfuin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_qquin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.bmqq.protocol.mobileqq_bmqq.CorpcardRspBody
 * JD-Core Version:    0.7.0.1
 */
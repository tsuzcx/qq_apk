package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_mp$GroupInfo
  extends MessageMicro
{
  public static final int FLAG_FIELD_NUMBER = 3;
  public static final int ID_FIELD_NUMBER = 1;
  public static final int NAME_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "id", "name", "flag" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, GroupInfo.class);
  public final PBUInt32Field flag = PBField.initUInt32(0);
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBStringField name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.GroupInfo
 * JD-Core Version:    0.7.0.1
 */
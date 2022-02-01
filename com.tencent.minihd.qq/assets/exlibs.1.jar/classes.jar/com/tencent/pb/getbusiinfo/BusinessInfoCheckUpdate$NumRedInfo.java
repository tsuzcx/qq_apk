package com.tencent.pb.getbusiinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class BusinessInfoCheckUpdate$NumRedInfo
  extends MessageMicro
{
  public static final int APPID_FIELD_NUMBER = 1;
  public static final int FLAG_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "appid", "flag" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false) }, NumRedInfo.class);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBBoolField flag = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.NumRedInfo
 * JD-Core Version:    0.7.0.1
 */
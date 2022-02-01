package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class safecheckPB$ReportItem
  extends MessageMicro
{
  public static final int STRING_TARGET_MD5_FIELD_NUMBER = 2;
  public static final int STRING_TARGET_PACKNAME_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "string_target_packname", "string_target_md5" }, new Object[] { "", "" }, ReportItem.class);
  public final PBStringField string_target_md5 = PBField.initString("");
  public final PBStringField string_target_packname = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.ims.safecheckPB.ReportItem
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.pb.getbusiinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class BusinessInfoCheckUpdate$RedTypeInfo
  extends MessageMicro
{
  public static final int RED_CONTENT_FIELD_NUMBER = 2;
  public static final int RED_DESC_FIELD_NUMBER = 3;
  public static final int RED_PRIORITY_FIELD_NUMBER = 4;
  public static final int RED_TYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "red_type", "red_content", "red_desc", "red_priority" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0) }, RedTypeInfo.class);
  public final PBStringField red_content = PBField.initString("");
  public final PBStringField red_desc = PBField.initString("");
  public final PBUInt32Field red_priority = PBField.initUInt32(0);
  public final PBUInt32Field red_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo
 * JD-Core Version:    0.7.0.1
 */
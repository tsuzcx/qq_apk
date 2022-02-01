package com.tencent.proto.lbsshare;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LBSShare$DPBiz
  extends MessageMicro
{
  public static final int AVG_PRICE_FIELD_NUMBER = 8;
  public static final int BIZ_ZONE_FIELD_NUMBER = 5;
  public static final int CATEGORY_FIELD_NUMBER = 6;
  public static final int HAS_QUAN_FIELD_NUMBER = 10;
  public static final int HAS_TUAN_FIELD_NUMBER = 9;
  public static final int ID_FIELD_NUMBER = 1;
  public static final int LOGO_FIELD_NUMBER = 3;
  public static final int NAME_FIELD_NUMBER = 2;
  public static final int RATE_FIELD_NUMBER = 7;
  public static final int URL_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 66, 72, 80 }, new String[] { "id", "name", "logo", "url", "biz_zone", "category", "rate", "avg_price", "has_tuan", "has_quan" }, new Object[] { "", "", "", "", "", "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, DPBiz.class);
  public final PBStringField avg_price = PBField.initString("");
  public final PBStringField biz_zone = PBField.initString("");
  public final PBStringField category = PBField.initString("");
  public final PBUInt32Field has_quan = PBField.initUInt32(0);
  public final PBUInt32Field has_tuan = PBField.initUInt32(0);
  public final PBStringField id = PBField.initString("");
  public final PBStringField logo = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field rate = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.proto.lbsshare.LBSShare.DPBiz
 * JD-Core Version:    0.7.0.1
 */
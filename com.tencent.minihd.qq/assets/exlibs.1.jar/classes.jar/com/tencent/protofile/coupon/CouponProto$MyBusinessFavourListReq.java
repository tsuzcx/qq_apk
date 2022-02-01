package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CouponProto$MyBusinessFavourListReq
  extends MessageMicro
{
  public static final int STYPE_FIELD_NUMBER = 2;
  public static final int TS_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ts", "stype" }, new Object[] { Long.valueOf(0L), "" }, MyBusinessFavourListReq.class);
  public final PBStringField stype = PBField.initString("");
  public final PBUInt64Field ts = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto.MyBusinessFavourListReq
 * JD-Core Version:    0.7.0.1
 */
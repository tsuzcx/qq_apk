package com.tencent.proto.lbsshare;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LBSShare$LocationReq
  extends MessageMicro
{
  public static final int CATEGORY_FIELD_NUMBER = 5;
  public static final int COORDINATE_FIELD_NUMBER = 3;
  public static final int COUNT_FIELD_NUMBER = 7;
  public static final int KEYWORD_FIELD_NUMBER = 4;
  public static final int LAT_FIELD_NUMBER = 1;
  public static final int LNG_FIELD_NUMBER = 2;
  public static final int PAGE_FIELD_NUMBER = 6;
  public static final int REQUIREMYLBS_FIELD_NUMBER = 8;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56, 64 }, new String[] { "lat", "lng", "coordinate", "keyword", "category", "page", "count", "requireMyLbs" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, LocationReq.class);
  public final PBStringField category = PBField.initString("");
  public final PBUInt32Field coordinate = PBField.initUInt32(0);
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBStringField keyword = PBField.initString("");
  public final PBUInt32Field lat = PBField.initUInt32(0);
  public final PBUInt32Field lng = PBField.initUInt32(0);
  public final PBUInt32Field page = PBField.initUInt32(0);
  public final PBUInt32Field requireMyLbs = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.proto.lbsshare.LBSShare.LocationReq
 * JD-Core Version:    0.7.0.1
 */
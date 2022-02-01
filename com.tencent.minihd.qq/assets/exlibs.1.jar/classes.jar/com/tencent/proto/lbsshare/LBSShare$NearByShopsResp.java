package com.tencent.proto.lbsshare;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LBSShare$NearByShopsResp
  extends MessageMicro
{
  public static final int EC_FIELD_NUMBER = 1;
  public static final int NEXT_BEGIN_FIELD_NUMBER = 3;
  public static final int POILIST_FIELD_NUMBER = 2;
  public static final int TOTAL_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "ec", "poilist", "next_begin", "total" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, NearByShopsResp.class);
  public final PBUInt32Field ec = PBField.initUInt32(0);
  public final PBUInt32Field next_begin = PBField.initUInt32(0);
  public final PBRepeatMessageField poilist = PBField.initRepeatMessage(LBSShare.Shop.class);
  public final PBUInt32Field total = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.proto.lbsshare.LBSShare.NearByShopsResp
 * JD-Core Version:    0.7.0.1
 */
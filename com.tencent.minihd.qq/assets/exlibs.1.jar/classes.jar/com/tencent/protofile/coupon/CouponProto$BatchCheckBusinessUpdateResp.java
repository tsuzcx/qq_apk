package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CouponProto$BatchCheckBusinessUpdateResp
  extends MessageMicro
{
  public static final int BIDS_FIELD_NUMBER = 2;
  public static final int RETCODE_FIELD_NUMBER = 1;
  public static final int SOURCE_IDS_FIELD_NUMBER = 3;
  public static final int TS_LIST_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "retcode", "bids", "source_ids", "ts_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, BatchCheckBusinessUpdateResp.class);
  public final PBRepeatField bids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field retcode = PBField.initUInt32(0);
  public final PBRepeatField source_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField ts_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto.BatchCheckBusinessUpdateResp
 * JD-Core Version:    0.7.0.1
 */
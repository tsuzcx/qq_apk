package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$SetRefuseFollowRequest
  extends MessageMicro
{
  public static final int ACCOUNT_TYPE_FIELD_NUMBER = 2;
  public static final int LUIN_FIELD_NUMBER = 1;
  public static final int REFUSE_FOREVER_FIELD_NUMBER = 3;
  public static final int REFUSE_PERIOD_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "luin", "account_type", "refuse_forever", "refuse_period" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0) }, SetRefuseFollowRequest.class);
  public final PBUInt32Field account_type = PBField.initUInt32(0);
  public final PBUInt64Field luin = PBField.initUInt64(0L);
  public final PBBoolField refuse_forever = PBField.initBool(false);
  public final PBUInt32Field refuse_period = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.SetRefuseFollowRequest
 * JD-Core Version:    0.7.0.1
 */
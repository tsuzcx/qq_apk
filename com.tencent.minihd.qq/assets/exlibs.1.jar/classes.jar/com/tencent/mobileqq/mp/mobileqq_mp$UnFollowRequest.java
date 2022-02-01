package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$UnFollowRequest
  extends MessageMicro
{
  public static final int ACCOUNT_TYPE_FIELD_NUMBER = 2;
  public static final int LUIN_FIELD_NUMBER = 3;
  public static final int UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uin", "account_type", "luin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, UnFollowRequest.class);
  public final PBUInt32Field account_type = PBField.initUInt32(0);
  public final PBUInt64Field luin = PBField.initUInt64(0L);
  public final PBUInt32Field uin = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest
 * JD-Core Version:    0.7.0.1
 */
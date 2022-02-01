package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SummaryCardUpdate$SUpdateRspBatch
  extends MessageMicro
{
  public static final int RSPS_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rsps" }, new Object[] { null }, SUpdateRspBatch.class);
  public final PBRepeatMessageField rsps = PBField.initRepeatMessage(SummaryCardUpdate.SUpdateRsp.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateRspBatch
 * JD-Core Version:    0.7.0.1
 */
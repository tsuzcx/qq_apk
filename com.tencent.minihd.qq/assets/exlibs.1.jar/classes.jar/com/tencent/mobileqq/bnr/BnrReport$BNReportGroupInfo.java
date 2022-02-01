package com.tencent.mobileqq.bnr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class BnrReport$BNReportGroupInfo
  extends MessageMicro
{
  public static final int ID_FIELD_NUMBER = 1;
  public static final int SEQNO_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "id", "seqno" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, BNReportGroupInfo.class);
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBUInt32Field seqno = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.bnr.BnrReport.BNReportGroupInfo
 * JD-Core Version:    0.7.0.1
 */
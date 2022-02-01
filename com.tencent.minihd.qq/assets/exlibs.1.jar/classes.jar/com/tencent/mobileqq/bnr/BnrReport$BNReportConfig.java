package com.tencent.mobileqq.bnr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class BnrReport$BNReportConfig
  extends MessageMicro
{
  public static final int DICLIST_FIELD_NUMBER = 3;
  public static final int IDLIST_FIELD_NUMBER = 4;
  public static final int ID_FIELD_NUMBER = 1;
  public static final int SEQNO_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "id", "seqno", "dicList", "idList" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, BNReportConfig.class);
  public final PBRepeatField dicList = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBRepeatField idList = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field seqno = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.bnr.BnrReport.BNReportConfig
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.bmqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class mobileqq_bmqq$CorpcardRspHead
  extends MessageMicro
{
  public static final int RSPHEAD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rspHead" }, new Object[] { null }, CorpcardRspHead.class);
  public mobileqq_bmqq.HRTXHead rspHead = new mobileqq_bmqq.HRTXHead();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.bmqq.protocol.mobileqq_bmqq.CorpcardRspHead
 * JD-Core Version:    0.7.0.1
 */
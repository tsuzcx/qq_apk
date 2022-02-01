package com.tencent.IndividPub;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class IndividPub$expTips_Req
  extends MessageMicro
{
  public static final int CMD_FIELD_NUMBER = 1;
  public static final int COMM_FIELD_NUMBER = 3;
  public static final int PACKET_SEQ_FIELD_NUMBER = 2;
  public static final int REQCMD_0X01_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "cmd", "packet_seq", "comm", "reqcmd_0x01" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null }, expTips_Req.class);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public IndividPub.Platform_Comm_Req comm = new IndividPub.Platform_Comm_Req();
  public final PBUInt64Field packet_seq = PBField.initUInt64(0L);
  public IndividPub.expTips_Pull_Req reqcmd_0x01 = new IndividPub.expTips_Pull_Req();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.IndividPub.IndividPub.expTips_Req
 * JD-Core Version:    0.7.0.1
 */
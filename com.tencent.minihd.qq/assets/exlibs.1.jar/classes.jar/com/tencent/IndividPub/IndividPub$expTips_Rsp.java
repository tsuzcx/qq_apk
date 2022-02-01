package com.tencent.IndividPub;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class IndividPub$expTips_Rsp
  extends MessageMicro
{
  public static final int CMD_FIELD_NUMBER = 3;
  public static final int COMM_FIELD_NUMBER = 5;
  public static final int ERRMSG_FIELD_NUMBER = 2;
  public static final int PACKET_SEQ_FIELD_NUMBER = 4;
  public static final int RET_FIELD_NUMBER = 1;
  public static final int RSPCMD_0X01_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50 }, new String[] { "ret", "errmsg", "cmd", "packet_seq", "comm", "rspcmd_0x01" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), null, null }, expTips_Rsp.class);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public IndividPub.Platform_Comm_Rsp comm = new IndividPub.Platform_Comm_Rsp();
  public final PBStringField errmsg = PBField.initString("");
  public final PBUInt64Field packet_seq = PBField.initUInt64(0L);
  public final PBInt64Field ret = PBField.initInt64(0L);
  public IndividPub.expTips_Pull_Rsp rspcmd_0x01 = new IndividPub.expTips_Pull_Rsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.IndividPub.IndividPub.expTips_Rsp
 * JD-Core Version:    0.7.0.1
 */
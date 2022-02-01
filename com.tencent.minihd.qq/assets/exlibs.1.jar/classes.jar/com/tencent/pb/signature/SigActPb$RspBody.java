package com.tencent.pb.signature;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SigActPb$RspBody
  extends MessageMicro
{
  public static final int AUTH_RSP_FIELD_NUMBER = 6;
  public static final int CMD_FIELD_NUMBER = 3;
  public static final int DESC_FIELD_NUMBER = 2;
  public static final int RET_FIELD_NUMBER = 1;
  public static final int RSP_FIELD_NUMBER = 5;
  public static final int SEQ_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50 }, new String[] { "ret", "desc", "cmd", "seq", "rsp", "auth_rsp" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), null, null }, RspBody.class);
  public SigActPb.SigauthRsp auth_rsp = new SigActPb.SigauthRsp();
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public final PBStringField desc = PBField.initString("");
  public final PBInt32Field ret = PBField.initInt32(0);
  public SigActPb.SigactRsp rsp = new SigActPb.SigactRsp();
  public final PBUInt64Field seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.signature.SigActPb.RspBody
 * JD-Core Version:    0.7.0.1
 */
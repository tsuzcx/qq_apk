package com.tencent.pb.vipfuncall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VipSetFunCall$SFunCallSetRsp
  extends MessageMicro
{
  public static final int ID_FIELD_NUMBER = 3;
  public static final int MSG_FIELD_NUMBER = 2;
  public static final int RET_FIELD_NUMBER = 1;
  public static final int TOUIN_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "ret", "msg", "id", "touin" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L) }, SFunCallSetRsp.class);
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBStringField msg = PBField.initString("");
  public final PBUInt32Field ret = PBField.initUInt32(0);
  public final PBUInt64Field touin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.vipfuncall.VipSetFunCall.SFunCallSetRsp
 * JD-Core Version:    0.7.0.1
 */
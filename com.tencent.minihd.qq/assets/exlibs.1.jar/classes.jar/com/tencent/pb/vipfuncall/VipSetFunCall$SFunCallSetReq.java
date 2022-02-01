package com.tencent.pb.vipfuncall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VipSetFunCall$SFunCallSetReq
  extends MessageMicro
{
  public static final int CLIENT_VERSION_FIELD_NUMBER = 2;
  public static final int ID_FIELD_NUMBER = 4;
  public static final int PLATFORM_FIELD_NUMBER = 3;
  public static final int TOUIN_FIELD_NUMBER = 5;
  public static final int UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "uin", "client_version", "platform", "id", "touin" }, new Object[] { Long.valueOf(0L), "5.4.0", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, SFunCallSetReq.class);
  public final PBStringField client_version = PBField.initString("5.4.0");
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBUInt32Field platform = PBField.initUInt32(0);
  public final PBUInt64Field touin = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.vipfuncall.VipSetFunCall.SFunCallSetReq
 * JD-Core Version:    0.7.0.1
 */
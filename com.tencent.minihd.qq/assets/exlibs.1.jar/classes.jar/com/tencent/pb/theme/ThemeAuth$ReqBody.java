package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ThemeAuth$ReqBody
  extends MessageMicro
{
  public static final int INT32_PLAT_ID_FIELD_NUMBER = 2;
  public static final int MSG_SUBCMD0X1_REQ_AUTH_FIELD_NUMBER = 5;
  public static final int STR_QQ_VERSION_FIELD_NUMBER = 3;
  public static final int UINT32_QQ_VERSION_FIELD_NUMBER = 4;
  public static final int UINT32_SUB_CMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "uint32_sub_cmd", "int32_plat_id", "str_qq_version", "uint32_qq_version", "msg_subcmd0x1_req_auth" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), null }, ReqBody.class);
  public final PBInt32Field int32_plat_id = PBField.initInt32(0);
  public ThemeAuth.SubCmd0x1ReqAuth msg_subcmd0x1_req_auth = new ThemeAuth.SubCmd0x1ReqAuth();
  public final PBStringField str_qq_version = PBField.initString("");
  public final PBUInt32Field uint32_qq_version = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.theme.ThemeAuth.ReqBody
 * JD-Core Version:    0.7.0.1
 */
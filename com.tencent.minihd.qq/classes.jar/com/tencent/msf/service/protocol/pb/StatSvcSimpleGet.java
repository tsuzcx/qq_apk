package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class StatSvcSimpleGet
{
  public static final class ReqBody
    extends MessageMicro
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ReqBody.class);
  }
  
  public static final class RspBody
    extends MessageMicro
  {
    public static final int STR_CLIENTIP_FIELD_NUMBER = 4;
    public static final int STR_ERRMSG_FIELD_NUMBER = 2;
    public static final int UINT32_ERROR_CODE_FIELD_NUMBER = 1;
    public static final int UINT32_HELLO_INTERVAL_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uint32_error_code", "str_errmsg", "uint32_hello_interval", "str_clientip" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "" }, RspBody.class);
    public final PBStringField str_clientip = PBField.initString("");
    public final PBStringField str_errmsg = PBField.initString("");
    public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_hello_interval = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.pb.StatSvcSimpleGet
 * JD-Core Version:    0.7.0.1
 */
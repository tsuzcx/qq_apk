package com.tencent.pb.secmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class SecMsgConfig$SecMsgConfigsResponse
  extends MessageMicro
{
  public static final int INT32_RET_FIELD_NUMBER = 1;
  public static final int INT32_SHOW_IN_PALIST_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_ret", "int32_show_in_palist" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, SecMsgConfigsResponse.class);
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public final PBInt32Field int32_show_in_palist = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.secmsg.SecMsgConfig.SecMsgConfigsResponse
 * JD-Core Version:    0.7.0.1
 */
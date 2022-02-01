package com.tencent.pb.getpreload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class PreloadInfoCheckUpdate$ControlRspHead
  extends MessageMicro
{
  public static final int CODE_FIELD_NUMBER = 1;
  public static final int ERR_MSG_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "code", "err_msg" }, new Object[] { Integer.valueOf(0), "" }, ControlRspHead.class);
  public final PBInt32Field code = PBField.initInt32(0);
  public final PBStringField err_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.getpreload.PreloadInfoCheckUpdate.ControlRspHead
 * JD-Core Version:    0.7.0.1
 */
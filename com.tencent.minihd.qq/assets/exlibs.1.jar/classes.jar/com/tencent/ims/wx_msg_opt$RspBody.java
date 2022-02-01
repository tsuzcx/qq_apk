package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class wx_msg_opt$RspBody
  extends MessageMicro
{
  public static final int STR_WORDING_FIELD_NUMBER = 6;
  public static final int UINT32_CMD_FIELD_NUMBER = 2;
  public static final int UINT32_OPT_FIELD_NUMBER = 5;
  public static final int UINT32_RET_FIELD_NUMBER = 4;
  public static final int UINT32_SEQ_FIELD_NUMBER = 3;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "uint64_uin", "uint32_cmd", "uint32_seq", "uint32_ret", "uint32_opt", "str_wording" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, RspBody.class);
  public final PBStringField str_wording = PBField.initString("");
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_opt = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ret = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.ims.wx_msg_opt.RspBody
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ClubContentUpdateInfoPb$RspBody
  extends MessageMicro
{
  public static final int INT_RESULT_FIELD_NUMBER = 1;
  public static final int RPT_MSG_RSPAPPINFO_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int_result", "rpt_msg_rspappinfo" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
  public final PBInt32Field int_result = PBField.initInt32(0);
  public final PBRepeatMessageField rpt_msg_rspappinfo = PBField.initRepeatMessage(ClubContentUpdateInfoPb.RspAppInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspBody
 * JD-Core Version:    0.7.0.1
 */
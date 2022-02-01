package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ClubContentUpdateInfoPb$RspAppInfo
  extends MessageMicro
{
  public static final int RPT_MSG_RSPITEMINFO_FIELD_NUMBER = 2;
  public static final int UINT_APPID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint_appid", "rpt_msg_rspiteminfo" }, new Object[] { Integer.valueOf(0), null }, RspAppInfo.class);
  public final PBRepeatMessageField rpt_msg_rspiteminfo = PBField.initRepeatMessage(ClubContentUpdateInfoPb.RspItemInfo.class);
  public final PBUInt32Field uint_appid = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspAppInfo
 * JD-Core Version:    0.7.0.1
 */
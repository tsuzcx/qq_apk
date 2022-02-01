package com.tencent.avatarinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MultiHeadUrl$MultiBusidUrlRsp
  extends MessageMicro
{
  public static final int DSTUIDTYPE_FIELD_NUMBER = 6;
  public static final int DSTUSRHEADINFOS_FIELD_NUMBER = 7;
  public static final int RESULT_FIELD_NUMBER = 5;
  public static final int SRCOPENID_FIELD_NUMBER = 4;
  public static final int SRCTID_FIELD_NUMBER = 3;
  public static final int SRCUIDTYPE_FIELD_NUMBER = 1;
  public static final int SRCUIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58 }, new String[] { "srcUidType", "srcUin", "srcTid", "srcOpenid", "result", "dstUidType", "dstUsrHeadInfos" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), null }, MultiBusidUrlRsp.class);
  public final PBUInt32Field dstUidType = PBField.initUInt32(0);
  public final PBRepeatMessageField dstUsrHeadInfos = PBField.initRepeatMessage(MultiHeadUrl.RspUsrHeadInfo.class);
  public final PBInt32Field result = PBField.initInt32(0);
  public final PBStringField srcOpenid = PBField.initString("");
  public final PBUInt64Field srcTid = PBField.initUInt64(0L);
  public final PBUInt32Field srcUidType = PBField.initUInt32(0);
  public final PBUInt64Field srcUin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlRsp
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.avatarinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MultiHeadUrl$RspUsrHeadInfo
  extends MessageMicro
{
  public static final int DSTHEADINFOS_FIELD_NUMBER = 4;
  public static final int DSTOPENID_FIELD_NUMBER = 3;
  public static final int DSTTID_FIELD_NUMBER = 2;
  public static final int DSTUIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "dstUin", "dstTid", "dstOpenid", "dstHeadInfos" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", null }, RspUsrHeadInfo.class);
  public final PBRepeatMessageField dstHeadInfos = PBField.initRepeatMessage(MultiHeadUrl.RspHeadInfo.class);
  public final PBStringField dstOpenid = PBField.initString("");
  public final PBUInt64Field dstTid = PBField.initUInt64(0L);
  public final PBUInt64Field dstUin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.avatarinfo.MultiHeadUrl.RspUsrHeadInfo
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.avatarinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQHeadUrl$QQHeadUrlRsp
  extends MessageMicro
{
  public static final int DSTENCRYPTTYPE_FIELD_NUMBER = 6;
  public static final int DSTHEADINFOS_FIELD_NUMBER = 5;
  public static final int DSTUSRTYPE_FIELD_NUMBER = 4;
  public static final int RESULT_FIELD_NUMBER = 3;
  public static final int SRCUIN_FIELD_NUMBER = 2;
  public static final int SRCUSRTYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "srcUsrType", "srcUin", "result", "dstUsrType", "dstHeadInfos", "dstEncryptType" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, QQHeadUrlRsp.class);
  public final PBUInt32Field dstEncryptType = PBField.initUInt32(0);
  public final PBRepeatMessageField dstHeadInfos = PBField.initRepeatMessage(QQHeadUrl.RspHeadInfo.class);
  public final PBUInt32Field dstUsrType = PBField.initUInt32(0);
  public final PBInt32Field result = PBField.initInt32(0);
  public final PBUInt64Field srcUin = PBField.initUInt64(0L);
  public final PBUInt32Field srcUsrType = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlRsp
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.avatarinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MultiHeadUrl$RspHeadInfo
  extends MessageMicro
{
  public static final int FACEFLAG_FIELD_NUMBER = 4;
  public static final int FACETYPE_FIELD_NUMBER = 2;
  public static final int SYSID_FIELD_NUMBER = 6;
  public static final int TIMESTAMP_FIELD_NUMBER = 3;
  public static final int URL_FIELD_NUMBER = 5;
  public static final int USRTYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "usrType", "faceType", "timestamp", "faceFlag", "url", "sysid" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, RspHeadInfo.class);
  public final PBUInt32Field faceFlag = PBField.initUInt32(0);
  public final PBUInt32Field faceType = PBField.initUInt32(0);
  public final PBUInt32Field sysid = PBField.initUInt32(0);
  public final PBUInt32Field timestamp = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
  public final PBUInt32Field usrType = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.avatarinfo.MultiHeadUrl.RspHeadInfo
 * JD-Core Version:    0.7.0.1
 */
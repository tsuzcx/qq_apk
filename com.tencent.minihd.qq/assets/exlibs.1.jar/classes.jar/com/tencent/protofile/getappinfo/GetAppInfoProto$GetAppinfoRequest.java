package com.tencent.protofile.getappinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetAppInfoProto$GetAppinfoRequest
  extends MessageMicro
{
  public static final int CLIENT_ID_FIELD_NUMBER = 1;
  public static final int ICONS_FIELD_NUMBER = 3;
  public static final int MD5TIME_FIELD_NUMBER = 6;
  public static final int OS_FIELD_NUMBER = 5;
  public static final int QQV_FIELD_NUMBER = 4;
  public static final int SDKP_FIELD_NUMBER = 2;
  public static final int SIGNATURE_FIELD_NUMBER = 7;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 58 }, new String[] { "client_id", "sdkp", "icons", "qqv", "os", "md5time", "signature" }, new Object[] { Long.valueOf(0L), "", "", "", "", Long.valueOf(0L), "" }, GetAppinfoRequest.class);
  public final PBInt64Field client_id = PBField.initInt64(0L);
  public final PBRepeatField icons = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt64Field md5time = PBField.initInt64(0L);
  public final PBStringField os = PBField.initString("");
  public final PBStringField qqv = PBField.initString("");
  public final PBStringField sdkp = PBField.initString("");
  public final PBStringField signature = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest
 * JD-Core Version:    0.7.0.1
 */
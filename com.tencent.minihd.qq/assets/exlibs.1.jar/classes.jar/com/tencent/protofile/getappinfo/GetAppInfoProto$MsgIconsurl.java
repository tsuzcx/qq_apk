package com.tencent.protofile.getappinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetAppInfoProto$MsgIconsurl
  extends MessageMicro
{
  public static final int SIZE_FIELD_NUMBER = 1;
  public static final int URL_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "size", "url" }, new Object[] { "", "" }, MsgIconsurl.class);
  public final PBStringField size = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl
 * JD-Core Version:    0.7.0.1
 */
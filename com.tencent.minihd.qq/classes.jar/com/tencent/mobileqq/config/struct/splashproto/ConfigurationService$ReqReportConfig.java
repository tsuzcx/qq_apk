package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ConfigurationService$ReqReportConfig
  extends MessageMicro
{
  public static final int CONFIG_LIST_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "config_list" }, new Object[] { null }, ReqReportConfig.class);
  public final PBRepeatMessageField config_list = PBField.initRepeatMessage(ConfigurationService.ReportConfig.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqReportConfig
 * JD-Core Version:    0.7.0.1
 */
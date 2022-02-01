package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class EmosmPb$SubCmd0x2RspFetchTab
  extends MessageMicro
{
  public static final int FIXED32_TIMESTAMP_FIELD_NUMBER = 1;
  public static final int INT32_SEGMENT_FLAG_FIELD_NUMBER = 2;
  public static final int RPT_MAGIC_TABINFO_FIELD_NUMBER = 4;
  public static final int RPT_MSG_TABINFO_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 26, 34 }, new String[] { "fixed32_timestamp", "int32_segment_flag", "rpt_msg_tabinfo", "rpt_magic_tabinfo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null }, SubCmd0x2RspFetchTab.class);
  public final PBFixed32Field fixed32_timestamp = PBField.initFixed32(0);
  public final PBInt32Field int32_segment_flag = PBField.initInt32(0);
  public final PBRepeatMessageField rpt_magic_tabinfo = PBField.initRepeatMessage(EmosmPb.SubCmd0x2RspFetchTab.TabInfo.class);
  public final PBRepeatMessageField rpt_msg_tabinfo = PBField.initRepeatMessage(EmosmPb.SubCmd0x2RspFetchTab.TabInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x2RspFetchTab
 * JD-Core Version:    0.7.0.1
 */
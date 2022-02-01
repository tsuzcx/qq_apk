package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class EmosmPb$SubCmd0x5RspBQRecommend
  extends MessageMicro
{
  public static final int STR_MOREBQ_IMG_URL_FIELD_NUMBER = 2;
  public static final int ST_TAB_INFO_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "st_tab_info", "str_morebq_img_url" }, new Object[] { null, "" }, SubCmd0x5RspBQRecommend.class);
  public final PBRepeatMessageField st_tab_info = PBField.initRepeatMessage(EmosmPb.STRecommendTabInfo.class);
  public final PBStringField str_morebq_img_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend
 * JD-Core Version:    0.7.0.1
 */
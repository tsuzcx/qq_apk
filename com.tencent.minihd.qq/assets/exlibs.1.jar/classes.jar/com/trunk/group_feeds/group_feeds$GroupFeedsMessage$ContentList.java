package com.trunk.group_feeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class group_feeds$GroupFeedsMessage$ContentList
  extends MessageMicro
{
  public static final int CONT_ELEM_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "cont_elem" }, new Object[] { null }, ContentList.class);
  public final PBRepeatMessageField cont_elem = PBField.initRepeatMessage(group_feeds.GroupFeedsMessage.MessageContent.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.trunk.group_feeds.group_feeds.GroupFeedsMessage.ContentList
 * JD-Core Version:    0.7.0.1
 */
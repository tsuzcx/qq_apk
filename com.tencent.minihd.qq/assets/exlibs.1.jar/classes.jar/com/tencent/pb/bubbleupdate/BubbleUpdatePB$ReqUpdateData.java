package com.tencent.pb.bubbleupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class BubbleUpdatePB$ReqUpdateData
  extends MessageMicro
{
  public static final int RPT_MSG_REQ_UPDATE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_req_update" }, new Object[] { null }, ReqUpdateData.class);
  public final PBRepeatMessageField rpt_msg_req_update = PBField.initRepeatMessage(BubbleUpdatePB.ReqUpdateTable.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.bubbleupdate.BubbleUpdatePB.ReqUpdateData
 * JD-Core Version:    0.7.0.1
 */
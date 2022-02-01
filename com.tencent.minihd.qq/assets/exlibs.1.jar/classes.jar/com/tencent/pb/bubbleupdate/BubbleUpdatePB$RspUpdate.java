package com.tencent.pb.bubbleupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BubbleUpdatePB$RspUpdate
  extends MessageMicro
{
  public static final int INT32_RET_FIELD_NUMBER = 1;
  public static final int MSG_RSP_DATA_FIELD_NUMBER = 4;
  public static final int UINT32_USED_ITEM_ID_FIELD_NUMBER = 3;
  public static final int UINT64_UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "int32_ret", "uint64_uin", "uint32_used_item_id", "msg_rsp_data" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null }, RspUpdate.class);
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public BubbleUpdatePB.RspUpdateData msg_rsp_data = new BubbleUpdatePB.RspUpdateData();
  public final PBUInt32Field uint32_used_item_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.bubbleupdate.BubbleUpdatePB.RspUpdate
 * JD-Core Version:    0.7.0.1
 */
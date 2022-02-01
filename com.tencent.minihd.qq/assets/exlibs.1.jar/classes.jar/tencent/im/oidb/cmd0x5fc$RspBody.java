package tencent.im.oidb;

import appoint.define.appoint_define.AppointID;
import appoint.define.appoint_define.DateEvent;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x5fc$RspBody
  extends MessageMicro
{
  public static final int MSG_EVENT_LIST_FIELD_NUMBER = 1;
  public static final int RPT_ACT_APPOINT_IDS_FIELD_NUMBER = 2;
  public static final int STR_ERROR_TIPS_FIELD_NUMBER = 4;
  public static final int UINT64_MAX_EVENT_ID_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "msg_event_list", "rpt_act_appoint_ids", "uint64_max_event_id", "str_error_tips" }, new Object[] { null, null, Long.valueOf(0L), "" }, RspBody.class);
  public final PBRepeatMessageField msg_event_list = PBField.initRepeatMessage(appoint_define.DateEvent.class);
  public final PBRepeatMessageField rpt_act_appoint_ids = PBField.initRepeatMessage(appoint_define.AppointID.class);
  public final PBStringField str_error_tips = PBField.initString("");
  public final PBUInt64Field uint64_max_event_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5fc.RspBody
 * JD-Core Version:    0.7.0.1
 */
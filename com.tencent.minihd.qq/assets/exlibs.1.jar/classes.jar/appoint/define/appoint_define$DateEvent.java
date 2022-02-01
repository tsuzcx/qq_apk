package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class appoint_define$DateEvent
  extends MessageMicro
{
  public static final int MSG_COMMENT_FIELD_NUMBER = 8;
  public static final int MSG_DATE_INFO_FIELD_NUMBER = 5;
  public static final int MSG_USER_INFO_FIELD_NUMBER = 4;
  public static final int STR_EVENT_TIPS_FIELD_NUMBER = 7;
  public static final int UINT32_ATTEND_IDX_FIELD_NUMBER = 6;
  public static final int UINT32_TIME_FIELD_NUMBER = 2;
  public static final int UINT32_TYPE_FIELD_NUMBER = 3;
  public static final int UINT64_CANCEL_EVENT_ID_FIELD_NUMBER = 9;
  public static final int UINT64_EVENT_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 58, 66, 72 }, new String[] { "uint64_event_id", "uint32_time", "uint32_type", "msg_user_info", "msg_date_info", "uint32_attend_idx", "str_event_tips", "msg_comment", "uint64_cancel_event_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, null, Integer.valueOf(0), "", null, Long.valueOf(0L) }, DateEvent.class);
  public appoint_define.DateComment msg_comment = new appoint_define.DateComment();
  public appoint_define.AppointInfo msg_date_info = new appoint_define.AppointInfo();
  public appoint_define.StrangerInfo msg_user_info = new appoint_define.StrangerInfo();
  public final PBStringField str_event_tips = PBField.initString("");
  public final PBUInt32Field uint32_attend_idx = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_cancel_event_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_event_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     appoint.define.appoint_define.DateEvent
 * JD-Core Version:    0.7.0.1
 */
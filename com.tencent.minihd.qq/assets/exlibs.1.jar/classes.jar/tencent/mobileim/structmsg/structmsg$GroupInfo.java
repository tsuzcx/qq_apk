package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class structmsg$GroupInfo
  extends MessageMicro
{
  public static final int DISPLAY_ACTION_FIELD_NUMBER = 2;
  public static final int GROUP_AUTH_TYPE_FIELD_NUMBER = 1;
  public static final int MSG_ALERT_FIELD_NUMBER = 3;
  public static final int MSG_DETAIL_ALERT_FIELD_NUMBER = 4;
  public static final int MSG_OTHER_ADMIN_DONE_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "group_auth_type", "display_action", "msg_alert", "msg_detail_alert", "msg_other_admin_done" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "" }, GroupInfo.class);
  public final PBUInt32Field display_action = PBField.initUInt32(0);
  public final PBUInt32Field group_auth_type = PBField.initUInt32(0);
  public final PBStringField msg_alert = PBField.initString("");
  public final PBStringField msg_detail_alert = PBField.initString("");
  public final PBStringField msg_other_admin_done = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.GroupInfo
 * JD-Core Version:    0.7.0.1
 */
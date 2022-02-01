package tencent.im.reminder;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.msg.im_msg_body.MsgBody;

public final class im_reminder$Reminder
  extends MessageMicro
{
  public static final int ALREADY_PUSHED_FIELD_NUMBER = 7;
  public static final int ASSOCIATION_SEQ_FIELD_NUMBER = 17;
  public static final int AT_TIME_FIELD_NUMBER = 3;
  public static final int BUSSI_TYPE_FIELD_NUMBER = 13;
  public static final int CONTENT_FIELD_NUMBER = 4;
  public static final int ENABLE_FIELD_NUMBER = 6;
  public static final int FROM_USER_FIELD_NUMBER = 1;
  public static final int LANG_FIELD_NUMBER = 16;
  public static final int LAST_OP_TIME_FIELD_NUMBER = 8;
  public static final int LAST_OP_TYPE_FIELD_NUMBER = 9;
  public static final int MSG_BODY_FIELD_NUMBER = 19;
  public static final int ONLY_REMINDER_AUTHOR_FIELD_NUMBER = 18;
  public static final int PC_TIPS_REDIRECT_URL_FIELD_NUMBER = 15;
  public static final int PC_TIPS_TITLE_FIELD_NUMBER = 14;
  public static final int REDIRECT_URL_FIELD_NUMBER = 11;
  public static final int RELATIONSHIP_FIELD_NUMBER = 10;
  public static final int REMINDER_NICK_FIELD_NUMBER = 12;
  public static final int SEQ_FIELD_NUMBER = 5;
  public static final int TO_USER_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field already_pushed = PBField.initUInt32(0);
  public final PBUInt64Field association_seq = PBField.initUInt64(0L);
  public final PBUInt64Field at_time = PBField.initUInt64(0L);
  public final PBUInt32Field bussi_type = PBField.initUInt32(0);
  public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBoolField enable = PBField.initBool(false);
  public im_reminder.Reminder.User from_user = new im_reminder.Reminder.User();
  public final PBStringField lang = PBField.initString("");
  public final PBUInt64Field last_op_time = PBField.initUInt64(0L);
  public final PBUInt64Field last_op_type = PBField.initUInt64(0L);
  public im_msg_body.MsgBody msg_body = new im_msg_body.MsgBody();
  public final PBUInt64Field only_reminder_author = PBField.initUInt64(0L);
  public final PBStringField pc_tips_redirect_url = PBField.initString("");
  public final PBStringField pc_tips_title = PBField.initString("");
  public final PBStringField redirect_url = PBField.initString("");
  public final PBUInt32Field relationship = PBField.initUInt32(0);
  public final PBStringField reminder_nick = PBField.initString("");
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  public im_reminder.Reminder.User to_user = new im_reminder.Reminder.User();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 56, 64, 72, 80, 90, 98, 104, 114, 122, 130, 136, 144, 154 }, new String[] { "from_user", "to_user", "at_time", "content", "seq", "enable", "already_pushed", "last_op_time", "last_op_type", "relationship", "redirect_url", "reminder_nick", "bussi_type", "pc_tips_title", "pc_tips_redirect_url", "lang", "association_seq", "only_reminder_author", "msg_body" }, new Object[] { null, null, Long.valueOf(0L), localByteStringMicro, Long.valueOf(0L), Boolean.valueOf(false), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", "", Long.valueOf(0L), Long.valueOf(0L), null }, Reminder.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.reminder.im_reminder.Reminder
 * JD-Core Version:    0.7.0.1
 */
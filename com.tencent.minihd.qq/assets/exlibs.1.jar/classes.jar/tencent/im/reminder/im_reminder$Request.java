package tencent.im.reminder;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class im_reminder$Request
  extends MessageMicro
{
  public static final int ADD_FIELD_NUMBER = 2;
  public static final int CHECK_ENABLE_FIELD_NUMBER = 8;
  public static final int DISABLE_FIELD_NUMBER = 6;
  public static final int ENABLE_FIELD_NUMBER = 7;
  public static final int GET_FIELD_NUMBER = 5;
  public static final int OPERATION_FIELD_NUMBER = 1;
  public static final int OP_ADD = 1;
  public static final int OP_ADD_TIME_REACHED = 20;
  public static final int OP_ALL_TIME_REACHED = 22;
  public static final int OP_CHECK_ENABLE = 7;
  public static final int OP_DEL_TIME_REACHED = 21;
  public static final int OP_DISABLE = 5;
  public static final int OP_ENABLE = 6;
  public static final int OP_GET = 4;
  public static final int OP_PUSH_MESSAGE_TO_USER = 8;
  public static final int OP_REMOVE = 2;
  public static final int OP_UPDATE = 3;
  public static final int REMINDER_FIELD_NUMBER = 10;
  public static final int REMOVE_FIELD_NUMBER = 3;
  public static final int TIME_REACHED_FIELD_NUMBER = 9;
  public static final int UPDATE_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "operation", "add", "remove", "update", "get", "disable", "enable", "check_enable", "time_reached", "reminder" }, new Object[] { Integer.valueOf(1), null, null, null, null, null, null, null, null, null }, Request.class);
  public im_reminder.Request.Add add = new im_reminder.Request.Add();
  public im_reminder.Request.CheckEnable check_enable = new im_reminder.Request.CheckEnable();
  public im_reminder.Request.Disable disable = new im_reminder.Request.Disable();
  public im_reminder.Request.Enable enable = new im_reminder.Request.Enable();
  public im_reminder.Request.Get get = new im_reminder.Request.Get();
  public final PBEnumField operation = PBField.initEnum(1);
  public im_reminder.Reminder reminder = new im_reminder.Reminder();
  public im_reminder.Request.Remove remove = new im_reminder.Request.Remove();
  public im_reminder.Request.TimeReachedReminders time_reached = new im_reminder.Request.TimeReachedReminders();
  public im_reminder.Request.Update update = new im_reminder.Request.Update();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.reminder.im_reminder.Request
 * JD-Core Version:    0.7.0.1
 */
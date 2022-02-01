package tencent.im.reminder;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class im_reminder$Request$TimeReachedReminders
  extends MessageMicro
{
  public static final int REMINDER_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "reminder" }, new Object[] { null }, TimeReachedReminders.class);
  public im_reminder.Reminder reminder = new im_reminder.Reminder();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.reminder.im_reminder.Request.TimeReachedReminders
 * JD-Core Version:    0.7.0.1
 */
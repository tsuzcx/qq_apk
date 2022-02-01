package tencent.im.reminder;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class im_reminder$Request$Update
  extends MessageMicro
{
  public static final int FROM_FIELD_NUMBER = 1;
  public static final int TO_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "from", "to" }, new Object[] { null, null }, Update.class);
  public im_reminder.Reminder from = new im_reminder.Reminder();
  public im_reminder.Reminder to = new im_reminder.Reminder();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.reminder.im_reminder.Request.Update
 * JD-Core Version:    0.7.0.1
 */
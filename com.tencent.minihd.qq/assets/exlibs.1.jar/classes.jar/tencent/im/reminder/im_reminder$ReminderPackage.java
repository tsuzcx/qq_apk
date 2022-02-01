package tencent.im.reminder;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class im_reminder$ReminderPackage
  extends MessageMicro
{
  public static final int HEAD_FIELD_NUMBER = 1;
  public static final int REQUEST_FIELD_NUMBER = 2;
  public static final int RESPONSE_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "head", "request", "response" }, new Object[] { null, null, null }, ReminderPackage.class);
  public im_reminder.PkgHead head = new im_reminder.PkgHead();
  public final PBRepeatMessageField request = PBField.initRepeatMessage(im_reminder.Request.class);
  public final PBRepeatMessageField response = PBField.initRepeatMessage(im_reminder.Response.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.reminder.im_reminder.ReminderPackage
 * JD-Core Version:    0.7.0.1
 */
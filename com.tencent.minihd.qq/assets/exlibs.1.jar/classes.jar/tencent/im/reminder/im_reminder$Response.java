package tencent.im.reminder;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_reminder$Response
  extends MessageMicro
{
  public static final int ERR_FIELD_NUMBER = 3;
  public static final int REMINDER_FIELD_NUMBER = 1;
  public static final int RESULT_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "reminder", "result", "err" }, new Object[] { null, Integer.valueOf(0), "" }, Response.class);
  public final PBStringField err = PBField.initString("");
  public final PBRepeatMessageField reminder = PBField.initRepeatMessage(im_reminder.Reminder.class);
  public final PBUInt32Field result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.reminder.im_reminder.Response
 * JD-Core Version:    0.7.0.1
 */
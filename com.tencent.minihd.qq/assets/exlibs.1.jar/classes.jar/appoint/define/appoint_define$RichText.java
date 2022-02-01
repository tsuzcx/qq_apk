package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class appoint_define$RichText
  extends MessageMicro
{
  public static final int RPT_MSG_ELEMS_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_elems" }, new Object[] { null }, RichText.class);
  public final PBRepeatMessageField rpt_msg_elems = PBField.initRepeatMessage(appoint_define.Elem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     appoint.define.appoint_define.RichText
 * JD-Core Version:    0.7.0.1
 */
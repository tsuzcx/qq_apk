package localpb.richMsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class MixedMsg$Msg
  extends MessageMicro
{
  public static final int ELEMS_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "elems" }, new Object[] { null }, Msg.class);
  public final PBRepeatMessageField elems = PBField.initRepeatMessage(MixedMsg.Elem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     localpb.richMsg.MixedMsg.Msg
 * JD-Core Version:    0.7.0.1
 */
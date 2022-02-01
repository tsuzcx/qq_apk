package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body$MsgDecodeTestMapElem
  extends MessageMicro
{
  public static final int KEY_FIELD_NUMBER = 1;
  public static final int VALUE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "key", "value" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, MsgDecodeTestMapElem.class);
  public final PBUInt32Field key = PBField.initUInt32(0);
  public final PBUInt64Field value = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.MsgDecodeTestMapElem
 * JD-Core Version:    0.7.0.1
 */
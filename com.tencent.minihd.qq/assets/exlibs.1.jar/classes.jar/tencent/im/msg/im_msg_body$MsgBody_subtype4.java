package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$MsgBody_subtype4
  extends MessageMicro
{
  public static final int MSG_NOT_ONLINE_FILE_FIELD_NUMBER = 1;
  public static final int UINT32_MSG_TIME_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_not_online_file", "uint32_msg_time" }, new Object[] { null, Integer.valueOf(0) }, MsgBody_subtype4.class);
  public im_msg_body.NotOnlineFile msg_not_online_file = new im_msg_body.NotOnlineFile();
  public final PBUInt32Field uint32_msg_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.MsgBody_subtype4
 * JD-Core Version:    0.7.0.1
 */
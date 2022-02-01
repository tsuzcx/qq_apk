package msf.msgcomm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import tencent.im.msg.im_msg_body.MsgBody;

public final class msg_comm$Msg
  extends MessageMicro
{
  public static final int APPSHARE_INFO_FIELD_NUMBER = 4;
  public static final int CONTENT_HEAD_FIELD_NUMBER = 2;
  public static final int MSG_BODY_FIELD_NUMBER = 3;
  public static final int MSG_HEAD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "msg_head", "content_head", "msg_body", "appshare_info" }, new Object[] { null, null, null, null }, Msg.class);
  public msg_comm.AppShareInfo appshare_info = new msg_comm.AppShareInfo();
  public msg_comm.ContentHead content_head = new msg_comm.ContentHead();
  public im_msg_body.MsgBody msg_body = new im_msg_body.MsgBody();
  public msg_comm.MsgHead msg_head = new msg_comm.MsgHead();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     msf.msgcomm.msg_comm.Msg
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.group.nearbybanner;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class nearbybanner$ReqBody
  extends MessageMicro
{
  public static final int MSG_CLIENT_INFO_FIELD_NUMBER = 1;
  public static final int MSG_USER_INFO_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_client_info", "msg_user_info" }, new Object[] { null, null }, ReqBody.class);
  public nearbybanner.ClientInfo msg_client_info = new nearbybanner.ClientInfo();
  public nearbybanner.UserInfo msg_user_info = new nearbybanner.UserInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.group.nearbybanner.nearbybanner.ReqBody
 * JD-Core Version:    0.7.0.1
 */
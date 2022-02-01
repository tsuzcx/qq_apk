package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appoint_define$DateComment
  extends MessageMicro
{
  public static final int MSG_APPOINT_ID_FIELD_NUMBER = 2;
  public static final int MSG_CONTENT_FIELD_NUMBER = 8;
  public static final int MSG_PUBLISHER_INFO_FIELD_NUMBER = 3;
  public static final int MSG_REPLY_INFO_FIELD_NUMBER = 6;
  public static final int STR_COMMENT_ID_FIELD_NUMBER = 1;
  public static final int STR_CONTENT_FIELD_NUMBER = 5;
  public static final int UINT32_FLAG_FIELD_NUMBER = 7;
  public static final int UINT32_TIME_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 56, 66 }, new String[] { "str_comment_id", "msg_appoint_id", "msg_publisher_info", "uint32_time", "str_content", "msg_reply_info", "uint32_flag", "msg_content" }, new Object[] { "", null, null, Integer.valueOf(0), "", null, Integer.valueOf(0), null }, DateComment.class);
  public appoint_define.AppointID msg_appoint_id = new appoint_define.AppointID();
  public appoint_define.RichText msg_content = new appoint_define.RichText();
  public appoint_define.StrangerInfo msg_publisher_info = new appoint_define.StrangerInfo();
  public appoint_define.ReplyInfo msg_reply_info = new appoint_define.ReplyInfo();
  public final PBStringField str_comment_id = PBField.initString("");
  public final PBStringField str_content = PBField.initString("");
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     appoint.define.appoint_define.DateComment
 * JD-Core Version:    0.7.0.1
 */
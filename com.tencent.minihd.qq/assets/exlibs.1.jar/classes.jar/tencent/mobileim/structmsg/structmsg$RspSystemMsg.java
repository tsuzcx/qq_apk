package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$RspSystemMsg
  extends MessageMicro
{
  public static final int FOLLOWING_FRIEND_SEQ_FIELD_NUMBER = 6;
  public static final int FOLLOWING_GROUP_SEQ_FIELD_NUMBER = 7;
  public static final int HEAD_FIELD_NUMBER = 1;
  public static final int LATEST_FRIEND_SEQ_FIELD_NUMBER = 4;
  public static final int LATEST_GROUP_SEQ_FIELD_NUMBER = 5;
  public static final int MSGS_FIELD_NUMBER = 2;
  public static final int MSG_DISPLAY_FIELD_NUMBER = 8;
  public static final int UNREAD_COUNT_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 66 }, new String[] { "head", "msgs", "unread_count", "latest_friend_seq", "latest_group_seq", "following_friend_seq", "following_group_seq", "msg_display" }, new Object[] { null, null, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "" }, RspSystemMsg.class);
  public final PBUInt64Field following_friend_seq = PBField.initUInt64(0L);
  public final PBUInt64Field following_group_seq = PBField.initUInt64(0L);
  public structmsg.RspHead head = new structmsg.RspHead();
  public final PBUInt64Field latest_friend_seq = PBField.initUInt64(0L);
  public final PBUInt64Field latest_group_seq = PBField.initUInt64(0L);
  public final PBStringField msg_display = PBField.initString("");
  public final PBRepeatMessageField msgs = PBField.initRepeatMessage(structmsg.StructMsg.class);
  public final PBUInt32Field unread_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.RspSystemMsg
 * JD-Core Version:    0.7.0.1
 */
package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$RspNextSystemMsg
  extends MessageMicro
{
  public static final int CHECKTYPE_FIELD_NUMBER = 5;
  public static final int FOLLOWING_FRIEND_SEQ_FIELD_NUMBER = 3;
  public static final int FOLLOWING_GROUP_SEQ_FIELD_NUMBER = 4;
  public static final int HEAD_FIELD_NUMBER = 1;
  public static final int MSGS_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "head", "msgs", "following_friend_seq", "following_group_seq", "checktype" }, new Object[] { null, null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(1) }, RspNextSystemMsg.class);
  public final PBEnumField checktype = PBField.initEnum(1);
  public final PBUInt64Field following_friend_seq = PBField.initUInt64(0L);
  public final PBUInt64Field following_group_seq = PBField.initUInt64(0L);
  public structmsg.RspHead head = new structmsg.RspHead();
  public final PBRepeatMessageField msgs = PBField.initRepeatMessage(structmsg.StructMsg.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.RspNextSystemMsg
 * JD-Core Version:    0.7.0.1
 */
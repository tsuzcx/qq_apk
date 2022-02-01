package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$StructMsg
  extends MessageMicro
{
  public static final int MSG_FIELD_NUMBER = 50;
  public static final int MSG_SEQ_FIELD_NUMBER = 3;
  public static final int MSG_TIME_FIELD_NUMBER = 4;
  public static final int MSG_TYPE_FIELD_NUMBER = 2;
  public static final int REQ_UIN_FIELD_NUMBER = 5;
  public static final int VERSION_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 402 }, new String[] { "version", "msg_type", "msg_seq", "msg_time", "req_uin", "msg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null }, StructMsg.class);
  public structmsg.SystemMsg msg = new structmsg.SystemMsg();
  public final PBUInt64Field msg_seq = PBField.initUInt64(0L);
  public final PBUInt64Field msg_time = PBField.initUInt64(0L);
  public final PBEnumField msg_type = PBField.initEnum(1);
  public final PBUInt64Field req_uin = PBField.initUInt64(0L);
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.StructMsg
 * JD-Core Version:    0.7.0.1
 */
package msf.msgcomm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_comm$UinPairMsg
  extends MessageMicro
{
  public static final int LAST_READ_TIME_FIELD_NUMBER = 1;
  public static final int MSG_COMPLETED_FIELD_NUMBER = 3;
  public static final int MSG_FIELD_NUMBER = 4;
  public static final int PEER_UIN_FIELD_NUMBER = 2;
  public static final int UNREAD_MSG_NUM_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "last_read_time", "peer_uin", "msg_completed", "msg", "unread_msg_num" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0) }, UinPairMsg.class);
  public final PBUInt32Field last_read_time = PBField.initUInt32(0);
  public final PBRepeatMessageField msg = PBField.initRepeatMessage(msg_comm.Msg.class);
  public final PBUInt32Field msg_completed = PBField.initUInt32(0);
  public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
  public final PBUInt32Field unread_msg_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     msf.msgcomm.msg_comm.UinPairMsg
 * JD-Core Version:    0.7.0.1
 */
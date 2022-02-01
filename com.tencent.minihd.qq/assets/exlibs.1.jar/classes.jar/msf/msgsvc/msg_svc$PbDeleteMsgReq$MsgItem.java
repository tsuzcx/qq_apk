package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbDeleteMsgReq$MsgItem
  extends MessageMicro
{
  public static final int FROM_UIN_FIELD_NUMBER = 1;
  public static final int MSG_SEQ_FIELD_NUMBER = 4;
  public static final int MSG_TYPE_FIELD_NUMBER = 3;
  public static final int MSG_UID_FIELD_NUMBER = 5;
  public static final int TO_UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "from_uin", "to_uin", "msg_type", "msg_seq", "msg_uid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, MsgItem.class);
  public final PBUInt64Field from_uin = PBField.initUInt64(0L);
  public final PBUInt32Field msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field msg_type = PBField.initUInt32(0);
  public final PBUInt64Field msg_uid = PBField.initUInt64(0L);
  public final PBUInt64Field to_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbDeleteMsgReq.MsgItem
 * JD-Core Version:    0.7.0.1
 */
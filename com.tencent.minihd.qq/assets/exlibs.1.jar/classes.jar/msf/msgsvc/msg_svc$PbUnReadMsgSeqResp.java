package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class msg_svc$PbUnReadMsgSeqResp
  extends MessageMicro
{
  public static final int BINDUIN_UNREAD_INFO_FIELD_NUMBER = 2;
  public static final int C2C_UNREAD_INFO_FIELD_NUMBER = 1;
  public static final int DISCUSS_UNREAD_INFO_FIELD_NUMBER = 4;
  public static final int GROUP_UNREAD_INFO_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "c2c_unread_info", "binduin_unread_info", "group_unread_info", "discuss_unread_info" }, new Object[] { null, null, null, null }, PbUnReadMsgSeqResp.class);
  public final PBRepeatMessageField binduin_unread_info = PBField.initRepeatMessage(msg_svc.PbBindUinUnReadMsgNumResp.class);
  public msg_svc.PbC2CUnReadMsgNumResp c2c_unread_info = new msg_svc.PbC2CUnReadMsgNumResp();
  public msg_svc.PbPullDiscussMsgSeqResp discuss_unread_info = new msg_svc.PbPullDiscussMsgSeqResp();
  public msg_svc.PbPullGroupMsgSeqResp group_unread_info = new msg_svc.PbPullGroupMsgSeqResp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbUnReadMsgSeqResp
 * JD-Core Version:    0.7.0.1
 */
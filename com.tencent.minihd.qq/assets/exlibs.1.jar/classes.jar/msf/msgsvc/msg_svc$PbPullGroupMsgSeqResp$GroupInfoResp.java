package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbPullGroupMsgSeqResp$GroupInfoResp
  extends MessageMicro
{
  public static final int GROUP_CODE_FIELD_NUMBER = 1;
  public static final int GROUP_SEQ_FIELD_NUMBER = 3;
  public static final int MEMBER_SEQ_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "group_code", "member_seq", "group_seq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, GroupInfoResp.class);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt64Field group_seq = PBField.initUInt64(0L);
  public final PBUInt64Field member_seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp
 * JD-Core Version:    0.7.0.1
 */
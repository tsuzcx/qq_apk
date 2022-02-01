package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbGetGroupMsgReq
  extends MessageMicro
{
  public static final int BEGIN_SEQ_FIELD_NUMBER = 2;
  public static final int END_SEQ_FIELD_NUMBER = 3;
  public static final int FILTER_FIELD_NUMBER = 4;
  public static final int GROUP_CODE_FIELD_NUMBER = 1;
  public static final int MEMBER_SEQ_FIELD_NUMBER = 5;
  public static final int PUBLIC_GROUP_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "group_code", "begin_seq", "end_seq", "filter", "member_seq", "public_group" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Boolean.valueOf(false) }, PbGetGroupMsgReq.class);
  public final PBUInt64Field begin_seq = PBField.initUInt64(0L);
  public final PBUInt64Field end_seq = PBField.initUInt64(0L);
  public final PBEnumField filter = PBField.initEnum(0);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt64Field member_seq = PBField.initUInt64(0L);
  public final PBBoolField public_group = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbGetGroupMsgReq
 * JD-Core Version:    0.7.0.1
 */
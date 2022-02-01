package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbC2CReadedReportReq$UinPairReadInfo
  extends MessageMicro
{
  public static final int CRM_SIG_FIELD_NUMBER = 3;
  public static final int LAST_READ_TIME_FIELD_NUMBER = 2;
  public static final int PEER_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField crm_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field last_read_time = PBField.initUInt32(0);
  public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "peer_uin", "last_read_time", "crm_sig" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, UinPairReadInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo
 * JD-Core Version:    0.7.0.1
 */
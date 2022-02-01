package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class msg_svc$PbMsgReadedReportResp
  extends MessageMicro
{
  public static final int BIND_UIN_READ_REPORT_FIELD_NUMBER = 4;
  public static final int C2C_READ_REPORT_FIELD_NUMBER = 3;
  public static final int DIS_READ_REPORT_FIELD_NUMBER = 2;
  public static final int GRP_READ_REPORT_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "grp_read_report", "dis_read_report", "c2c_read_report", "bind_uin_read_report" }, new Object[] { null, null, null, null }, PbMsgReadedReportResp.class);
  public msg_svc.PbBindUinMsgReadedConfirmResp bind_uin_read_report = new msg_svc.PbBindUinMsgReadedConfirmResp();
  public msg_svc.PbC2CReadedReportResp c2c_read_report = new msg_svc.PbC2CReadedReportResp();
  public final PBRepeatMessageField dis_read_report = PBField.initRepeatMessage(msg_svc.PbDiscussReadedReportResp.class);
  public final PBRepeatMessageField grp_read_report = PBField.initRepeatMessage(msg_svc.PbGroupReadedReportResp.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbMsgReadedReportResp
 * JD-Core Version:    0.7.0.1
 */
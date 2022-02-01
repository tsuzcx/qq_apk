package tencent.im.profile.forward;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class sysmsg_push$ForwardHead
  extends MessageMicro
{
  public static final int FIXED32_SERVICE_ADDR_FIELD_NUMBER = 6;
  public static final int RPT_FIXED32_CLIENT_ADDR_FIELD_NUMBER = 7;
  public static final int UINT32_CLIENT_TYPE_FIELD_NUMBER = 2;
  public static final int UINT32_CMD_FIELD_NUMBER = 4;
  public static final int UINT32_IF_NEED_ACK_FIELD_NUMBER = 9;
  public static final int UINT32_REQ_TYPE_FIELD_NUMBER = 3;
  public static final int UINT32_RESULT_FIELD_NUMBER = 10;
  public static final int UINT32_SEQUENCE_FIELD_NUMBER = 8;
  public static final int UINT32_SUB_CMD_FIELD_NUMBER = 5;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 53, 61, 64, 72, 80 }, new String[] { "uint64_uin", "uint32_client_type", "uint32_req_type", "uint32_cmd", "uint32_sub_cmd", "fixed32_service_addr", "rpt_fixed32_client_addr", "uint32_sequence", "uint32_if_need_ack", "uint32_result" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ForwardHead.class);
  public final PBFixed32Field fixed32_service_addr = PBField.initFixed32(0);
  public final PBRepeatField rpt_fixed32_client_addr = PBField.initRepeat(PBFixed32Field.__repeatHelper__);
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_if_need_ack = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.profile.forward.sysmsg_push.ForwardHead
 * JD-Core Version:    0.7.0.1
 */
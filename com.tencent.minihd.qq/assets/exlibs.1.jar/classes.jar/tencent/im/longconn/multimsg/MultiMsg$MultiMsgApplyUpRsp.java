package tencent.im.longconn.multimsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MultiMsg$MultiMsgApplyUpRsp
  extends MessageMicro
{
  public static final int BYTES_MSG_KEY_FIELD_NUMBER = 9;
  public static final int BYTES_MSG_RESID_FIELD_NUMBER = 2;
  public static final int BYTES_MSG_SIG_FIELD_NUMBER = 10;
  public static final int BYTES_MSG_UKEY_FIELD_NUMBER = 3;
  public static final int RPT_UINT32_UP_IP_FIELD_NUMBER = 4;
  public static final int RPT_UINT32_UP_PORT_FIELD_NUMBER = 5;
  public static final int UINT32_APPLY_ID_FIELD_NUMBER = 8;
  public static final int UINT32_RESULT_FIELD_NUMBER = 1;
  public static final int UINT64_BLOCK_SIZE_FIELD_NUMBER = 6;
  public static final int UINT64_UP_OFFSET_FIELD_NUMBER = 7;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msg_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField rpt_uint32_up_ip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField rpt_uint32_up_port = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_apply_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt64Field uint64_block_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_up_offset = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 64, 74, 82 }, new String[] { "uint32_result", "bytes_msg_resid", "bytes_msg_ukey", "rpt_uint32_up_ip", "rpt_uint32_up_port", "uint64_block_size", "uint64_up_offset", "uint32_apply_id", "bytes_msg_key", "bytes_msg_sig" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4 }, MultiMsgApplyUpRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyUpRsp
 * JD-Core Version:    0.7.0.1
 */
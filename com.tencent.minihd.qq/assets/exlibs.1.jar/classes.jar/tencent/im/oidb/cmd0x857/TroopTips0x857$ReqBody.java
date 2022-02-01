package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TroopTips0x857$ReqBody
  extends MessageMicro
{
  public static final int MSG_INST_CTRL_FIELD_NUMBER = 4;
  public static final int OPT_BYTES_MSG_FIELD_NUMBER = 5;
  public static final int OPT_UINT32_OFFLINE_FIELD_NUMBER = 3;
  public static final int OPT_UINT64_GROUP_CODE_FIELD_NUMBER = 1;
  public static final int RPT_UINT64_MEMBERUINS_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public TroopTips0x857.InstCtrl msg_inst_ctrl = new TroopTips0x857.InstCtrl();
  public final PBBytesField opt_bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field opt_uint32_offline = PBField.initUInt32(0);
  public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0L);
  public final PBRepeatField rpt_uint64_memberuins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "opt_uint64_group_code", "rpt_uint64_memberuins", "opt_uint32_offline", "msg_inst_ctrl", "opt_bytes_msg" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null, localByteStringMicro }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.ReqBody
 * JD-Core Version:    0.7.0.1
 */
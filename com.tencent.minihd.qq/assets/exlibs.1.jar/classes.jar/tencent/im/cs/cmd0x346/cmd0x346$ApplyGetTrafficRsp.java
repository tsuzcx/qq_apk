package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x346$ApplyGetTrafficRsp
  extends MessageMicro
{
  public static final int INT32_RET_CODE_FIELD_NUMBER = 10;
  public static final int STR_RET_MSG_FIELD_NUMBER = 20;
  public static final int UINT32_ALL_FILE_NUM_FIELD_NUMBER = 60;
  public static final int UINT32_USE_FILE_NUM_FIELD_NUMBER = 40;
  public static final int UINT64_ALL_FILE_SIZE_FIELD_NUMBER = 50;
  public static final int UINT64_USE_FILE_SIZE_FIELD_NUMBER = 30;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 240, 320, 400, 480 }, new String[] { "int32_ret_code", "str_ret_msg", "uint64_use_file_size", "uint32_use_file_num", "uint64_all_file_size", "uint32_all_file_num" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, ApplyGetTrafficRsp.class);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBUInt32Field uint32_all_file_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_use_file_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_all_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_use_file_size = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.ApplyGetTrafficRsp
 * JD-Core Version:    0.7.0.1
 */
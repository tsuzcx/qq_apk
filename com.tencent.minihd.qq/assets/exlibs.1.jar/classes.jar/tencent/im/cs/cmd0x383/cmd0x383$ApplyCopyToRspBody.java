package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x383$ApplyCopyToRspBody
  extends MessageMicro
{
  public static final int BOOL_SAFE_CHECK_FLAG_FIELD_NUMBER = 11;
  public static final int STR_SAVE_FILE_PATH_FIELD_NUMBER = 1;
  public static final int UINT32_SAFE_CHECK_RES_FIELD_NUMBER = 12;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 88, 96 }, new String[] { "str_save_file_path", "bool_safe_check_flag", "uint32_safe_check_res" }, new Object[] { "", Boolean.valueOf(false), Integer.valueOf(0) }, ApplyCopyToRspBody.class);
  public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
  public final PBStringField str_save_file_path = PBField.initString("");
  public final PBUInt32Field uint32_safe_check_res = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyCopyToRspBody
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x791$SetRedDotOpt
  extends MessageMicro
{
  public static final int BOOL_CLEAR_FIELD_NUMBER = 3;
  public static final int BOOL_DISPLAY_REDDOT_FIELD_NUMBER = 4;
  public static final int BOOL_PUSH_TO_CLIENT_FIELD_NUMBER = 7;
  public static final int INT32_NUMBER_FIELD_NUMBER = 5;
  public static final int RPT_UINT64_UIN_FIELD_NUMBER = 2;
  public static final int STR_FACE_URL_FIELD_NUMBER = 8;
  public static final int UINT32_REASON_FIELD_NUMBER = 6;
  public static final int UINT64_CMD_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_clear = PBField.initBool(false);
  public final PBBoolField bool_display_reddot = PBField.initBool(false);
  public final PBBoolField bool_push_to_client = PBField.initBool(false);
  public final PBInt32Field int32_number = PBField.initInt32(0);
  public final PBRepeatField rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBBytesField str_face_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_reason = PBField.initUInt32(0);
  public final PBUInt64Field uint64_cmd_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66 }, new String[] { "uint64_cmd_uin", "rpt_uint64_uin", "bool_clear", "bool_display_reddot", "int32_number", "uint32_reason", "bool_push_to_client", "str_face_url" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), localByteStringMicro }, SetRedDotOpt.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x791.oidb_0x791.SetRedDotOpt
 * JD-Core Version:    0.7.0.1
 */
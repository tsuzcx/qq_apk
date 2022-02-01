package tencent.im.s2c.msgtype0x211.submsgtype0x9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class C2CType0x211_SubC2CType0x9$MsgBody$MsgPrinter
  extends MessageMicro
{
  public static final int RPT_MSG_SUPPORT_FILE_INFO_FIELD_NUMBER = 6;
  public static final int RPT_STRING_PRINTER_FIELD_NUMBER = 1;
  public static final int RPT_UINT64_SESSION_ID_FIELD_NUMBER = 5;
  public static final int STR_RESULT_MSG_FIELD_NUMBER = 4;
  public static final int UINT32_PRINT_RESULT_FIELD_NUMBER = 3;
  public static final int UINT64_PRINT_SESSION_ID_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 50 }, new String[] { "rpt_string_printer", "uint64_print_session_id", "uint32_print_result", "str_result_msg", "rpt_uint64_session_id", "rpt_msg_support_file_info" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), "", Long.valueOf(0L), null }, MsgPrinter.class);
  public final PBRepeatMessageField rpt_msg_support_file_info = PBField.initRepeatMessage(C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo.class);
  public final PBRepeatField rpt_string_printer = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField rpt_uint64_session_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBStringField str_result_msg = PBField.initString("");
  public final PBUInt32Field uint32_print_result = PBField.initUInt32(0);
  public final PBUInt64Field uint64_print_session_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody.MsgPrinter
 * JD-Core Version:    0.7.0.1
 */
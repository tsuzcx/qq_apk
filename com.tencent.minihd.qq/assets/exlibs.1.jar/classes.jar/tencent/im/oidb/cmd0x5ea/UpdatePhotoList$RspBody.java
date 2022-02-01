package tencent.im.oidb.cmd0x5ea;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UpdatePhotoList$RspBody
  extends MessageMicro
{
  public static final int RPT_MSG_HEADINFO_FIELD_NUMBER = 1;
  public static final int STR_ERRORINFO_FIELD_NUMBER = 2;
  public static final int UINT32_IMPORT_COUNT_FIELD_NUMBER = 4;
  public static final int UINT32_IMPORT_REST_COUNT_FIELD_NUMBER = 5;
  public static final int UINT32_IMPORT_STATE_FIELD_NUMBER = 3;
  public static final int UINT32_REST_COUNT_IN_QZONE_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48 }, new String[] { "rpt_msg_headinfo", "str_errorinfo", "uint32_import_state", "uint32_import_count", "uint32_import_rest_count", "uint32_rest_count_in_qzone" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  public final PBRepeatMessageField rpt_msg_headinfo = PBField.initRepeatMessage(UpdatePhotoList.HeadInfo.class);
  public final PBStringField str_errorinfo = PBField.initString("");
  public final PBUInt32Field uint32_import_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_import_rest_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_import_state = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rest_count_in_qzone = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5ea.UpdatePhotoList.RspBody
 * JD-Core Version:    0.7.0.1
 */
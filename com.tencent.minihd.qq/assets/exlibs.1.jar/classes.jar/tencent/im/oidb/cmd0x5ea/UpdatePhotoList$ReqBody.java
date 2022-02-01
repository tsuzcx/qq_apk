package tencent.im.oidb.cmd0x5ea;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UpdatePhotoList$ReqBody
  extends MessageMicro
{
  public static final int RPT_UINT32_HEADIDS_FIELD_NUMBER = 1;
  public static final int STR_UPLOAD_URL_FIELD_NUMBER = 2;
  public static final int UINT32_COPY_COUNT_FROM_QZONE_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "rpt_uint32_headids", "str_upload_url", "uint32_copy_count_from_qzone" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, ReqBody.class);
  public final PBRepeatField rpt_uint32_headids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBStringField str_upload_url = PBField.initString("");
  public final PBUInt32Field uint32_copy_count_from_qzone = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5ea.UpdatePhotoList.ReqBody
 * JD-Core Version:    0.7.0.1
 */
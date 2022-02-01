package tencent.im.oidb.cmd0x5e9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GetPhotoList$HeadInfo
  extends MessageMicro
{
  public static final int STR_HEADURL_FIELD_NUMBER = 2;
  public static final int UINT32_HEADID_FIELD_NUMBER = 1;
  public static final int UINT32_IS_CURHEAD_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 32 }, new String[] { "uint32_headid", "str_headurl", "uint32_is_curhead" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, HeadInfo.class);
  public final PBStringField str_headurl = PBField.initString("");
  public final PBUInt32Field uint32_headid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_curhead = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e9.GetPhotoList.HeadInfo
 * JD-Core Version:    0.7.0.1
 */
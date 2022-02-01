package tencent.im.oidb.cmd0x7a1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x7a1$ReqBody
  extends MessageMicro
{
  public static final int STR_IMEI_FIELD_NUMBER = 2;
  public static final int UINT32_CLT_APPID_FIELD_NUMBER = 3;
  public static final int UINT32_FLAG_FIELD_NUMBER = 4;
  public static final int UINT64_BIND_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint64_bind_uin", "str_imei", "uint32_clt_appid", "uint32_flag" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public final PBStringField str_imei = PBField.initString("");
  public final PBUInt32Field uint32_clt_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_bind_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7a1.oidb_0x7a1.ReqBody
 * JD-Core Version:    0.7.0.1
 */
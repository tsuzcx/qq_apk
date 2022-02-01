package tencent.im.oidb.cmd0x7d0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x7d0$OneBasicInfo
  extends MessageMicro
{
  public static final int UINT32_IS_TODAY_LOGIN_FIELD_NUMBER = 5;
  public static final int UINT32_IS_YESTODAY_LOGIN_FIELD_NUMBER = 4;
  public static final int UINT32_LOGIN_DAYS_FIELD_NUMBER = 2;
  public static final int UINT32_OPEN_LOGIN_DAYS_FIELD_NUMBER = 3;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_uin", "uint32_login_days", "uint32_open_login_days", "uint32_is_yestoday_login", "uint32_is_today_login" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, OneBasicInfo.class);
  public final PBUInt32Field uint32_is_today_login = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_yestoday_login = PBField.initUInt32(0);
  public final PBUInt32Field uint32_login_days = PBField.initUInt32(0);
  public final PBUInt32Field uint32_open_login_days = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7d0.oidb_cmd0x7d0.OneBasicInfo
 * JD-Core Version:    0.7.0.1
 */
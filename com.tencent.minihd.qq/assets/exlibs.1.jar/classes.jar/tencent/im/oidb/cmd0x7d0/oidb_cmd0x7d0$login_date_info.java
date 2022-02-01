package tencent.im.oidb.cmd0x7d0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x7d0$login_date_info
  extends MessageMicro
{
  public static final int MSG_GAP_END_DATE_FIELD_NUMBER = 3;
  public static final int MSG_GAP_START_DATE_FIELD_NUMBER = 2;
  public static final int MSG_LOGIN_START_DATE_FIELD_NUMBER = 1;
  public static final int MSG_NEXT_LEVEL_DATE_FIELD_NUMBER = 4;
  public static final int UINT32_LOGIN_DAYS_FIELD_NUMBER = 7;
  public static final int UINT32_NEXT_LEVEL_DAYS_FIELD_NUMBER = 5;
  public static final int UINT32_NEXT_PERCENT_FIELD_NUMBER = 6;
  public static final int UINT32_NOW_PERCENT_FIELD_NUMBER = 8;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56, 64 }, new String[] { "msg_login_start_date", "msg_gap_start_date", "msg_gap_end_date", "msg_next_level_date", "uint32_next_level_days", "uint32_next_percent", "uint32_login_days", "uint32_now_percent" }, new Object[] { null, null, null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, login_date_info.class);
  public oidb_cmd0x7d0.one_date msg_gap_end_date = new oidb_cmd0x7d0.one_date();
  public oidb_cmd0x7d0.one_date msg_gap_start_date = new oidb_cmd0x7d0.one_date();
  public oidb_cmd0x7d0.one_date msg_login_start_date = new oidb_cmd0x7d0.one_date();
  public oidb_cmd0x7d0.one_date msg_next_level_date = new oidb_cmd0x7d0.one_date();
  public final PBUInt32Field uint32_login_days = PBField.initUInt32(0);
  public final PBUInt32Field uint32_next_level_days = PBField.initUInt32(0);
  public final PBUInt32Field uint32_next_percent = PBField.initUInt32(0);
  public final PBUInt32Field uint32_now_percent = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7d0.oidb_cmd0x7d0.login_date_info
 * JD-Core Version:    0.7.0.1
 */
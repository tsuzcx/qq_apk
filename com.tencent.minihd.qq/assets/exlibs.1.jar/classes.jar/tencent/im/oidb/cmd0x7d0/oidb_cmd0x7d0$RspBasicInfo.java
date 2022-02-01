package tencent.im.oidb.cmd0x7d0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x7d0$RspBasicInfo
  extends MessageMicro
{
  public static final int RPT_MSG_BASIC_INFO_FIELD_NUMBER = 4;
  public static final int UINT32_CLICK_DISABLED_FIELD_NUMBER = 2;
  public static final int UINT32_DAYS_FIELD_NUMBER = 3;
  public static final int UINT32_HIDE_ICON_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_hide_icon", "uint32_click_disabled", "uint32_days", "rpt_msg_basic_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, RspBasicInfo.class);
  public final PBRepeatMessageField rpt_msg_basic_info = PBField.initRepeatMessage(oidb_cmd0x7d0.OneBasicInfo.class);
  public final PBUInt32Field uint32_click_disabled = PBField.initUInt32(0);
  public final PBUInt32Field uint32_days = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hide_icon = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7d0.oidb_cmd0x7d0.RspBasicInfo
 * JD-Core Version:    0.7.0.1
 */
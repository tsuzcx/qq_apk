package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TroopTips0x857$NotifyMsgBody
  extends MessageMicro
{
  public static final int OPT_ENUM_TYPE_FIELD_NUMBER = 1;
  public static final int OPT_MSG_FLOATEDTIPS_FIELD_NUMBER = 7;
  public static final int OPT_MSG_GRAYTIPS_FIELD_NUMBER = 5;
  public static final int OPT_MSG_MESSAGEBOX_FIELD_NUMBER = 6;
  public static final int OPT_MSG_TOPTIPS_FIELD_NUMBER = 8;
  public static final int OPT_UINT64_GROUP_CODE_FIELD_NUMBER = 4;
  public static final int OPT_UINT64_MSG_EXPIRES_FIELD_NUMBER = 3;
  public static final int OPT_UINT64_MSG_TIME_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66 }, new String[] { "opt_enum_type", "opt_uint64_msg_time", "opt_uint64_msg_expires", "opt_uint64_group_code", "opt_msg_graytips", "opt_msg_messagebox", "opt_msg_floatedtips", "opt_msg_toptips" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, null, null, null }, NotifyMsgBody.class);
  public final PBEnumField opt_enum_type = PBField.initEnum(1);
  public TroopTips0x857.FloatedTipsInfo opt_msg_floatedtips = new TroopTips0x857.FloatedTipsInfo();
  public TroopTips0x857.AIOGrayTipsInfo opt_msg_graytips = new TroopTips0x857.AIOGrayTipsInfo();
  public TroopTips0x857.MessageBoxInfo opt_msg_messagebox = new TroopTips0x857.MessageBoxInfo();
  public TroopTips0x857.AIOTopTipsInfo opt_msg_toptips = new TroopTips0x857.AIOTopTipsInfo();
  public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field opt_uint64_msg_expires = PBField.initUInt64(0L);
  public final PBUInt64Field opt_uint64_msg_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.NotifyMsgBody
 * JD-Core Version:    0.7.0.1
 */
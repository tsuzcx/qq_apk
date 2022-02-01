package tencent.im.oidb.cmd0x88c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x88c$RspBody
  extends MessageMicro
{
  public static final int STR_ERRORINFO_FIELD_NUMBER = 2;
  public static final int UINT32_CREATED_GROUP_1K_FIELD_NUMBER = 8;
  public static final int UINT32_CREATED_GROUP_2K_FIELD_NUMBER = 9;
  public static final int UINT32_CREATED_GROUP_500_FIELD_NUMBER = 7;
  public static final int UINT32_CREATED_GROUP_MINI_FIELD_NUMBER = 10;
  public static final int UINT32_GROUP_1K_FIELD_NUMBER = 4;
  public static final int UINT32_GROUP_1K_FREQ_AVAIL_FIELD_NUMBER = 12;
  public static final int UINT32_GROUP_2K_FIELD_NUMBER = 5;
  public static final int UINT32_GROUP_2K_FREQ_AVAIL_FIELD_NUMBER = 13;
  public static final int UINT32_GROUP_500_FIELD_NUMBER = 3;
  public static final int UINT32_GROUP_500_FREQ_AVAIL_FIELD_NUMBER = 11;
  public static final int UINT32_GROUP_MINI_FIELD_NUMBER = 6;
  public static final int UINT32_GROUP_MINI_FREQ_AVAIL_FIELD_NUMBER = 14;
  public static final int UINT32_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112 }, new String[] { "uint32_uin", "str_errorinfo", "uint32_group_500", "uint32_group_1k", "uint32_group_2k", "uint32_group_mini", "uint32_created_group_500", "uint32_created_group_1k", "uint32_created_group_2k", "uint32_created_group_mini", "uint32_group_500_freq_avail", "uint32_group_1k_freq_avail", "uint32_group_2k_freq_avail", "uint32_group_mini_freq_avail" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  public final PBStringField str_errorinfo = PBField.initString("");
  public final PBUInt32Field uint32_created_group_1k = PBField.initUInt32(0);
  public final PBUInt32Field uint32_created_group_2k = PBField.initUInt32(0);
  public final PBUInt32Field uint32_created_group_500 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_created_group_mini = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_1k = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_1k_freq_avail = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_2k = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_2k_freq_avail = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_500 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_500_freq_avail = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_mini = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_mini_freq_avail = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uin = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x88c.oidb_0x88c.RspBody
 * JD-Core Version:    0.7.0.1
 */
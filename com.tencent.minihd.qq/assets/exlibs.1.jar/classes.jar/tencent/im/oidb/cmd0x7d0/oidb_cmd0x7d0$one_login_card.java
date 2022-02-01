package tencent.im.oidb.cmd0x7d0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x7d0$one_login_card
  extends MessageMicro
{
  public static final int MSG_END_DATE_FIELD_NUMBER = 6;
  public static final int MSG_START_DATE_FIELD_NUMBER = 5;
  public static final int UINT32_ID_FIELD_NUMBER = 1;
  public static final int UINT32_IS_USED_FIELD_NUMBER = 4;
  public static final int UINT32_OUT_OF_DATE_FIELD_NUMBER = 3;
  public static final int UINT32_TYPE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50 }, new String[] { "uint32_id", "uint32_type", "uint32_out_of_date", "uint32_is_used", "msg_start_date", "msg_end_date" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null }, one_login_card.class);
  public oidb_cmd0x7d0.one_date msg_end_date = new oidb_cmd0x7d0.one_date();
  public oidb_cmd0x7d0.one_date msg_start_date = new oidb_cmd0x7d0.one_date();
  public final PBUInt32Field uint32_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_used = PBField.initUInt32(0);
  public final PBUInt32Field uint32_out_of_date = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7d0.oidb_cmd0x7d0.one_login_card
 * JD-Core Version:    0.7.0.1
 */
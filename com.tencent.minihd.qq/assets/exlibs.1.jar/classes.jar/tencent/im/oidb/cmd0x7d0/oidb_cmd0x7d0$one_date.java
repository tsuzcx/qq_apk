package tencent.im.oidb.cmd0x7d0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x7d0$one_date
  extends MessageMicro
{
  public static final int UINT32_DAY_FIELD_NUMBER = 3;
  public static final int UINT32_MONTH_FIELD_NUMBER = 2;
  public static final int UINT32_YEAR_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_year", "uint32_month", "uint32_day" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, one_date.class);
  public final PBUInt32Field uint32_day = PBField.initUInt32(0);
  public final PBUInt32Field uint32_month = PBField.initUInt32(0);
  public final PBUInt32Field uint32_year = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7d0.oidb_cmd0x7d0.one_date
 * JD-Core Version:    0.7.0.1
 */
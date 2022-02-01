package tencent.im.oidb.cmd0x7c9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7c9$RspBody
  extends MessageMicro
{
  public static final int UINT32_NEXT_TIME_GAP_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_next_time_gap" }, new Object[] { Integer.valueOf(0) }, RspBody.class);
  public final PBUInt32Field uint32_next_time_gap = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7c9.cmd0x7c9.RspBody
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.oidb.cmd0x799;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x799$RspBody
  extends MessageMicro
{
  public static final int ASTLONGNICKINFOLIST_FIELD_NUMBER = 2;
  public static final int UINT32_RESULT_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "astLongNickInfoList" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
  public final PBRepeatMessageField astLongNickInfoList = PBField.initRepeatMessage(oidb_0x799.LongNickInfo.class);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x799.oidb_0x799.RspBody
 * JD-Core Version:    0.7.0.1
 */
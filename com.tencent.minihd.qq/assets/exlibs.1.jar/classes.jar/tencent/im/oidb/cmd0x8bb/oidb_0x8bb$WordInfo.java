package tencent.im.oidb.cmd0x8bb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8bb$WordInfo
  extends MessageMicro
{
  public static final int STR_KEYWORD_FIELD_NUMBER = 1;
  public static final int UINT32_UPDATE_TIME_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_keyword", "uint32_update_time" }, new Object[] { "", Integer.valueOf(0) }, WordInfo.class);
  public final PBStringField str_keyword = PBField.initString("");
  public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8bb.oidb_0x8bb.WordInfo
 * JD-Core Version:    0.7.0.1
 */
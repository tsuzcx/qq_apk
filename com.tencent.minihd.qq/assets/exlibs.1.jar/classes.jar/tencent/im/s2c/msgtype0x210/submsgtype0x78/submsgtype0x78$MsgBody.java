package tencent.im.s2c.msgtype0x210.submsgtype0x78;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0x78$MsgBody
  extends MessageMicro
{
  public static final int UINT32_TYPE_FIELD_NUMBER = 1;
  public static final int UINT32_VERSION_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_type", "uint32_version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, MsgBody.class);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x78.submsgtype0x78.MsgBody
 * JD-Core Version:    0.7.0.1
 */
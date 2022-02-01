package tencent.im.s2c.msgtype0x210.submsgtype0x31;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x31$MsgBody
  extends MessageMicro
{
  public static final int UINT32_FLAG_FIELD_NUMBER = 1;
  public static final int UINT32_TIME_FIELD_NUMBER = 4;
  public static final int UINT64_BIND_UIN_FIELD_NUMBER = 3;
  public static final int UINT64_UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 37 }, new String[] { "uint32_flag", "uint64_uin", "uint64_bind_uin", "uint32_time" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, MsgBody.class);
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBFixed32Field uint32_time = PBField.initFixed32(0);
  public final PBUInt64Field uint64_bind_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x31.submsgtype0x31.MsgBody
 * JD-Core Version:    0.7.0.1
 */
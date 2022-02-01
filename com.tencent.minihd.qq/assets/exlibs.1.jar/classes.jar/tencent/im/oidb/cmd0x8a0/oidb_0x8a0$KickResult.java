package tencent.im.oidb.cmd0x8a0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8a0$KickResult
  extends MessageMicro
{
  public static final int OPT_UINT32_RESULT_FIELD_NUMBER = 1;
  public static final int OPT_UINT64_MEMBER_UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "opt_uint32_result", "opt_uint64_member_uin" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, KickResult.class);
  public final PBUInt32Field opt_uint32_result = PBField.initUInt32(0);
  public final PBUInt64Field opt_uint64_member_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8a0.oidb_0x8a0.KickResult
 * JD-Core Version:    0.7.0.1
 */
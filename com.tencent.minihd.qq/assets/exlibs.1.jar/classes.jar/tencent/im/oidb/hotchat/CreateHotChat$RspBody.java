package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CreateHotChat$RspBody
  extends MessageMicro
{
  public static final int UINT32_GROUP_CODE_FIELD_NUMBER = 1;
  public static final int UINT32_GROUP_UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_group_code", "uint32_group_uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  public final PBUInt32Field uint32_group_code = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_uin = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.hotchat.CreateHotChat.RspBody
 * JD-Core Version:    0.7.0.1
 */
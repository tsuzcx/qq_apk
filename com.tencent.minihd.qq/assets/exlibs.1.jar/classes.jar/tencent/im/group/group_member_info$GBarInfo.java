package tencent.im.group;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class group_member_info$GBarInfo
  extends MessageMicro
{
  public static final int STR_HEAD_PORTRAIT_FIELD_NUMBER = 3;
  public static final int UINT32_GBAR_ID_FIELD_NUMBER = 1;
  public static final int UINT32_UIN_LEV_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField str_head_portrait = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_gbar_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uin_lev = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_gbar_id", "uint32_uin_lev", "str_head_portrait" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, GBarInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.group.group_member_info.GBarInfo
 * JD-Core Version:    0.7.0.1
 */
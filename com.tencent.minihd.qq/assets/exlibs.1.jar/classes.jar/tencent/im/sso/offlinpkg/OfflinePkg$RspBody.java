package tencent.im.sso.offlinpkg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class OfflinePkg$RspBody
  extends MessageMicro
{
  public static final int INT32_RET_FIELD_NUMBER = 1;
  public static final int STR_ERR_DESC_FIELD_NUMBER = 2;
  public static final int STR_EXPIRE_PKG_FIELD_NUMBER = 3;
  public static final int STR_PREDOWN_PKG_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public final PBBytesField str_err_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_expire_pkg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_predown_pkg = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "int32_ret", "str_err_desc", "str_expire_pkg", "str_predown_pkg" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.sso.offlinpkg.OfflinePkg.RspBody
 * JD-Core Version:    0.7.0.1
 */
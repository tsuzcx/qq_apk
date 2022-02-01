package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TroopTips0x857$InstInfo
  extends MessageMicro
{
  public static final int BYTES_GUID_FIELD_NUMBER = 7;
  public static final int UINT32_APPPID_FIELD_NUMBER = 1;
  public static final int UINT32_INSTID_FIELD_NUMBER = 2;
  public static final int UINT32_OPEN_APPID_FIELD_NUMBER = 4;
  public static final int UINT32_PLATFORM_FIELD_NUMBER = 3;
  public static final int UINT32_PRODUCTID_FIELD_NUMBER = 5;
  public static final int UINT32_SSO_BID_FIELD_NUMBER = 6;
  public static final int UINT32_VER_MAX_FIELD_NUMBER = 9;
  public static final int UINT32_VER_MIN_FIELD_NUMBER = 8;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_apppid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_instid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_open_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
  public final PBUInt32Field uint32_productid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sso_bid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ver_max = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ver_min = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 64, 72 }, new String[] { "uint32_apppid", "uint32_instid", "uint32_platform", "uint32_open_appid", "uint32_productid", "uint32_sso_bid", "bytes_guid", "uint32_ver_min", "uint32_ver_max" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, InstInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.InstInfo
 * JD-Core Version:    0.7.0.1
 */
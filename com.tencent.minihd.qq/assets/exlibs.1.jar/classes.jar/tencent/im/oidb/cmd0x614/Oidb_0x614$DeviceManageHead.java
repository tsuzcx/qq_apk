package tencent.im.oidb.cmd0x614;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x614$DeviceManageHead
  extends MessageMicro
{
  public static final int BYTES_APPNAME_FIELD_NUMBER = 7;
  public static final int BYTES_GUID_FIELD_NUMBER = 4;
  public static final int UINT32_APPID_FIELD_NUMBER = 5;
  public static final int UINT32_CMD_FIELD_NUMBER = 1;
  public static final int UINT32_RESULT_FIELD_NUMBER = 2;
  public static final int UINT32_SUBAPPID_FIELD_NUMBER = 6;
  public static final int UINT64_UIN_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_appname = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subappid = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58 }, new String[] { "uint32_cmd", "uint32_result", "uint64_uin", "bytes_guid", "uint32_appid", "uint32_subappid", "bytes_appname" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, DeviceManageHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x614.Oidb_0x614.DeviceManageHead
 * JD-Core Version:    0.7.0.1
 */
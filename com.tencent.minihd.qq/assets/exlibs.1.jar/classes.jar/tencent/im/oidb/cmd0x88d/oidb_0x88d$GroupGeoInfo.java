package tencent.im.oidb.cmd0x88d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x88d$GroupGeoInfo
  extends MessageMicro
{
  public static final int BYTES_GEOCONTENT_FIELD_NUMBER = 6;
  public static final int INT64_LATITUDE_FIELD_NUMBER = 5;
  public static final int INT64_LONGITUDE_FIELD_NUMBER = 4;
  public static final int UINT32_CITYID_FIELD_NUMBER = 3;
  public static final int UINT32_SETTIME_FIELD_NUMBER = 2;
  public static final int UINT64_OWNERUIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_geocontent = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt64Field int64_latitude = PBField.initInt64(0L);
  public final PBInt64Field int64_longitude = PBField.initInt64(0L);
  public final PBUInt32Field uint32_cityid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_settime = PBField.initUInt32(0);
  public final PBUInt64Field uint64_owneruin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "uint64_owneruin", "uint32_settime", "uint32_cityid", "int64_longitude", "int64_latitude", "bytes_geocontent" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, GroupGeoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo
 * JD-Core Version:    0.7.0.1
 */
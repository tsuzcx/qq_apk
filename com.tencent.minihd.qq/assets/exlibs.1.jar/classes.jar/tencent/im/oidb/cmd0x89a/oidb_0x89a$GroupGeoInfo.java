package tencent.im.oidb.cmd0x89a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x89a$GroupGeoInfo
  extends MessageMicro
{
  public static final int STRING_GEO_CONTENT_FIELD_NUMBER = 4;
  public static final int UINT32_CITY_ID_FIELD_NUMBER = 1;
  public static final int UINT64_LATITUDE_FIELD_NUMBER = 3;
  public static final int UINT64_LONGTITUDE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField string_geo_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_city_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_latitude = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_longtitude = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_city_id", "uint64_longtitude", "uint64_latitude", "string_geo_content" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, GroupGeoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x89a.oidb_0x89a.GroupGeoInfo
 * JD-Core Version:    0.7.0.1
 */
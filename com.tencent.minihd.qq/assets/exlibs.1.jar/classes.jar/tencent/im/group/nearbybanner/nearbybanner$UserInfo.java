package tencent.im.group.nearbybanner;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class nearbybanner$UserInfo
  extends MessageMicro
{
  public static final int BYTES_GEOCONTENT_FIELD_NUMBER = 3;
  public static final int INT64_LATITUDE_FIELD_NUMBER = 2;
  public static final int INT64_LONGITUDE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_geocontent = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt64Field int64_latitude = PBField.initInt64(0L);
  public final PBInt64Field int64_longitude = PBField.initInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "int64_longitude", "int64_latitude", "bytes_geocontent" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, UserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.group.nearbybanner.nearbybanner.UserInfo
 * JD-Core Version:    0.7.0.1
 */
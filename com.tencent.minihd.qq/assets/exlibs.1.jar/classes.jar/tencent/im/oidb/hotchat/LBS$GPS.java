package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class LBS$GPS
  extends MessageMicro
{
  public static final int ALTITUDE_FIELD_NUMBER = 3;
  public static final int COORDINATE_FIELD_NUMBER = 4;
  public static final int LATITUDE_FIELD_NUMBER = 1;
  public static final int LONGITUDE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "latitude", "longitude", "altitude", "coordinate" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GPS.class);
  public final PBInt32Field altitude = PBField.initInt32(0);
  public final PBEnumField coordinate = PBField.initEnum(0);
  public final PBInt32Field latitude = PBField.initInt32(0);
  public final PBInt32Field longitude = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.hotchat.LBS.GPS
 * JD-Core Version:    0.7.0.1
 */
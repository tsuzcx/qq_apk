package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PackServer$QueryPackListReq
  extends MessageMicro
{
  public static final int COUNT_FIELD_NUMBER = 2;
  public static final int FROM_INDEX_FIELD_NUMBER = 1;
  public static final int TYPE_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "from_index", "count", "type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, QueryPackListReq.class);
  public final PBInt32Field count = PBField.initInt32(0);
  public final PBUInt32Field from_index = PBField.initUInt32(0);
  public final PBInt32Field type = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.new_year_2014.PackServer.QueryPackListReq
 * JD-Core Version:    0.7.0.1
 */
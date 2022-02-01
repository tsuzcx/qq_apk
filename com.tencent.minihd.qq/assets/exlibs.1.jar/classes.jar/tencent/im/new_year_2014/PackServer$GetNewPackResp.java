package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PackServer$GetNewPackResp
  extends MessageMicro
{
  public static final int DATA_FIELD_NUMBER = 3;
  public static final int EMPTY_URL_FIELD_NUMBER = 4;
  public static final int PROMOTION_ID_FIELD_NUMBER = 1;
  public static final int SEQ_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "promotion_id", "seq", "data", "empty_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, "" }, GetNewPackResp.class);
  public PackData.Pack data = new PackData.Pack();
  public final PBStringField empty_url = PBField.initString("");
  public final PBUInt32Field promotion_id = PBField.initUInt32(0);
  public final PBUInt32Field seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.new_year_2014.PackServer.GetNewPackResp
 * JD-Core Version:    0.7.0.1
 */
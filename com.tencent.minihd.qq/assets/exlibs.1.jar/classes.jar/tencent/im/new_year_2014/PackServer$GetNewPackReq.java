package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PackServer$GetNewPackReq
  extends MessageMicro
{
  public static final int BUSINESS_FIELD_NUMBER = 20;
  public static final int GROUP_ID_FIELD_NUMBER = 4;
  public static final int GROUP_TYPE_FIELD_NUMBER = 5;
  public static final int PROMOTION_ID_FIELD_NUMBER = 1;
  public static final int SEQ_FIELD_NUMBER = 2;
  public static final int SIGNATURE_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field business = PBField.initUInt32(0);
  public final PBUInt32Field group_id = PBField.initUInt32(0);
  public final PBUInt32Field group_type = PBField.initUInt32(0);
  public final PBUInt32Field promotion_id = PBField.initUInt32(0);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public final PBBytesField signature = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 160 }, new String[] { "promotion_id", "seq", "signature", "group_id", "group_type", "business" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetNewPackReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.new_year_2014.PackServer.GetNewPackReq
 * JD-Core Version:    0.7.0.1
 */
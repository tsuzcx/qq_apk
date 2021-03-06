package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class PackServer$SetPackUsedReq
  extends MessageMicro
{
  public static final int EXTERNAL_FIELD_NUMBER = 2;
  public static final int PACK_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField external = PBField.initBool(false);
  public final PBBytesField pack_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "pack_id", "external" }, new Object[] { localByteStringMicro, Boolean.valueOf(false) }, SetPackUsedReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.new_year_2014.PackServer.SetPackUsedReq
 * JD-Core Version:    0.7.0.1
 */
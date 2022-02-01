package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Unisso$UniSsoServerRspComm
  extends MessageMicro
{
  public static final int DELAYMS_FIELD_NUMBER = 1;
  public static final int PACKAGESIZE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "delayms", "packagesize" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, UniSsoServerRspComm.class);
  public final PBUInt32Field delayms = PBField.initUInt32(0);
  public final PBUInt32Field packagesize = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.new_year_2014.Unisso.UniSsoServerRspComm
 * JD-Core Version:    0.7.0.1
 */
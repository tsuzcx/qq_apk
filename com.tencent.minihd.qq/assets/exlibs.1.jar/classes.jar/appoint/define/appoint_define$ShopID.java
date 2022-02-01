package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appoint_define$ShopID
  extends MessageMicro
{
  public static final int STR_SHOPID_FIELD_NUMBER = 1;
  public static final int UINT32_SP_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_shopid", "uint32_sp" }, new Object[] { "", Integer.valueOf(0) }, ShopID.class);
  public final PBStringField str_shopid = PBField.initString("");
  public final PBUInt32Field uint32_sp = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     appoint.define.appoint_define.ShopID
 * JD-Core Version:    0.7.0.1
 */
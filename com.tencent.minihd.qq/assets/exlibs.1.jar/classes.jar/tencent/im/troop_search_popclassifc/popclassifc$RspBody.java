package tencent.im.troop_search_popclassifc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class popclassifc$RspBody
  extends MessageMicro
{
  public static final int BANNER_CARD_FIELD_NUMBER = 1;
  public static final int POP_CARD_FIELD_NUMBER = 2;
  public static final int STR_CITY_ID_FIELD_NUMBER = 5;
  public static final int UINT32_LATITUDE_FIELD_NUMBER = 3;
  public static final int UINT32_LONGITUDE_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "banner_card", "pop_card", "uint32_latitude", "uint32_longitude", "str_city_id" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), "" }, RspBody.class);
  public popclassifc.BannerCard banner_card = new popclassifc.BannerCard();
  public popclassifc.PopCard pop_card = new popclassifc.PopCard();
  public final PBStringField str_city_id = PBField.initString("");
  public final PBUInt32Field uint32_latitude = PBField.initUInt32(0);
  public final PBUInt32Field uint32_longitude = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.troop_search_popclassifc.popclassifc.RspBody
 * JD-Core Version:    0.7.0.1
 */
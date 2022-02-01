package tencent.im.troop_search_popclassifc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class popclassifc$PopItem
  extends MessageMicro
{
  public static final int STR_DESC_FIELD_NUMBER = 1;
  public static final int STR_ICON_URL_FIELD_NUMBER = 2;
  public static final int STR_TRANSFER_URL_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_desc", "str_icon_url", "str_transfer_url" }, new Object[] { "", "", "" }, PopItem.class);
  public final PBStringField str_desc = PBField.initString("");
  public final PBStringField str_icon_url = PBField.initString("");
  public final PBStringField str_transfer_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.troop_search_popclassifc.popclassifc.PopItem
 * JD-Core Version:    0.7.0.1
 */
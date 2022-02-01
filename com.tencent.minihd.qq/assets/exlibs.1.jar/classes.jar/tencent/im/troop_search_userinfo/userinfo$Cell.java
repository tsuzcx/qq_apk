package tencent.im.troop_search_userinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class userinfo$Cell
  extends MessageMicro
{
  public static final int INT32_RSSI_FIELD_NUMBER = 5;
  public static final int UINT32_CELLID_FIELD_NUMBER = 4;
  public static final int UINT32_LAC_FIELD_NUMBER = 3;
  public static final int UINT32_MCC_FIELD_NUMBER = 1;
  public static final int UINT32_MNC_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint32_mcc", "uint32_mnc", "uint32_lac", "uint32_cellid", "int32_rssi" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Cell.class);
  public final PBInt32Field int32_rssi = PBField.initInt32(0);
  public final PBUInt32Field uint32_cellid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lac = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mcc = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mnc = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.troop_search_userinfo.userinfo.Cell
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class LBS$LBSInfo
  extends MessageMicro
{
  public static final int ATTRIBUTE_FIELD_NUMBER = 4;
  public static final int GPS_FIELD_NUMBER = 1;
  public static final int RPT_CELL_FIELD_NUMBER = 3;
  public static final int RPT_WIFI_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "gps", "rpt_wifi", "rpt_cell", "attribute" }, new Object[] { null, null, null, null }, LBSInfo.class);
  public LBS.Attribute attribute = new LBS.Attribute();
  public LBS.GPS gps = new LBS.GPS();
  public final PBRepeatMessageField rpt_cell = PBField.initRepeatMessage(LBS.Cell.class);
  public final PBRepeatMessageField rpt_wifi = PBField.initRepeatMessage(LBS.Wifi.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.hotchat.LBS.LBSInfo
 * JD-Core Version:    0.7.0.1
 */
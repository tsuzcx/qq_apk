package oicq.wlogin_sdk.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class sec_trans
{
  public static final class SecTransInfo
    extends MessageMicro<SecTransInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 58 }, new String[] { "str_phone_brand", "str_model_type", "str_wifi_mac", "str_bssid", "str_os_language", "uint32_qq_language", "str_gps_location" }, new Object[] { "", "", "", "", "", Integer.valueOf(0), "" }, SecTransInfo.class);
    public final PBStringField str_bssid = PBField.initString("");
    public final PBStringField str_gps_location = PBField.initString("");
    public final PBStringField str_model_type = PBField.initString("");
    public final PBStringField str_os_language = PBField.initString("");
    public final PBStringField str_phone_brand = PBField.initString("");
    public final PBStringField str_wifi_mac = PBField.initString("");
    public final PBUInt32Field uint32_qq_language = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.pb.sec_trans
 * JD-Core Version:    0.7.0.1
 */
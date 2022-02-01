package msf.msgcomm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_comm$PluginInfo
  extends MessageMicro
{
  public static final int LAN_TYPE_FIELD_NUMBER = 5;
  public static final int NEW_VER_FIELD_NUMBER = 3;
  public static final int PKG_NAME_FIELD_NUMBER = 2;
  public static final int PRIORITY_FIELD_NUMBER = 6;
  public static final int RES_CONF_FIELD_NUMBER = 11;
  public static final int RES_DESC_FIELD_NUMBER = 8;
  public static final int RES_ID_FIELD_NUMBER = 1;
  public static final int RES_NAME_FIELD_NUMBER = 7;
  public static final int RES_TYPE_FIELD_NUMBER = 4;
  public static final int RES_URL_BIG_FIELD_NUMBER = 9;
  public static final int RES_URL_SMALL_FIELD_NUMBER = 10;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 58, 66, 74, 82, 90 }, new String[] { "res_id", "pkg_name", "new_ver", "res_type", "lan_type", "priority", "res_name", "res_desc", "res_url_big", "res_url_small", "res_conf" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "" }, PluginInfo.class);
  public final PBUInt32Field lan_type = PBField.initUInt32(0);
  public final PBUInt32Field new_ver = PBField.initUInt32(0);
  public final PBStringField pkg_name = PBField.initString("");
  public final PBUInt32Field priority = PBField.initUInt32(0);
  public final PBStringField res_conf = PBField.initString("");
  public final PBStringField res_desc = PBField.initString("");
  public final PBUInt32Field res_id = PBField.initUInt32(0);
  public final PBStringField res_name = PBField.initString("");
  public final PBUInt32Field res_type = PBField.initUInt32(0);
  public final PBStringField res_url_big = PBField.initString("");
  public final PBStringField res_url_small = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     msf.msgcomm.msg_comm.PluginInfo
 * JD-Core Version:    0.7.0.1
 */
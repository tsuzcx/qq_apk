package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GetHotChatList$ReqBody
  extends MessageMicro
{
  public static final int GET_POI_GROUP_FIELD_NUMBER = 2;
  public static final int GET_WIFI_GROUP_FIELD_NUMBER = 1;
  public static final int JOINED_WIFI_FIELD_NUMBER = 3;
  public static final int LBS_INFO_FIELD_NUMBER = 4;
  public static final int UINT32_MSG_TAB_SWITCH_OFF_ALL_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "get_wifi_group", "get_poi_group", "joined_wifi", "lbs_info", "uint32_msg_tab_switch_off_all" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt32Field get_poi_group = PBField.initUInt32(0);
  public final PBUInt32Field get_wifi_group = PBField.initUInt32(0);
  public LBS.Wifi joined_wifi = new LBS.Wifi();
  public LBS.LBSInfo lbs_info = new LBS.LBSInfo();
  public final PBUInt32Field uint32_msg_tab_switch_off_all = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.hotchat.GetHotChatList.ReqBody
 * JD-Core Version:    0.7.0.1
 */
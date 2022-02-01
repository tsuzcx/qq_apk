package tencent.im.oidb.cmd0x5e0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x5e0$ContentItem
  extends MessageMicro
{
  public static final int MSG_FRIENDREMARK_FIELD_NUMBER = 4;
  public static final int MSG_FRIEND_TEAMLIST_FIELD_NUMBER = 7;
  public static final int MSG_GENDERFILED_FIELD_NUMBER = 3;
  public static final int MSG_GENERAL_BUFFER_FIELD_NUMBER = 9;
  public static final int MSG_GROUPNAME_FIELD_NUMBER = 6;
  public static final int MSG_LONGNICK_FIELD_NUMBER = 5;
  public static final int MSG_NICKNAMEFILED_FIELD_NUMBER = 2;
  public static final int MSG_VALUE_BIT_FIELD_NUMBER = 8;
  public static final int UINT32_UPDATE_PROFILE_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74 }, new String[] { "uint32_update_profile_id", "msg_nicknamefiled", "msg_genderfiled", "msg_friendremark", "msg_longnick", "msg_groupname", "msg_friend_teamlist", "msg_value_bit", "msg_general_buffer" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, null, null }, ContentItem.class);
  public Oidb_0x5e0.FriendTeamList msg_friend_teamlist = new Oidb_0x5e0.FriendTeamList();
  public Oidb_0x5e0.FriendRemark msg_friendremark = new Oidb_0x5e0.FriendRemark();
  public Oidb_0x5e0.GenderFiled msg_genderfiled = new Oidb_0x5e0.GenderFiled();
  public Oidb_0x5e0.GeneralBuffer msg_general_buffer = new Oidb_0x5e0.GeneralBuffer();
  public Oidb_0x5e0.GroupName msg_groupname = new Oidb_0x5e0.GroupName();
  public Oidb_0x5e0.LongNick msg_longnick = new Oidb_0x5e0.LongNick();
  public Oidb_0x5e0.NickNameFiled msg_nicknamefiled = new Oidb_0x5e0.NickNameFiled();
  public Oidb_0x5e0.ValueBit msg_value_bit = new Oidb_0x5e0.ValueBit();
  public final PBUInt32Field uint32_update_profile_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ContentItem
 * JD-Core Version:    0.7.0.1
 */
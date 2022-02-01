package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x27$ForwardBody
  extends MessageMicro
{
  public static final int MSG_ADD_GROUP_FIELD_NUMBER = 3;
  public static final int MSG_APPOINTMENT_NOTIFY_FIELD_NUMBER = 23;
  public static final int MSG_BIN_PKG_FIELD_NUMBER = 19;
  public static final int MSG_CONF_MSG_ROAM_FLAG_FIELD_NUMBER = 17;
  public static final int MSG_DAREN_NOTIFY_FIELD_NUMBER = 25;
  public static final int MSG_DEL_FRIEND_FIELD_NUMBER = 14;
  public static final int MSG_DEL_GROUP_FIELD_NUMBER = 4;
  public static final int MSG_FANPANZI_NOTIFY_FIELD_NUMBER = 2000;
  public static final int MSG_GRP_MSG_ROAM_FLAG_FIELD_NUMBER = 16;
  public static final int MSG_MOD_CONF_PROFILE_FIELD_NUMBER = 21;
  public static final int MSG_MOD_CUSTOM_FACE_FIELD_NUMBER = 11;
  public static final int MSG_MOD_FRD_FIELD_NUMBER = 1000;
  public static final int MSG_MOD_FRIEND_FLAG_FIELD_NUMBER = 22;
  public static final int MSG_MOD_FRIEND_GROUP_FIELD_NUMBER = 7;
  public static final int MSG_MOD_FRIEND_REMARK_FIELD_NUMBER = 9;
  public static final int MSG_MOD_FRIEND_RINGS_FIELD_NUMBER = 20;
  public static final int MSG_MOD_GROUP_MEMBER_PROFILE_FIELD_NUMBER = 13;
  public static final int MSG_MOD_GROUP_NAME_FIELD_NUMBER = 5;
  public static final int MSG_MOD_GROUP_PROFILE_FIELD_NUMBER = 12;
  public static final int MSG_MOD_GROUP_SORT_FIELD_NUMBER = 6;
  public static final int MSG_MOD_LONG_NICK_FIELD_NUMBER = 10;
  public static final int MSG_MOD_PROFILE_FIELD_NUMBER = 8;
  public static final int MSG_MOD_RICH_LONG_NICK_FIELD_NUMBER = 18;
  public static final int MSG_NEW_COMEIN_USER_NOTIFY_FIELD_NUMBER = 26;
  public static final int MSG_NEW_FRD_FIELD_NUMBER = 1001;
  public static final int MSG_RECOMMEND_FRD_DATA_FIELD_NUMBER = 1002;
  public static final int MSG_ROAM_PRIV_FIELD_NUMBER = 15;
  public static final int UINT32_NOTIFY_TYPE_FIELD_NUMBER = 1;
  public static final int UINT32_OP_TYPE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178, 186, 202, 210, 8002, 8010, 8018, 16002 }, new String[] { "uint32_notify_type", "uint32_op_type", "msg_add_group", "msg_del_group", "msg_mod_group_name", "msg_mod_group_sort", "msg_mod_friend_group", "msg_mod_profile", "msg_mod_friend_remark", "msg_mod_long_nick", "msg_mod_custom_face", "msg_mod_group_profile", "msg_mod_group_member_profile", "msg_del_friend", "msg_roam_priv", "msg_grp_msg_roam_flag", "msg_conf_msg_roam_flag", "msg_mod_rich_long_nick", "msg_bin_pkg", "msg_mod_friend_rings", "msg_mod_conf_profile", "msg_mod_friend_flag", "msg_appointment_notify", "msg_daren_notify", "msg_new_comein_user_notify", "msg_mod_frd", "msg_new_frd", "msg_recommend_frd_data", "msg_fanpanzi_notify" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, ForwardBody.class);
  public SubMsgType0x27.AddGroup msg_add_group = new SubMsgType0x27.AddGroup();
  public SubMsgType0x27.AppointmentNotify msg_appointment_notify = new SubMsgType0x27.AppointmentNotify();
  public SubMsgType0x27.BinaryMsg msg_bin_pkg = new SubMsgType0x27.BinaryMsg();
  public SubMsgType0x27.ConfMsgRoamFlag msg_conf_msg_roam_flag = new SubMsgType0x27.ConfMsgRoamFlag();
  public SubMsgType0x27.DaRenNotify msg_daren_notify = new SubMsgType0x27.DaRenNotify();
  public SubMsgType0x27.DelFriend msg_del_friend = new SubMsgType0x27.DelFriend();
  public SubMsgType0x27.DelGroup msg_del_group = new SubMsgType0x27.DelGroup();
  public SubMsgType0x27.FanpaiziNotify msg_fanpanzi_notify = new SubMsgType0x27.FanpaiziNotify();
  public SubMsgType0x27.GrpMsgRoamFlag msg_grp_msg_roam_flag = new SubMsgType0x27.GrpMsgRoamFlag();
  public SubMsgType0x27.ModConfProfile msg_mod_conf_profile = new SubMsgType0x27.ModConfProfile();
  public SubMsgType0x27.ModCustomFace msg_mod_custom_face = new SubMsgType0x27.ModCustomFace();
  public SubMsgType0x27.ModFrd msg_mod_frd = new SubMsgType0x27.ModFrd();
  public SubMsgType0x27.SnsUpdateFlag msg_mod_friend_flag = new SubMsgType0x27.SnsUpdateFlag();
  public SubMsgType0x27.ModFriendGroup msg_mod_friend_group = new SubMsgType0x27.ModFriendGroup();
  public SubMsgType0x27.ModFriendRemark msg_mod_friend_remark = new SubMsgType0x27.ModFriendRemark();
  public SubMsgType0x27.ModSnsGeneralInfo msg_mod_friend_rings = new SubMsgType0x27.ModSnsGeneralInfo();
  public SubMsgType0x27.ModGroupMemberProfile msg_mod_group_member_profile = new SubMsgType0x27.ModGroupMemberProfile();
  public SubMsgType0x27.ModGroupName msg_mod_group_name = new SubMsgType0x27.ModGroupName();
  public SubMsgType0x27.ModGroupProfile msg_mod_group_profile = new SubMsgType0x27.ModGroupProfile();
  public SubMsgType0x27.ModGroupSort msg_mod_group_sort = new SubMsgType0x27.ModGroupSort();
  public SubMsgType0x27.ModLongNick msg_mod_long_nick = new SubMsgType0x27.ModLongNick();
  public SubMsgType0x27.ModProfile msg_mod_profile = new SubMsgType0x27.ModProfile();
  public SubMsgType0x27.ModLongNick msg_mod_rich_long_nick = new SubMsgType0x27.ModLongNick();
  public SubMsgType0x27.NewComeinUserNotify msg_new_comein_user_notify = new SubMsgType0x27.NewComeinUserNotify();
  public SubMsgType0x27.NewFrd msg_new_frd = new SubMsgType0x27.NewFrd();
  public SubMsgType0x27.RecommendFrdData msg_recommend_frd_data = new SubMsgType0x27.RecommendFrdData();
  public SubMsgType0x27.ModFrdRoamPriv msg_roam_priv = new SubMsgType0x27.ModFrdRoamPriv();
  public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ForwardBody
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.s2c.msgtype0x210.submsgtype0x44;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class submsgtype0x44$MsgBody
  extends MessageMicro
{
  public static final int MSG_CLEAN_COUNT_MSG_FIELD_NUMBER = 3;
  public static final int MSG_FRIEND_MSG_SYNC_FIELD_NUMBER = 1;
  public static final int MSG_GROUP_MSG_SYNC_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_friend_msg_sync", "msg_group_msg_sync", "msg_clean_count_msg" }, new Object[] { null, null, null }, MsgBody.class);
  public static final MsgBody __repeatHelper__ = new MsgBody();
  public submsgtype0x44.ClearCountMsg msg_clean_count_msg = new submsgtype0x44.ClearCountMsg();
  public submsgtype0x44.FriendSyncMsg msg_friend_msg_sync = new submsgtype0x44.FriendSyncMsg();
  public submsgtype0x44.GroupSyncMsg msg_group_msg_sync = new submsgtype0x44.GroupSyncMsg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.MsgBody
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.s2c.msgtype0x210.submsgtype0x26;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum
  extends MessageMicro
{
  public static final int MSG_APP_ID_FIELD_NUMBER = 1;
  public static final int MSG_APP_TIP_NOTIFY_FIELD_NUMBER = 4;
  public static final int SINT32_ALBUM_CNT_FIELD_NUMBER = 5;
  public static final int SINT32_UNREAD_NUM_FIELD_NUMBER = 3;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40 }, new String[] { "msg_app_id", "uint64_group_code", "sint32_unread_num", "msg_app_tip_notify", "sint32_album_cnt" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0) }, SubCmd0x1UpdateAppUnreadNum.class);
  public submsgtype0x26.AppID msg_app_id = new submsgtype0x26.AppID();
  public submsgtype0x26.AppTipNotify msg_app_tip_notify = new submsgtype0x26.AppTipNotify();
  public final PBSInt32Field sint32_album_cnt = PBField.initSInt32(0);
  public final PBSInt32Field sint32_unread_num = PBField.initSInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum
 * JD-Core Version:    0.7.0.1
 */
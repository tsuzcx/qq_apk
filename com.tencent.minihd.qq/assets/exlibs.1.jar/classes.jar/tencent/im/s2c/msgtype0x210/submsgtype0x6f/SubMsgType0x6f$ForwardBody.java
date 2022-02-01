package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x6f$ForwardBody
  extends MessageMicro
{
  public static final int MSG_FANPANZI_NOTIFY_FIELD_NUMBER = 2000;
  public static final int MSG_MCARD_NOTIFICATION_LIKE_FIELD_NUMBER = 2001;
  public static final int UINT32_NOTIFY_TYPE_FIELD_NUMBER = 1;
  public static final int UINT32_OP_TYPE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 16002, 16010 }, new String[] { "uint32_notify_type", "uint32_op_type", "msg_fanpanzi_notify", "msg_mcard_notification_like" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null }, ForwardBody.class);
  public SubMsgType0x6f.FanpaiziNotify msg_fanpanzi_notify = new SubMsgType0x6f.FanpaiziNotify();
  public SubMsgType0x6f.MCardNotificationLike msg_mcard_notification_like = new SubMsgType0x6f.MCardNotificationLike();
  public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.ForwardBody
 * JD-Core Version:    0.7.0.1
 */
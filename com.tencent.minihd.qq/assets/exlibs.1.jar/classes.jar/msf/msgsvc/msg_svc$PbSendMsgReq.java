package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.ContentHead;
import tencent.im.msg.im_msg_body.MsgBody;

public final class msg_svc$PbSendMsgReq
  extends MessageMicro
{
  public static final int APP_SHARE_FIELD_NUMBER = 7;
  public static final int CONTENT_HEAD_FIELD_NUMBER = 2;
  public static final int MSG_BODY_FIELD_NUMBER = 3;
  public static final int MSG_RAND_FIELD_NUMBER = 5;
  public static final int MSG_SEQ_FIELD_NUMBER = 4;
  public static final int MSG_VIA_FIELD_NUMBER = 8;
  public static final int ROUTING_HEAD_FIELD_NUMBER = 1;
  public static final int SYNC_COOKIE_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__;
  public msg_comm.AppShareInfo app_share = new msg_comm.AppShareInfo();
  public msg_comm.ContentHead content_head = new msg_comm.ContentHead();
  public im_msg_body.MsgBody msg_body = new im_msg_body.MsgBody();
  public final PBUInt32Field msg_rand = PBField.initUInt32(0);
  public final PBUInt32Field msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field msg_via = PBField.initUInt32(0);
  public msg_svc.RoutingHead routing_head = new msg_svc.RoutingHead();
  public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50, 58, 64 }, new String[] { "routing_head", "content_head", "msg_body", "msg_seq", "msg_rand", "sync_cookie", "app_share", "msg_via" }, new Object[] { null, null, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null, Integer.valueOf(0) }, PbSendMsgReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbSendMsgReq
 * JD-Core Version:    0.7.0.1
 */
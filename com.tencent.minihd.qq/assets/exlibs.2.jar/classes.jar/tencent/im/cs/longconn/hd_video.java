package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hd_video
{
  public static final class CmdPSTNCallbackNotifyAccept
    extends MessageMicro<CmdPSTNCallbackNotifyAccept>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_call_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_accept_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_call_id", "uint32_accept_time" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, CmdPSTNCallbackNotifyAccept.class);
    }
  }
  
  public static final class CmdPSTNCallbackNotifyLogout
    extends MessageMicro<CmdPSTNCallbackNotifyLogout>
  {
    public static final int STATUS_DST_NO_ANSWER = 3;
    public static final int STATUS_DST_NO_CONNECT = 5;
    public static final int STATUS_NORMAL = 1;
    public static final int STATUS_SRC_NO_ANSWER = 2;
    public static final int STATUS_SRC_NO_CONNECT = 4;
    public static final int STATUS_UNKNOWN = 0;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_call_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_call_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_call_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_call_id", "uint32_call_time", "uint32_call_status" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, CmdPSTNCallbackNotifyLogout.class);
    }
  }
  
  public static final class CmdS2CInviteReqBody
    extends MessageMicro<CmdS2CInviteReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_chat_with_anyone = PBField.initBool(false);
    public final PBBoolField bool_terminal_switch_flag = PBField.initBool(false);
    public final PBBytesField bytes_ext_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_from_display_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sign = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_business_type = PBField.initEnum(1);
    public final PBEnumField enum_termtype = PBField.initEnum(1);
    public final PBFixed32Field fixed32_client_seq = PBField.initFixed32(0);
    public final PBFixed32Field fixed32_timestamp = PBField.initFixed32(0);
    public hd_video_comm.CryptInfo msg_crypt_info = new hd_video_comm.CryptInfo();
    public hd_video_comm.PstnAudioProto msg_local_audio_proto = new hd_video_comm.PstnAudioProto();
    public hd_video.LoginSig msg_login_sig = new hd_video.LoginSig();
    public hd_video_comm.NetAddr msg_punch_addr = new hd_video_comm.NetAddr();
    public hd_video.InviteTempSessionData msg_temp_session = new hd_video.InviteTempSessionData();
    public final PBRepeatMessageField<hd_video_comm.ExtContent> rpt_msg_ext_contents = PBField.initRepeatMessage(hd_video_comm.ExtContent.class);
    public final PBRepeatMessageField<hd_video_comm.NetAddr> rpt_msg_interface_list = PBField.initRepeatMessage(hd_video_comm.NetAddr.class);
    public final PBRepeatMessageField<hd_video_comm.SipServerInfo> rpt_msg_sip_server_list = PBField.initRepeatMessage(hd_video_comm.SipServerInfo.class);
    public final PBRepeatField<Long> rpt_uint64_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBStringField str_interesting_chat_buf = PBField.initString("");
    public final PBStringField str_ticket = PBField.initString("");
    public final PBUInt32Field uint32_business_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_ver = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ext_content_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_from_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_from_binded_id_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_from_instance_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_from_network_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_new_business_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_punch_key = PBField.initUInt32(0);
    public final PBUInt32Field uint32_to_network_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_business_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_dial_no = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_from_binded_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_old_room_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 53, 61, 64, 72, 80, 90, 98, 104, 114, 120, 128, 136, 144, 154, 160, 168, 176, 186, 194, 200, 208, 216, 224, 234, 242, 250, 256, 266, 274, 280 }, new String[] { "bytes_sign", "rpt_msg_interface_list", "enum_business_type", "uint64_business_id", "uint32_business_flag", "fixed32_client_seq", "fixed32_timestamp", "rpt_uint64_uin_list", "uint64_from_uin", "uint64_dial_no", "str_ticket", "msg_punch_addr", "uint32_punch_key", "msg_temp_session", "enum_termtype", "uint32_client_ver", "uint32_new_business_flag", "uint32_from_app_id", "msg_login_sig", "bool_terminal_switch_flag", "uint64_old_room_id", "bool_chat_with_anyone", "str_interesting_chat_buf", "rpt_msg_sip_server_list", "uint64_from_binded_id", "uint32_from_binded_id_type", "uint32_from_network_type", "uint32_to_network_type", "msg_local_audio_proto", "bytes_from_display_name", "msg_crypt_info", "uint32_ext_content_type", "bytes_ext_content", "rpt_msg_ext_contents", "uint32_from_instance_id" }, new Object[] { localByteStringMicro1, null, Integer.valueOf(1), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", null, Integer.valueOf(0), null, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Boolean.valueOf(false), Long.valueOf(0L), Boolean.valueOf(false), "", null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro2, null, Integer.valueOf(0), localByteStringMicro3, null, Integer.valueOf(0) }, CmdS2CInviteReqBody.class);
    }
  }
  
  public static final class InviteTempSessionData
    extends MessageMicro<InviteTempSessionData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_relationship = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_relationship_ext = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_relationship_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "uint64_uin", "uint64_group_uin", "bytes_relationship", "uint32_relationship_type", "bytes_relationship_ext" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, InviteTempSessionData.class);
    }
  }
  
  public static final class LoginSig
    extends MessageMicro<LoginSig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_type", "bytes_sig" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, LoginSig.class);
    }
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 82, 90 }, new String[] { "msg_video_head", "msg_invite_body", "msg_pstn_callback_notify_accept", "msg_pstn_callback_notify_logout" }, new Object[] { null, null, null, null }, MsgBody.class);
    public hd_video.CmdS2CInviteReqBody msg_invite_body = new hd_video.CmdS2CInviteReqBody();
    public hd_video.CmdPSTNCallbackNotifyAccept msg_pstn_callback_notify_accept = new hd_video.CmdPSTNCallbackNotifyAccept();
    public hd_video.CmdPSTNCallbackNotifyLogout msg_pstn_callback_notify_logout = new hd_video.CmdPSTNCallbackNotifyLogout();
    public hd_video.VideoHead msg_video_head = new hd_video.VideoHead();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_video_head" }, new Object[] { null }, RspBody.class);
    public hd_video.VideoHead msg_video_head = new hd_video.VideoHead();
  }
  
  public static final class VideoHead
    extends MessageMicro<VideoHead>
  {
    public static final int CMD_S2C_PSTN_CALLBACK_NOTIFY_ACCEPT_REQ = 22;
    public static final int CMD_S2C_PSTN_CALLBACK_NOTIFY_LOGOUT_REQ = 23;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 66, 106, 176 }, new String[] { "uint64_room_id", "uint64_uin", "uint32_seq", "enum_body_type", "uint32_error_no", "str_from_nation", "str_from_mobile", "str_to_mobile", "str_to_nation", "int32_sub_service_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(22), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0) }, VideoHead.class);
    public final PBEnumField enum_body_type = PBField.initEnum(22);
    public final PBInt32Field int32_sub_service_type = PBField.initInt32(0);
    public final PBStringField str_from_mobile = PBField.initString("");
    public final PBStringField str_from_nation = PBField.initString("");
    public final PBStringField str_to_mobile = PBField.initString("");
    public final PBStringField str_to_nation = PBField.initString("");
    public final PBUInt32Field uint32_error_no = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt64Field uint64_room_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     tencent.im.cs.longconn.hd_video
 * JD-Core Version:    0.7.0.1
 */
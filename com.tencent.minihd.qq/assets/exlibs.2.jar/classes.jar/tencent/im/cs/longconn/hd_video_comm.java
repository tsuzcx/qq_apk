package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hd_video_comm
{
  public static final int BT_CALLBACK = 4;
  public static final int BT_CC = 6;
  public static final int BT_DISCUSS = 2;
  public static final int BT_GROUP = 3;
  public static final int BT_NORMAL = 1;
  public static final int BT_TTS = 5;
  public static final int CRT_AES = 1;
  public static final int CRT_LCG = 3;
  public static final int CRT_LCG32 = 4;
  public static final int CRT_TEA = 2;
  public static final int CT_LAN_UDP = 3;
  public static final int CT_SERVER_TCP = 2;
  public static final int CT_SERVER_UDP = 1;
  public static final int CT_WAN_UDP = 4;
  public static final int EXT_CONTENT_TYPE_DISPATH_C2B_APPID = 101;
  public static final int EXT_CONTENT_TYPE_DISPATH_OPEN_SDK_APPID = 102;
  public static final int EXT_CONTENT_TYPE_GETAWAY_C2B_APPID = 202;
  public static final int EXT_CONTENT_TYPE_GETAWAY_C2B_OPENID = 201;
  public static final int EXT_CONTENT_TYPE_GETAWAY_C2B_OPENKEYS = 203;
  public static final int EXT_CONTENT_TYPE_QIDIAN_MAIN_NUMBER = 206;
  public static final int IDC_TYPE_AWS_CLOUD = 20;
  public static final int IDC_TYPE_DC = 100;
  public static final int IDC_TYPE_SOFTLAYER_CLOUD = 21;
  public static final int IDC_TYPE_TEG_D2D_SDH = 3;
  public static final int IDC_TYPE_TEG_D2F_SDH = 1;
  public static final int IDC_TYPE_TEG_OVERSEA = 2;
  public static final int IDC_TYPE_TX_CLOUD = 10;
  public static final int IDC_TYPE_TX_CLOUD_GBN = 11;
  public static final int IDC_TYPE_UNKNOWN = 0;
  public static final int IDC_TYPE_ZENLAYER_CLOUD = 22;
  public static final int IP_SPEED_CLIENT_TYPE_MB = 2;
  public static final int IP_SPEED_CLIENT_TYPE_PC = 1;
  public static final int IP_SPEED_CLIENT_TYPE_UNKNOWN = 0;
  public static final int IP_SPEED_RESULT_TYPE_AREA = 2;
  public static final int IP_SPEED_RESULT_TYPE_IP = 1;
  public static final int IP_SPEED_RESULT_TYPE_UNKNOWN = 0;
  public static final int IP_SPEED_TYPE_HIGH_SPEED = 2;
  public static final int IP_SPEED_TYPE_NORMAL = 1;
  public static final int IP_SPEED_TYPE_UNKNOWN = 0;
  public static final int NT_2G = 4;
  public static final int NT_3G = 3;
  public static final int NT_4G = 5;
  public static final int NT_LINE = 1;
  public static final int NT_OTHER = 100;
  public static final int NT_WIFI = 2;
  public static final int PT_CALLBACK_CENTER = 3;
  public static final int PT_DIRECT_TOB = 4;
  public static final int PT_DISCUSS = 2;
  public static final int PT_PEER2PEER = 1;
  public static final int PT_UNKNOWN = 0;
  public static final int SRTP_AEAD_AES_128_GCM_8 = 3;
  public static final int SRTP_AEAD_AES_256_GCM_8 = 2;
  public static final int SRTP_AES_CM_128_HMAC_SHA1_32 = 1;
  public static final int SRTP_AES_CM_128_HMAC_SHA1_80 = 0;
  public static final int SRTP_AES_CM_128_NULL_AUTH = 8;
  public static final int SRTP_AES_CM_192_HMAC_SHA1_32 = 7;
  public static final int SRTP_AES_CM_192_HMAC_SHA1_80 = 5;
  public static final int SRTP_AES_CM_256_HMAC_SHA1_32 = 6;
  public static final int SRTP_AES_CM_256_HMAC_SHA1_80 = 4;
  public static final int SRTP_METHOD_NUM = 9;
  public static final int S_CLOSE = 2;
  public static final int S_OPEN = 1;
  public static final int TT_ANDRIOD = 4;
  public static final int TT_ANDROID_PAD = 8;
  public static final int TT_IPAD = 3;
  public static final int TT_IPHONE = 2;
  public static final int TT_MAC = 12;
  public static final int TT_MOBILE = 1;
  public static final int TT_PC = 5;
  public static final int TT_SMART_CAMERA = 10;
  public static final int TT_SMART_TV = 11;
  public static final int TT_SMART_VOICE_BOX = 13;
  public static final int TT_VOIP = 9;
  public static final int TT_WINRT_PAD = 6;
  public static final int TT_WINRT_PHONE = 7;
  public static final int UE_ACCEPTED = 3;
  public static final int UE_BEINVITED = 1;
  public static final int UE_CONNECTED = 4;
  public static final int UE_CONNECT_FAIL = 5;
  public static final int UE_DATA_CHANGE = 10;
  public static final int UE_ENTERED = 2;
  public static final int UE_KICK_OUT = 9;
  public static final int UE_LOGOUT = 7;
  public static final int UE_LOGOUT_SWITCH_TO_GROUP = 11;
  public static final int UE_LOGOUT_TERMINAL_SWITCH = 12;
  public static final int UE_REFUSED = 6;
  public static final int UE_TIMEOUT = 8;
  public static final int US_CONNECTED = 3;
  public static final int US_CONNECTING = 2;
  public static final int US_INVITING = 1;
  
  public static final class AddrInfo
    extends MessageMicro<AddrInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_account", "uint32_isp", "uint32_country", "uint32_prov", "uint32_city" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, AddrInfo.class);
    public final PBUInt32Field uint32_city = PBField.initUInt32(0);
    public final PBUInt32Field uint32_country = PBField.initUInt32(0);
    public final PBUInt32Field uint32_isp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_prov = PBField.initUInt32(0);
    public final PBUInt64Field uint64_account = PBField.initUInt64(0L);
  }
  
  public static final class CmdFailedRspBody
    extends MessageMicro<CmdFailedRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_error_code", "str_error_info" }, new Object[] { Integer.valueOf(0), "" }, CmdFailedRspBody.class);
    public final PBStringField str_error_info = PBField.initString("");
    public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
  }
  
  public static final class CryptInfo
    extends MessageMicro<CryptInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_key_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_crypt_type = PBField.initEnum(1);
    public final PBUInt32Field uint32_key_len = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "enum_crypt_type", "uint32_key_len", "bytes_key_buf" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), localByteStringMicro }, CryptInfo.class);
    }
  }
  
  public static final class ExtContent
    extends MessageMicro<ExtContent>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_ext_content_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_ext_content = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_ext_content_type", "uint64_ext_content", "bytes_ext_content" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, ExtContent.class);
    }
  }
  
  public static final class NetAddr
    extends MessageMicro<NetAddr>
  {
    public static final int PT_TCP = 1;
    public static final int PT_UDP = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 24, 37 }, new String[] { "fixed32_IP", "uint32_port", "enum_proto_type", "fixed32_inner_IP" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) }, NetAddr.class);
    public final PBEnumField enum_proto_type = PBField.initEnum(1);
    public final PBFixed32Field fixed32_IP = PBField.initFixed32(0);
    public final PBFixed32Field fixed32_inner_IP = PBField.initFixed32(0);
    public final PBUInt32Field uint32_port = PBField.initUInt32(0);
  }
  
  public static final class PstnAudioProto
    extends MessageMicro<PstnAudioProto>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 74 }, new String[] { "uint32_audio_pt", "uint32_audio_sample", "uint32_audio_ptime", "uint32_proto", "uint32_rfc2833_pt", "uint32_max_average_bitrate", "uint32_use_inband_fec", "uint32_used_tx", "rpt_srtp_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, PstnAudioProto.class);
    public final PBRepeatMessageField<hd_video_comm.PstnAudioSrtpSdpInfo> rpt_srtp_info = PBField.initRepeatMessage(hd_video_comm.PstnAudioSrtpSdpInfo.class);
    public final PBUInt32Field uint32_audio_pt = PBField.initUInt32(0);
    public final PBUInt32Field uint32_audio_ptime = PBField.initUInt32(0);
    public final PBUInt32Field uint32_audio_sample = PBField.initUInt32(0);
    public final PBUInt32Field uint32_max_average_bitrate = PBField.initUInt32(0);
    public final PBUInt32Field uint32_proto = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rfc2833_pt = PBField.initUInt32(0);
    public final PBUInt32Field uint32_use_inband_fec = PBField.initUInt32(0);
    public final PBUInt32Field uint32_used_tx = PBField.initUInt32(0);
  }
  
  public static final class PstnAudioSrtpSdpInfo
    extends MessageMicro<PstnAudioSrtpSdpInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_raw_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_crypto_method = PBField.initEnum(0);
    public final PBUInt32Field uint32_crypto_tag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_key_derivation_rate = PBField.initUInt32(0);
    public final PBUInt32Field uint32_life_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mki_len = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mki_value = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 56 }, new String[] { "enum_crypto_method", "uint32_crypto_tag", "bytes_raw_key", "uint32_life_time", "uint32_mki_value", "uint32_mki_len", "uint32_key_derivation_rate" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PstnAudioSrtpSdpInfo.class);
    }
  }
  
  public static final class PstnMobileInfo
    extends MessageMicro<PstnMobileInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_mobile = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nation = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_prefix = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_provider_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "bytes_nation", "bytes_prefix", "bytes_mobile", "uint32_provider_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, PstnMobileInfo.class);
    }
  }
  
  public static final class SharpSignInfo
    extends MessageMicro<SharpSignInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 98, 106, 112, 122 }, new String[] { "uint64_uin", "uint32_business_type", "uint64_business_id", "uint64_roomId", "uint32_timestamp", "uint32_timeout", "uint32_clientseq", "uint32_interface_ip", "uint32_interface_port", "uint32_engine_ip", "uint32_engine_port", "msg_initiator_addr", "rpt_receiver_addr", "uint32_client_ip", "msg_crypt_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, Integer.valueOf(0), null }, SharpSignInfo.class);
    public hd_video_comm.CryptInfo msg_crypt_info = new hd_video_comm.CryptInfo();
    public hd_video_comm.AddrInfo msg_initiator_addr = new hd_video_comm.AddrInfo();
    public final PBRepeatMessageField<hd_video_comm.AddrInfo> rpt_receiver_addr = PBField.initRepeatMessage(hd_video_comm.AddrInfo.class);
    public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_clientseq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_engine_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_engine_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_interface_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_interface_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timeout = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBUInt64Field uint64_business_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_roomId = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class SipServerInfo
    extends MessageMicro<SipServerInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_domain = PBField.initBytes(ByteStringMicro.EMPTY);
    public hd_video_comm.PstnMobileInfo msg_caller_phone = new hd_video_comm.PstnMobileInfo();
    public hd_video_comm.NetAddr msg_sip_addr = new hd_video_comm.NetAddr();
    public final PBRepeatField<Integer> rpt_uint32_dtmf_mode = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_encode_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_provider_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_srtp_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tls_flag = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50, 56, 64 }, new String[] { "msg_sip_addr", "uint32_provider_id", "msg_caller_phone", "uint32_encode_type", "uint32_tls_flag", "bytes_domain", "uint32_srtp_flag", "rpt_uint32_dtmf_mode" }, new Object[] { null, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, SipServerInfo.class);
    }
  }
  
  public static final class TransBuffer
    extends MessageMicro<TransBuffer>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_type", "bytes_content" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, TransBuffer.class);
    }
  }
  
  public static final class UTime
    extends MessageMicro<UTime>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_time", "uint32_utime" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, UTime.class);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_utime = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     tencent.im.cs.longconn.hd_video_comm
 * JD-Core Version:    0.7.0.1
 */
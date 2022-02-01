package tencent.im.cs.longconn.putinfo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hd_video_putinfo
{
  public static final int CHIP_ARM_V5 = 1;
  public static final int CHIP_ARM_V6 = 2;
  public static final int CHIP_ARM_V7_NENO = 4;
  public static final int CHIP_ARM_V7_NO_NENO = 3;
  public static final int CHIP_ARM_V8 = 5;
  public static final int CHIP_MIPS = 6;
  public static final int CHIP_UNKNOW = 0;
  public static final int CHIP_X86 = 7;
  public static final int EM_DeviceIPad1 = 100;
  public static final int EM_DeviceIPad2 = 101;
  public static final int EM_DeviceIPad3 = 102;
  public static final int EM_DeviceIPad4 = 103;
  public static final int EM_DeviceIPadAIR = 105;
  public static final int EM_DeviceIPadAIR2 = 108;
  public static final int EM_DeviceIPadLater = 199;
  public static final int EM_DeviceIPadMINI1G = 104;
  public static final int EM_DeviceIPadMINI2 = 106;
  public static final int EM_DeviceIPadMINI3 = 107;
  public static final int EM_DeviceIPhone1G = 1;
  public static final int EM_DeviceIPhone3G = 2;
  public static final int EM_DeviceIPhone3GS = 3;
  public static final int EM_DeviceIPhone4 = 4;
  public static final int EM_DeviceIPhone4S = 5;
  public static final int EM_DeviceIPhone5 = 6;
  public static final int EM_DeviceIPhone5C = 7;
  public static final int EM_DeviceIPhone5S = 8;
  public static final int EM_DeviceIPhone6 = 9;
  public static final int EM_DeviceIPhone6Plus = 10;
  public static final int EM_DeviceIPhoneLater = 49;
  public static final int EM_DeviceIPodTouch1G = 50;
  public static final int EM_DeviceIPodTouch2G = 51;
  public static final int EM_DeviceIPodTouch3G = 52;
  public static final int EM_DeviceIPodTouch4G = 53;
  public static final int EM_DeviceIPodTouch5G = 54;
  public static final int EM_DeviceIPodTouchLater = 99;
  public static final int EM_Device_Android = 201;
  public static final int EM_Device_Unknow = 0;
  public static final int EM_Device_WP8 = 301;
  public static final int EM_DeviceiPhoneSimulator = 500;
  public static final int EM_OS_ANDROID_1_1 = 101;
  public static final int EM_OS_ANDROID_1_5 = 102;
  public static final int EM_OS_ANDROID_1_6 = 103;
  public static final int EM_OS_ANDROID_2_0 = 104;
  public static final int EM_OS_ANDROID_2_0_1 = 105;
  public static final int EM_OS_ANDROID_2_1 = 106;
  public static final int EM_OS_ANDROID_2_2 = 107;
  public static final int EM_OS_ANDROID_2_2_1 = 108;
  public static final int EM_OS_ANDROID_2_3_x = 109;
  public static final int EM_OS_ANDROID_3_0 = 110;
  public static final int EM_OS_ANDROID_3_1 = 111;
  public static final int EM_OS_ANDROID_3_2 = 112;
  public static final int EM_OS_ANDROID_4_0 = 113;
  public static final int EM_OS_ANDROID_4_1 = 114;
  public static final int EM_OS_ANDROID_4_2 = 115;
  public static final int EM_OS_ANDROID_4_3 = 116;
  public static final int EM_OS_ANDROID_4_4 = 117;
  public static final int EM_OS_ANDROID_5_0 = 118;
  public static final int EM_OS_ANDROID_Later = 200;
  public static final int EM_OS_IOS_4_0 = 1;
  public static final int EM_OS_IOS_4_0_1 = 2;
  public static final int EM_OS_IOS_4_0_2 = 3;
  public static final int EM_OS_IOS_4_1 = 4;
  public static final int EM_OS_IOS_4_2_1 = 5;
  public static final int EM_OS_IOS_4_2_10 = 11;
  public static final int EM_OS_IOS_4_2_5 = 6;
  public static final int EM_OS_IOS_4_2_6 = 7;
  public static final int EM_OS_IOS_4_2_7 = 8;
  public static final int EM_OS_IOS_4_2_8 = 9;
  public static final int EM_OS_IOS_4_2_9 = 10;
  public static final int EM_OS_IOS_4_3 = 12;
  public static final int EM_OS_IOS_4_3_1 = 13;
  public static final int EM_OS_IOS_4_3_2 = 14;
  public static final int EM_OS_IOS_4_3_3 = 15;
  public static final int EM_OS_IOS_4_3_4 = 16;
  public static final int EM_OS_IOS_4_3_5 = 17;
  public static final int EM_OS_IOS_5_0 = 18;
  public static final int EM_OS_IOS_5_0_1 = 20;
  public static final int EM_OS_IOS_5_1 = 21;
  public static final int EM_OS_IOS_5_1_1 = 22;
  public static final int EM_OS_IOS_5_1_1r1 = 23;
  public static final int EM_OS_IOS_5_4s = 19;
  public static final int EM_OS_IOS_6_0 = 25;
  public static final int EM_OS_IOS_6_0_Beta = 24;
  public static final int EM_OS_IOS_Later = 100;
  public static final int EM_OS_UNKNOW = 0;
  public static final int EM_OS_WP8 = 201;
  public static final int QUEST_DEVICE = 11020;
  public static final int QUEST_OPENSDK = 12009;
  public static final int QUEST_OTHER = 19999;
  public static final int QUEST_QCALL = 11023;
  public static final int QUEST_QQ = 11001;
  public static final int QUEST_UNKNOWN = 0;
  public static final int TS_AUDIO_ENCODE = 2;
  public static final int TS_AUDIO_PARA = 1;
  public static final int TS_NOTICEWORD_A = 3;
  public static final int TS_UNKNOWN = 0;
  
  public static final class AndroidCameraInfo
    extends MessageMicro<AndroidCameraInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128 }, new String[] { "uint32_param1", "uint32_param2", "uint32_param3", "uint32_param4", "uint32_param5", "uint32_param6", "uint32_param7", "uint32_param8", "uint32_param9", "uint32_param10", "uint32_param11", "uint32_param12", "uint32_param13", "uint32_param14", "uint32_param15", "uint32_param16" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, AndroidCameraInfo.class);
    public final PBUInt32Field uint32_param1 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param10 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param11 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param12 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param13 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param14 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param15 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param16 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param2 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param3 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param4 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param5 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param6 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param7 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param8 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param9 = PBField.initUInt32(0);
  }
  
  public static final class AudioSwitchPointInfo
    extends MessageMicro<AudioSwitchPointInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nowifi_words = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wifi_words = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_nowifi_pack_loss = PBField.initUInt32(0);
    public final PBUInt32Field uint32_nowifi_pack_loss_rate = PBField.initUInt32(0);
    public final PBUInt32Field uint32_nowifi_shake = PBField.initUInt32(0);
    public final PBUInt32Field uint32_nowifi_time_delay = PBField.initUInt32(0);
    public final PBUInt32Field uint32_wifi_pack_loss = PBField.initUInt32(0);
    public final PBUInt32Field uint32_wifi_pack_loss_rate = PBField.initUInt32(0);
    public final PBUInt32Field uint32_wifi_shake = PBField.initUInt32(0);
    public final PBUInt32Field uint32_wifi_time_delay = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 50, 56, 64, 72, 80, 98 }, new String[] { "uint32_wifi_shake", "uint32_wifi_time_delay", "uint32_wifi_pack_loss", "uint32_wifi_pack_loss_rate", "bytes_wifi_words", "uint32_nowifi_shake", "uint32_nowifi_time_delay", "uint32_nowifi_pack_loss", "uint32_nowifi_pack_loss_rate", "bytes_nowifi_words" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, AudioSwitchPointInfo.class);
    }
  }
  
  public static final class CmdReportClientInfoReqBody
    extends MessageMicro<CmdReportClientInfoReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_app_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_client_system_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_device_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_mobile_rom_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public hd_video_putinfo.MobileHardWareValue msg_device_info = new hd_video_putinfo.MobileHardWareValue();
    public hd_video_putinfo.VideoHardWareInfo msg_video_info = new hd_video_putinfo.VideoHardWareInfo();
    public final PBUInt32Field uint32_instid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mobile_os_info = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mobile_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_open_general_info = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sharp_sdk_ver = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 72, 80, 90 }, new String[] { "uint32_mobile_type", "uint32_mobile_os_info", "uint32_instid", "bytes_client_system_info", "bytes_device_info", "msg_device_info", "msg_video_info", "bytes_mobile_rom_info", "uint32_sharp_sdk_ver", "uint32_open_general_info", "bytes_app_version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, null, null, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4 }, CmdReportClientInfoReqBody.class);
    }
  }
  
  public static final class CmdToClientConfigInfoRspBody
    extends MessageMicro<CmdToClientConfigInfoRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_log_report_time = PBField.initBytes(ByteStringMicro.EMPTY);
    public hd_video_putinfo.AndroidCameraInfo msg_android_camera_set = new hd_video_putinfo.AndroidCameraInfo();
    public hd_video_putinfo.AudioSwitchPointInfo msg_audio_quality_set = new hd_video_putinfo.AudioSwitchPointInfo();
    public hd_video_putinfo.MobileQQPttInfo msg_qq_ptt_info_set = new hd_video_putinfo.MobileQQPttInfo();
    public hd_video_putinfo.SharpTraeInfo msg_sharp_trae_info_set = new hd_video_putinfo.SharpTraeInfo();
    public final PBRepeatMessageField<hd_video_putinfo.TransBuffer> rpt_msg_trans_buffer_list = PBField.initRepeatMessage(hd_video_putinfo.TransBuffer.class);
    public final PBUInt32Field uint32_log_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_switch = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 26, 34, 42, 48, 58, 66, 74 }, new String[] { "uint32_log_flag", "bytes_log_report_time", "msg_android_camera_set", "msg_sharp_trae_info_set", "uint64_switch", "msg_qq_ptt_info_set", "msg_audio_quality_set", "rpt_msg_trans_buffer_list" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null, Long.valueOf(0L), null, null, null }, CmdToClientConfigInfoRspBody.class);
    }
  }
  
  public static final class MobileHardWareValue
    extends MessageMicro<MobileHardWareValue>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_mobile_cpu_struct", "uint32_mobile_cpu_number", "uint32_mobile_cpu_hertz", "uint32_mobile_camera_turn" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MobileHardWareValue.class);
    public final PBUInt32Field uint32_mobile_camera_turn = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mobile_cpu_hertz = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mobile_cpu_number = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mobile_cpu_struct = PBField.initUInt32(0);
  }
  
  public static final class MobileQQPttInfo
    extends MessageMicro<MobileQQPttInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120 }, new String[] { "uint32_param1", "uint32_param2", "uint32_param3", "uint32_param4", "uint32_param5", "uint32_param6", "uint32_param7", "uint32_param8", "uint32_param9", "uint32_param10", "uint32_param11", "uint32_param12", "uint32_param13", "uint32_param14", "uint32_param15" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MobileQQPttInfo.class);
    public final PBUInt32Field uint32_param1 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param10 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param11 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param12 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param13 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param14 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param15 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param2 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param3 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param4 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param5 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param6 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param7 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param8 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param9 = PBField.initUInt32(0);
  }
  
  public static final class PutinfoHead
    extends MessageMicro<PutinfoHead>
  {
    public static final int CMD_CLIENT_REPORT_REQ = 1;
    public static final int CMD_S2C_PUTINFO_REQ = 2;
    public static final int ERR_DECODE_REQUEST = 1;
    public static final int ERR_UNKNOWN = 255;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_appid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_config_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_body_type = PBField.initEnum(1);
    public final PBUInt32Field uint32_error_no = PBField.initUInt32(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50, 58 }, new String[] { "enum_body_type", "uint64_uin", "bytes_appid", "uint64_seq", "uint32_error_no", "bytes_error_msg", "bytes_config_ver" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3 }, PutinfoHead.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_putinfo_head", "msg_report_client_info_req_body" }, new Object[] { null, null }, ReqBody.class);
    public hd_video_putinfo.PutinfoHead msg_putinfo_head = new hd_video_putinfo.PutinfoHead();
    public hd_video_putinfo.CmdReportClientInfoReqBody msg_report_client_info_req_body = new hd_video_putinfo.CmdReportClientInfoReqBody();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_putinfo_head", "msg_to_client_config_info_rsq_body" }, new Object[] { null, null }, RspBody.class);
    public hd_video_putinfo.PutinfoHead msg_putinfo_head = new hd_video_putinfo.PutinfoHead();
    public hd_video_putinfo.CmdToClientConfigInfoRspBody msg_to_client_config_info_rsq_body = new hd_video_putinfo.CmdToClientConfigInfoRspBody();
  }
  
  public static final class SharpTraeInfo
    extends MessageMicro<SharpTraeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88 }, new String[] { "uint32_trae_source", "uint32_trae_interface", "uint32_trae_stream_type", "uint32_trae_volume", "uint32_trae_mode", "uint32_arm_flag", "uint32_cpu_hertz", "uint32_audio_set", "uint32_param9", "uint32_param10", "uint32_param11" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SharpTraeInfo.class);
    public final PBUInt32Field uint32_arm_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_audio_set = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cpu_hertz = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param10 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param11 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_param9 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_trae_interface = PBField.initUInt32(0);
    public final PBUInt32Field uint32_trae_mode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_trae_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_trae_stream_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_trae_volume = PBField.initUInt32(0);
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
  
  public static final class VideoHardWareInfo
    extends MessageMicro<VideoHardWareInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_mobile_max_encodeframe", "uint32_mobile_max_decodeframe", "uint32_mobile_width", "uint32_mobile_height" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, VideoHardWareInfo.class);
    public final PBUInt32Field uint32_mobile_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mobile_max_decodeframe = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mobile_max_encodeframe = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mobile_width = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     tencent.im.cs.longconn.putinfo.hd_video_putinfo
 * JD-Core Version:    0.7.0.1
 */
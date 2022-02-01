package com.tencent.av.config;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.AndroidCameraInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.AudioSwitchPointInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.CmdReportClientInfoReqBody;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.CmdToClientConfigInfoRspBody;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.MobileHardWareValue;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.MobileQQPttInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.PutinfoHead;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.ReqBody;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.RspBody;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.SharpTraeInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.TransBuffer;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.VideoHardWareInfo;

public class ConfigPBProtocol
{
  public static String m_md5 = "";
  private C2SConfigInfoPBProtocol m_c2sReq = new C2SConfigInfoPBProtocol();
  private S2CConfigInfoPBProtocol m_s2cRsp = new S2CConfigInfoPBProtocol();
  
  public byte[] GetConfigRequest()
  {
    byte[] arrayOfByte = null;
    if (this.m_c2sReq != null) {
      arrayOfByte = this.m_c2sReq.pack();
    }
    return arrayOfByte;
  }
  
  public ConfigSysInfoNew GetConfigSysInfoNew()
  {
    ConfigSysInfoNew localConfigSysInfoNew = null;
    if (this.m_s2cRsp != null) {
      localConfigSysInfoNew = this.m_s2cRsp.GetConfigSysInfoNew();
    }
    return localConfigSysInfoNew;
  }
  
  public void Init(long paramLong, TerminalInfo paramTerminalInfo)
  {
    this.m_c2sReq.Init(paramLong, paramTerminalInfo);
  }
  
  public int UnpackPBConfigInfo(byte[] paramArrayOfByte)
  {
    if (this.m_s2cRsp != null) {
      return this.m_s2cRsp.unpack(paramArrayOfByte);
    }
    return -1;
  }
  
  public void UpdateSelfUIN(long paramLong)
  {
    if (this.m_c2sReq != null) {
      this.m_c2sReq.UpdateSelfUIN(paramLong);
    }
  }
  
  public class C2SConfigInfoPBProtocol
  {
    private hd_video_putinfo.ReqBody m_PutinfoReq = new hd_video_putinfo.ReqBody();
    private ConfigPBProtocol.TerminalInfo m_pClientInfo = null;
    private long m_selfuin = 0L;
    
    public C2SConfigInfoPBProtocol() {}
    
    private void makeBody()
    {
      hd_video_putinfo.CmdReportClientInfoReqBody localCmdReportClientInfoReqBody = (hd_video_putinfo.CmdReportClientInfoReqBody)this.m_PutinfoReq.msg_report_client_info_req_body.get();
      localCmdReportClientInfoReqBody.uint32_mobile_type.set(this.m_pClientInfo.deviceType);
      localCmdReportClientInfoReqBody.uint32_mobile_os_info.set(this.m_pClientInfo.osType);
      localCmdReportClientInfoReqBody.uint32_instid.set(11001);
      localCmdReportClientInfoReqBody.bytes_client_system_info.set(ByteStringMicro.copyFrom(this.m_pClientInfo.os_version.getBytes()));
      localCmdReportClientInfoReqBody.bytes_device_info.set(ByteStringMicro.copyFrom(this.m_pClientInfo.deviceName.getBytes()));
      Object localObject = (hd_video_putinfo.MobileHardWareValue)localCmdReportClientInfoReqBody.msg_device_info.get();
      ((hd_video_putinfo.MobileHardWareValue)localObject).uint32_mobile_cpu_struct.set(this.m_pClientInfo.chip);
      ((hd_video_putinfo.MobileHardWareValue)localObject).uint32_mobile_cpu_number.set(this.m_pClientInfo.numOfCore);
      ((hd_video_putinfo.MobileHardWareValue)localObject).uint32_mobile_cpu_hertz.set(this.m_pClientInfo.cpuFreq);
      ((hd_video_putinfo.MobileHardWareValue)localObject).uint32_mobile_camera_turn.set(this.m_pClientInfo.angleForCamera);
      localCmdReportClientInfoReqBody.msg_device_info.set((MessageMicro)localObject);
      localObject = (hd_video_putinfo.VideoHardWareInfo)localCmdReportClientInfoReqBody.msg_video_info.get();
      ((hd_video_putinfo.VideoHardWareInfo)localObject).uint32_mobile_max_encodeframe.set(this.m_pClientInfo.maxEncodeFrame);
      ((hd_video_putinfo.VideoHardWareInfo)localObject).uint32_mobile_max_decodeframe.set(this.m_pClientInfo.maxDecodeFrame);
      ((hd_video_putinfo.VideoHardWareInfo)localObject).uint32_mobile_width.set(this.m_pClientInfo.screenWidth);
      ((hd_video_putinfo.VideoHardWareInfo)localObject).uint32_mobile_height.set(this.m_pClientInfo.screenHeight);
      localCmdReportClientInfoReqBody.msg_video_info.set((MessageMicro)localObject);
      localCmdReportClientInfoReqBody.bytes_mobile_rom_info.set(ByteStringMicro.copyFrom(this.m_pClientInfo.romInfo.getBytes()));
      localCmdReportClientInfoReqBody.uint32_sharp_sdk_ver.set(this.m_pClientInfo.sharpSDKVersion);
      localCmdReportClientInfoReqBody.uint32_open_general_info.set(this.m_pClientInfo.sharpConfigVersion);
      localCmdReportClientInfoReqBody.bytes_app_version.set(ByteStringMicro.copyFrom(this.m_pClientInfo.appVersion.getBytes()));
      this.m_PutinfoReq.msg_report_client_info_req_body.set(localCmdReportClientInfoReqBody);
    }
    
    private void makeHead()
    {
      hd_video_putinfo.PutinfoHead localPutinfoHead = (hd_video_putinfo.PutinfoHead)this.m_PutinfoReq.msg_putinfo_head.get();
      localPutinfoHead.enum_body_type.set(1);
      localPutinfoHead.uint64_uin.set(this.m_selfuin);
      localPutinfoHead.bytes_appid.set(ByteStringMicro.copyFrom(this.m_pClientInfo.appID.getBytes()));
      localPutinfoHead.uint64_seq.set(new Random().nextLong());
      localPutinfoHead.bytes_config_ver.set(ByteStringMicro.copyFrom(ConfigPBProtocol.m_md5.getBytes()));
      this.m_PutinfoReq.msg_putinfo_head.set(localPutinfoHead);
    }
    
    public void Init(long paramLong, ConfigPBProtocol.TerminalInfo paramTerminalInfo)
    {
      this.m_selfuin = paramLong;
      this.m_pClientInfo = paramTerminalInfo;
    }
    
    public void UpdateSelfUIN(long paramLong)
    {
      if (this.m_selfuin != paramLong) {
        this.m_selfuin = paramLong;
      }
    }
    
    public byte[] pack()
    {
      makeHead();
      makeBody();
      return this.m_PutinfoReq.toByteArray();
    }
  }
  
  public class ConfigSysInfoNew
  {
    MobileQQPttInfo m_PttInfo = new MobileQQPttInfo();
    SwtichInfo m_SwitchInfo = new SwtichInfo();
    AudioSwitchPointInfo m_audioPointInfo = new AudioSwitchPointInfo();
    boolean m_bIsWriteLocalLog = true;
    AndroidCameraInfo m_cameraInfo = new AndroidCameraInfo();
    String m_hwcodecTestPayload = "";
    String m_sharpConfigPayload = "";
    SharpTraeInfo m_sharpTraeInfo = new SharpTraeInfo();
    List<TransBuffer> m_transBufferList = new ArrayList();
    
    public ConfigSysInfoNew() {}
    
    class AndroidCameraInfo
    {
      byte m_BackCameraAngleForLocalPreview = 0;
      byte m_BackCameraAngleForRemote_0 = 0;
      byte m_BackCameraAngleForRemote_180 = 0;
      byte m_BackCameraAngleForRemote_270 = 0;
      byte m_BackCameraAngleForRemote_90 = 0;
      byte m_BackCameraFormat = 0;
      byte m_FrontCameraAngleForLocalPreview = 0;
      byte m_FrontCameraAngleForRemote_0 = 0;
      byte m_FrontCameraAngleForRemote_180 = 0;
      byte m_FrontCameraAngleForRemote_270 = 0;
      byte m_FrontCameraAngleForRemote_90 = 0;
      byte m_FrontCameraFormat = 0;
      
      AndroidCameraInfo() {}
    }
    
    class AudioSwitchPointInfo
    {
      String bytes_nowifi_words = "";
      String bytes_wifi_words = "";
      int uint32_nowifi_pack_loss = 0;
      int uint32_nowifi_pack_loss_rate = 0;
      int uint32_nowifi_shake = 0;
      int uint32_nowifi_time_delay = 0;
      int uint32_wifi_pack_loss = 0;
      int uint32_wifi_pack_loss_rate = 0;
      int uint32_wifi_shake = 0;
      int uint32_wifi_time_delay = 0;
      
      AudioSwitchPointInfo() {}
    }
    
    class MobileQQPttInfo
    {
      boolean bool_isConfig = false;
      int uint32_param1 = 0;
      int uint32_param10 = 0;
      int uint32_param11 = 0;
      int uint32_param12 = 0;
      int uint32_param13 = 0;
      int uint32_param14 = 0;
      int uint32_param15 = 0;
      int uint32_param2 = 0;
      int uint32_param3 = 0;
      int uint32_param4 = 0;
      int uint32_param5 = 0;
      int uint32_param6 = 0;
      int uint32_param7 = 0;
      int uint32_param8 = 0;
      int uint32_param9 = 0;
      
      MobileQQPttInfo() {}
    }
    
    class SharpTraeInfo
    {
      int uint32_arm_flag = 0;
      int uint32_audio_set = 0;
      int uint32_cpu_hertz = 0;
      int uint32_trae_interface = 0;
      int uint32_trae_mode = 0;
      int uint32_trae_source = 0;
      int uint32_trae_stream_type = 0;
      int uint32_trae_volume = 0;
      
      SharpTraeInfo() {}
    }
    
    class SwtichInfo
    {
      byte m_isAllPSTNEnable = 0;
      byte m_isAudioEnable = 1;
      byte m_isAudioHowlingEnable = 0;
      byte m_isOpenMaxEnable = 0;
      byte m_isPBCmdEnable = 1;
      byte m_isPSTNEnable = 1;
      byte m_isStrongPSTNEnable = 0;
      byte m_isSupportSmallScreen = 0;
      byte m_isVOIPEnable = 1;
      
      SwtichInfo() {}
    }
    
    class TransBuffer
    {
      String bytes_content = "";
      int uint32_type = 0;
      
      TransBuffer() {}
    }
  }
  
  public class S2CConfigInfoPBProtocol
  {
    private ConfigPBProtocol.ConfigSysInfoNew m_ConfigInfo = new ConfigPBProtocol.ConfigSysInfoNew(ConfigPBProtocol.this);
    private hd_video_putinfo.RspBody m_RspBody = new hd_video_putinfo.RspBody();
    
    public S2CConfigInfoPBProtocol() {}
    
    private int unpackToConfigSysSt()
    {
      if (!this.m_RspBody.msg_to_client_config_info_rsq_body.has()) {
        return -1;
      }
      Object localObject1 = (hd_video_putinfo.CmdToClientConfigInfoRspBody)this.m_RspBody.msg_to_client_config_info_rsq_body.get();
      int i;
      Object localObject2;
      boolean bool;
      if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint32_log_flag.has())
      {
        i = ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint32_log_flag.get();
        localObject2 = this.m_ConfigInfo;
        if (i == 0)
        {
          bool = false;
          ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).m_bIsWriteLocalLog = bool;
        }
      }
      else
      {
        if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).bytes_log_report_time.has()) {
          ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).bytes_log_report_time.get().toStringUtf8();
        }
        if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_android_camera_set.has())
        {
          localObject2 = (hd_video_putinfo.AndroidCameraInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_android_camera_set.get();
          this.m_ConfigInfo.m_cameraInfo.m_FrontCameraAngleForLocalPreview = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param1.get());
          this.m_ConfigInfo.m_cameraInfo.m_BackCameraAngleForLocalPreview = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param2.get());
          this.m_ConfigInfo.m_cameraInfo.m_FrontCameraAngleForRemote_0 = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param3.get());
          this.m_ConfigInfo.m_cameraInfo.m_BackCameraAngleForRemote_0 = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param4.get());
          this.m_ConfigInfo.m_cameraInfo.m_FrontCameraAngleForRemote_90 = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param5.get());
          this.m_ConfigInfo.m_cameraInfo.m_BackCameraAngleForRemote_90 = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param6.get());
          this.m_ConfigInfo.m_cameraInfo.m_FrontCameraAngleForRemote_180 = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param7.get());
          this.m_ConfigInfo.m_cameraInfo.m_BackCameraAngleForRemote_180 = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param8.get());
          this.m_ConfigInfo.m_cameraInfo.m_FrontCameraAngleForRemote_270 = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param9.get());
          this.m_ConfigInfo.m_cameraInfo.m_BackCameraAngleForRemote_270 = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param10.get());
          this.m_ConfigInfo.m_cameraInfo.m_FrontCameraFormat = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param11.get());
          this.m_ConfigInfo.m_cameraInfo.m_BackCameraFormat = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param12.get());
        }
        if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_sharp_trae_info_set.has())
        {
          localObject2 = (hd_video_putinfo.SharpTraeInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_sharp_trae_info_set.get();
          this.m_ConfigInfo.m_sharpTraeInfo.uint32_trae_source = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_source.get();
          this.m_ConfigInfo.m_sharpTraeInfo.uint32_trae_interface = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_interface.get();
          this.m_ConfigInfo.m_sharpTraeInfo.uint32_trae_stream_type = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_stream_type.get();
          this.m_ConfigInfo.m_sharpTraeInfo.uint32_trae_volume = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_volume.get();
          this.m_ConfigInfo.m_sharpTraeInfo.uint32_trae_mode = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_mode.get();
          this.m_ConfigInfo.m_sharpTraeInfo.uint32_arm_flag = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_arm_flag.get();
          this.m_ConfigInfo.m_sharpTraeInfo.uint32_cpu_hertz = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_cpu_hertz.get();
          this.m_ConfigInfo.m_sharpTraeInfo.uint32_audio_set = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_audio_set.get();
        }
        if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint64_switch.has())
        {
          long l = ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint64_switch.get();
          this.m_ConfigInfo.m_SwitchInfo.m_isAudioEnable = ((byte)(int)(1L & l));
          this.m_ConfigInfo.m_SwitchInfo.m_isOpenMaxEnable = ((byte)(int)(l >> 1 & 1L));
          this.m_ConfigInfo.m_SwitchInfo.m_isPBCmdEnable = ((byte)(int)(l >> 2 & 1L));
          this.m_ConfigInfo.m_SwitchInfo.m_isVOIPEnable = ((byte)(int)(l >> 3 & 1L));
          this.m_ConfigInfo.m_SwitchInfo.m_isPSTNEnable = ((byte)(int)(l >> 4 & 1L));
          this.m_ConfigInfo.m_SwitchInfo.m_isAllPSTNEnable = ((byte)(int)(l >> 5 & 1L));
          this.m_ConfigInfo.m_SwitchInfo.m_isStrongPSTNEnable = ((byte)(int)(l >> 6 & 1L));
          this.m_ConfigInfo.m_SwitchInfo.m_isSupportSmallScreen = ((byte)(int)(l >> 7 & 1L));
          this.m_ConfigInfo.m_SwitchInfo.m_isAudioHowlingEnable = ((byte)(int)(l >> 13 & 1L));
        }
        if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_qq_ptt_info_set.has())
        {
          this.m_ConfigInfo.m_PttInfo.bool_isConfig = true;
          localObject2 = (hd_video_putinfo.MobileQQPttInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_qq_ptt_info_set.get();
          this.m_ConfigInfo.m_PttInfo.uint32_param1 = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param1.get();
          this.m_ConfigInfo.m_PttInfo.uint32_param2 = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param2.get();
          this.m_ConfigInfo.m_PttInfo.uint32_param3 = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param3.get();
          this.m_ConfigInfo.m_PttInfo.uint32_param4 = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param4.get();
          this.m_ConfigInfo.m_PttInfo.uint32_param5 = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param5.get();
          this.m_ConfigInfo.m_PttInfo.uint32_param6 = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param6.get();
          this.m_ConfigInfo.m_PttInfo.uint32_param7 = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param7.get();
          this.m_ConfigInfo.m_PttInfo.uint32_param8 = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param8.get();
          this.m_ConfigInfo.m_PttInfo.uint32_param9 = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param9.get();
          this.m_ConfigInfo.m_PttInfo.uint32_param10 = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param10.get();
          this.m_ConfigInfo.m_PttInfo.uint32_param11 = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param11.get();
          this.m_ConfigInfo.m_PttInfo.uint32_param12 = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param12.get();
          this.m_ConfigInfo.m_PttInfo.uint32_param13 = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param13.get();
          this.m_ConfigInfo.m_PttInfo.uint32_param14 = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param14.get();
          this.m_ConfigInfo.m_PttInfo.uint32_param15 = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param15.get();
        }
        if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_audio_quality_set.has())
        {
          localObject2 = (hd_video_putinfo.AudioSwitchPointInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_audio_quality_set.get();
          this.m_ConfigInfo.m_audioPointInfo.uint32_wifi_shake = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_shake.get();
          this.m_ConfigInfo.m_audioPointInfo.uint32_wifi_time_delay = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_time_delay.get();
          this.m_ConfigInfo.m_audioPointInfo.uint32_wifi_pack_loss = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_pack_loss.get();
          this.m_ConfigInfo.m_audioPointInfo.uint32_wifi_pack_loss_rate = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_pack_loss_rate.get();
          this.m_ConfigInfo.m_audioPointInfo.bytes_wifi_words = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).bytes_wifi_words.get().toStringUtf8();
          this.m_ConfigInfo.m_audioPointInfo.uint32_nowifi_shake = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_shake.get();
          this.m_ConfigInfo.m_audioPointInfo.uint32_nowifi_time_delay = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_time_delay.get();
          this.m_ConfigInfo.m_audioPointInfo.uint32_nowifi_pack_loss = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_pack_loss.get();
          this.m_ConfigInfo.m_audioPointInfo.uint32_nowifi_pack_loss_rate = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_pack_loss_rate.get();
          this.m_ConfigInfo.m_audioPointInfo.bytes_nowifi_words = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).bytes_nowifi_words.get().toStringUtf8();
        }
        if (!((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).rpt_msg_trans_buffer_list.has()) {
          break label1391;
        }
        localObject1 = ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).rpt_msg_trans_buffer_list.get();
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break label1391;
        }
        i = 0;
        label1238:
        if (i >= ((List)localObject1).size()) {
          break label1391;
        }
        localObject2 = this.m_ConfigInfo;
        localObject2.getClass();
        localObject2 = new ConfigPBProtocol.ConfigSysInfoNew.TransBuffer((ConfigPBProtocol.ConfigSysInfoNew)localObject2);
        ((ConfigPBProtocol.ConfigSysInfoNew.TransBuffer)localObject2).uint32_type = ((hd_video_putinfo.TransBuffer)((List)localObject1).get(i)).uint32_type.get();
        ((ConfigPBProtocol.ConfigSysInfoNew.TransBuffer)localObject2).bytes_content = ((hd_video_putinfo.TransBuffer)((List)localObject1).get(i)).bytes_content.get().toStringUtf8();
        this.m_ConfigInfo.m_transBufferList.add(localObject2);
        if (((ConfigPBProtocol.ConfigSysInfoNew.TransBuffer)localObject2).uint32_type != 1) {
          break label1367;
        }
        this.m_ConfigInfo.m_sharpConfigPayload = ((ConfigPBProtocol.ConfigSysInfoNew.TransBuffer)localObject2).bytes_content;
      }
      for (;;)
      {
        i += 1;
        break label1238;
        bool = true;
        break;
        label1367:
        if (((ConfigPBProtocol.ConfigSysInfoNew.TransBuffer)localObject2).uint32_type == 2) {
          this.m_ConfigInfo.m_hwcodecTestPayload = ((ConfigPBProtocol.ConfigSysInfoNew.TransBuffer)localObject2).bytes_content;
        }
      }
      label1391:
      return 0;
    }
    
    public ConfigPBProtocol.ConfigSysInfoNew GetConfigSysInfoNew()
    {
      return this.m_ConfigInfo;
    }
    
    public int unpack(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte == null) {}
      for (;;)
      {
        return -1;
        try
        {
          this.m_RspBody.mergeFrom(paramArrayOfByte);
          if (this.m_RspBody.msg_putinfo_head.has())
          {
            paramArrayOfByte = (hd_video_putinfo.PutinfoHead)this.m_RspBody.msg_putinfo_head.get();
            if ((paramArrayOfByte != null) && (paramArrayOfByte.uint32_error_no.has()) && (paramArrayOfByte.uint32_error_no.get() == 0) && (paramArrayOfByte.enum_body_type.has()) && (paramArrayOfByte.enum_body_type.get() == 2))
            {
              if (paramArrayOfByte.bytes_config_ver.has()) {
                ConfigPBProtocol.m_md5 = paramArrayOfByte.bytes_config_ver.get().toStringUtf8();
              }
              int i = unpackToConfigSysSt();
              return i;
            }
          }
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
      return -1;
    }
  }
  
  public class TerminalInfo
  {
    int angleForCamera = 0;
    String appID = "";
    String appVersion = "";
    int chip = 0;
    int cpuFreq = 0;
    String deviceName = "";
    int deviceType = 0;
    int maxDecodeFrame = 0;
    int maxEncodeFrame = 0;
    int numOfCore = 0;
    int openslInfo = 0;
    int osType = 0;
    String os_version = "";
    String romInfo = "";
    int screenHeight = 0;
    int screenWidth = 0;
    int sharpConfigVersion = 0;
    int sharpSDKVersion = 0;
    
    public TerminalInfo() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.config.ConfigPBProtocol
 * JD-Core Version:    0.7.0.1
 */
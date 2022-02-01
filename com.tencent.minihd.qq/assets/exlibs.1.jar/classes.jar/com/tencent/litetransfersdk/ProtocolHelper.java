package com.tencent.litetransfersdk;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dcg;
import dch;
import dci;
import dcj;
import dck;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadHitReqV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadHitRspV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReqV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReqV3;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV3;
import tencent.im.cs.cmd0x346.cmd0x346.DeleteFileReq;
import tencent.im.cs.cmd0x346.cmd0x346.DeleteFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346.FileInfo;
import tencent.im.cs.cmd0x346.cmd0x346.FileQueryReq;
import tencent.im.cs.cmd0x346.cmd0x346.FileQueryRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccRsp;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.ActionInfo;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.FTNNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.FileControl;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MpFileNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MsgHeader;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.NFCNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.RNFCNotify;

public class ProtocolHelper
{
  public static final int TYPE_TINYID = 1;
  public static final int TYPE_UIN = 0;
  public static final String sTagName = "dataline.ProtocolHelper";
  protected AppInterface mApp;
  protected int mUinType = 0;
  
  public ProtocolHelper(AppInterface paramAppInterface, int paramInt)
  {
    this.mApp = paramAppInterface;
    this.mUinType = paramInt;
  }
  
  public static String FixImageFileExtName(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    String str = paramString1;
    if (paramInt == 1)
    {
      str = paramString1;
      if (FileManagerUtil.a(paramString1) != 0)
      {
        str = paramString1;
        if (!paramBoolean) {
          if (!GifDrawable.isGifFile(new File(paramString2))) {
            break label65;
          }
        }
      }
    }
    label65:
    for (paramString2 = ".gif";; paramString2 = ".jpg")
    {
      str = paramString1 + paramString2;
      return str;
    }
  }
  
  private FileInfo createFileInfo(cmd0x346.FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return null;
    }
    FileInfo localFileInfo = new FileInfo();
    localFileInfo.uint64_uin = paramFileInfo.uint64_uin.get();
    localFileInfo.uint32_danger_evel = paramFileInfo.uint32_danger_evel.get();
    localFileInfo.uint64_file_size = paramFileInfo.uint64_file_size.get();
    localFileInfo.uint32_life_time = paramFileInfo.uint32_life_time.get();
    localFileInfo.uint32_upload_time = paramFileInfo.uint32_upload_time.get();
    localFileInfo.bytes_uuid = paramFileInfo.bytes_uuid.get().toByteArray();
    localFileInfo.str_file_name = paramFileInfo.str_file_name.get();
    localFileInfo.uint32_abs_file_type = paramFileInfo.uint32_abs_file_type.get();
    localFileInfo.bytes_10m_md5 = paramFileInfo.bytes_10m_md5.get().toByteArray();
    localFileInfo.uint32_client_type = paramFileInfo.uint32_client_type.get();
    localFileInfo.uint64_owner_uin = paramFileInfo.uint64_owner_uin.get();
    localFileInfo.uint64_peer_uin = paramFileInfo.uint64_peer_uin.get();
    localFileInfo.uint32_expire_time = paramFileInfo.uint32_expire_time.get();
    return localFileInfo;
  }
  
  public static void fillMsgHeader(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, long paramLong1, long paramLong2)
  {
    int i = AppSetting.a;
    paramMsgHeader.uint32_src_app_id.set(1001);
    paramMsgHeader.uint32_src_inst_id.set(i);
    paramMsgHeader.uint32_dst_app_id.set(1);
    paramMsgHeader.uint32_dst_inst_id.set(1);
    paramMsgHeader.uint64_dst_uin.set(paramLong1);
    paramMsgHeader.uint64_src_uin.set(paramLong2);
    paramMsgHeader.setHasFlag(true);
  }
  
  public boolean CheckActionInfo(SubMsgType0x7.MsgBody.FTNNotify paramFTNNotify, String paramString)
  {
    if (paramFTNNotify.msg_ActionInfo.has()) {
      return isMyNotify((SubMsgType0x7.MsgBody.ActionInfo)paramFTNNotify.msg_ActionInfo.get(), paramString);
    }
    return false;
  }
  
  public boolean CheckActionInfo(SubMsgType0x7.MsgBody.NFCNotify paramNFCNotify, String paramString)
  {
    if (paramNFCNotify.msg_ActionInfo.has()) {
      return isMyNotify((SubMsgType0x7.MsgBody.ActionInfo)paramNFCNotify.msg_ActionInfo.get(), paramString);
    }
    return false;
  }
  
  public void FillMsgSCBody(MsgSCBody paramMsgSCBody, cmd0x346.RspBody paramRspBody, int paramInt)
  {
    paramMsgSCBody.msgBody0x346 = new MsgSCBody0x346();
    paramMsgSCBody.msgBody0x346.uMsgSubType = paramInt;
    List localList;
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("dataline.ProtocolHelper", 2, "PBToMsgSCBody : msgtype is not cmd0x346");
      }
      return;
    case 1610: 
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp = new ApplyUploadRsp();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.int32_ret_code = paramRspBody.msg_apply_upload_rsp_v2.int32_ret_code.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_ret_msg = paramRspBody.msg_apply_upload_rsp_v2.str_ret_msg.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint64_total_space = paramRspBody.msg_apply_upload_rsp_v2.uint64_total_space.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint64_used_space = paramRspBody.msg_apply_upload_rsp_v2.uint64_used_space.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint64_uploaded_size = paramRspBody.msg_apply_upload_rsp_v2.uint64_uploaded_size.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_upload_ip = paramRspBody.msg_apply_upload_rsp_v2.str_upload_ip.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_upload_domain = paramRspBody.msg_apply_upload_rsp_v2.str_upload_domain.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint32_upload_port = paramRspBody.msg_apply_upload_rsp_v2.uint32_upload_port.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bytes_uuid = paramRspBody.msg_apply_upload_rsp_v2.bytes_uuid.get().toStringUtf8();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bytes_upload_key = paramRspBody.msg_apply_upload_rsp_v2.bytes_upload_key.get().toByteArray();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bool_file_exist = paramRspBody.msg_apply_upload_rsp_v2.bool_file_exist.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint32_pack_size = paramRspBody.msg_apply_upload_rsp_v2.uint32_pack_size.get();
      localList = paramRspBody.msg_apply_upload_rsp_v2.rpt_str_uploadip_list.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.rpt_str_uploadip_list = ((String[])localList.toArray(new String[localList.size()]));
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint32_httpsvr_api_ver = paramRspBody.msg_apply_upload_rsp_v2.uint32_httpsvr_api_ver.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bytes_sha = paramRspBody.msg_apply_upload_rsp_v2.bytes_sha.get().toByteArray();
      return;
    case 1710: 
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp = new ApplyUploadRsp();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.int32_ret_code = paramRspBody.msg_apply_upload_rsp_v3.int32_ret_code.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_ret_msg = paramRspBody.msg_apply_upload_rsp_v3.str_ret_msg.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint64_total_space = paramRspBody.msg_apply_upload_rsp_v3.uint64_total_space.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint64_used_space = paramRspBody.msg_apply_upload_rsp_v3.uint64_used_space.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint64_uploaded_size = paramRspBody.msg_apply_upload_rsp_v3.uint64_uploaded_size.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_upload_ip = paramRspBody.msg_apply_upload_rsp_v3.str_upload_ip.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_upload_domain = paramRspBody.msg_apply_upload_rsp_v3.str_upload_domain.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint32_upload_port = paramRspBody.msg_apply_upload_rsp_v3.uint32_upload_port.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bytes_uuid = paramRspBody.msg_apply_upload_rsp_v3.bytes_uuid.get().toStringUtf8();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bytes_upload_key = paramRspBody.msg_apply_upload_rsp_v3.bytes_upload_key.get().toByteArray();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bool_file_exist = paramRspBody.msg_apply_upload_rsp_v3.bool_file_exist.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint32_pack_size = paramRspBody.msg_apply_upload_rsp_v3.uint32_pack_size.get();
      paramRspBody = paramRspBody.msg_apply_upload_rsp_v3.rpt_str_uploadip_list.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.rpt_str_uploadip_list = ((String[])paramRspBody.toArray(new String[paramRspBody.size()]));
      return;
    case 1810: 
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1810 = new ApplyUploadHitRsp();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1810.int32_ret_code = paramRspBody.msg_apply_upload_hit_rsp_v2.int32_ret_code.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1810.str_ret_msg = paramRspBody.msg_apply_upload_hit_rsp_v2.str_ret_msg.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1810.str_upload_ip = paramRspBody.msg_apply_upload_hit_rsp_v2.str_upload_ip.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1810.str_upload_domain = paramRspBody.msg_apply_upload_hit_rsp_v2.str_upload_domain.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1810.bytes_uuid = paramRspBody.msg_apply_upload_hit_rsp_v2.bytes_uuid.get().toByteArray();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1810.bytes_upload_key = paramRspBody.msg_apply_upload_hit_rsp_v2.bytes_upload_key.get().toByteArray();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1810.uint64_total_space = paramRspBody.msg_apply_upload_hit_rsp_v2.uint64_total_space.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1810.uint64_used_space = paramRspBody.msg_apply_upload_hit_rsp_v2.uint64_used_space.get();
      return;
    case 1210: 
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210 = new ApplyDownloadRsp();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.int32_ret_code = paramRspBody.msg_apply_download_rsp.int32_ret_code.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.str_ret_msg = paramRspBody.msg_apply_download_rsp.str_ret_msg.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info = new DownloadInfo();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.bytes_download_key = paramRspBody.msg_apply_download_rsp.msg_download_info.bytes_download_key.get().toByteArray();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_download_ip = paramRspBody.msg_apply_download_rsp.msg_download_info.str_download_ip.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_download_domain = paramRspBody.msg_apply_download_rsp.msg_download_info.str_download_domain.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.uint32_port = paramRspBody.msg_apply_download_rsp.msg_download_info.uint32_port.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_download_url = paramRspBody.msg_apply_download_rsp.msg_download_info.str_download_url.get();
      localList = paramRspBody.msg_apply_download_rsp.msg_download_info.rpt_str_downloadip_list.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.rpt_str_downloadip_list = ((String[])localList.toArray(new String[localList.size()]));
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_cookie = paramRspBody.msg_apply_download_rsp.msg_download_info.str_cookie.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_file_info = createFileInfo(paramRspBody.msg_apply_download_rsp.msg_file_info);
      return;
    case 810: 
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_810 = new UploadSuccRsp();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_810.int32_ret_code = paramRspBody.msg_upload_succ_rsp.int32_ret_code.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_810.str_ret_msg = paramRspBody.msg_upload_succ_rsp.str_ret_msg.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_810.msg_file_info = createFileInfo(paramRspBody.msg_upload_succ_rsp.msg_file_info);
      return;
    case 910: 
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_910 = new DeleteFileRsp();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_910.int32_ret_code = paramRspBody.msg_delete_file_rsp.int32_ret_code.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_910.str_ret_msg = paramRspBody.msg_delete_file_rsp.str_ret_msg.get();
      return;
    case 1410: 
      paramMsgSCBody.msgBody0x346.fileQueryRsp = new FileQueryRsp();
      paramMsgSCBody.msgBody0x346.fileQueryRsp.int32_ret_code = paramRspBody.msg_file_query_rsp.int32_ret_code.get();
      paramMsgSCBody.msgBody0x346.fileQueryRsp.str_ret_msg = paramRspBody.msg_file_query_rsp.str_ret_msg.get();
      paramMsgSCBody.msgBody0x346.fileQueryRsp.msg_file_info = createFileInfo(paramRspBody.msg_file_query_rsp.msg_file_info);
      return;
    }
    paramMsgSCBody.msgBody0x346.applyCopyToRsp = new ApplyCopyToRsp();
    paramMsgSCBody.msgBody0x346.applyCopyToRsp.int32_ret_code = paramRspBody.msg_apply_copy_to_rsp.int32_ret_code.get();
    paramMsgSCBody.msgBody0x346.applyCopyToRsp.str_ret_msg = paramRspBody.msg_apply_copy_to_rsp.str_ret_msg.get();
    paramMsgSCBody.msgBody0x346.applyCopyToRsp.str_file_key = paramRspBody.msg_apply_copy_to_rsp.str_file_key.get();
  }
  
  public boolean FillReqBody(MsgCSBody0x346 paramMsgCSBody0x346, cmd0x346.ReqBody paramReqBody)
  {
    Object localObject;
    switch (paramMsgCSBody0x346.uMsgSubType)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("dataline.ProtocolHelper", 2, "send0x346Req, unknwon nCmdType:" + paramMsgCSBody0x346.uMsgSubType);
      }
    case 1600: 
      do
      {
        return false;
        localObject = new cmd0x346.ApplyUploadReqV2();
        paramMsgCSBody0x346 = paramMsgCSBody0x346.pMsgBody0x346_uploadReq;
      } while (paramMsgCSBody0x346 == null);
      ((cmd0x346.ApplyUploadReqV2)localObject).uint64_sender_uin.set(paramMsgCSBody0x346.uint64_sender_uin);
      ((cmd0x346.ApplyUploadReqV2)localObject).uint64_recver_uin.set(paramMsgCSBody0x346.uint64_recver_uin);
      ((cmd0x346.ApplyUploadReqV2)localObject).uint64_file_size.set(paramMsgCSBody0x346.uint64_file_size);
      ((cmd0x346.ApplyUploadReqV2)localObject).str_file_name.set(paramMsgCSBody0x346.str_file_name);
      ((cmd0x346.ApplyUploadReqV2)localObject).bytes_10m_md5.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.bytes_10m_md5));
      ((cmd0x346.ApplyUploadReqV2)localObject).bytes_3sha.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.bytes_sha));
      ((cmd0x346.ApplyUploadReqV2)localObject).str_local_filepath.set(paramMsgCSBody0x346.str_local_filepath);
      ((cmd0x346.ApplyUploadReqV2)localObject).uint32_danger_level.set(paramMsgCSBody0x346.uint32_danger_level);
      ((cmd0x346.ApplyUploadReqV2)localObject).uint64_total_space.set(paramMsgCSBody0x346.uint64_total_space);
      paramReqBody.msg_apply_upload_req_v2.set((MessageMicro)localObject);
    }
    for (;;)
    {
      return true;
      localObject = new cmd0x346.ApplyUploadReqV3();
      paramMsgCSBody0x346 = paramMsgCSBody0x346.pMsgBody0x346_uploadReq;
      if (paramMsgCSBody0x346 == null) {
        break;
      }
      ((cmd0x346.ApplyUploadReqV3)localObject).uint64_sender_uin.set(paramMsgCSBody0x346.uint64_sender_uin);
      ((cmd0x346.ApplyUploadReqV3)localObject).uint64_recver_uin.set(paramMsgCSBody0x346.uint64_recver_uin);
      ((cmd0x346.ApplyUploadReqV3)localObject).uint64_file_size.set(paramMsgCSBody0x346.uint64_file_size);
      ((cmd0x346.ApplyUploadReqV3)localObject).str_file_name.set(paramMsgCSBody0x346.str_file_name);
      ((cmd0x346.ApplyUploadReqV3)localObject).bytes_10m_md5.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.bytes_10m_md5));
      ((cmd0x346.ApplyUploadReqV3)localObject).bytes_sha.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.bytes_sha));
      ((cmd0x346.ApplyUploadReqV3)localObject).str_local_filepath.set(paramMsgCSBody0x346.str_local_filepath);
      ((cmd0x346.ApplyUploadReqV3)localObject).uint32_danger_level.set(paramMsgCSBody0x346.uint32_danger_level);
      ((cmd0x346.ApplyUploadReqV3)localObject).uint64_total_space.set(paramMsgCSBody0x346.uint64_total_space);
      paramReqBody.msg_apply_upload_req_v3.set((MessageMicro)localObject);
      continue;
      localObject = new cmd0x346.ApplyUploadHitReqV2();
      paramMsgCSBody0x346 = paramMsgCSBody0x346.pMsgBody0x346_1800;
      if (paramMsgCSBody0x346 == null) {
        break;
      }
      ((cmd0x346.ApplyUploadHitReqV2)localObject).uint64_sender_uin.set(paramMsgCSBody0x346.uint64_sender_uin);
      ((cmd0x346.ApplyUploadHitReqV2)localObject).uint64_recver_uin.set(paramMsgCSBody0x346.uint64_recver_uin);
      ((cmd0x346.ApplyUploadHitReqV2)localObject).uint64_file_size.set(paramMsgCSBody0x346.uint64_file_size);
      ((cmd0x346.ApplyUploadHitReqV2)localObject).str_file_name.set(paramMsgCSBody0x346.str_file_name);
      ((cmd0x346.ApplyUploadHitReqV2)localObject).bytes_10m_md5.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.bytes_10m_md5));
      ((cmd0x346.ApplyUploadHitReqV2)localObject).bytes_3sha.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.bytes_3sha));
      ((cmd0x346.ApplyUploadHitReqV2)localObject).bytes_sha.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.bytes_sha));
      ((cmd0x346.ApplyUploadHitReqV2)localObject).str_local_filepath.set(paramMsgCSBody0x346.str_local_filepath);
      ((cmd0x346.ApplyUploadHitReqV2)localObject).uint32_danger_level.set(paramMsgCSBody0x346.uint32_danger_level);
      ((cmd0x346.ApplyUploadHitReqV2)localObject).uint64_total_space.set(paramMsgCSBody0x346.uint64_total_space);
      paramReqBody.msg_apply_upload_hit_req_v2.set((MessageMicro)localObject);
      continue;
      localObject = new cmd0x346.ApplyDownloadReq();
      paramMsgCSBody0x346 = paramMsgCSBody0x346.pMsgBody0x346_1200;
      if (paramMsgCSBody0x346 == null) {
        break;
      }
      ((cmd0x346.ApplyDownloadReq)localObject).uint64_uin.set(paramMsgCSBody0x346.uint64_uin);
      ((cmd0x346.ApplyDownloadReq)localObject).bytes_uuid.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.bytes_uuid));
      if (paramMsgCSBody0x346.uint32_ext_uintype != 0) {
        ((cmd0x346.ApplyDownloadReq)localObject).uint32_ext_uintype.set(paramMsgCSBody0x346.uint32_ext_uintype);
      }
      if (paramMsgCSBody0x346.uint32_ext_uintype == 1) {
        ((cmd0x346.ApplyDownloadReq)localObject).uint32_owner_type.set(1);
      }
      for (;;)
      {
        paramReqBody.msg_apply_download_req.set((MessageMicro)localObject);
        break;
        ((cmd0x346.ApplyDownloadReq)localObject).uint32_owner_type.set(2);
      }
      paramReqBody.msg_upload_succ_req.setHasFlag(true);
      paramReqBody.msg_upload_succ_req.uint64_sender_uin.set(paramMsgCSBody0x346.pMsgBody0x346_800.uint64_sender_uin);
      paramReqBody.msg_upload_succ_req.uint64_recver_uin.set(paramMsgCSBody0x346.pMsgBody0x346_800.uint64_recver_uin);
      if (paramMsgCSBody0x346.pMsgBody0x346_800.bytes_uuid != null)
      {
        paramReqBody.msg_upload_succ_req.bytes_uuid.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.pMsgBody0x346_800.bytes_uuid.getBytes()));
        continue;
        paramReqBody.msg_delete_file_req.setHasFlag(true);
        paramReqBody.msg_delete_file_req.uint64_uin.set(paramMsgCSBody0x346.pMsgBody0x346_900.uint64_uin);
        paramReqBody.msg_delete_file_req.uint64_peer_uin.set(paramMsgCSBody0x346.pMsgBody0x346_900.uint64_peer_uin);
        paramReqBody.msg_delete_file_req.uint32_delete_type.set(paramMsgCSBody0x346.pMsgBody0x346_900.uint32_delete_type);
        if (paramMsgCSBody0x346.pMsgBody0x346_900.bytes_uuid != null)
        {
          paramReqBody.msg_delete_file_req.bytes_uuid.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.pMsgBody0x346_900.bytes_uuid.getBytes()));
          continue;
          paramReqBody.msg_file_query_req.setHasFlag(true);
          paramReqBody.msg_file_query_req.uint64_uin.set(paramMsgCSBody0x346.fileQueryReq.uint64_uin);
          if (paramMsgCSBody0x346.fileQueryReq.bytes_uuid != null)
          {
            paramReqBody.msg_file_query_req.bytes_uuid.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.fileQueryReq.bytes_uuid));
            continue;
            paramReqBody.msg_apply_copy_to_req.setHasFlag(true);
            paramReqBody.msg_apply_copy_to_req.uint64_dst_id.set(paramMsgCSBody0x346.applyCopyToReq.uint64_dst_id);
            paramReqBody.msg_apply_copy_to_req.uint64_dst_uin.set(paramMsgCSBody0x346.applyCopyToReq.uint64_dst_uin);
            paramReqBody.msg_apply_copy_to_req.uint32_dst_svcid.set(paramMsgCSBody0x346.applyCopyToReq.uint32_dst_svcid);
            paramReqBody.msg_apply_copy_to_req.uint64_src_uin.set(paramMsgCSBody0x346.applyCopyToReq.uint64_src_uin);
            paramReqBody.msg_apply_copy_to_req.uint64_file_size.set(paramMsgCSBody0x346.applyCopyToReq.uint64_file_size);
            paramReqBody.msg_apply_copy_to_req.str_file_name.set(paramMsgCSBody0x346.applyCopyToReq.str_file_name);
            paramReqBody.msg_apply_copy_to_req.str_local_filepath.set(paramMsgCSBody0x346.applyCopyToReq.str_local_filepath);
            paramReqBody.msg_apply_copy_to_req.bytes_uuid.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.applyCopyToReq.bytes_uuid));
          }
        }
      }
    }
  }
  
  public long GetSelfUin()
  {
    if (this.mUinType == 0) {
      return Long.valueOf(this.mApp.a()).longValue();
    }
    if (this.mUinType == 1) {
      return ((SmartDeviceProxyMgr)((QQAppInterface)this.mApp).a(53)).a();
    }
    return 0L;
  }
  
  public SubMsgType0x7.MsgBody MsgBodyFromFTNNotify(FTNNotify paramFTNNotify, long paramLong)
  {
    Object localObject = FixImageFileExtName(paramFTNNotify.str_file_name, paramFTNNotify.str_file_name, paramFTNNotify.uint32_originfiletype, false);
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    localMsgBody.uint32_sub_cmd.set(1);
    fillMsgHeader(localMsgBody.msg_header, paramLong);
    SubMsgType0x7.MsgBody.FTNNotify localFTNNotify = new SubMsgType0x7.MsgBody.FTNNotify();
    localFTNNotify.uint64_sessionid.set(paramFTNNotify.uint64_sessionid);
    localFTNNotify.str_file_name.set((String)localObject);
    localFTNNotify.str_file_index.set(paramFTNNotify.str_file_index);
    localFTNNotify.bytes_file_md5.set(ByteStringMicro.copyFrom(paramFTNNotify.bytes_file_md5));
    localFTNNotify.uint64_file_len.set(paramFTNNotify.uint64_file_len);
    if (paramFTNNotify.bytes_originfile_md5 != null) {
      localFTNNotify.bytes_originfile_md5.set(ByteStringMicro.copyFrom(paramFTNNotify.bytes_originfile_md5));
    }
    localFTNNotify.uint32_originfiletype.set(paramFTNNotify.uint32_originfiletype);
    localFTNNotify.uint32_batchID.set(paramFTNNotify.uint32_batchID);
    if (paramFTNNotify.uint32_group_size > 1)
    {
      localFTNNotify.uint32_group_id.set(paramFTNNotify.uint32_group_id);
      localFTNNotify.uint32_group_size.set(paramFTNNotify.uint32_group_size);
      localFTNNotify.uint32_group_curindex.set(paramFTNNotify.uint32_group_curindex);
      localFTNNotify.uint32_groupflag.set(paramFTNNotify.uint32_groupflag);
    }
    localObject = new SubMsgType0x7.MsgBody.ActionInfo();
    ((SubMsgType0x7.MsgBody.ActionInfo)localObject).str_service_name.set(paramFTNNotify.msg_ActionInfo.strServiceName);
    if (paramFTNNotify.msg_ActionInfo.vServiceInfo != null) {
      ((SubMsgType0x7.MsgBody.ActionInfo)localObject).bytes_buf.set(ByteStringMicro.copyFrom(paramFTNNotify.msg_ActionInfo.vServiceInfo));
    }
    ((SubMsgType0x7.MsgBody.ActionInfo)localObject).setHasFlag(true);
    localFTNNotify.msg_ActionInfo.set((MessageMicro)localObject);
    localFTNNotify.setHasFlag(true);
    localMsgBody.rpt_msg_subcmd_0x1_ftn_notify.add(localFTNNotify);
    localMsgBody.setHasFlag(true);
    return localMsgBody;
  }
  
  public SubMsgType0x7.MsgBody MsgBodyFromFileControl(FileControl paramFileControl, long paramLong)
  {
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    localMsgBody.uint32_sub_cmd.set(3);
    fillMsgHeader(localMsgBody.msg_header, paramLong);
    SubMsgType0x7.MsgBody.FileControl localFileControl = new SubMsgType0x7.MsgBody.FileControl();
    localFileControl.uint64_sessionid.set(paramFileControl.uint64_sessionid);
    localFileControl.uint32_operate.set(paramFileControl.uint32_operate);
    localFileControl.uint32_seq.set(paramFileControl.uint32_seq);
    localFileControl.uint32_group_id.set(paramFileControl.uint32_group_id);
    localFileControl.uint32_batchID.set(paramFileControl.uint32_batchID);
    if ((paramFileControl.str_msg != null) && (paramFileControl.str_msg.length() != 0)) {
      localFileControl.str_msg.set(paramFileControl.str_msg);
    }
    localFileControl.setHasFlag(true);
    localMsgBody.rpt_msg_subcmd_0x3_filecontrol.add(localFileControl);
    localMsgBody.setHasFlag(true);
    return localMsgBody;
  }
  
  public SubMsgType0x7.MsgBody MsgBodyFromMpFileNotify(long paramLong1, long paramLong2, int paramInt)
  {
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    localMsgBody.uint32_sub_cmd.set(11);
    fillMsgHeader(localMsgBody.msg_header, paramLong1);
    SubMsgType0x7.MsgBody.MpFileNotify localMpFileNotify = new SubMsgType0x7.MsgBody.MpFileNotify();
    localMpFileNotify.uint64_sessionid.set(paramLong2);
    localMpFileNotify.uint32_operate.set(paramInt);
    localMpFileNotify.uint32_type.set(1);
    localMpFileNotify.setHasFlag(true);
    localMsgBody.rpt_msg_subcmd_0xb_mpfile_notify.add(localMpFileNotify);
    localMsgBody.setHasFlag(true);
    return localMsgBody;
  }
  
  public SubMsgType0x7.MsgBody MsgBodyFromNFCNotify(NFCNotify paramNFCNotify, long paramLong)
  {
    Object localObject1 = paramNFCNotify.str_file_name;
    Object localObject2 = paramNFCNotify.str_file_name;
    int i = paramNFCNotify.uint32_originfiletype;
    if (paramNFCNotify.bytes_originfile_md5 == null) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject3 = FixImageFileExtName((String)localObject1, (String)localObject2, i, bool);
      localObject1 = new SubMsgType0x7.MsgBody();
      ((SubMsgType0x7.MsgBody)localObject1).uint32_sub_cmd.set(2);
      fillMsgHeader(((SubMsgType0x7.MsgBody)localObject1).msg_header, paramLong);
      localObject2 = new SubMsgType0x7.MsgBody.NFCNotify();
      ((SubMsgType0x7.MsgBody.NFCNotify)localObject2).uint64_sessionid.set(paramNFCNotify.uint64_sessionid);
      ((SubMsgType0x7.MsgBody.NFCNotify)localObject2).str_file_name.set((String)localObject3);
      if (paramNFCNotify.bytes_file_md5 != null) {
        ((SubMsgType0x7.MsgBody.NFCNotify)localObject2).bytes_file_md5.set(ByteStringMicro.copyFrom(paramNFCNotify.bytes_file_md5));
      }
      ((SubMsgType0x7.MsgBody.NFCNotify)localObject2).fixed32_ip.set(paramNFCNotify.fixed32_ip);
      ((SubMsgType0x7.MsgBody.NFCNotify)localObject2).uint32_port.set(paramNFCNotify.uint32_port);
      ((SubMsgType0x7.MsgBody.NFCNotify)localObject2).bytes_url_notify.set(ByteStringMicro.copyFrom(paramNFCNotify.bytes_url_notify));
      ((SubMsgType0x7.MsgBody.NFCNotify)localObject2).bytes_tokenkey.set(ByteStringMicro.copyFrom("1234567890123456".getBytes()));
      ((SubMsgType0x7.MsgBody.NFCNotify)localObject2).uint64_file_len.set(paramNFCNotify.uint64_file_len);
      if (paramNFCNotify.bytes_originfile_md5 != null) {
        ((SubMsgType0x7.MsgBody.NFCNotify)localObject2).bytes_originfile_md5.set(ByteStringMicro.copyFrom(paramNFCNotify.bytes_originfile_md5));
      }
      ((SubMsgType0x7.MsgBody.NFCNotify)localObject2).uint32_originfiletype.set(paramNFCNotify.uint32_originfiletype);
      ((SubMsgType0x7.MsgBody.NFCNotify)localObject2).uint32_batchID.set(paramNFCNotify.uint32_batchID);
      if (paramNFCNotify.uint32_group_size > 1)
      {
        ((SubMsgType0x7.MsgBody.NFCNotify)localObject2).uint32_group_id.set(paramNFCNotify.uint32_group_id);
        ((SubMsgType0x7.MsgBody.NFCNotify)localObject2).uint32_group_size.set(paramNFCNotify.uint32_group_size);
        ((SubMsgType0x7.MsgBody.NFCNotify)localObject2).uint32_group_curindex.set(paramNFCNotify.uint32_group_curindex);
        ((SubMsgType0x7.MsgBody.NFCNotify)localObject2).uint32_groupflag.set(paramNFCNotify.uint32_groupflag);
      }
      localObject3 = new SubMsgType0x7.MsgBody.ActionInfo();
      ((SubMsgType0x7.MsgBody.ActionInfo)localObject3).str_service_name.set(paramNFCNotify.msg_ActionInfo.strServiceName);
      if (paramNFCNotify.msg_ActionInfo.vServiceInfo != null) {
        ((SubMsgType0x7.MsgBody.ActionInfo)localObject3).bytes_buf.set(ByteStringMicro.copyFrom(paramNFCNotify.msg_ActionInfo.vServiceInfo));
      }
      ((SubMsgType0x7.MsgBody.ActionInfo)localObject3).setHasFlag(true);
      ((SubMsgType0x7.MsgBody.NFCNotify)localObject2).msg_ActionInfo.set((MessageMicro)localObject3);
      ((SubMsgType0x7.MsgBody.NFCNotify)localObject2).setHasFlag(true);
      ((SubMsgType0x7.MsgBody)localObject1).rpt_msg_subcmd_0x2_nfc_notify.add((MessageMicro)localObject2);
      ((SubMsgType0x7.MsgBody)localObject1).setHasFlag(true);
      return localObject1;
    }
  }
  
  public MsgCSBody MsgCSBodyFromFTNNotify(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList, boolean paramBoolean)
  {
    MsgCSBody localMsgCSBody = new MsgCSBody();
    localMsgCSBody.uMsgType = 529;
    localMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
    localMsgCSBody.msgBody0x211.uMsgSubType = 7;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = new MsgHeader();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_app_id = paramMsgHeader.uint32_src_app_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_inst_id = paramMsgHeader.uint32_src_inst_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_app_id = paramMsgHeader.uint32_dst_app_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_inst_id = paramMsgHeader.uint32_dst_inst_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint64_dst_uin = paramMsgHeader.uint64_dst_uin.get();
    Object localObject = localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader;
    long l;
    label232:
    SubMsgType0x7.MsgBody.FTNNotify localFTNNotify;
    label280:
    FTNNotify localFTNNotify1;
    if (paramMsgHeader.uint64_src_uin.has())
    {
      l = paramMsgHeader.uint64_src_uin.get();
      ((MsgHeader)localObject).uint64_src_uin = l;
      localObject = new ArrayList();
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        localFTNNotify = (SubMsgType0x7.MsgBody.FTNNotify)paramList.next();
      } while (!localFTNNotify.uint64_sessionid.has());
      paramMsgHeader = localMsgCSBody.msgBody0x211.msgBody0x211_0x7;
      if (!paramBoolean) {
        break label796;
      }
      i = 9;
      paramMsgHeader.uMsgSubCmd = i;
      localFTNNotify1 = new FTNNotify();
      localFTNNotify1.uint64_sessionid = localFTNNotify.uint64_sessionid.get();
      localFTNNotify1.str_file_name = localFTNNotify.str_file_name.get();
      localFTNNotify1.str_file_index = localFTNNotify.str_file_index.get();
      localFTNNotify1.bytes_file_md5 = localFTNNotify.bytes_file_md5.get().toByteArray();
      localFTNNotify1.uint64_file_len = localFTNNotify.uint64_file_len.get();
      if (!paramBoolean) {
        break label802;
      }
      paramMsgHeader = null;
      label369:
      localFTNNotify1.bytes_originfile_md5 = paramMsgHeader;
      localFTNNotify1.uint32_originfiletype = localFTNNotify.uint32_originfiletype.get();
      if (!localFTNNotify.uint32_group_id.has()) {
        break label817;
      }
      i = localFTNNotify.uint32_group_id.get();
      label409:
      localFTNNotify1.uint32_group_id = i;
      if (!localFTNNotify.uint32_group_size.has()) {
        break label823;
      }
      i = localFTNNotify.uint32_group_size.get();
      label437:
      localFTNNotify1.uint32_group_size = i;
      if (!localFTNNotify.uint32_group_curindex.has()) {
        break label829;
      }
      i = localFTNNotify.uint32_group_curindex.get();
      label465:
      localFTNNotify1.uint32_group_curindex = i;
      localFTNNotify1.msg_ActionInfo = new ActionInfo();
      ActionInfo localActionInfo = localFTNNotify1.msg_ActionInfo;
      if (!localFTNNotify.msg_ActionInfo.has()) {
        break label835;
      }
      paramMsgHeader = ((SubMsgType0x7.MsgBody.ActionInfo)localFTNNotify.msg_ActionInfo.get()).str_service_name.get();
      label520:
      localActionInfo.strServiceName = paramMsgHeader;
      localActionInfo = localFTNNotify1.msg_ActionInfo;
      if (!localFTNNotify.msg_ActionInfo.has()) {
        break label840;
      }
      paramMsgHeader = ((SubMsgType0x7.MsgBody.ActionInfo)localFTNNotify.msg_ActionInfo.get()).bytes_buf.get().toByteArray();
      label565:
      localActionInfo.vServiceInfo = paramMsgHeader;
      if (!localFTNNotify.uint32_batchID.has()) {
        break label845;
      }
      i = localFTNNotify.uint32_batchID.get();
      label592:
      localFTNNotify1.uint32_batchID = i;
      if (!localFTNNotify.uint32_groupflag.has()) {
        break label851;
      }
    }
    label796:
    label802:
    label817:
    label823:
    label829:
    label835:
    label840:
    label845:
    label851:
    for (int i = localFTNNotify.uint32_groupflag.get();; i = 0)
    {
      localFTNNotify1.uint32_groupflag = i;
      ((List)localObject).add(localFTNNotify1);
      if (!QLog.isColorLevel()) {
        break label232;
      }
      QLog.d("dataline.ProtocolHelper", 2, "onFileComing0x211_0x1_0x9, 中转信令[" + paramBoolean + "]; sessionid[" + localFTNNotify1.uint64_sessionid + "]; curindex[" + localFTNNotify1.uint32_group_curindex + "]; group_id[" + localFTNNotify1.uint32_group_id + "]; group_size[" + localFTNNotify1.uint32_group_size + "]; batchID[" + localFTNNotify1.uint32_batchID + "]; groupflag[" + localFTNNotify1.uint32_groupflag + "]; file_name[" + localFTNNotify1.str_file_name + "]; file_len[" + localFTNNotify1.uint64_file_len + "];");
      break label232;
      l = 0L;
      break;
      i = 1;
      break label280;
      paramMsgHeader = localFTNNotify.bytes_originfile_md5.get().toByteArray();
      break label369;
      i = 0;
      break label409;
      i = 0;
      break label437;
      i = 0;
      break label465;
      paramMsgHeader = null;
      break label520;
      paramMsgHeader = null;
      break label565;
      i = 0;
      break label592;
    }
    if (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd == 9) {
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb = ((FTNNotify[])((List)localObject).toArray(new FTNNotify[((List)localObject).size()]));
    }
    while (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd != 1) {
      return localMsgCSBody;
    }
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc = ((FTNNotify[])((List)localObject).toArray(new FTNNotify[((List)localObject).size()]));
    return localMsgCSBody;
  }
  
  public MsgCSBody MsgCSBodyFromFTNNotify_0x210(long paramLong1, long paramLong2, long paramLong3, String paramString1, long paramLong4, byte[] paramArrayOfByte1, String paramString2, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong5, long paramLong6, long paramLong7, boolean paramBoolean)
  {
    MsgCSBody localMsgCSBody = new MsgCSBody();
    localMsgCSBody.uMsgType = 529;
    localMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
    localMsgCSBody.msgBody0x211.uMsgSubType = 7;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = msgHeader(GetSelfUin());
    ArrayList localArrayList = new ArrayList();
    Object localObject = localMsgCSBody.msgBody0x211.msgBody0x211_0x7;
    int i;
    if (paramArrayOfByte2 == null)
    {
      i = 9;
      ((MsgCSBody0x211_0x7)localObject).uMsgSubCmd = i;
      localObject = new FTNNotify();
      ((FTNNotify)localObject).uint64_sessionid = paramLong1;
      ((FTNNotify)localObject).str_file_name = paramString1;
      ((FTNNotify)localObject).str_file_index = paramString2;
      ((FTNNotify)localObject).bytes_file_md5 = paramArrayOfByte1;
      ((FTNNotify)localObject).uint64_file_len = paramLong4;
      ((FTNNotify)localObject).bytes_originfile_md5 = paramArrayOfByte2;
      ((FTNNotify)localObject).uint32_originfiletype = ((int)paramLong2);
      ((FTNNotify)localObject).uint32_group_id = paramInt1;
      ((FTNNotify)localObject).uint32_group_size = paramInt2;
      ((FTNNotify)localObject).uint32_group_curindex = paramInt3;
      ((FTNNotify)localObject).uint32_batchID = paramInt4;
      ((FTNNotify)localObject).msg_ActionInfo = new ActionInfo();
      localArrayList.add(localObject);
      if (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd != 9) {
        break label274;
      }
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb = ((FTNNotify[])localArrayList.toArray(new FTNNotify[localArrayList.size()]));
    }
    label274:
    while (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd != 1)
    {
      return localMsgCSBody;
      i = 1;
      break;
    }
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc = ((FTNNotify[])localArrayList.toArray(new FTNNotify[localArrayList.size()]));
    return localMsgCSBody;
  }
  
  public MsgCSBody MsgCSBodyFromFileControl(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList)
  {
    MsgCSBody localMsgCSBody = new MsgCSBody();
    localMsgCSBody.uMsgType = 529;
    localMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
    localMsgCSBody.msgBody0x211.uMsgSubType = 7;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd = 3;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = new MsgHeader();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_app_id = paramMsgHeader.uint32_src_app_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_inst_id = paramMsgHeader.uint32_src_inst_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_app_id = paramMsgHeader.uint32_dst_app_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_inst_id = paramMsgHeader.uint32_dst_inst_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint64_dst_uin = paramMsgHeader.uint64_dst_uin.get();
    Object localObject = localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader;
    long l;
    label244:
    SubMsgType0x7.MsgBody.FileControl localFileControl;
    FileControl localFileControl1;
    if (paramMsgHeader.uint64_src_uin.has())
    {
      l = paramMsgHeader.uint64_src_uin.get();
      ((MsgHeader)localObject).uint64_src_uin = l;
      localObject = new ArrayList();
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        localFileControl = (SubMsgType0x7.MsgBody.FileControl)paramList.next();
      } while ((!localFileControl.uint64_sessionid.has()) || (!localFileControl.uint32_operate.has()));
      localFileControl1 = new FileControl();
      localFileControl1.uint64_sessionid = localFileControl.uint64_sessionid.get();
      localFileControl1.uint32_operate = localFileControl.uint32_operate.get();
      if (!localFileControl.uint32_seq.has()) {
        break label594;
      }
      i = localFileControl.uint32_seq.get();
      label341:
      localFileControl1.uint32_seq = i;
      if (!localFileControl.uint32_code.has()) {
        break label599;
      }
      i = localFileControl.uint32_code.get();
      label367:
      localFileControl1.uint32_code = i;
      if (!localFileControl.str_msg.has()) {
        break label604;
      }
      paramMsgHeader = localFileControl.str_msg.get();
      label393:
      localFileControl1.str_msg = paramMsgHeader;
      if (!localFileControl.uint32_group_id.has()) {
        break label609;
      }
      i = localFileControl.uint32_group_id.get();
      label419:
      localFileControl1.uint32_group_id = i;
      if (!localFileControl.uint32_group_curindex.has()) {
        break label614;
      }
      i = localFileControl.uint32_group_curindex.get();
      label445:
      localFileControl1.uint32_group_curindex = i;
      if (!localFileControl.uint32_batchID.has()) {
        break label619;
      }
    }
    label594:
    label599:
    label604:
    label609:
    label614:
    label619:
    for (int i = localFileControl.uint32_batchID.get();; i = 0)
    {
      localFileControl1.uint32_batchID = i;
      ((List)localObject).add(localFileControl1);
      if (!QLog.isColorLevel()) {
        break label244;
      }
      QLog.d("dataline.ProtocolHelper", 2, "onFileOperate0x211, 控制信令, sessionid[" + localFileControl1.uint64_sessionid + "]; curindex[" + localFileControl1.uint32_group_curindex + "]; group_id[" + localFileControl1.uint32_group_id + "]; batchID[" + localFileControl1.uint32_batchID + "]; operate[" + localFileControl1.uint32_operate + "];");
      break label244;
      l = 0L;
      break;
      i = 0;
      break label341;
      i = 0;
      break label367;
      paramMsgHeader = null;
      break label393;
      i = 0;
      break label419;
      i = 0;
      break label445;
    }
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl = ((FileControl[])((List)localObject).toArray(new FileControl[((List)localObject).size()]));
    return localMsgCSBody;
  }
  
  public MsgCSBody MsgCSBodyFromFileControl_0x210(long paramLong1, long paramLong2, int paramInt1, int paramInt2, short paramShort)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.ProtocolHelper", 2, "uSessionID[" + paramLong1 + "]onFileOpdrate: 210  operate = " + paramLong2);
    }
    MsgCSBody localMsgCSBody = new MsgCSBody();
    localMsgCSBody.uMsgType = 529;
    localMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
    localMsgCSBody.msgBody0x211.uMsgSubType = 7;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = msgHeader(GetSelfUin());
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd = 3;
    ArrayList localArrayList = new ArrayList();
    FileControl localFileControl = new FileControl();
    localFileControl.uint64_sessionid = paramLong1;
    localFileControl.uint32_operate = ((int)paramLong2);
    localFileControl.uint32_seq = paramShort;
    localFileControl.uint32_code = 0;
    localFileControl.str_msg = null;
    localFileControl.uint32_group_id = paramInt2;
    localFileControl.uint32_group_curindex = 0;
    localFileControl.uint32_batchID = 0;
    localArrayList.add(localFileControl);
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl = ((FileControl[])localArrayList.toArray(new FileControl[localArrayList.size()]));
    return localMsgCSBody;
  }
  
  public MsgCSBody MsgCSBodyFromNFCNotify(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList, boolean paramBoolean)
  {
    MsgCSBody localMsgCSBody = new MsgCSBody();
    localMsgCSBody.uMsgType = 529;
    localMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
    localMsgCSBody.msgBody0x211.uMsgSubType = 7;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = new MsgHeader();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_app_id = paramMsgHeader.uint32_src_app_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_inst_id = paramMsgHeader.uint32_src_inst_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_app_id = paramMsgHeader.uint32_dst_app_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_inst_id = paramMsgHeader.uint32_dst_inst_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint64_dst_uin = paramMsgHeader.uint64_dst_uin.get();
    Object localObject = localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader;
    long l;
    label247:
    SubMsgType0x7.MsgBody.NFCNotify localNFCNotify;
    label295:
    NFCNotify localNFCNotify1;
    if (paramMsgHeader.uint64_src_uin.has())
    {
      l = paramMsgHeader.uint64_src_uin.get();
      ((MsgHeader)localObject).uint64_src_uin = l;
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_uin_type = 0;
      localObject = new ArrayList();
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        localNFCNotify = (SubMsgType0x7.MsgBody.NFCNotify)paramList.next();
      } while (!localNFCNotify.uint64_sessionid.has());
      paramMsgHeader = localMsgCSBody.msgBody0x211.msgBody0x211_0x7;
      if (!paramBoolean) {
        break label856;
      }
      i = 10;
      paramMsgHeader.uMsgSubCmd = i;
      localNFCNotify1 = new NFCNotify();
      localNFCNotify1.uint64_sessionid = localNFCNotify.uint64_sessionid.get();
      localNFCNotify1.str_file_name = localNFCNotify.str_file_name.get();
      localNFCNotify1.bytes_file_md5 = localNFCNotify.bytes_file_md5.get().toByteArray();
      localNFCNotify1.fixed32_ip = localNFCNotify.fixed32_ip.get();
      localNFCNotify1.uint32_port = localNFCNotify.uint32_port.get();
      localNFCNotify1.bytes_url_notify = localNFCNotify.bytes_url_notify.get().toByteArray();
      localNFCNotify1.bytes_tokenkey = localNFCNotify.bytes_tokenkey.get().toByteArray();
      localNFCNotify1.uint64_file_len = localNFCNotify.uint64_file_len.get();
      if (!paramBoolean) {
        break label862;
      }
      paramMsgHeader = null;
      label429:
      localNFCNotify1.bytes_originfile_md5 = paramMsgHeader;
      localNFCNotify1.uint32_originfiletype = localNFCNotify.uint32_originfiletype.get();
      if (!localNFCNotify.uint32_group_id.has()) {
        break label877;
      }
      i = localNFCNotify.uint32_group_id.get();
      label469:
      localNFCNotify1.uint32_group_id = i;
      if (!localNFCNotify.uint32_group_size.has()) {
        break label883;
      }
      i = localNFCNotify.uint32_group_size.get();
      label497:
      localNFCNotify1.uint32_group_size = i;
      if (!localNFCNotify.uint32_group_curindex.has()) {
        break label889;
      }
      i = localNFCNotify.uint32_group_curindex.get();
      label525:
      localNFCNotify1.uint32_group_curindex = i;
      localNFCNotify1.msg_ActionInfo = new ActionInfo();
      ActionInfo localActionInfo = localNFCNotify1.msg_ActionInfo;
      if (!localNFCNotify.msg_ActionInfo.has()) {
        break label895;
      }
      paramMsgHeader = ((SubMsgType0x7.MsgBody.ActionInfo)localNFCNotify.msg_ActionInfo.get()).str_service_name.get();
      label580:
      localActionInfo.strServiceName = paramMsgHeader;
      localActionInfo = localNFCNotify1.msg_ActionInfo;
      if (!localNFCNotify.msg_ActionInfo.has()) {
        break label900;
      }
      paramMsgHeader = ((SubMsgType0x7.MsgBody.ActionInfo)localNFCNotify.msg_ActionInfo.get()).bytes_buf.get().toByteArray();
      label625:
      localActionInfo.vServiceInfo = paramMsgHeader;
      if (!localNFCNotify.uint32_batchID.has()) {
        break label905;
      }
      i = localNFCNotify.uint32_batchID.get();
      label652:
      localNFCNotify1.uint32_batchID = i;
      if (!localNFCNotify.uint32_groupflag.has()) {
        break label911;
      }
    }
    label900:
    label905:
    label911:
    for (int i = localNFCNotify.uint32_groupflag.get();; i = 0)
    {
      localNFCNotify1.uint32_groupflag = i;
      ((List)localObject).add(localNFCNotify1);
      if (!QLog.isColorLevel()) {
        break label247;
      }
      QLog.d("dataline.ProtocolHelper", 2, "onFileComing0x211_0xa_0x2, 近场信令[" + paramBoolean + "]; sessionid[" + localNFCNotify1.uint64_sessionid + "]; curindex[" + localNFCNotify1.uint32_group_curindex + "]; group_id[" + localNFCNotify1.uint32_group_id + "]; group_size[" + localNFCNotify1.uint32_group_size + "]; batchID[" + localNFCNotify1.uint32_batchID + "]; groupflag[" + localNFCNotify1.uint32_groupflag + "]; file_name[" + localNFCNotify1.str_file_name + "]; file_len[" + localNFCNotify1.uint64_file_len + "];");
      break label247;
      l = 0L;
      break;
      label856:
      i = 2;
      break label295;
      label862:
      paramMsgHeader = localNFCNotify.bytes_originfile_md5.get().toByteArray();
      break label429;
      label877:
      i = 0;
      break label469;
      label883:
      i = 0;
      break label497;
      label889:
      i = 0;
      break label525;
      label895:
      paramMsgHeader = null;
      break label580;
      paramMsgHeader = null;
      break label625;
      i = 0;
      break label652;
    }
    if (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd == 10) {
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb = ((NFCNotify[])((List)localObject).toArray(new NFCNotify[((List)localObject).size()]));
    }
    while (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd != 2) {
      return localMsgCSBody;
    }
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc = ((NFCNotify[])((List)localObject).toArray(new NFCNotify[((List)localObject).size()]));
    return localMsgCSBody;
  }
  
  public MsgCSBody MsgCSBodyFromNFCNotify_0x210(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4, byte[] paramArrayOfByte1, long paramLong5, long paramLong6, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong7, long paramLong8, long paramLong9, boolean paramBoolean)
  {
    MsgCSBody localMsgCSBody = new MsgCSBody();
    localMsgCSBody.uMsgType = 529;
    localMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
    localMsgCSBody.msgBody0x211.uMsgSubType = 7;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = new MsgHeader();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = msgHeader(GetSelfUin());
    ArrayList localArrayList = new ArrayList();
    Object localObject = localMsgCSBody.msgBody0x211.msgBody0x211_0x7;
    int i;
    if (paramArrayOfByte4 == null)
    {
      i = 10;
      ((MsgCSBody0x211_0x7)localObject).uMsgSubCmd = i;
      localObject = new NFCNotify();
      ((NFCNotify)localObject).uint64_sessionid = paramLong1;
      ((NFCNotify)localObject).str_file_name = paramString;
      ((NFCNotify)localObject).bytes_file_md5 = paramArrayOfByte1;
      ((NFCNotify)localObject).fixed32_ip = ((int)paramLong5);
      ((NFCNotify)localObject).uint32_port = ((int)paramLong6);
      ((NFCNotify)localObject).bytes_url_notify = paramArrayOfByte2;
      ((NFCNotify)localObject).bytes_tokenkey = paramArrayOfByte3;
      ((NFCNotify)localObject).uint64_file_len = paramLong4;
      ((NFCNotify)localObject).bytes_originfile_md5 = paramArrayOfByte4;
      ((NFCNotify)localObject).uint32_originfiletype = ((int)paramLong2);
      ((NFCNotify)localObject).uint32_group_id = paramInt1;
      ((NFCNotify)localObject).uint32_group_size = paramInt2;
      ((NFCNotify)localObject).uint32_group_curindex = paramInt3;
      ((NFCNotify)localObject).uint32_batchID = paramInt4;
      ((NFCNotify)localObject).msg_ActionInfo = new ActionInfo();
      localArrayList.add(localObject);
      if (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd != 10) {
        break label315;
      }
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb = ((NFCNotify[])localArrayList.toArray(new NFCNotify[localArrayList.size()]));
    }
    label315:
    while (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd != 2)
    {
      return localMsgCSBody;
      i = 2;
      break;
    }
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc = ((NFCNotify[])localArrayList.toArray(new NFCNotify[localArrayList.size()]));
    return localMsgCSBody;
  }
  
  public MsgCSBody MsgCSBodyFromRFCInfoNotify(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList)
  {
    MsgCSBody localMsgCSBody = new MsgCSBody();
    localMsgCSBody.uMsgType = 529;
    localMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
    localMsgCSBody.msgBody0x211.uMsgSubType = 7;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = new MsgHeader();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_app_id = paramMsgHeader.uint32_src_app_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_inst_id = paramMsgHeader.uint32_src_inst_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_app_id = paramMsgHeader.uint32_dst_app_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_inst_id = paramMsgHeader.uint32_dst_inst_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint64_dst_uin = paramMsgHeader.uint64_dst_uin.get();
    Object localObject = localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader;
    if (paramMsgHeader.uint64_src_uin.has()) {}
    for (long l = paramMsgHeader.uint64_src_uin.get();; l = 0L)
    {
      ((MsgHeader)localObject).uint64_src_uin = l;
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_uin_type = 0;
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd = 8;
      paramMsgHeader = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (SubMsgType0x7.MsgBody.RNFCNotify)paramList.next();
        RFCInfoNotify localRFCInfoNotify = new RFCInfoNotify();
        localRFCInfoNotify.uSessionId = ((SubMsgType0x7.MsgBody.RNFCNotify)localObject).uint64_sessionid.get();
        localRFCInfoNotify.uServerIp = ((SubMsgType0x7.MsgBody.RNFCNotify)localObject).fixed32_ip.get();
        localRFCInfoNotify.uSvrPort = ((SubMsgType0x7.MsgBody.RNFCNotify)localObject).uint32_port.get();
        localRFCInfoNotify.vTokenKey = ((SubMsgType0x7.MsgBody.RNFCNotify)localObject).bytes_token.get().toByteArray();
        localRFCInfoNotify.uSvrTaskId = ((SubMsgType0x7.MsgBody.RNFCNotify)localObject).uint64_svrTaskId.get();
        paramMsgHeader.add(localRFCInfoNotify);
      }
    }
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x8_RFCInfoNotiy = ((RFCInfoNotify[])paramMsgHeader.toArray(new RFCInfoNotify[paramMsgHeader.size()]));
    return localMsgCSBody;
  }
  
  public void fillMsgHeader(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, long paramLong)
  {
    fillMsgHeader(paramMsgHeader, paramLong, GetSelfUin());
  }
  
  public void fillService(Session paramSession, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramSession != null) && (paramString != null) && (paramString.length() > 0))
    {
      paramSession.actionInfo = new ActionInfo();
      paramSession.actionInfo.strServiceName = paramString;
      paramSession.actionInfo.vServiceInfo = paramArrayOfByte;
    }
  }
  
  public Session genSession(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.ProtocolHelper", 2, "--->>sendFile sPath[" + paramString1 + "], sPathThumb[" + paramString2 + "], type[" + paramInt2 + "], fileFrom[" + paramInt1);
    }
    if ((paramInt1 == 0) && (paramString1 != null) && (!paramString1.equals("")))
    {
      localObject = new File(paramString1);
      if (!((File)localObject).exists())
      {
        showFileNotExistDialog(((File)localObject).getName());
        return null;
      }
      if (((File)localObject).length() == 0L)
      {
        showFileIsEmptyDialog(((File)localObject).getName());
        return null;
      }
      if (((File)localObject).length() > 4294967296L)
      {
        showFileTooLargeDialog(((File)localObject).getName());
        return null;
      }
    }
    Object localObject = new Session();
    ((Session)localObject).uSessionID = paramLong;
    ((Session)localObject).emFileFrom = paramInt1;
    ((Session)localObject).bSend = true;
    ((Session)localObject).emFileType = paramInt2;
    ((Session)localObject).uChannelType = paramInt3;
    ((Session)localObject).dwGroupID = paramInt4;
    ((Session)localObject).dwGroupSize = paramInt5;
    ((Session)localObject).dwGroupIndex = paramInt6;
    ((Session)localObject).pFileBuffer = null;
    ((Session)localObject).strFilePathSrc = paramString1;
    ((Session)localObject).strFilePathThumb = paramString2;
    return localObject;
  }
  
  public Session genSession(DataLineMsgRecord paramDataLineMsgRecord, boolean paramBoolean)
  {
    Session localSession = genSession(paramDataLineMsgRecord.fileFrom, paramDataLineMsgRecord.path, paramDataLineMsgRecord.thumbPath, DataLineHandler.d(paramDataLineMsgRecord.msgtype), 0, paramDataLineMsgRecord.sessionid, paramDataLineMsgRecord.groupId, paramDataLineMsgRecord.groupSize, paramDataLineMsgRecord.groupIndex, paramBoolean);
    if (localSession != null)
    {
      localSession.uFileSizeSrc = paramDataLineMsgRecord.filesize;
      if (paramDataLineMsgRecord.fileUuid != null) {
        localSession.vOfflineFileUUID = paramDataLineMsgRecord.fileUuid.getBytes();
      }
      if (paramDataLineMsgRecord.md5 != null) {
        localSession.vFileMD5Src = paramDataLineMsgRecord.md5;
      }
      localSession.uOwnerUin = paramDataLineMsgRecord.uOwnerUin;
    }
    return localSession;
  }
  
  boolean isMyNotify(SubMsgType0x7.MsgBody.ActionInfo paramActionInfo, String paramString)
  {
    if (paramActionInfo.str_service_name.has())
    {
      paramActionInfo = paramActionInfo.str_service_name.get();
      if ((paramActionInfo.length() > 0) && (paramActionInfo.compareToIgnoreCase(paramString) == 0)) {
        return true;
      }
    }
    return false;
  }
  
  public SubMsgType0x7.MsgBody msgBodyFromRFCInfoNotify(RFCInfoNotify paramRFCInfoNotify, long paramLong)
  {
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    fillMsgHeader(localMsgBody.msg_header, paramLong);
    localMsgBody.uint32_sub_cmd.set(8);
    SubMsgType0x7.MsgBody.RNFCNotify localRNFCNotify = new SubMsgType0x7.MsgBody.RNFCNotify();
    localRNFCNotify.uint64_sessionid.set(paramRFCInfoNotify.uSessionId);
    localRNFCNotify.bytes_token.set(ByteStringMicro.copyFrom(paramRFCInfoNotify.vTokenKey));
    localRNFCNotify.fixed32_ip.set(paramRFCInfoNotify.uServerIp);
    localRNFCNotify.uint32_port.set(paramRFCInfoNotify.uSvrPort);
    localRNFCNotify.uint64_svrTaskId.set(paramRFCInfoNotify.uSvrTaskId);
    localMsgBody.rpt_msg_subcmd_0x8_rnfc_notify.add(localRNFCNotify);
    return localMsgBody;
  }
  
  public MsgHeader msgHeader(long paramLong)
  {
    int i = AppSetting.a;
    MsgHeader localMsgHeader = new MsgHeader();
    localMsgHeader.uint32_src_app_id = 1001;
    localMsgHeader.uint32_src_inst_id = i;
    localMsgHeader.uint32_dst_app_id = 1;
    localMsgHeader.uint32_dst_inst_id = 1;
    localMsgHeader.uint64_dst_uin = paramLong;
    localMsgHeader.uint64_src_uin = GetSelfUin();
    return localMsgHeader;
  }
  
  public void showFileIsEmptyDialog(String paramString)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      FMToastUtil.a("'" + paramString + "'" + BaseApplication.getContext().getResources().getString(2131362116));
      return;
    }
    new Handler(localLooper).post(new dcg(this, paramString));
  }
  
  public void showFileNotExistDialog(String paramString)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      FMToastUtil.a("'" + paramString + "'" + BaseApplication.getContext().getResources().getString(2131362080));
      return;
    }
    new Handler(localLooper).post(new dci(this, paramString));
  }
  
  public void showFileTooLargeDialog(String paramString)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      FMToastUtil.a("'" + paramString + "'" + BaseApplication.getContext().getResources().getString(2131362118));
      return;
    }
    new Handler(localLooper).post(new dch(this, paramString));
  }
  
  public void showNoNetworkDialog()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      FMToastUtil.a(2131362120);
      return;
    }
    new Handler(localLooper).post(new dck(this));
  }
  
  public void showQQIsOfflineDialog()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      FMToastUtil.a(2131362119);
      return;
    }
    new Handler(localLooper).post(new dcj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.litetransfersdk.ProtocolHelper
 * JD-Core Version:    0.7.0.1
 */
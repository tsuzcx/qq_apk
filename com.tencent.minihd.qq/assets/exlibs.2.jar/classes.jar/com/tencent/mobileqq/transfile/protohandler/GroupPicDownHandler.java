package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.GetImgUrlReq;
import tencent.im.cs.cmd0x388.cmd0x388.GetImgUrlRsp;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.RspBody;

public class GroupPicDownHandler
  extends BaseHandler
{
  void a(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x388.ReqBody paramReqBody)
  {
    int i = 1;
    paramReqCommon = (RichProto.RichProtoReq.GroupPicDownReq)paramReqCommon;
    cmd0x388.GetImgUrlReq localGetImgUrlReq = new cmd0x388.GetImgUrlReq();
    localGetImgUrlReq.setHasFlag(true);
    localGetImgUrlReq.uint64_file_id.set(paramInt);
    localGetImgUrlReq.uint64_dst_uin.set(Long.valueOf(paramReqCommon.jdField_c_of_type_JavaLangString).longValue());
    localGetImgUrlReq.uint64_group_code.set(Long.parseLong(paramReqCommon.d));
    localGetImgUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramReqCommon.jdField_a_of_type_ArrayOfByte));
    if (paramReqCommon.jdField_a_of_type_Long != 0L) {
      localGetImgUrlReq.uint64_fileid.set(paramReqCommon.jdField_a_of_type_Long);
    }
    PBUInt32Field localPBUInt32Field;
    if (paramReqCommon.jdField_a_of_type_Int == 65537)
    {
      localGetImgUrlReq.uint32_url_flag.set(1);
      localGetImgUrlReq.uint32_url_type.set(2);
      localGetImgUrlReq.uint32_req_platform_type.set(9);
      localGetImgUrlReq.uint32_req_term.set(5);
      localGetImgUrlReq.uint32_inner_ip.set(0);
      localPBUInt32Field = localGetImgUrlReq.uint32_bu_type;
      if (paramReqCommon.jdField_c_of_type_Int != 1) {
        break label265;
      }
    }
    label265:
    for (paramInt = i;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localGetImgUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(RichMediaUtil.a()));
      paramReqBody.rpt_msg_getimg_url_req.add(localGetImgUrlReq);
      return;
      if (paramReqCommon.jdField_a_of_type_Int == 1)
      {
        localGetImgUrlReq.uint32_url_flag.set(8);
        localGetImgUrlReq.uint32_url_type.set(3);
        break;
      }
      if (paramReqCommon.jdField_a_of_type_Int != 131075) {
        break;
      }
      localGetImgUrlReq.uint32_url_flag.set(2);
      localGetImgUrlReq.uint32_url_type.set(4);
      break;
    }
  }
  
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    FromServiceMsg localFromServiceMsg = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.jdField_a_of_type_JavaLangObject;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    MessageObserver.StatictisInfo localStatictisInfo = paramProtoResp.jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject = MessageHandler.a(localFromServiceMsg);
        paramProtoReq = localFromServiceMsg.getBusinessFailMsg();
        paramProtoResp = paramProtoReq;
        if (paramProtoReq == null) {
          paramProtoResp = "";
        }
        a(-1, 9311, (String)localObject, paramProtoResp, localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      RichProtoProc.a(localRichProtoReq, localRichProtoResp);
      return;
      localObject = MessageHandler.a(localFromServiceMsg);
      paramProtoReq = localFromServiceMsg.getBusinessFailMsg();
      paramProtoResp = paramProtoReq;
      if (paramProtoReq == null) {
        paramProtoResp = "";
      }
      a(-1, 9044, (String)localObject, paramProtoResp, localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        paramProtoResp = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_getimg_url_rsp.get();
        if ((paramProtoResp != null) && (paramProtoResp.size() != 0)) {
          break label261;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramProtoResp)
      {
        a(-1, -9527, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label261:
      Iterator localIterator = paramProtoResp.iterator();
      while (localIterator.hasNext())
      {
        cmd0x388.GetImgUrlRsp localGetImgUrlRsp = (cmd0x388.GetImgUrlRsp)localIterator.next();
        for (;;)
        {
          try
          {
            localObject = (RichProto.RichProtoResp.PicDownResp)localRichProtoResp.jdField_a_of_type_JavaUtilList.get((int)localGetImgUrlRsp.uint64_file_id.get());
          }
          catch (Exception paramProtoResp)
          {
            List localList;
            localObject = null;
            continue;
            paramProtoResp = null;
            continue;
            i = 0;
            continue;
            i = 1;
            continue;
          }
          try
          {
            paramProtoResp = (RichProto.RichProtoReq.GroupPicDownReq)localRichProtoReq.jdField_a_of_type_JavaUtilList.get(0);
            if ((localObject != null) && (localFromServiceMsg != null) && (localFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp"))) {
              ((RichProto.RichProtoResp.PicDownResp)localObject).e = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
            }
            i = localGetImgUrlRsp.uint32_result.get();
            if (i != 0) {
              continue;
            }
            if (localGetImgUrlRsp.rpt_uint32_down_ip.size() <= 0) {
              continue;
            }
            if (localGetImgUrlRsp.rpt_uint32_down_port.size() > 0) {
              continue;
            }
          }
          catch (Exception paramProtoResp)
          {
            a(-1, -9527, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject);
          }
        }
        if (paramProtoResp.jdField_a_of_type_Int == 65537) {
          paramProtoResp = localGetImgUrlRsp.bytes_thumb_down_para.get().toStringUtf8();
        }
        for (;;)
        {
          ((RichProto.RichProtoResp.PicDownResp)localObject).jdField_a_of_type_JavaLangString = paramProtoResp;
          if ((paramProtoResp != null) && ((i == 0) || (localGetImgUrlRsp.bytes_down_domain.has()))) {
            break label573;
          }
          throw new Exception("no url or ip");
          break;
          if (paramProtoResp.jdField_a_of_type_Int == 1)
          {
            paramProtoResp = localGetImgUrlRsp.bytes_big_down_para.get().toStringUtf8();
          }
          else
          {
            if (paramProtoResp.jdField_a_of_type_Int != 131075) {
              break label870;
            }
            paramProtoResp = localGetImgUrlRsp.bytes_original_down_para.get().toStringUtf8();
          }
        }
        label573:
        if (i == 0)
        {
          paramProtoResp = localGetImgUrlRsp.rpt_uint32_down_ip.get();
          localList = localGetImgUrlRsp.rpt_uint32_down_port.get();
          i = 0;
          while (i < paramProtoResp.size())
          {
            ServerAddr localServerAddr = new ServerAddr();
            localServerAddr.jdField_a_of_type_JavaLangString = PkgTools.a(((Integer)paramProtoResp.get(i)).intValue() & 0xFFFFFFFF);
            localServerAddr.b = ((Integer)localList.get(i)).intValue();
            ((RichProto.RichProtoResp.PicDownResp)localObject).jdField_a_of_type_JavaUtilArrayList.add(i, localServerAddr);
            i += 1;
          }
          if (localGetImgUrlRsp.bytes_down_domain.has())
          {
            paramProtoResp = new ServerAddr();
            paramProtoResp.jdField_a_of_type_JavaLangString = localGetImgUrlRsp.bytes_down_domain.get().toStringUtf8();
            paramProtoResp.b = 80;
            ((RichProto.RichProtoResp.PicDownResp)localObject).jdField_a_of_type_JavaUtilArrayList.add(paramProtoResp);
          }
        }
        if (localGetImgUrlRsp.bytes_down_domain.has())
        {
          paramProtoResp = new ServerAddr();
          paramProtoResp.jdField_a_of_type_JavaLangString = localGetImgUrlRsp.bytes_down_domain.get().toStringUtf8();
          paramProtoResp.b = 80;
          ((RichProto.RichProtoResp.PicDownResp)localObject).jdField_a_of_type_JavaUtilArrayList.add(paramProtoResp);
          ((RichProto.RichProtoResp.PicDownResp)localObject).b = paramProtoResp.jdField_a_of_type_JavaLangString;
        }
        a(0, 0, "", "", localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject);
        continue;
        if (GroupPicUpHandler.a(i))
        {
          this.aq += 1;
          if (this.aq < 2)
          {
            localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramProtoReq);
            return;
          }
        }
        a(-1, -9527, BaseTransProcessor.a(i), "", localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject);
      }
    }
  }
  
  void a(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    localRichProtoResp.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramRichProtoReq.jdField_a_of_type_JavaUtilList.size())
    {
      RichProto.RichProtoResp.PicDownResp localPicDownResp = new RichProto.RichProtoResp.PicDownResp();
      localRichProtoResp.jdField_a_of_type_JavaUtilList.add(i, localPicDownResp);
      i += 1;
    }
  }
  
  byte[] a(List paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(2);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (RichProto.RichProtoReq.ReqCommon)paramList.get(i), localReqBody);
      i += 1;
    }
    switch (NetworkCenter.a().a())
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = NetworkCenter.a().a();
      int j = i;
      if (paramList != null)
      {
        j = i;
        if (paramList.contains("wap")) {
          j = 5;
        }
      }
      localReqBody.uint32_net_type.set(j);
      return localReqBody.toByteArray();
      i = 3;
      continue;
      i = 6;
      continue;
      i = 7;
      continue;
      i = 8;
    }
  }
  
  public void c(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.jdField_a_of_type_JavaLangString = "ImgStore.GroupPicDown";
      localProtoReq.jdField_a_of_type_ArrayOfByte = a(paramRichProtoReq.jdField_a_of_type_JavaUtilList);
      localProtoReq.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
      a(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.GroupPicDownHandler
 * JD-Core Version:    0.7.0.1
 */
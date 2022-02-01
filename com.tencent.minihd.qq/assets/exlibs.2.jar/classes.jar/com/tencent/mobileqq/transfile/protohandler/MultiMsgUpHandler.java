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
import java.util.List;
import tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyUpReq;
import tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyUpRsp;
import tencent.im.longconn.multimsg.MultiMsg.ReqBody;
import tencent.im.longconn.multimsg.MultiMsg.RspBody;

public class MultiMsgUpHandler
  extends BaseHandler
{
  int ar;
  
  public static int a(int paramInt)
  {
    int i = 3;
    switch (paramInt)
    {
    default: 
      i = 1;
    }
    return i;
  }
  
  private void a(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, MultiMsg.ReqBody paramReqBody)
  {
    paramReqCommon = (RichProto.RichProtoReq.MultiMsgUpReq)paramReqCommon;
    MultiMsg.MultiMsgApplyUpReq localMultiMsgApplyUpReq = new MultiMsg.MultiMsgApplyUpReq();
    localMultiMsgApplyUpReq.setHasFlag(true);
    localMultiMsgApplyUpReq.uint64_dst_uin.set(Long.valueOf(paramReqCommon.d).longValue());
    localMultiMsgApplyUpReq.uint64_msg_size.set(paramReqCommon.jdField_a_of_type_Long);
    localMultiMsgApplyUpReq.bytes_msg_md5.set(ByteStringMicro.copyFrom(paramReqCommon.jdField_a_of_type_ArrayOfByte));
    localMultiMsgApplyUpReq.uint32_msg_type.set(a(paramReqCommon.c));
    localMultiMsgApplyUpReq.uint32_apply_id.set(0);
    paramReqBody.rpt_multimsg_applyup_req.add(localMultiMsgApplyUpReq);
  }
  
  private byte[] a(List paramList)
  {
    int i = NetworkCenter.a().a();
    this.ar = i;
    switch (i)
    {
    default: 
      i = 255;
    }
    Object localObject;
    for (;;)
    {
      localObject = NetworkCenter.a().a();
      int j = i;
      if (localObject != null)
      {
        j = i;
        if (((String)localObject).contains("wap")) {
          j = 5;
        }
      }
      localObject = new MultiMsg.ReqBody();
      ((MultiMsg.ReqBody)localObject).setHasFlag(true);
      ((MultiMsg.ReqBody)localObject).uint32_subcmd.set(1);
      ((MultiMsg.ReqBody)localObject).uint32_term_type.set(5);
      ((MultiMsg.ReqBody)localObject).uint32_platform_type.set(9);
      ((MultiMsg.ReqBody)localObject).uint32_net_type.set(j);
      ((MultiMsg.ReqBody)localObject).bytes_build_ver.set(ByteStringMicro.copyFromUtf8(RichMediaUtil.a()));
      i = 0;
      while (i < paramList.size())
      {
        a(i, (RichProto.RichProtoReq.ReqCommon)paramList.get(i), (MultiMsg.ReqBody)localObject);
        i += 1;
      }
      i = 3;
      continue;
      i = 6;
      continue;
      i = 7;
      continue;
      i = 8;
    }
    return ((MultiMsg.ReqBody)localObject).toByteArray();
  }
  
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    localObject1 = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte1 = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.jdField_a_of_type_JavaLangObject;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    MessageObserver.StatictisInfo localStatictisInfo = paramProtoResp.jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo;
    if (((FromServiceMsg)localObject1).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject1).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.a((FromServiceMsg)localObject1), "", localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
    }
    List localList;
    for (;;)
    {
      RichProtoProc.a(localRichProtoReq, localRichProtoResp);
      return;
      a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject1), "", localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        localList = ((MultiMsg.RspBody)new MultiMsg.RspBody().mergeFrom(arrayOfByte1)).rpt_multimsg_applyup_rsp.get();
        if ((localList != null) && (localList.size() != 0)) {
          break;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramProtoResp)
      {
        a(-1, -9527, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte1), localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
    }
    int i = 0;
    label230:
    if (i < localList.size()) {
      paramProtoResp = (MultiMsg.MultiMsgApplyUpRsp)localList.get(i);
    }
    try
    {
      localObject1 = (RichProto.RichProtoResp.MultiMsgUpResp)localRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
      try
      {
        j = paramProtoResp.uint32_result.get();
        if (j != 0) {
          break label776;
        }
        if (paramProtoResp.bytes_msg_resid.has()) {
          break label362;
        }
        throw new Exception("bytes_msg_resid NOT exists");
      }
      catch (Exception paramProtoResp) {}
    }
    catch (Exception paramProtoResp)
    {
      for (;;)
      {
        localObject1 = null;
        continue;
        int j = 0;
      }
    }
    a(-1, -9527, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte1), localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject1);
    for (;;)
    {
      i += 1;
      break label230;
      break;
      label362:
      Object localObject2 = paramProtoResp.bytes_msg_resid.get().toByteArray();
      if ((localObject2 == null) || (localObject2.length <= 0)) {
        throw new Exception("resid_bs == null || empty");
      }
      if (!paramProtoResp.bytes_msg_ukey.has()) {
        throw new Exception("bytes_msg_ukey NOT exists");
      }
      Object localObject3 = paramProtoResp.bytes_msg_ukey.get().toByteArray();
      if ((localObject3 == null) || (localObject3.length <= 0)) {
        throw new Exception("ukey_bs == null || empty");
      }
      if (!paramProtoResp.bytes_msg_key.has()) {
        throw new Exception("bytes_msg_key NOT exists");
      }
      Object localObject4 = paramProtoResp.bytes_msg_key.get().toByteArray();
      if ((localObject4 == null) || (localObject4.length <= 0)) {
        throw new Exception("msgkey_bs == null || empty");
      }
      if (!paramProtoResp.bytes_msg_sig.has()) {
        throw new Exception("bytes_msg_sig NOT exists");
      }
      byte[] arrayOfByte2 = paramProtoResp.bytes_msg_sig.get().toByteArray();
      if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
        throw new Exception("msgsig_bs == null || empty");
      }
      ((RichProto.RichProtoResp.MultiMsgUpResp)localObject1).jdField_a_of_type_ArrayOfByte = ((byte[])localObject2);
      ((RichProto.RichProtoResp.MultiMsgUpResp)localObject1).jdField_b_of_type_ArrayOfByte = ((byte[])localObject3);
      ((RichProto.RichProtoResp.MultiMsgUpResp)localObject1).c = ((byte[])localObject4);
      ((RichProto.RichProtoResp.MultiMsgUpResp)localObject1).d = arrayOfByte2;
      localObject2 = paramProtoResp.rpt_uint32_up_ip.get();
      localObject3 = paramProtoResp.rpt_uint32_up_port.get();
      if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
        break label842;
      }
      throw new Exception("check iplist");
      while (j < ((List)localObject2).size())
      {
        long l1 = ((Integer)((List)localObject2).get(j)).intValue();
        long l2 = ((Integer)((List)localObject3).get(j)).intValue();
        localObject4 = new ServerAddr();
        ((ServerAddr)localObject4).jdField_a_of_type_JavaLangString = PkgTools.a(l1 & 0xFFFFFFFF);
        ((ServerAddr)localObject4).jdField_b_of_type_Int = ((int)l2);
        ((RichProto.RichProtoResp.MultiMsgUpResp)localObject1).jdField_a_of_type_JavaUtilArrayList.add(j, localObject4);
        j += 1;
      }
      ((RichProto.RichProtoResp.MultiMsgUpResp)localObject1).jdField_a_of_type_Int = ((int)paramProtoResp.uint64_block_size.get());
      ((RichProto.RichProtoResp.MultiMsgUpResp)localObject1).jdField_b_of_type_Int = ((int)paramProtoResp.uint64_up_offset.get());
      a(0, 0, "", "", localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject1);
      continue;
      label776:
      if (GroupPicUpHandler.a(j))
      {
        this.aq += 1;
        if (this.aq < 2)
        {
          localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramProtoReq);
          return;
        }
      }
      a(-1, -9527, BaseTransProcessor.a(j), "", localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject1);
    }
  }
  
  void a(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    localRichProtoResp.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramRichProtoReq.jdField_a_of_type_JavaUtilList.size())
    {
      RichProto.RichProtoResp.MultiMsgUpResp localMultiMsgUpResp = new RichProto.RichProtoResp.MultiMsgUpResp();
      localRichProtoResp.jdField_a_of_type_JavaUtilList.add(i, localMultiMsgUpResp);
      i += 1;
    }
  }
  
  public void c(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.jdField_a_of_type_JavaLangString = "MultiMsg.ApplyUp";
      localProtoReq.jdField_a_of_type_ArrayOfByte = a(paramRichProtoReq.jdField_a_of_type_JavaUtilList);
      localProtoReq.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
      a(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.MultiMsgUpHandler
 * JD-Core Version:    0.7.0.1
 */
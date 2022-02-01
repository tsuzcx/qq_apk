package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x352.cmd0x352.GetImgUrlRsp;
import tencent.im.cs.cmd0x352.cmd0x352.ReqBody;
import tencent.im.cs.cmd0x352.cmd0x352.RspBody;

public class C2CPicDownHandler
  extends BaseHandler
{
  /* Error */
  void a(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x352.ReqBody paramReqBody)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_2
    //   4: checkcast 17	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq
    //   7: astore 8
    //   9: new 19	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq
    //   12: dup
    //   13: invokespecial 20	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:<init>	()V
    //   16: astore 9
    //   18: aload 9
    //   20: iconst_1
    //   21: invokevirtual 24	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:setHasFlag	(Z)V
    //   24: aload 9
    //   26: getfield 28	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint64_src_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   29: aload 8
    //   31: getfield 32	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:c	Ljava/lang/String;
    //   34: invokestatic 38	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   37: invokevirtual 42	java/lang/Long:longValue	()J
    //   40: invokevirtual 48	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   43: aload 8
    //   45: getfield 51	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:d	Ljava/lang/String;
    //   48: astore 7
    //   50: aload 7
    //   52: astore_2
    //   53: aload 7
    //   55: ldc 53
    //   57: invokevirtual 59	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   60: ifeq +10 -> 70
    //   63: aload 7
    //   65: iconst_1
    //   66: invokevirtual 63	java/lang/String:substring	(I)Ljava/lang/String;
    //   69: astore_2
    //   70: aload_2
    //   71: invokestatic 38	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   74: invokevirtual 42	java/lang/Long:longValue	()J
    //   77: lstore 5
    //   79: aload 9
    //   81: getfield 66	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint64_dst_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   84: lload 5
    //   86: invokevirtual 48	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   89: aload 8
    //   91: getfield 68	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   94: ldc 70
    //   96: invokevirtual 74	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   99: astore_2
    //   100: aload 9
    //   102: getfield 78	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bytes_file_resid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   105: aload_2
    //   106: invokestatic 84	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   109: invokevirtual 89	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   112: aload 9
    //   114: getfield 93	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bool_address_book	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   117: aload 8
    //   119: getfield 96	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:jdField_a_of_type_Boolean	Z
    //   122: invokevirtual 100	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   125: ldc 102
    //   127: aload 8
    //   129: getfield 105	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:b	Ljava/lang/String;
    //   132: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   135: ifeq +131 -> 266
    //   138: aload 9
    //   140: getfield 113	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_src_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   143: iconst_2
    //   144: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   147: aload 9
    //   149: getfield 121	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_req_term	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   152: iconst_5
    //   153: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   156: aload 9
    //   158: getfield 93	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bool_address_book	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   161: aload 8
    //   163: getfield 96	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:jdField_a_of_type_Boolean	Z
    //   166: invokevirtual 100	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   169: aload 9
    //   171: getfield 124	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_req_platform_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   174: bipush 9
    //   176: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   179: aload 9
    //   181: getfield 127	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_bu_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   184: iconst_1
    //   185: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   188: aload 8
    //   190: getfield 130	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:jdField_a_of_type_Int	I
    //   193: istore_1
    //   194: iload_1
    //   195: ldc 131
    //   197: if_icmpne +108 -> 305
    //   200: iconst_4
    //   201: istore 4
    //   203: iconst_1
    //   204: istore_1
    //   205: aload 9
    //   207: getfield 134	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_url_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   210: iload 4
    //   212: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   215: aload 9
    //   217: getfield 137	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_url_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   220: iload_1
    //   221: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   224: aload 9
    //   226: getfield 140	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bytes_build_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   229: invokestatic 145	com/tencent/mobileqq/transfile/RichMediaUtil:a	()Ljava/lang/String;
    //   232: invokestatic 149	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   235: invokevirtual 89	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   238: aload_3
    //   239: getfield 155	tencent/im/cs/cmd0x352/cmd0x352$ReqBody:rpt_msg_getimg_url_req	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   242: aload 9
    //   244: invokevirtual 161	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   247: return
    //   248: astore_2
    //   249: aload_2
    //   250: invokevirtual 164	java/lang/Exception:printStackTrace	()V
    //   253: goto -164 -> 89
    //   256: astore_2
    //   257: aload_2
    //   258: invokevirtual 165	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   261: aconst_null
    //   262: astore_2
    //   263: goto -163 -> 100
    //   266: ldc 167
    //   268: aload 8
    //   270: getfield 105	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:b	Ljava/lang/String;
    //   273: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   276: ifeq +15 -> 291
    //   279: aload 9
    //   281: getfield 113	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_src_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   284: iconst_1
    //   285: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   288: goto -141 -> 147
    //   291: aload 9
    //   293: getfield 113	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_src_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   296: sipush 255
    //   299: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   302: goto -155 -> 147
    //   305: iload_1
    //   306: iconst_1
    //   307: if_icmpne +13 -> 320
    //   310: bipush 6
    //   312: istore 4
    //   314: bipush 8
    //   316: istore_1
    //   317: goto -112 -> 205
    //   320: iload_1
    //   321: ldc 168
    //   323: if_icmpne +12 -> 335
    //   326: bipush 16
    //   328: istore 4
    //   330: iconst_2
    //   331: istore_1
    //   332: goto -127 -> 205
    //   335: iconst_0
    //   336: istore_1
    //   337: goto -132 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	this	C2CPicDownHandler
    //   0	340	1	paramInt	int
    //   0	340	2	paramReqCommon	RichProto.RichProtoReq.ReqCommon
    //   0	340	3	paramReqBody	cmd0x352.ReqBody
    //   1	328	4	i	int
    //   77	8	5	l	long
    //   48	16	7	str	String
    //   7	262	8	localC2CPicDownReq	RichProto.RichProtoReq.C2CPicDownReq
    //   16	276	9	localGetImgUrlReq	tencent.im.cs.cmd0x352.cmd0x352.GetImgUrlReq
    // Exception table:
    //   from	to	target	type
    //   43	50	248	java/lang/Exception
    //   53	70	248	java/lang/Exception
    //   70	89	248	java/lang/Exception
    //   89	100	256	java/io/UnsupportedEncodingException
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
        localObject1 = MessageHandler.a(localFromServiceMsg);
        paramProtoReq = localFromServiceMsg.getBusinessFailMsg();
        paramProtoResp = paramProtoReq;
        if (paramProtoReq == null) {
          paramProtoResp = "";
        }
        a(-1, 9311, (String)localObject1, paramProtoResp, localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      RichProtoProc.a(localRichProtoReq, localRichProtoResp);
      return;
      localObject1 = MessageHandler.a(localFromServiceMsg);
      paramProtoReq = localFromServiceMsg.getBusinessFailMsg();
      paramProtoResp = paramProtoReq;
      if (paramProtoReq == null) {
        paramProtoResp = "";
      }
      a(-1, 9044, (String)localObject1, paramProtoResp, localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        paramProtoResp = ((cmd0x352.RspBody)new cmd0x352.RspBody().mergeFrom(arrayOfByte)).rpt_msg_getimg_url_rsp.get();
        if ((paramProtoResp != null) && (paramProtoResp.size() != 0)) {
          break label262;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramProtoResp)
      {
        a(-1, -9527, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label262:
      Iterator localIterator = paramProtoResp.iterator();
      while (localIterator.hasNext())
      {
        cmd0x352.GetImgUrlRsp localGetImgUrlRsp = (cmd0x352.GetImgUrlRsp)localIterator.next();
        for (;;)
        {
          try
          {
            localPicDownResp = (RichProto.RichProtoResp.PicDownResp)localRichProtoResp.jdField_a_of_type_JavaUtilList.get(0);
          }
          catch (Exception paramProtoResp)
          {
            RichProto.RichProtoResp.PicDownResp localPicDownResp;
            RichProto.RichProtoReq.C2CPicDownReq localC2CPicDownReq;
            localObject1 = null;
            continue;
            paramProtoResp = null;
            continue;
            i = 0;
            continue;
            i = 1;
            continue;
            if (localObject1 != null) {
              continue;
            }
            localObject1 = null;
            if (localObject2 != null) {
              continue;
            }
            Object localObject2 = null;
            continue;
            if (paramProtoResp != null) {
              continue;
            }
            continue;
          }
          try
          {
            localC2CPicDownReq = (RichProto.RichProtoReq.C2CPicDownReq)localRichProtoReq.jdField_a_of_type_JavaUtilList.get(0);
            if ((localPicDownResp != null) && (localFromServiceMsg != null) && (localFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp"))) {
              localPicDownResp.e = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
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
            localObject1 = localPicDownResp;
            a(-1, -9527, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject1);
          }
        }
        paramProtoResp = localGetImgUrlRsp.bytes_thumb_down_para.get();
        localObject1 = localGetImgUrlRsp.bytes_original_down_para.get();
        localObject2 = localGetImgUrlRsp.bytes_big_down_para.get();
        if (paramProtoResp == null)
        {
          paramProtoResp = null;
          break label872;
          label447:
          if (localC2CPicDownReq.jdField_a_of_type_Int != 65537) {
            break label573;
          }
        }
        for (;;)
        {
          if ((i == 0) || (localGetImgUrlRsp.bytes_down_domain.has())) {
            break label891;
          }
          throw new Exception("no ip");
          break;
          paramProtoResp = paramProtoResp.toStringUtf8();
          break label872;
          localObject1 = ((ByteStringMicro)localObject1).toStringUtf8();
          break label880;
          localObject2 = ((ByteStringMicro)localObject2).toStringUtf8();
          break label447;
          label573:
          if (localC2CPicDownReq.jdField_a_of_type_Int == 1)
          {
            paramProtoResp = (ProtoReqManager.ProtoResp)localObject2;
          }
          else
          {
            if (localC2CPicDownReq.jdField_a_of_type_Int != 131075) {
              break label857;
            }
            paramProtoResp = (ProtoReqManager.ProtoResp)localObject1;
          }
        }
        localPicDownResp.jdField_a_of_type_JavaLangString = paramProtoResp;
        if (i == 0)
        {
          paramProtoResp = localGetImgUrlRsp.rpt_uint32_down_ip.get();
          localObject1 = localGetImgUrlRsp.rpt_uint32_down_port.get();
          i = 0;
          while (i < paramProtoResp.size())
          {
            localObject2 = new ServerAddr();
            ((ServerAddr)localObject2).jdField_a_of_type_JavaLangString = PkgTools.a(((Integer)paramProtoResp.get(i)).intValue() & 0xFFFFFFFF);
            ((ServerAddr)localObject2).b = ((Integer)((List)localObject1).get(i)).intValue();
            localPicDownResp.jdField_a_of_type_JavaUtilArrayList.add(i, localObject2);
            i += 1;
          }
        }
        if (localGetImgUrlRsp.bytes_down_domain.has())
        {
          paramProtoResp = new ServerAddr();
          paramProtoResp.jdField_a_of_type_JavaLangString = localGetImgUrlRsp.bytes_down_domain.get().toStringUtf8();
          paramProtoResp.b = 80;
          localPicDownResp.jdField_a_of_type_JavaUtilArrayList.add(paramProtoResp);
          localPicDownResp.b = paramProtoResp.jdField_a_of_type_JavaLangString;
        }
        a(0, 0, "", "", localStatictisInfo, localPicDownResp);
        continue;
        if (C2CPicUpHandler.a(i))
        {
          this.aq += 1;
          if (this.aq < 2)
          {
            localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramProtoReq);
            return;
          }
        }
        a(-1, -9527, BaseTransProcessor.a(i), "", localStatictisInfo, localPicDownResp);
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
    cmd0x352.ReqBody localReqBody = new cmd0x352.ReqBody();
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
      localProtoReq.jdField_a_of_type_JavaLangString = "LongConn.OffPicDown";
      localProtoReq.jdField_a_of_type_ArrayOfByte = a(paramRichProtoReq.jdField_a_of_type_JavaUtilList);
      localProtoReq.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
      a(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.C2CPicDownHandler
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PttUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPttUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jzt;
import mqq.manager.ProxyIpManager;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.TmpPtt;

public class C2CPttUploadProcessor
  extends BaseUploadProcessor
{
  public static final String ae = "C2CPicUploadProcessor";
  MessageObserver a;
  String af;
  
  public C2CPttUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new jzt(this);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ServerAddr localServerAddr = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    localStringBuilder.append("http://");
    localStringBuilder.append(localServerAddr.jdField_a_of_type_JavaLangString);
    if (localServerAddr.b != 80)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(localServerAddr.b);
    }
    localStringBuilder.append("/?ver=");
    localStringBuilder.append(2);
    localStringBuilder.append("&ukey=");
    localStringBuilder.append(this.ad);
    localStringBuilder.append("&filekey=");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("&filesize=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("&bmd5=");
    localStringBuilder.append(MD5.toMD5(paramArrayOfByte));
    localStringBuilder.append("&range=");
    localStringBuilder.append(this.h);
    paramArrayOfByte = a(localStringBuilder.toString(), this.jdField_a_of_type_JavaUtilArrayList);
    BaseTransProcessor.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
    return paramArrayOfByte;
  }
  
  protected im_msg_body.RichText a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 0)
      {
        localObject1 = new im_msg_body.Ptt();
        ((im_msg_body.Ptt)localObject1).uint32_file_type.set(4);
        ((im_msg_body.Ptt)localObject1).uint64_src_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString));
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          localObject2 = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          ((im_msg_body.Ptt)localObject1).uint32_server_ip.set(GroupPicUploadProcessor.a(((ServerAddr)localObject2).jdField_a_of_type_JavaLangString));
          ((im_msg_body.Ptt)localObject1).uint32_server_port.set(((ServerAddr)localObject2).b);
        }
        i = MessageUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        localObject2 = new im_msg_body.Elem();
        Object localObject3 = new im_msg_body.ElemFlags2();
        ((im_msg_body.ElemFlags2)localObject3).uint32_vip_status.set(i);
        ((im_msg_body.Elem)localObject2).elem_flags2.set((MessageMicro)localObject3);
        ((im_msg_body.Ptt)localObject1).bool_valid.set(true);
        ((im_msg_body.Ptt)localObject1).bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.f));
        ((im_msg_body.Ptt)localObject1).bytes_file_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
        ((im_msg_body.Ptt)localObject1).bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
        ((im_msg_body.Ptt)localObject1).uint32_file_size.set((int)this.jdField_a_of_type_Long);
        localObject3 = new im_msg_body.RichText();
        ((im_msg_body.RichText)localObject3).ptt.set((MessageMicro)localObject1);
        ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject2);
        return localObject3;
      }
      Object localObject1 = new im_msg_body.TmpPtt();
      ((im_msg_body.TmpPtt)localObject1).uint32_file_type.set(4);
      ((im_msg_body.TmpPtt)localObject1).bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.f));
      ((im_msg_body.TmpPtt)localObject1).bytes_file_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
      ((im_msg_body.TmpPtt)localObject1).bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
      ((im_msg_body.TmpPtt)localObject1).uint32_file_size.set((int)this.jdField_a_of_type_Long);
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      int i = MessageUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2);
      ((im_msg_body.TmpPtt)localObject1).uint32_user_type.set(i);
      ((im_msg_body.TmpPtt)localObject1).uint64_ptt_times.set(QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h));
      localObject2 = new im_msg_body.RichText();
      ((im_msg_body.RichText)localObject2).tmp_ptt.set((MessageMicro)localObject1);
      return localObject2;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("C2CPicUploadProcessor", 2, "Construct richtext error");
      }
      localException.printStackTrace();
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    d(1001);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!f()))
    {
      d();
      return;
    }
    if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h, "r");
        if (this.jdField_a_of_type_JavaIoRandomAccessFile == null)
        {
          a(9303, "read file error");
          d();
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.jdField_a_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    r();
  }
  
  public void a(NetResp paramNetResp)
  {
    super.a(paramNetResp);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
    int i = paramNetResp.g;
    for (;;)
    {
      try
      {
        if (paramNetResp.e != 0) {
          break label396;
        }
        if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode") == null) {
          break label478;
        }
        l1 = Long.parseLong((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode"));
        if ((l1 != 0L) && (l1 != 9223372036854775807L))
        {
          a(this.b, paramNetResp, false);
          a(-9527, null, b(i, l1), this.b);
          d();
          return;
        }
        if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range") == null) {
          break label470;
        }
        l2 = Integer.parseInt((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range"));
        if (l2 == 9223372036854775807L)
        {
          a(this.b, paramNetResp, false);
          a(-9527, "no header range", a(this.S, this.az), this.b);
          d();
          return;
        }
      }
      catch (Exception paramNetResp)
      {
        a(9343, AbstractImageDownloader.a(new Exception("decode unknown exception")), "", this.b);
        d();
        return;
      }
      a("decodeHttpResp", "from " + this.h + " to " + l2 + " userReturnCode:" + l1);
      if (l2 <= this.h)
      {
        if (this.au < 3)
        {
          a("procHttpRespBody", "server offset rollback");
          this.au += 1;
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Long = l2;
        this.h = l2;
        a(this.b, paramNetResp, true);
        if (l2 >= this.jdField_a_of_type_Long) {
          break label387;
        }
        f();
        c();
        return;
      }
      a(this.b, paramNetResp, false);
      a(-9527, "", a(this.S, this.ay), this.b);
      d();
      return;
      label387:
      f();
      s();
      return;
      label396:
      if ((paramNetResp.f == 9364) && (this.aE < 3))
      {
        a("[netChg]", "failed.but net change detect.so retry");
        this.aE += 1;
        o();
        r();
        return;
      }
      a(this.b, paramNetResp, false);
      a(paramNetResp.f, paramNetResp.jdField_a_of_type_JavaLangString);
      d();
      return;
      label470:
      long l2 = 9223372036854775807L;
      continue;
      label478:
      long l1 = 9223372036854775807L;
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      if (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.C2CPttUpResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          if (paramRichProtoReq.jdField_a_of_type_Boolean)
          {
            this.f = paramRichProtoReq.jdField_a_of_type_JavaLangString;
            s();
          }
          for (;;)
          {
            i += 1;
            break;
            this.f = paramRichProtoReq.jdField_a_of_type_JavaLangString;
            this.ad = paramRichProtoReq.b;
            this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
            this.h = 0L;
            this.i = paramRichProtoReq.jdField_a_of_type_Int;
            c();
          }
        }
        d();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
    {
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (localMessageRecord != null) {
        break label78;
      }
      a("updateDb", "msg null");
    }
    label78:
    while (!(localMessageRecord instanceof MessageForPtt))
    {
      return;
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      a("updateDb", "findmsgbyMsgId,need fix");
      break;
    }
    MessageForPtt localMessageForPtt = (MessageForPtt)localMessageRecord;
    localMessageForPtt.url = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
    localMessageForPtt.fileSize = this.jdField_a_of_type_Long;
    localMessageForPtt.urlAtServer = this.f;
    localMessageForPtt.itemType = 2;
    localMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, localMessageForPtt.msgData);
  }
  
  protected void c(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.c(this.aC))) {}
    while ((this.jdField_c_of_type_Boolean) || ((paramBoolean) && ((this.aF & 0x2) > 0)) || ((!paramBoolean) && ((this.aF & 0x1) > 0))) {
      return;
    }
    int j = this.aF;
    int i;
    long l;
    String str;
    if (paramBoolean)
    {
      i = 2;
      this.aF = (i | j);
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      l = (System.nanoTime() - this.jdField_c_of_type_Long) / 1000000L;
      str = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.b.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str);
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.f != null) {
        break label309;
      }
      str = this.ac;
      label176:
      localHashMap.put("param_uuid", str);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_netStat", String.valueOf(NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
      PttInfoCollector.a(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, l, this.jdField_a_of_type_Long);
      if (!paramBoolean) {
        break label318;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actC2CPttUpload", true, l, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      n();
      return;
      i = 1;
      break;
      label309:
      str = this.f;
      break label176;
      label318:
      if (this.aC != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aC));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.T);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_Long));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actC2CPttUpload", false, l, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public void d()
  {
    super.d();
    d(1005);
  }
  
  public int e()
  {
    super.e();
    a("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    String str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
    if ((str == null) || ("".equals(str)))
    {
      a(9302, a(new Exception("filePath null")));
      d();
      return -1;
    }
    if (str != null)
    {
      File localFile = new File(str);
      if (!localFile.exists())
      {
        a(9042, a(new Exception("sendFile not exist " + str)));
        d();
        return -1;
      }
      if (!localFile.canRead())
      {
        a(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString)));
        d();
        return -1;
      }
      this.jdField_e_of_type_JavaLangString = "amr";
      long l = localFile.length();
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Long = l;
      if (l <= 0L)
      {
        a(9071, a(new Exception("file size 0 " + str)));
        d();
        return -1;
      }
    }
    return 0;
  }
  
  public void e()
  {
    super.e();
    a(true);
    d(1003);
  }
  
  protected void p()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq))) {
      ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttCu", ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
    }
  }
  
  void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.PttUpReq localPttUpReq = new RichProto.RichProtoReq.PttUpReq();
    localPttUpReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString;
    localPttUpReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b;
    localPttUpReq.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localPttUpReq.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localPttUpReq.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localPttUpReq.b = ((int)this.jdField_a_of_type_Long);
    localPttUpReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
    localRichProtoReq.jdField_a_of_type_JavaLangString = "c2c_ptt_up";
    localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localPttUpReq);
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (!d())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        a("requestStart", localRichProtoReq.toString());
      }
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  void s()
  {
    if (!e()) {
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    im_msg_body.RichText localRichText = a();
    if (localRichText == null)
    {
      a(9360, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
    {
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForPtt))) {
        break label188;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("accost_ptt", 4, "mr not ptt?......");
      }
      a(9360, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
    }
    for (;;)
    {
      ((MessageForPtt)localMessageRecord).richText = localRichText;
      if (d()) {
        break label207;
      }
      a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      a("updateDb", "findmsgbyMsgId,need fix");
      break;
      label188:
      if (QLog.isDevelopLevel()) {
        QLog.d("accost_ptt", 4, "mr is ptt......");
      }
    }
    label207:
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPttUploadProcessor
 * JD-Core Version:    0.7.0.1
 */
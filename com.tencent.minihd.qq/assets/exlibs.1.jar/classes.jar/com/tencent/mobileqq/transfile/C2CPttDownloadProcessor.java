package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.C2CPttDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPttDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.manager.ProxyIpManager;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;

public class C2CPttDownloadProcessor
  extends BaseDownloadProcessor
{
  String[] a;
  private long h;
  private long i;
  
  public C2CPttDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
  }
  
  private cmd0x346.ReqBody a()
  {
    int k = 17;
    cmd0x346.DownloadSuccReq localDownloadSuccReq = new cmd0x346.DownloadSuccReq();
    localDownloadSuccReq.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString));
    localDownloadSuccReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d));
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(1000);
    localReqBody.uint32_seq.set(0);
    int j;
    if ("ftn".equals(this.f)) {
      j = 3;
    }
    for (;;)
    {
      localReqBody.uint32_business_id.set(j);
      localReqBody.uint32_client_type.set(104);
      localReqBody.msg_download_succ_req.set(localDownloadSuccReq);
      return localReqBody;
      j = k;
      if ("pttcenter".equals(this.f)) {
        j = k;
      }
    }
  }
  
  private void s()
  {
    a("setSuccess", "req");
    String str = "PttCenterSvr.pb_pttCenter_CMD_REQ_DOWNLOAD_SUCC-1000";
    if ("pttcenter".equals(this.f)) {
      str = "PttCenterSvr.pb_pttCenter_CMD_REQ_DOWNLOAD_SUCC-1000";
    }
    ProtoReqManager.ProtoReq localProtoReq;
    for (;;)
    {
      cmd0x346.ReqBody localReqBody = a();
      localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.jdField_a_of_type_JavaLangString = str;
      localProtoReq.jdField_a_of_type_ArrayOfByte = localReqBody.toByteArray();
      localProtoReq.jdField_c_of_type_Int = 1;
      localProtoReq.jdField_a_of_type_Int = 30000;
      localProtoReq.jdField_b_of_type_Int = 1;
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
      if (d()) {
        break;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
      if ("ftn".equals(this.f)) {
        str = "OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_DOWNLOAD_SUCC-1000";
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localProtoReq);
  }
  
  public void a()
  {
    super.a();
    c();
  }
  
  public void a(NetResp paramNetResp)
  {
    boolean bool2 = true;
    super.a(paramNetResp);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
    Object localObject = new StringBuilder().append(" result:");
    if (paramNetResp.e == 0)
    {
      bool1 = true;
      a("onHttpResp", bool1);
      localObject = this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo;
      if (paramNetResp.e != 0) {
        break label140;
      }
    }
    label140:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a((BaseTransProcessor.StepInfo)localObject, paramNetResp, bool1);
      this.jdField_a_of_type_Long = paramNetResp.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (paramNetResp.jdField_b_of_type_Long + paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_Long);
      }
      this.jdField_b_of_type_Long += paramNetResp.jdField_c_of_type_Long;
      if (paramNetResp.e != 0) {
        break label145;
      }
      s();
      e();
      return;
      bool1 = false;
      break;
    }
    label145:
    if ((paramNetResp.f == 9364) && (this.aE < 3))
    {
      a("[netChg]", "failed.but net change detect.so retry");
      this.aE += 1;
      o();
      c();
      return;
    }
    d();
  }
  
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    a(null, paramProtoResp.a, paramProtoResp.a.getWupBuffer());
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int j = 0;
      while (j < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.C2CPttDownResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(j);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          this.e = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k = this.e;
          if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
          {
            paramRichProtoReq = RichMediaUtil.a(this.e);
            if (paramRichProtoReq != null) {
              this.jdField_a_of_type_JavaUtilArrayList.add(paramRichProtoReq);
            }
          }
          q();
          j += 1;
        }
        else
        {
          d();
        }
      }
    }
  }
  
  /* Error */
  protected void a(com.tencent.qphone.base.remote.ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 126
    //   3: ldc_w 326
    //   6: invokevirtual 131	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_2
    //   10: invokevirtual 329	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   13: sipush 1000
    //   16: if_icmpeq +38 -> 54
    //   19: aload_2
    //   20: invokevirtual 329	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   23: istore 4
    //   25: aload_0
    //   26: ldc_w 331
    //   29: new 193	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 333
    //   39: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload 4
    //   44: invokevirtual 336	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokevirtual 131	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: return
    //   54: new 338	tencent/im/cs/cmd0x346/cmd0x346$RspBody
    //   57: dup
    //   58: invokespecial 339	tencent/im/cs/cmd0x346/cmd0x346$RspBody:<init>	()V
    //   61: astore_1
    //   62: aload_1
    //   63: aload_3
    //   64: invokevirtual 343	tencent/im/cs/cmd0x346/cmd0x346$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   67: pop
    //   68: aload_1
    //   69: getfield 344	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   72: invokevirtual 347	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   75: ifeq +91 -> 166
    //   78: aload_1
    //   79: getfield 344	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 349	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   85: i2l
    //   86: lstore 5
    //   88: lload 5
    //   90: ldc2_w 350
    //   93: lcmp
    //   94: ifne -41 -> 53
    //   97: aload_1
    //   98: getfield 355	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   101: invokevirtual 358	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:has	()Z
    //   104: ifeq -51 -> 53
    //   107: aload_1
    //   108: getfield 355	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   111: invokevirtual 361	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   114: checkcast 357	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp
    //   117: getfield 365	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:int32_ret_code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   120: invokevirtual 368	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   123: istore 4
    //   125: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq -75 -> 53
    //   131: aload_0
    //   132: ldc_w 331
    //   135: new 193	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 370
    //   145: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: iload 4
    //   150: invokevirtual 336	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokevirtual 131	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: return
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual 373	java/lang/Exception:printStackTrace	()V
    //   165: return
    //   166: ldc2_w 374
    //   169: lstore 5
    //   171: goto -83 -> 88
    //   174: astore_1
    //   175: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	C2CPttDownloadProcessor
    //   0	176	1	paramToServiceMsg	com.tencent.qphone.base.remote.ToServiceMsg
    //   0	176	2	paramFromServiceMsg	FromServiceMsg
    //   0	176	3	paramArrayOfByte	byte[]
    //   23	126	4	j	int
    //   86	84	5	l	long
    // Exception table:
    //   from	to	target	type
    //   54	62	160	java/lang/Exception
    //   68	88	160	java/lang/Exception
    //   97	159	160	java/lang/Exception
    //   62	68	174	java/lang/Exception
  }
  
  void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    if ((localObject != null) && ((localObject instanceof MessageForPtt)))
    {
      this.f = ((MessageForPtt)localObject).storageSource;
      localObject = new RichProto.RichProtoReq();
      RichProto.RichProtoReq.C2CPttDownReq localC2CPttDownReq = new RichProto.RichProtoReq.C2CPttDownReq();
      localC2CPttDownReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString;
      localC2CPttDownReq.d = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
      localC2CPttDownReq.e = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
      localC2CPttDownReq.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
      localC2CPttDownReq.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d;
      localC2CPttDownReq.jdField_b_of_type_JavaLangString = this.f;
      localC2CPttDownReq.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Boolean;
      ((RichProto.RichProtoReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      ((RichProto.RichProtoReq)localObject).jdField_a_of_type_JavaLangString = "c2c_ptt_dw";
      ((RichProto.RichProtoReq)localObject).jdField_a_of_type_JavaUtilList.add(localC2CPttDownReq);
      ((RichProto.RichProtoReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (d()) {
        break label230;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
    }
    label230:
    do
    {
      return;
      this.f = "pttcenter";
      a("findDbRec", "not found");
      break;
      if (QLog.isColorLevel()) {
        a("requestStart", ((RichProto.RichProtoReq)localObject).toString());
      }
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = ((RichProto.RichProtoReq)localObject);
    RichProtoProc.a((RichProto.RichProtoReq)localObject);
  }
  
  protected void c(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.c(this.aC))) {}
    while ((this.jdField_c_of_type_Boolean) || ((paramBoolean) && ((this.aF & 0x2) > 0)) || ((!paramBoolean) && ((this.aF & 0x1) > 0))) {
      return;
    }
    int k = this.aF;
    int j;
    long l1;
    Object localObject;
    if (paramBoolean)
    {
      j = 2;
      this.aF = (j | k);
      l1 = (System.nanoTime() - this.jdField_c_of_type_Long) / 1000000L;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_netStat", String.valueOf(NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_writtenSize", String.valueOf(this.jdField_b_of_type_Long));
      if (!paramBoolean) {
        break label269;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actC2CPttDownload", true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      n();
      return;
      j = 1;
      break;
      label269:
      if (this.aC != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aC));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.T);
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actC2CPttDownload", false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
      if ((this.aC == -9527) && (this.i > this.h) && (this.T != null) && (this.T.equals("H_400_-5103017")))
      {
        localObject = new HashMap();
        long l3 = System.currentTimeMillis() / 1000L;
        l1 = (this.i - this.h) / 86400L;
        long l2 = (l3 - this.h) / 86400L;
        l3 = (l3 - this.i) / 86400L;
        ((HashMap)localObject).put("MsgOff", String.valueOf(l1));
        ((HashMap)localObject).put("PttOff", String.valueOf(l3));
        ((HashMap)localObject).put("OutOfTimeReason", String.valueOf(256));
        ((HashMap)localObject).put("param_FailCode", String.valueOf(l2));
        StatisticCollector.a(BaseApplication.getContext()).a(null, "actC2CPTTOutOfTime", false, 0L, 0L, (HashMap)localObject, null);
      }
    }
  }
  
  void d()
  {
    super.d();
    d(2005);
  }
  
  public int e()
  {
    super.e();
    a("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    String str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d;
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    if ((localMessageRecord != null) && (localMessageRecord.getPttStreamFlag() == 10001)) {
      this.jdField_c_of_type_Boolean = true;
    }
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (FileUtils.c(str)) || (str.startsWith("http://")))
    {
      a(9302, a(new Exception("uuid illegal " + str)));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g == null) || (!FileUtils.c(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h))) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g = a("c2c", str);
    }
    if ((localMessageRecord instanceof MessageForPtt))
    {
      this.h = ((MessageForPtt)localMessageRecord).msgTime;
      this.i = ((MessageForPtt)localMessageRecord).msgRecTime;
    }
    return 0;
  }
  
  void e()
  {
    super.e();
    r();
    d(2003);
  }
  
  protected void p()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq))) {
      ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttCd", ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
    }
  }
  
  void q()
  {
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    String str3 = a(this.e, this.jdField_a_of_type_JavaUtilArrayList);
    BaseTransProcessor.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = str3;
    localHttpNetReq.jdField_c_of_type_Int = 0;
    localHttpNetReq.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localHttpNetReq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g;
    localHttpNetReq.d = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    localHttpNetReq.n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localHttpNetReq.m = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    localHttpNetReq.jdField_a_of_type_Long = 0L;
    localHttpNetReq.jdField_b_of_type_Boolean = true;
    localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localHttpNetReq.jdField_c_of_type_Boolean = false;
    String str2 = null;
    String str1 = str2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      str1 = str2;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        str1 = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
      }
    }
    str2 = RichMediaUtil.a(str3);
    a("httpDown", "RespDomain: " + str2 + " ipList:" + str1 + " uuid:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d + " downOffset:" + localHttpNetReq.jdField_a_of_type_Long);
    if (!e()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = localHttpNetReq;
    p();
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
  }
  
  void r()
  {
    try
    {
      Object localObject = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      ((MessageForPtt)localObject).url = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g;
      ((MessageForPtt)localObject).fileSize = this.jdField_a_of_type_Long;
      ((MessageForPtt)localObject).urlAtServer = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d;
      ((MessageForPtt)localObject).serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, ((MessageForPtt)localObject).uniseq, ((MessageForPtt)localObject).msgData);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, 0);
      if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d.equals(((QQMessageFacade.Message)localObject).pttUrl))) {
        ((QQMessageFacade.Message)localObject).pttUrl = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g;
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("BaseTransProcessor", 2, "updatedb", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */
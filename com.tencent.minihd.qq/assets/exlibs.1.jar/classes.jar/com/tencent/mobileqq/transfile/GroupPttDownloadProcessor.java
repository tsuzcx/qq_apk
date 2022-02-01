package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.GroupPttDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPttDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.manager.ProxyIpManager;

public class GroupPttDownloadProcessor
  extends BaseDownloadProcessor
{
  byte[] a;
  String ac;
  long h;
  private long i;
  private long j;
  boolean k = true;
  
  public GroupPttDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
  }
  
  public void a()
  {
    d(2001);
    c();
  }
  
  public void a(NetResp paramNetResp)
  {
    boolean bool2 = true;
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo;
    if (paramNetResp.e == 0)
    {
      bool1 = true;
      a((BaseTransProcessor.StepInfo)localObject, paramNetResp, bool1);
      localObject = new StringBuilder().append(" result:");
      if (paramNetResp.e != 0) {
        break label140;
      }
    }
    label140:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a("onHttpResp", bool1);
      this.jdField_a_of_type_Long = paramNetResp.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (paramNetResp.b + paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a.e = ((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader"));
      if (paramNetResp.e != 0) {
        break label145;
      }
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
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int m = 0;
      while (m < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.GroupPttDownResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(m);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
          this.d = paramRichProtoReq.jdField_b_of_type_JavaLangString;
          this.jdField_c_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          r();
          m += 1;
        }
        else
        {
          d();
        }
      }
    }
  }
  
  void c()
  {
    d(2001);
    q();
  }
  
  protected void c(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.c(this.aC))) {}
    while ((this.jdField_c_of_type_Boolean) || ((paramBoolean) && ((this.aF & 0x2) > 0)) || ((!paramBoolean) && ((this.aF & 0x1) > 0))) {
      return;
    }
    int n = this.aF;
    label81:
    long l1;
    Object localObject;
    if (paramBoolean)
    {
      m = 2;
      this.aF = (m | n);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 1) {
        break label259;
      }
      str = "actGrpPttDown";
      l1 = (System.nanoTime() - this.jdField_c_of_type_Long) / 1000000L;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_netStat", String.valueOf(NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())));
      if (!paramBoolean) {
        break label267;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str, true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    label259:
    label267:
    do
    {
      n();
      return;
      m = 1;
      break;
      str = "actDisscusPttDown";
      break label81;
      if (this.aC != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aC));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.T);
      StatisticCollector.a(BaseApplication.getContext()).a(null, str, false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    } while ((this.aC != -9527) || (this.j <= this.i) || (this.T == null));
    int m = 0;
    if (this.T.equals("T_203"))
    {
      m = 1;
      label389:
      if (m == 0) {
        break label557;
      }
      if (!this.k) {
        break label559;
      }
    }
    label557:
    label559:
    for (String str = "actGroupPTTOutOfTime";; str = "actDiscussionPTTOutOfTime")
    {
      localObject = new HashMap();
      long l3 = System.currentTimeMillis() / 1000L;
      l1 = (this.j - this.i) / 86400L;
      long l2 = (l3 - this.i) / 86400L;
      l3 = (l3 - this.j) / 86400L;
      ((HashMap)localObject).put("MsgOff", String.valueOf(l1));
      ((HashMap)localObject).put("PttOff", String.valueOf(l3));
      ((HashMap)localObject).put("OutOfTimeReason", String.valueOf(m));
      ((HashMap)localObject).put("param_FailCode", String.valueOf(l2));
      StatisticCollector.a(BaseApplication.getContext()).a(null, str, false, 0L, 0L, (HashMap)localObject, null);
      break;
      if (!this.T.equals("H_400_-5103017")) {
        break label389;
      }
      m = 16;
      break label389;
      break;
    }
  }
  
  void d()
  {
    super.d();
    d(2005);
  }
  
  public int e()
  {
    boolean bool = true;
    int m = 0;
    a("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d;
    if ((localObject == null) || (((String)localObject).equals("")) || (((String)localObject).equals("null")) || (FileUtils.c((String)localObject)) || (((String)localObject).startsWith("http://")))
    {
      a(9302, a(new Exception("uuid illegal " + (String)localObject)));
      d();
      m = -1;
    }
    do
    {
      return m;
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g == null) || (!FileUtils.c(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h))) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g = a("group", (String)localObject);
      }
      if (1 == this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int) {}
      for (;;)
      {
        this.k = bool;
        this.jdField_a_of_type_ArrayOfByte = a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d);
        this.h = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Long;
        this.ac = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f;
        if (this.jdField_a_of_type_ArrayOfByte != null) {
          break;
        }
        a(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e + "  uuid:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d)));
        d();
        return -1;
        bool = false;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    } while (!(localObject instanceof MessageForPtt));
    this.i = ((MessageForPtt)localObject).msgTime;
    this.j = ((MessageForPtt)localObject).msgRecTime;
    return 0;
  }
  
  void e()
  {
    super.e();
    s();
    d(2003);
  }
  
  protected void p()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq)))
    {
      if (this.k) {
        ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttGd", ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttDd", ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
  }
  
  void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.GroupPttDownReq localGroupPttDownReq = new RichProto.RichProtoReq.GroupPttDownReq();
    localGroupPttDownReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString;
    localGroupPttDownReq.d = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localGroupPttDownReq.e = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localGroupPttDownReq.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localGroupPttDownReq.jdField_a_of_type_Long = this.h;
    a("SendRequest", " SendRequest GrpFileKey:" + this.ac);
    localGroupPttDownReq.jdField_a_of_type_JavaLangString = this.ac;
    localGroupPttDownReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
    localRichProtoReq.jdField_a_of_type_JavaLangString = "grp_ptt_dw";
    localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localGroupPttDownReq);
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
  
  void r()
  {
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 0) && (this.d != null)) {
      localObject = "http://" + this.d;
    }
    for (;;)
    {
      localObject = a((String)localObject + this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList);
      BaseTransProcessor.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
      localHttpNetReq.jdField_a_of_type_JavaLangString = ((String)localObject);
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
      ServerAddr localServerAddr = null;
      localObject = localServerAddr;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject = localServerAddr;
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          localObject = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
        }
      }
      a("httpDown", "directMsgUrlDown:" + this.jdField_b_of_type_Boolean + " ipList:" + (String)localObject + " uuid:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d + " FileID:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Long + " downOffset:" + localHttpNetReq.jdField_a_of_type_Long);
      if (!e())
      {
        return;
        localServerAddr = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localObject = "http://" + localServerAddr.jdField_a_of_type_JavaLangString;
        if (localServerAddr.jdField_b_of_type_Int != 80) {
          localObject = (String)localObject + ":" + localServerAddr.jdField_b_of_type_Int;
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = localHttpNetReq;
        p();
        this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
        return;
      }
    }
  }
  
  public void s()
  {
    Object localObject = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (localObject != null)
    {
      ((MessageForPtt)localObject).url = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g;
      ((MessageForPtt)localObject).fileSize = this.jdField_a_of_type_Long;
      ((MessageForPtt)localObject).urlAtServer = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d;
      ((MessageForPtt)localObject).serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, ((MessageForPtt)localObject).uniseq, ((MessageForPtt)localObject).msgData);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int);
    if ((localObject != null) && (((QQMessageFacade.Message)localObject).pttUrl != null) && (((QQMessageFacade.Message)localObject).pttUrl.equals(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d))) {
      ((QQMessageFacade.Message)localObject).pttUrl = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */
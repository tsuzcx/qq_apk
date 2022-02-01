package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.NearbyPeoplePicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.NearbyPeoplePicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.util.HashMap;
import java.util.List;
import kap;

public class NearbyPeoplePhotoUploadProcessor
  extends BaseUploadProcessor
{
  public static int aP = 0;
  public static final String ae = "NearbyPeoplePhotoUploadProcessor";
  private Transaction jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = null;
  private byte[] jdField_b_of_type_ArrayOfByte;
  
  public NearbyPeoplePhotoUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq.NearbyPeoplePicUpReq localNearbyPeoplePicUpReq = new RichProto.RichProtoReq.NearbyPeoplePicUpReq();
    localNearbyPeoplePicUpReq.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b == 21)
    {
      localRichProtoReq.jdField_a_of_type_JavaLangString = "friend_avatar_up";
      localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localNearbyPeoplePicUpReq);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (d()) {
        break label114;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
    }
    label114:
    do
    {
      return;
      localRichProtoReq.jdField_a_of_type_JavaLangString = "nearby_people_pic_up";
      break;
      if (QLog.isColorLevel()) {
        a("requestStart", localRichProtoReq.toString());
      }
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  protected long a(long paramLong)
  {
    paramLong = this.jdField_a_of_type_Long - paramLong;
    if (!this.jdField_b_of_type_Boolean) {}
    for (paramLong = Math.min(paramLong, this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_a_of_type_Long, this.h, -1));; paramLong = Math.min(paramLong, 14600L)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.start()");
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!f()))
    {
      d();
      return;
    }
    s();
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong1 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong4);
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    super.a(paramNetResp);
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    if (paramRichProtoResp != null)
    {
      int i = 0;
      if (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.NearbyPeoplePicUpResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (QLog.isColorLevel()) {
          QLog.d("NearbyPeoplePhotoUploadProcessor", 2, "onBusiProtoResp()------response.result = " + paramRichProtoReq.c);
        }
        if (paramRichProtoReq.c == 0)
        {
          this.jdField_b_of_type_ArrayOfByte = paramRichProtoReq.jdField_a_of_type_ArrayOfByte;
          if (QLog.isColorLevel()) {
            QLog.d("NearbyPeoplePhotoUploadProcessor", 2, "onBusiProtoResp()---- sessionKey: " + this.jdField_b_of_type_ArrayOfByte);
          }
          c();
        }
        for (;;)
        {
          i += 1;
          break;
          d();
        }
      }
    }
  }
  
  byte[] a(int paramInt1, int paramInt2)
  {
    return super.a(paramInt1, paramInt2);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.sendFile()");
    }
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    kap localkap = new kap(this, SystemClock.uptimeMillis());
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b == 21) {}
    for (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 5, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h, (int)this.jdField_b_of_type_Long, this.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_ArrayOfByte, localkap);; this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 3, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h, (int)this.jdField_b_of_type_Long, this.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_ArrayOfByte, localkap))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().submitTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPeoplePhotoUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.ac + " Path:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 3);
      }
      if (i != 0)
      {
        a(i, "SubmitError.", "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
      }
      return;
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeoplePhotoUploadProcessor", 2, paramString);
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.c(this.aC))) {}
    while ((this.jdField_c_of_type_Boolean) || ((paramBoolean) && ((this.aF & 0x2) > 0)) || ((!paramBoolean) && ((this.aF & 0x1) > 0))) {
      return;
    }
    int j = this.aF;
    int i;
    String str1;
    label83:
    long l;
    String str2;
    if (paramBoolean)
    {
      i = 2;
      this.aF = (i | j);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b != 21) {
        break label173;
      }
      str1 = "actFriendAvatarUpload";
      this.d = System.currentTimeMillis();
      l = (System.nanoTime() - this.jdField_c_of_type_Long) / 1000000L;
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.jdField_b_of_type_ArrayOfByte != null) {
        break label181;
      }
      str2 = "null";
      label122:
      localHashMap.put("param_sessionKey", str2);
      if (!paramBoolean) {
        break label193;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, true, l, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      n();
      return;
      i = 1;
      break;
      label173:
      str1 = "actNearbyPeoplePicUpload";
      break label83;
      label181:
      str2 = PkgTools.b(this.jdField_b_of_type_ArrayOfByte);
      break label122;
      label193:
      if (this.aC != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aC));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.T);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_Long));
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, false, l, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public void d()
  {
    super.d();
    d(1005);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeoplePhotoUploadProcessor", 2, "onError()---- errCode: " + this.aC + ", errDesc:" + this.T);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = -1;
      localSendResult.b = this.aC;
      localSendResult.jdField_a_of_type_JavaLangString = this.T;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
    }
  }
  
  public int e()
  {
    return super.e();
  }
  
  public void e()
  {
    super.e();
    d(1003);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeoplePhotoUploadProcessor", 2, "onSuccess().");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
    }
  }
  
  public int f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.resume()");
    }
    r();
    s();
    return 0;
  }
  
  public void r()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().cancelTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor
 * JD-Core Version:    0.7.0.1
 */
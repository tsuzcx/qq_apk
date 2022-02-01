package com.tencent.mobileqq.transfile;

import java.util.HashMap;

public class UrlDownloader
  extends BaseDownloadProcessor
{
  protected TransferRequest.PicDownExtraInfo a;
  
  public UrlDownloader(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.b = ((TransferRequest.PicDownExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Int;
  }
  
  public void a()
  {
    c();
  }
  
  public void a(NetResp paramNetResp)
  {
    super.a(paramNetResp);
    StringBuilder localStringBuilder = new StringBuilder().append(" result:");
    if (paramNetResp.e == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a("onHttpResp", bool);
      this.b += paramNetResp.c;
      if (paramNetResp.e != 0) {
        break;
      }
      e();
      return;
    }
    d();
  }
  
  void c()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString;
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = str;
    localHttpNetReq.c = 0;
    localHttpNetReq.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaIoOutputStream;
    localHttpNetReq.b = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g;
    localHttpNetReq.jdField_d_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    localHttpNetReq.n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localHttpNetReq.m = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b;
    localHttpNetReq.jdField_a_of_type_Long = this.b;
    localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localHttpNetReq.l = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Boolean)
    {
      localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + localHttpNetReq.jdField_a_of_type_Long + "-");
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    }
    localHttpNetReq.k = 4;
    localHttpNetReq.jdField_d_of_type_Long = 90000L;
    a("httpDown", " url:" + str + ",downOffset:" + localHttpNetReq.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
  }
  
  void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.d(TransFileController.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest));
    TransferResult localTransferResult = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
    if (localTransferResult != null)
    {
      localTransferResult.d = -1;
      localTransferResult.jdField_a_of_type_Long = this.aC;
      localTransferResult.jdField_a_of_type_JavaLangString = this.T;
      localTransferResult.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    }
    try
    {
      a("notify", "start");
      notifyAll();
      a("notify", "end");
      return;
    }
    finally {}
  }
  
  void e()
  {
    super.e();
    TransferResult localTransferResult = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.d(TransFileController.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest));
    if (localTransferResult != null)
    {
      localTransferResult.d = 0;
      localTransferResult.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    }
    try
    {
      a("notify", "start");
      notifyAll();
      a("notify", "end");
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.UrlDownloader
 * JD-Core Version:    0.7.0.1
 */
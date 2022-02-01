import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.pic.BasePicOprerator;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;

public class jlr
  implements Runnable
{
  public jlr(BasePicOprerator paramBasePicOprerator, PicUploadInfo paramPicUploadInfo) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().preConnect();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo;
    ??? = new CompressInfo(((PicUploadInfo)localObject1).jdField_g_of_type_JavaLangString, 0);
    CompressOperator.b((CompressInfo)???);
    if (((CompressInfo)???).jdField_e_of_type_JavaLangString != null)
    {
      ((PicUploadInfo)localObject1).jdField_h_of_type_JavaLangString = ((CompressInfo)???).jdField_e_of_type_JavaLangString;
      ((PicUploadInfo)localObject1).jdField_f_of_type_Int = ((CompressInfo)???).d;
      ((PicUploadInfo)localObject1).jdField_g_of_type_Int = ((CompressInfo)???).jdField_e_of_type_Int;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.a((PicUploadInfo)localObject1);
    if (MessageForPic.class.isInstance(localObject1)) {
      BasePicOprerator.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator, (MessageForPic)localObject1);
    }
    if (((MessageRecord)localObject1).istroop == 1) {
      AnonymousChatHelper.a().a((MessageRecord)localObject1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Boolean) {}
    synchronized (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo)
    {
      this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject = localObject1;
      this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.notifyAll();
      Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, "PresendStatus", "destPath:" + this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
      if (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int == 3)
      {
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, "PresendStatus", "destPath:" + this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Int == 1001) && (!this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString, ((MessageRecord)localObject1).uniseq);
        if (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Boolean) {
          BasePicOprerator.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator, (MessageRecord)localObject1);
        }
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo, "getSendTask.start old lbs protocol", "");
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = localObject2;
    long l = System.currentTimeMillis();
    ??? = new TransferRequest();
    ((TransferRequest)???).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((TransferRequest)???).jdField_b_of_type_JavaLangString = localObject2.frienduin;
    ((TransferRequest)???).jdField_c_of_type_JavaLangString = localObject2.senderuin;
    ((TransferRequest)???).jdField_a_of_type_Int = localObject2.istroop;
    ((TransferRequest)???).jdField_b_of_type_Int = 1;
    ((TransferRequest)???).jdField_a_of_type_Long = localObject2.uniseq;
    ((TransferRequest)???).jdField_a_of_type_Boolean = true;
    ((TransferRequest)???).d = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_Int;
    ((TransferRequest)???).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString;
    ((TransferRequest)???).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_JavaLangString;
    ??? = new TransferRequest.PicUpExtraInfo();
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.a() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((TransferRequest.PicUpExtraInfo)???).jdField_a_of_type_Boolean = bool;
      ((TransferRequest)???).jdField_a_of_type_JavaLangObject = ???;
      ((TransferRequest)???).jdField_a_of_type_ComTencentMobileqqPicUpCallBack = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator;
      ((TransferRequest)???).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      ((TransferRequest)???).jdField_h_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Boolean;
      ((TransferRequest)???).i = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.e;
      if (!this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Boolean) {
        break label946;
      }
      synchronized (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.d) {
          break;
        }
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "PresendPic doSendPic cancel transferAsync!", "");
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, "PresendStatus", "destPath:" + this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
        return;
      }
    }
    Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "PresendPic doSendPic start transferAsync!", "");
    this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((TransferRequest)???);
    Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, "PresendStatus", "destPath:" + this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
    for (;;)
    {
      Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "sendReq", "cost:" + (System.currentTimeMillis() - l));
      if ((this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Boolean)) {
        BasePicOprerator.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator, localMessageRecord);
      }
      Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "getSendTask.start", "");
      return;
      label946:
      this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((TransferRequest)???);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jlr
 * JD-Core Version:    0.7.0.1
 */
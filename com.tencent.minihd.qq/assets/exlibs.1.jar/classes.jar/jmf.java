import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PresendPicMgrService;
import com.tencent.mobileqq.pic.UiCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AccountNotMatchException;

public class jmf
  implements UiCallBack
{
  public jmf(PresendPicMgrService paramPresendPicMgrService, PicReq paramPicReq) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, PicResult paramPicResult) {}
  
  public void a(int paramInt, ArrayList paramArrayList) {}
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, PicResult arg2)
  {
    UpCallBack.SendResult localSendResult = (UpCallBack.SendResult)???.a;
    Object localObject2 = new StringBuilder().append("destPath:").append(this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g).append(",uuid:").append(this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_JavaLangString).append(",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true, mainUploadFinish:true, uploadResult:");
    if (paramInt == 0)
    {
      ??? = "ResultOk";
      Logger.a("PresendPicMgrService", "PresendStatus", ???);
      Logger.a("PresendPicMgrService", "onSend", " SendResult = " + localSendResult);
    }
    for (;;)
    {
      synchronized (PresendPicMgrService.a(this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService))
      {
        if (!PresendPicMgrService.a(this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService))
        {
          if (paramInt == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c = 1;
            Logger.a("PresendPicMgrService", "onSend", " SendButton not clicked, add senReq to mUploadFinishList,senReq = " + this.jdField_a_of_type_ComTencentMobileqqPicPicReq);
            PresendPicMgrService.a(this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService).add(this.jdField_a_of_type_ComTencentMobileqqPicPicReq);
            return;
            ??? = "ResultFail";
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c = 2;
        }
      }
      if (paramInt == 0)
      {
        try
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a.getAppRuntime(PresendPicMgrService.a(this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService));
          localObject2 = (MessageRecord)this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.a;
          localQQAppInterface.a().b((MessageRecord)localObject2, null);
          Logger.a("PresendPicMgrService", "onSend", " SendButton has been clicked, sendMessage directly! ,senReq = " + this.jdField_a_of_type_ComTencentMobileqqPicPicReq);
        }
        catch (AccountNotMatchException localAccountNotMatchException) {}
        if (QLog.isColorLevel()) {
          QLog.d("PresendPicMgrService", 2, "no appRuntime");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PresendPicMgrService", 2, "onSend SendResult = " + localAccountNotMatchException + ", upload failed");
      }
    }
  }
  
  public void c(int paramInt, PicResult paramPicResult) {}
  
  public void d(int paramInt, PicResult paramPicResult) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jmf
 * JD-Core Version:    0.7.0.1
 */
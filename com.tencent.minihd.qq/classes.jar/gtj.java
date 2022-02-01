import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack.Stub;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class gtj
  extends ICompressionCallBack.Stub
{
  private PicReq jdField_a_of_type_ComTencentMobileqqPicPicReq;
  private PicUploadInfo jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public gtj(SendPhotoActivity paramSendPhotoActivity, PicUploadInfo paramPicUploadInfo, PicReq paramPicReq)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramSendPhotoActivity);
    this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo = paramPicUploadInfo;
    this.jdField_a_of_type_ComTencentMobileqqPicPicReq = paramPicReq;
  }
  
  public void a(CompressInfo paramCompressInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "SendPhotoActivity, compress success, localUUID:" + paramCompressInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(CompressInfo paramCompressInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "SendPhotoActivity, compress fail, localUUID:" + paramCompressInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void c(CompressInfo paramCompressInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "SendPhotoActivity, compress complete, localUUID:" + paramCompressInfo.jdField_a_of_type_JavaLangString);
    }
    SendPhotoActivity localSendPhotoActivity = (SendPhotoActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localSendPhotoActivity == null) && (QLog.isColorLevel())) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onCompressComplete, error: activity is null");
    }
    String str = paramCompressInfo.jdField_e_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g = str;
    if ((paramCompressInfo.g != 2) && (PeakUtils.a(str))) {
      LogTag.a();
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.a = PeakUtils.a(str);
      if ((this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.a != null) && (QLog.isColorLevel())) {
        QLog.d("peak_pgjpeg", 2, "SendPhotoActivity.sendPhotoTask:" + this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.a.toString());
      }
      LogTag.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + str + ")");
      localSendPhotoActivity.b.add(this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g);
      SendPhotoActivity.b(localSendPhotoActivity).add(paramCompressInfo);
      if (paramCompressInfo.jdField_e_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.h = 1;
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo, "fixProtocolType", "sendReq.upInfo.protocolType");
        SendPhotoActivity.a(localSendPhotoActivity, this.jdField_a_of_type_ComTencentMobileqqPicPicReq);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + str + "'s size is " + FileUtils.a(str));
          continue;
          this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.h = this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gtj
 * JD-Core Version:    0.7.0.1
 */
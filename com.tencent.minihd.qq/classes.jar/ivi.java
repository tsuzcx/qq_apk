import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;

public class ivi
  implements IWyFileSystem.IWyCallback
{
  public ivi(WeiYunLogicCenter paramWeiYunLogicCenter, WeiYunFileInfo paramWeiYunFileInfo) {}
  
  public void a(Void paramVoid)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "deleteWeiYunFile, onSucceed  strFileId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.a + "]strFileName[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.b) + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a.a().a(true, 20, new Object[] { Integer.valueOf(0), null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.a, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.b, Boolean.valueOf(false) });
  }
  
  public void onFailed(IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "deleteWeiYunFile, onFailed  strFileId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.a + "]strFileName[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.b) + "]errorCode[" + String.valueOf(paramWyErrorStatus.errorCode) + "],errorMsg[" + paramWyErrorStatus.errorMsg + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a.a().a(false, 20, new Object[] { Integer.valueOf(paramWyErrorStatus.errorCode), paramWyErrorStatus.errorMsg, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.a, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.b, Boolean.valueOf(false) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     ivi
 * JD-Core Version:    0.7.0.1
 */
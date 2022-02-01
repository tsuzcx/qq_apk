import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.troop.data.TroopFilePreviewController;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.PreviewInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class kks
  extends BizTroopObserver
{
  public kks(TroopFilePreviewController paramTroopFilePreviewController) {}
  
  protected void c(Object paramObject)
  {
    TroopFileTransferManager.PreviewInfo localPreviewInfo = (TroopFileTransferManager.PreviewInfo)paramObject;
    String str1 = localPreviewInfo.c;
    if (!NetworkUtil.f(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
      str1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131362551);
    }
    String str2;
    if (str1 != null)
    {
      str2 = str1;
      if (str1.length() >= 1) {}
    }
    else
    {
      str2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131367610);
    }
    if (FMConfig.jdField_a_of_type_Boolean)
    {
      localPreviewInfo.jdField_a_of_type_JavaLangString = "183.61.37.13";
      localPreviewInfo.b = "443";
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback.a(localPreviewInfo.jdField_a_of_type_Boolean, localPreviewInfo.jdField_a_of_type_JavaLangString, localPreviewInfo.b, localPreviewInfo.jdField_a_of_type_Int, str2, localPreviewInfo.d, null, localPreviewInfo.e);
    super.c(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kks
 * JD-Core Version:    0.7.0.1
 */
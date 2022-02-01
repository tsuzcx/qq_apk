import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingTroopFileView;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.PreviewInfo;
import com.tencent.qphone.base.util.QLog;

class izy
  extends BizTroopObserver
{
  izy(izx paramizx) {}
  
  protected void c(Object paramObject)
  {
    TroopFileTransferManager.PreviewInfo localPreviewInfo = (TroopFileTransferManager.PreviewInfo)paramObject;
    if ((localPreviewInfo.a) && (TextUtils.isEmpty(localPreviewInfo.d)))
    {
      localPreviewInfo.a = false;
      paramObject = BaseApplicationImpl.getContext().getString(2131362407);
      if (QLog.isColorLevel()) {
        QLog.i("PreviewStep_1", 2, "FAILED onFetchPreviewInfo harcode[" + FMConfig.a + "],server return true,but downloadKey is null, rcmsg[" + paramObject + "]");
      }
      PreviewingTroopFileView.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingTroopFileView, 11203, paramObject, paramObject);
      return;
    }
    if (localPreviewInfo.a)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$PreviewInfo = localPreviewInfo;
      PreviewingTroopFileView.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingTroopFileView);
    }
    for (;;)
    {
      super.c(paramObject);
      return;
      Activity localActivity = PreviewingTroopFileView.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingTroopFileView);
      localActivity.runOnUiThread(new izz(this, localPreviewInfo, localActivity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     izy
 * JD-Core Version:    0.7.0.1
 */
import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingTroopFileView;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.PreviewInfo;
import com.tencent.mobileqq.utils.NetworkUtil;

class izz
  implements Runnable
{
  izz(izy paramizy, TroopFileTransferManager.PreviewInfo paramPreviewInfo, Activity paramActivity) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$PreviewInfo.c;
    if (!NetworkUtil.f(this.jdField_a_of_type_AndroidAppActivity)) {
      str = this.jdField_a_of_type_AndroidAppActivity.getString(2131363364);
    }
    PreviewingTroopFileView.b(this.jdField_a_of_type_Izy.a.a, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$PreviewInfo.a, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$PreviewInfo.c, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     izz
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarOfflineFile.BaseActionBarOfflineFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

public class iwk
  implements View.OnClickListener
{
  public iwk(BaseActionBarOfflineFile paramBaseActionBarOfflineFile) {}
  
  public void onClick(View paramView)
  {
    int i;
    if ((FileManagerUtil.a()) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > 5242880L))
    {
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
      if (this.a.jdField_a_of_type_Boolean)
      {
        i = 2131362465;
        FMDialogUtil.a(paramView, 2131362469, i, new iwl(this));
      }
    }
    for (;;)
    {
      if (!this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.f()) {
        break label129;
      }
      FileManagerReporter.a("0X8004BBA");
      return;
      i = 2131362466;
      break;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      this.a.f();
    }
    label129:
    FileManagerReporter.a("0X8004BD0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iwk
 * JD-Core Version:    0.7.0.1
 */
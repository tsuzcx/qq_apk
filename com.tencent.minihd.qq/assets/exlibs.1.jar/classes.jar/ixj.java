import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarWeiYunFile.BaseActionBarWeiyunFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

public class ixj
  implements View.OnClickListener
{
  public ixj(BaseActionBarWeiyunFile paramBaseActionBarWeiyunFile) {}
  
  public void onClick(View paramView)
  {
    if ((FileManagerUtil.a()) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > 5242880L)) {
      FMDialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), 2131362469, 2131362466, new ixk(this));
    }
    while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.f())
    {
      FileManagerReporter.a("0X8004BB6");
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().b(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getId() == -1L) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      }
      this.a.f();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.c();
    }
    FileManagerReporter.a("0X8004BCC");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ixj
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarLocalFile;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarUtil;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import iwa;

public class ActionBarLocalAppFile
  extends BaseActionBarLocalFile
{
  public ActionBarLocalAppFile(View paramView)
  {
    super(paramView);
  }
  
  public void a(Activity paramActivity)
  {
    a(0, "安装", ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().e();
    if ((i == 3) || (i == 0)) {
      b();
    }
    for (;;)
    {
      a(2, "收藏", ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
      a(2, FileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
      super.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
      return;
      if (i == 2) {
        f();
      } else {
        a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
      }
    }
  }
  
  public void b()
  {
    a(0, "继续", new iwa(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarLocalFile.ActionBarLocalAppFile
 * JD-Core Version:    0.7.0.1
 */
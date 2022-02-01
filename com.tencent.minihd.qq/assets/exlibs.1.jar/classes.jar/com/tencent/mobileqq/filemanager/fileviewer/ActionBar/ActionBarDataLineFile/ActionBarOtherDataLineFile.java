package com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarUtil;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

public class ActionBarOtherDataLineFile
  extends BaseActionBarDataLineFile
{
  public ActionBarOtherDataLineFile(View paramView)
  {
    super(paramView);
  }
  
  public void a(Activity paramActivity)
  {
    super.a(paramActivity);
    if (FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName)) {
      c(paramActivity, "用QQ音乐打开", 2130839684, 2130839685, ActionBarUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    }
    for (;;)
    {
      c(paramActivity, "用其他应用打开", 2130839629, 2130839630, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
      d(paramActivity);
      return;
      if (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName)) {
        c(paramActivity, "用QQ浏览器打开", 2130839682, 2130839683, ActionBarUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.ActionBarOtherDataLineFile
 * JD-Core Version:    0.7.0.1
 */
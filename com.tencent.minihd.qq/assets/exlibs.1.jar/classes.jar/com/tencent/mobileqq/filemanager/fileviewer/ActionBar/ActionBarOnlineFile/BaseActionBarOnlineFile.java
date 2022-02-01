package com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarOnlineFile;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarUtil;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseQfileActionBar;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import iwm;
import iwn;

public class BaseActionBarOnlineFile
  extends BaseQfileActionBar
{
  protected String a;
  
  public BaseActionBarOnlineFile(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_JavaLangString = "BaseActionBarWeiyunFile<FileAssistant>";
  }
  
  public void a(Activity paramActivity)
  {
    a(0, "下载原文件", new iwm(this));
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 5) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 6) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 7) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 8) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 9) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 10) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 11) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 12)) {
      a(0, false);
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramObject.a();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      paramObject = paramObject.a();
      if (paramObject == null)
      {
        if (QLog.isDevelopLevel()) {
          throw new NullPointerException("丫的类型是不是搞错了？！");
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = FileManagerUtil.a(paramObject);
      }
    }
    else
    {
      a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), "发给好友", 2130839627, 2130839628, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), 10003, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 3)) {
        break label236;
      }
      b();
    }
    for (;;)
    {
      a(2, "收藏", ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
      a(2, FileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
      c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
      b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
      a(1, false);
      a(2, false);
      a(3, false);
      return;
      label236:
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 2) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 14) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 15)) {
        f();
      } else {
        a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 5) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 6) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 7) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 8) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 9) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 10) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 11) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 12))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b();
      return;
    }
    a(0, "恢复下载", new iwn(this));
  }
  
  public void b(Activity paramActivity)
  {
    b(paramActivity, "存到微云", 2130839637, 2130839638, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    super.b(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarOnlineFile.BaseActionBarOnlineFile
 * JD-Core Version:    0.7.0.1
 */
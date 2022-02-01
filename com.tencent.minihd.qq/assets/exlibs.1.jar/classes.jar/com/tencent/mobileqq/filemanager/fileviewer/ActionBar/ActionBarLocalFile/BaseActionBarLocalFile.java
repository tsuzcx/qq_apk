package com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarLocalFile;

import android.app.Activity;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarUtil;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseQfileActionBar;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;

public abstract class BaseActionBarLocalFile
  extends BaseQfileActionBar
{
  protected String a;
  
  public BaseActionBarLocalFile(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().b();
      if (this.jdField_a_of_type_JavaLangString == null)
      {
        if (!QLog.isDevelopLevel()) {
          break label202;
        }
        throw new NullPointerException("丫的类型是不是搞错了？！");
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = FileManagerUtil.a(new FileInfo(this.jdField_a_of_type_JavaLangString));
        a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), "发给好友", 2130839627, 2130839628, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
        c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 16))
        {
          a(0, false);
          a(1, false);
          a(2, false);
          a(3, false);
        }
        label202:
        return;
      }
      catch (FileNotFoundException paramObject)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = new FileManagerEntity();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType = 3;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath = this.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a();
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().b() != 5) {}
      }
      for (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType = 5;; this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a()))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = -1;
        ((QQAppInterface)BaseApplicationImpl.a().a()).a().d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        break;
      }
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath;
    }
  }
  
  public void b(Activity paramActivity)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8);
    if ((localDataLineHandler != null) && (DataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity))) {
      b(paramActivity, "发送到电脑", 2130839623, 2130839624, ActionBarUtil.a(localDataLineHandler, (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().b() == 0) {
      b(paramActivity, "保存到平板", 2130839625, 2130839626, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    }
    b(paramActivity, "存到微云", 2130839637, 2130839638, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), paramActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    super.b(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarLocalFile.BaseActionBarLocalFile
 * JD-Core Version:    0.7.0.1
 */
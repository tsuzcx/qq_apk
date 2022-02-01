package com.tencent.mobileqq.filemanager.fileviewer.ActionBar;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.ActionBarAppDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.ActionBarMusciDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.ActionBarOtherDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.ActionBarPicDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarLocalFile.ActionBarLocalAppFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarLocalFile.ActionBarLocalMusciFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarLocalFile.ActionBarLocalOtherFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarLocalFile.ActionBarLocalPicFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarOfflineFile.BaseActionBarOfflineFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarOnlineFile.BaseActionBarOnlineFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarTroopFile.ActionBarTroopFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarWeiYunFile.BaseActionBarWeiyunFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;

public class ActionBarManager
{
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  BaseActionBar.IActionBarClickEvent jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent;
  BaseActionBar jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar;
  IFileBrowser jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser;
  final String jdField_a_of_type_JavaLangString = "ActionBarManager<FileAssistant>";
  
  public ActionBarManager(IFileBrowser paramIFileBrowser, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser = paramIFileBrowser;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent = paramIActionBarClickEvent;
    c();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b().setVisibility(0);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b().setVisibility(8);
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b();
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      ((RelativeLayout)localObject).removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate(((RelativeLayout)localObject).getContext(), 2130903748, null));
    ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ActionBarManager<FileAssistant>", 2, "creater actionbar faild, adapteris null!");
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.e_();
      }
      int i = ((IFileViewerAdapter)localObject).d();
      int j = ((IFileViewerAdapter)localObject).b();
      switch (i)
      {
      }
      while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar == null)
      {
        throw new NullPointerException("your parameter is wrong, pls check your code");
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b();
        switch (j)
        {
        case 2: 
        case 3: 
        case 4: 
        default: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalOtherFile((View)localObject);
          break;
        case 5: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalAppFile((View)localObject);
          break;
        case 0: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalPicFile((View)localObject);
          break;
        case 1: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalMusciFile((View)localObject);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarTroopFile(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b());
          continue;
          localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b();
          switch (j)
          {
          case 2: 
          case 3: 
          case 4: 
          default: 
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarOtherDataLineFile((View)localObject);
            break;
          case 5: 
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarAppDataLineFile((View)localObject);
            break;
          case 0: 
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarPicDataLineFile((View)localObject);
            break;
          case 1: 
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarMusciDataLineFile((View)localObject);
            continue;
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new BaseActionBarOfflineFile(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b());
            continue;
            if (FileUtil.b(((IFileViewerAdapter)localObject).b()))
            {
              localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b();
              switch (j)
              {
              case 2: 
              case 3: 
              case 4: 
              default: 
                this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalOtherFile((View)localObject);
                break;
              case 5: 
                this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalAppFile((View)localObject);
                break;
              case 0: 
                this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalPicFile((View)localObject);
                break;
              case 1: 
                this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalMusciFile((View)localObject);
                break;
              }
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new BaseActionBarWeiyunFile(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b());
              continue;
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new BaseActionBarOnlineFile(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b());
            }
            break;
          }
          break;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b()) {
        b();
      }
      while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.e())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.a(1, false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.a(2, false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.a(3, false);
        return;
        a();
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.e_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarManager
 * JD-Core Version:    0.7.0.1
 */
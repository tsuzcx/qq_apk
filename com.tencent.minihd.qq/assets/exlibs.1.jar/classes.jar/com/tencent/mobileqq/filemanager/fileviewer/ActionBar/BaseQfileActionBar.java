package com.tencent.mobileqq.filemanager.fileviewer.ActionBar;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import ixp;
import ixq;

public abstract class BaseQfileActionBar
  extends BaseActionBar
{
  protected Button a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  public ProgressBar a;
  public TextView a;
  protected FMObserver a;
  public FileManagerEntity a;
  public IFileBrowser a;
  private final String jdField_a_of_type_JavaLangString = "BaseActionBar<FileAssistant>";
  RelativeLayout b = null;
  
  public BaseQfileActionBar(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseActionBar<FileAssistant>", 2, "actbarmemoryleaktest ProgressEvent this " + this + " is added");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new ixq(this);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
  
  public abstract void a(Activity paramActivity);
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IFileBrowser))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser = ((IFileBrowser)paramObject);
      a();
    }
    while (!QLog.isDevelopLevel()) {
      return;
    }
    throw new NullPointerException("init类型错误,请检查堆栈");
  }
  
  public abstract void b();
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseActionBar<FileAssistant>", 2, "actbarmemoryleaktest ProgressEvent this " + this + " is delete");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
  }
  
  public void e()
  {
    this.b.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status)
    {
    case 1: 
    case 2: 
    default: 
      return;
    }
    b();
  }
  
  public void e_()
  {
    d();
  }
  
  public void f()
  {
    this.b.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    if (this.jdField_a_of_type_AndroidWidgetButton == null)
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.b.findViewById(2131299486));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ixp(this));
    }
    if (this.jdField_a_of_type_AndroidWidgetProgressBar == null)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.b.findViewById(2131299485));
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F));
    }
    long l;
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.b.findViewById(2131299484));
      l = ((float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize * this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress);
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType != 6) && ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 8) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 1) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 5))) {
        break label283;
      }
    }
    label283:
    for (String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getString(2131362423) + "(" + FileUtil.a(l) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")";; str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getString(2131362424) + "(" + FileUtil.a(l) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")")
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseQfileActionBar
 * JD-Core Version:    0.7.0.1
 */
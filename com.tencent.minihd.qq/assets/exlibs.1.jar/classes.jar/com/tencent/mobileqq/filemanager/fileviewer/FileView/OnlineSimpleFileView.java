package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;

public class OnlineSimpleFileView
  extends FileViewBase
{
  private static final String jdField_a_of_type_JavaLangString = "OnlineSimpleFileView";
  private View jdField_a_of_type_AndroidViewView;
  
  public OnlineSimpleFileView(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private String b()
  {
    switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.f())
    {
    case 0: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("OnlineSimpleFileView", 2, "getFileTips: opType[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.f() + "not implemented");
      }
      break;
    }
    do
    {
      do
      {
        return null;
        switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.e())
        {
        }
      } while (!QLog.isColorLevel());
      QLog.e("OnlineSimpleFileView", 2, "getFileTips: opType[OPERATION_TYPE_OLFILE_BE_PC_HANDLED] status[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.e() + "not implemented");
      return null;
      return BaseApplicationImpl.getContext().getString(2131362489);
      return BaseApplicationImpl.getContext().getString(2131362490);
      return BaseApplicationImpl.getContext().getString(2131362491);
      switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.e())
      {
      }
    } while (!QLog.isColorLevel());
    QLog.e("OnlineSimpleFileView", 2, "getFileTips: opType[OPERATION_TYPE_OLFILE_GOTO_UPLOAD] status[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.e() + "not implemented");
    return null;
    return BaseApplicationImpl.getContext().getString(2131362492);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null) {
      if (QLog.isDevelopLevel()) {
        QLog.w("OnlineSimpleFileView", 4, "initVarView: but adapter is null");
      }
    }
    Object localObject;
    do
    {
      return;
      localObject = (AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299573);
      String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
      ((AsyncImageView)localObject).setImageResource(FileManagerUtil.b(str));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299503)).setText(str);
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299574)).setText(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()));
      localObject = b();
    } while (localObject == null);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299575)).setText((CharSequence)localObject);
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130903778, paramViewGroup, false);
    e();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.OnlineSimpleFileView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;

public class LocalSimpleFileView
  extends FileViewBase
{
  private View jdField_a_of_type_AndroidViewView;
  private final String jdField_a_of_type_JavaLangString = "LocalSimpleFileView";
  
  public LocalSimpleFileView(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("LocalSimpleFileView", 4, "initVarView: but adapter is null");
      }
      return;
    }
    Object localObject = (AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299573);
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    ((AsyncImageView)localObject).setImageResource(FileManagerUtil.b(str));
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299503)).setText(str);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299574)).setText(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()));
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299575);
    BaseApplicationImpl.getContext().getString(2131362483);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.e() == 16) {
      localObject = BaseApplicationImpl.getContext().getString(2131362483);
    }
    for (;;)
    {
      localTextView.setText((CharSequence)localObject);
      return;
      str = BaseApplicationImpl.getContext().getString(2131362455);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.d() != 7)
      {
        localObject = str;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.d() != 6) {}
      }
      else
      {
        localObject = str;
        if (!FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b()))
        {
          localObject = str;
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() != null)
          {
            localObject = str;
            if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().bSend) {
              localObject = BaseApplicationImpl.getContext().getString(2131367611);
            }
          }
        }
      }
    }
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130903778, paramViewGroup, false);
    e();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public String a()
  {
    return BaseApplicationImpl.getContext().getString(2131362410);
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalSimpleFileView
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;

public class LocalApkFileView
  extends FileViewBase
{
  private View jdField_a_of_type_AndroidViewView;
  private final String jdField_a_of_type_JavaLangString = "LocalApkFileViewer";
  
  public LocalApkFileView(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("LocalApkFileViewer", 4, "initVarView: but adapter is null");
      }
      return;
    }
    Object localObject = (AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299573);
    ((AsyncImageView)localObject).setDefaultImage(2130839640);
    ((AsyncImageView)localObject).setApkIconAsyncImage(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.d());
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299503)).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299574)).setText(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()));
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299576)).setText(BaseApplicationImpl.getContext().getString(2131362456));
    localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299575);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.e() == 16)
    {
      ((TextView)localObject).setText(BaseApplicationImpl.getContext().getString(2131362483));
      return;
    }
    ((TextView)localObject).setVisibility(8);
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130903776, paramViewGroup, false);
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalApkFileView
 * JD-Core Version:    0.7.0.1
 */
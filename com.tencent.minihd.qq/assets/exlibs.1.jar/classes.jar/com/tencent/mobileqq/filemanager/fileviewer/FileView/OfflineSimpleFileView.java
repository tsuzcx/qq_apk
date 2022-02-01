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
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;

public class OfflineSimpleFileView
  extends FileViewBase
{
  private static final String jdField_a_of_type_JavaLangString = "OfflineSimpleFileView";
  private View jdField_a_of_type_AndroidViewView;
  
  public OfflineSimpleFileView(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null) {
      if (QLog.isDevelopLevel()) {
        QLog.w("OfflineSimpleFileView", 4, "initVarView: but adapter is null");
      }
    }
    Object localObject;
    do
    {
      return;
      localObject = (AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299573);
      if (5 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b())
      {
        ((AsyncImageView)localObject).setDefaultImage(2130839640);
        ((AsyncImageView)localObject).setApkIconAsyncImage(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.d());
      }
      for (;;)
      {
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299503)).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299574)).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c());
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299576)).setVisibility(8);
        localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299575);
        if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().isFromProcessingForward2c2cOrDiscItem()) {
          break;
        }
        ((TextView)localObject).setText(BaseApplicationImpl.getContext().getString(2131362554));
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.g() != null) {
          ((AsyncImageView)localObject).setAsyncImage(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.g());
        } else {
          ((AsyncImageView)localObject).setImageResource(FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()));
        }
      }
    } while ((!FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a())) || (1 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().cloudType));
    ((TextView)localObject).setText(BaseApplicationImpl.getContext().getString(2131362483));
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130903776, paramViewGroup, false);
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineSimpleFileView
 * JD-Core Version:    0.7.0.1
 */
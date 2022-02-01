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
import ixx;

public class CanPreviewOfflineFileView
  extends FileViewBase
{
  private View jdField_a_of_type_AndroidViewView;
  private final String jdField_a_of_type_JavaLangString = "CanPreviewOfflineFileView";
  
  public CanPreviewOfflineFileView(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null) {
      if (QLog.isDevelopLevel()) {
        QLog.w("CanPreviewOfflineFileView", 4, "initVarView: but adapter is null");
      }
    }
    TextView localTextView1;
    TextView localTextView2;
    do
    {
      return;
      ((AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299573)).setImageResource(FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299503)).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299574)).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c());
      localTextView1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299577);
      localTextView2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299575);
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
      if ((localFileManagerEntity != null) && (localFileManagerEntity.isFromProcessingForward2c2cOrDiscItem()))
      {
        localTextView1.setVisibility(8);
        localTextView2.setVisibility(0);
        localTextView2.setText(BaseApplicationImpl.getContext().getString(2131362554));
        return;
      }
      if (!FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()))
      {
        localTextView2.setVisibility(8);
        localTextView1.setVisibility(0);
        localTextView1.setOnClickListener(new ixx(this));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.d() == 1)
      {
        localTextView1.setVisibility(8);
        localTextView2.setVisibility(0);
        localTextView2.setText(BaseApplicationImpl.getContext().getString(2131362483));
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.d() != 3);
    localTextView1.setVisibility(8);
    localTextView2.setVisibility(0);
    localTextView2.setText(BaseApplicationImpl.getContext().getString(2131362455));
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130903777, paramViewGroup, false);
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.CanPreviewOfflineFileView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import izx;

public class PreviewingTroopFileView
  extends PreviewingOfflineFileViewBase
{
  public static final String a = "PreviewingTroopFileView";
  private final PreviewingOfflineFileViewBase.IControllProxyInterface a;
  
  public PreviewingTroopFileView(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase$IControllProxyInterface = new izx(this, paramQQAppInterface);
  }
  
  protected PreviewingOfflineFileViewBase.IControllProxyInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase$IControllProxyInterface;
  }
  
  public IFileViewerAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingTroopFileView
 * JD-Core Version:    0.7.0.1
 */
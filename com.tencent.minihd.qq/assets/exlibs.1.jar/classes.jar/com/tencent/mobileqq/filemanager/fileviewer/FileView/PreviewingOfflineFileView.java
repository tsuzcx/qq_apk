package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import iza;

public class PreviewingOfflineFileView
  extends PreviewingOfflineFileViewBase
{
  private static final String jdField_a_of_type_JavaLangString = "PreviewingOfflineFileView<FileAssistant>";
  private final PreviewingOfflineFileViewBase.IControllProxyInterface jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase$IControllProxyInterface;
  
  public PreviewingOfflineFileView(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase$IControllProxyInterface = new iza(this, paramQQAppInterface);
  }
  
  protected PreviewingOfflineFileViewBase.IControllProxyInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase$IControllProxyInterface;
  }
  
  public boolean a()
  {
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileView
 * JD-Core Version:    0.7.0.1
 */
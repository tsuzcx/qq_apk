import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import mqq.app.AppRuntime;

public class izh
  implements Runnable
{
  public izh(PreviewingOfflineFileViewBase paramPreviewingOfflineFileViewBase, boolean paramBoolean, long paramLong, String paramString) {}
  
  public void run()
  {
    if (PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase) == null) {
      return;
    }
    PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).a();
    if (this.jdField_a_of_type_Boolean)
    {
      PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).setListenSroll();
      PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, true, 0L, "");
    }
    for (;;)
    {
      PreviewingOfflineFileViewBase.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, false);
      long l1 = System.currentTimeMillis();
      long l2 = PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase);
      FileManagerReporter.fileAssistantReportData localfileAssistantReportData = new FileManagerReporter.fileAssistantReportData();
      localfileAssistantReportData.jdField_b_of_type_JavaLangString = "file_preview_time_more";
      localfileAssistantReportData.jdField_b_of_type_Long = (l1 - l2);
      localfileAssistantReportData.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      localfileAssistantReportData.c = FileUtil.a(PreviewingOfflineFileViewBase.h(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).a());
      localfileAssistantReportData.jdField_a_of_type_Long = PreviewingOfflineFileViewBase.i(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).a();
      FileManagerReporter.a(BaseApplicationImpl.a().a().getAccount(), localfileAssistantReportData);
      return;
      PreviewingOfflineFileViewBase.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase);
      PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, false, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     izh
 * JD-Core Version:    0.7.0.1
 */
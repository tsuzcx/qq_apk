import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.qphone.base.util.QLog;

class ijy
  implements Runnable
{
  ijy(ijx paramijx) {}
  
  public void run()
  {
    if ((this.a.a.h == null) || (this.a.a.h.length() == 0))
    {
      this.a.a.b = false;
      FilePreviewActivity.b(this.a.a);
      return;
    }
    String str1;
    if (this.a.a.jdField_a_of_type_Boolean)
    {
      str1 = "javascript:qpreview.onClientResponse('showFileList', {})";
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('showFileList', {})");
    }
    for (;;)
    {
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "mWebView.loadUrl(" + str1 + ")");
      FileManagerReporter.fileAssistantReportData localfileAssistantReportData = new FileManagerReporter.fileAssistantReportData();
      localfileAssistantReportData.b = "sf_preview_again";
      localfileAssistantReportData.c = FileUtil.a(this.a.a.c);
      localfileAssistantReportData.jdField_a_of_type_Long = this.a.a.jdField_a_of_type_Long;
      FileManagerReporter.a(this.a.a.app.a(), localfileAssistantReportData);
      try
      {
        this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl(str1);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      String str2 = "javascript:qpreview.onClientResponse('addMorePage',{})";
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('addMorePage',{})");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ijy
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.data.FilePreviewDataReporter;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.mobileqq.filemanager.widget.FileWebView.TitilebarEventInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class ikb
  implements FileWebView.TitilebarEventInterface
{
  long jdField_a_of_type_Long = 0L;
  
  public ikb(FilePreviewActivity paramFilePreviewActivity, Handler paramHandler) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.c();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.d();
  }
  
  public void b()
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1000L) {}
    do
    {
      return;
      this.jdField_a_of_type_Long = l;
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.e)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.d();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.l = "3";
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_Long = System.currentTimeMillis();
    }
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.getActivity()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.c.setText(2131367610);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.c.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.c = (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f - this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_JavaLangString = "2";
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.d = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.a(5000);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.e();
    new Handler().postDelayed(new ikc(this), 1500L);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.a(1000);
  }
  
  public void d()
  {
    ikd localikd = new ikd(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(localikd, 3000L);
    QLog.i("<FileAssistant>FilePreviewActivity", 1, "postDelayed(newRunnable, 3000)");
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.runOnUiThread(new ike(this));
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.runOnUiThread(new ikf(this));
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.e) {}
    do
    {
      long l;
      do
      {
        return;
        l = System.currentTimeMillis();
      } while (l - this.jdField_a_of_type_Long < 1000L);
      this.jdField_a_of_type_Long = l;
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl("javascript:qpreview.onClientResponse('addMorePage',{})");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ikb
 * JD-Core Version:    0.7.0.1
 */
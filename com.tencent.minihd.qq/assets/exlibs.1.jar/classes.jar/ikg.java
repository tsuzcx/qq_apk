import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.widget.FileWebView.TitilebarEventInterface;

public class ikg
  implements FileWebView.TitilebarEventInterface
{
  public ikg(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void a() {}
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    if ((this.a.jdField_a_of_type_Boolean) || (this.a.e)) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.l = "3";
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.e = System.currentTimeMillis();
    }
    this.a.runOnUiThread(new ikh(this));
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ikg
 * JD-Core Version:    0.7.0.1
 */
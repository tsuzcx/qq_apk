import android.content.Intent;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.mobileqq.filemanager.widget.FileWebView.JSInterface;
import com.tencent.qphone.base.util.QLog;

public class iju
  implements FileWebView.JSInterface
{
  public iju(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void loadFinish(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool;
    if (paramInt2 == 0)
    {
      bool = true;
      if (paramInt1 != 0) {
        break label66;
      }
      this.a.a(bool, paramInt2, paramString);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.b();
    }
    for (;;)
    {
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "js call loadFinish process Over");
      this.a.e = true;
      this.a.a(1000);
      return;
      bool = false;
      break;
      label66:
      if (paramInt1 == 1) {
        this.a.b(bool, paramInt2, paramString);
      }
    }
  }
  
  public void loadFinish(int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
  {
    if (paramInt2 == 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.a.runOnUiThread(new ijw(this, paramInt1, paramBoolean, paramInt2, paramString));
      this.a.e = true;
      this.a.a(1000);
      return;
    }
  }
  
  public void openFile(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Intent localIntent = new Intent(this.a, FilePreviewActivity.class);
      localIntent.putExtra("offline_file_type", 1);
      localIntent.putExtra("offline_file_name", this.a.c);
      localIntent.putExtra("offline_file_url", this.a.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("offline_file_bZip", this.a.jdField_a_of_type_Boolean);
      localIntent.putExtra("offline_file_domain", this.a.h);
      localIntent.putExtra("offline_file_port", this.a.i);
      localIntent.putExtra("offline_file_domain_key", this.a.f);
      localIntent.putExtra("offline_file_type_key", this.a.jdField_b_of_type_Int);
      localIntent.putExtra("OfflinePreZipPath", paramString2);
      localIntent.putExtra("OfflinePreZipDirName", paramString1);
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "open zip dic,open new activity");
      this.a.startActivityForResult(localIntent, 0);
    }
  }
  
  public void updatePage(int paramInt1, int paramInt2)
  {
    this.a.runOnUiThread(new ijv(this, paramInt1, paramInt2));
  }
  
  public void webLog(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity_interfacePage", 2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iju
 * JD-Core Version:    0.7.0.1
 */
import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.mobileqq.filemanager.widget.FileWebView.JSInterface;
import com.tencent.qphone.base.util.QLog;

public class izi
  implements FileWebView.JSInterface
{
  public izi(PreviewingOfflineFileViewBase paramPreviewingOfflineFileViewBase) {}
  
  public void loadFinish(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool;
    if (paramInt2 == 0)
    {
      bool = true;
      if (paramInt1 != 0) {
        break label68;
      }
      this.a.a(bool, paramInt2, paramString, paramString);
      PreviewingOfflineFileViewBase.a(this.a).b();
    }
    for (;;)
    {
      QLog.i("PreviewingOfflineFileViewBase<FileAssistant>", 1, "js call loadFinish");
      PreviewingOfflineFileViewBase.e(this.a, true);
      PreviewingOfflineFileViewBase.a(this.a, 1000);
      return;
      bool = false;
      break;
      label68:
      if (paramInt1 == 1) {
        this.a.b(bool, paramInt2, paramString, paramString);
      }
    }
  }
  
  public void loadFinish(int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
  {
    boolean bool;
    if (paramInt2 == 0)
    {
      bool = true;
      if (paramInt1 != 0) {
        break label81;
      }
      this.a.a(bool, paramInt2, paramString, paramString);
      PreviewingOfflineFileViewBase.a(this.a).b();
      label36:
      paramString = this.a;
      if (paramBoolean) {
        break label120;
      }
    }
    label81:
    label120:
    for (paramBoolean = true;; paramBoolean = false)
    {
      PreviewingOfflineFileViewBase.e(paramString, paramBoolean);
      PreviewingOfflineFileViewBase.c(this.a, false);
      PreviewingOfflineFileViewBase.a(this.a, 1000);
      return;
      bool = false;
      break;
      if (paramInt1 == 1)
      {
        this.a.b(bool, paramInt2, paramString, paramString);
        break label36;
      }
      if (!QLog.isDevelopLevel()) {
        break label36;
      }
      throw new NullPointerException("接口页返回了错误的 stage！");
    }
  }
  
  public void openFile(String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void updatePage(int paramInt1, int paramInt2)
  {
    PreviewingOfflineFileViewBase.h(this.a).runOnUiThread(new izj(this, paramInt1, paramInt2));
  }
  
  public void webLog(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PreviewingOfflineFileViewBase<FileAssistant>_interfacePage", 2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     izi
 * JD-Core Version:    0.7.0.1
 */
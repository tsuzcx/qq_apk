import android.app.Activity;
import android.os.Build.VERSION;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.net.URLDecoder;

public class izk
  extends WebViewClient
{
  public izk(PreviewingOfflineFileViewBase paramPreviewingOfflineFileViewBase) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (PreviewingOfflineFileViewBase.a(this.a) == null) {
      return;
    }
    PreviewingOfflineFileViewBase.a(this.a).runOnUiThread(new izl(this));
    super.onPageFinished(paramWebView, paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    for (;;)
    {
      try
      {
        String str = URLDecoder.decode(paramString, "UTF-8");
        paramString = str;
      }
      catch (Exception localException)
      {
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("PreviewingOfflineFileViewBase<FileAssistant>", 1, "URLDecoder.decode, url:" + paramString);
        }
        if (!PreviewingOfflineFileViewBase.a(this.a).a(paramWebView, paramString, this.a.a)) {
          continue;
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("PreviewStep_6", 4, "recv js callBack[" + paramString + "]");
        }
      }
      catch (Exception paramWebView)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PreviewingOfflineFileViewBase<FileAssistant>", 2, "parseUrl error,exception:" + paramWebView.toString());
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.i("PreviewStep_6", 4, "recv js callBack[" + paramString + "]");
        if ((!paramString.equals("about:blank;")) && (!paramString.equals("about:blank"))) {
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("PreviewingOfflineFileViewBase<FileAssistant>", 2, "shouldOverrideUrlLoading about:blank; " + paramString);
        if (Build.VERSION.SDK_INT < 11) {
          continue;
        }
        return false;
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     izk
 * JD-Core Version:    0.7.0.1
 */
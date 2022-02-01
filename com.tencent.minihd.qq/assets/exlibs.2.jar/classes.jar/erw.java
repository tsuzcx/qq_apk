import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.filemanager.app.UniformDownload;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.DownloadListener;

public class erw
  implements DownloadListener
{
  public erw(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "start UniformDownloadActivity");
    }
    if (this.a.a != null) {}
    for (String str = this.a.a.getUrl();; str = null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("_filesize", paramLong);
      localBundle.putString("param_user_agent", paramString2);
      localBundle.putString("param_content_des", paramString3);
      localBundle.putString("param_mime_type", paramString4);
      localBundle.putString("param_refer_url", str);
      UniformDownload.a(this.a, paramString1, localBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     erw
 * JD-Core Version:    0.7.0.1
 */
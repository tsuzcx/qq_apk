import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloader.IUniformDownloaderListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class iui
  implements UniformDownloader.IUniformDownloaderListener
{
  public iui(UniformDownloadMgr paramUniformDownloadMgr) {}
  
  public void a(int paramInt, Bundle paramBundle) {}
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    UniformDownloadMgr.a(this.a);
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    ReportController.b(null, "P_CliOper", "webview", "", "webview_apk_download", "download_success", 0, 1, 0, "", "", "", "");
    paramBundle.getInt("_CB_SID");
    paramBundle = paramBundle.getString("_CB_URL");
    UniformDownloadMgr.a(this.a, paramBundle);
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>insertFM and install. PH:" + paramString + " SZ:" + paramLong);
    if (this.a.a != null) {
      this.a.a.a().a(null, -1, paramString, paramLong, 16, null, null);
    }
    for (;;)
    {
      UniformDownloadUtil.a(paramString);
      UniformDownloadMgr.a(this.a);
      if ("https://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean".equals(paramBundle)) {
        ReportController.b(null, "P_CliOper", "Safe_SpaceClean", "", "SpaceClean_", "download secure apk sucess", 0, 0, "", "", "", "");
      }
      return;
      FileManagerUtil.c(paramString);
    }
  }
  
  public void b(int paramInt, Bundle paramBundle) {}
  
  public void c(int paramInt, Bundle paramBundle) {}
  
  public void d(int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iui
 * JD-Core Version:    0.7.0.1
 */
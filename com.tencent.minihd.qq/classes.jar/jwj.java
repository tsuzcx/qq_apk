import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.statistics.MainAcitivityReportHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import java.io.File;
import java.lang.ref.WeakReference;

class jwj
  extends DownloadListener
{
  jwj(jwi paramjwi, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    long l = paramDownloadTask.a().getLong("id");
    paramDownloadTask = AvatarPendantUtil.a(new File(AvatarPendantUtil.a(l, 4)));
    if (this.a.a.a != null)
    {
      SplashActivity localSplashActivity = (SplashActivity)this.a.a.a.get();
      if (localSplashActivity != null) {
        ReportController.b(localSplashActivity.app, "CliStatus", "", "", "AvatarPendant", "AvatarPendantOn", 0, 0, String.valueOf(l), paramDownloadTask, "", "");
      }
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     jwj
 * JD-Core Version:    0.7.0.1
 */
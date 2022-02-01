import android.os.Handler;
import android.os.Looper;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener;
import com.tencent.open.downloadnew.MyAppDialog;

public class lhp
  implements Runnable
{
  public lhp(MyAppApi.YYBDownloadListener paramYYBDownloadListener, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener.a.a != null) && (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener.a.a.isShowing())) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener.a.a.dismiss();
    }
    DownloadManager.a().c(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
    new Handler(Looper.getMainLooper()).postAtTime(new lhq(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lhp
 * JD-Core Version:    0.7.0.1
 */
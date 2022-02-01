import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.ControlPolicyUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener;

public class lhr
  implements Runnable
{
  public lhr(MyAppApi.YYBDownloadListener paramYYBDownloadListener, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    LogUtility.c("MyAppApi", "rooted and start silent install...");
    long l = System.currentTimeMillis();
    if (ControlPolicyUtil.a(l))
    {
      if ((AppUtil.a()) && (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.k))) {
        AppUtil.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.k);
      }
    }
    else {
      return;
    }
    LogUtility.c("MyAppApi", "root confused and remember user operation time!");
    ControlPolicyUtil.a(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lhr
 * JD-Core Version:    0.7.0.1
 */
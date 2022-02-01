import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.config.QQMapConstants;

public class etd
  implements Runnable
{
  public etd(QQMapActivity paramQQMapActivity) {}
  
  public void run()
  {
    OfflineDownloader.a(this.a.getApplicationContext(), this.a.q, QQMapConstants.i, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     etd
 * JD-Core Version:    0.7.0.1
 */
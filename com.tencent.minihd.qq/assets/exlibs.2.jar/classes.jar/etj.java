import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.mobileqq.activity.QQMapActivity;

public class etj
  implements Runnable
{
  public etj(QQMapActivity paramQQMapActivity) {}
  
  public void run()
  {
    OfflineDownloader.b(this.a.q);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     etj
 * JD-Core Version:    0.7.0.1
 */
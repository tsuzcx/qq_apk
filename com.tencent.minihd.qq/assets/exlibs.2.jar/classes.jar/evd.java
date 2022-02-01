import com.tencent.mobileqq.activity.QQSpaceCleanActivity;
import com.tencent.mobileqq.utils.HttpDownloadUtil;

public class evd
  implements Runnable
{
  public evd(QQSpaceCleanActivity paramQQSpaceCleanActivity) {}
  
  public void run()
  {
    HttpDownloadUtil.a(this.a.app, "https://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean", this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     evd
 * JD-Core Version:    0.7.0.1
 */
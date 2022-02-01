import com.tencent.mobileqq.activity.SecurityProtectActivity;
import com.tencent.mobileqq.utils.HttpDownloadUtil;

public class ezm
  implements Runnable
{
  public ezm(SecurityProtectActivity paramSecurityProtectActivity) {}
  
  public void run()
  {
    HttpDownloadUtil.a(this.a.app, this.a.a, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ezm
 * JD-Core Version:    0.7.0.1
 */
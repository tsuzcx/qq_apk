package sm;

import android.content.Intent;
import com.tencent.securemodule.impl.SecureService;

public class z
  implements Runnable
{
  public z(SecureService paramSecureService, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      if ("1000010".equals(this.a.getAction()))
      {
        SecureService.b(this.b);
        SecureService.c(this.b);
        SecureService.d(this.b);
        SecureService.e(this.b);
      }
      while ((!SecureService.f(this.b)) && (SecureService.g(this.b) == 0))
      {
        this.b.stopSelf();
        SecureService.a(this.b);
        return;
        if ("1000011".equals(this.a.getAction()))
        {
          SecureService.b(this.b, this.a.getBooleanExtra("key_download_listener", false));
          SecureService.b(this.b, "http://fwd.3g.qq.com:8080/forward.jsp?bid=882");
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      this.b.stopSelf();
      SecureService.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     sm.z
 * JD-Core Version:    0.7.0.1
 */
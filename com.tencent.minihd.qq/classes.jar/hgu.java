import android.os.Handler;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class hgu
  implements Runnable
{
  public hgu(BrowserAppInterface paramBrowserAppInterface) {}
  
  public void run()
  {
    boolean bool = WebView.getTbsNeedReboot();
    if (QLog.isColorLevel()) {
      QLog.d(BrowserAppInterface.b, 2, "tbs need reboot: " + bool);
    }
    if (bool) {
      this.a.a(BrowserAppInterface.class).postDelayed(new hgv(this), 3000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hgu
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.TbsLogClient;

public class hgs
  extends TbsLogClient
{
  public hgs(BrowserAppInterface paramBrowserAppInterface, Context paramContext)
  {
    super(paramContext);
  }
  
  public void d(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public void e(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.e(paramString1, 2, paramString2);
    }
  }
  
  public void i(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public void showLog(String paramString)
  {
    if (this.a.a == -1) {
      this.a.a = 0;
    }
    if (this.a.a == 1) {
      this.a.a(BrowserAppInterface.class).post(new hgw(this.a, paramString));
    }
  }
  
  public void w(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(paramString1, 2, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hgs
 * JD-Core Version:    0.7.0.1
 */
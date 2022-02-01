import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.trick.TrickHelper;
import com.tencent.qphone.base.util.QLog;

public class kbg
  implements Runnable
{
  public kbg(TrickHelper paramTrickHelper) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TrickHelper", 2, "Runnable tricking=" + TrickHelper.a + ",needCheck=" + TrickHelper.b);
    }
    if ((TrickHelper.b) && (!TrickHelper.a(this.a))) {
      ThreadManager.a().postDelayed(this, 2000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     kbg
 * JD-Core Version:    0.7.0.1
 */
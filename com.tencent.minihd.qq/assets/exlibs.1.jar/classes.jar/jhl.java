import MyCarrier.Carrier;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.mybusiness.MyBusinessObserver;
import com.tencent.qphone.base.util.QLog;

public class jhl
  extends MyBusinessObserver
{
  public jhl(MyBusinessManager paramMyBusinessManager) {}
  
  public void a(boolean paramBoolean, Carrier paramCarrier, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MyBusinessManager", 4, "onCarrierQuery refreshTimeSpan = " + paramInt);
    }
    this.a.a = paramInt;
    if (this.a.a > 86400) {
      this.a.a = 86400;
    }
    ThreadManager.a().post(new jhm(this, paramCarrier));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jhl
 * JD-Core Version:    0.7.0.1
 */
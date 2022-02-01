import android.hardware.SensorManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class hgj
  implements Runnable
{
  public hgj(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    if (BaseActivity.access$200() == null)
    {
      hgm localhgm = new hgm(null);
      SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
      localSensorManager.registerListener(localhgm, localSensorManager.getDefaultSensor(1), 0);
      BaseActivity.access$202(localhgm);
      if (QLog.isDevelopLevel()) {
        QLog.d("qqBaseActivity", 4, "turnOnShake");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hgj
 * JD-Core Version:    0.7.0.1
 */
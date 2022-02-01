import android.hardware.SensorManager;
import com.tencent.mobileqq.app.BaseActivity2;

public class hgn
  extends Thread
{
  public hgn(BaseActivity2 paramBaseActivity2) {}
  
  public void run()
  {
    hgp localhgp = new hgp(null);
    SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
    localSensorManager.registerListener(localhgp, localSensorManager.getDefaultSensor(1), 0);
    BaseActivity2.a(localhgp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hgn
 * JD-Core Version:    0.7.0.1
 */
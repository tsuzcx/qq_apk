import android.os.Handler;
import cooperation.qzone.util.QZoneDistributedAppCtrl;

public class mdj
  implements Runnable
{
  public mdj(QZoneDistributedAppCtrl paramQZoneDistributedAppCtrl) {}
  
  public void run()
  {
    QZoneDistributedAppCtrl.a(this.a);
    QZoneDistributedAppCtrl.a(this.a).removeCallbacks(QZoneDistributedAppCtrl.a(this.a));
    QZoneDistributedAppCtrl.a(this.a).postDelayed(QZoneDistributedAppCtrl.a(this.a), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mdj
 * JD-Core Version:    0.7.0.1
 */
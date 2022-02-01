import com.tencent.qav.monitor.PhoneStatusMonitor;
import com.tencent.qav.monitor.PhoneStatusMonitor.PhoneStatusListener;
import com.tencent.qav.monitor.PhoneStatusTools;

class ljt
  implements Runnable
{
  ljt(ljs paramljs) {}
  
  public void run()
  {
    boolean bool = PhoneStatusTools.e(PhoneStatusMonitor.a(this.a.a));
    if ((PhoneStatusMonitor.a(this.a.a)) && (!bool))
    {
      PhoneStatusMonitor.a(this.a.a, false);
      if (PhoneStatusMonitor.a(this.a.a) != null) {
        PhoneStatusMonitor.a(this.a.a).c(false);
      }
    }
    do
    {
      do
      {
        return;
      } while ((PhoneStatusMonitor.a(this.a.a)) || (!bool));
      PhoneStatusMonitor.a(this.a.a, true);
    } while (PhoneStatusMonitor.a(this.a.a) == null);
    PhoneStatusMonitor.a(this.a.a).c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ljt
 * JD-Core Version:    0.7.0.1
 */
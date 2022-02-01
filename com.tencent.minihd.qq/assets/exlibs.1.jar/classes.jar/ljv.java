import com.tencent.qav.monitor.PhoneStatusMonitor;
import com.tencent.qav.monitor.PhoneStatusMonitor.PhoneStatusListener;

class ljv
  implements Runnable
{
  ljv(lju paramlju) {}
  
  public void run()
  {
    if (PhoneStatusMonitor.a(this.a.a))
    {
      PhoneStatusMonitor.a(this.a.a, false);
      if (PhoneStatusMonitor.a(this.a.a) != null) {
        PhoneStatusMonitor.a(this.a.a).c(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ljv
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import com.tencent.mobileqq.transfile.NetworkCenter;

public class kaq
  implements Runnable
{
  public kaq(NetworkCenter paramNetworkCenter) {}
  
  public void run()
  {
    this.a.b();
    NetworkCenter.a(this.a).postDelayed(this, 120000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kaq
 * JD-Core Version:    0.7.0.1
 */
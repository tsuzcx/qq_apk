import android.os.Handler;
import com.tencent.mobileqq.activity.flaotaio.FloatHbCircle;

public class gly
  implements Runnable
{
  public gly(FloatHbCircle paramFloatHbCircle) {}
  
  public void run()
  {
    if (FloatHbCircle.a(this.a))
    {
      this.a.a = true;
      this.a.c();
      FloatHbCircle.a(this.a).post(new glz(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gly
 * JD-Core Version:    0.7.0.1
 */
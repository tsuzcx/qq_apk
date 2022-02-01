import android.support.v4.view.ViewPager;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;

class gvm
  implements Runnable
{
  gvm(gvl paramgvl) {}
  
  public void run()
  {
    if (RecentCallHelper.a(this.a.a) != null) {}
    try
    {
      RecentCallHelper.a(this.a.a).endFakeDrag();
      this.a.a.d = false;
      return;
    }
    catch (Exception localException1) {}
    try
    {
      RecentCallHelper.a(this.a.a).endFakeDrag();
      this.a.a.d = false;
      return;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        localException2.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gvm
 * JD-Core Version:    0.7.0.1
 */
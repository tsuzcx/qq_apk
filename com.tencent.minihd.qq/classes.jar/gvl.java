import android.support.v4.view.ViewPager;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;

public class gvl
  implements Runnable
{
  public gvl(RecentCallHelper paramRecentCallHelper) {}
  
  public void run()
  {
    if (RecentCallHelper.a(this.a) != null)
    {
      if ((RecentCallHelper.a(this.a).getChildCount() > 1) && (RecentCallHelper.a(this.a).getCurrentItem() == 0)) {
        break label46;
      }
      this.a.d = false;
    }
    label46:
    while ((!RecentCallHelper.a(this.a).isFakeDragging()) && (!RecentCallHelper.a(this.a).beginFakeDrag())) {
      return;
    }
    float f1 = RecentCallHelper.a(this.a).getWidth() / 40;
    int i = 0;
    int j = 30;
    while (i < 20)
    {
      float f2 = f1;
      if (i == 10)
      {
        f2 = -f1;
        j = 30;
      }
      RecentCallHelper.a(this.a).postDelayed(new gvn(this, f2), i * j);
      i += 1;
      f1 = f2;
    }
    RecentCallHelper.a(this.a).postDelayed(new gvm(this), 700L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gvl
 * JD-Core Version:    0.7.0.1
 */
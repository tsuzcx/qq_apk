import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;

public class gvi
  implements ViewPager.OnPageChangeListener
{
  public gvi(RecentCallHelper paramRecentCallHelper) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    int j = RecentCallHelper.a(this.a).getChildCount();
    int i = 0;
    while (i < j)
    {
      ((ImageView)RecentCallHelper.a(this.a).getChildAt(i)).setImageResource(2130838260);
      i += 1;
    }
    if ((paramInt >= 0) && (paramInt < j)) {
      ((ImageView)RecentCallHelper.a(this.a).getChildAt(paramInt)).setImageResource(2130838259);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gvi
 * JD-Core Version:    0.7.0.1
 */
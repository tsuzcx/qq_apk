import android.support.v4.view.ViewPager;
import com.tencent.biz.addContactTroopView.TroopCardBanner;

class ccb
  implements Runnable
{
  ccb(cca paramcca) {}
  
  public void run()
  {
    int i = TroopCardBanner.a(this.a.a).getCurrentItem();
    TroopCardBanner.a(this.a.a).setCurrentItem(i + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ccb
 * JD-Core Version:    0.7.0.1
 */
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;
import com.tencent.biz.addContactTroopView.TroopCardBanner;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import tencent.im.troop_search_popclassifc.popclassifc.BannerCard;

public class cbz
  implements ViewPager.OnPageChangeListener
{
  public cbz(TroopCardBanner paramTroopCardBanner) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if ((TroopCardBanner.a(this.a) != null) && (TroopCardBanner.a(this.a).rpt_banner_items.size() > 1))
    {
      if (TroopCardBanner.a(this.a) != null) {
        TroopCardBanner.a(this.a).setImageResource(2130837558);
      }
      paramInt %= TroopCardBanner.a(this.a).rpt_banner_items.size();
      ((ImageView)TroopCardBanner.a(this.a).get(paramInt)).setImageResource(2130837557);
      TroopCardBanner.a(this.a, (ImageView)TroopCardBanner.a(this.a).get(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cbz
 * JD-Core Version:    0.7.0.1
 */
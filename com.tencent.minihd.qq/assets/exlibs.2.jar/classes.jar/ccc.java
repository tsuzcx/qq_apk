import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.addContactTroopView.TroopCardBanner;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.List;
import tencent.im.troop_search_popclassifc.popclassifc.BannerCard;
import tencent.im.troop_search_popclassifc.popclassifc.BannerItem;

public class ccc
  extends PagerAdapter
{
  private ccc(TroopCardBanner paramTroopCardBanner) {}
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ((ViewGroup)paramView).removeView((View)paramObject);
  }
  
  public int getCount()
  {
    if ((TroopCardBanner.a(this.a) != null) && (TroopCardBanner.a(this.a).rpt_banner_items.get().size() > 0))
    {
      if (1 == TroopCardBanner.a(this.a).rpt_banner_items.get().size()) {
        return 1;
      }
      return 2147483647;
    }
    return 0;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    paramInt %= TroopCardBanner.a(this.a).rpt_banner_items.size();
    ImageView localImageView = new ImageView(this.a.a);
    localImageView.setImageDrawable(URLDrawable.getDrawable(((popclassifc.BannerItem)TroopCardBanner.a(this.a).rpt_banner_items.get(paramInt)).str_pic_url.get(), null));
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    paramViewGroup.addView(localImageView, -1, -1);
    localImageView.setTag(Integer.valueOf(paramInt));
    localImageView.setOnClickListener(this.a);
    return localImageView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ccc
 * JD-Core Version:    0.7.0.1
 */
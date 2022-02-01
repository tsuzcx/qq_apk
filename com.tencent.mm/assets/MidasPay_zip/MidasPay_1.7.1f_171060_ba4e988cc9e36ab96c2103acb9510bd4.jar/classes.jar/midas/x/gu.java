package midas.x;

import android.os.Parcelable;
import android.view.View;
import com.pay.v4.view.APPagerAdapter;
import com.pay.v4.view.APViewPager;
import java.util.List;

public class gu
  extends APPagerAdapter
{
  private List<View> a;
  
  public gu(List<View> paramList)
  {
    this.a = paramList;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ((APViewPager)paramView).removeView((View)this.a.get(paramInt));
  }
  
  public void finishUpdate(View paramView) {}
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    ((APViewPager)paramView).addView((View)this.a.get(paramInt), 0);
    return this.a.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public Parcelable saveState()
  {
    return null;
  }
  
  public void startUpdate(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.gu
 * JD-Core Version:    0.7.0.1
 */
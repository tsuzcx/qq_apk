package midas.x;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import com.pay.v4.view.APPagerAdapter;
import com.pay.v4.view.APViewPager;
import java.util.List;

public class j7
  extends APPagerAdapter
{
  public List<View> a;
  
  public j7(List<View> paramList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.j7
 * JD-Core Version:    0.7.0.1
 */
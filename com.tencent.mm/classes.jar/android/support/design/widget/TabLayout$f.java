package android.support.design.widget;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import java.lang.ref.WeakReference;

public final class TabLayout$f
  implements ViewPager.OnPageChangeListener
{
  private int mScrollState;
  private final WeakReference<TabLayout> ma;
  private int mb;
  
  public TabLayout$f(TabLayout paramTabLayout)
  {
    this.ma = new WeakReference(paramTabLayout);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    this.mb = this.mScrollState;
    this.mScrollState = paramInt;
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    boolean bool2 = false;
    TabLayout localTabLayout = (TabLayout)this.ma.get();
    if (localTabLayout != null) {
      if ((this.mScrollState == 2) && (this.mb != 1)) {
        break label69;
      }
    }
    label69:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((this.mScrollState != 2) || (this.mb != 0)) {
        bool2 = true;
      }
      localTabLayout.a(paramInt1, paramFloat, bool1, bool2);
      return;
    }
  }
  
  public final void onPageSelected(int paramInt)
  {
    TabLayout localTabLayout = (TabLayout)this.ma.get();
    if ((localTabLayout != null) && (localTabLayout.getSelectedTabPosition() != paramInt) && (paramInt < localTabLayout.getTabCount())) {
      if ((this.mScrollState != 0) && ((this.mScrollState != 2) || (this.mb != 0))) {
        break label66;
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      localTabLayout.b(localTabLayout.K(paramInt), bool);
      return;
    }
  }
  
  final void reset()
  {
    this.mScrollState = 0;
    this.mb = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.TabLayout.f
 * JD-Core Version:    0.7.0.1
 */
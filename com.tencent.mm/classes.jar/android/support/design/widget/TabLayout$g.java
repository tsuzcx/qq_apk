package android.support.design.widget;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import java.lang.ref.WeakReference;

public final class TabLayout$g
  implements ViewPager.OnPageChangeListener
{
  private final WeakReference<TabLayout> tn;
  private int to;
  private int tp;
  
  public TabLayout$g(TabLayout paramTabLayout)
  {
    this.tn = new WeakReference(paramTabLayout);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    this.to = this.tp;
    this.tp = paramInt;
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    boolean bool2 = false;
    TabLayout localTabLayout = (TabLayout)this.tn.get();
    if (localTabLayout != null) {
      if ((this.tp == 2) && (this.to != 1)) {
        break label69;
      }
    }
    label69:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((this.tp != 2) || (this.to != 0)) {
        bool2 = true;
      }
      localTabLayout.a(paramInt1, paramFloat, bool1, bool2);
      return;
    }
  }
  
  public final void onPageSelected(int paramInt)
  {
    TabLayout localTabLayout = (TabLayout)this.tn.get();
    if ((localTabLayout != null) && (localTabLayout.getSelectedTabPosition() != paramInt) && (paramInt < localTabLayout.getTabCount())) {
      if ((this.tp != 0) && ((this.tp != 2) || (this.to != 0))) {
        break label66;
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      localTabLayout.b(localTabLayout.ad(paramInt), bool);
      return;
    }
  }
  
  final void reset()
  {
    this.tp = 0;
    this.to = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.TabLayout.g
 * JD-Core Version:    0.7.0.1
 */
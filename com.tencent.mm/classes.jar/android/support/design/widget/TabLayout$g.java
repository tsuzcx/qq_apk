package android.support.design.widget;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import java.lang.ref.WeakReference;

public final class TabLayout$g
  implements ViewPager.OnPageChangeListener
{
  private final WeakReference<TabLayout> vg;
  private int vh;
  private int vi;
  
  public TabLayout$g(TabLayout paramTabLayout)
  {
    this.vg = new WeakReference(paramTabLayout);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    this.vh = this.vi;
    this.vi = paramInt;
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    boolean bool2 = false;
    TabLayout localTabLayout = (TabLayout)this.vg.get();
    if (localTabLayout != null) {
      if ((this.vi == 2) && (this.vh != 1)) {
        break label69;
      }
    }
    label69:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((this.vi != 2) || (this.vh != 0)) {
        bool2 = true;
      }
      localTabLayout.a(paramInt1, paramFloat, bool1, bool2);
      return;
    }
  }
  
  public final void onPageSelected(int paramInt)
  {
    TabLayout localTabLayout = (TabLayout)this.vg.get();
    if ((localTabLayout != null) && (localTabLayout.getSelectedTabPosition() != paramInt) && (paramInt < localTabLayout.getTabCount())) {
      if ((this.vi != 0) && ((this.vi != 2) || (this.vh != 0))) {
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
    this.vi = 0;
    this.vh = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.TabLayout.g
 * JD-Core Version:    0.7.0.1
 */
package android.support.design.widget;

import android.support.v4.view.ViewPager.e;
import java.lang.ref.WeakReference;

public final class TabLayout$f
  implements ViewPager.e
{
  private final WeakReference<TabLayout> ld;
  int le;
  int lf;
  
  public TabLayout$f(TabLayout paramTabLayout)
  {
    this.ld = new WeakReference(paramTabLayout);
  }
  
  public final void Q(int paramInt)
  {
    this.le = this.lf;
    this.lf = paramInt;
  }
  
  public final void R(int paramInt)
  {
    TabLayout localTabLayout = (TabLayout)this.ld.get();
    if ((localTabLayout != null) && (localTabLayout.getSelectedTabPosition() != paramInt) && (paramInt < localTabLayout.getTabCount())) {
      if ((this.lf != 0) && ((this.lf != 2) || (this.le != 0))) {
        break label66;
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      localTabLayout.b(localTabLayout.L(paramInt), bool);
      return;
    }
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2)
  {
    boolean bool2 = false;
    TabLayout localTabLayout = (TabLayout)this.ld.get();
    if (localTabLayout != null) {
      if ((this.lf == 2) && (this.le != 1)) {
        break label69;
      }
    }
    label69:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((this.lf != 2) || (this.le != 0)) {
        bool2 = true;
      }
      localTabLayout.a(paramInt1, paramFloat, bool1, bool2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.design.widget.TabLayout.f
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.material.tabs;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class TabLayout$f
  implements ViewPager.OnPageChangeListener
{
  private final WeakReference<TabLayout> dyN;
  private int dyO;
  private int dyP;
  
  public TabLayout$f(TabLayout paramTabLayout)
  {
    AppMethodBeat.i(208931);
    this.dyN = new WeakReference(paramTabLayout);
    AppMethodBeat.o(208931);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.dyO = this.dyP;
    this.dyP = paramInt;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(208937);
    TabLayout localTabLayout = (TabLayout)this.dyN.get();
    if (localTabLayout != null) {
      if ((this.dyP == 2) && (this.dyO != 1)) {
        break label79;
      }
    }
    label79:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((this.dyP != 2) || (this.dyO != 0)) {
        bool2 = true;
      }
      localTabLayout.a(paramInt1, paramFloat, bool1, bool2);
      AppMethodBeat.o(208937);
      return;
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(208942);
    TabLayout localTabLayout = (TabLayout)this.dyN.get();
    if ((localTabLayout != null) && (localTabLayout.getSelectedTabPosition() != paramInt) && (paramInt < localTabLayout.getTabCount())) {
      if ((this.dyP != 0) && ((this.dyP != 2) || (this.dyO != 0))) {
        break label76;
      }
    }
    label76:
    for (boolean bool = true;; bool = false)
    {
      localTabLayout.b(localTabLayout.js(paramInt), bool);
      AppMethodBeat.o(208942);
      return;
    }
  }
  
  final void reset()
  {
    this.dyP = 0;
    this.dyO = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayout.f
 * JD-Core Version:    0.7.0.1
 */
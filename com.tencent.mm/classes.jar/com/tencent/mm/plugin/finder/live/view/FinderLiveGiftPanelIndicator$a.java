package com.tencent.mm.plugin.finder.live.view;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.bk;
import com.tencent.mm.plugin.finder.live.utils.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/view/FinderLiveGiftPanelIndicator$attachViewPager$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "p0", "", "onPageScrolled", "p1", "", "p2", "onPageSelected", "selectedIndex", "plugin-finder_release"})
public final class FinderLiveGiftPanelIndicator$a
  implements ViewPager.OnPageChangeListener
{
  public final void onPageScrollStateChanged(int paramInt) {}
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(280304);
    this.yUm.setCurrentChoosedIndicator(paramInt);
    Object localObject = a.yRm;
    if (!a.dEy())
    {
      localObject = m.yCt;
      m.a(s.bk.yMq, "", 0);
    }
    AppMethodBeat.o(280304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveGiftPanelIndicator.a
 * JD-Core Version:    0.7.0.1
 */
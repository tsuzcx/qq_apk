package com.tencent.mm.plugin.finder.live.view;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.live.s.aw;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/view/FinderLiveGiftPanelIndicator$attachViewPager$1", "Landroid/support/v4/view/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "p0", "", "onPageScrolled", "p1", "", "p2", "onPageSelected", "selectedIndex", "plugin-finder_release"})
public final class FinderLiveGiftPanelIndicator$a
  implements ViewPager.OnPageChangeListener
{
  public final void onPageScrollStateChanged(int paramInt) {}
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(247445);
    this.uyv.setCurrentChoosedIndicator(paramInt);
    Object localObject = com.tencent.mm.plugin.finder.utils.m.vVH;
    if (!com.tencent.mm.plugin.finder.utils.m.dBP())
    {
      localObject = com.tencent.mm.plugin.finder.report.live.m.vli;
      com.tencent.mm.plugin.finder.report.live.m.a(s.aw.vss, "", 0);
    }
    AppMethodBeat.o(247445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveGiftPanelIndicator.a
 * JD-Core Version:    0.7.0.1
 */
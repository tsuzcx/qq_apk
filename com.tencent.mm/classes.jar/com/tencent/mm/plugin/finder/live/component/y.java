package com.tencent.mm.plugin.finder.live.component;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.k;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveNoticePreLoadUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "liveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "plugin-finder_release"})
public final class y
  extends UIComponent
{
  public final k yci;
  
  public y(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(291490);
    this.yci = new k((Activity)paramAppCompatActivity);
    AppMethodBeat.o(291490);
  }
  
  public y(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(291491);
    this.yci = new k(paramFragment);
    AppMethodBeat.o(291491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.y
 * JD-Core Version:    0.7.0.1
 */
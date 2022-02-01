package com.tencent.mm.plugin.finder.feed.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.component.k;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveWinLotteryListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getReportTag", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveWinLotteryListUI
  extends MMFinderUI
{
  public final void _$_clearFindViewByIdCache() {}
  
  public final String efe()
  {
    return "FinderLiveWinLotteryListUI";
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(365542);
    Set localSet = ar.setOf(k.class);
    AppMethodBeat.o(365542);
    return localSet;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveWinLotteryListUI
 * JD-Core Version:    0.7.0.1
 */
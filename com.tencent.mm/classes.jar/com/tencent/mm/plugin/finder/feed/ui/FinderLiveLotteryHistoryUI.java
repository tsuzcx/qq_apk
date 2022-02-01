package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.component.a;
import com.tencent.mm.plugin.finder.live.viewmodel.component.g;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveLotteryHistoryUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getReportTag", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveLotteryHistoryUI
  extends MMFinderUI
{
  public static final a Bph;
  
  static
  {
    AppMethodBeat.i(365768);
    Bph = new a((byte)0);
    AppMethodBeat.o(365768);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final String efe()
  {
    return "FinderLiveLotteryHistoryUI";
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(365774);
    if (getIntent().getBooleanExtra("KEY_IS_FROM_SETTING", false))
    {
      localSet = ar.setOf(a.class);
      AppMethodBeat.o(365774);
      return localSet;
    }
    Set localSet = ar.setOf(g.class);
    AppMethodBeat.o(365774);
    return localSet;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveLotteryHistoryUI$Companion;", "", "()V", "KEY_IS_FROM_SETTING", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveLotteryHistoryUI
 * JD-Core Version:    0.7.0.1
 */
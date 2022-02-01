package com.tencent.mm.plugin.finder.feed.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.v;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveNewFansUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveNewFansUI
  extends MMFinderUI
{
  public final void _$_clearFindViewByIdCache() {}
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365583);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    AppMethodBeat.o(365583);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(365587);
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(v.class);
    AppMethodBeat.o(365587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveNewFansUI
 * JD-Core Version:    0.7.0.1
 */
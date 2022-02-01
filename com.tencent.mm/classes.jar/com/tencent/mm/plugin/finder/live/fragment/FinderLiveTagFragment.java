package com.tencent.mm.plugin.finder.live.fragment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.aq;
import com.tencent.mm.plugin.finder.ui.fragment.MMFinderFragment;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveTagFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/MMFinderFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveTagFragment
  extends MMFinderFragment
{
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(350882);
    Set localSet = ar.setOf(aq.class);
    AppMethodBeat.o(350882);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fragment.FinderLiveTagFragment
 * JD-Core Version:    0.7.0.1
 */
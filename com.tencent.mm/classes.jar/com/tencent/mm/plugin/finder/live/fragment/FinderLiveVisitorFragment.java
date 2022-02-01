package com.tencent.mm.plugin.finder.live.fragment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.component.i;
import com.tencent.mm.plugin.finder.live.viewmodel.component.j;
import com.tencent.mm.plugin.finder.ui.fragment.MMFinderFragment;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveVisitorFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/MMFinderFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveVisitorFragment
  extends MMFinderFragment
{
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(350899);
    Set localSet = ar.setOf(new Class[] { i.class, j.class });
    AppMethodBeat.o(350899);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fragment.FinderLiveVisitorFragment
 * JD-Core Version:    0.7.0.1
 */
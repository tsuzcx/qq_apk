package com.tencent.mm.plugin.finder.live.fragment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.q;
import com.tencent.mm.plugin.finder.live.component.r;
import com.tencent.mm.plugin.finder.ui.fragment.MMFinderFragment;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveAnchorFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/MMFinderFragment;", "()V", "isSecondaryDevice", "", "()Z", "setSecondaryDevice", "(Z)V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveAnchorFragment
  extends MMFinderFragment
{
  public boolean CDr;
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(350886);
    if (this.CDr)
    {
      localSet = ar.setOf(q.class);
      AppMethodBeat.o(350886);
      return localSet;
    }
    Set localSet = ar.setOf(r.class);
    AppMethodBeat.o(350886);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fragment.FinderLiveAnchorFragment
 * JD-Core Version:    0.7.0.1
 */
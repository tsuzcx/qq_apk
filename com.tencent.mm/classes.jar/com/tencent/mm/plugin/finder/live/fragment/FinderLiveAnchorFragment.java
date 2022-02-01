package com.tencent.mm.plugin.finder.live.fragment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.h;
import com.tencent.mm.plugin.finder.live.component.i;
import com.tencent.mm.plugin.finder.ui.fragment.MMFinderFragment;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveAnchorFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/MMFinderFragment;", "()V", "isSecondaryDevice", "", "()Z", "setSecondaryDevice", "(Z)V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder_release"})
public final class FinderLiveAnchorFragment
  extends MMFinderFragment
{
  private HashMap _$_findViewCache;
  public boolean yda;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(274734);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(274734);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(274733);
    if (this.yda)
    {
      localSet = ak.setOf(h.class);
      AppMethodBeat.o(274733);
      return localSet;
    }
    Set localSet = ak.setOf(i.class);
    AppMethodBeat.o(274733);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fragment.FinderLiveAnchorFragment
 * JD-Core Version:    0.7.0.1
 */
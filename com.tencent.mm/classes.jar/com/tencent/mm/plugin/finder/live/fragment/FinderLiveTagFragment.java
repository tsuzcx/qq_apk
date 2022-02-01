package com.tencent.mm.plugin.finder.live.fragment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveTagUIC;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveTagFragment;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder_release"})
public final class FinderLiveTagFragment
  extends UIComponentFragment
{
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245984);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245984);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(245983);
    Set localSet = ak.setOf(FinderLiveTagUIC.class);
    AppMethodBeat.o(245983);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fragment.FinderLiveTagFragment
 * JD-Core Version:    0.7.0.1
 */
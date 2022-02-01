package com.tencent.mm.plugin.finder.live.fragment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveAnchorSecDeviceUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveAnchorUIC;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveAnchorFragment;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "()V", "isSecondaryDevice", "", "()Z", "setSecondaryDevice", "(Z)V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder_release"})
public final class FinderLiveAnchorFragment
  extends UIComponentFragment
{
  private HashMap _$_findViewCache;
  public boolean uhI;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245978);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245978);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(245977);
    if (this.uhI)
    {
      localSet = ak.setOf(FinderLiveAnchorSecDeviceUIC.class);
      AppMethodBeat.o(245977);
      return localSet;
    }
    Set localSet = ak.setOf(FinderLiveAnchorUIC.class);
    AppMethodBeat.o(245977);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fragment.FinderLiveAnchorFragment
 * JD-Core Version:    0.7.0.1
 */
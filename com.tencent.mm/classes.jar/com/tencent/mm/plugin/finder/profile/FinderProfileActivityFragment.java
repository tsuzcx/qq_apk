package com.tencent.mm.plugin.finder.profile;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileActivityUIC;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/FinderProfileActivityFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder_release"})
public final class FinderProfileActivityFragment
  extends FinderHomeTabFragment
{
  private HashMap _$_findViewCache;
  
  public FinderProfileActivityFragment()
  {
    this.dLS = 107;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(249962);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(249962);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(249961);
    Set localSet = ak.setOf(FinderProfileActivityUIC.class);
    AppMethodBeat.o(249961);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.FinderProfileActivityFragment
 * JD-Core Version:    0.7.0.1
 */
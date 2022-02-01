package com.tencent.mm.plugin.finder.profile;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileAtFeedUIC;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/FinderProfileAtFeedFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder_release"})
public final class FinderProfileAtFeedFragment
  extends FinderHomeTabFragment
{
  private HashMap _$_findViewCache;
  
  public FinderProfileAtFeedFragment()
  {
    super((byte)0);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(249965);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(249965);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(249964);
    Set localSet = ak.setOf(FinderProfileAtFeedUIC.class);
    AppMethodBeat.o(249964);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.FinderProfileAtFeedFragment
 * JD-Core Version:    0.7.0.1
 */
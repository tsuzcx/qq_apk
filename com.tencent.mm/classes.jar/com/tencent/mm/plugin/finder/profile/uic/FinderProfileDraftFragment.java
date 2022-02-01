package com.tencent.mm.plugin.finder.profile.uic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder_release"})
public final class FinderProfileDraftFragment
  extends FinderHomeTabFragment
{
  private HashMap _$_findViewCache;
  
  public FinderProfileDraftFragment()
  {
    this.dLS = 109;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(250140);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(250140);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(250139);
    Set localSet = ak.setOf(FinderProfileDraftUIC.class);
    AppMethodBeat.o(250139);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.FinderProfileDraftFragment
 * JD-Core Version:    0.7.0.1
 */
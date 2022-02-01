package com.tencent.mm.plugin.finder.profile.uic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder_release"})
public final class FinderProfileMusicFragment
  extends FinderHomeTabFragment
{
  private HashMap _$_findViewCache;
  
  public FinderProfileMusicFragment()
  {
    this.dLS = 108;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(250424);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(250424);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(250423);
    Set localSet = ak.setOf(FinderProfileMusicUIC.class);
    AppMethodBeat.o(250423);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.FinderProfileMusicFragment
 * JD-Core Version:    0.7.0.1
 */
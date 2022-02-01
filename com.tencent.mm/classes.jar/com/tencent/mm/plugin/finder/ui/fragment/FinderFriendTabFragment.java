package com.tencent.mm.plugin.finder.ui.fragment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDoubleClickTipUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderStreamPartialExposeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineUIC;
import com.tencent.mm.ui.component.UIComponent;
import d.a.ak;
import d.l;
import java.util.HashMap;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFriendTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "plugin-finder_release"})
public final class FinderFriendTabFragment
  extends FinderHomeTabFragment
{
  private HashMap _$_findViewCache;
  
  public FinderFriendTabFragment()
  {
    super(2131766501, 1);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(204927);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(204927);
  }
  
  public final Set<Class<? extends UIComponent>> cEg()
  {
    AppMethodBeat.i(204925);
    Set localSet = ak.setOf(new Class[] { FinderTimelineUIC.class, FinderDoubleClickTipUIC.class, FinderStreamPartialExposeUIC.class });
    AppMethodBeat.o(204925);
    return localSet;
  }
  
  public final void cNd()
  {
    AppMethodBeat.i(204926);
    super.cNd();
    ((FinderDoubleClickTipUIC)bj(FinderDoubleClickTipUIC.class)).cQQ();
    ((FinderTimelineUIC)bj(FinderTimelineUIC.class)).cQQ();
    AppMethodBeat.o(204926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment
 * JD-Core Version:    0.7.0.1
 */
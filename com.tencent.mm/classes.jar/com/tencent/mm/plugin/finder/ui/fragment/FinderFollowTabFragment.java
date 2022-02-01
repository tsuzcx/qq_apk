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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFollowTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "plugin-finder_release"})
public final class FinderFollowTabFragment
  extends FinderHomeTabFragment
{
  private HashMap _$_findViewCache;
  
  public FinderFollowTabFragment()
  {
    super(2131766500, 3);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(204923);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(204923);
  }
  
  public final Set<Class<? extends UIComponent>> cEg()
  {
    AppMethodBeat.i(204921);
    Set localSet = ak.setOf(new Class[] { FinderTimelineUIC.class, FinderDoubleClickTipUIC.class, FinderStreamPartialExposeUIC.class });
    AppMethodBeat.o(204921);
    return localSet;
  }
  
  public final void cNd()
  {
    AppMethodBeat.i(204922);
    super.cNd();
    ((FinderTimelineUIC)bj(FinderTimelineUIC.class)).cQQ();
    ((FinderDoubleClickTipUIC)bj(FinderDoubleClickTipUIC.class)).cQQ();
    AppMethodBeat.o(204922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.ui.fragment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDoubleClickTipUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineLbsUIC;
import com.tencent.mm.ui.component.UIComponent;
import d.a.ak;
import d.l;
import java.util.HashMap;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderLbsTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "plugin-finder_release"})
public final class FinderLbsTabFragment
  extends FinderHomeTabFragment
{
  private HashMap _$_findViewCache;
  
  public FinderLbsTabFragment()
  {
    super(2131766502, 2);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(204931);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(204931);
  }
  
  public final Set<Class<? extends UIComponent>> cEg()
  {
    AppMethodBeat.i(204929);
    Set localSet = ak.setOf(new Class[] { FinderTimelineLbsUIC.class, FinderDoubleClickTipUIC.class });
    AppMethodBeat.o(204929);
    return localSet;
  }
  
  public final void cNd()
  {
    AppMethodBeat.i(204930);
    super.cNd();
    ((FinderDoubleClickTipUIC)bj(FinderDoubleClickTipUIC.class)).cQQ();
    ((FinderTimelineLbsUIC)bj(FinderTimelineLbsUIC.class)).cNd();
    AppMethodBeat.o(204930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment
 * JD-Core Version:    0.7.0.1
 */
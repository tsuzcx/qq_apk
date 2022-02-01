package com.tencent.mm.plugin.finder.ui.fragment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDoubleClickTipUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineLbsUIC;
import com.tencent.mm.ui.component.UIComponent;
import d.a.ak;
import d.l;
import java.util.HashMap;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderLbsTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "plugin-finder_release"})
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
    AppMethodBeat.i(204313);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(204313);
  }
  
  public final Set<Class<? extends UIComponent>> cCu()
  {
    AppMethodBeat.i(204311);
    Set localSet = ak.setOf(new Class[] { FinderTimelineLbsUIC.class, FinderDoubleClickTipUIC.class });
    AppMethodBeat.o(204311);
    return localSet;
  }
  
  public final void cKz()
  {
    AppMethodBeat.i(204312);
    super.cKz();
    ((FinderDoubleClickTipUIC)bj(FinderDoubleClickTipUIC.class)).cOl();
    ((FinderTimelineLbsUIC)bj(FinderTimelineLbsUIC.class)).cKz();
    AppMethodBeat.o(204312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment
 * JD-Core Version:    0.7.0.1
 */
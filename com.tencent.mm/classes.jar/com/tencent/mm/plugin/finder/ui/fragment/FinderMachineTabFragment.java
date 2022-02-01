package com.tencent.mm.plugin.finder.ui.fragment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDoubleClickTipUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHotRelatedUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderStreamPartialExposeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineUIC;
import com.tencent.mm.ui.component.UIComponent;
import d.a.ak;
import d.l;
import java.util.HashMap;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderMachineTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "plugin-finder_release"})
public final class FinderMachineTabFragment
  extends FinderHomeTabFragment
{
  private HashMap _$_findViewCache;
  
  public FinderMachineTabFragment()
  {
    super(2131766503, 4);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(204317);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(204317);
  }
  
  public final Set<Class<? extends UIComponent>> cCu()
  {
    AppMethodBeat.i(204315);
    Set localSet = ak.setOf(new Class[] { FinderTimelineUIC.class, FinderDoubleClickTipUIC.class, FinderStreamPartialExposeUIC.class, FinderHotRelatedUIC.class });
    AppMethodBeat.o(204315);
    return localSet;
  }
  
  public final void cKz()
  {
    AppMethodBeat.i(204316);
    super.cKz();
    ((FinderDoubleClickTipUIC)bj(FinderDoubleClickTipUIC.class)).cOl();
    ((FinderTimelineUIC)bj(FinderTimelineUIC.class)).cOl();
    AppMethodBeat.o(204316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment
 * JD-Core Version:    0.7.0.1
 */
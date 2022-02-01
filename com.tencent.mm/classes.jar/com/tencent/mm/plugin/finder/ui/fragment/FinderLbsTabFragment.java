package com.tencent.mm.plugin.finder.ui.fragment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDoubleClickTipUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineLbsUIC;
import com.tencent.mm.ui.component.UIComponent;
import d.a.ak;
import d.l;
import java.util.HashMap;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderLbsTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "plugin-finder_release"})
public final class FinderLbsTabFragment
  extends FinderHomeTabFragment
{
  private HashMap _$_findViewCache;
  
  public FinderLbsTabFragment()
  {
    super(2131766488, 2);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(199511);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(199511);
  }
  
  public final Set<Class<? extends UIComponent>> fTM()
  {
    AppMethodBeat.i(199509);
    Set localSet = ak.setOf(new Class[] { FinderTimelineLbsUIC.class, FinderDoubleClickTipUIC.class });
    AppMethodBeat.o(199509);
    return localSet;
  }
  
  public final void fVI()
  {
    AppMethodBeat.i(199510);
    super.fVI();
    ((FinderDoubleClickTipUIC)bF(FinderDoubleClickTipUIC.class)).fXk();
    ((FinderTimelineLbsUIC)bF(FinderTimelineLbsUIC.class)).fVI();
    AppMethodBeat.o(199510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment
 * JD-Core Version:    0.7.0.1
 */
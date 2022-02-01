package com.tencent.mm.plugin.finder.ui.fragment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDoubleClickTipUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineLbsUIC;
import com.tencent.mm.ui.component.UIComponent;
import d.a.ak;
import d.l;
import java.util.HashMap;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderLbsTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "plugin-finder_release"})
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
    AppMethodBeat.i(203487);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(203487);
  }
  
  public final void cCp()
  {
    AppMethodBeat.i(203486);
    super.cCp();
    ((FinderDoubleClickTipUIC)bh(FinderDoubleClickTipUIC.class)).cFT();
    ((FinderTimelineLbsUIC)bh(FinderTimelineLbsUIC.class)).cCp();
    AppMethodBeat.o(203486);
  }
  
  public final Set<Class<? extends UIComponent>> cwg()
  {
    AppMethodBeat.i(203485);
    Set localSet = ak.setOf(new Class[] { FinderTimelineLbsUIC.class, FinderDoubleClickTipUIC.class });
    AppMethodBeat.o(203485);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment
 * JD-Core Version:    0.7.0.1
 */
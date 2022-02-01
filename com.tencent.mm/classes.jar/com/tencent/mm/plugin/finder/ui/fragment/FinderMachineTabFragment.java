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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderMachineTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "plugin-finder_release"})
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
    AppMethodBeat.i(203491);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(203491);
  }
  
  public final void cCp()
  {
    AppMethodBeat.i(203490);
    super.cCp();
    ((FinderDoubleClickTipUIC)bh(FinderDoubleClickTipUIC.class)).cFT();
    ((FinderTimelineUIC)bh(FinderTimelineUIC.class)).cFT();
    AppMethodBeat.o(203490);
  }
  
  public final Set<Class<? extends UIComponent>> cwg()
  {
    AppMethodBeat.i(203489);
    Set localSet = ak.setOf(new Class[] { FinderTimelineUIC.class, FinderDoubleClickTipUIC.class, FinderStreamPartialExposeUIC.class, FinderHotRelatedUIC.class });
    AppMethodBeat.o(203489);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment
 * JD-Core Version:    0.7.0.1
 */
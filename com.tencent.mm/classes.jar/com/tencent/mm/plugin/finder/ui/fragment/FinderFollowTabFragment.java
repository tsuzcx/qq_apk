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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFollowTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "plugin-finder_release"})
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
    AppMethodBeat.i(203479);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(203479);
  }
  
  public final void cCp()
  {
    AppMethodBeat.i(203478);
    super.cCp();
    ((FinderTimelineUIC)bh(FinderTimelineUIC.class)).cFT();
    ((FinderDoubleClickTipUIC)bh(FinderDoubleClickTipUIC.class)).cFT();
    AppMethodBeat.o(203478);
  }
  
  public final Set<Class<? extends UIComponent>> cwg()
  {
    AppMethodBeat.i(203477);
    Set localSet = ak.setOf(new Class[] { FinderTimelineUIC.class, FinderDoubleClickTipUIC.class, FinderStreamPartialExposeUIC.class });
    AppMethodBeat.o(203477);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment
 * JD-Core Version:    0.7.0.1
 */
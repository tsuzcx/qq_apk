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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFriendTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "plugin-finder_release"})
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
    AppMethodBeat.i(203483);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(203483);
  }
  
  public final void cCp()
  {
    AppMethodBeat.i(203482);
    super.cCp();
    ((FinderDoubleClickTipUIC)bh(FinderDoubleClickTipUIC.class)).cFT();
    ((FinderTimelineUIC)bh(FinderTimelineUIC.class)).cFT();
    AppMethodBeat.o(203482);
  }
  
  public final Set<Class<? extends UIComponent>> cwg()
  {
    AppMethodBeat.i(203481);
    Set localSet = ak.setOf(new Class[] { FinderTimelineUIC.class, FinderDoubleClickTipUIC.class, FinderStreamPartialExposeUIC.class });
    AppMethodBeat.o(203481);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.ui.fragment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderActionBarOverlayUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineLbsUIC;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderLbsTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "plugin-finder_release"})
public final class FinderLbsTabFragment
  extends FinderHomeTabFragment
{
  private HashMap _$_findViewCache;
  
  public FinderLbsTabFragment()
  {
    super(2131760615, 2);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252894);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252894);
  }
  
  public final void dlm()
  {
    AppMethodBeat.i(252893);
    super.dlm();
    ((FinderActionBarOverlayUIC)component(FinderActionBarOverlayUIC.class)).dHX();
    ((FinderTimelineLbsUIC)component(FinderTimelineLbsUIC.class)).dlm();
    AppMethodBeat.o(252893);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(252892);
    Set localSet = ak.setOf(new Class[] { FinderTimelineLbsUIC.class, FinderActionBarOverlayUIC.class });
    AppMethodBeat.o(252892);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment
 * JD-Core Version:    0.7.0.1
 */
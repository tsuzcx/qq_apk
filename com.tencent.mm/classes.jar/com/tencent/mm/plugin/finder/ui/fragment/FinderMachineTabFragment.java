package com.tencent.mm.plugin.finder.ui.fragment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderActionBarOverlayUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFullFeedGuideUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHorizontalVideoPreviewUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHotRelatedUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderStreamPartialExposeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineUIC;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderMachineTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "plugin-finder_release"})
public final class FinderMachineTabFragment
  extends FinderHomeTabFragment
{
  private HashMap _$_findViewCache;
  
  public FinderMachineTabFragment()
  {
    super(2131760616, 4);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252930);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252930);
  }
  
  public final void dlm()
  {
    AppMethodBeat.i(252929);
    super.dlm();
    ((FinderActionBarOverlayUIC)component(FinderActionBarOverlayUIC.class)).dHX();
    ((FinderTimelineUIC)component(FinderTimelineUIC.class)).dHX();
    AppMethodBeat.o(252929);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(252928);
    Object localObject = ak.ae(new Class[] { FinderTimelineUIC.class, FinderActionBarOverlayUIC.class, FinderStreamPartialExposeUIC.class, FinderHotRelatedUIC.class, FinderHorizontalVideoPreviewUIC.class });
    if (y.a(y.vXH, 4, 0, 2)) {
      ((HashSet)localObject).add(FinderFullFeedGuideUIC.class);
    }
    localObject = (Set)localObject;
    AppMethodBeat.o(252928);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment
 * JD-Core Version:    0.7.0.1
 */
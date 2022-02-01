package com.tencent.mm.plugin.finder.ui.fragment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderActionBarOverlayUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFullFeedGuideUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHorizontalVideoPreviewUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderStreamPartialExposeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineUIC;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFriendTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "plugin-finder_release"})
public final class FinderFriendTabFragment
  extends FinderHomeTabFragment
{
  private HashMap _$_findViewCache;
  
  public FinderFriendTabFragment()
  {
    super(2131760614, 1);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252890);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252890);
  }
  
  public final void dlm()
  {
    AppMethodBeat.i(252889);
    super.dlm();
    ((FinderActionBarOverlayUIC)component(FinderActionBarOverlayUIC.class)).dHX();
    ((FinderTimelineUIC)component(FinderTimelineUIC.class)).dHX();
    AppMethodBeat.o(252889);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(252888);
    Object localObject = ak.ae(new Class[] { FinderTimelineUIC.class, FinderActionBarOverlayUIC.class, FinderStreamPartialExposeUIC.class, FinderHorizontalVideoPreviewUIC.class });
    if (y.a(y.vXH, 1, 0, 2)) {
      ((HashSet)localObject).add(FinderFullFeedGuideUIC.class);
    }
    localObject = (Set)localObject;
    AppMethodBeat.o(252888);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment
 * JD-Core Version:    0.7.0.1
 */
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFollowTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "plugin-finder_release"})
public final class FinderFollowTabFragment
  extends FinderHomeTabFragment
{
  private HashMap _$_findViewCache;
  
  public FinderFollowTabFragment()
  {
    super(2131760613, 3);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252886);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252886);
  }
  
  public final void dlm()
  {
    AppMethodBeat.i(252885);
    super.dlm();
    ((FinderTimelineUIC)component(FinderTimelineUIC.class)).dHX();
    ((FinderActionBarOverlayUIC)component(FinderActionBarOverlayUIC.class)).dHX();
    AppMethodBeat.o(252885);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(252884);
    Object localObject = ak.ae(new Class[] { FinderTimelineUIC.class, FinderActionBarOverlayUIC.class, FinderStreamPartialExposeUIC.class, FinderHorizontalVideoPreviewUIC.class });
    if (y.a(y.vXH, 3, 0, 2)) {
      ((HashSet)localObject).add(FinderFullFeedGuideUIC.class);
    }
    localObject = (Set)localObject;
    AppMethodBeat.o(252884);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment
 * JD-Core Version:    0.7.0.1
 */
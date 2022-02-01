package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.preload.tabPreload.c;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineHotCacheControl;", "", "()V", "hasPreload", "", "tabType", "", "notShowCacheOnInit", "notShowCacheOnVisible", "", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "notShowCacheWhenLoading", "notShowCacheWhenPreloadExist", "plugin-finder_release"})
public final class aq
{
  public static final aq xBP;
  
  static
  {
    AppMethodBeat.i(271074);
    xBP = new aq();
    AppMethodBeat.o(271074);
  }
  
  public static boolean Mz(int paramInt)
  {
    AppMethodBeat.i(271073);
    Object localObject = com.tencent.mm.ui.component.g.Xox;
    localObject = ((c)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(c.class)).OM(paramInt);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.preload.tabPreload.g)localObject).zLy;
      if (localObject == null) {}
    }
    for (localObject = ((com.tencent.mm.plugin.finder.preload.tabPreload.g.a)localObject).zLA; localObject != null; localObject = null)
    {
      AppMethodBeat.o(271073);
      return true;
    }
    AppMethodBeat.o(271073);
    return false;
  }
  
  public static boolean dtr()
  {
    AppMethodBeat.i(271071);
    d locald = d.AjH;
    if (((Number)d.dYd().aSr()).intValue() == 1)
    {
      AppMethodBeat.o(271071);
      return true;
    }
    AppMethodBeat.o(271071);
    return false;
  }
  
  public static boolean dts()
  {
    AppMethodBeat.i(271072);
    d locald = d.AjH;
    if (((Number)d.dYe().aSr()).intValue() == 1)
    {
      AppMethodBeat.o(271072);
      return true;
    }
    AppMethodBeat.o(271072);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aq
 * JD-Core Version:    0.7.0.1
 */
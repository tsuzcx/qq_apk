package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.h.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "lruCache", "Lcom/tencent/mm/loader/model/MMLRUMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM$Cache;", "get", "key", "onCleared", "", "resetCache", "store", "lastExitPosition", "", "lastExitFromTopPx", "lastDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Cache", "Companion", "plugin-finder_release"})
public final class FinderTimelineRefCacheVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final FinderTimelineRefCacheVM.b tlq;
  public final d<String, FinderTimelineRefCacheVM.a> tlp;
  
  static
  {
    AppMethodBeat.i(206090);
    tlq = new FinderTimelineRefCacheVM.b((byte)0);
    AppMethodBeat.o(206090);
  }
  
  public FinderTimelineRefCacheVM()
  {
    AppMethodBeat.i(206089);
    this.tlp = new d(6);
    AppMethodBeat.o(206089);
  }
  
  public final void af()
  {
    AppMethodBeat.i(206088);
    super.af();
    this.tlp.clear();
    AppMethodBeat.o(206088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderTimelineRefCacheVM
 * JD-Core Version:    0.7.0.1
 */
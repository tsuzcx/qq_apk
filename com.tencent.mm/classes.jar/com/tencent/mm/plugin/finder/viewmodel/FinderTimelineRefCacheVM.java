package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.h.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "lruCache", "Lcom/tencent/mm/loader/model/MMLRUMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM$Cache;", "get", "key", "onCleared", "", "resetCache", "store", "lastExitPosition", "", "lastExitFromTopPx", "lastDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Cache", "Companion", "plugin-finder_release"})
public final class FinderTimelineRefCacheVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final FinderTimelineRefCacheVM.b sdb;
  public final d<String, FinderTimelineRefCacheVM.a> sda;
  
  static
  {
    AppMethodBeat.i(204462);
    sdb = new FinderTimelineRefCacheVM.b((byte)0);
    AppMethodBeat.o(204462);
  }
  
  public FinderTimelineRefCacheVM()
  {
    AppMethodBeat.i(204461);
    this.sda = new d(6);
    AppMethodBeat.o(204461);
  }
  
  public final void ae()
  {
    AppMethodBeat.i(204460);
    super.ae();
    this.sda.clear();
    AppMethodBeat.o(204460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderTimelineRefCacheVM
 * JD-Core Version:    0.7.0.1
 */
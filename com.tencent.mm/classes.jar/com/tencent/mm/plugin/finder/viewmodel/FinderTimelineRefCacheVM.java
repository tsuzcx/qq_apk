package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.h.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.ui.component.UIComponentPlugin;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "lruCache", "Lcom/tencent/mm/loader/model/MMLRUMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM$Cache;", "get", "key", "onCleared", "", "resetCache", "store", "lastExitPosition", "", "lastExitFromTopPx", "lastDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Cache", "Companion", "plugin-finder_release"})
public final class FinderTimelineRefCacheVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final b wuW;
  public final d<String, a> wuV;
  
  static
  {
    AppMethodBeat.i(255395);
    wuW = new b((byte)0);
    AppMethodBeat.o(255395);
  }
  
  public FinderTimelineRefCacheVM()
  {
    AppMethodBeat.i(255394);
    this.wuV = new d(6);
    AppMethodBeat.o(255394);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(255393);
    super.onCleared();
    this.wuV.clear();
    AppMethodBeat.o(255393);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM$Cache;", "", "key", "", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "lastDataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLastDataList", "()Ljava/util/List;", "setLastDataList", "(Ljava/util/List;)V", "lastExitFromTopPx", "", "getLastExitFromTopPx", "()I", "setLastExitFromTopPx", "(I)V", "lastExitPosition", "getLastExitPosition", "setLastExitPosition", "lastExitTime", "", "getLastExitTime", "()J", "setLastExitTime", "(J)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class a
  {
    private final String key;
    public List<? extends bo> wuc;
    public int wuf;
    public int wug;
    public long wuh;
    
    public a(String paramString)
    {
      AppMethodBeat.i(255389);
      this.key = paramString;
      this.wuc = ((List)new LinkedList());
      AppMethodBeat.o(255389);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(255392);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (!p.j(this.key, paramObject.key)) {}
        }
      }
      else
      {
        AppMethodBeat.o(255392);
        return true;
      }
      AppMethodBeat.o(255392);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(255391);
      String str = this.key;
      if (str != null)
      {
        int i = str.hashCode();
        AppMethodBeat.o(255391);
        return i;
      }
      AppMethodBeat.o(255391);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(255390);
      String str = "Cache(key=" + this.key + ")";
      AppMethodBeat.o(255390);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderTimelineRefCacheVM
 * JD-Core Version:    0.7.0.1
 */
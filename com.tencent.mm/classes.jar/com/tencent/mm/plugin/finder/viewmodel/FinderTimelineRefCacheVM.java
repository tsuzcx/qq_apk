package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.h.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.g.b.p;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "lruCache", "Lcom/tencent/mm/loader/model/MMLRUMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM$Cache;", "get", "key", "onCleared", "", "resetCache", "store", "lastExitPosition", "", "lastExitFromTopPx", "lastDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Cache", "Companion", "plugin-finder_release"})
public final class FinderTimelineRefCacheVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final b taC;
  public final d<String, a> taB;
  
  static
  {
    AppMethodBeat.i(205480);
    taC = new b((byte)0);
    AppMethodBeat.o(205480);
  }
  
  public FinderTimelineRefCacheVM()
  {
    AppMethodBeat.i(205479);
    this.taB = new d(6);
    AppMethodBeat.o(205479);
  }
  
  public final void af()
  {
    AppMethodBeat.i(205478);
    super.af();
    this.taB.clear();
    AppMethodBeat.o(205478);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM$Cache;", "", "key", "", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "lastDataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLastDataList", "()Ljava/util/List;", "setLastDataList", "(Ljava/util/List;)V", "lastExitFromTopPx", "", "getLastExitFromTopPx", "()I", "setLastExitFromTopPx", "(I)V", "lastExitPosition", "getLastExitPosition", "setLastExitPosition", "lastExitTime", "", "getLastExitTime", "()J", "setLastExitTime", "(J)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class a
  {
    private final String key;
    public List<? extends al> sZm;
    public int sZo;
    public int sZp;
    public long sZq;
    
    public a(String paramString)
    {
      AppMethodBeat.i(205474);
      this.key = paramString;
      this.sZm = ((List)new LinkedList());
      AppMethodBeat.o(205474);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(205477);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (!p.i(this.key, paramObject.key)) {}
        }
      }
      else
      {
        AppMethodBeat.o(205477);
        return true;
      }
      AppMethodBeat.o(205477);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(205476);
      String str = this.key;
      if (str != null)
      {
        int i = str.hashCode();
        AppMethodBeat.o(205476);
        return i;
      }
      AppMethodBeat.o(205476);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(205475);
      String str = "Cache(key=" + this.key + ")";
      AppMethodBeat.o(205475);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderTimelineRefCacheVM
 * JD-Core Version:    0.7.0.1
 */
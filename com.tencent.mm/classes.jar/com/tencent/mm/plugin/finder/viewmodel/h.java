package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.h.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.ui.component.i;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "lruCache", "Lcom/tencent/mm/loader/model/MMLRUMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM$Cache;", "get", "key", "onCleared", "", "resetCache", "store", "lastExitPosition", "", "lastExitFromTopPx", "lastDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Cache", "Companion", "plugin-finder_release"})
public final class h
  extends i<PluginFinder>
{
  public static final b Bhu;
  public final d<String, a> Bht;
  
  static
  {
    AppMethodBeat.i(286246);
    Bhu = new b((byte)0);
    AppMethodBeat.o(286246);
  }
  
  public h()
  {
    AppMethodBeat.i(286245);
    this.Bht = new d(6);
    AppMethodBeat.o(286245);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(286244);
    super.onCleared();
    this.Bht.clear();
    AppMethodBeat.o(286244);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM$Cache;", "", "key", "", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "lastDataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLastDataList", "()Ljava/util/List;", "setLastDataList", "(Ljava/util/List;)V", "lastExitFromTopPx", "", "getLastExitFromTopPx", "()I", "setLastExitFromTopPx", "(I)V", "lastExitPosition", "getLastExitPosition", "setLastExitPosition", "lastExitTime", "", "getLastExitTime", "()J", "setLastExitTime", "(J)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class a
  {
    public long BgA;
    public List<? extends bu> Bgw;
    public int Bgy;
    public int Bgz;
    private final String key;
    
    public a(String paramString)
    {
      AppMethodBeat.i(280197);
      this.key = paramString;
      this.Bgw = ((List)new LinkedList());
      AppMethodBeat.o(280197);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(280200);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (!p.h(this.key, paramObject.key)) {}
        }
      }
      else
      {
        AppMethodBeat.o(280200);
        return true;
      }
      AppMethodBeat.o(280200);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(280199);
      String str = this.key;
      if (str != null)
      {
        int i = str.hashCode();
        AppMethodBeat.o(280199);
        return i;
      }
      AppMethodBeat.o(280199);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(280198);
      String str = "Cache(key=" + this.key + ")";
      AppMethodBeat.o(280198);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.h
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.h.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.g.b.k;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "lruCache", "Lcom/tencent/mm/loader/model/MMLRUMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM$Cache;", "get", "key", "onCleared", "", "resetCache", "store", "lastExitPosition", "", "lastExitFromTopPx", "lastDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Cache", "Companion", "plugin-finder_release"})
public final class FinderTimelineRefCacheVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final b Lhy;
  public final d<String, a> Lhx;
  
  static
  {
    AppMethodBeat.i(200337);
    Lhy = new b((byte)0);
    AppMethodBeat.o(200337);
  }
  
  public FinderTimelineRefCacheVM()
  {
    AppMethodBeat.i(200336);
    this.Lhx = new d(6);
    AppMethodBeat.o(200336);
  }
  
  public final void ae()
  {
    AppMethodBeat.i(200335);
    super.ae();
    this.Lhx.clear();
    AppMethodBeat.o(200335);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM$Cache;", "", "key", "", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "lastDataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getLastDataList", "()Ljava/util/List;", "setLastDataList", "(Ljava/util/List;)V", "lastExitFromTopPx", "", "getLastExitFromTopPx", "()I", "setLastExitFromTopPx", "(I)V", "lastExitPosition", "getLastExitPosition", "setLastExitPosition", "lastExitTime", "", "getLastExitTime", "()J", "setLastExitTime", "(J)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class a
  {
    public List<? extends BaseFinderFeed> Lhe;
    public int Lhf;
    public int Lhg;
    public long Lhh;
    private final String key;
    
    public a(String paramString)
    {
      AppMethodBeat.i(200331);
      this.key = paramString;
      this.Lhe = ((List)new LinkedList());
      AppMethodBeat.o(200331);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(200334);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (!k.g(this.key, paramObject.key)) {}
        }
      }
      else
      {
        AppMethodBeat.o(200334);
        return true;
      }
      AppMethodBeat.o(200334);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(200333);
      String str = this.key;
      if (str != null)
      {
        int i = str.hashCode();
        AppMethodBeat.o(200333);
        return i;
      }
      AppMethodBeat.o(200333);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(200332);
      String str = "Cache(key=" + this.key + ")";
      AppMethodBeat.o(200332);
      return str;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderTimelineRefCacheVM
 * JD-Core Version:    0.7.0.1
 */
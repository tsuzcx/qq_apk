package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.loader.g.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.ui.component.n;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "lruCache", "Lcom/tencent/mm/loader/model/MMLRUMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM$Cache;", "get", "key", "onCleared", "", "resetCache", "store", "lastExitPosition", "", "lastExitFromTopPx", "lastDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Cache", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends n<PluginFinder>
{
  public static final b GLt;
  public final d<String, a> GLu;
  
  static
  {
    AppMethodBeat.i(337160);
    GLt = new b((byte)0);
    AppMethodBeat.o(337160);
  }
  
  public j()
  {
    AppMethodBeat.i(337153);
    this.GLu = new d(6);
    AppMethodBeat.o(337153);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(337168);
    super.onCleared();
    Object localObject = this.GLu;
    if (((d)localObject).nsn == null)
    {
      localObject = new NullPointerException("mData == null");
      AppMethodBeat.o(337168);
      throw ((Throwable)localObject);
    }
    ((d)localObject).nsn.trimToSize(-1);
    AppMethodBeat.o(337168);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM$Cache;", "", "key", "", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "lastDataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLastDataList", "()Ljava/util/List;", "setLastDataList", "(Ljava/util/List;)V", "lastExitFromTopPx", "", "getLastExitFromTopPx", "()I", "setLastExitFromTopPx", "(I)V", "lastExitPosition", "getLastExitPosition", "setLastExitPosition", "lastExitTime", "", "getLastExitTime", "()J", "setLastExitTime", "(J)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public int GKx;
    public int GKy;
    public long GKz;
    public List<? extends cc> GLv;
    private final String key;
    
    public a(String paramString)
    {
      AppMethodBeat.i(337138);
      this.key = paramString;
      this.GLv = ((List)new LinkedList());
      AppMethodBeat.o(337138);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(337155);
      if (this == paramObject)
      {
        AppMethodBeat.o(337155);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(337155);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.key, paramObject.key))
      {
        AppMethodBeat.o(337155);
        return false;
      }
      AppMethodBeat.o(337155);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(337148);
      int i = this.key.hashCode();
      AppMethodBeat.o(337148);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(337144);
      String str = "Cache(key=" + this.key + ')';
      AppMethodBeat.o(337144);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.j
 * JD-Core Version:    0.7.0.1
 */
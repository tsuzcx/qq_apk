package com.tencent.mm.plugin.finder.viewmodel;

import androidx.lifecycle.af;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.auk;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM;", "Landroidx/lifecycle/ViewModel;", "()V", "caches", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Cache;", "get", "tabType", "onCleared", "", "resetCache", "store", "lastSelectedPosition", "lastDataList", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "Cache", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends af
{
  public static final b GLq;
  public final ConcurrentHashMap<Integer, a> GKl;
  
  static
  {
    AppMethodBeat.i(337165);
    GLq = new b((byte)0);
    AppMethodBeat.o(337165);
  }
  
  public i()
  {
    AppMethodBeat.i(337157);
    this.GKl = new ConcurrentHashMap();
    AppMethodBeat.o(337157);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(337174);
    super.onCleared();
    this.GKl.clear();
    AppMethodBeat.o(337174);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Cache;", "", "tabType", "", "(I)V", "lastDataList", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "getLastDataList", "()Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "setLastDataList", "(Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;)V", "lastSelectedPosition", "getLastSelectedPosition", "()I", "setLastSelectedPosition", "getTabType", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public auk GLr;
    public int GLs;
    private final int hJx;
    
    public a()
    {
      AppMethodBeat.i(337383);
      this.hJx = 4;
      this.GLr = new auk();
      this.GLs = -1;
      AppMethodBeat.o(337383);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
      } while (this.hJx == paramObject.hJx);
      return false;
    }
    
    public final int hashCode()
    {
      return this.hJx;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(337387);
      String str = "Cache(tabType=" + this.hJx + ')';
      AppMethodBeat.o(337387);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.i
 * JD-Core Version:    0.7.0.1
 */
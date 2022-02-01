package com.tencent.mm.plugin.finder.viewmodel;

import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aqk;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM;", "Landroidx/lifecycle/ViewModel;", "()V", "caches", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Cache;", "get", "tabType", "onCleared", "", "resetCache", "store", "lastSelectedPosition", "lastDataList", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "Cache", "Companion", "plugin-finder_release"})
public final class g
  extends x
{
  public static final b Bhq;
  public final ConcurrentHashMap<Integer, a> Bgm;
  
  static
  {
    AppMethodBeat.i(273877);
    Bhq = new b((byte)0);
    AppMethodBeat.o(273877);
  }
  
  public g()
  {
    AppMethodBeat.i(273876);
    this.Bgm = new ConcurrentHashMap();
    AppMethodBeat.o(273876);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(273875);
    super.onCleared();
    this.Bgm.clear();
    AppMethodBeat.o(273875);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Cache;", "", "tabType", "", "(I)V", "lastDataList", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "getLastDataList", "()Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "setLastDataList", "(Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;)V", "lastSelectedPosition", "getLastSelectedPosition", "()I", "setLastSelectedPosition", "getTabType", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    public aqk Bhr;
    public int Bhs;
    private final int fEH;
    
    public a()
    {
      AppMethodBeat.i(282144);
      this.fEH = 4;
      this.Bhr = new aqk();
      this.Bhs = -1;
      AppMethodBeat.o(282144);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (this.fEH != paramObject.fEH) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.fEH;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(282145);
      String str = "Cache(tabType=" + this.fEH + ")";
      AppMethodBeat.o(282145);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.g
 * JD-Core Version:    0.7.0.1
 */
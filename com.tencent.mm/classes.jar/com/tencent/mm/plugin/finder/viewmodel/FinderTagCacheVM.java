package com.tencent.mm.plugin.finder.viewmodel;

import android.arch.lifecycle.ViewModel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.apa;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM;", "Landroid/arch/lifecycle/ViewModel;", "()V", "caches", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Cache;", "get", "tabType", "onCleared", "", "resetCache", "store", "lastSelectedPosition", "lastDataList", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "Cache", "Companion", "plugin-finder_release"})
public final class FinderTagCacheVM
  extends ViewModel
{
  public static final b wuS;
  public final ConcurrentHashMap<Integer, a> wtV;
  
  static
  {
    AppMethodBeat.i(255388);
    wuS = new b((byte)0);
    AppMethodBeat.o(255388);
  }
  
  public FinderTagCacheVM()
  {
    AppMethodBeat.i(255387);
    this.wtV = new ConcurrentHashMap();
    AppMethodBeat.o(255387);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(255386);
    super.onCleared();
    this.wtV.clear();
    AppMethodBeat.o(255386);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Cache;", "", "tabType", "", "(I)V", "lastDataList", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "getLastDataList", "()Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "setLastDataList", "(Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;)V", "lastSelectedPosition", "getLastSelectedPosition", "()I", "setLastSelectedPosition", "getTabType", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    private final int dLS;
    public apa wuT;
    public int wuU;
    
    public a()
    {
      AppMethodBeat.i(255384);
      this.dLS = 4;
      this.wuT = new apa();
      this.wuU = -1;
      AppMethodBeat.o(255384);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (this.dLS != paramObject.dLS) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.dLS;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(255385);
      String str = "Cache(tabType=" + this.dLS + ")";
      AppMethodBeat.o(255385);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM
 * JD-Core Version:    0.7.0.1
 */
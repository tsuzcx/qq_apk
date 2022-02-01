package com.tencent.mm.plugin.finder.viewmodel;

import android.arch.lifecycle.ViewModel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyf;
import d.l;
import java.util.concurrent.ConcurrentHashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM;", "Landroid/arch/lifecycle/ViewModel;", "()V", "caches", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Cache;", "get", "tabType", "onCleared", "", "resetCache", "store", "lastSelectedPosition", "lastDataList", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "Cache", "Companion", "plugin-finder_release"})
public final class FinderTagCacheVM
  extends ViewModel
{
  public static final b Lhu;
  public final ConcurrentHashMap<Integer, a> LgZ;
  
  static
  {
    AppMethodBeat.i(200330);
    Lhu = new b((byte)0);
    AppMethodBeat.o(200330);
  }
  
  public FinderTagCacheVM()
  {
    AppMethodBeat.i(200329);
    this.LgZ = new ConcurrentHashMap();
    AppMethodBeat.o(200329);
  }
  
  public final void ae()
  {
    AppMethodBeat.i(200328);
    super.ae();
    this.LgZ.clear();
    AppMethodBeat.o(200328);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Cache;", "", "tabType", "", "(I)V", "lastDataList", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "getLastDataList", "()Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "setLastDataList", "(Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;)V", "lastSelectedPosition", "getLastSelectedPosition", "()I", "setLastSelectedPosition", "getTabType", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    private final int IoU;
    public dyf Lhv;
    public int Lhw;
    
    public a()
    {
      AppMethodBeat.i(200326);
      this.IoU = 4;
      this.Lhv = new dyf();
      this.Lhw = -1;
      AppMethodBeat.o(200326);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (this.IoU != paramObject.IoU) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.IoU;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(200327);
      String str = "Cache(tabType=" + this.IoU + ")";
      AppMethodBeat.o(200327);
      return str;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM
 * JD-Core Version:    0.7.0.1
 */
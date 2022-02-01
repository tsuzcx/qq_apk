package com.tencent.mm.plugin.finder.viewmodel;

import android.arch.lifecycle.ViewModel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.alm;
import d.l;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM;", "Landroid/arch/lifecycle/ViewModel;", "()V", "caches", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Cache;", "get", "tabType", "onCleared", "", "resetCache", "store", "lastSelectedPosition", "lastDataList", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "Cache", "Companion", "plugin-finder_release"})
public final class FinderTagCacheVM
  extends ViewModel
{
  public static final b tay;
  public final ConcurrentHashMap<Integer, a> sZf;
  
  static
  {
    AppMethodBeat.i(205473);
    tay = new b((byte)0);
    AppMethodBeat.o(205473);
  }
  
  public FinderTagCacheVM()
  {
    AppMethodBeat.i(205472);
    this.sZf = new ConcurrentHashMap();
    AppMethodBeat.o(205472);
  }
  
  public final void af()
  {
    AppMethodBeat.i(205471);
    super.af();
    this.sZf.clear();
    AppMethodBeat.o(205471);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Cache;", "", "tabType", "", "(I)V", "lastDataList", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "getLastDataList", "()Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "setLastDataList", "(Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;)V", "lastSelectedPosition", "getLastSelectedPosition", "()I", "setLastSelectedPosition", "getTabType", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    private final int duh;
    public int taA;
    public alm taz;
    
    public a()
    {
      AppMethodBeat.i(205469);
      this.duh = 4;
      this.taz = new alm();
      this.taA = -1;
      AppMethodBeat.o(205469);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (this.duh != paramObject.duh) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.duh;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(205470);
      String str = "Cache(tabType=" + this.duh + ")";
      AppMethodBeat.o(205470);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM
 * JD-Core Version:    0.7.0.1
 */
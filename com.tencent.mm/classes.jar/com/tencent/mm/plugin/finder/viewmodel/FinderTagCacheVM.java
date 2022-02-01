package com.tencent.mm.plugin.finder.viewmodel;

import android.arch.lifecycle.ViewModel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aly;
import d.l;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM;", "Landroid/arch/lifecycle/ViewModel;", "()V", "caches", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Cache;", "get", "tabType", "onCleared", "", "resetCache", "store", "lastSelectedPosition", "lastDataList", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "Cache", "Companion", "plugin-finder_release"})
public final class FinderTagCacheVM
  extends ViewModel
{
  public static final b tlm;
  public final ConcurrentHashMap<Integer, a> tkt;
  
  static
  {
    AppMethodBeat.i(206083);
    tlm = new b((byte)0);
    AppMethodBeat.o(206083);
  }
  
  public FinderTagCacheVM()
  {
    AppMethodBeat.i(206082);
    this.tkt = new ConcurrentHashMap();
    AppMethodBeat.o(206082);
  }
  
  public final void af()
  {
    AppMethodBeat.i(206081);
    super.af();
    this.tkt.clear();
    AppMethodBeat.o(206081);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Cache;", "", "tabType", "", "(I)V", "lastDataList", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "getLastDataList", "()Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "setLastDataList", "(Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;)V", "lastSelectedPosition", "getLastSelectedPosition", "()I", "setLastSelectedPosition", "getTabType", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    private final int dvm;
    public aly tln;
    public int tlo;
    
    public a()
    {
      AppMethodBeat.i(206079);
      this.dvm = 4;
      this.tln = new aly();
      this.tlo = -1;
      AppMethodBeat.o(206079);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (this.dvm != paramObject.dvm) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.dvm;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206080);
      String str = "Cache(tabType=" + this.dvm + ")";
      AppMethodBeat.o(206080);
      return str;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM
 * JD-Core Version:    0.7.0.1
 */
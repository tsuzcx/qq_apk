package com.tencent.mm.plugin.finder.viewmodel;

import android.arch.lifecycle.ViewModel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aiw;
import d.l;
import java.util.concurrent.ConcurrentHashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM;", "Landroid/arch/lifecycle/ViewModel;", "()V", "caches", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Cache;", "get", "tabType", "onCleared", "", "resetCache", "store", "lastSelectedPosition", "lastDataList", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "Cache", "Companion", "plugin-finder_release"})
public final class FinderTagCacheVM
  extends ViewModel
{
  public static final FinderTagCacheVM.b scX;
  public final ConcurrentHashMap<Integer, a> sbP;
  
  static
  {
    AppMethodBeat.i(204455);
    scX = new FinderTagCacheVM.b((byte)0);
    AppMethodBeat.o(204455);
  }
  
  public FinderTagCacheVM()
  {
    AppMethodBeat.i(204454);
    this.sbP = new ConcurrentHashMap();
    AppMethodBeat.o(204454);
  }
  
  public final void ae()
  {
    AppMethodBeat.i(204453);
    super.ae();
    this.sbP.clear();
    AppMethodBeat.o(204453);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM$Cache;", "", "tabType", "", "(I)V", "lastDataList", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "getLastDataList", "()Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "setLastDataList", "(Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;)V", "lastSelectedPosition", "getLastSelectedPosition", "()I", "setLastSelectedPosition", "getTabType", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    private final int diw;
    public aiw scY;
    public int scZ;
    
    public a()
    {
      AppMethodBeat.i(204451);
      this.diw = 4;
      this.scY = new aiw();
      this.scZ = -1;
      AppMethodBeat.o(204451);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (this.diw != paramObject.diw) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.diw;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(204452);
      String str = "Cache(tabType=" + this.diw + ")";
      AppMethodBeat.o(204452);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM
 * JD-Core Version:    0.7.0.1
 */
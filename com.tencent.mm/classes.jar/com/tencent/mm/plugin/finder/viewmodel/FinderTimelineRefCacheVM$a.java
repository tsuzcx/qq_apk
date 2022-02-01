package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import d.g.b.k;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM$Cache;", "", "key", "", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "lastDataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getLastDataList", "()Ljava/util/List;", "setLastDataList", "(Ljava/util/List;)V", "lastExitFromTopPx", "", "getLastExitFromTopPx", "()I", "setLastExitFromTopPx", "(I)V", "lastExitPosition", "getLastExitPosition", "setLastExitPosition", "lastExitTime", "", "getLastExitTime", "()J", "setLastExitTime", "(J)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
public final class FinderTimelineRefCacheVM$a
{
  private final String key;
  public List<? extends BaseFinderFeed> sbU;
  public int sbW;
  public int sbX;
  public long sbY;
  
  public FinderTimelineRefCacheVM$a(String paramString)
  {
    AppMethodBeat.i(204456);
    this.key = paramString;
    this.sbU = ((List)new LinkedList());
    AppMethodBeat.o(204456);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204459);
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
      AppMethodBeat.o(204459);
      return true;
    }
    AppMethodBeat.o(204459);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204458);
    String str = this.key;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(204458);
      return i;
    }
    AppMethodBeat.o(204458);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204457);
    String str = "Cache(key=" + this.key + ")";
    AppMethodBeat.o(204457);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderTimelineRefCacheVM.a
 * JD-Core Version:    0.7.0.1
 */
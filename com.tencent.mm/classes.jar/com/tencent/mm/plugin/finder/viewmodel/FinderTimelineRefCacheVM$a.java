package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.am;
import d.g.b.p;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM$Cache;", "", "key", "", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "lastDataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLastDataList", "()Ljava/util/List;", "setLastDataList", "(Ljava/util/List;)V", "lastExitFromTopPx", "", "getLastExitFromTopPx", "()I", "setLastExitFromTopPx", "(I)V", "lastExitPosition", "getLastExitPosition", "setLastExitPosition", "lastExitTime", "", "getLastExitTime", "()J", "setLastExitTime", "(J)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
public final class FinderTimelineRefCacheVM$a
{
  private final String key;
  public List<? extends am> tkA;
  public int tkC;
  public int tkD;
  public long tkE;
  
  public FinderTimelineRefCacheVM$a(String paramString)
  {
    AppMethodBeat.i(206084);
    this.key = paramString;
    this.tkA = ((List)new LinkedList());
    AppMethodBeat.o(206084);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(206087);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if (!p.i(this.key, paramObject.key)) {}
      }
    }
    else
    {
      AppMethodBeat.o(206087);
      return true;
    }
    AppMethodBeat.o(206087);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(206086);
    String str = this.key;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(206086);
      return i;
    }
    AppMethodBeat.o(206086);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206085);
    String str = "Cache(key=" + this.key + ")";
    AppMethodBeat.o(206085);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderTimelineRefCacheVM.a
 * JD-Core Version:    0.7.0.1
 */
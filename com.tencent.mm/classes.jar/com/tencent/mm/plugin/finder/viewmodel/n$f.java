package com.tencent.mm.plugin.finder.viewmodel;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/NearbyLivePreloadCacheVM$SubTabCache;", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "timestamp", "", "(Ljava/util/ArrayList;J)V", "getData", "()Ljava/util/ArrayList;", "getTimestamp", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "isDeprecated", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n$f
{
  public final ArrayList<cc> data;
  public final long timestamp;
  
  private n$f(ArrayList<cc> paramArrayList, long paramLong)
  {
    AppMethodBeat.i(370288);
    this.data = paramArrayList;
    this.timestamp = paramLong;
    AppMethodBeat.o(370288);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(370292);
    if (this == paramObject)
    {
      AppMethodBeat.o(370292);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(370292);
      return false;
    }
    paramObject = (f)paramObject;
    if (!s.p(this.data, paramObject.data))
    {
      AppMethodBeat.o(370292);
      return false;
    }
    if (this.timestamp != paramObject.timestamp)
    {
      AppMethodBeat.o(370292);
      return false;
    }
    AppMethodBeat.o(370292);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(370291);
    int i = this.data.hashCode();
    int j = q.a..ExternalSyntheticBackport0.m(this.timestamp);
    AppMethodBeat.o(370291);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(370290);
    String str = "SubTabCache(data=" + this.data + ", timestamp=" + this.timestamp + ')';
    AppMethodBeat.o(370290);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.n.f
 * JD-Core Version:    0.7.0.1
 */
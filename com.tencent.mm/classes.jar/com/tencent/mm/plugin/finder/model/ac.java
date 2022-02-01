package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderFeedMoreLiveListItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "equals", "", "other", "", "getItemId", "", "getItemType", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
  implements cc
{
  private final String TAG = "FinderFeedMoreLiveListItem";
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(332045);
    s.u(paramk, "obj");
    ac localac;
    if ((paramk instanceof ac)) {
      localac = (ac)paramk;
    }
    while (localac != null) {
      if (paramk.hashCode() == hashCode())
      {
        AppMethodBeat.o(332045);
        return 0;
        localac = null;
      }
      else
      {
        AppMethodBeat.o(332045);
        return -1;
      }
    }
    AppMethodBeat.o(332045);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(332036);
    long l = hashCode();
    AppMethodBeat.o(332036);
    return l;
  }
  
  public final int bZB()
  {
    return 2005;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(332049);
    if ((paramObject instanceof ac)) {
      paramObject = (ac)paramObject;
    }
    while (paramObject != null) {
      if (paramObject.hashCode() == hashCode())
      {
        AppMethodBeat.o(332049);
        return true;
        paramObject = null;
      }
      else
      {
        AppMethodBeat.o(332049);
        return false;
      }
    }
    AppMethodBeat.o(332049);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(332059);
    String str = s.X("MoreLiveListItem", Long.valueOf(hashCode()));
    AppMethodBeat.o(332059);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ac
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderFeedMoreLiveListItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "equals", "", "other", "", "getItemId", "", "getItemType", "toString", "plugin-finder_release"})
public final class ab
  implements bu
{
  private final String TAG = "FinderFeedMoreLiveListItem";
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(241878);
    p.k(paramk, "obj");
    if (!(paramk instanceof ab)) {}
    for (k localk = null;; localk = paramk)
    {
      if ((ab)localk != null)
      {
        if (paramk.hashCode() == hashCode())
        {
          AppMethodBeat.o(241878);
          return 0;
        }
        AppMethodBeat.o(241878);
        return -1;
      }
      AppMethodBeat.o(241878);
      return -1;
    }
  }
  
  public final int bAQ()
  {
    return 2005;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(241879);
    if (!(paramObject instanceof ab)) {
      paramObject = null;
    }
    for (;;)
    {
      paramObject = (ab)paramObject;
      if (paramObject != null)
      {
        if (paramObject.hashCode() == hashCode())
        {
          AppMethodBeat.o(241879);
          return true;
        }
        AppMethodBeat.o(241879);
        return false;
      }
      AppMethodBeat.o(241879);
      return false;
    }
  }
  
  public final long mf()
  {
    AppMethodBeat.i(241877);
    long l = hashCode();
    AppMethodBeat.o(241877);
    return l;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(241880);
    String str = "MoreLiveListItem" + hashCode();
    AppMethodBeat.o(241880);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ab
 * JD-Core Version:    0.7.0.1
 */
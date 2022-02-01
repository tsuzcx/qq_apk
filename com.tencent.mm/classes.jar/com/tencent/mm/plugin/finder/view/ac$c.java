package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.cc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/GameTeamSelectCoinBottomPage$Data;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "data", "", "(I)V", "getData", "()I", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac$c
  implements cc
{
  final int data;
  
  public ac$c(int paramInt)
  {
    this.data = paramInt;
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(344218);
    s.u(paramk, "obj");
    if ((paramk instanceof c))
    {
      if (this.data == ((c)paramk).data)
      {
        AppMethodBeat.o(344218);
        return 0;
      }
      AppMethodBeat.o(344218);
      return 1;
    }
    AppMethodBeat.o(344218);
    return 1;
  }
  
  public final long bZA()
  {
    return this.data;
  }
  
  public final int bZB()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.ac.c
 * JD-Core Version:    0.7.0.1
 */
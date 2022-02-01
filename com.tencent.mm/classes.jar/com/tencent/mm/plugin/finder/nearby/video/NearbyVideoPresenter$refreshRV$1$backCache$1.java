package com.tencent.mm.plugin.finder.nearby.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.y;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "", "RVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
final class NearbyVideoPresenter$refreshRV$1$backCache$1
  extends u
  implements b<cc, Boolean>
{
  public static final 1 INSTANCE;
  
  static
  {
    AppMethodBeat.i(340206);
    INSTANCE = new 1();
    AppMethodBeat.o(340206);
  }
  
  NearbyVideoPresenter$refreshRV$1$backCache$1()
  {
    super(1);
  }
  
  public final Boolean invoke(cc paramcc)
  {
    AppMethodBeat.i(340212);
    s.u(paramcc, "RVFeed");
    if (!(paramcc instanceof y)) {}
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(340212);
      return Boolean.valueOf(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.video.NearbyVideoPresenter.refreshRV.1.backCache.1
 * JD-Core Version:    0.7.0.1
 */
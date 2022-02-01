package com.tencent.mm.plugin.finder.nearby.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.x;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "RVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
final class NearbyVideoPresenter$refreshRV$1$backCache$1
  extends q
  implements b<bo, Boolean>
{
  public static final 1 INSTANCE;
  
  static
  {
    AppMethodBeat.i(249420);
    INSTANCE = new 1();
    AppMethodBeat.o(249420);
  }
  
  NearbyVideoPresenter$refreshRV$1$backCache$1()
  {
    super(1);
  }
  
  public final boolean invoke(bo parambo)
  {
    AppMethodBeat.i(249419);
    p.h(parambo, "RVFeed");
    if (!(parambo instanceof x))
    {
      AppMethodBeat.o(249419);
      return true;
    }
    AppMethodBeat.o(249419);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.video.NearbyVideoPresenter.refreshRV.1.backCache.1
 * JD-Core Version:    0.7.0.1
 */
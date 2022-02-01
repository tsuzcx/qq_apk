package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveFeedFlowReporter$timer$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-finder_release"})
public final class l$c
  implements MTimerHandler.CallBack
{
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(282041);
    Object localObject = l.yfp;
    localObject = l.dyt();
    if (localObject != null) {
      d.c("Finder.FinderLiveFeedFlowReporter:onVideoRealPlay", (a)new a((Runnable)localObject));
    }
    AppMethodBeat.o(282041);
    return false;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(Runnable paramRunnable)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.l.c
 * JD-Core Version:    0.7.0.1
 */
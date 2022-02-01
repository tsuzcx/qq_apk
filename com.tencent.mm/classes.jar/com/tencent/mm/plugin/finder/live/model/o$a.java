package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveFeedFlowReporter$timer$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o$a
  implements MTimerHandler.CallBack
{
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(359759);
    Runnable localRunnable = o.ekK();
    if (localRunnable != null) {
      d.e("Finder.FinderLiveFeedFlowReporter:onVideoRealPlay", (a)new a(localRunnable));
    }
    AppMethodBeat.o(359759);
    return false;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(Runnable paramRunnable)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.o.a
 * JD-Core Version:    0.7.0.1
 */
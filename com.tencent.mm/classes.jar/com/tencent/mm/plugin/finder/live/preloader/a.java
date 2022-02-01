package com.tencent.mm.plugin.finder.live.preloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.f.a.a;
import com.tencent.mm.plugin.datapreloader.b;
import kotlin.Metadata;
import kotlin.d.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/preloader/LiveVisitorCoreFuture;", "Lcom/tencent/mm/plugin/datapreloader/IDataFuture;", "", "Lcom/tencent/mm/live/core/core/visitor/FinderLiveVisitorPlayCore;", "liveId", "", "(J)V", "getLiveId", "()J", "cancelTask", "", "getKey", "hitPreloadCache", "value", "runTask", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements b<String, com.tencent.mm.live.core.core.f.a>
{
  private final long liveId;
  
  public a(long paramLong)
  {
    this.liveId = paramLong;
  }
  
  public final Object Z(d<? super com.tencent.mm.live.core.core.f.a> paramd)
  {
    AppMethodBeat.i(350966);
    paramd = com.tencent.mm.live.core.core.f.a.mUf;
    paramd = a.a.hG(this.liveId);
    AppMethodBeat.o(350966);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.preloader.a
 * JD-Core Version:    0.7.0.1
 */
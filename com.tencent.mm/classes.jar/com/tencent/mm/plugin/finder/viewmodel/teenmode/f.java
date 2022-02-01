package com.tencent.mm.plugin.finder.viewmodel.teenmode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/teenmode/FinderUseTimer;", "", "()V", "onTaskListener", "Lkotlin/Function0;", "", "timerFuture", "Ljava/util/concurrent/Future;", "getTodayStartTime", "", "setTaskListener", "startCheckUseTimer", "initDelay", "interval", "stopCheckUseTimer", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  private Future<?> GWT;
  a<ah> GWU;
  
  private static final void a(f paramf)
  {
    AppMethodBeat.i(337338);
    s.u(paramf, "this$0");
    paramf = paramf.GWU;
    if (paramf != null) {
      paramf.invoke();
    }
    AppMethodBeat.o(337338);
  }
  
  public final void fpH()
  {
    AppMethodBeat.i(337355);
    if (this.GWT == null) {
      this.GWT = ((Future)h.ahAA.b(new f..ExternalSyntheticLambda0(this), 500L, 60000L));
    }
    AppMethodBeat.o(337355);
  }
  
  public final boolean fpI()
  {
    AppMethodBeat.i(337362);
    Future localFuture = this.GWT;
    if (localFuture != null)
    {
      localFuture.cancel(false);
      this.GWT = null;
      AppMethodBeat.o(337362);
      return true;
    }
    AppMethodBeat.o(337362);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.teenmode.f
 * JD-Core Version:    0.7.0.1
 */
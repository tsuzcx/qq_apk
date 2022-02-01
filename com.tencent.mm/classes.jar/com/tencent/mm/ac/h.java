package com.tencent.mm.ac;

import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.h.d;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/kt/ThreadScheduler;", "Lcom/tencent/mm/vending/scheduler/Scheduler;", "()V", "arrange", "", "p0", "Ljava/lang/Runnable;", "arrangeInterval", "p1", "", "cancel", "getType", "", "libktcomm_release"})
public final class h
  extends d
{
  public static final h hvt;
  
  static
  {
    AppMethodBeat.i(168839);
    hvt = new h();
    AppMethodBeat.o(168839);
  }
  
  public final void arrange(Runnable paramRunnable)
  {
    AppMethodBeat.i(168838);
    if (paramRunnable != null)
    {
      com.tencent.f.h.RTc.aX(paramRunnable);
      AppMethodBeat.o(168838);
      return;
    }
    AppMethodBeat.o(168838);
  }
  
  public final void arrangeInterval(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(168836);
    if (paramRunnable != null)
    {
      com.tencent.f.h.RTc.o(paramRunnable, paramLong);
      AppMethodBeat.o(168836);
      return;
    }
    AppMethodBeat.o(168836);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(168837);
    Log.e("ThreadScheduler", "can not support");
    AppMethodBeat.o(168837);
  }
  
  public final String getType()
  {
    return "ThreadScheduler";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ac.h
 * JD-Core Version:    0.7.0.1
 */
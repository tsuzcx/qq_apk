package com.tencent.mm.ad;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.h.d;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/kt/ThreadScheduler;", "Lcom/tencent/mm/vending/scheduler/Scheduler;", "()V", "arrange", "", "p0", "Ljava/lang/Runnable;", "arrangeInterval", "p1", "", "cancel", "getType", "", "libktcomm_release"})
public final class g
  extends d
{
  public static final g gFT;
  
  static
  {
    AppMethodBeat.i(168839);
    gFT = new g();
    AppMethodBeat.o(168839);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(168837);
    ad.e("ThreadScheduler", "can not support");
    AppMethodBeat.o(168837);
  }
  
  public final void g(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(168836);
    h.LTJ.r(paramRunnable, paramLong);
    AppMethodBeat.o(168836);
  }
  
  public final String getType()
  {
    return "ThreadScheduler";
  }
  
  public final void w(Runnable paramRunnable)
  {
    AppMethodBeat.i(168838);
    h.LTJ.aR(paramRunnable);
    AppMethodBeat.o(168838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ad.g
 * JD-Core Version:    0.7.0.1
 */
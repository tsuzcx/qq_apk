package com.tencent.mm.cm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.h.d;

public final class e
  extends d
{
  public final void cancel() {}
  
  public final String getType()
  {
    return "WxNoLooperScheduler";
  }
  
  public final void n(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(123368);
    paramRunnable.run();
    AppMethodBeat.o(123368);
  }
  
  public final void o(Runnable paramRunnable)
  {
    AppMethodBeat.i(123367);
    paramRunnable.run();
    AppMethodBeat.o(123367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cm.e
 * JD-Core Version:    0.7.0.1
 */
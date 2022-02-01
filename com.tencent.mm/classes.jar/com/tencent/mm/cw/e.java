package com.tencent.mm.cw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.h.d;

public final class e
  extends d
{
  public final void arrange(Runnable paramRunnable)
  {
    AppMethodBeat.i(158420);
    paramRunnable.run();
    AppMethodBeat.o(158420);
  }
  
  public final void arrangeInterval(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(158421);
    paramRunnable.run();
    AppMethodBeat.o(158421);
  }
  
  public final void cancel() {}
  
  public final String getType()
  {
    return "WxNoLooperScheduler";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cw.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.cn;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.h.d;

public final class e
  extends d
{
  public final void cancel() {}
  
  public final void f(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(158421);
    paramRunnable.run();
    AppMethodBeat.o(158421);
  }
  
  public final String getType()
  {
    return "WxNoLooperScheduler";
  }
  
  public final void w(Runnable paramRunnable)
  {
    AppMethodBeat.i(158420);
    paramRunnable.run();
    AppMethodBeat.o(158420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cn.e
 * JD-Core Version:    0.7.0.1
 */
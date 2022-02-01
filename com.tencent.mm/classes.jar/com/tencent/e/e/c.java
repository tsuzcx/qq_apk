package com.tencent.e.e;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements g
{
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(183281);
    h.LTJ.aS(paramRunnable);
    AppMethodBeat.o(183281);
  }
  
  public final String getTag()
  {
    AppMethodBeat.i(183282);
    String str = "IOScheduler@" + hashCode();
    AppMethodBeat.o(183282);
    return str;
  }
  
  public final void onShutdown() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.e.c
 * JD-Core Version:    0.7.0.1
 */
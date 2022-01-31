package com.tencent.mm.ch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;

public final class a
{
  public static boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(65381);
    d.ysm.execute(paramRunnable);
    AppMethodBeat.o(65381);
    return true;
  }
  
  public static boolean s(Runnable paramRunnable)
  {
    AppMethodBeat.i(139734);
    d.ysm.r(paramRunnable, 1000L);
    AppMethodBeat.o(139734);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ch.a
 * JD-Core Version:    0.7.0.1
 */
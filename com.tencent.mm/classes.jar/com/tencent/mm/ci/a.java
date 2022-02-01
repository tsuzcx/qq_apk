package com.tencent.mm.ci;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public final class a
{
  public static boolean C(Runnable paramRunnable)
  {
    AppMethodBeat.i(156367);
    h.ahAA.p(paramRunnable, 1000L);
    AppMethodBeat.o(156367);
    return true;
  }
  
  public static boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(156366);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(156366);
      return false;
    }
    h.ahAA.bm(paramRunnable);
    AppMethodBeat.o(156366);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ci.a
 * JD-Core Version:    0.7.0.1
 */
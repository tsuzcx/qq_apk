package com.tencent.mm.ci;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;

public final class a
{
  public static boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(156366);
    h.JZN.aS(paramRunnable);
    AppMethodBeat.o(156366);
    return true;
  }
  
  public static boolean y(Runnable paramRunnable)
  {
    AppMethodBeat.i(156367);
    h.JZN.q(paramRunnable, 1000L);
    AppMethodBeat.o(156367);
    return true;
  }
  
  public static boolean z(Runnable paramRunnable)
  {
    AppMethodBeat.i(182045);
    ap.f(paramRunnable);
    AppMethodBeat.o(182045);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ci.a
 * JD-Core Version:    0.7.0.1
 */
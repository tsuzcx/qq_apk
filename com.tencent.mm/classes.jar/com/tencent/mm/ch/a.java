package com.tencent.mm.ch;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class a
{
  public static boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(156366);
    h.RTc.aX(paramRunnable);
    AppMethodBeat.o(156366);
    return true;
  }
  
  public static boolean x(Runnable paramRunnable)
  {
    AppMethodBeat.i(156367);
    h.RTc.o(paramRunnable, 1000L);
    AppMethodBeat.o(156367);
    return true;
  }
  
  public static boolean y(Runnable paramRunnable)
  {
    AppMethodBeat.i(182045);
    MMHandlerThread.postToMainThread(paramRunnable);
    AppMethodBeat.o(182045);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ch.a
 * JD-Core Version:    0.7.0.1
 */
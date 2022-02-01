package com.tencent.mm.platformtools;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

final class p$1
  implements Executor
{
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(223653);
    h.RTc.aX(paramRunnable);
    AppMethodBeat.o(223653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.p.1
 * JD-Core Version:    0.7.0.1
 */
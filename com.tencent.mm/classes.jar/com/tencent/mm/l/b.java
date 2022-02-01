package com.tencent.mm.l;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Future;

public final class b
  implements com.tencent.mm.picker.base.c.b
{
  public final Future<?> e(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(216540);
    paramRunnable = h.ZvG.b(paramRunnable, 0L, paramLong);
    AppMethodBeat.o(216540);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.l.b
 * JD-Core Version:    0.7.0.1
 */
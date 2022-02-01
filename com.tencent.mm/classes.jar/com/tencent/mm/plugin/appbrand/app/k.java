package com.tencent.mm.plugin.appbrand.app;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.c.b;
import java.util.concurrent.Future;

public final class k
  implements b
{
  public final Future<?> h(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(226310);
    paramRunnable = h.RTc.a(paramRunnable, 0L, paramLong);
    AppMethodBeat.o(226310);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.k
 * JD-Core Version:    0.7.0.1
 */
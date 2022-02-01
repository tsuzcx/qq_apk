package com.tencent.mm.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.concurrent.Future;

public final class b
  implements com.tencent.mm.picker.base.c.b
{
  public final Future<?> f(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(230951);
    paramRunnable = h.ahAA.b(paramRunnable, 0L, paramLong);
    AppMethodBeat.o(230951);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.i.b
 * JD-Core Version:    0.7.0.1
 */
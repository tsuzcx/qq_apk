package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;

final class x$1
  implements ThreadFactory
{
  x$1(String paramString) {}
  
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(95952);
    paramRunnable = new Thread(paramRunnable, this.bby);
    AppMethodBeat.o(95952);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i.x.1
 * JD-Core Version:    0.7.0.1
 */
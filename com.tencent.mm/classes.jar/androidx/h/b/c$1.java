package androidx.h.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class c$1
  implements ThreadFactory
{
  private final AtomicInteger bIW;
  
  c$1()
  {
    AppMethodBeat.i(193151);
    this.bIW = new AtomicInteger(1);
    AppMethodBeat.o(193151);
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(193158);
    paramRunnable = new Thread(paramRunnable, "ModernAsyncTask #" + this.bIW.getAndIncrement());
    AppMethodBeat.o(193158);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.h.b.c.1
 * JD-Core Version:    0.7.0.1
 */
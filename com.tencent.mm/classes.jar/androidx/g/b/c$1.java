package androidx.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class c$1
  implements ThreadFactory
{
  private final AtomicInteger abo;
  
  c$1()
  {
    AppMethodBeat.i(188383);
    this.abo = new AtomicInteger(1);
    AppMethodBeat.o(188383);
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(188387);
    paramRunnable = new Thread(paramRunnable, "ModernAsyncTask #" + this.abo.getAndIncrement());
    AppMethodBeat.o(188387);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.g.b.c.1
 * JD-Core Version:    0.7.0.1
 */
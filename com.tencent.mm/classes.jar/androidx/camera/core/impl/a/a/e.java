package androidx.camera.core.impl.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class e
  implements Executor
{
  private static volatile Executor Pj;
  private final ExecutorService Pm;
  
  e()
  {
    AppMethodBeat.i(199079);
    this.Pm = Executors.newFixedThreadPool(2, new ThreadFactory()
    {
      private final AtomicInteger yW;
      
      public final Thread newThread(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(199077);
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable);
        paramAnonymousRunnable.setName(String.format(Locale.US, "CameraX-camerax_io_%d", new Object[] { Integer.valueOf(this.yW.getAndIncrement()) }));
        AppMethodBeat.o(199077);
        return paramAnonymousRunnable;
      }
    });
    AppMethodBeat.o(199079);
  }
  
  public static Executor kP()
  {
    AppMethodBeat.i(199087);
    Executor localExecutor;
    if (Pj != null)
    {
      localExecutor = Pj;
      AppMethodBeat.o(199087);
      return localExecutor;
    }
    try
    {
      if (Pj == null) {
        Pj = new e();
      }
      localExecutor = Pj;
      AppMethodBeat.o(199087);
      return localExecutor;
    }
    finally
    {
      AppMethodBeat.o(199087);
    }
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(199092);
    this.Pm.execute(paramRunnable);
    AppMethodBeat.o(199092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.core.impl.a.a.e
 * JD-Core Version:    0.7.0.1
 */
package androidx.camera.core.impl.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class d
  implements Executor
{
  private static volatile Executor Pj;
  private final ExecutorService Pk;
  
  d()
  {
    AppMethodBeat.i(199081);
    this.Pk = Executors.newSingleThreadExecutor(new ThreadFactory()
    {
      public final Thread newThread(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(199100);
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable);
        paramAnonymousRunnable.setPriority(10);
        paramAnonymousRunnable.setName("CameraX-camerax_high_priority");
        AppMethodBeat.o(199100);
        return paramAnonymousRunnable;
      }
    });
    AppMethodBeat.o(199081);
  }
  
  public static Executor kP()
  {
    AppMethodBeat.i(199088);
    Executor localExecutor;
    if (Pj != null)
    {
      localExecutor = Pj;
      AppMethodBeat.o(199088);
      return localExecutor;
    }
    try
    {
      if (Pj == null) {
        Pj = new d();
      }
      localExecutor = Pj;
      AppMethodBeat.o(199088);
      return localExecutor;
    }
    finally
    {
      AppMethodBeat.o(199088);
    }
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(199097);
    this.Pk.execute(paramRunnable);
    AppMethodBeat.o(199097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.camera.core.impl.a.a.d
 * JD-Core Version:    0.7.0.1
 */
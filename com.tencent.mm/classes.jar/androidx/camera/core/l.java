package androidx.camera.core;

import androidx.camera.core.impl.r;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

final class l
  implements Executor
{
  private static final ThreadFactory Gp;
  private final Object Gn;
  private ThreadPoolExecutor Go;
  
  static
  {
    AppMethodBeat.i(198543);
    Gp = new ThreadFactory()
    {
      private final AtomicInteger yW;
      
      public final Thread newThread(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(198552);
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable);
        paramAnonymousRunnable.setName(String.format(Locale.US, "CameraX-core_camera_%d", new Object[] { Integer.valueOf(this.yW.getAndIncrement()) }));
        AppMethodBeat.o(198552);
        return paramAnonymousRunnable;
      }
    };
    AppMethodBeat.o(198543);
  }
  
  l()
  {
    AppMethodBeat.i(198531);
    this.Gn = new Object();
    this.Go = iH();
    AppMethodBeat.o(198531);
  }
  
  private static ThreadPoolExecutor iH()
  {
    AppMethodBeat.i(198535);
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), Gp);
    localThreadPoolExecutor.setRejectedExecutionHandler(l..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(198535);
    return localThreadPoolExecutor;
  }
  
  final void a(r paramr)
  {
    AppMethodBeat.i(198558);
    f.checkNotNull(paramr);
    synchronized (this.Gn)
    {
      if (this.Go.isShutdown()) {
        this.Go = iH();
      }
      ThreadPoolExecutor localThreadPoolExecutor = this.Go;
      int i = Math.max(1, paramr.gC().size());
      localThreadPoolExecutor.setMaximumPoolSize(i);
      localThreadPoolExecutor.setCorePoolSize(i);
      AppMethodBeat.o(198558);
      return;
    }
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(198562);
    f.checkNotNull(paramRunnable);
    synchronized (this.Gn)
    {
      this.Go.execute(paramRunnable);
      AppMethodBeat.o(198562);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.core.l
 * JD-Core Version:    0.7.0.1
 */
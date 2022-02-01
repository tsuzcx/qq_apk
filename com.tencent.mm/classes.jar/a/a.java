package a;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class a
{
  private static final int aBB;
  static final int aBC;
  static final int aBD;
  private static final a aBz;
  private final Executor aBA;
  
  static
  {
    AppMethodBeat.i(52976);
    aBz = new a();
    int i = Runtime.getRuntime().availableProcessors();
    aBB = i;
    aBC = i + 1;
    aBD = aBB * 2 + 1;
    AppMethodBeat.o(52976);
  }
  
  private a()
  {
    AppMethodBeat.i(52974);
    this.aBA = new a((byte)0);
    AppMethodBeat.o(52974);
  }
  
  public static ExecutorService newCachedThreadPool()
  {
    AppMethodBeat.i(52975);
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(aBC, aBD, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    if (Build.VERSION.SDK_INT >= 9) {
      localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }
    AppMethodBeat.o(52975);
    return localThreadPoolExecutor;
  }
  
  public static Executor nz()
  {
    return aBz.aBA;
  }
  
  static final class a
    implements Executor
  {
    public final void execute(Runnable paramRunnable)
    {
      AppMethodBeat.i(52973);
      new Handler(Looper.getMainLooper()).post(paramRunnable);
      AppMethodBeat.o(52973);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.a
 * JD-Core Version:    0.7.0.1
 */
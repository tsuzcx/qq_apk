package a;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class a
{
  static final int aBA;
  static final int aBB;
  private static final a aBx;
  private static final int aBz;
  private final Executor aBy;
  
  static
  {
    AppMethodBeat.i(52976);
    aBx = new a();
    int i = Runtime.getRuntime().availableProcessors();
    aBz = i;
    aBA = i + 1;
    aBB = aBz * 2 + 1;
    AppMethodBeat.o(52976);
  }
  
  private a()
  {
    AppMethodBeat.i(52974);
    this.aBy = new a.a((byte)0);
    AppMethodBeat.o(52974);
  }
  
  public static Executor nB()
  {
    return aBx.aBy;
  }
  
  public static ExecutorService newCachedThreadPool()
  {
    AppMethodBeat.i(52975);
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(aBA, aBB, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    if (Build.VERSION.SDK_INT >= 9) {
      localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }
    AppMethodBeat.o(52975);
    return localThreadPoolExecutor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.a
 * JD-Core Version:    0.7.0.1
 */
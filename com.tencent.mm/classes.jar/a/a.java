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
  private static final a azI;
  private static final int azK;
  static final int azL;
  static final int azM;
  private final Executor azJ;
  
  static
  {
    AppMethodBeat.i(52976);
    azI = new a();
    int i = Runtime.getRuntime().availableProcessors();
    azK = i;
    azL = i + 1;
    azM = azK * 2 + 1;
    AppMethodBeat.o(52976);
  }
  
  private a()
  {
    AppMethodBeat.i(52974);
    this.azJ = new a.a((byte)0);
    AppMethodBeat.o(52974);
  }
  
  public static ExecutorService newCachedThreadPool()
  {
    AppMethodBeat.i(52975);
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(azL, azM, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    if (Build.VERSION.SDK_INT >= 9) {
      localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }
    AppMethodBeat.o(52975);
    return localThreadPoolExecutor;
  }
  
  public static Executor nh()
  {
    return azI.azJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.a
 * JD-Core Version:    0.7.0.1
 */
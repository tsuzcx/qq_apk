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
  private static final a ayO;
  private static final int ayQ;
  static final int ayR;
  static final int ayS;
  private final Executor ayP;
  
  static
  {
    AppMethodBeat.i(52976);
    ayO = new a();
    int i = Runtime.getRuntime().availableProcessors();
    ayQ = i;
    ayR = i + 1;
    ayS = ayQ * 2 + 1;
    AppMethodBeat.o(52976);
  }
  
  private a()
  {
    AppMethodBeat.i(52974);
    this.ayP = new a.a((byte)0);
    AppMethodBeat.o(52974);
  }
  
  public static Executor mX()
  {
    return ayO.ayP;
  }
  
  public static ExecutorService newCachedThreadPool()
  {
    AppMethodBeat.i(52975);
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(ayR, ayS, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    if (Build.VERSION.SDK_INT >= 9) {
      localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }
    AppMethodBeat.o(52975);
    return localThreadPoolExecutor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.a
 * JD-Core Version:    0.7.0.1
 */
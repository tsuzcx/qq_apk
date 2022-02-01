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
  private static final a avR;
  private static final int avT;
  static final int avU;
  static final int avV;
  private final Executor avS;
  
  static
  {
    AppMethodBeat.i(52976);
    avR = new a();
    int i = Runtime.getRuntime().availableProcessors();
    avT = i;
    avU = i + 1;
    avV = avT * 2 + 1;
    AppMethodBeat.o(52976);
  }
  
  private a()
  {
    AppMethodBeat.i(52974);
    this.avS = new a.a((byte)0);
    AppMethodBeat.o(52974);
  }
  
  public static ExecutorService nK()
  {
    AppMethodBeat.i(52975);
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(avU, avV, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    if (Build.VERSION.SDK_INT >= 9) {
      localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }
    AppMethodBeat.o(52975);
    return localThreadPoolExecutor;
  }
  
  public static Executor nL()
  {
    return avR.avS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.a
 * JD-Core Version:    0.7.0.1
 */
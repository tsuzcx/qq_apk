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
  private static final a ckn;
  private static final int ckp;
  static final int ckq;
  static final int ckr;
  private final Executor cko;
  
  static
  {
    AppMethodBeat.i(52976);
    ckn = new a();
    int i = Runtime.getRuntime().availableProcessors();
    ckp = i;
    ckq = i + 1;
    ckr = ckp * 2 + 1;
    AppMethodBeat.o(52976);
  }
  
  private a()
  {
    AppMethodBeat.i(52974);
    this.cko = new a.a((byte)0);
    AppMethodBeat.o(52974);
  }
  
  public static ExecutorService Mp()
  {
    AppMethodBeat.i(52975);
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(ckq, ckr, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    if (Build.VERSION.SDK_INT >= 9) {
      localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }
    AppMethodBeat.o(52975);
    return localThreadPoolExecutor;
  }
  
  public static Executor Mq()
  {
    return ckn.cko;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.a
 * JD-Core Version:    0.7.0.1
 */
package androidx.core.d;

import android.os.Handler;
import android.os.Process;
import androidx.core.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class f
{
  static <T> T a(ExecutorService paramExecutorService, Callable<T> paramCallable, int paramInt)
  {
    AppMethodBeat.i(196286);
    paramExecutorService = paramExecutorService.submit(paramCallable);
    long l = paramInt;
    try
    {
      paramExecutorService = paramExecutorService.get(l, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(196286);
      return paramExecutorService;
    }
    catch (ExecutionException paramExecutorService)
    {
      paramExecutorService = new RuntimeException(paramExecutorService);
      AppMethodBeat.o(196286);
      throw paramExecutorService;
    }
    catch (InterruptedException paramExecutorService)
    {
      AppMethodBeat.o(196286);
      throw paramExecutorService;
    }
    catch (TimeoutException paramExecutorService)
    {
      paramExecutorService = new InterruptedException("timeout");
      AppMethodBeat.o(196286);
      throw paramExecutorService;
    }
  }
  
  static final class a
    implements ThreadFactory
  {
    private int mPriority;
    private String mThreadName;
    
    a(String paramString)
    {
      this.mThreadName = paramString;
      this.mPriority = 10;
    }
    
    public final Thread newThread(Runnable paramRunnable)
    {
      AppMethodBeat.i(196276);
      paramRunnable = new a(paramRunnable, this.mThreadName, this.mPriority);
      AppMethodBeat.o(196276);
      return paramRunnable;
    }
    
    static final class a
      extends Thread
    {
      private final int mPriority;
      
      a(Runnable paramRunnable, String paramString, int paramInt)
      {
        super(paramString);
        this.mPriority = paramInt;
      }
      
      public final void run()
      {
        AppMethodBeat.i(196255);
        Process.setThreadPriority(this.mPriority);
        super.run();
        AppMethodBeat.o(196255);
      }
    }
  }
  
  static final class b<T>
    implements Runnable
  {
    private Callable<T> brO;
    private a<T> brP;
    private Handler mHandler;
    
    b(Handler paramHandler, Callable<T> paramCallable, a<T> parama)
    {
      this.brO = paramCallable;
      this.brP = parama;
      this.mHandler = paramHandler;
    }
    
    public final void run()
    {
      AppMethodBeat.i(196278);
      try
      {
        final Object localObject1 = this.brO.call();
        final a locala = this.brP;
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(196282);
            locala.accept(localObject1);
            AppMethodBeat.o(196282);
          }
        });
        AppMethodBeat.o(196278);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.d.f
 * JD-Core Version:    0.7.0.1
 */
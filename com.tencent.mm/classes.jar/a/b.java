package a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class b
{
  private static final b ayT;
  private final ExecutorService ayU;
  private final ScheduledExecutorService ayV;
  private final Executor ayW;
  
  static
  {
    AppMethodBeat.i(52981);
    ayT = new b();
    AppMethodBeat.o(52981);
  }
  
  private b()
  {
    AppMethodBeat.i(52980);
    Object localObject = System.getProperty("java.runtime.name");
    boolean bool;
    if (localObject == null)
    {
      bool = false;
      if (bool) {
        break label75;
      }
    }
    label75:
    for (localObject = Executors.newCachedThreadPool();; localObject = a.newCachedThreadPool())
    {
      this.ayU = ((ExecutorService)localObject);
      this.ayV = Executors.newSingleThreadScheduledExecutor();
      this.ayW = new a((byte)0);
      AppMethodBeat.o(52980);
      return;
      bool = ((String)localObject).toLowerCase(Locale.US).contains("android");
      break;
    }
  }
  
  public static ExecutorService mY()
  {
    return ayT.ayU;
  }
  
  static Executor mZ()
  {
    return ayT.ayW;
  }
  
  static final class a
    implements Executor
  {
    private ThreadLocal<Integer> ayX;
    
    private a()
    {
      AppMethodBeat.i(52977);
      this.ayX = new ThreadLocal();
      AppMethodBeat.o(52977);
    }
    
    private int na()
    {
      AppMethodBeat.i(52978);
      Integer localInteger2 = (Integer)this.ayX.get();
      Integer localInteger1 = localInteger2;
      if (localInteger2 == null) {
        localInteger1 = Integer.valueOf(0);
      }
      int i = localInteger1.intValue() - 1;
      if (i == 0) {
        this.ayX.remove();
      }
      for (;;)
      {
        AppMethodBeat.o(52978);
        return i;
        this.ayX.set(Integer.valueOf(i));
      }
    }
    
    public final void execute(Runnable paramRunnable)
    {
      AppMethodBeat.i(52979);
      Integer localInteger2 = (Integer)this.ayX.get();
      Integer localInteger1 = localInteger2;
      if (localInteger2 == null) {
        localInteger1 = Integer.valueOf(0);
      }
      int i = localInteger1.intValue() + 1;
      this.ayX.set(Integer.valueOf(i));
      if (i <= 15) {}
      for (;;)
      {
        try
        {
          paramRunnable.run();
          return;
        }
        finally
        {
          na();
          AppMethodBeat.o(52979);
        }
        b.mY().execute(paramRunnable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.b
 * JD-Core Version:    0.7.0.1
 */
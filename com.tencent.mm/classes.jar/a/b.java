package a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class b
{
  private static final b cks;
  private final ExecutorService ckt;
  private final ScheduledExecutorService cku;
  private final Executor ckv;
  
  static
  {
    AppMethodBeat.i(52981);
    cks = new b();
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
    for (localObject = Executors.newCachedThreadPool();; localObject = a.Mp())
    {
      this.ckt = ((ExecutorService)localObject);
      this.cku = Executors.newSingleThreadScheduledExecutor();
      this.ckv = new a((byte)0);
      AppMethodBeat.o(52980);
      return;
      bool = ((String)localObject).toLowerCase(Locale.US).contains("android");
      break;
    }
  }
  
  public static ExecutorService Mr()
  {
    return cks.ckt;
  }
  
  static Executor Ms()
  {
    return cks.ckv;
  }
  
  static final class a
    implements Executor
  {
    private ThreadLocal<Integer> ckw;
    
    private a()
    {
      AppMethodBeat.i(52977);
      this.ckw = new ThreadLocal();
      AppMethodBeat.o(52977);
    }
    
    private int Mt()
    {
      AppMethodBeat.i(52978);
      Integer localInteger2 = (Integer)this.ckw.get();
      Integer localInteger1 = localInteger2;
      if (localInteger2 == null) {
        localInteger1 = Integer.valueOf(0);
      }
      int i = localInteger1.intValue() - 1;
      if (i == 0) {
        this.ckw.remove();
      }
      for (;;)
      {
        AppMethodBeat.o(52978);
        return i;
        this.ckw.set(Integer.valueOf(i));
      }
    }
    
    public final void execute(Runnable paramRunnable)
    {
      AppMethodBeat.i(52979);
      Integer localInteger2 = (Integer)this.ckw.get();
      Integer localInteger1 = localInteger2;
      if (localInteger2 == null) {
        localInteger1 = Integer.valueOf(0);
      }
      int i = localInteger1.intValue() + 1;
      this.ckw.set(Integer.valueOf(i));
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
          Mt();
          AppMethodBeat.o(52979);
        }
        b.Mr().execute(paramRunnable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.b
 * JD-Core Version:    0.7.0.1
 */
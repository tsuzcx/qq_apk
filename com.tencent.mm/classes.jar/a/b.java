package a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class b
{
  private static final b azN;
  private final ExecutorService azO;
  private final ScheduledExecutorService azP;
  private final Executor azQ;
  
  static
  {
    AppMethodBeat.i(52981);
    azN = new b();
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
      this.azO = ((ExecutorService)localObject);
      this.azP = Executors.newSingleThreadScheduledExecutor();
      this.azQ = new a((byte)0);
      AppMethodBeat.o(52980);
      return;
      bool = ((String)localObject).toLowerCase(Locale.US).contains("android");
      break;
    }
  }
  
  public static ExecutorService ni()
  {
    return azN.azO;
  }
  
  static Executor nj()
  {
    return azN.azQ;
  }
  
  static final class a
    implements Executor
  {
    private ThreadLocal<Integer> azR;
    
    private a()
    {
      AppMethodBeat.i(52977);
      this.azR = new ThreadLocal();
      AppMethodBeat.o(52977);
    }
    
    private int nk()
    {
      AppMethodBeat.i(52978);
      Integer localInteger2 = (Integer)this.azR.get();
      Integer localInteger1 = localInteger2;
      if (localInteger2 == null) {
        localInteger1 = Integer.valueOf(0);
      }
      int i = localInteger1.intValue() - 1;
      if (i == 0) {
        this.azR.remove();
      }
      for (;;)
      {
        AppMethodBeat.o(52978);
        return i;
        this.azR.set(Integer.valueOf(i));
      }
    }
    
    public final void execute(Runnable paramRunnable)
    {
      AppMethodBeat.i(52979);
      Integer localInteger2 = (Integer)this.azR.get();
      Integer localInteger1 = localInteger2;
      if (localInteger2 == null) {
        localInteger1 = Integer.valueOf(0);
      }
      int i = localInteger1.intValue() + 1;
      this.azR.set(Integer.valueOf(i));
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
          nk();
          AppMethodBeat.o(52979);
        }
        b.ni().execute(paramRunnable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.b
 * JD-Core Version:    0.7.0.1
 */
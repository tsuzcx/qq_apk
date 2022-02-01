package a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class b
{
  private static final b avW;
  private final ExecutorService avX;
  private final ScheduledExecutorService avY;
  private final Executor avZ;
  
  static
  {
    AppMethodBeat.i(52981);
    avW = new b();
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
    for (localObject = Executors.newCachedThreadPool();; localObject = a.nK())
    {
      this.avX = ((ExecutorService)localObject);
      this.avY = Executors.newSingleThreadScheduledExecutor();
      this.avZ = new a((byte)0);
      AppMethodBeat.o(52980);
      return;
      bool = ((String)localObject).toLowerCase(Locale.US).contains("android");
      break;
    }
  }
  
  public static ExecutorService nM()
  {
    return avW.avX;
  }
  
  static Executor nN()
  {
    return avW.avZ;
  }
  
  static final class a
    implements Executor
  {
    private ThreadLocal<Integer> awa;
    
    private a()
    {
      AppMethodBeat.i(52977);
      this.awa = new ThreadLocal();
      AppMethodBeat.o(52977);
    }
    
    private int nO()
    {
      AppMethodBeat.i(52978);
      Integer localInteger2 = (Integer)this.awa.get();
      Integer localInteger1 = localInteger2;
      if (localInteger2 == null) {
        localInteger1 = Integer.valueOf(0);
      }
      int i = localInteger1.intValue() - 1;
      if (i == 0) {
        this.awa.remove();
      }
      for (;;)
      {
        AppMethodBeat.o(52978);
        return i;
        this.awa.set(Integer.valueOf(i));
      }
    }
    
    public final void execute(Runnable paramRunnable)
    {
      AppMethodBeat.i(52979);
      Integer localInteger2 = (Integer)this.awa.get();
      Integer localInteger1 = localInteger2;
      if (localInteger2 == null) {
        localInteger1 = Integer.valueOf(0);
      }
      int i = localInteger1.intValue() + 1;
      this.awa.set(Integer.valueOf(i));
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
          nO();
          AppMethodBeat.o(52979);
        }
        b.nM().execute(paramRunnable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.b
 * JD-Core Version:    0.7.0.1
 */
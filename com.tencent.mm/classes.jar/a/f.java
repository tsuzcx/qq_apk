package a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class f<TResult>
{
  private static volatile f.a ckA;
  private static f<?> ckG;
  private static f<Boolean> ckH;
  private static f<Boolean> ckI;
  private static f<?> ckJ;
  public static final ExecutorService ckx;
  public static final Executor cky;
  public static final Executor ckz;
  private boolean cancelled;
  private boolean ckB;
  private Exception ckC;
  private boolean ckD;
  private h ckE;
  private List<d<TResult, Void>> ckF;
  private final Object lock;
  private TResult result;
  
  static
  {
    AppMethodBeat.i(53004);
    ckx = b.Mr();
    cky = b.Ms();
    ckz = a.Mq();
    ckG = new f(null);
    ckH = new f(Boolean.TRUE);
    ckI = new f(Boolean.FALSE);
    ckJ = new f((byte)0);
    AppMethodBeat.o(53004);
  }
  
  f()
  {
    AppMethodBeat.i(52991);
    this.lock = new Object();
    this.ckF = new ArrayList();
    AppMethodBeat.o(52991);
  }
  
  private f(byte paramByte)
  {
    AppMethodBeat.i(52993);
    this.lock = new Object();
    this.ckF = new ArrayList();
    My();
    AppMethodBeat.o(52993);
  }
  
  private f(TResult paramTResult)
  {
    AppMethodBeat.i(52992);
    this.lock = new Object();
    this.ckF = new ArrayList();
    trySetResult(paramTResult);
    AppMethodBeat.o(52992);
  }
  
  public static f.a Mu()
  {
    return ckA;
  }
  
  private void Mx()
  {
    AppMethodBeat.i(52999);
    for (;;)
    {
      d locald;
      synchronized (this.lock)
      {
        Iterator localIterator = this.ckF.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        locald = (d)localIterator.next();
      }
      try
      {
        locald.a(this);
      }
      catch (RuntimeException localRuntimeException1)
      {
        AppMethodBeat.o(52999);
        throw localRuntimeException1;
        localObject2 = finally;
        AppMethodBeat.o(52999);
        throw localObject2;
      }
      catch (Exception localException)
      {
        RuntimeException localRuntimeException2 = new RuntimeException(localException);
        AppMethodBeat.o(52999);
        throw localRuntimeException2;
      }
    }
    this.ckF = null;
    AppMethodBeat.o(52999);
  }
  
  public static <TResult> f<TResult> a(Callable<TResult> paramCallable)
  {
    AppMethodBeat.i(52995);
    paramCallable = a(paramCallable, ckx);
    AppMethodBeat.o(52995);
    return paramCallable;
  }
  
  private static <TResult> f<TResult> a(final Callable<TResult> paramCallable, Executor paramExecutor)
  {
    AppMethodBeat.i(52996);
    g localg = new g();
    try
    {
      paramExecutor.execute(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52990);
          if (this.ckN != null)
          {
            AppMethodBeat.o(52990);
            throw null;
          }
          try
          {
            this.ckK.setResult(paramCallable.call());
            AppMethodBeat.o(52990);
            return;
          }
          catch (CancellationException localCancellationException)
          {
            this.ckK.Mz();
            AppMethodBeat.o(52990);
            return;
          }
          catch (Exception localException)
          {
            this.ckK.c(localException);
            AppMethodBeat.o(52990);
          }
        }
      });
      paramCallable = localg.ckQ;
      AppMethodBeat.o(52996);
      return paramCallable;
    }
    catch (Exception paramCallable)
    {
      for (;;)
      {
        localg.c(new e(paramCallable));
      }
    }
  }
  
  private static <TContinuationResult, TResult> void a(final g<TContinuationResult> paramg, final d<TResult, TContinuationResult> paramd, final f<TResult> paramf, Executor paramExecutor, c paramc)
  {
    AppMethodBeat.i(52998);
    try
    {
      paramExecutor.execute(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52989);
          if (this.ckN != null)
          {
            AppMethodBeat.o(52989);
            throw null;
          }
          try
          {
            Object localObject = paramd.a(paramf);
            paramg.setResult(localObject);
            AppMethodBeat.o(52989);
            return;
          }
          catch (CancellationException localCancellationException)
          {
            paramg.Mz();
            AppMethodBeat.o(52989);
            return;
          }
          catch (Exception localException)
          {
            paramg.c(localException);
            AppMethodBeat.o(52989);
          }
        }
      });
      AppMethodBeat.o(52998);
      return;
    }
    catch (Exception paramd)
    {
      paramg.c(new e(paramd));
      AppMethodBeat.o(52998);
    }
  }
  
  public static <TResult> f<TResult> b(Callable<TResult> paramCallable)
  {
    AppMethodBeat.i(187788);
    paramCallable = a(paramCallable, cky);
    AppMethodBeat.o(187788);
    return paramCallable;
  }
  
  private boolean isCompleted()
  {
    synchronized (this.lock)
    {
      boolean bool = this.ckB;
      return bool;
    }
  }
  
  public final boolean Mv()
  {
    AppMethodBeat.i(52994);
    synchronized (this.lock)
    {
      if (Mw() != null)
      {
        bool = true;
        AppMethodBeat.o(52994);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public final Exception Mw()
  {
    synchronized (this.lock)
    {
      if (this.ckC != null)
      {
        this.ckD = true;
        if (this.ckE != null)
        {
          this.ckE.ckQ = null;
          this.ckE = null;
        }
      }
      Exception localException = this.ckC;
      return localException;
    }
  }
  
  final boolean My()
  {
    AppMethodBeat.i(53000);
    synchronized (this.lock)
    {
      if (this.ckB)
      {
        AppMethodBeat.o(53000);
        return false;
      }
      this.ckB = true;
      this.cancelled = true;
      this.lock.notifyAll();
      Mx();
      AppMethodBeat.o(53000);
      return true;
    }
  }
  
  public final <TContinuationResult> f<TContinuationResult> a(final d<TResult, TContinuationResult> paramd, final Executor paramExecutor)
  {
    AppMethodBeat.i(52997);
    final g localg = new g();
    synchronized (this.lock)
    {
      boolean bool = isCompleted();
      if (!bool) {
        this.ckF.add(new d() {});
      }
      if (bool) {
        a(localg, paramd, this, paramExecutor, null);
      }
      paramd = localg.ckQ;
      AppMethodBeat.o(52997);
      return paramd;
    }
  }
  
  final boolean b(Exception paramException)
  {
    AppMethodBeat.i(53002);
    synchronized (this.lock)
    {
      if (this.ckB)
      {
        AppMethodBeat.o(53002);
        return false;
      }
      this.ckB = true;
      this.ckC = paramException;
      this.ckD = false;
      this.lock.notifyAll();
      Mx();
      if ((!this.ckD) && (ckA != null)) {
        this.ckE = new h(this);
      }
      AppMethodBeat.o(53002);
      return true;
    }
  }
  
  public final TResult getResult()
  {
    synchronized (this.lock)
    {
      Object localObject2 = this.result;
      return localObject2;
    }
  }
  
  final boolean trySetResult(TResult paramTResult)
  {
    AppMethodBeat.i(53001);
    synchronized (this.lock)
    {
      if (this.ckB)
      {
        AppMethodBeat.o(53001);
        return false;
      }
      this.ckB = true;
      this.result = paramTResult;
      this.lock.notifyAll();
      Mx();
      AppMethodBeat.o(53001);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     a.f
 * JD-Core Version:    0.7.0.1
 */
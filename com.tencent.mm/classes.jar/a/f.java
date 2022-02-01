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
  public static final ExecutorService awb;
  public static final Executor awc;
  public static final Executor awd;
  private static volatile a awe;
  private static f<?> awj;
  private static f<Boolean> awk;
  private static f<Boolean> awl;
  private static f<?> awm;
  private boolean awf;
  private boolean awg;
  private h awh;
  private List<d<TResult, Void>> awi;
  private boolean cancelled;
  private Exception error;
  private final Object lock;
  private TResult result;
  
  static
  {
    AppMethodBeat.i(53004);
    awb = b.nM();
    awc = b.nN();
    awd = a.nL();
    awj = new f(null);
    awk = new f(Boolean.TRUE);
    awl = new f(Boolean.FALSE);
    awm = new f((byte)0);
    AppMethodBeat.o(53004);
  }
  
  f()
  {
    AppMethodBeat.i(52991);
    this.lock = new Object();
    this.awi = new ArrayList();
    AppMethodBeat.o(52991);
  }
  
  private f(byte paramByte)
  {
    AppMethodBeat.i(52993);
    this.lock = new Object();
    this.awi = new ArrayList();
    nS();
    AppMethodBeat.o(52993);
  }
  
  private f(TResult paramTResult)
  {
    AppMethodBeat.i(52992);
    this.lock = new Object();
    this.awi = new ArrayList();
    trySetResult(paramTResult);
    AppMethodBeat.o(52992);
  }
  
  public static <TResult> f<TResult> a(Callable<TResult> paramCallable)
  {
    AppMethodBeat.i(52995);
    paramCallable = a(paramCallable, awb);
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
          if (this.awq != null)
          {
            AppMethodBeat.o(52990);
            throw null;
          }
          try
          {
            this.awn.setResult(paramCallable.call());
            AppMethodBeat.o(52990);
            return;
          }
          catch (CancellationException localCancellationException)
          {
            this.awn.nT();
            AppMethodBeat.o(52990);
            return;
          }
          catch (Exception localException)
          {
            this.awn.c(localException);
            AppMethodBeat.o(52990);
          }
        }
      });
      paramCallable = localg.awt;
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
          if (this.awq != null)
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
            paramg.nT();
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
    AppMethodBeat.i(206925);
    paramCallable = a(paramCallable, awc);
    AppMethodBeat.o(206925);
    return paramCallable;
  }
  
  private boolean isCompleted()
  {
    synchronized (this.lock)
    {
      boolean bool = this.awf;
      return bool;
    }
  }
  
  public static a nP()
  {
    return awe;
  }
  
  private void nR()
  {
    AppMethodBeat.i(52999);
    for (;;)
    {
      d locald;
      synchronized (this.lock)
      {
        Iterator localIterator = this.awi.iterator();
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
    this.awi = null;
    AppMethodBeat.o(52999);
  }
  
  public final <TContinuationResult> f<TContinuationResult> a(final d<TResult, TContinuationResult> paramd, final Executor paramExecutor)
  {
    AppMethodBeat.i(52997);
    final g localg = new g();
    synchronized (this.lock)
    {
      boolean bool = isCompleted();
      if (!bool) {
        this.awi.add(new d() {});
      }
      if (bool) {
        a(localg, paramd, this, paramExecutor, null);
      }
      paramd = localg.awt;
      AppMethodBeat.o(52997);
      return paramd;
    }
  }
  
  final boolean b(Exception paramException)
  {
    AppMethodBeat.i(53002);
    synchronized (this.lock)
    {
      if (this.awf)
      {
        AppMethodBeat.o(53002);
        return false;
      }
      this.awf = true;
      this.error = paramException;
      this.awg = false;
      this.lock.notifyAll();
      nR();
      if ((!this.awg) && (awe != null)) {
        this.awh = new h(this);
      }
      AppMethodBeat.o(53002);
      return true;
    }
  }
  
  public final Exception getError()
  {
    synchronized (this.lock)
    {
      if (this.error != null)
      {
        this.awg = true;
        if (this.awh != null)
        {
          this.awh.awt = null;
          this.awh = null;
        }
      }
      Exception localException = this.error;
      return localException;
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
  
  public final boolean nQ()
  {
    AppMethodBeat.i(52994);
    synchronized (this.lock)
    {
      if (getError() != null)
      {
        bool = true;
        AppMethodBeat.o(52994);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  final boolean nS()
  {
    AppMethodBeat.i(53000);
    synchronized (this.lock)
    {
      if (this.awf)
      {
        AppMethodBeat.o(53000);
        return false;
      }
      this.awf = true;
      this.cancelled = true;
      this.lock.notifyAll();
      nR();
      AppMethodBeat.o(53000);
      return true;
    }
  }
  
  final boolean trySetResult(TResult paramTResult)
  {
    AppMethodBeat.i(53001);
    synchronized (this.lock)
    {
      if (this.awf)
      {
        AppMethodBeat.o(53001);
        return false;
      }
      this.awf = true;
      this.result = paramTResult;
      this.lock.notifyAll();
      nR();
      AppMethodBeat.o(53001);
      return true;
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.f
 * JD-Core Version:    0.7.0.1
 */
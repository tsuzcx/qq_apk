package a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class h<TResult>
{
  public static final ExecutorService aBM;
  public static final Executor aBN;
  public static final Executor aBO;
  private static volatile a aBP;
  private static h<?> aBU;
  private static h<Boolean> aBV;
  private static h<Boolean> aBW;
  private static h<?> aBX;
  private boolean aBQ;
  private boolean aBR;
  private j aBS;
  private List<f<TResult, Void>> aBT;
  private boolean cancelled;
  private Exception error;
  private final Object lock;
  private TResult result;
  
  static
  {
    AppMethodBeat.i(53004);
    aBM = b.nC();
    aBN = b.nD();
    aBO = a.nB();
    aBU = new h(null);
    aBV = new h(Boolean.TRUE);
    aBW = new h(Boolean.FALSE);
    aBX = new h((byte)0);
    AppMethodBeat.o(53004);
  }
  
  h()
  {
    AppMethodBeat.i(52991);
    this.lock = new Object();
    this.aBT = new ArrayList();
    AppMethodBeat.o(52991);
  }
  
  private h(byte paramByte)
  {
    AppMethodBeat.i(52993);
    this.lock = new Object();
    this.aBT = new ArrayList();
    nJ();
    AppMethodBeat.o(52993);
  }
  
  private h(TResult paramTResult)
  {
    AppMethodBeat.i(52992);
    this.lock = new Object();
    this.aBT = new ArrayList();
    trySetResult(paramTResult);
    AppMethodBeat.o(52992);
  }
  
  public static <TResult> h<TResult> a(Callable<TResult> paramCallable)
  {
    AppMethodBeat.i(52995);
    paramCallable = a(paramCallable, aBM);
    AppMethodBeat.o(52995);
    return paramCallable;
  }
  
  private static <TResult> h<TResult> a(final Callable<TResult> paramCallable, Executor paramExecutor)
  {
    AppMethodBeat.i(52996);
    i locali = new i();
    try
    {
      paramExecutor.execute(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52990);
          if ((this.aCb != null) && (this.aCb.aBH.isCancellationRequested()))
          {
            this.aBY.nK();
            AppMethodBeat.o(52990);
            return;
          }
          try
          {
            this.aBY.setResult(paramCallable.call());
            AppMethodBeat.o(52990);
            return;
          }
          catch (CancellationException localCancellationException)
          {
            this.aBY.nK();
            AppMethodBeat.o(52990);
            return;
          }
          catch (Exception localException)
          {
            this.aBY.c(localException);
            AppMethodBeat.o(52990);
          }
        }
      });
      paramCallable = locali.aCe;
      AppMethodBeat.o(52996);
      return paramCallable;
    }
    catch (Exception paramCallable)
    {
      for (;;)
      {
        locali.c(new g(paramCallable));
      }
    }
  }
  
  private static <TContinuationResult, TResult> void a(final i<TContinuationResult> parami, final f<TResult, TContinuationResult> paramf, final h<TResult> paramh, Executor paramExecutor, c paramc)
  {
    AppMethodBeat.i(52998);
    try
    {
      paramExecutor.execute(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52989);
          if ((this.aCb != null) && (this.aCb.aBH.isCancellationRequested()))
          {
            parami.nK();
            AppMethodBeat.o(52989);
            return;
          }
          try
          {
            Object localObject = paramf.a(paramh);
            parami.setResult(localObject);
            AppMethodBeat.o(52989);
            return;
          }
          catch (CancellationException localCancellationException)
          {
            parami.nK();
            AppMethodBeat.o(52989);
            return;
          }
          catch (Exception localException)
          {
            parami.c(localException);
            AppMethodBeat.o(52989);
          }
        }
      });
      AppMethodBeat.o(52998);
      return;
    }
    catch (Exception paramf)
    {
      parami.c(new g(paramf));
      AppMethodBeat.o(52998);
    }
  }
  
  public static <TResult> h<TResult> b(Callable<TResult> paramCallable)
  {
    AppMethodBeat.i(240220);
    paramCallable = a(paramCallable, aBN);
    AppMethodBeat.o(240220);
    return paramCallable;
  }
  
  private boolean isCompleted()
  {
    synchronized (this.lock)
    {
      boolean bool = this.aBQ;
      return bool;
    }
  }
  
  public static a nG()
  {
    return aBP;
  }
  
  private void nI()
  {
    AppMethodBeat.i(52999);
    for (;;)
    {
      f localf;
      synchronized (this.lock)
      {
        Iterator localIterator = this.aBT.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localf = (f)localIterator.next();
      }
      try
      {
        localf.a(this);
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
    this.aBT = null;
    AppMethodBeat.o(52999);
  }
  
  public final <TContinuationResult> h<TContinuationResult> a(final f<TResult, TContinuationResult> paramf, final Executor paramExecutor)
  {
    AppMethodBeat.i(52997);
    final i locali = new i();
    synchronized (this.lock)
    {
      boolean bool = isCompleted();
      if (!bool) {
        this.aBT.add(new f() {});
      }
      if (bool) {
        a(locali, paramf, this, paramExecutor, null);
      }
      paramf = locali.aCe;
      AppMethodBeat.o(52997);
      return paramf;
    }
  }
  
  final boolean b(Exception paramException)
  {
    AppMethodBeat.i(53002);
    synchronized (this.lock)
    {
      if (this.aBQ)
      {
        AppMethodBeat.o(53002);
        return false;
      }
      this.aBQ = true;
      this.error = paramException;
      this.aBR = false;
      this.lock.notifyAll();
      nI();
      if ((!this.aBR) && (aBP != null)) {
        this.aBS = new j(this);
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
        this.aBR = true;
        if (this.aBS != null)
        {
          this.aBS.aCe = null;
          this.aBS = null;
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
  
  public final boolean nH()
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
  
  final boolean nJ()
  {
    AppMethodBeat.i(53000);
    synchronized (this.lock)
    {
      if (this.aBQ)
      {
        AppMethodBeat.o(53000);
        return false;
      }
      this.aBQ = true;
      this.cancelled = true;
      this.lock.notifyAll();
      nI();
      AppMethodBeat.o(53000);
      return true;
    }
  }
  
  final boolean trySetResult(TResult paramTResult)
  {
    AppMethodBeat.i(53001);
    synchronized (this.lock)
    {
      if (this.aBQ)
      {
        AppMethodBeat.o(53001);
        return false;
      }
      this.aBQ = true;
      this.result = paramTResult;
      this.lock.notifyAll();
      nI();
      AppMethodBeat.o(53001);
      return true;
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.h
 * JD-Core Version:    0.7.0.1
 */
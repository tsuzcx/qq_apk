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
  public static final ExecutorService aBO;
  public static final Executor aBP;
  public static final Executor aBQ;
  private static volatile a aBR;
  private static h<?> aBW;
  private static h<Boolean> aBX;
  private static h<Boolean> aBY;
  private static h<?> aBZ;
  private boolean aBS;
  private boolean aBT;
  private j aBU;
  private List<f<TResult, Void>> aBV;
  private boolean cancelled;
  private Exception error;
  private final Object lock;
  private TResult result;
  
  static
  {
    AppMethodBeat.i(53004);
    aBO = b.nA();
    aBP = b.nB();
    aBQ = a.nz();
    aBW = new h(null);
    aBX = new h(Boolean.TRUE);
    aBY = new h(Boolean.FALSE);
    aBZ = new h((byte)0);
    AppMethodBeat.o(53004);
  }
  
  h()
  {
    AppMethodBeat.i(52991);
    this.lock = new Object();
    this.aBV = new ArrayList();
    AppMethodBeat.o(52991);
  }
  
  private h(byte paramByte)
  {
    AppMethodBeat.i(52993);
    this.lock = new Object();
    this.aBV = new ArrayList();
    nH();
    AppMethodBeat.o(52993);
  }
  
  private h(TResult paramTResult)
  {
    AppMethodBeat.i(52992);
    this.lock = new Object();
    this.aBV = new ArrayList();
    trySetResult(paramTResult);
    AppMethodBeat.o(52992);
  }
  
  public static <TResult> h<TResult> a(Callable<TResult> paramCallable)
  {
    AppMethodBeat.i(52995);
    paramCallable = a(paramCallable, aBO);
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
          if ((this.aCd != null) && (this.aCd.aBJ.isCancellationRequested()))
          {
            this.aCa.nI();
            AppMethodBeat.o(52990);
            return;
          }
          try
          {
            this.aCa.setResult(paramCallable.call());
            AppMethodBeat.o(52990);
            return;
          }
          catch (CancellationException localCancellationException)
          {
            this.aCa.nI();
            AppMethodBeat.o(52990);
            return;
          }
          catch (Exception localException)
          {
            this.aCa.c(localException);
            AppMethodBeat.o(52990);
          }
        }
      });
      paramCallable = locali.aCg;
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
          if ((this.aCd != null) && (this.aCd.aBJ.isCancellationRequested()))
          {
            parami.nI();
            AppMethodBeat.o(52989);
            return;
          }
          try
          {
            paramf.a(paramh);
            parami.setResult(null);
            AppMethodBeat.o(52989);
            return;
          }
          catch (CancellationException localCancellationException)
          {
            parami.nI();
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
  
  private boolean isCompleted()
  {
    synchronized (this.lock)
    {
      boolean bool = this.aBS;
      return bool;
    }
  }
  
  public static a nE()
  {
    return aBR;
  }
  
  private void nG()
  {
    AppMethodBeat.i(52999);
    for (;;)
    {
      f localf;
      synchronized (this.lock)
      {
        Iterator localIterator = this.aBV.iterator();
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
    this.aBV = null;
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
        this.aBV.add(new f() {});
      }
      if (bool) {
        a(locali, paramf, this, paramExecutor, null);
      }
      paramf = locali.aCg;
      AppMethodBeat.o(52997);
      return paramf;
    }
  }
  
  final boolean b(Exception paramException)
  {
    AppMethodBeat.i(53002);
    synchronized (this.lock)
    {
      if (this.aBS)
      {
        AppMethodBeat.o(53002);
        return false;
      }
      this.aBS = true;
      this.error = paramException;
      this.aBT = false;
      this.lock.notifyAll();
      nG();
      if ((!this.aBT) && (aBR != null)) {
        this.aBU = new j(this);
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
        this.aBT = true;
        if (this.aBU != null)
        {
          this.aBU.aCg = null;
          this.aBU = null;
        }
      }
      Exception localException = this.error;
      return localException;
    }
  }
  
  public final boolean nF()
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
  
  final boolean nH()
  {
    AppMethodBeat.i(53000);
    synchronized (this.lock)
    {
      if (this.aBS)
      {
        AppMethodBeat.o(53000);
        return false;
      }
      this.aBS = true;
      this.cancelled = true;
      this.lock.notifyAll();
      nG();
      AppMethodBeat.o(53000);
      return true;
    }
  }
  
  final boolean trySetResult(TResult paramTResult)
  {
    AppMethodBeat.i(53001);
    synchronized (this.lock)
    {
      if (this.aBS)
      {
        AppMethodBeat.o(53001);
        return false;
      }
      this.aBS = true;
      this.result = paramTResult;
      this.lock.notifyAll();
      nG();
      AppMethodBeat.o(53001);
      return true;
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.h
 * JD-Core Version:    0.7.0.1
 */
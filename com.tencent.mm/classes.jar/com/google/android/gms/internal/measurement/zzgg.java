package com.google.android.gms.internal.measurement;

import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zzgg
  extends zzhh
{
  private static final AtomicLong zzalx;
  private ExecutorService zzaln;
  private zzgk zzalo;
  private zzgk zzalp;
  private final PriorityBlockingQueue<zzgj<?>> zzalq;
  private final BlockingQueue<zzgj<?>> zzalr;
  private final Thread.UncaughtExceptionHandler zzals;
  private final Thread.UncaughtExceptionHandler zzalt;
  private final Object zzalu;
  private final Semaphore zzalv;
  private volatile boolean zzalw;
  
  static
  {
    AppMethodBeat.i(69052);
    zzalx = new AtomicLong(-9223372036854775808L);
    AppMethodBeat.o(69052);
  }
  
  zzgg(zzgl paramzzgl)
  {
    super(paramzzgl);
    AppMethodBeat.i(69023);
    this.zzalu = new Object();
    this.zzalv = new Semaphore(2);
    this.zzalq = new PriorityBlockingQueue();
    this.zzalr = new LinkedBlockingQueue();
    this.zzals = new zzgi(this, "Thread death: Uncaught exception on worker thread");
    this.zzalt = new zzgi(this, "Thread death: Uncaught exception on network thread");
    AppMethodBeat.o(69023);
  }
  
  public static boolean isMainThread()
  {
    AppMethodBeat.i(69026);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      AppMethodBeat.o(69026);
      return true;
    }
    AppMethodBeat.o(69026);
    return false;
  }
  
  private final void zza(zzgj<?> paramzzgj)
  {
    AppMethodBeat.i(69032);
    synchronized (this.zzalu)
    {
      this.zzalq.add(paramzzgj);
      if (this.zzalo == null)
      {
        this.zzalo = new zzgk(this, "Measurement Worker", this.zzalq);
        this.zzalo.setUncaughtExceptionHandler(this.zzals);
        this.zzalo.start();
        AppMethodBeat.o(69032);
        return;
      }
      this.zzalo.zzjn();
    }
  }
  
  final <T> T zza(AtomicReference<T> paramAtomicReference, long paramLong, String paramString, Runnable paramRunnable)
  {
    AppMethodBeat.i(69031);
    for (;;)
    {
      try
      {
        zzgd().zzc(paramRunnable);
        try
        {
          paramAtomicReference.wait(15000L);
          paramRunnable = paramAtomicReference.get();
          if (paramRunnable == null)
          {
            zzfi localzzfi = zzge().zzip();
            paramAtomicReference = String.valueOf(paramString);
            if (paramAtomicReference.length() != 0)
            {
              paramAtomicReference = "Timed out waiting for ".concat(paramAtomicReference);
              localzzfi.log(paramAtomicReference);
            }
          }
          else
          {
            AppMethodBeat.o(69031);
            return paramRunnable;
          }
        }
        catch (InterruptedException paramRunnable)
        {
          paramRunnable = zzge().zzip();
          paramString = String.valueOf(paramString);
          if (paramString.length() != 0)
          {
            paramString = "Interrupted waiting for ".concat(paramString);
            paramRunnable.log(paramString);
            return null;
          }
          paramString = new String("Interrupted waiting for ");
          continue;
        }
        paramAtomicReference = new String("Timed out waiting for ");
      }
      finally
      {
        AppMethodBeat.o(69031);
      }
    }
  }
  
  public final void zzab()
  {
    AppMethodBeat.i(69024);
    if (Thread.currentThread() != this.zzalo)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Call expected from worker thread");
      AppMethodBeat.o(69024);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(69024);
  }
  
  public final <V> Future<V> zzb(Callable<V> paramCallable)
  {
    AppMethodBeat.i(69028);
    zzch();
    Preconditions.checkNotNull(paramCallable);
    paramCallable = new zzgj(this, paramCallable, false, "Task exception on worker thread");
    if (Thread.currentThread() == this.zzalo)
    {
      if (!this.zzalq.isEmpty()) {
        zzge().zzip().log("Callable skipped the worker queue.");
      }
      paramCallable.run();
    }
    for (;;)
    {
      AppMethodBeat.o(69028);
      return paramCallable;
      zza(paramCallable);
    }
  }
  
  public final <V> Future<V> zzc(Callable<V> paramCallable)
  {
    AppMethodBeat.i(69029);
    zzch();
    Preconditions.checkNotNull(paramCallable);
    paramCallable = new zzgj(this, paramCallable, true, "Task exception on worker thread");
    if (Thread.currentThread() == this.zzalo) {
      paramCallable.run();
    }
    for (;;)
    {
      AppMethodBeat.o(69029);
      return paramCallable;
      zza(paramCallable);
    }
  }
  
  public final void zzc(Runnable paramRunnable)
  {
    AppMethodBeat.i(69030);
    zzch();
    Preconditions.checkNotNull(paramRunnable);
    zza(new zzgj(this, paramRunnable, false, "Task exception on worker thread"));
    AppMethodBeat.o(69030);
  }
  
  public final void zzd(Runnable arg1)
  {
    AppMethodBeat.i(69033);
    zzch();
    Preconditions.checkNotNull(???);
    zzgj localzzgj = new zzgj(this, ???, false, "Task exception on network thread");
    synchronized (this.zzalu)
    {
      this.zzalr.add(localzzgj);
      if (this.zzalp == null)
      {
        this.zzalp = new zzgk(this, "Measurement Network", this.zzalr);
        this.zzalp.setUncaughtExceptionHandler(this.zzalt);
        this.zzalp.start();
        AppMethodBeat.o(69033);
        return;
      }
      this.zzalp.zzjn();
    }
  }
  
  public final void zzfs()
  {
    AppMethodBeat.i(69025);
    if (Thread.currentThread() != this.zzalp)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Call expected from network thread");
      AppMethodBeat.o(69025);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(69025);
  }
  
  protected final boolean zzhf()
  {
    return false;
  }
  
  public final boolean zzjk()
  {
    AppMethodBeat.i(69027);
    if (Thread.currentThread() == this.zzalo)
    {
      AppMethodBeat.o(69027);
      return true;
    }
    AppMethodBeat.o(69027);
    return false;
  }
  
  final ExecutorService zzjl()
  {
    AppMethodBeat.i(69034);
    synchronized (this.zzalu)
    {
      if (this.zzaln == null) {
        this.zzaln = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
      }
      ExecutorService localExecutorService = this.zzaln;
      AppMethodBeat.o(69034);
      return localExecutorService;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzgg
 * JD-Core Version:    0.7.0.1
 */
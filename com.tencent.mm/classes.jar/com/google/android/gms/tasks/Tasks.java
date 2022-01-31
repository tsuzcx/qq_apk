package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;

public final class Tasks
{
  public static <TResult> TResult await(Task<TResult> paramTask)
  {
    AppMethodBeat.i(57366);
    Preconditions.checkNotMainThread();
    Preconditions.checkNotNull(paramTask, "Task must not be null");
    if (paramTask.isComplete())
    {
      paramTask = zzb(paramTask);
      AppMethodBeat.o(57366);
      return paramTask;
    }
    zza localzza = new zza(null);
    zza(paramTask, localzza);
    localzza.await();
    paramTask = zzb(paramTask);
    AppMethodBeat.o(57366);
    return paramTask;
  }
  
  public static <TResult> TResult await(Task<TResult> paramTask, long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(57367);
    Preconditions.checkNotMainThread();
    Preconditions.checkNotNull(paramTask, "Task must not be null");
    Preconditions.checkNotNull(paramTimeUnit, "TimeUnit must not be null");
    if (paramTask.isComplete())
    {
      paramTask = zzb(paramTask);
      AppMethodBeat.o(57367);
      return paramTask;
    }
    zza localzza = new zza(null);
    zza(paramTask, localzza);
    if (!localzza.await(paramLong, paramTimeUnit))
    {
      paramTask = new TimeoutException("Timed out waiting for Task");
      AppMethodBeat.o(57367);
      throw paramTask;
    }
    paramTask = zzb(paramTask);
    AppMethodBeat.o(57367);
    return paramTask;
  }
  
  public static <TResult> Task<TResult> call(Callable<TResult> paramCallable)
  {
    AppMethodBeat.i(57364);
    paramCallable = call(TaskExecutors.MAIN_THREAD, paramCallable);
    AppMethodBeat.o(57364);
    return paramCallable;
  }
  
  public static <TResult> Task<TResult> call(Executor paramExecutor, Callable<TResult> paramCallable)
  {
    AppMethodBeat.i(57365);
    Preconditions.checkNotNull(paramExecutor, "Executor must not be null");
    Preconditions.checkNotNull(paramCallable, "Callback must not be null");
    zzu localzzu = new zzu();
    paramExecutor.execute(new zzv(localzzu, paramCallable));
    AppMethodBeat.o(57365);
    return localzzu;
  }
  
  public static <TResult> Task<TResult> forCanceled()
  {
    AppMethodBeat.i(57363);
    zzu localzzu = new zzu();
    localzzu.zzdp();
    AppMethodBeat.o(57363);
    return localzzu;
  }
  
  public static <TResult> Task<TResult> forException(Exception paramException)
  {
    AppMethodBeat.i(57362);
    zzu localzzu = new zzu();
    localzzu.setException(paramException);
    AppMethodBeat.o(57362);
    return localzzu;
  }
  
  public static <TResult> Task<TResult> forResult(TResult paramTResult)
  {
    AppMethodBeat.i(57361);
    zzu localzzu = new zzu();
    localzzu.setResult(paramTResult);
    AppMethodBeat.o(57361);
    return localzzu;
  }
  
  public static Task<Void> whenAll(Collection<? extends Task<?>> paramCollection)
  {
    AppMethodBeat.i(57368);
    if (paramCollection.isEmpty())
    {
      paramCollection = forResult(null);
      AppMethodBeat.o(57368);
      return paramCollection;
    }
    Object localObject = paramCollection.iterator();
    while (((Iterator)localObject).hasNext()) {
      if ((Task)((Iterator)localObject).next() == null)
      {
        paramCollection = new NullPointerException("null tasks are not accepted");
        AppMethodBeat.o(57368);
        throw paramCollection;
      }
    }
    localObject = new zzu();
    zzc localzzc = new zzc(paramCollection.size(), (zzu)localObject);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      zza((Task)paramCollection.next(), localzzc);
    }
    AppMethodBeat.o(57368);
    return localObject;
  }
  
  public static Task<Void> whenAll(Task<?>... paramVarArgs)
  {
    AppMethodBeat.i(57369);
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = forResult(null);
      AppMethodBeat.o(57369);
      return paramVarArgs;
    }
    paramVarArgs = whenAll(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(57369);
    return paramVarArgs;
  }
  
  public static Task<List<Task<?>>> whenAllComplete(Collection<? extends Task<?>> paramCollection)
  {
    AppMethodBeat.i(57372);
    paramCollection = whenAll(paramCollection).continueWithTask(new zzx(paramCollection));
    AppMethodBeat.o(57372);
    return paramCollection;
  }
  
  public static Task<List<Task<?>>> whenAllComplete(Task<?>... paramVarArgs)
  {
    AppMethodBeat.i(57373);
    paramVarArgs = whenAllComplete(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(57373);
    return paramVarArgs;
  }
  
  public static <TResult> Task<List<TResult>> whenAllSuccess(Collection<? extends Task<?>> paramCollection)
  {
    AppMethodBeat.i(57370);
    paramCollection = whenAll(paramCollection).continueWith(new zzw(paramCollection));
    AppMethodBeat.o(57370);
    return paramCollection;
  }
  
  public static <TResult> Task<List<TResult>> whenAllSuccess(Task<?>... paramVarArgs)
  {
    AppMethodBeat.i(57371);
    paramVarArgs = whenAllSuccess(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(57371);
    return paramVarArgs;
  }
  
  private static void zza(Task<?> paramTask, zzb paramzzb)
  {
    AppMethodBeat.i(57375);
    paramTask.addOnSuccessListener(TaskExecutors.zzagd, paramzzb);
    paramTask.addOnFailureListener(TaskExecutors.zzagd, paramzzb);
    paramTask.addOnCanceledListener(TaskExecutors.zzagd, paramzzb);
    AppMethodBeat.o(57375);
  }
  
  private static <TResult> TResult zzb(Task<TResult> paramTask)
  {
    AppMethodBeat.i(57374);
    if (paramTask.isSuccessful())
    {
      paramTask = paramTask.getResult();
      AppMethodBeat.o(57374);
      return paramTask;
    }
    if (paramTask.isCanceled())
    {
      paramTask = new CancellationException("Task is already canceled");
      AppMethodBeat.o(57374);
      throw paramTask;
    }
    paramTask = new ExecutionException(paramTask.getException());
    AppMethodBeat.o(57374);
    throw paramTask;
  }
  
  static final class zza
    implements Tasks.zzb
  {
    private final CountDownLatch zzfd;
    
    private zza()
    {
      AppMethodBeat.i(57350);
      this.zzfd = new CountDownLatch(1);
      AppMethodBeat.o(57350);
    }
    
    public final void await()
    {
      AppMethodBeat.i(57354);
      this.zzfd.await();
      AppMethodBeat.o(57354);
    }
    
    public final boolean await(long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(57355);
      boolean bool = this.zzfd.await(paramLong, paramTimeUnit);
      AppMethodBeat.o(57355);
      return bool;
    }
    
    public final void onCanceled()
    {
      AppMethodBeat.i(57353);
      this.zzfd.countDown();
      AppMethodBeat.o(57353);
    }
    
    public final void onFailure(Exception paramException)
    {
      AppMethodBeat.i(57352);
      this.zzfd.countDown();
      AppMethodBeat.o(57352);
    }
    
    public final void onSuccess(Object paramObject)
    {
      AppMethodBeat.i(57351);
      this.zzfd.countDown();
      AppMethodBeat.o(57351);
    }
  }
  
  static abstract interface zzb
    extends OnCanceledListener, OnFailureListener, OnSuccessListener<Object>
  {}
  
  static final class zzc
    implements Tasks.zzb
  {
    private final Object mLock;
    private final zzu<Void> zzafh;
    @GuardedBy("mLock")
    private Exception zzagh;
    private final int zzagl;
    @GuardedBy("mLock")
    private int zzagm;
    @GuardedBy("mLock")
    private int zzagn;
    @GuardedBy("mLock")
    private int zzago;
    @GuardedBy("mLock")
    private boolean zzagp;
    
    public zzc(int paramInt, zzu<Void> paramzzu)
    {
      AppMethodBeat.i(57356);
      this.mLock = new Object();
      this.zzagl = paramInt;
      this.zzafh = paramzzu;
      AppMethodBeat.o(57356);
    }
    
    @GuardedBy("mLock")
    private final void zzdu()
    {
      AppMethodBeat.i(57360);
      if (this.zzagm + this.zzagn + this.zzago == this.zzagl)
      {
        if (this.zzagh != null)
        {
          zzu localzzu = this.zzafh;
          int i = this.zzagn;
          int j = this.zzagl;
          localzzu.setException(new ExecutionException(54 + i + " out of " + j + " underlying tasks failed", this.zzagh));
          AppMethodBeat.o(57360);
          return;
        }
        if (this.zzagp)
        {
          this.zzafh.zzdp();
          AppMethodBeat.o(57360);
          return;
        }
        this.zzafh.setResult(null);
      }
      AppMethodBeat.o(57360);
    }
    
    public final void onCanceled()
    {
      AppMethodBeat.i(57359);
      synchronized (this.mLock)
      {
        this.zzago += 1;
        this.zzagp = true;
        zzdu();
        AppMethodBeat.o(57359);
        return;
      }
    }
    
    public final void onFailure(Exception paramException)
    {
      AppMethodBeat.i(57357);
      synchronized (this.mLock)
      {
        this.zzagn += 1;
        this.zzagh = paramException;
        zzdu();
        AppMethodBeat.o(57357);
        return;
      }
    }
    
    public final void onSuccess(Object arg1)
    {
      AppMethodBeat.i(57358);
      synchronized (this.mLock)
      {
        this.zzagm += 1;
        zzdu();
        AppMethodBeat.o(57358);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.Tasks
 * JD-Core Version:    0.7.0.1
 */
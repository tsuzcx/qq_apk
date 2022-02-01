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

public final class Tasks
{
  public static <TResult> TResult await(Task<TResult> paramTask)
  {
    AppMethodBeat.i(13365);
    Preconditions.checkNotMainThread();
    Preconditions.checkNotNull(paramTask, "Task must not be null");
    if (paramTask.isComplete())
    {
      paramTask = zzb(paramTask);
      AppMethodBeat.o(13365);
      return paramTask;
    }
    zza localzza = new zza(null);
    zza(paramTask, localzza);
    localzza.await();
    paramTask = zzb(paramTask);
    AppMethodBeat.o(13365);
    return paramTask;
  }
  
  public static <TResult> TResult await(Task<TResult> paramTask, long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(13366);
    Preconditions.checkNotMainThread();
    Preconditions.checkNotNull(paramTask, "Task must not be null");
    Preconditions.checkNotNull(paramTimeUnit, "TimeUnit must not be null");
    if (paramTask.isComplete())
    {
      paramTask = zzb(paramTask);
      AppMethodBeat.o(13366);
      return paramTask;
    }
    zza localzza = new zza(null);
    zza(paramTask, localzza);
    if (!localzza.await(paramLong, paramTimeUnit))
    {
      paramTask = new TimeoutException("Timed out waiting for Task");
      AppMethodBeat.o(13366);
      throw paramTask;
    }
    paramTask = zzb(paramTask);
    AppMethodBeat.o(13366);
    return paramTask;
  }
  
  public static <TResult> Task<TResult> call(Callable<TResult> paramCallable)
  {
    AppMethodBeat.i(13363);
    paramCallable = call(TaskExecutors.MAIN_THREAD, paramCallable);
    AppMethodBeat.o(13363);
    return paramCallable;
  }
  
  public static <TResult> Task<TResult> call(Executor paramExecutor, Callable<TResult> paramCallable)
  {
    AppMethodBeat.i(13364);
    Preconditions.checkNotNull(paramExecutor, "Executor must not be null");
    Preconditions.checkNotNull(paramCallable, "Callback must not be null");
    zzu localzzu = new zzu();
    paramExecutor.execute(new zzv(localzzu, paramCallable));
    AppMethodBeat.o(13364);
    return localzzu;
  }
  
  public static <TResult> Task<TResult> forCanceled()
  {
    AppMethodBeat.i(13362);
    zzu localzzu = new zzu();
    localzzu.zzdp();
    AppMethodBeat.o(13362);
    return localzzu;
  }
  
  public static <TResult> Task<TResult> forException(Exception paramException)
  {
    AppMethodBeat.i(13361);
    zzu localzzu = new zzu();
    localzzu.setException(paramException);
    AppMethodBeat.o(13361);
    return localzzu;
  }
  
  public static <TResult> Task<TResult> forResult(TResult paramTResult)
  {
    AppMethodBeat.i(13360);
    zzu localzzu = new zzu();
    localzzu.setResult(paramTResult);
    AppMethodBeat.o(13360);
    return localzzu;
  }
  
  public static Task<Void> whenAll(Collection<? extends Task<?>> paramCollection)
  {
    AppMethodBeat.i(13367);
    if (paramCollection.isEmpty())
    {
      paramCollection = forResult(null);
      AppMethodBeat.o(13367);
      return paramCollection;
    }
    Object localObject = paramCollection.iterator();
    while (((Iterator)localObject).hasNext()) {
      if ((Task)((Iterator)localObject).next() == null)
      {
        paramCollection = new NullPointerException("null tasks are not accepted");
        AppMethodBeat.o(13367);
        throw paramCollection;
      }
    }
    localObject = new zzu();
    zzc localzzc = new zzc(paramCollection.size(), (zzu)localObject);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      zza((Task)paramCollection.next(), localzzc);
    }
    AppMethodBeat.o(13367);
    return localObject;
  }
  
  public static Task<Void> whenAll(Task<?>... paramVarArgs)
  {
    AppMethodBeat.i(13368);
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = forResult(null);
      AppMethodBeat.o(13368);
      return paramVarArgs;
    }
    paramVarArgs = whenAll(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(13368);
    return paramVarArgs;
  }
  
  public static Task<List<Task<?>>> whenAllComplete(Collection<? extends Task<?>> paramCollection)
  {
    AppMethodBeat.i(13371);
    paramCollection = whenAll(paramCollection).continueWithTask(new zzx(paramCollection));
    AppMethodBeat.o(13371);
    return paramCollection;
  }
  
  public static Task<List<Task<?>>> whenAllComplete(Task<?>... paramVarArgs)
  {
    AppMethodBeat.i(13372);
    paramVarArgs = whenAllComplete(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(13372);
    return paramVarArgs;
  }
  
  public static <TResult> Task<List<TResult>> whenAllSuccess(Collection<? extends Task<?>> paramCollection)
  {
    AppMethodBeat.i(13369);
    paramCollection = whenAll(paramCollection).continueWith(new zzw(paramCollection));
    AppMethodBeat.o(13369);
    return paramCollection;
  }
  
  public static <TResult> Task<List<TResult>> whenAllSuccess(Task<?>... paramVarArgs)
  {
    AppMethodBeat.i(13370);
    paramVarArgs = whenAllSuccess(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(13370);
    return paramVarArgs;
  }
  
  private static void zza(Task<?> paramTask, zzb paramzzb)
  {
    AppMethodBeat.i(13374);
    paramTask.addOnSuccessListener(TaskExecutors.zzagd, paramzzb);
    paramTask.addOnFailureListener(TaskExecutors.zzagd, paramzzb);
    paramTask.addOnCanceledListener(TaskExecutors.zzagd, paramzzb);
    AppMethodBeat.o(13374);
  }
  
  private static <TResult> TResult zzb(Task<TResult> paramTask)
  {
    AppMethodBeat.i(13373);
    if (paramTask.isSuccessful())
    {
      paramTask = paramTask.getResult();
      AppMethodBeat.o(13373);
      return paramTask;
    }
    if (paramTask.isCanceled())
    {
      paramTask = new CancellationException("Task is already canceled");
      AppMethodBeat.o(13373);
      throw paramTask;
    }
    paramTask = new ExecutionException(paramTask.getException());
    AppMethodBeat.o(13373);
    throw paramTask;
  }
  
  static final class zza
    implements Tasks.zzb
  {
    private final CountDownLatch zzfd;
    
    private zza()
    {
      AppMethodBeat.i(13349);
      this.zzfd = new CountDownLatch(1);
      AppMethodBeat.o(13349);
    }
    
    public final void await()
    {
      AppMethodBeat.i(13353);
      this.zzfd.await();
      AppMethodBeat.o(13353);
    }
    
    public final boolean await(long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(13354);
      boolean bool = this.zzfd.await(paramLong, paramTimeUnit);
      AppMethodBeat.o(13354);
      return bool;
    }
    
    public final void onCanceled()
    {
      AppMethodBeat.i(13352);
      this.zzfd.countDown();
      AppMethodBeat.o(13352);
    }
    
    public final void onFailure(Exception paramException)
    {
      AppMethodBeat.i(13351);
      this.zzfd.countDown();
      AppMethodBeat.o(13351);
    }
    
    public final void onSuccess(Object paramObject)
    {
      AppMethodBeat.i(13350);
      this.zzfd.countDown();
      AppMethodBeat.o(13350);
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
    private Exception zzagh;
    private final int zzagl;
    private int zzagm;
    private int zzagn;
    private int zzago;
    private boolean zzagp;
    
    public zzc(int paramInt, zzu<Void> paramzzu)
    {
      AppMethodBeat.i(13355);
      this.mLock = new Object();
      this.zzagl = paramInt;
      this.zzafh = paramzzu;
      AppMethodBeat.o(13355);
    }
    
    private final void zzdu()
    {
      AppMethodBeat.i(13359);
      if (this.zzagm + this.zzagn + this.zzago == this.zzagl)
      {
        if (this.zzagh != null)
        {
          zzu localzzu = this.zzafh;
          int i = this.zzagn;
          int j = this.zzagl;
          localzzu.setException(new ExecutionException(54 + i + " out of " + j + " underlying tasks failed", this.zzagh));
          AppMethodBeat.o(13359);
          return;
        }
        if (this.zzagp)
        {
          this.zzafh.zzdp();
          AppMethodBeat.o(13359);
          return;
        }
        this.zzafh.setResult(null);
      }
      AppMethodBeat.o(13359);
    }
    
    public final void onCanceled()
    {
      AppMethodBeat.i(13358);
      synchronized (this.mLock)
      {
        this.zzago += 1;
        this.zzagp = true;
        zzdu();
        AppMethodBeat.o(13358);
        return;
      }
    }
    
    public final void onFailure(Exception paramException)
    {
      AppMethodBeat.i(13356);
      synchronized (this.mLock)
      {
        this.zzagn += 1;
        this.zzagh = paramException;
        zzdu();
        AppMethodBeat.o(13356);
        return;
      }
    }
    
    public final void onSuccess(Object arg1)
    {
      AppMethodBeat.i(13357);
      synchronized (this.mLock)
      {
        this.zzagm += 1;
        zzdu();
        AppMethodBeat.o(13357);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.tasks.Tasks
 * JD-Core Version:    0.7.0.1
 */
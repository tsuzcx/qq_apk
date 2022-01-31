package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.zzac;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks
{
  public static <TResult> TResult await(Task<TResult> paramTask)
  {
    zzac.zzye();
    zzac.zzb(paramTask, "Task must not be null");
    if (paramTask.isComplete()) {
      return zzb(paramTask);
    }
    Tasks.zza localzza = new Tasks.zza(null);
    zza(paramTask, localzza);
    localzza.await();
    return zzb(paramTask);
  }
  
  public static <TResult> TResult await(Task<TResult> paramTask, long paramLong, TimeUnit paramTimeUnit)
  {
    zzac.zzye();
    zzac.zzb(paramTask, "Task must not be null");
    zzac.zzb(paramTimeUnit, "TimeUnit must not be null");
    if (paramTask.isComplete()) {
      return zzb(paramTask);
    }
    Tasks.zza localzza = new Tasks.zza(null);
    zza(paramTask, localzza);
    if (!localzza.await(paramLong, paramTimeUnit)) {
      throw new TimeoutException("Timed out waiting for Task");
    }
    return zzb(paramTask);
  }
  
  public static <TResult> Task<TResult> call(Callable<TResult> paramCallable)
  {
    return call(TaskExecutors.MAIN_THREAD, paramCallable);
  }
  
  public static <TResult> Task<TResult> call(Executor paramExecutor, Callable<TResult> paramCallable)
  {
    zzac.zzb(paramExecutor, "Executor must not be null");
    zzac.zzb(paramCallable, "Callback must not be null");
    zzh localzzh = new zzh();
    paramExecutor.execute(new Tasks.1(localzzh, paramCallable));
    return localzzh;
  }
  
  public static <TResult> Task<TResult> forException(Exception paramException)
  {
    zzh localzzh = new zzh();
    localzzh.setException(paramException);
    return localzzh;
  }
  
  public static <TResult> Task<TResult> forResult(TResult paramTResult)
  {
    zzh localzzh = new zzh();
    localzzh.setResult(paramTResult);
    return localzzh;
  }
  
  public static Task<Void> whenAll(Collection<? extends Task<?>> paramCollection)
  {
    if (paramCollection.isEmpty()) {
      return forResult(null);
    }
    Object localObject = paramCollection.iterator();
    while (((Iterator)localObject).hasNext()) {
      if ((Task)((Iterator)localObject).next() == null) {
        throw new NullPointerException("null tasks are not accepted");
      }
    }
    localObject = new zzh();
    Tasks.zzc localzzc = new Tasks.zzc(paramCollection.size(), (zzh)localObject);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      zza((Task)paramCollection.next(), localzzc);
    }
    return localObject;
  }
  
  public static Task<Void> whenAll(Task<?>... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return forResult(null);
    }
    return whenAll(Arrays.asList(paramVarArgs));
  }
  
  private static void zza(Task<?> paramTask, zzb paramzzb)
  {
    paramTask.addOnSuccessListener(TaskExecutors.zzbNH, paramzzb);
    paramTask.addOnFailureListener(TaskExecutors.zzbNH, paramzzb);
  }
  
  private static <TResult> TResult zzb(Task<TResult> paramTask)
  {
    if (paramTask.isSuccessful()) {
      return paramTask.getResult();
    }
    throw new ExecutionException(paramTask.getException());
  }
  
  static abstract interface zzb
    extends OnFailureListener, OnSuccessListener<Object>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.tasks.Tasks
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzu<TResult>
  extends Task<TResult>
{
  private final Object mLock;
  private final zzr<TResult> zzage;
  @GuardedBy("mLock")
  private boolean zzagf;
  @GuardedBy("mLock")
  private TResult zzagg;
  @GuardedBy("mLock")
  private Exception zzagh;
  private volatile boolean zzfi;
  
  zzu()
  {
    AppMethodBeat.i(13416);
    this.mLock = new Object();
    this.zzage = new zzr();
    AppMethodBeat.o(13416);
  }
  
  @GuardedBy("mLock")
  private final void zzdq()
  {
    AppMethodBeat.i(13442);
    Preconditions.checkState(this.zzagf, "Task is not yet complete");
    AppMethodBeat.o(13442);
  }
  
  @GuardedBy("mLock")
  private final void zzdr()
  {
    AppMethodBeat.i(13443);
    if (!this.zzagf) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "Task is already complete");
      AppMethodBeat.o(13443);
      return;
    }
  }
  
  @GuardedBy("mLock")
  private final void zzds()
  {
    AppMethodBeat.i(13444);
    if (this.zzfi)
    {
      CancellationException localCancellationException = new CancellationException("Task is already canceled.");
      AppMethodBeat.o(13444);
      throw localCancellationException;
    }
    AppMethodBeat.o(13444);
  }
  
  private final void zzdt()
  {
    AppMethodBeat.i(13445);
    synchronized (this.mLock)
    {
      if (!this.zzagf)
      {
        AppMethodBeat.o(13445);
        return;
      }
      this.zzage.zza(this);
      AppMethodBeat.o(13445);
      return;
    }
  }
  
  public final Task<TResult> addOnCanceledListener(Activity paramActivity, OnCanceledListener paramOnCanceledListener)
  {
    AppMethodBeat.i(13433);
    paramOnCanceledListener = new zzg(TaskExecutors.MAIN_THREAD, paramOnCanceledListener);
    this.zzage.zza(paramOnCanceledListener);
    zzu.zza.zze(paramActivity).zzb(paramOnCanceledListener);
    zzdt();
    AppMethodBeat.o(13433);
    return this;
  }
  
  public final Task<TResult> addOnCanceledListener(OnCanceledListener paramOnCanceledListener)
  {
    AppMethodBeat.i(13431);
    paramOnCanceledListener = addOnCanceledListener(TaskExecutors.MAIN_THREAD, paramOnCanceledListener);
    AppMethodBeat.o(13431);
    return paramOnCanceledListener;
  }
  
  public final Task<TResult> addOnCanceledListener(Executor paramExecutor, OnCanceledListener paramOnCanceledListener)
  {
    AppMethodBeat.i(13432);
    this.zzage.zza(new zzg(paramExecutor, paramOnCanceledListener));
    zzdt();
    AppMethodBeat.o(13432);
    return this;
  }
  
  public final Task<TResult> addOnCompleteListener(Activity paramActivity, OnCompleteListener<TResult> paramOnCompleteListener)
  {
    AppMethodBeat.i(13427);
    paramOnCompleteListener = new zzi(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
    this.zzage.zza(paramOnCompleteListener);
    zzu.zza.zze(paramActivity).zzb(paramOnCompleteListener);
    zzdt();
    AppMethodBeat.o(13427);
    return this;
  }
  
  public final Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> paramOnCompleteListener)
  {
    AppMethodBeat.i(13425);
    paramOnCompleteListener = addOnCompleteListener(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
    AppMethodBeat.o(13425);
    return paramOnCompleteListener;
  }
  
  public final Task<TResult> addOnCompleteListener(Executor paramExecutor, OnCompleteListener<TResult> paramOnCompleteListener)
  {
    AppMethodBeat.i(13426);
    this.zzage.zza(new zzi(paramExecutor, paramOnCompleteListener));
    zzdt();
    AppMethodBeat.o(13426);
    return this;
  }
  
  public final Task<TResult> addOnFailureListener(Activity paramActivity, OnFailureListener paramOnFailureListener)
  {
    AppMethodBeat.i(13424);
    paramOnFailureListener = new zzk(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
    this.zzage.zza(paramOnFailureListener);
    zzu.zza.zze(paramActivity).zzb(paramOnFailureListener);
    zzdt();
    AppMethodBeat.o(13424);
    return this;
  }
  
  public final Task<TResult> addOnFailureListener(OnFailureListener paramOnFailureListener)
  {
    AppMethodBeat.i(13422);
    paramOnFailureListener = addOnFailureListener(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
    AppMethodBeat.o(13422);
    return paramOnFailureListener;
  }
  
  public final Task<TResult> addOnFailureListener(Executor paramExecutor, OnFailureListener paramOnFailureListener)
  {
    AppMethodBeat.i(13423);
    this.zzage.zza(new zzk(paramExecutor, paramOnFailureListener));
    zzdt();
    AppMethodBeat.o(13423);
    return this;
  }
  
  public final Task<TResult> addOnSuccessListener(Activity paramActivity, OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    AppMethodBeat.i(13421);
    paramOnSuccessListener = new zzm(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
    this.zzage.zza(paramOnSuccessListener);
    zzu.zza.zze(paramActivity).zzb(paramOnSuccessListener);
    zzdt();
    AppMethodBeat.o(13421);
    return this;
  }
  
  public final Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    AppMethodBeat.i(13419);
    paramOnSuccessListener = addOnSuccessListener(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
    AppMethodBeat.o(13419);
    return paramOnSuccessListener;
  }
  
  public final Task<TResult> addOnSuccessListener(Executor paramExecutor, OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    AppMethodBeat.i(13420);
    this.zzage.zza(new zzm(paramExecutor, paramOnSuccessListener));
    zzdt();
    AppMethodBeat.o(13420);
    return this;
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> paramContinuation)
  {
    AppMethodBeat.i(13428);
    paramContinuation = continueWith(TaskExecutors.MAIN_THREAD, paramContinuation);
    AppMethodBeat.o(13428);
    return paramContinuation;
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWith(Executor paramExecutor, Continuation<TResult, TContinuationResult> paramContinuation)
  {
    AppMethodBeat.i(13429);
    zzu localzzu = new zzu();
    this.zzage.zza(new zzc(paramExecutor, paramContinuation, localzzu));
    zzdt();
    AppMethodBeat.o(13429);
    return localzzu;
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> paramContinuation)
  {
    AppMethodBeat.i(13430);
    paramContinuation = continueWithTask(TaskExecutors.MAIN_THREAD, paramContinuation);
    AppMethodBeat.o(13430);
    return paramContinuation;
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor paramExecutor, Continuation<TResult, Task<TContinuationResult>> paramContinuation)
  {
    AppMethodBeat.i(13434);
    zzu localzzu = new zzu();
    this.zzage.zza(new zze(paramExecutor, paramContinuation, localzzu));
    zzdt();
    AppMethodBeat.o(13434);
    return localzzu;
  }
  
  public final Exception getException()
  {
    synchronized (this.mLock)
    {
      Exception localException = this.zzagh;
      return localException;
    }
  }
  
  public final TResult getResult()
  {
    AppMethodBeat.i(13417);
    synchronized (this.mLock)
    {
      zzdq();
      zzds();
      if (this.zzagh != null)
      {
        RuntimeExecutionException localRuntimeExecutionException = new RuntimeExecutionException(this.zzagh);
        AppMethodBeat.o(13417);
        throw localRuntimeExecutionException;
      }
    }
    Object localObject3 = this.zzagg;
    AppMethodBeat.o(13417);
    return localObject3;
  }
  
  public final <X extends Throwable> TResult getResult(Class<X> paramClass)
  {
    AppMethodBeat.i(13418);
    synchronized (this.mLock)
    {
      zzdq();
      zzds();
      if (paramClass.isInstance(this.zzagh))
      {
        paramClass = (Throwable)paramClass.cast(this.zzagh);
        AppMethodBeat.o(13418);
        throw paramClass;
      }
    }
    if (this.zzagh != null)
    {
      paramClass = new RuntimeExecutionException(this.zzagh);
      AppMethodBeat.o(13418);
      throw paramClass;
    }
    paramClass = this.zzagg;
    AppMethodBeat.o(13418);
    return paramClass;
  }
  
  public final boolean isCanceled()
  {
    return this.zzfi;
  }
  
  public final boolean isComplete()
  {
    synchronized (this.mLock)
    {
      boolean bool = this.zzagf;
      return bool;
    }
  }
  
  public final boolean isSuccessful()
  {
    synchronized (this.mLock)
    {
      if ((this.zzagf) && (!this.zzfi) && (this.zzagh == null))
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation)
  {
    AppMethodBeat.i(13436);
    paramSuccessContinuation = onSuccessTask(TaskExecutors.MAIN_THREAD, paramSuccessContinuation);
    AppMethodBeat.o(13436);
    return paramSuccessContinuation;
  }
  
  public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor paramExecutor, SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation)
  {
    AppMethodBeat.i(13435);
    zzu localzzu = new zzu();
    this.zzage.zza(new zzo(paramExecutor, paramSuccessContinuation, localzzu));
    zzdt();
    AppMethodBeat.o(13435);
    return localzzu;
  }
  
  public final void setException(Exception paramException)
  {
    AppMethodBeat.i(13439);
    Preconditions.checkNotNull(paramException, "Exception must not be null");
    synchronized (this.mLock)
    {
      zzdr();
      this.zzagf = true;
      this.zzagh = paramException;
      this.zzage.zza(this);
      AppMethodBeat.o(13439);
      return;
    }
  }
  
  public final void setResult(TResult paramTResult)
  {
    AppMethodBeat.i(13437);
    synchronized (this.mLock)
    {
      zzdr();
      this.zzagf = true;
      this.zzagg = paramTResult;
      this.zzage.zza(this);
      AppMethodBeat.o(13437);
      return;
    }
  }
  
  public final boolean trySetException(Exception paramException)
  {
    AppMethodBeat.i(13440);
    Preconditions.checkNotNull(paramException, "Exception must not be null");
    synchronized (this.mLock)
    {
      if (this.zzagf)
      {
        AppMethodBeat.o(13440);
        return false;
      }
      this.zzagf = true;
      this.zzagh = paramException;
      this.zzage.zza(this);
      AppMethodBeat.o(13440);
      return true;
    }
  }
  
  public final boolean trySetResult(TResult paramTResult)
  {
    AppMethodBeat.i(13438);
    synchronized (this.mLock)
    {
      if (this.zzagf)
      {
        AppMethodBeat.o(13438);
        return false;
      }
      this.zzagf = true;
      this.zzagg = paramTResult;
      this.zzage.zza(this);
      AppMethodBeat.o(13438);
      return true;
    }
  }
  
  public final boolean zzdp()
  {
    AppMethodBeat.i(13441);
    synchronized (this.mLock)
    {
      if (this.zzagf)
      {
        AppMethodBeat.o(13441);
        return false;
      }
      this.zzagf = true;
      this.zzfi = true;
      this.zzage.zza(this);
      AppMethodBeat.o(13441);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.tasks.zzu
 * JD-Core Version:    0.7.0.1
 */
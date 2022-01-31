package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    AppMethodBeat.i(57417);
    this.mLock = new Object();
    this.zzage = new zzr();
    AppMethodBeat.o(57417);
  }
  
  @GuardedBy("mLock")
  private final void zzdq()
  {
    AppMethodBeat.i(57443);
    Preconditions.checkState(this.zzagf, "Task is not yet complete");
    AppMethodBeat.o(57443);
  }
  
  @GuardedBy("mLock")
  private final void zzdr()
  {
    AppMethodBeat.i(57444);
    if (!this.zzagf) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "Task is already complete");
      AppMethodBeat.o(57444);
      return;
    }
  }
  
  @GuardedBy("mLock")
  private final void zzds()
  {
    AppMethodBeat.i(57445);
    if (this.zzfi)
    {
      CancellationException localCancellationException = new CancellationException("Task is already canceled.");
      AppMethodBeat.o(57445);
      throw localCancellationException;
    }
    AppMethodBeat.o(57445);
  }
  
  private final void zzdt()
  {
    AppMethodBeat.i(57446);
    synchronized (this.mLock)
    {
      if (!this.zzagf)
      {
        AppMethodBeat.o(57446);
        return;
      }
      this.zzage.zza(this);
      AppMethodBeat.o(57446);
      return;
    }
  }
  
  public final Task<TResult> addOnCanceledListener(Activity paramActivity, OnCanceledListener paramOnCanceledListener)
  {
    AppMethodBeat.i(57434);
    paramOnCanceledListener = new zzg(TaskExecutors.MAIN_THREAD, paramOnCanceledListener);
    this.zzage.zza(paramOnCanceledListener);
    zza.zze(paramActivity).zzb(paramOnCanceledListener);
    zzdt();
    AppMethodBeat.o(57434);
    return this;
  }
  
  public final Task<TResult> addOnCanceledListener(OnCanceledListener paramOnCanceledListener)
  {
    AppMethodBeat.i(57432);
    paramOnCanceledListener = addOnCanceledListener(TaskExecutors.MAIN_THREAD, paramOnCanceledListener);
    AppMethodBeat.o(57432);
    return paramOnCanceledListener;
  }
  
  public final Task<TResult> addOnCanceledListener(Executor paramExecutor, OnCanceledListener paramOnCanceledListener)
  {
    AppMethodBeat.i(57433);
    this.zzage.zza(new zzg(paramExecutor, paramOnCanceledListener));
    zzdt();
    AppMethodBeat.o(57433);
    return this;
  }
  
  public final Task<TResult> addOnCompleteListener(Activity paramActivity, OnCompleteListener<TResult> paramOnCompleteListener)
  {
    AppMethodBeat.i(57428);
    paramOnCompleteListener = new zzi(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
    this.zzage.zza(paramOnCompleteListener);
    zza.zze(paramActivity).zzb(paramOnCompleteListener);
    zzdt();
    AppMethodBeat.o(57428);
    return this;
  }
  
  public final Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> paramOnCompleteListener)
  {
    AppMethodBeat.i(57426);
    paramOnCompleteListener = addOnCompleteListener(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
    AppMethodBeat.o(57426);
    return paramOnCompleteListener;
  }
  
  public final Task<TResult> addOnCompleteListener(Executor paramExecutor, OnCompleteListener<TResult> paramOnCompleteListener)
  {
    AppMethodBeat.i(57427);
    this.zzage.zza(new zzi(paramExecutor, paramOnCompleteListener));
    zzdt();
    AppMethodBeat.o(57427);
    return this;
  }
  
  public final Task<TResult> addOnFailureListener(Activity paramActivity, OnFailureListener paramOnFailureListener)
  {
    AppMethodBeat.i(57425);
    paramOnFailureListener = new zzk(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
    this.zzage.zza(paramOnFailureListener);
    zza.zze(paramActivity).zzb(paramOnFailureListener);
    zzdt();
    AppMethodBeat.o(57425);
    return this;
  }
  
  public final Task<TResult> addOnFailureListener(OnFailureListener paramOnFailureListener)
  {
    AppMethodBeat.i(57423);
    paramOnFailureListener = addOnFailureListener(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
    AppMethodBeat.o(57423);
    return paramOnFailureListener;
  }
  
  public final Task<TResult> addOnFailureListener(Executor paramExecutor, OnFailureListener paramOnFailureListener)
  {
    AppMethodBeat.i(57424);
    this.zzage.zza(new zzk(paramExecutor, paramOnFailureListener));
    zzdt();
    AppMethodBeat.o(57424);
    return this;
  }
  
  public final Task<TResult> addOnSuccessListener(Activity paramActivity, OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    AppMethodBeat.i(57422);
    paramOnSuccessListener = new zzm(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
    this.zzage.zza(paramOnSuccessListener);
    zza.zze(paramActivity).zzb(paramOnSuccessListener);
    zzdt();
    AppMethodBeat.o(57422);
    return this;
  }
  
  public final Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    AppMethodBeat.i(57420);
    paramOnSuccessListener = addOnSuccessListener(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
    AppMethodBeat.o(57420);
    return paramOnSuccessListener;
  }
  
  public final Task<TResult> addOnSuccessListener(Executor paramExecutor, OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    AppMethodBeat.i(57421);
    this.zzage.zza(new zzm(paramExecutor, paramOnSuccessListener));
    zzdt();
    AppMethodBeat.o(57421);
    return this;
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> paramContinuation)
  {
    AppMethodBeat.i(57429);
    paramContinuation = continueWith(TaskExecutors.MAIN_THREAD, paramContinuation);
    AppMethodBeat.o(57429);
    return paramContinuation;
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWith(Executor paramExecutor, Continuation<TResult, TContinuationResult> paramContinuation)
  {
    AppMethodBeat.i(57430);
    zzu localzzu = new zzu();
    this.zzage.zza(new zzc(paramExecutor, paramContinuation, localzzu));
    zzdt();
    AppMethodBeat.o(57430);
    return localzzu;
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> paramContinuation)
  {
    AppMethodBeat.i(57431);
    paramContinuation = continueWithTask(TaskExecutors.MAIN_THREAD, paramContinuation);
    AppMethodBeat.o(57431);
    return paramContinuation;
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor paramExecutor, Continuation<TResult, Task<TContinuationResult>> paramContinuation)
  {
    AppMethodBeat.i(57435);
    zzu localzzu = new zzu();
    this.zzage.zza(new zze(paramExecutor, paramContinuation, localzzu));
    zzdt();
    AppMethodBeat.o(57435);
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
    AppMethodBeat.i(57418);
    synchronized (this.mLock)
    {
      zzdq();
      zzds();
      if (this.zzagh != null)
      {
        RuntimeExecutionException localRuntimeExecutionException = new RuntimeExecutionException(this.zzagh);
        AppMethodBeat.o(57418);
        throw localRuntimeExecutionException;
      }
    }
    Object localObject3 = this.zzagg;
    AppMethodBeat.o(57418);
    return localObject3;
  }
  
  public final <X extends Throwable> TResult getResult(Class<X> paramClass)
  {
    AppMethodBeat.i(57419);
    synchronized (this.mLock)
    {
      zzdq();
      zzds();
      if (paramClass.isInstance(this.zzagh))
      {
        paramClass = (Throwable)paramClass.cast(this.zzagh);
        AppMethodBeat.o(57419);
        throw paramClass;
      }
    }
    if (this.zzagh != null)
    {
      paramClass = new RuntimeExecutionException(this.zzagh);
      AppMethodBeat.o(57419);
      throw paramClass;
    }
    paramClass = this.zzagg;
    AppMethodBeat.o(57419);
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
    for (;;)
    {
      synchronized (this.mLock)
      {
        if ((this.zzagf) && (!this.zzfi) && (this.zzagh == null))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation)
  {
    AppMethodBeat.i(57437);
    paramSuccessContinuation = onSuccessTask(TaskExecutors.MAIN_THREAD, paramSuccessContinuation);
    AppMethodBeat.o(57437);
    return paramSuccessContinuation;
  }
  
  public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor paramExecutor, SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation)
  {
    AppMethodBeat.i(57436);
    zzu localzzu = new zzu();
    this.zzage.zza(new zzo(paramExecutor, paramSuccessContinuation, localzzu));
    zzdt();
    AppMethodBeat.o(57436);
    return localzzu;
  }
  
  public final void setException(Exception paramException)
  {
    AppMethodBeat.i(57440);
    Preconditions.checkNotNull(paramException, "Exception must not be null");
    synchronized (this.mLock)
    {
      zzdr();
      this.zzagf = true;
      this.zzagh = paramException;
      this.zzage.zza(this);
      AppMethodBeat.o(57440);
      return;
    }
  }
  
  public final void setResult(TResult paramTResult)
  {
    AppMethodBeat.i(57438);
    synchronized (this.mLock)
    {
      zzdr();
      this.zzagf = true;
      this.zzagg = paramTResult;
      this.zzage.zza(this);
      AppMethodBeat.o(57438);
      return;
    }
  }
  
  public final boolean trySetException(Exception paramException)
  {
    AppMethodBeat.i(57441);
    Preconditions.checkNotNull(paramException, "Exception must not be null");
    synchronized (this.mLock)
    {
      if (this.zzagf)
      {
        AppMethodBeat.o(57441);
        return false;
      }
      this.zzagf = true;
      this.zzagh = paramException;
      this.zzage.zza(this);
      AppMethodBeat.o(57441);
      return true;
    }
  }
  
  public final boolean trySetResult(TResult paramTResult)
  {
    AppMethodBeat.i(57439);
    synchronized (this.mLock)
    {
      if (this.zzagf)
      {
        AppMethodBeat.o(57439);
        return false;
      }
      this.zzagf = true;
      this.zzagg = paramTResult;
      this.zzage.zza(this);
      AppMethodBeat.o(57439);
      return true;
    }
  }
  
  public final boolean zzdp()
  {
    AppMethodBeat.i(57442);
    synchronized (this.mLock)
    {
      if (this.zzagf)
      {
        AppMethodBeat.o(57442);
        return false;
      }
      this.zzagf = true;
      this.zzfi = true;
      this.zzage.zza(this);
      AppMethodBeat.o(57442);
      return true;
    }
  }
  
  static class zza
    extends LifecycleCallback
  {
    private final List<WeakReference<zzq<?>>> zzagi;
    
    private zza(LifecycleFragment paramLifecycleFragment)
    {
      super();
      AppMethodBeat.i(57414);
      this.zzagi = new ArrayList();
      this.mLifecycleFragment.addCallback("TaskOnStopCallback", this);
      AppMethodBeat.o(57414);
    }
    
    public static zza zze(Activity paramActivity)
    {
      AppMethodBeat.i(57413);
      LifecycleFragment localLifecycleFragment = getFragment(paramActivity);
      zza localzza = (zza)localLifecycleFragment.getCallbackOrNull("TaskOnStopCallback", zza.class);
      paramActivity = localzza;
      if (localzza == null) {
        paramActivity = new zza(localLifecycleFragment);
      }
      AppMethodBeat.o(57413);
      return paramActivity;
    }
    
    public void onStop()
    {
      AppMethodBeat.i(57416);
      synchronized (this.zzagi)
      {
        Iterator localIterator = this.zzagi.iterator();
        while (localIterator.hasNext())
        {
          zzq localzzq = (zzq)((WeakReference)localIterator.next()).get();
          if (localzzq != null) {
            localzzq.cancel();
          }
        }
      }
      this.zzagi.clear();
      AppMethodBeat.o(57416);
    }
    
    public final <T> void zzb(zzq<T> paramzzq)
    {
      AppMethodBeat.i(57415);
      synchronized (this.zzagi)
      {
        this.zzagi.add(new WeakReference(paramzzq));
        AppMethodBeat.o(57415);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.zzu
 * JD-Core Version:    0.7.0.1
 */
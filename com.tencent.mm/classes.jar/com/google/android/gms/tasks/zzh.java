package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzabe;
import com.google.android.gms.internal.zzabf;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

final class zzh<TResult>
  extends Task<TResult>
{
  private final zzg<TResult> zzbNI = new zzg();
  private boolean zzbNJ;
  private TResult zzbNK;
  private Exception zzbNL;
  private final Object zzrJ = new Object();
  
  private void zzTF()
  {
    zzac.zza(this.zzbNJ, "Task is not yet complete");
  }
  
  private void zzTG()
  {
    if (!this.zzbNJ) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zza(bool, "Task is already complete");
      return;
    }
  }
  
  private void zzTH()
  {
    synchronized (this.zzrJ)
    {
      if (!this.zzbNJ) {
        return;
      }
      this.zzbNI.zza(this);
      return;
    }
  }
  
  public final Task<TResult> addOnCompleteListener(Activity paramActivity, OnCompleteListener<TResult> paramOnCompleteListener)
  {
    paramOnCompleteListener = new zzc(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
    this.zzbNI.zza(paramOnCompleteListener);
    zza.zzw(paramActivity).zzb(paramOnCompleteListener);
    zzTH();
    return this;
  }
  
  public final Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> paramOnCompleteListener)
  {
    return addOnCompleteListener(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
  }
  
  public final Task<TResult> addOnCompleteListener(Executor paramExecutor, OnCompleteListener<TResult> paramOnCompleteListener)
  {
    this.zzbNI.zza(new zzc(paramExecutor, paramOnCompleteListener));
    zzTH();
    return this;
  }
  
  public final Task<TResult> addOnFailureListener(Activity paramActivity, OnFailureListener paramOnFailureListener)
  {
    paramOnFailureListener = new zzd(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
    this.zzbNI.zza(paramOnFailureListener);
    zza.zzw(paramActivity).zzb(paramOnFailureListener);
    zzTH();
    return this;
  }
  
  public final Task<TResult> addOnFailureListener(OnFailureListener paramOnFailureListener)
  {
    return addOnFailureListener(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
  }
  
  public final Task<TResult> addOnFailureListener(Executor paramExecutor, OnFailureListener paramOnFailureListener)
  {
    this.zzbNI.zza(new zzd(paramExecutor, paramOnFailureListener));
    zzTH();
    return this;
  }
  
  public final Task<TResult> addOnSuccessListener(Activity paramActivity, OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    paramOnSuccessListener = new zze(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
    this.zzbNI.zza(paramOnSuccessListener);
    zza.zzw(paramActivity).zzb(paramOnSuccessListener);
    zzTH();
    return this;
  }
  
  public final Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    return addOnSuccessListener(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
  }
  
  public final Task<TResult> addOnSuccessListener(Executor paramExecutor, OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    this.zzbNI.zza(new zze(paramExecutor, paramOnSuccessListener));
    zzTH();
    return this;
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> paramContinuation)
  {
    return continueWith(TaskExecutors.MAIN_THREAD, paramContinuation);
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWith(Executor paramExecutor, Continuation<TResult, TContinuationResult> paramContinuation)
  {
    zzh localzzh = new zzh();
    this.zzbNI.zza(new zza(paramExecutor, paramContinuation, localzzh));
    zzTH();
    return localzzh;
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> paramContinuation)
  {
    return continueWithTask(TaskExecutors.MAIN_THREAD, paramContinuation);
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor paramExecutor, Continuation<TResult, Task<TContinuationResult>> paramContinuation)
  {
    zzh localzzh = new zzh();
    this.zzbNI.zza(new zzb(paramExecutor, paramContinuation, localzzh));
    zzTH();
    return localzzh;
  }
  
  public final Exception getException()
  {
    synchronized (this.zzrJ)
    {
      Exception localException = this.zzbNL;
      return localException;
    }
  }
  
  public final TResult getResult()
  {
    synchronized (this.zzrJ)
    {
      zzTF();
      if (this.zzbNL != null) {
        throw new RuntimeExecutionException(this.zzbNL);
      }
    }
    Object localObject3 = this.zzbNK;
    return localObject3;
  }
  
  public final <X extends Throwable> TResult getResult(Class<X> paramClass)
  {
    synchronized (this.zzrJ)
    {
      zzTF();
      if (paramClass.isInstance(this.zzbNL)) {
        throw ((Throwable)paramClass.cast(this.zzbNL));
      }
    }
    if (this.zzbNL != null) {
      throw new RuntimeExecutionException(this.zzbNL);
    }
    paramClass = this.zzbNK;
    return paramClass;
  }
  
  public final boolean isComplete()
  {
    synchronized (this.zzrJ)
    {
      boolean bool = this.zzbNJ;
      return bool;
    }
  }
  
  public final boolean isSuccessful()
  {
    for (;;)
    {
      synchronized (this.zzrJ)
      {
        if ((this.zzbNJ) && (this.zzbNL == null))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public final void setException(Exception paramException)
  {
    zzac.zzb(paramException, "Exception must not be null");
    synchronized (this.zzrJ)
    {
      zzTG();
      this.zzbNJ = true;
      this.zzbNL = paramException;
      this.zzbNI.zza(this);
      return;
    }
  }
  
  public final void setResult(TResult paramTResult)
  {
    synchronized (this.zzrJ)
    {
      zzTG();
      this.zzbNJ = true;
      this.zzbNK = paramTResult;
      this.zzbNI.zza(this);
      return;
    }
  }
  
  public final boolean trySetException(Exception paramException)
  {
    zzac.zzb(paramException, "Exception must not be null");
    synchronized (this.zzrJ)
    {
      if (this.zzbNJ) {
        return false;
      }
      this.zzbNJ = true;
      this.zzbNL = paramException;
      this.zzbNI.zza(this);
      return true;
    }
  }
  
  public final boolean trySetResult(TResult paramTResult)
  {
    synchronized (this.zzrJ)
    {
      if (this.zzbNJ) {
        return false;
      }
      this.zzbNJ = true;
      this.zzbNK = paramTResult;
      this.zzbNI.zza(this);
      return true;
    }
  }
  
  private static class zza
    extends zzabe
  {
    private final List<WeakReference<zzf<?>>> mListeners = new ArrayList();
    
    private zza(zzabf paramzzabf)
    {
      super();
      this.zzaCR.zza("TaskOnStopCallback", this);
    }
    
    public static zza zzw(Activity paramActivity)
    {
      zzabf localzzabf = zzs(paramActivity);
      zza localzza = (zza)localzzabf.zza("TaskOnStopCallback", zza.class);
      paramActivity = localzza;
      if (localzza == null) {
        paramActivity = new zza(localzzabf);
      }
      return paramActivity;
    }
    
    public void onStop()
    {
      synchronized (this.mListeners)
      {
        Iterator localIterator = this.mListeners.iterator();
        while (localIterator.hasNext())
        {
          zzf localzzf = (zzf)((WeakReference)localIterator.next()).get();
          if (localzzf != null) {
            localzzf.cancel();
          }
        }
      }
      this.mListeners.clear();
    }
    
    public <T> void zzb(zzf<T> paramzzf)
    {
      synchronized (this.mListeners)
      {
        this.mListeners.add(new WeakReference(paramzzf));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.tasks.zzh
 * JD-Core Version:    0.7.0.1
 */
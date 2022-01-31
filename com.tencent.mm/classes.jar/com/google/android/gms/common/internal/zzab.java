package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.zze;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class zzab
{
  private static final zzab.zzb zzaGw = new zzab.1();
  
  public static <R extends Result, T extends zze<R>> Task<T> zza(PendingResult<R> paramPendingResult, T paramT)
  {
    return zza(paramPendingResult, new zzab.3(paramT));
  }
  
  public static <R extends Result, T> Task<T> zza(PendingResult<R> paramPendingResult, zzab.zza<R, T> paramzza)
  {
    return zza(paramPendingResult, paramzza, zzaGw);
  }
  
  public static <R extends Result, T> Task<T> zza(PendingResult<R> paramPendingResult, zzab.zza<R, T> paramzza, zzab.zzb paramzzb)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramPendingResult.zza(new zzab.2(paramPendingResult, localTaskCompletionSource, paramzza, paramzzb));
    return localTaskCompletionSource.getTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzab
 * JD-Core Version:    0.7.0.1
 */
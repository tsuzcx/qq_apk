package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.tasks.TaskCompletionSource;

public class zzabw
{
  public static void zza(Status paramStatus, TaskCompletionSource<Void> paramTaskCompletionSource)
  {
    zza(paramStatus, null, paramTaskCompletionSource);
  }
  
  public static <TResult> void zza(Status paramStatus, TResult paramTResult, TaskCompletionSource<TResult> paramTaskCompletionSource)
  {
    if (paramStatus.isSuccess())
    {
      paramTaskCompletionSource.setResult(paramTResult);
      return;
    }
    paramTaskCompletionSource.setException(new zza(paramStatus));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzabw
 * JD-Core Version:    0.7.0.1
 */
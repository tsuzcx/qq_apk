package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public class TaskUtil
{
  @KeepForSdk
  public static void setResultOrApiException(Status paramStatus, TaskCompletionSource<Void> paramTaskCompletionSource)
  {
    AppMethodBeat.i(60664);
    setResultOrApiException(paramStatus, null, paramTaskCompletionSource);
    AppMethodBeat.o(60664);
  }
  
  @KeepForSdk
  public static <TResult> void setResultOrApiException(Status paramStatus, TResult paramTResult, TaskCompletionSource<TResult> paramTaskCompletionSource)
  {
    AppMethodBeat.i(60665);
    if (paramStatus.isSuccess())
    {
      paramTaskCompletionSource.setResult(paramTResult);
      AppMethodBeat.o(60665);
      return;
    }
    paramTaskCompletionSource.setException(new ApiException(paramStatus));
    AppMethodBeat.o(60665);
  }
  
  @Deprecated
  @KeepForSdk
  public static Task<Void> toVoidTaskThatFailsOnFalse(Task<Boolean> paramTask)
  {
    AppMethodBeat.i(60666);
    paramTask = paramTask.continueWith(new zzcg());
    AppMethodBeat.o(60666);
    return paramTask;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.TaskUtil
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TaskUtil
{
  public static void setResultOrApiException(Status paramStatus, TaskCompletionSource<Void> paramTaskCompletionSource)
  {
    AppMethodBeat.i(11156);
    setResultOrApiException(paramStatus, null, paramTaskCompletionSource);
    AppMethodBeat.o(11156);
  }
  
  public static <TResult> void setResultOrApiException(Status paramStatus, TResult paramTResult, TaskCompletionSource<TResult> paramTaskCompletionSource)
  {
    AppMethodBeat.i(11157);
    if (paramStatus.isSuccess())
    {
      paramTaskCompletionSource.setResult(paramTResult);
      AppMethodBeat.o(11157);
      return;
    }
    paramTaskCompletionSource.setException(new ApiException(paramStatus));
    AppMethodBeat.o(11157);
  }
  
  @Deprecated
  public static Task<Void> toVoidTaskThatFailsOnFalse(Task<Boolean> paramTask)
  {
    AppMethodBeat.i(11158);
    paramTask = paramTask.continueWith(new zzcg());
    AppMethodBeat.o(11158);
    return paramTask;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.TaskUtil
 * JD-Core Version:    0.7.0.1
 */
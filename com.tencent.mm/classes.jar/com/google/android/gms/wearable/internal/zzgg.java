package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgg
  implements BaseImplementation.ResultHolder<Status>
{
  private final TaskCompletionSource<Boolean> zzes;
  
  zzgg(TaskCompletionSource<Boolean> paramTaskCompletionSource)
  {
    this.zzes = paramTaskCompletionSource;
  }
  
  public final void setFailedResult(Status paramStatus)
  {
    AppMethodBeat.i(71365);
    this.zzes.setException(new ApiException(paramStatus));
    AppMethodBeat.o(71365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgg
 * JD-Core Version:    0.7.0.1
 */
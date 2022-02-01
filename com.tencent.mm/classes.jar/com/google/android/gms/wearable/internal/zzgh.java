package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgh
  implements BaseImplementation.ResultHolder<Status>
{
  private final TaskCompletionSource<Void> zzes;
  
  zzgh(TaskCompletionSource<Void> paramTaskCompletionSource)
  {
    this.zzes = paramTaskCompletionSource;
  }
  
  public final void setFailedResult(Status paramStatus)
  {
    AppMethodBeat.i(101350);
    this.zzes.setException(new ApiException(paramStatus));
    AppMethodBeat.o(101350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgh
 * JD-Core Version:    0.7.0.1
 */
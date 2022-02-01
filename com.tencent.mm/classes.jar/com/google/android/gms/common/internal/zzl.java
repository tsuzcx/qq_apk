package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

final class zzl
  implements PendingResult.StatusListener
{
  zzl(PendingResult paramPendingResult, TaskCompletionSource paramTaskCompletionSource, PendingResultUtil.ResultConverter paramResultConverter, PendingResultUtil.StatusConverter paramStatusConverter) {}
  
  public final void onComplete(Status paramStatus)
  {
    AppMethodBeat.i(11900);
    if (paramStatus.isSuccess())
    {
      paramStatus = this.zzuo.await(0L, TimeUnit.MILLISECONDS);
      this.zzup.setResult(this.zzuq.convert(paramStatus));
      AppMethodBeat.o(11900);
      return;
    }
    this.zzup.setException(this.zzur.convert(paramStatus));
    AppMethodBeat.o(11900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzl
 * JD-Core Version:    0.7.0.1
 */
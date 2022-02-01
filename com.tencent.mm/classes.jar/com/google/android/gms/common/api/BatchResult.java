package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public final class BatchResult
  implements Result
{
  private final Status mStatus;
  private final PendingResult<?>[] zzcg;
  
  BatchResult(Status paramStatus, PendingResult<?>[] paramArrayOfPendingResult)
  {
    this.mStatus = paramStatus;
    this.zzcg = paramArrayOfPendingResult;
  }
  
  public final Status getStatus()
  {
    return this.mStatus;
  }
  
  public final <R extends Result> R take(BatchResultToken<R> paramBatchResultToken)
  {
    AppMethodBeat.i(10983);
    if (paramBatchResultToken.mId < this.zzcg.length) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "The result token does not belong to this batch");
      paramBatchResultToken = this.zzcg[paramBatchResultToken.mId].await(0L, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(10983);
      return paramBatchResultToken;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.api.BatchResult
 * JD-Core Version:    0.7.0.1
 */
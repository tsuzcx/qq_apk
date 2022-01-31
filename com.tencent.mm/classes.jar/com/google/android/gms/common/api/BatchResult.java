package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.TimeUnit;

public final class BatchResult
  implements Result
{
  private final Status zzair;
  private final PendingResult<?>[] zzayP;
  
  BatchResult(Status paramStatus, PendingResult<?>[] paramArrayOfPendingResult)
  {
    this.zzair = paramStatus;
    this.zzayP = paramArrayOfPendingResult;
  }
  
  public final Status getStatus()
  {
    return this.zzair;
  }
  
  public final <R extends Result> R take(BatchResultToken<R> paramBatchResultToken)
  {
    if (paramBatchResultToken.mId < this.zzayP.length) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "The result token does not belong to this batch");
      return this.zzayP[paramBatchResultToken.mId].await(0L, TimeUnit.MILLISECONDS);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.api.BatchResult
 * JD-Core Version:    0.7.0.1
 */
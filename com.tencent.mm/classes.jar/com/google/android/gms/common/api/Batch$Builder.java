package com.google.android.gms.common.api;

import java.util.ArrayList;
import java.util.List;

public final class Batch$Builder
{
  private GoogleApiClient zzanE;
  private List<PendingResult<?>> zzayR = new ArrayList();
  
  public Batch$Builder(GoogleApiClient paramGoogleApiClient)
  {
    this.zzanE = paramGoogleApiClient;
  }
  
  public final <R extends Result> BatchResultToken<R> add(PendingResult<R> paramPendingResult)
  {
    BatchResultToken localBatchResultToken = new BatchResultToken(this.zzayR.size());
    this.zzayR.add(paramPendingResult);
    return localBatchResultToken;
  }
  
  public final Batch build()
  {
    return new Batch(this.zzayR, this.zzanE, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.api.Batch.Builder
 * JD-Core Version:    0.7.0.1
 */
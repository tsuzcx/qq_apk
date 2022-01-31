package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;

final class PendingResults$zzb<R extends Result>
  extends BasePendingResult<R>
{
  private final R zzdm;
  
  public PendingResults$zzb(GoogleApiClient paramGoogleApiClient, R paramR)
  {
    super(paramGoogleApiClient);
    this.zzdm = paramR;
  }
  
  public final R createFailedResult(Status paramStatus)
  {
    return this.zzdm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.api.PendingResults.zzb
 * JD-Core Version:    0.7.0.1
 */
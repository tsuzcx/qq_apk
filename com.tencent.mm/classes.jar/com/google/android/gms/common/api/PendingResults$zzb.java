package com.google.android.gms.common.api;

import com.google.android.gms.internal.zzaaf;

final class PendingResults$zzb<R extends Result>
  extends zzaaf<R>
{
  private final R zzazt;
  
  public PendingResults$zzb(GoogleApiClient paramGoogleApiClient, R paramR)
  {
    super(paramGoogleApiClient);
    this.zzazt = paramR;
  }
  
  protected final R zzc(Status paramStatus)
  {
    return this.zzazt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.api.PendingResults.zzb
 * JD-Core Version:    0.7.0.1
 */
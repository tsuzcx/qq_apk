package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public final class zzach
  implements zzacg
{
  public final PendingResult<Status> zzg(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.zzb(new zzach.1(this, paramGoogleApiClient));
  }
  
  private static class zza
    extends zzace
  {
    private final zzaad.zzb<Status> zzaGN;
    
    public zza(zzaad.zzb<Status> paramzzb)
    {
      this.zzaGN = paramzzb;
    }
    
    public void zzdd(int paramInt)
    {
      this.zzaGN.setResult(new Status(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzach
 * JD-Core Version:    0.7.0.1
 */
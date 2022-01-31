package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzaaf;
import com.google.android.gms.internal.zzabk;
import com.google.android.gms.internal.zzabt;

public final class PendingResults
{
  public static PendingResult<Status> canceledPendingResult()
  {
    zzabt localzzabt = new zzabt(Looper.getMainLooper());
    localzzabt.cancel();
    return localzzabt;
  }
  
  public static <R extends Result> PendingResult<R> canceledPendingResult(R paramR)
  {
    zzac.zzb(paramR, "Result must not be null");
    if (paramR.getStatus().getStatusCode() == 16) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "Status code must be CommonStatusCodes.CANCELED");
      paramR = new zza(paramR);
      paramR.cancel();
      return paramR;
    }
  }
  
  public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R paramR)
  {
    zzac.zzb(paramR, "Result must not be null");
    PendingResults.zzc localzzc = new PendingResults.zzc(null);
    localzzc.zzb(paramR);
    return new zzabk(localzzc);
  }
  
  public static PendingResult<Status> immediatePendingResult(Status paramStatus)
  {
    zzac.zzb(paramStatus, "Result must not be null");
    zzabt localzzabt = new zzabt(Looper.getMainLooper());
    localzzabt.zzb(paramStatus);
    return localzzabt;
  }
  
  public static <R extends Result> PendingResult<R> zza(R paramR, GoogleApiClient paramGoogleApiClient)
  {
    zzac.zzb(paramR, "Result must not be null");
    if (!paramR.getStatus().isSuccess()) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "Status code must not be SUCCESS");
      paramGoogleApiClient = new PendingResults.zzb(paramGoogleApiClient, paramR);
      paramGoogleApiClient.zzb(paramR);
      return paramGoogleApiClient;
    }
  }
  
  public static PendingResult<Status> zza(Status paramStatus, GoogleApiClient paramGoogleApiClient)
  {
    zzac.zzb(paramStatus, "Result must not be null");
    paramGoogleApiClient = new zzabt(paramGoogleApiClient);
    paramGoogleApiClient.zzb(paramStatus);
    return paramGoogleApiClient;
  }
  
  public static <R extends Result> OptionalPendingResult<R> zzb(R paramR, GoogleApiClient paramGoogleApiClient)
  {
    zzac.zzb(paramR, "Result must not be null");
    paramGoogleApiClient = new PendingResults.zzc(paramGoogleApiClient);
    paramGoogleApiClient.zzb(paramR);
    return new zzabk(paramGoogleApiClient);
  }
  
  private static final class zza<R extends Result>
    extends zzaaf<R>
  {
    private final R zzazs;
    
    public zza(R paramR)
    {
      super();
      this.zzazs = paramR;
    }
    
    protected final R zzc(Status paramStatus)
    {
      if (paramStatus.getStatusCode() != this.zzazs.getStatus().getStatusCode()) {
        throw new UnsupportedOperationException("Creating failed results is not supported");
      }
      return this.zzazs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.api.PendingResults
 * JD-Core Version:    0.7.0.1
 */
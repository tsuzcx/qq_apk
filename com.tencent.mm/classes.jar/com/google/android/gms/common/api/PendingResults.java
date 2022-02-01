package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public final class PendingResults
{
  public static PendingResult<Status> canceledPendingResult()
  {
    AppMethodBeat.i(11053);
    StatusPendingResult localStatusPendingResult = new StatusPendingResult(Looper.getMainLooper());
    localStatusPendingResult.cancel();
    AppMethodBeat.o(11053);
    return localStatusPendingResult;
  }
  
  public static <R extends Result> PendingResult<R> canceledPendingResult(R paramR)
  {
    AppMethodBeat.i(11054);
    Preconditions.checkNotNull(paramR, "Result must not be null");
    if (paramR.getStatus().getStatusCode() == 16) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Status code must be CommonStatusCodes.CANCELED");
      paramR = new zza(paramR);
      paramR.cancel();
      AppMethodBeat.o(11054);
      return paramR;
    }
  }
  
  @KeepForSdk
  public static <R extends Result> PendingResult<R> immediateFailedResult(R paramR, GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(11050);
    Preconditions.checkNotNull(paramR, "Result must not be null");
    if (!paramR.getStatus().isSuccess()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Status code must not be SUCCESS");
      paramGoogleApiClient = new zzb(paramGoogleApiClient, paramR);
      paramGoogleApiClient.setResult(paramR);
      AppMethodBeat.o(11050);
      return paramGoogleApiClient;
    }
  }
  
  @KeepForSdk
  public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R paramR)
  {
    AppMethodBeat.i(11051);
    Preconditions.checkNotNull(paramR, "Result must not be null");
    zzc localzzc = new zzc(null);
    localzzc.setResult(paramR);
    paramR = new OptionalPendingResultImpl(localzzc);
    AppMethodBeat.o(11051);
    return paramR;
  }
  
  @KeepForSdk
  public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R paramR, GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(11052);
    Preconditions.checkNotNull(paramR, "Result must not be null");
    paramGoogleApiClient = new zzc(paramGoogleApiClient);
    paramGoogleApiClient.setResult(paramR);
    paramR = new OptionalPendingResultImpl(paramGoogleApiClient);
    AppMethodBeat.o(11052);
    return paramR;
  }
  
  @KeepForSdk
  public static PendingResult<Status> immediatePendingResult(Status paramStatus)
  {
    AppMethodBeat.i(11048);
    Preconditions.checkNotNull(paramStatus, "Result must not be null");
    StatusPendingResult localStatusPendingResult = new StatusPendingResult(Looper.getMainLooper());
    localStatusPendingResult.setResult(paramStatus);
    AppMethodBeat.o(11048);
    return localStatusPendingResult;
  }
  
  @KeepForSdk
  public static PendingResult<Status> immediatePendingResult(Status paramStatus, GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(11049);
    Preconditions.checkNotNull(paramStatus, "Result must not be null");
    paramGoogleApiClient = new StatusPendingResult(paramGoogleApiClient);
    paramGoogleApiClient.setResult(paramStatus);
    AppMethodBeat.o(11049);
    return paramGoogleApiClient;
  }
  
  static final class zza<R extends Result>
    extends BasePendingResult<R>
  {
    private final R zzdl;
    
    public zza(R paramR)
    {
      super();
      AppMethodBeat.i(11045);
      this.zzdl = paramR;
      AppMethodBeat.o(11045);
    }
    
    public final R createFailedResult(Status paramStatus)
    {
      AppMethodBeat.i(11046);
      if (paramStatus.getStatusCode() != this.zzdl.getStatus().getStatusCode())
      {
        paramStatus = new UnsupportedOperationException("Creating failed results is not supported");
        AppMethodBeat.o(11046);
        throw paramStatus;
      }
      paramStatus = this.zzdl;
      AppMethodBeat.o(11046);
      return paramStatus;
    }
  }
  
  static final class zzb<R extends Result>
    extends BasePendingResult<R>
  {
    private final R zzdm;
    
    public zzb(GoogleApiClient paramGoogleApiClient, R paramR)
    {
      super();
      this.zzdm = paramR;
    }
    
    public final R createFailedResult(Status paramStatus)
    {
      return this.zzdm;
    }
  }
  
  static final class zzc<R extends Result>
    extends BasePendingResult<R>
  {
    public zzc(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public final R createFailedResult(Status paramStatus)
    {
      AppMethodBeat.i(11047);
      paramStatus = new UnsupportedOperationException("Creating failed results is not supported");
      AppMethodBeat.o(11047);
      throw paramStatus;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.api.PendingResults
 * JD-Core Version:    0.7.0.1
 */
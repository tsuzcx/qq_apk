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
    AppMethodBeat.i(60561);
    StatusPendingResult localStatusPendingResult = new StatusPendingResult(Looper.getMainLooper());
    localStatusPendingResult.cancel();
    AppMethodBeat.o(60561);
    return localStatusPendingResult;
  }
  
  public static <R extends Result> PendingResult<R> canceledPendingResult(R paramR)
  {
    AppMethodBeat.i(60562);
    Preconditions.checkNotNull(paramR, "Result must not be null");
    if (paramR.getStatus().getStatusCode() == 16) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Status code must be CommonStatusCodes.CANCELED");
      paramR = new PendingResults.zza(paramR);
      paramR.cancel();
      AppMethodBeat.o(60562);
      return paramR;
    }
  }
  
  @KeepForSdk
  public static <R extends Result> PendingResult<R> immediateFailedResult(R paramR, GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(60558);
    Preconditions.checkNotNull(paramR, "Result must not be null");
    if (!paramR.getStatus().isSuccess()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Status code must not be SUCCESS");
      paramGoogleApiClient = new PendingResults.zzb(paramGoogleApiClient, paramR);
      paramGoogleApiClient.setResult(paramR);
      AppMethodBeat.o(60558);
      return paramGoogleApiClient;
    }
  }
  
  @KeepForSdk
  public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R paramR)
  {
    AppMethodBeat.i(60559);
    Preconditions.checkNotNull(paramR, "Result must not be null");
    PendingResults.zzc localzzc = new PendingResults.zzc(null);
    localzzc.setResult(paramR);
    paramR = new OptionalPendingResultImpl(localzzc);
    AppMethodBeat.o(60559);
    return paramR;
  }
  
  @KeepForSdk
  public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R paramR, GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(60560);
    Preconditions.checkNotNull(paramR, "Result must not be null");
    paramGoogleApiClient = new PendingResults.zzc(paramGoogleApiClient);
    paramGoogleApiClient.setResult(paramR);
    paramR = new OptionalPendingResultImpl(paramGoogleApiClient);
    AppMethodBeat.o(60560);
    return paramR;
  }
  
  @KeepForSdk
  public static PendingResult<Status> immediatePendingResult(Status paramStatus)
  {
    AppMethodBeat.i(60556);
    Preconditions.checkNotNull(paramStatus, "Result must not be null");
    StatusPendingResult localStatusPendingResult = new StatusPendingResult(Looper.getMainLooper());
    localStatusPendingResult.setResult(paramStatus);
    AppMethodBeat.o(60556);
    return localStatusPendingResult;
  }
  
  @KeepForSdk
  public static PendingResult<Status> immediatePendingResult(Status paramStatus, GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(60557);
    Preconditions.checkNotNull(paramStatus, "Result must not be null");
    paramGoogleApiClient = new StatusPendingResult(paramGoogleApiClient);
    paramGoogleApiClient.setResult(paramStatus);
    AppMethodBeat.o(60557);
    return paramGoogleApiClient;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.api.PendingResults
 * JD-Core Version:    0.7.0.1
 */
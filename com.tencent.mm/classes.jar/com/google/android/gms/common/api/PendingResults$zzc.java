package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PendingResults$zzc<R extends Result>
  extends BasePendingResult<R>
{
  public PendingResults$zzc(GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
  }
  
  public final R createFailedResult(Status paramStatus)
  {
    AppMethodBeat.i(60555);
    paramStatus = new UnsupportedOperationException("Creating failed results is not supported");
    AppMethodBeat.o(60555);
    throw paramStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.api.PendingResults.zzc
 * JD-Core Version:    0.7.0.1
 */
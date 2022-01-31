package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PendingResults$zza<R extends Result>
  extends BasePendingResult<R>
{
  private final R zzdl;
  
  public PendingResults$zza(R paramR)
  {
    super(Looper.getMainLooper());
    AppMethodBeat.i(60553);
    this.zzdl = paramR;
    AppMethodBeat.o(60553);
  }
  
  public final R createFailedResult(Status paramStatus)
  {
    AppMethodBeat.i(60554);
    if (paramStatus.getStatusCode() != this.zzdl.getStatus().getStatusCode())
    {
      paramStatus = new UnsupportedOperationException("Creating failed results is not supported");
      AppMethodBeat.o(60554);
      throw paramStatus;
    }
    paramStatus = this.zzdl;
    AppMethodBeat.o(60554);
    return paramStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.PendingResults.zza
 * JD-Core Version:    0.7.0.1
 */
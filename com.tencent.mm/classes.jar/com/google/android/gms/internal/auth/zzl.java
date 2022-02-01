package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzl
  extends BaseImplementation.ApiMethodImpl<Result, zzu>
{
  zzl(zzk paramzzk, Api paramApi, GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    super(paramApi, paramGoogleApiClient);
  }
  
  public final Result createFailedResult(Status paramStatus)
  {
    AppMethodBeat.i(10794);
    paramStatus = new zzs(paramStatus);
    AppMethodBeat.o(10794);
    return paramStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzl
 * JD-Core Version:    0.7.0.1
 */
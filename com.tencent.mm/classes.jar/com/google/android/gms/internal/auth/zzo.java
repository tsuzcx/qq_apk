package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzo
  extends BaseImplementation.ApiMethodImpl<Result, zzu>
{
  zzo(zzk paramzzk, Api paramApi, GoogleApiClient paramGoogleApiClient, Account paramAccount)
  {
    super(paramApi, paramGoogleApiClient);
  }
  
  public final Result createFailedResult(Status paramStatus)
  {
    AppMethodBeat.i(10799);
    paramStatus = new zzt(paramStatus);
    AppMethodBeat.o(10799);
    return paramStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzo
 * JD-Core Version:    0.7.0.1
 */
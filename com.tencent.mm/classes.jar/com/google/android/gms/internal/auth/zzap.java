package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzap
  extends zzav<CredentialRequestResult>
{
  zzap(zzao paramzzao, GoogleApiClient paramGoogleApiClient, CredentialRequest paramCredentialRequest)
  {
    super(paramGoogleApiClient);
  }
  
  protected final void zzd(Context paramContext, zzbc paramzzbc)
  {
    AppMethodBeat.i(50477);
    paramzzbc.zzd(new zzaq(this), this.zzdr);
    AppMethodBeat.o(50477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzap
 * JD-Core Version:    0.7.0.1
 */
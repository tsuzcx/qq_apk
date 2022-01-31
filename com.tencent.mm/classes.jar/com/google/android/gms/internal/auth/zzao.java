package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzao
  implements CredentialsApi
{
  public final PendingResult<Status> delete(GoogleApiClient paramGoogleApiClient, Credential paramCredential)
  {
    AppMethodBeat.i(50475);
    Preconditions.checkNotNull(paramGoogleApiClient, "client must not be null");
    Preconditions.checkNotNull(paramCredential, "credential must not be null");
    paramGoogleApiClient = paramGoogleApiClient.execute(new zzas(this, paramGoogleApiClient, paramCredential));
    AppMethodBeat.o(50475);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Status> disableAutoSignIn(GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(50476);
    Preconditions.checkNotNull(paramGoogleApiClient, "client must not be null");
    paramGoogleApiClient = paramGoogleApiClient.execute(new zzat(this, paramGoogleApiClient));
    AppMethodBeat.o(50476);
    return paramGoogleApiClient;
  }
  
  public final PendingIntent getHintPickerIntent(GoogleApiClient paramGoogleApiClient, HintRequest paramHintRequest)
  {
    AppMethodBeat.i(50473);
    Preconditions.checkNotNull(paramGoogleApiClient, "client must not be null");
    Preconditions.checkNotNull(paramHintRequest, "request must not be null");
    Auth.AuthCredentialsOptions localAuthCredentialsOptions = ((zzax)paramGoogleApiClient.getClient(Auth.zzaj)).zzk();
    paramGoogleApiClient = zzaw.zzd(paramGoogleApiClient.getContext(), localAuthCredentialsOptions, paramHintRequest);
    AppMethodBeat.o(50473);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<CredentialRequestResult> request(GoogleApiClient paramGoogleApiClient, CredentialRequest paramCredentialRequest)
  {
    AppMethodBeat.i(50472);
    Preconditions.checkNotNull(paramGoogleApiClient, "client must not be null");
    Preconditions.checkNotNull(paramCredentialRequest, "request must not be null");
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzap(this, paramGoogleApiClient, paramCredentialRequest));
    AppMethodBeat.o(50472);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Status> save(GoogleApiClient paramGoogleApiClient, Credential paramCredential)
  {
    AppMethodBeat.i(50474);
    Preconditions.checkNotNull(paramGoogleApiClient, "client must not be null");
    Preconditions.checkNotNull(paramCredential, "credential must not be null");
    paramGoogleApiClient = paramGoogleApiClient.execute(new zzar(this, paramGoogleApiClient, paramCredential));
    AppMethodBeat.o(50474);
    return paramGoogleApiClient;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzao
 * JD-Core Version:    0.7.0.1
 */
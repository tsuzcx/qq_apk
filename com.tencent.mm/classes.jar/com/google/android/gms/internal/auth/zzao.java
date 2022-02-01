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
    AppMethodBeat.i(88370);
    Preconditions.checkNotNull(paramGoogleApiClient, "client must not be null");
    Preconditions.checkNotNull(paramCredential, "credential must not be null");
    paramGoogleApiClient = paramGoogleApiClient.execute(new zzas(this, paramGoogleApiClient, paramCredential));
    AppMethodBeat.o(88370);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Status> disableAutoSignIn(GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(88371);
    Preconditions.checkNotNull(paramGoogleApiClient, "client must not be null");
    paramGoogleApiClient = paramGoogleApiClient.execute(new zzat(this, paramGoogleApiClient));
    AppMethodBeat.o(88371);
    return paramGoogleApiClient;
  }
  
  public final PendingIntent getHintPickerIntent(GoogleApiClient paramGoogleApiClient, HintRequest paramHintRequest)
  {
    AppMethodBeat.i(88368);
    Preconditions.checkNotNull(paramGoogleApiClient, "client must not be null");
    Preconditions.checkNotNull(paramHintRequest, "request must not be null");
    Auth.AuthCredentialsOptions localAuthCredentialsOptions = ((zzax)paramGoogleApiClient.getClient(Auth.zzaj)).zzk();
    paramGoogleApiClient = zzaw.zzd(paramGoogleApiClient.getContext(), localAuthCredentialsOptions, paramHintRequest);
    AppMethodBeat.o(88368);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<CredentialRequestResult> request(GoogleApiClient paramGoogleApiClient, CredentialRequest paramCredentialRequest)
  {
    AppMethodBeat.i(88367);
    Preconditions.checkNotNull(paramGoogleApiClient, "client must not be null");
    Preconditions.checkNotNull(paramCredentialRequest, "request must not be null");
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzap(this, paramGoogleApiClient, paramCredentialRequest));
    AppMethodBeat.o(88367);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Status> save(GoogleApiClient paramGoogleApiClient, Credential paramCredential)
  {
    AppMethodBeat.i(88369);
    Preconditions.checkNotNull(paramGoogleApiClient, "client must not be null");
    Preconditions.checkNotNull(paramCredential, "credential must not be null");
    paramGoogleApiClient = paramGoogleApiClient.execute(new zzar(this, paramGoogleApiClient, paramCredential));
    AppMethodBeat.o(88369);
    return paramGoogleApiClient;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzao
 * JD-Core Version:    0.7.0.1
 */
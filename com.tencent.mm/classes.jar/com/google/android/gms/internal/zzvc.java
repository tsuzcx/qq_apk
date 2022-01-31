package com.google.android.gms.internal;

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
import com.google.android.gms.common.internal.zzac;

public final class zzvc
  implements CredentialsApi
{
  private Auth.AuthCredentialsOptions zza(GoogleApiClient paramGoogleApiClient)
  {
    return ((zzvf)paramGoogleApiClient.zza(Auth.zzaiS)).zzrc();
  }
  
  public final PendingResult<Status> delete(GoogleApiClient paramGoogleApiClient, Credential paramCredential)
  {
    return paramGoogleApiClient.zzb(new zzvc.3(this, paramGoogleApiClient, paramCredential));
  }
  
  public final PendingResult<Status> disableAutoSignIn(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.zzb(new zzvc.4(this, paramGoogleApiClient));
  }
  
  public final PendingIntent getHintPickerIntent(GoogleApiClient paramGoogleApiClient, HintRequest paramHintRequest)
  {
    zzac.zzb(paramGoogleApiClient.zza(Auth.CREDENTIALS_API), "Auth.CREDENTIALS_API must be added to GoogleApiClient to use this API");
    Auth.AuthCredentialsOptions localAuthCredentialsOptions = zza(paramGoogleApiClient);
    return zzve.zza(paramGoogleApiClient.getContext(), localAuthCredentialsOptions, paramHintRequest);
  }
  
  public final PendingResult<CredentialRequestResult> request(GoogleApiClient paramGoogleApiClient, CredentialRequest paramCredentialRequest)
  {
    return paramGoogleApiClient.zza(new zzvc.1(this, paramGoogleApiClient, paramCredentialRequest));
  }
  
  public final PendingResult<Status> save(GoogleApiClient paramGoogleApiClient, Credential paramCredential)
  {
    return paramGoogleApiClient.zzb(new zzvc.2(this, paramGoogleApiClient, paramCredential));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.zzvc
 * JD-Core Version:    0.7.0.1
 */
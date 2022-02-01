package com.google.android.gms.auth.api.credentials;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.internal.auth.zzaw;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CredentialsClient
  extends GoogleApi<Auth.AuthCredentialsOptions>
{
  CredentialsClient(Activity paramActivity, Auth.AuthCredentialsOptions paramAuthCredentialsOptions)
  {
    super(paramActivity, Auth.CREDENTIALS_API, paramAuthCredentialsOptions, new ApiExceptionMapper());
    AppMethodBeat.i(88229);
    AppMethodBeat.o(88229);
  }
  
  CredentialsClient(Context paramContext, Auth.AuthCredentialsOptions paramAuthCredentialsOptions)
  {
    super(paramContext, Auth.CREDENTIALS_API, paramAuthCredentialsOptions, new ApiExceptionMapper());
    AppMethodBeat.i(88228);
    AppMethodBeat.o(88228);
  }
  
  public Task<Void> delete(Credential paramCredential)
  {
    AppMethodBeat.i(88233);
    paramCredential = PendingResultUtil.toVoidTask(Auth.CredentialsApi.delete(asGoogleApiClient(), paramCredential));
    AppMethodBeat.o(88233);
    return paramCredential;
  }
  
  public Task<Void> disableAutoSignIn()
  {
    AppMethodBeat.i(88234);
    Task localTask = PendingResultUtil.toVoidTask(Auth.CredentialsApi.disableAutoSignIn(asGoogleApiClient()));
    AppMethodBeat.o(88234);
    return localTask;
  }
  
  public PendingIntent getHintPickerIntent(HintRequest paramHintRequest)
  {
    AppMethodBeat.i(88231);
    paramHintRequest = zzaw.zzd(getApplicationContext(), (Auth.AuthCredentialsOptions)getApiOptions(), paramHintRequest);
    AppMethodBeat.o(88231);
    return paramHintRequest;
  }
  
  public Task<CredentialRequestResponse> request(CredentialRequest paramCredentialRequest)
  {
    AppMethodBeat.i(88230);
    paramCredentialRequest = PendingResultUtil.toResponseTask(Auth.CredentialsApi.request(asGoogleApiClient(), paramCredentialRequest), new CredentialRequestResponse());
    AppMethodBeat.o(88230);
    return paramCredentialRequest;
  }
  
  public Task<Void> save(Credential paramCredential)
  {
    AppMethodBeat.i(88232);
    paramCredential = PendingResultUtil.toVoidTask(Auth.CredentialsApi.save(asGoogleApiClient(), paramCredential));
    AppMethodBeat.o(88232);
    return paramCredential;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialsClient
 * JD-Core Version:    0.7.0.1
 */
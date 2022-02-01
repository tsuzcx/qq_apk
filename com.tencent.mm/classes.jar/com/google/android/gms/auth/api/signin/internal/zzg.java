package com.google.android.gms.auth.api.signin.internal;

import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzg
  implements GoogleSignInApi
{
  private static GoogleSignInOptions zzd(GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(88326);
    paramGoogleApiClient = ((zzh)paramGoogleApiClient.getClient(Auth.zzak)).zzn();
    AppMethodBeat.o(88326);
    return paramGoogleApiClient;
  }
  
  public final Intent getSignInIntent(GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(88321);
    paramGoogleApiClient = zzi.zzd(paramGoogleApiClient.getContext(), zzd(paramGoogleApiClient));
    AppMethodBeat.o(88321);
    return paramGoogleApiClient;
  }
  
  public final GoogleSignInResult getSignInResultFromIntent(Intent paramIntent)
  {
    AppMethodBeat.i(88325);
    paramIntent = zzi.getSignInResultFromIntent(paramIntent);
    AppMethodBeat.o(88325);
    return paramIntent;
  }
  
  public final PendingResult<Status> revokeAccess(GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(88324);
    paramGoogleApiClient = zzi.zze(paramGoogleApiClient, paramGoogleApiClient.getContext(), false);
    AppMethodBeat.o(88324);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Status> signOut(GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(88323);
    paramGoogleApiClient = zzi.zzd(paramGoogleApiClient, paramGoogleApiClient.getContext(), false);
    AppMethodBeat.o(88323);
    return paramGoogleApiClient;
  }
  
  public final OptionalPendingResult<GoogleSignInResult> silentSignIn(GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(88322);
    paramGoogleApiClient = zzi.zzd(paramGoogleApiClient, paramGoogleApiClient.getContext(), zzd(paramGoogleApiClient), false);
    AppMethodBeat.o(88322);
    return paramGoogleApiClient;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzg
 * JD-Core Version:    0.7.0.1
 */
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
    AppMethodBeat.i(50431);
    paramGoogleApiClient = ((zzh)paramGoogleApiClient.getClient(Auth.zzak)).zzn();
    AppMethodBeat.o(50431);
    return paramGoogleApiClient;
  }
  
  public final Intent getSignInIntent(GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(50426);
    paramGoogleApiClient = zzi.zzd(paramGoogleApiClient.getContext(), zzd(paramGoogleApiClient));
    AppMethodBeat.o(50426);
    return paramGoogleApiClient;
  }
  
  public final GoogleSignInResult getSignInResultFromIntent(Intent paramIntent)
  {
    AppMethodBeat.i(50430);
    paramIntent = zzi.getSignInResultFromIntent(paramIntent);
    AppMethodBeat.o(50430);
    return paramIntent;
  }
  
  public final PendingResult<Status> revokeAccess(GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(50429);
    paramGoogleApiClient = zzi.zze(paramGoogleApiClient, paramGoogleApiClient.getContext(), false);
    AppMethodBeat.o(50429);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Status> signOut(GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(50428);
    paramGoogleApiClient = zzi.zzd(paramGoogleApiClient, paramGoogleApiClient.getContext(), false);
    AppMethodBeat.o(50428);
    return paramGoogleApiClient;
  }
  
  public final OptionalPendingResult<GoogleSignInResult> silentSignIn(GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(50427);
    paramGoogleApiClient = zzi.zzd(paramGoogleApiClient, paramGoogleApiClient.getContext(), zzd(paramGoogleApiClient), false);
    AppMethodBeat.o(50427);
    return paramGoogleApiClient;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzg
 * JD-Core Version:    0.7.0.1
 */
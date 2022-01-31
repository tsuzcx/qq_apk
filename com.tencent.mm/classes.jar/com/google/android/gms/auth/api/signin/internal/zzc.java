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

public class zzc
  implements GoogleSignInApi
{
  private GoogleSignInOptions zzb(GoogleApiClient paramGoogleApiClient)
  {
    return ((zzd)paramGoogleApiClient.zza(Auth.zzaiU)).zzrt();
  }
  
  public Intent getSignInIntent(GoogleApiClient paramGoogleApiClient)
  {
    return zze.zza(paramGoogleApiClient.getContext(), zzb(paramGoogleApiClient));
  }
  
  public GoogleSignInResult getSignInResultFromIntent(Intent paramIntent)
  {
    return zze.getSignInResultFromIntent(paramIntent);
  }
  
  public PendingResult<Status> revokeAccess(GoogleApiClient paramGoogleApiClient)
  {
    return zze.zzb(paramGoogleApiClient, paramGoogleApiClient.getContext());
  }
  
  public PendingResult<Status> signOut(GoogleApiClient paramGoogleApiClient)
  {
    return zze.zza(paramGoogleApiClient, paramGoogleApiClient.getContext());
  }
  
  public OptionalPendingResult<GoogleSignInResult> silentSignIn(GoogleApiClient paramGoogleApiClient)
  {
    return zze.zza(paramGoogleApiClient, paramGoogleApiClient.getContext(), zzb(paramGoogleApiClient));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzc
 * JD-Core Version:    0.7.0.1
 */
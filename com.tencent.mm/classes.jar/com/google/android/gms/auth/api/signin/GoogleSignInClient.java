package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.internal.zzi;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GoogleSignInClient
  extends GoogleApi<GoogleSignInOptions>
{
  private static final GoogleSignInClient.zzd zzef;
  @VisibleForTesting
  private static int zzeg;
  
  static
  {
    AppMethodBeat.i(50395);
    zzef = new GoogleSignInClient.zzd(null);
    zzeg = GoogleSignInClient.zze.zzei;
    AppMethodBeat.o(50395);
  }
  
  GoogleSignInClient(Activity paramActivity, GoogleSignInOptions paramGoogleSignInOptions)
  {
    super(paramActivity, Auth.GOOGLE_SIGN_IN_API, paramGoogleSignInOptions, new ApiExceptionMapper());
    AppMethodBeat.i(50389);
    AppMethodBeat.o(50389);
  }
  
  GoogleSignInClient(Context paramContext, GoogleSignInOptions paramGoogleSignInOptions)
  {
    super(paramContext, Auth.GOOGLE_SIGN_IN_API, paramGoogleSignInOptions, new ApiExceptionMapper());
    AppMethodBeat.i(50388);
    AppMethodBeat.o(50388);
  }
  
  private final int zzl()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(50390);
        Context localContext;
        GoogleApiAvailability localGoogleApiAvailability;
        int i;
        if (zzeg == GoogleSignInClient.zze.zzei)
        {
          localContext = getApplicationContext();
          localGoogleApiAvailability = GoogleApiAvailability.getInstance();
          i = localGoogleApiAvailability.isGooglePlayServicesAvailable(localContext, 12451000);
          if (i == 0) {
            zzeg = GoogleSignInClient.zze.zzel;
          }
        }
        else
        {
          i = zzeg;
          AppMethodBeat.o(50390);
          return i;
        }
        if ((localGoogleApiAvailability.getErrorResolutionIntent(localContext, i, null) == null) && (DynamiteModule.getLocalVersion(localContext, "com.google.android.gms.auth.api.fallback") != 0)) {
          zzeg = GoogleSignInClient.zze.zzek;
        } else {
          zzeg = GoogleSignInClient.zze.zzej;
        }
      }
      finally {}
    }
  }
  
  public Intent getSignInIntent()
  {
    AppMethodBeat.i(50391);
    Object localObject = getApplicationContext();
    switch (zzd.zzeh[(zzl() - 1)])
    {
    default: 
      localObject = zzi.zzf((Context)localObject, (GoogleSignInOptions)getApiOptions());
      AppMethodBeat.o(50391);
      return localObject;
    case 1: 
      localObject = zzi.zze((Context)localObject, (GoogleSignInOptions)getApiOptions());
      AppMethodBeat.o(50391);
      return localObject;
    }
    localObject = zzi.zzd((Context)localObject, (GoogleSignInOptions)getApiOptions());
    AppMethodBeat.o(50391);
    return localObject;
  }
  
  public Task<Void> revokeAccess()
  {
    AppMethodBeat.i(50394);
    Object localObject = asGoogleApiClient();
    Context localContext = getApplicationContext();
    if (zzl() == GoogleSignInClient.zze.zzek) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = PendingResultUtil.toVoidTask(zzi.zze((GoogleApiClient)localObject, localContext, bool));
      AppMethodBeat.o(50394);
      return localObject;
    }
  }
  
  public Task<Void> signOut()
  {
    AppMethodBeat.i(50393);
    Object localObject = asGoogleApiClient();
    Context localContext = getApplicationContext();
    if (zzl() == GoogleSignInClient.zze.zzek) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = PendingResultUtil.toVoidTask(zzi.zzd((GoogleApiClient)localObject, localContext, bool));
      AppMethodBeat.o(50393);
      return localObject;
    }
  }
  
  public Task<GoogleSignInAccount> silentSignIn()
  {
    AppMethodBeat.i(50392);
    Object localObject = asGoogleApiClient();
    Context localContext = getApplicationContext();
    GoogleSignInOptions localGoogleSignInOptions = (GoogleSignInOptions)getApiOptions();
    if (zzl() == GoogleSignInClient.zze.zzek) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = PendingResultUtil.toTask(zzi.zzd((GoogleApiClient)localObject, localContext, localGoogleSignInOptions, bool), zzef);
      AppMethodBeat.o(50392);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInClient
 * JD-Core Version:    0.7.0.1
 */
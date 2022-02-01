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
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GoogleSignInClient
  extends GoogleApi<GoogleSignInOptions>
{
  private static final zzd zzef;
  @VisibleForTesting
  private static int zzeg;
  
  static
  {
    AppMethodBeat.i(88290);
    zzef = new zzd(null);
    zzeg = zze.zzei;
    AppMethodBeat.o(88290);
  }
  
  GoogleSignInClient(Activity paramActivity, GoogleSignInOptions paramGoogleSignInOptions)
  {
    super(paramActivity, Auth.GOOGLE_SIGN_IN_API, paramGoogleSignInOptions, new ApiExceptionMapper());
    AppMethodBeat.i(88284);
    AppMethodBeat.o(88284);
  }
  
  GoogleSignInClient(Context paramContext, GoogleSignInOptions paramGoogleSignInOptions)
  {
    super(paramContext, Auth.GOOGLE_SIGN_IN_API, paramGoogleSignInOptions, new ApiExceptionMapper());
    AppMethodBeat.i(88283);
    AppMethodBeat.o(88283);
  }
  
  private final int zzl()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(88285);
        Context localContext;
        GoogleApiAvailability localGoogleApiAvailability;
        int i;
        if (zzeg == zze.zzei)
        {
          localContext = getApplicationContext();
          localGoogleApiAvailability = GoogleApiAvailability.getInstance();
          i = localGoogleApiAvailability.isGooglePlayServicesAvailable(localContext, 12451000);
          if (i == 0) {
            zzeg = zze.zzel;
          }
        }
        else
        {
          i = zzeg;
          AppMethodBeat.o(88285);
          return i;
        }
        if ((localGoogleApiAvailability.getErrorResolutionIntent(localContext, i, null) == null) && (DynamiteModule.getLocalVersion(localContext, "com.google.android.gms.auth.api.fallback") != 0)) {
          zzeg = zze.zzek;
        } else {
          zzeg = zze.zzej;
        }
      }
      finally {}
    }
  }
  
  public Intent getSignInIntent()
  {
    AppMethodBeat.i(88286);
    Object localObject = getApplicationContext();
    switch (zzd.zzeh[(zzl() - 1)])
    {
    default: 
      localObject = zzi.zzf((Context)localObject, (GoogleSignInOptions)getApiOptions());
      AppMethodBeat.o(88286);
      return localObject;
    case 1: 
      localObject = zzi.zze((Context)localObject, (GoogleSignInOptions)getApiOptions());
      AppMethodBeat.o(88286);
      return localObject;
    }
    localObject = zzi.zzd((Context)localObject, (GoogleSignInOptions)getApiOptions());
    AppMethodBeat.o(88286);
    return localObject;
  }
  
  public Task<Void> revokeAccess()
  {
    AppMethodBeat.i(88289);
    Object localObject = asGoogleApiClient();
    Context localContext = getApplicationContext();
    if (zzl() == zze.zzek) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = PendingResultUtil.toVoidTask(zzi.zze((GoogleApiClient)localObject, localContext, bool));
      AppMethodBeat.o(88289);
      return localObject;
    }
  }
  
  public Task<Void> signOut()
  {
    AppMethodBeat.i(88288);
    Object localObject = asGoogleApiClient();
    Context localContext = getApplicationContext();
    if (zzl() == zze.zzek) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = PendingResultUtil.toVoidTask(zzi.zzd((GoogleApiClient)localObject, localContext, bool));
      AppMethodBeat.o(88288);
      return localObject;
    }
  }
  
  public Task<GoogleSignInAccount> silentSignIn()
  {
    AppMethodBeat.i(88287);
    Object localObject = asGoogleApiClient();
    Context localContext = getApplicationContext();
    GoogleSignInOptions localGoogleSignInOptions = (GoogleSignInOptions)getApiOptions();
    if (zzl() == zze.zzek) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = PendingResultUtil.toTask(zzi.zzd((GoogleApiClient)localObject, localContext, localGoogleSignInOptions, bool), zzef);
      AppMethodBeat.o(88287);
      return localObject;
    }
  }
  
  static final class zzd
    implements PendingResultUtil.ResultConverter<GoogleSignInResult, GoogleSignInAccount>
  {}
  
  @VisibleForTesting
  static enum zze
  {
    public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FC5N68SJFD5I2UPRDECNM2TBKD0NM2S395TPMIPRED5N2UHRFDTJMOPAJD5JMSIBE8DM6IPBEEGI4IRBGDHIMQPBEEHGN8QBFDOTG____0()
    {
      AppMethodBeat.i(88282);
      int[] arrayOfInt = (int[])zzem.clone();
      AppMethodBeat.o(88282);
      return arrayOfInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInClient
 * JD-Core Version:    0.7.0.1
 */
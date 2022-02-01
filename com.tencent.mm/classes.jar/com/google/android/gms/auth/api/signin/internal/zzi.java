package com.google.android.gms.auth.api.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class zzi
{
  private static Logger zzer;
  
  static
  {
    AppMethodBeat.i(88338);
    zzer = new Logger("GoogleSignInCommon", new String[0]);
    AppMethodBeat.o(88338);
  }
  
  public static GoogleSignInResult getSignInResultFromIntent(Intent paramIntent)
  {
    AppMethodBeat.i(88337);
    if ((paramIntent == null) || ((!paramIntent.hasExtra("googleSignInStatus")) && (!paramIntent.hasExtra("googleSignInAccount"))))
    {
      AppMethodBeat.o(88337);
      return null;
    }
    GoogleSignInAccount localGoogleSignInAccount = (GoogleSignInAccount)paramIntent.getParcelableExtra("googleSignInAccount");
    paramIntent = (Status)paramIntent.getParcelableExtra("googleSignInStatus");
    if (localGoogleSignInAccount != null) {
      paramIntent = Status.RESULT_SUCCESS;
    }
    paramIntent = new GoogleSignInResult(localGoogleSignInAccount, paramIntent);
    AppMethodBeat.o(88337);
    return paramIntent;
  }
  
  public static Intent zzd(Context paramContext, GoogleSignInOptions paramGoogleSignInOptions)
  {
    AppMethodBeat.i(88330);
    zzer.d("getSignInIntent()", new Object[0]);
    paramGoogleSignInOptions = new SignInConfiguration(paramContext.getPackageName(), paramGoogleSignInOptions);
    Intent localIntent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.setClass(paramContext, SignInHubActivity.class);
    paramContext = new Bundle();
    paramContext.putParcelable("config", paramGoogleSignInOptions);
    localIntent.putExtra("config", paramContext);
    AppMethodBeat.o(88330);
    return localIntent;
  }
  
  public static OptionalPendingResult<GoogleSignInResult> zzd(GoogleApiClient paramGoogleApiClient, Context paramContext, GoogleSignInOptions paramGoogleSignInOptions, boolean paramBoolean)
  {
    AppMethodBeat.i(88333);
    zzer.d("silentSignIn()", new Object[0]);
    zzer.d("getEligibleSavedSignInResult()", new Object[0]);
    Preconditions.checkNotNull(paramGoogleSignInOptions);
    Object localObject = zzq.zze(paramContext).zzp();
    Account localAccount1;
    Account localAccount2;
    boolean bool;
    if (localObject != null)
    {
      localAccount1 = ((GoogleSignInOptions)localObject).getAccount();
      localAccount2 = paramGoogleSignInOptions.getAccount();
      if (localAccount1 == null) {
        if (localAccount2 == null)
        {
          bool = true;
          if ((!bool) || (paramGoogleSignInOptions.isServerAuthCodeRequested()) || ((paramGoogleSignInOptions.isIdTokenRequested()) && ((!((GoogleSignInOptions)localObject).isIdTokenRequested()) || (!paramGoogleSignInOptions.getServerClientId().equals(((GoogleSignInOptions)localObject).getServerClientId())))) || (!new HashSet(((GoogleSignInOptions)localObject).getScopes()).containsAll(new HashSet(paramGoogleSignInOptions.getScopes())))) {
            break label232;
          }
          localObject = zzq.zze(paramContext).zzo();
          if ((localObject == null) || (((GoogleSignInAccount)localObject).isExpired())) {
            break label232;
          }
        }
      }
    }
    label232:
    for (localObject = new GoogleSignInResult((GoogleSignInAccount)localObject, Status.RESULT_SUCCESS);; localObject = null)
    {
      if (localObject == null) {
        break label238;
      }
      zzer.d("Eligible saved sign in result found", new Object[0]);
      paramGoogleApiClient = PendingResults.immediatePendingResult((Result)localObject, paramGoogleApiClient);
      AppMethodBeat.o(88333);
      return paramGoogleApiClient;
      bool = false;
      break;
      bool = localAccount1.equals(localAccount2);
      break;
    }
    label238:
    if (paramBoolean)
    {
      paramGoogleApiClient = PendingResults.immediatePendingResult(new GoogleSignInResult(null, new Status(4)), paramGoogleApiClient);
      AppMethodBeat.o(88333);
      return paramGoogleApiClient;
    }
    zzer.d("trySilentSignIn()", new Object[0]);
    paramGoogleApiClient = new OptionalPendingResultImpl(paramGoogleApiClient.enqueue(new zzj(paramGoogleApiClient, paramContext, paramGoogleSignInOptions)));
    AppMethodBeat.o(88333);
    return paramGoogleApiClient;
  }
  
  public static PendingResult<Status> zzd(GoogleApiClient paramGoogleApiClient, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(88334);
    zzer.d("Signing out", new Object[0]);
    zzd(paramContext);
    if (paramBoolean)
    {
      paramGoogleApiClient = PendingResults.immediatePendingResult(Status.RESULT_SUCCESS, paramGoogleApiClient);
      AppMethodBeat.o(88334);
      return paramGoogleApiClient;
    }
    paramGoogleApiClient = paramGoogleApiClient.execute(new zzl(paramGoogleApiClient));
    AppMethodBeat.o(88334);
    return paramGoogleApiClient;
  }
  
  private static void zzd(Context paramContext)
  {
    AppMethodBeat.i(88336);
    zzq.zze(paramContext).clear();
    paramContext = GoogleApiClient.getAllClients().iterator();
    while (paramContext.hasNext()) {
      ((GoogleApiClient)paramContext.next()).maybeSignOut();
    }
    GoogleApiManager.reportSignOut();
    AppMethodBeat.o(88336);
  }
  
  public static Intent zze(Context paramContext, GoogleSignInOptions paramGoogleSignInOptions)
  {
    AppMethodBeat.i(88331);
    zzer.d("getFallbackSignInIntent()", new Object[0]);
    paramContext = zzd(paramContext, paramGoogleSignInOptions);
    paramContext.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
    AppMethodBeat.o(88331);
    return paramContext;
  }
  
  public static PendingResult<Status> zze(GoogleApiClient paramGoogleApiClient, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(88335);
    zzer.d("Revoking access", new Object[0]);
    String str = Storage.getInstance(paramContext).getSavedRefreshToken();
    zzd(paramContext);
    if (paramBoolean)
    {
      paramGoogleApiClient = zze.zzg(str);
      AppMethodBeat.o(88335);
      return paramGoogleApiClient;
    }
    paramGoogleApiClient = paramGoogleApiClient.execute(new zzn(paramGoogleApiClient));
    AppMethodBeat.o(88335);
    return paramGoogleApiClient;
  }
  
  public static Intent zzf(Context paramContext, GoogleSignInOptions paramGoogleSignInOptions)
  {
    AppMethodBeat.i(88332);
    zzer.d("getNoImplementationSignInIntent()", new Object[0]);
    paramContext = zzd(paramContext, paramGoogleSignInOptions);
    paramContext.setAction("com.google.android.gms.auth.NO_IMPL");
    AppMethodBeat.o(88332);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzi
 * JD-Core Version:    0.7.0.1
 */
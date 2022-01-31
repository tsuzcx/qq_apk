package com.google.android.gms.auth.api.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzaax;
import com.google.android.gms.internal.zzabk;
import com.google.android.gms.internal.zzacm;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class zze
{
  private static zzacm zzakx = new zzacm("GoogleSignInCommon", new String[0]);
  
  public static GoogleSignInResult getSignInResultFromIntent(Intent paramIntent)
  {
    if ((paramIntent == null) || ((!paramIntent.hasExtra("googleSignInStatus")) && (!paramIntent.hasExtra("googleSignInAccount")))) {
      return null;
    }
    GoogleSignInAccount localGoogleSignInAccount = (GoogleSignInAccount)paramIntent.getParcelableExtra("googleSignInAccount");
    paramIntent = (Status)paramIntent.getParcelableExtra("googleSignInStatus");
    if (localGoogleSignInAccount != null) {
      paramIntent = Status.zzazx;
    }
    return new GoogleSignInResult(localGoogleSignInAccount, paramIntent);
  }
  
  public static Intent zza(Context paramContext, GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzakx.zzb("GoogleSignInCommon", new Object[] { "getSignInIntent()" });
    paramGoogleSignInOptions = new SignInConfiguration(paramContext.getPackageName(), paramGoogleSignInOptions);
    Intent localIntent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
    localIntent.setClass(paramContext, SignInHubActivity.class);
    localIntent.putExtra("config", paramGoogleSignInOptions);
    return localIntent;
  }
  
  static GoogleSignInResult zza(zzn paramzzn, GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzakx.zzb("GoogleSignInCommon", new Object[] { "getEligibleSavedSignInResult()" });
    zzac.zzw(paramGoogleSignInOptions);
    GoogleSignInOptions localGoogleSignInOptions = paramzzn.zzrC();
    if (localGoogleSignInOptions == null) {}
    do
    {
      do
      {
        return null;
      } while ((!zza(localGoogleSignInOptions.getAccount(), paramGoogleSignInOptions.getAccount())) || (paramGoogleSignInOptions.zzrk()) || ((paramGoogleSignInOptions.isIdTokenRequested()) && ((!localGoogleSignInOptions.isIdTokenRequested()) || (!paramGoogleSignInOptions.getServerClientId().equals(localGoogleSignInOptions.getServerClientId())))) || (!new HashSet(localGoogleSignInOptions.zzrj()).containsAll(new HashSet(paramGoogleSignInOptions.zzrj()))));
      paramzzn = paramzzn.zzrB();
    } while ((paramzzn == null) || (paramzzn.zza()));
    return new GoogleSignInResult(paramzzn, Status.zzazx);
  }
  
  public static OptionalPendingResult<GoogleSignInResult> zza(GoogleApiClient paramGoogleApiClient, Context paramContext, GoogleSignInOptions paramGoogleSignInOptions)
  {
    paramContext = zzn.zzas(paramContext);
    GoogleSignInResult localGoogleSignInResult = zza(paramContext, paramGoogleSignInOptions);
    if (localGoogleSignInResult != null)
    {
      zzakx.zzb("GoogleSignInCommon", new Object[] { "Eligible saved sign in result found" });
      return PendingResults.zzb(localGoogleSignInResult, paramGoogleApiClient);
    }
    return zza(paramGoogleApiClient, paramContext, paramGoogleSignInOptions);
  }
  
  private static OptionalPendingResult<GoogleSignInResult> zza(GoogleApiClient paramGoogleApiClient, zzn paramzzn, GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzakx.zzb("GoogleSignInCommon", new Object[] { "trySilentSignIn()" });
    return new zzabk(paramGoogleApiClient.zza(new zze.1(paramGoogleApiClient, paramzzn, paramGoogleSignInOptions)));
  }
  
  public static PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, Context paramContext)
  {
    zzakx.zzb("GoogleSignInCommon", new Object[] { "Signing out" });
    zzar(paramContext);
    return paramGoogleApiClient.zzb(new zze.2(paramGoogleApiClient));
  }
  
  private static boolean zza(Account paramAccount1, Account paramAccount2)
  {
    if (paramAccount1 == null) {
      return paramAccount2 == null;
    }
    return paramAccount1.equals(paramAccount2);
  }
  
  private static void zzar(Context paramContext)
  {
    zzn.zzas(paramContext).zzrD();
    paramContext = GoogleApiClient.zzvm().iterator();
    while (paramContext.hasNext()) {
      ((GoogleApiClient)paramContext.next()).zzvn();
    }
    zzaax.zzwx();
  }
  
  public static PendingResult<Status> zzb(GoogleApiClient paramGoogleApiClient, Context paramContext)
  {
    zzakx.zzb("GoogleSignInCommon", new Object[] { "Revoking access" });
    zzar(paramContext);
    return paramGoogleApiClient.zzb(new zze.3(paramGoogleApiClient));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zze
 * JD-Core Version:    0.7.0.1
 */
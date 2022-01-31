package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzf.zzi;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.internal.zzr;

public class zzbat
  extends zzl<zzbaq>
  implements zzbai
{
  private final zzg zzaAL;
  private Integer zzaFD;
  private final Bundle zzbEl;
  private final boolean zzbEw;
  
  public zzbat(Context paramContext, Looper paramLooper, boolean paramBoolean, zzg paramzzg, Bundle paramBundle, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 44, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzbEw = paramBoolean;
    this.zzaAL = paramzzg;
    this.zzbEl = paramBundle;
    this.zzaFD = paramzzg.zzxS();
  }
  
  public zzbat(Context paramContext, Looper paramLooper, boolean paramBoolean, zzg paramzzg, zzbaj paramzzbaj, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, paramBoolean, paramzzg, zza(paramzzg), paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  private zzad zzPR()
  {
    Account localAccount = this.zzaAL.zzxB();
    GoogleSignInAccount localGoogleSignInAccount = null;
    if ("<<default account>>".equals(localAccount.name)) {
      localGoogleSignInAccount = zzn.zzas(getContext()).zzrB();
    }
    return new zzad(localAccount, this.zzaFD.intValue(), localGoogleSignInAccount);
  }
  
  public static Bundle zza(zzg paramzzg)
  {
    zzbaj localzzbaj = paramzzg.zzxR();
    Integer localInteger = paramzzg.zzxS();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", paramzzg.getAccount());
    if (localInteger != null) {
      localBundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", localInteger.intValue());
    }
    if (localzzbaj != null)
    {
      localBundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", localzzbaj.zzPJ());
      localBundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", localzzbaj.isIdTokenRequested());
      localBundle.putString("com.google.android.gms.signin.internal.serverClientId", localzzbaj.getServerClientId());
      localBundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
      localBundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", localzzbaj.zzrl());
      localBundle.putString("com.google.android.gms.signin.internal.hostedDomain", localzzbaj.zzrm());
      localBundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", localzzbaj.zzPK());
      if (localzzbaj.zzPL() != null) {
        localBundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", localzzbaj.zzPL().longValue());
      }
      if (localzzbaj.zzPM() != null) {
        localBundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", localzzbaj.zzPM().longValue());
      }
    }
    return localBundle;
  }
  
  public void connect()
  {
    zza(new zzf.zzi(this));
  }
  
  public void zzPI()
  {
    try
    {
      ((zzbaq)zzxD()).zznv(this.zzaFD.intValue());
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
  
  public void zza(zzr paramzzr, boolean paramBoolean)
  {
    try
    {
      ((zzbaq)zzxD()).zza(paramzzr, this.zzaFD.intValue(), paramBoolean);
      return;
    }
    catch (RemoteException paramzzr) {}
  }
  
  public void zza(zzbap paramzzbap)
  {
    zzac.zzb(paramzzbap, "Expecting a valid ISignInCallbacks");
    try
    {
      zzad localzzad = zzPR();
      ((zzbaq)zzxD()).zza(new zzbau(localzzad), paramzzbap);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      try
      {
        paramzzbap.zzb(new zzbaw(8));
        return;
      }
      catch (RemoteException paramzzbap)
      {
        Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", localRemoteException);
      }
    }
  }
  
  protected String zzeA()
  {
    return "com.google.android.gms.signin.internal.ISignInService";
  }
  
  protected String zzez()
  {
    return "com.google.android.gms.signin.service.START";
  }
  
  protected zzbaq zzfg(IBinder paramIBinder)
  {
    return zzbaq.zza.zzff(paramIBinder);
  }
  
  protected Bundle zzqL()
  {
    String str = this.zzaAL.zzxO();
    if (!getContext().getPackageName().equals(str)) {
      this.zzbEl.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zzaAL.zzxO());
    }
    return this.zzbEl;
  }
  
  public boolean zzrd()
  {
    return this.zzbEw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzbat
 * JD-Core Version:    0.7.0.1
 */
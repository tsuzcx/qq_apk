package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BaseGmsClient.LegacyClientCallbackAdapter;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SignInClientImpl
  extends GmsClient<ISignInService>
  implements SignInClient
{
  public static final String ACTION_START_SERVICE = "com.google.android.gms.signin.service.START";
  public static final String INTERNAL_ACTION_START_SERVICE = "com.google.android.gms.signin.service.INTERNAL_START";
  public static final String KEY_AUTH_API_SIGN_IN_MODULE_VERSION = "com.google.android.gms.signin.internal.authApiSignInModuleVersion";
  public static final String KEY_CLIENT_REQUESTED_ACCOUNT = "com.google.android.gms.signin.internal.clientRequestedAccount";
  public static final String KEY_FORCE_CODE_FOR_REFRESH_TOKEN = "com.google.android.gms.signin.internal.forceCodeForRefreshToken";
  public static final String KEY_HOSTED_DOMAIN = "com.google.android.gms.signin.internal.hostedDomain";
  public static final String KEY_ID_TOKEN_REQUESTED = "com.google.android.gms.signin.internal.idTokenRequested";
  @Deprecated
  public static final String KEY_OFFLINE_ACCESS_CALLBACKS = "com.google.android.gms.signin.internal.signInCallbacks";
  public static final String KEY_OFFLINE_ACCESS_REQUESTED = "com.google.android.gms.signin.internal.offlineAccessRequested";
  public static final String KEY_REAL_CLIENT_LIBRARY_VERSION = "com.google.android.gms.signin.internal.realClientLibraryVersion";
  public static final String KEY_REAL_CLIENT_PACKAGE_NAME = "com.google.android.gms.signin.internal.realClientPackageName";
  public static final String KEY_SERVER_CLIENT_ID = "com.google.android.gms.signin.internal.serverClientId";
  public static final String KEY_USE_PROMPT_MODE_FOR_AUTH_CODE = "com.google.android.gms.signin.internal.usePromptModeForAuthCode";
  public static final String KEY_WAIT_FOR_ACCESS_TOKEN_REFRESH = "com.google.android.gms.signin.internal.waitForAccessTokenRefresh";
  private final Bundle zzada;
  private final boolean zzads;
  private final ClientSettings zzgf;
  private Integer zzsc;
  
  public SignInClientImpl(Context paramContext, Looper paramLooper, boolean paramBoolean, ClientSettings paramClientSettings, Bundle paramBundle, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 44, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    AppMethodBeat.i(12179);
    this.zzads = paramBoolean;
    this.zzgf = paramClientSettings;
    this.zzada = paramBundle;
    this.zzsc = paramClientSettings.getClientSessionId();
    AppMethodBeat.o(12179);
  }
  
  public SignInClientImpl(Context paramContext, Looper paramLooper, boolean paramBoolean, ClientSettings paramClientSettings, SignInOptions paramSignInOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, paramBoolean, paramClientSettings, createBundleFromClientSettings(paramClientSettings), paramConnectionCallbacks, paramOnConnectionFailedListener);
    AppMethodBeat.i(12180);
    AppMethodBeat.o(12180);
  }
  
  public static Bundle createBundleFromClientSettings(ClientSettings paramClientSettings)
  {
    AppMethodBeat.i(12187);
    SignInOptions localSignInOptions = paramClientSettings.getSignInOptions();
    Integer localInteger = paramClientSettings.getClientSessionId();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", paramClientSettings.getAccount());
    if (localInteger != null) {
      localBundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", localInteger.intValue());
    }
    if (localSignInOptions != null)
    {
      localBundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", localSignInOptions.isOfflineAccessRequested());
      localBundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", localSignInOptions.isIdTokenRequested());
      localBundle.putString("com.google.android.gms.signin.internal.serverClientId", localSignInOptions.getServerClientId());
      localBundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
      localBundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", localSignInOptions.isForceCodeForRefreshToken());
      localBundle.putString("com.google.android.gms.signin.internal.hostedDomain", localSignInOptions.getHostedDomain());
      localBundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", localSignInOptions.waitForAccessTokenRefresh());
      if (localSignInOptions.getAuthApiSignInModuleVersion() != null) {
        localBundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", localSignInOptions.getAuthApiSignInModuleVersion().longValue());
      }
      if (localSignInOptions.getRealClientLibraryVersion() != null) {
        localBundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", localSignInOptions.getRealClientLibraryVersion().longValue());
      }
    }
    AppMethodBeat.o(12187);
    return localBundle;
  }
  
  public void clearAccountFromSessionStore()
  {
    AppMethodBeat.i(12182);
    try
    {
      ((ISignInService)getService()).clearAccountFromSessionStore(this.zzsc.intValue());
      AppMethodBeat.o(12182);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(12182);
    }
  }
  
  public void connect()
  {
    AppMethodBeat.i(12186);
    connect(new BaseGmsClient.LegacyClientCallbackAdapter(this));
    AppMethodBeat.o(12186);
  }
  
  protected ISignInService createServiceInterface(IBinder paramIBinder)
  {
    AppMethodBeat.i(12184);
    paramIBinder = ISignInService.Stub.asInterface(paramIBinder);
    AppMethodBeat.o(12184);
    return paramIBinder;
  }
  
  public Bundle getGetServiceRequestExtraArgs()
  {
    AppMethodBeat.i(12185);
    Object localObject = this.zzgf.getRealClientPackageName();
    if (!getContext().getPackageName().equals(localObject)) {
      this.zzada.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zzgf.getRealClientPackageName());
    }
    localObject = this.zzada;
    AppMethodBeat.o(12185);
    return localObject;
  }
  
  public int getMinApkVersion()
  {
    return 12451000;
  }
  
  public String getServiceDescriptor()
  {
    return "com.google.android.gms.signin.internal.ISignInService";
  }
  
  public String getStartServiceAction()
  {
    return "com.google.android.gms.signin.service.START";
  }
  
  public boolean requiresSignIn()
  {
    return this.zzads;
  }
  
  public void saveDefaultAccount(IAccountAccessor paramIAccountAccessor, boolean paramBoolean)
  {
    AppMethodBeat.i(12181);
    try
    {
      ((ISignInService)getService()).saveDefaultAccountToSharedPref(paramIAccountAccessor, this.zzsc.intValue(), paramBoolean);
      AppMethodBeat.o(12181);
      return;
    }
    catch (RemoteException paramIAccountAccessor)
    {
      AppMethodBeat.o(12181);
    }
  }
  
  public void signIn(ISignInCallbacks paramISignInCallbacks)
  {
    AppMethodBeat.i(12183);
    Preconditions.checkNotNull(paramISignInCallbacks, "Expecting a valid ISignInCallbacks");
    try
    {
      Account localAccount = this.zzgf.getAccountOrDefault();
      Object localObject = null;
      if ("<<default account>>".equals(localAccount.name)) {
        localObject = Storage.getInstance(getContext()).getSavedDefaultGoogleSignInAccount();
      }
      localObject = new ResolveAccountRequest(localAccount, this.zzsc.intValue(), (GoogleSignInAccount)localObject);
      ((ISignInService)getService()).signIn(new SignInRequest((ResolveAccountRequest)localObject), paramISignInCallbacks);
      AppMethodBeat.o(12183);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      try
      {
        paramISignInCallbacks.onSignInComplete(new SignInResponse(8));
        AppMethodBeat.o(12183);
        return;
      }
      catch (RemoteException paramISignInCallbacks)
      {
        Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", localRemoteException);
        AppMethodBeat.o(12183);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.signin.internal.SignInClientImpl
 * JD-Core Version:    0.7.0.1
 */
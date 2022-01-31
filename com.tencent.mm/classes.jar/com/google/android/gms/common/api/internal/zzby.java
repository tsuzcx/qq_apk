package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignIn;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.BaseSignInCallbacks;
import com.google.android.gms.signin.internal.SignInResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public final class zzby
  extends BaseSignInCallbacks
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private static Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> zzlv = SignIn.CLIENT_BUILDER;
  private final Context mContext;
  private final Handler mHandler;
  private Set<Scope> mScopes;
  private final Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> zzby;
  private ClientSettings zzgf;
  private SignInClient zzhn;
  private zzcb zzlw;
  
  public zzby(Context paramContext, Handler paramHandler, ClientSettings paramClientSettings)
  {
    this(paramContext, paramHandler, paramClientSettings, zzlv);
  }
  
  public zzby(Context paramContext, Handler paramHandler, ClientSettings paramClientSettings, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> paramAbstractClientBuilder)
  {
    AppMethodBeat.i(60864);
    this.mContext = paramContext;
    this.mHandler = paramHandler;
    this.zzgf = ((ClientSettings)Preconditions.checkNotNull(paramClientSettings, "ClientSettings must not be null"));
    this.mScopes = paramClientSettings.getRequiredScopes();
    this.zzby = paramAbstractClientBuilder;
    AppMethodBeat.o(60864);
  }
  
  private final void zzb(SignInResponse paramSignInResponse)
  {
    AppMethodBeat.i(60871);
    Object localObject = paramSignInResponse.getConnectionResult();
    if (((ConnectionResult)localObject).isSuccess())
    {
      localObject = paramSignInResponse.getResolveAccountResponse();
      paramSignInResponse = ((ResolveAccountResponse)localObject).getConnectionResult();
      if (!paramSignInResponse.isSuccess())
      {
        localObject = String.valueOf(paramSignInResponse);
        Log.wtf("SignInCoordinator", String.valueOf(localObject).length() + 48 + "Sign-in succeeded with resolve account failure: " + (String)localObject, new Exception());
        this.zzlw.zzg(paramSignInResponse);
        this.zzhn.disconnect();
        AppMethodBeat.o(60871);
        return;
      }
      this.zzlw.zza(((ResolveAccountResponse)localObject).getAccountAccessor(), this.mScopes);
    }
    for (;;)
    {
      this.zzhn.disconnect();
      AppMethodBeat.o(60871);
      return;
      this.zzlw.zzg((ConnectionResult)localObject);
    }
  }
  
  public final void onConnected(Bundle paramBundle)
  {
    AppMethodBeat.i(60867);
    this.zzhn.signIn(this);
    AppMethodBeat.o(60867);
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    AppMethodBeat.i(60869);
    this.zzlw.zzg(paramConnectionResult);
    AppMethodBeat.o(60869);
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    AppMethodBeat.i(60868);
    this.zzhn.disconnect();
    AppMethodBeat.o(60868);
  }
  
  public final void onSignInComplete(SignInResponse paramSignInResponse)
  {
    AppMethodBeat.i(60870);
    this.mHandler.post(new zzca(this, paramSignInResponse));
    AppMethodBeat.o(60870);
  }
  
  public final void zza(zzcb paramzzcb)
  {
    AppMethodBeat.i(60865);
    if (this.zzhn != null) {
      this.zzhn.disconnect();
    }
    this.zzgf.setClientSessionId(Integer.valueOf(System.identityHashCode(this)));
    this.zzhn = ((SignInClient)this.zzby.buildClient(this.mContext, this.mHandler.getLooper(), this.zzgf, this.zzgf.getSignInOptions(), this, this));
    this.zzlw = paramzzcb;
    if ((this.mScopes == null) || (this.mScopes.isEmpty()))
    {
      this.mHandler.post(new zzbz(this));
      AppMethodBeat.o(60865);
      return;
    }
    this.zzhn.connect();
    AppMethodBeat.o(60865);
  }
  
  public final SignInClient zzbt()
  {
    return this.zzhn;
  }
  
  public final void zzbz()
  {
    AppMethodBeat.i(60866);
    if (this.zzhn != null) {
      this.zzhn.disconnect();
    }
    AppMethodBeat.o(60866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzby
 * JD-Core Version:    0.7.0.1
 */
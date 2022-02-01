package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;

public final class zzh
  extends GmsClient<zzv>
{
  private final GoogleSignInOptions zzev;
  
  public zzh(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, GoogleSignInOptions paramGoogleSignInOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 91, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    AppMethodBeat.i(88327);
    if (paramGoogleSignInOptions != null) {}
    for (;;)
    {
      paramContext = paramGoogleSignInOptions;
      if (paramClientSettings.getAllRequestedScopes().isEmpty()) {
        break label108;
      }
      paramContext = new GoogleSignInOptions.Builder(paramGoogleSignInOptions);
      paramLooper = paramClientSettings.getAllRequestedScopes().iterator();
      while (paramLooper.hasNext()) {
        paramContext.requestScopes((Scope)paramLooper.next(), new Scope[0]);
      }
      paramGoogleSignInOptions = new GoogleSignInOptions.Builder().build();
    }
    paramContext = paramContext.build();
    label108:
    this.zzev = paramContext;
    AppMethodBeat.o(88327);
  }
  
  public final int getMinApkVersion()
  {
    return 12451000;
  }
  
  public final String getServiceDescriptor()
  {
    return "com.google.android.gms.auth.api.signin.internal.ISignInService";
  }
  
  public final Intent getSignInIntent()
  {
    AppMethodBeat.i(88328);
    Intent localIntent = zzi.zzd(getContext(), this.zzev);
    AppMethodBeat.o(88328);
    return localIntent;
  }
  
  public final String getStartServiceAction()
  {
    return "com.google.android.gms.auth.api.signin.service.START";
  }
  
  public final boolean providesSignIn()
  {
    return true;
  }
  
  public final GoogleSignInOptions zzn()
  {
    return this.zzev;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzh
 * JD-Core Version:    0.7.0.1
 */
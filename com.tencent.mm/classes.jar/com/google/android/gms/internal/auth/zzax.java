package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzax
  extends GmsClient<zzbc>
{
  private final Auth.AuthCredentialsOptions zzdv;
  
  public zzax(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, Auth.AuthCredentialsOptions paramAuthCredentialsOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 68, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzdv = paramAuthCredentialsOptions;
  }
  
  public final Bundle getGetServiceRequestExtraArgs()
  {
    AppMethodBeat.i(88381);
    if (this.zzdv == null)
    {
      localBundle = new Bundle();
      AppMethodBeat.o(88381);
      return localBundle;
    }
    Bundle localBundle = this.zzdv.toBundle();
    AppMethodBeat.o(88381);
    return localBundle;
  }
  
  public final int getMinApkVersion()
  {
    return 12451000;
  }
  
  public final String getServiceDescriptor()
  {
    return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
  }
  
  public final String getStartServiceAction()
  {
    return "com.google.android.gms.auth.api.credentials.service.START";
  }
  
  final Auth.AuthCredentialsOptions zzk()
  {
    return this.zzdv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzax
 * JD-Core Version:    0.7.0.1
 */
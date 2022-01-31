package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.auth.api.accounttransfer.zzq;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzx
  extends GmsClient<zzac>
{
  private final Bundle zzcf;
  
  public zzx(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, zzq paramzzq, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 128, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    AppMethodBeat.i(77153);
    if (paramzzq == null)
    {
      this.zzcf = new Bundle();
      AppMethodBeat.o(77153);
      return;
    }
    paramContext = new NoSuchMethodError();
    AppMethodBeat.o(77153);
    throw paramContext;
  }
  
  public final Bundle getGetServiceRequestExtraArgs()
  {
    return this.zzcf;
  }
  
  public final int getMinApkVersion()
  {
    return 12451000;
  }
  
  public final String getServiceDescriptor()
  {
    return "com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferService";
  }
  
  public final String getStartServiceAction()
  {
    return "com.google.android.gms.auth.api.accounttransfer.service.START";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzx
 * JD-Core Version:    0.7.0.1
 */
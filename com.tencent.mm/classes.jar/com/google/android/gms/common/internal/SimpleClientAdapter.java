package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.SimpleClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SimpleClientAdapter<T extends IInterface>
  extends GmsClient<T>
{
  private final Api.SimpleClient<T> zzva;
  
  public SimpleClientAdapter(Context paramContext, Looper paramLooper, int paramInt, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, ClientSettings paramClientSettings, Api.SimpleClient<T> paramSimpleClient)
  {
    super(paramContext, paramLooper, paramInt, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzva = paramSimpleClient;
  }
  
  protected T createServiceInterface(IBinder paramIBinder)
  {
    AppMethodBeat.i(11880);
    paramIBinder = this.zzva.createServiceInterface(paramIBinder);
    AppMethodBeat.o(11880);
    return paramIBinder;
  }
  
  public Api.SimpleClient<T> getClient()
  {
    return this.zzva;
  }
  
  public int getMinApkVersion()
  {
    AppMethodBeat.i(11882);
    int i = super.getMinApkVersion();
    AppMethodBeat.o(11882);
    return i;
  }
  
  protected String getServiceDescriptor()
  {
    AppMethodBeat.i(11879);
    String str = this.zzva.getServiceDescriptor();
    AppMethodBeat.o(11879);
    return str;
  }
  
  protected String getStartServiceAction()
  {
    AppMethodBeat.i(11878);
    String str = this.zzva.getStartServiceAction();
    AppMethodBeat.o(11878);
    return str;
  }
  
  protected void onSetConnectState(int paramInt, T paramT)
  {
    AppMethodBeat.i(11881);
    this.zzva.setState(paramInt, paramT);
    AppMethodBeat.o(11881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.SimpleClientAdapter
 * JD-Core Version:    0.7.0.1
 */
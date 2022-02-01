package com.google.android.gms.common.internal.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CommonClient
  extends GmsClient<ICommonService>
{
  public static final String START_SERVICE_ACTION = "com.google.android.gms.common.service.START";
  
  public CommonClient(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 39, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  protected ICommonService createServiceInterface(IBinder paramIBinder)
  {
    AppMethodBeat.i(11886);
    paramIBinder = ICommonService.Stub.asInterface(paramIBinder);
    AppMethodBeat.o(11886);
    return paramIBinder;
  }
  
  public int getMinApkVersion()
  {
    AppMethodBeat.i(11887);
    int i = super.getMinApkVersion();
    AppMethodBeat.o(11887);
    return i;
  }
  
  public String getServiceDescriptor()
  {
    return "com.google.android.gms.common.internal.service.ICommonService";
  }
  
  public String getStartServiceAction()
  {
    return "com.google.android.gms.common.service.START";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.service.CommonClient
 * JD-Core Version:    0.7.0.1
 */
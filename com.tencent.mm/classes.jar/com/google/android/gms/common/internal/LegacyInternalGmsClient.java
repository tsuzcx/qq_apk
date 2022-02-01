package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IInterface;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

@Deprecated
public abstract class LegacyInternalGmsClient<T extends IInterface>
  extends GmsClient<T>
{
  private final GmsClientEventManager zzie = new GmsClientEventManager(paramContext.getMainLooper(), this);
  
  public LegacyInternalGmsClient(Context paramContext, int paramInt, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramContext.getMainLooper(), paramInt, paramClientSettings);
    this.zzie.registerConnectionCallbacks(paramConnectionCallbacks);
    this.zzie.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void checkAvailabilityAndConnect()
  {
    this.zzie.enableCallbacks();
    super.checkAvailabilityAndConnect();
  }
  
  public void disconnect()
  {
    this.zzie.disableCallbacks();
    super.disconnect();
  }
  
  public int getMinApkVersion()
  {
    return super.getMinApkVersion();
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.zzie.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.zzie.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  public void onConnectedLocked(T paramT)
  {
    super.onConnectedLocked(paramT);
    this.zzie.onConnectionSuccess(getConnectionHint());
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    super.onConnectionFailed(paramConnectionResult);
    this.zzie.onConnectionFailure(paramConnectionResult);
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    super.onConnectionSuspended(paramInt);
    this.zzie.onUnintentionalDisconnection(paramInt);
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.zzie.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.zzie.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.zzie.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.zzie.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.LegacyInternalGmsClient
 * JD-Core Version:    0.7.0.1
 */
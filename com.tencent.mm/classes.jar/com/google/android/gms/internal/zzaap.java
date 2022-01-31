package com.google.android.gms.internal;

import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class zzaap
  extends GoogleApiClient
{
  private final UnsupportedOperationException zzaBj;
  
  public zzaap(String paramString)
  {
    this.zzaBj = new UnsupportedOperationException(paramString);
  }
  
  public ConnectionResult blockingConnect()
  {
    throw this.zzaBj;
  }
  
  public ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    throw this.zzaBj;
  }
  
  public PendingResult<Status> clearDefaultAccountAndReconnect()
  {
    throw this.zzaBj;
  }
  
  public void connect()
  {
    throw this.zzaBj;
  }
  
  public void disconnect()
  {
    throw this.zzaBj;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    throw this.zzaBj;
  }
  
  public ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    throw this.zzaBj;
  }
  
  public boolean hasConnectedApi(Api<?> paramApi)
  {
    throw this.zzaBj;
  }
  
  public boolean isConnected()
  {
    throw this.zzaBj;
  }
  
  public boolean isConnecting()
  {
    throw this.zzaBj;
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    throw this.zzaBj;
  }
  
  public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    throw this.zzaBj;
  }
  
  public void reconnect()
  {
    throw this.zzaBj;
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    throw this.zzaBj;
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    throw this.zzaBj;
  }
  
  public void stopAutoManage(FragmentActivity paramFragmentActivity)
  {
    throw this.zzaBj;
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    throw this.zzaBj;
  }
  
  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    throw this.zzaBj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzaap
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.common.api.internal;

import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class zzaf
  extends GoogleApiClient
{
  private final String zzhe;
  
  public zzaf(String paramString)
  {
    this.zzhe = paramString;
  }
  
  public ConnectionResult blockingConnect()
  {
    AppMethodBeat.i(60697);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(60697);
    throw localUnsupportedOperationException;
  }
  
  public ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(60698);
    paramTimeUnit = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(60698);
    throw paramTimeUnit;
  }
  
  public PendingResult<Status> clearDefaultAccountAndReconnect()
  {
    AppMethodBeat.i(60701);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(60701);
    throw localUnsupportedOperationException;
  }
  
  public void connect()
  {
    AppMethodBeat.i(60696);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(60696);
    throw localUnsupportedOperationException;
  }
  
  public void disconnect()
  {
    AppMethodBeat.i(60699);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(60699);
    throw localUnsupportedOperationException;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    AppMethodBeat.i(60711);
    paramString = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(60711);
    throw paramString;
  }
  
  public ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    AppMethodBeat.i(60695);
    paramApi = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(60695);
    throw paramApi;
  }
  
  public boolean hasConnectedApi(Api<?> paramApi)
  {
    AppMethodBeat.i(60694);
    paramApi = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(60694);
    throw paramApi;
  }
  
  public boolean isConnected()
  {
    AppMethodBeat.i(60703);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(60703);
    throw localUnsupportedOperationException;
  }
  
  public boolean isConnecting()
  {
    AppMethodBeat.i(60704);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(60704);
    throw localUnsupportedOperationException;
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    AppMethodBeat.i(60706);
    paramConnectionCallbacks = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(60706);
    throw paramConnectionCallbacks;
  }
  
  public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    AppMethodBeat.i(60709);
    paramOnConnectionFailedListener = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(60709);
    throw paramOnConnectionFailedListener;
  }
  
  public void reconnect()
  {
    AppMethodBeat.i(60700);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(60700);
    throw localUnsupportedOperationException;
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    AppMethodBeat.i(60705);
    paramConnectionCallbacks = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(60705);
    throw paramConnectionCallbacks;
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    AppMethodBeat.i(60708);
    paramOnConnectionFailedListener = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(60708);
    throw paramOnConnectionFailedListener;
  }
  
  public void stopAutoManage(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(60702);
    paramFragmentActivity = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(60702);
    throw paramFragmentActivity;
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    AppMethodBeat.i(60707);
    paramConnectionCallbacks = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(60707);
    throw paramConnectionCallbacks;
  }
  
  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    AppMethodBeat.i(60710);
    paramOnConnectionFailedListener = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(60710);
    throw paramOnConnectionFailedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzaf
 * JD-Core Version:    0.7.0.1
 */
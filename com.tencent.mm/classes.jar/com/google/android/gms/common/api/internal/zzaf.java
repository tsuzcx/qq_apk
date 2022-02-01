package com.google.android.gms.common.api.internal;

import androidx.fragment.app.FragmentActivity;
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
    AppMethodBeat.i(11189);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(11189);
    throw localUnsupportedOperationException;
  }
  
  public ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(11190);
    paramTimeUnit = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(11190);
    throw paramTimeUnit;
  }
  
  public PendingResult<Status> clearDefaultAccountAndReconnect()
  {
    AppMethodBeat.i(11193);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(11193);
    throw localUnsupportedOperationException;
  }
  
  public void connect()
  {
    AppMethodBeat.i(11188);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(11188);
    throw localUnsupportedOperationException;
  }
  
  public void disconnect()
  {
    AppMethodBeat.i(11191);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(11191);
    throw localUnsupportedOperationException;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    AppMethodBeat.i(11203);
    paramString = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(11203);
    throw paramString;
  }
  
  public ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    AppMethodBeat.i(11187);
    paramApi = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(11187);
    throw paramApi;
  }
  
  public boolean hasConnectedApi(Api<?> paramApi)
  {
    AppMethodBeat.i(11186);
    paramApi = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(11186);
    throw paramApi;
  }
  
  public boolean isConnected()
  {
    AppMethodBeat.i(11195);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(11195);
    throw localUnsupportedOperationException;
  }
  
  public boolean isConnecting()
  {
    AppMethodBeat.i(11196);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(11196);
    throw localUnsupportedOperationException;
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    AppMethodBeat.i(11198);
    paramConnectionCallbacks = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(11198);
    throw paramConnectionCallbacks;
  }
  
  public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    AppMethodBeat.i(11201);
    paramOnConnectionFailedListener = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(11201);
    throw paramOnConnectionFailedListener;
  }
  
  public void reconnect()
  {
    AppMethodBeat.i(11192);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(11192);
    throw localUnsupportedOperationException;
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    AppMethodBeat.i(11197);
    paramConnectionCallbacks = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(11197);
    throw paramConnectionCallbacks;
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    AppMethodBeat.i(11200);
    paramOnConnectionFailedListener = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(11200);
    throw paramOnConnectionFailedListener;
  }
  
  public void stopAutoManage(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(256937);
    paramFragmentActivity = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(256937);
    throw paramFragmentActivity;
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    AppMethodBeat.i(11199);
    paramConnectionCallbacks = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(11199);
    throw paramConnectionCallbacks;
  }
  
  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    AppMethodBeat.i(11202);
    paramOnConnectionFailedListener = new UnsupportedOperationException(this.zzhe);
    AppMethodBeat.o(11202);
    throw paramOnConnectionFailedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzaf
 * JD-Core Version:    0.7.0.1
 */
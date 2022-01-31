package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzaad.zza;
import com.google.android.gms.internal.zzabh;
import com.google.android.gms.internal.zzabq;
import com.google.android.gms.internal.zzabx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public abstract class GoogleApiClient
{
  public static final int SIGN_IN_MODE_OPTIONAL = 2;
  public static final int SIGN_IN_MODE_REQUIRED = 1;
  private static final Set<GoogleApiClient> zzazc = Collections.newSetFromMap(new WeakHashMap());
  
  public static void dumpAll(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    synchronized (zzazc)
    {
      String str = String.valueOf(paramString).concat("  ");
      Iterator localIterator = zzazc.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        GoogleApiClient localGoogleApiClient = (GoogleApiClient)localIterator.next();
        paramPrintWriter.append(paramString).append("GoogleApiClient#").println(i);
        localGoogleApiClient.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
      return;
    }
  }
  
  public static Set<GoogleApiClient> zzvm()
  {
    synchronized (zzazc)
    {
      Set localSet2 = zzazc;
      return localSet2;
    }
  }
  
  public abstract ConnectionResult blockingConnect();
  
  public abstract ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract PendingResult<Status> clearDefaultAccountAndReconnect();
  
  public abstract void connect();
  
  public void connect(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void disconnect();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract ConnectionResult getConnectionResult(Api<?> paramApi);
  
  public Context getContext()
  {
    throw new UnsupportedOperationException();
  }
  
  public Looper getLooper()
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean hasConnectedApi(Api<?> paramApi);
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public abstract void reconnect();
  
  public abstract void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public abstract void stopAutoManage(FragmentActivity paramFragmentActivity);
  
  public abstract void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public <C extends Api.zze> C zza(Api.zzc<C> paramzzc)
  {
    throw new UnsupportedOperationException();
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzaad.zza<R, A>> T zza(T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  public void zza(zzabx paramzzabx)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean zza(Api<?> paramApi)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean zza(zzabq paramzzabq)
  {
    throw new UnsupportedOperationException();
  }
  
  public <A extends Api.zzb, T extends zzaad.zza<? extends Result, A>> T zzb(T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  public void zzb(zzabx paramzzabx)
  {
    throw new UnsupportedOperationException();
  }
  
  public <L> zzabh<L> zzr(L paramL)
  {
    throw new UnsupportedOperationException();
  }
  
  public void zzvn()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.GoogleApiClient
 * JD-Core Version:    0.7.0.1
 */
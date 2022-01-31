package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzm
  implements Handler.Callback
{
  private final Handler mHandler;
  private final zzm.zza zzaFU;
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzaFV = new ArrayList();
  final ArrayList<GoogleApiClient.ConnectionCallbacks> zzaFW = new ArrayList();
  private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzaFX = new ArrayList();
  private volatile boolean zzaFY = false;
  private final AtomicInteger zzaFZ = new AtomicInteger(0);
  private boolean zzaGa = false;
  private final Object zzrJ = new Object();
  
  public zzm(Looper paramLooper, zzm.zza paramzza)
  {
    this.zzaFU = paramzza;
    this.mHandler = new Handler(paramLooper, this);
  }
  
  public final boolean handleMessage(Message arg1)
  {
    if (???.what == 1)
    {
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)???.obj;
      synchronized (this.zzrJ)
      {
        if ((this.zzaFY) && (this.zzaFU.isConnected()) && (this.zzaFV.contains(localConnectionCallbacks))) {
          localConnectionCallbacks.onConnected(this.zzaFU.zzuC());
        }
        return true;
      }
    }
    int i = ???.what;
    Log.wtf("GmsClientEvents", 45 + "Don't know how to handle message: " + i, new Exception());
    return false;
  }
  
  public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzac.zzw(paramConnectionCallbacks);
    synchronized (this.zzrJ)
    {
      boolean bool = this.zzaFV.contains(paramConnectionCallbacks);
      return bool;
    }
  }
  
  public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzac.zzw(paramOnConnectionFailedListener);
    synchronized (this.zzrJ)
    {
      boolean bool = this.zzaFX.contains(paramOnConnectionFailedListener);
      return bool;
    }
  }
  
  public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzac.zzw(paramConnectionCallbacks);
    synchronized (this.zzrJ)
    {
      if (this.zzaFV.contains(paramConnectionCallbacks))
      {
        String str = String.valueOf(paramConnectionCallbacks);
        new StringBuilder(String.valueOf(str).length() + 62).append("registerConnectionCallbacks(): listener ").append(str).append(" is already registered");
        if (this.zzaFU.isConnected()) {
          this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramConnectionCallbacks));
        }
        return;
      }
      this.zzaFV.add(paramConnectionCallbacks);
    }
  }
  
  public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzac.zzw(paramOnConnectionFailedListener);
    synchronized (this.zzrJ)
    {
      if (this.zzaFX.contains(paramOnConnectionFailedListener))
      {
        paramOnConnectionFailedListener = String.valueOf(paramOnConnectionFailedListener);
        new StringBuilder(String.valueOf(paramOnConnectionFailedListener).length() + 67).append("registerConnectionFailedListener(): listener ").append(paramOnConnectionFailedListener).append(" is already registered");
        return;
      }
      this.zzaFX.add(paramOnConnectionFailedListener);
    }
  }
  
  public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzac.zzw(paramConnectionCallbacks);
    synchronized (this.zzrJ)
    {
      if (!this.zzaFV.remove(paramConnectionCallbacks))
      {
        paramConnectionCallbacks = String.valueOf(paramConnectionCallbacks);
        new StringBuilder(String.valueOf(paramConnectionCallbacks).length() + 52).append("unregisterConnectionCallbacks(): listener ").append(paramConnectionCallbacks).append(" not found");
      }
      while (!this.zzaGa) {
        return;
      }
      this.zzaFW.add(paramConnectionCallbacks);
    }
  }
  
  public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzac.zzw(paramOnConnectionFailedListener);
    synchronized (this.zzrJ)
    {
      if (!this.zzaFX.remove(paramOnConnectionFailedListener))
      {
        paramOnConnectionFailedListener = String.valueOf(paramOnConnectionFailedListener);
        new StringBuilder(String.valueOf(paramOnConnectionFailedListener).length() + 57).append("unregisterConnectionFailedListener(): listener ").append(paramOnConnectionFailedListener).append(" not found");
      }
      return;
    }
  }
  
  public final void zzcV(int paramInt)
  {
    boolean bool = false;
    if (Looper.myLooper() == this.mHandler.getLooper()) {
      bool = true;
    }
    zzac.zza(bool, "onUnintentionalDisconnection must only be called on the Handler thread");
    this.mHandler.removeMessages(1);
    synchronized (this.zzrJ)
    {
      this.zzaGa = true;
      Object localObject2 = new ArrayList(this.zzaFV);
      int i = this.zzaFZ.get();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)((Iterator)localObject2).next();
        if ((this.zzaFY) && (this.zzaFZ.get() == i)) {
          if (this.zzaFV.contains(localConnectionCallbacks)) {
            localConnectionCallbacks.onConnectionSuspended(paramInt);
          }
        }
      }
    }
    this.zzaFW.clear();
    this.zzaGa = false;
  }
  
  public final void zzn(ConnectionResult paramConnectionResult)
  {
    if (Looper.myLooper() == this.mHandler.getLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zza(bool, "onConnectionFailure must only be called on the Handler thread");
      this.mHandler.removeMessages(1);
      synchronized (this.zzrJ)
      {
        Object localObject2 = new ArrayList(this.zzaFX);
        int i = this.zzaFZ.get();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          GoogleApiClient.OnConnectionFailedListener localOnConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener)((Iterator)localObject2).next();
          if ((!this.zzaFY) || (this.zzaFZ.get() != i)) {
            return;
          }
          if (this.zzaFX.contains(localOnConnectionFailedListener)) {
            localOnConnectionFailedListener.onConnectionFailed(paramConnectionResult);
          }
        }
      }
      return;
    }
  }
  
  public final void zzq(Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() == this.mHandler.getLooper())
    {
      bool1 = true;
      zzac.zza(bool1, "onConnectionSuccess must only be called on the Handler thread");
    }
    for (;;)
    {
      synchronized (this.zzrJ)
      {
        if (this.zzaGa) {
          break label190;
        }
        bool1 = true;
        zzac.zzaw(bool1);
        this.mHandler.removeMessages(1);
        this.zzaGa = true;
        if (this.zzaFW.size() != 0) {
          break label195;
        }
        bool1 = bool2;
        zzac.zzaw(bool1);
        Object localObject2 = new ArrayList(this.zzaFV);
        int i = this.zzaFZ.get();
        localObject2 = ((ArrayList)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label200;
        }
        GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)((Iterator)localObject2).next();
        if ((!this.zzaFY) || (!this.zzaFU.isConnected()) || (this.zzaFZ.get() != i)) {
          break label200;
        }
        if (this.zzaFW.contains(localConnectionCallbacks)) {
          continue;
        }
        localConnectionCallbacks.onConnected(paramBundle);
      }
      bool1 = false;
      break;
      label190:
      bool1 = false;
      continue;
      label195:
      bool1 = false;
    }
    label200:
    this.zzaFW.clear();
    this.zzaGa = false;
  }
  
  public final void zzxX()
  {
    this.zzaFY = false;
    this.zzaFZ.incrementAndGet();
  }
  
  public final void zzxY()
  {
    this.zzaFY = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzm
 * JD-Core Version:    0.7.0.1
 */
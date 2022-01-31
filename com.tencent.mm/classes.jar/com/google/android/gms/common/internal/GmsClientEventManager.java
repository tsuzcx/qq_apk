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
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class GmsClientEventManager
  implements Handler.Callback
{
  private final Handler mHandler;
  private final Object mLock;
  private final GmsClientEventState zztf;
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> zztg;
  @VisibleForTesting
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzth;
  private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzti;
  private volatile boolean zztj;
  private final AtomicInteger zztk;
  private boolean zztl;
  
  public GmsClientEventManager(Looper paramLooper, GmsClientEventState paramGmsClientEventState)
  {
    AppMethodBeat.i(61334);
    this.zztg = new ArrayList();
    this.zzth = new ArrayList();
    this.zzti = new ArrayList();
    this.zztj = false;
    this.zztk = new AtomicInteger(0);
    this.zztl = false;
    this.mLock = new Object();
    this.zztf = paramGmsClientEventState;
    this.mHandler = new Handler(paramLooper, this);
    AppMethodBeat.o(61334);
  }
  
  public final boolean areCallbacksEnabled()
  {
    return this.zztj;
  }
  
  public final void disableCallbacks()
  {
    AppMethodBeat.i(61335);
    this.zztj = false;
    this.zztk.incrementAndGet();
    AppMethodBeat.o(61335);
  }
  
  public final void enableCallbacks()
  {
    this.zztj = true;
  }
  
  public final boolean handleMessage(Message arg1)
  {
    AppMethodBeat.i(61346);
    if (???.what == 1)
    {
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)???.obj;
      synchronized (this.mLock)
      {
        if ((this.zztj) && (this.zztf.isConnected()) && (this.zztg.contains(localConnectionCallbacks))) {
          localConnectionCallbacks.onConnected(this.zztf.getConnectionHint());
        }
        AppMethodBeat.o(61346);
        return true;
      }
    }
    int i = ???.what;
    Log.wtf("GmsClientEvents", 45 + "Don't know how to handle message: " + i, new Exception());
    AppMethodBeat.o(61346);
    return false;
  }
  
  public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    AppMethodBeat.i(61341);
    Preconditions.checkNotNull(paramConnectionCallbacks);
    synchronized (this.mLock)
    {
      boolean bool = this.zztg.contains(paramConnectionCallbacks);
      AppMethodBeat.o(61341);
      return bool;
    }
  }
  
  public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    AppMethodBeat.i(61344);
    Preconditions.checkNotNull(paramOnConnectionFailedListener);
    synchronized (this.mLock)
    {
      boolean bool = this.zzti.contains(paramOnConnectionFailedListener);
      AppMethodBeat.o(61344);
      return bool;
    }
  }
  
  @VisibleForTesting
  public final void onConnectionFailure(ConnectionResult paramConnectionResult)
  {
    int i = 0;
    AppMethodBeat.i(61339);
    boolean bool;
    if (Looper.myLooper() == this.mHandler.getLooper()) {
      bool = true;
    }
    for (;;)
    {
      Preconditions.checkState(bool, "onConnectionFailure must only be called on the Handler thread");
      this.mHandler.removeMessages(1);
      synchronized (this.mLock)
      {
        ArrayList localArrayList = new ArrayList(this.zzti);
        int k = this.zztk.get();
        localArrayList = (ArrayList)localArrayList;
        int m = localArrayList.size();
        for (;;)
        {
          if (i < m)
          {
            Object localObject2 = localArrayList.get(i);
            int j = i + 1;
            localObject2 = (GoogleApiClient.OnConnectionFailedListener)localObject2;
            if ((!this.zztj) || (this.zztk.get() != k))
            {
              AppMethodBeat.o(61339);
              return;
              bool = false;
              break;
            }
            i = j;
            if (this.zzti.contains(localObject2))
            {
              ((GoogleApiClient.OnConnectionFailedListener)localObject2).onConnectionFailed(paramConnectionResult);
              i = j;
            }
          }
        }
      }
    }
    AppMethodBeat.o(61339);
  }
  
  @VisibleForTesting
  protected final void onConnectionSuccess()
  {
    AppMethodBeat.i(61336);
    synchronized (this.mLock)
    {
      onConnectionSuccess(this.zztf.getConnectionHint());
      AppMethodBeat.o(61336);
      return;
    }
  }
  
  @VisibleForTesting
  public final void onConnectionSuccess(Bundle paramBundle)
  {
    boolean bool2 = true;
    int i = 0;
    AppMethodBeat.i(61337);
    boolean bool1;
    if (Looper.myLooper() == this.mHandler.getLooper())
    {
      bool1 = true;
      Preconditions.checkState(bool1, "onConnectionSuccess must only be called on the Handler thread");
    }
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.zztl) {
          break label225;
        }
        bool1 = true;
        Preconditions.checkState(bool1);
        this.mHandler.removeMessages(1);
        this.zztl = true;
        if (this.zzth.size() != 0) {
          break label231;
        }
        bool1 = bool2;
        Preconditions.checkState(bool1);
        ArrayList localArrayList = new ArrayList(this.zztg);
        int k = this.zztk.get();
        localArrayList = (ArrayList)localArrayList;
        int m = localArrayList.size();
        if (i >= m) {
          break label237;
        }
        Object localObject2 = localArrayList.get(i);
        int j = i + 1;
        localObject2 = (GoogleApiClient.ConnectionCallbacks)localObject2;
        if ((!this.zztj) || (!this.zztf.isConnected()) || (this.zztk.get() != k)) {
          break label237;
        }
        i = j;
        if (this.zzth.contains(localObject2)) {
          continue;
        }
        ((GoogleApiClient.ConnectionCallbacks)localObject2).onConnected(paramBundle);
        i = j;
      }
      bool1 = false;
      break;
      label225:
      bool1 = false;
      continue;
      label231:
      bool1 = false;
    }
    label237:
    this.zzth.clear();
    this.zztl = false;
    AppMethodBeat.o(61337);
  }
  
  @VisibleForTesting
  public final void onUnintentionalDisconnection(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(61338);
    if (Looper.myLooper() == this.mHandler.getLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "onUnintentionalDisconnection must only be called on the Handler thread");
      this.mHandler.removeMessages(1);
      synchronized (this.mLock)
      {
        this.zztl = true;
        ArrayList localArrayList = new ArrayList(this.zztg);
        int k = this.zztk.get();
        localArrayList = (ArrayList)localArrayList;
        int m = localArrayList.size();
        Object localObject3;
        int j;
        do
        {
          if (i >= m) {
            break;
          }
          localObject3 = localArrayList.get(i);
          j = i + 1;
          localObject3 = (GoogleApiClient.ConnectionCallbacks)localObject3;
          if ((!this.zztj) || (this.zztk.get() != k)) {
            break;
          }
          i = j;
        } while (!this.zztg.contains(localObject3));
        ((GoogleApiClient.ConnectionCallbacks)localObject3).onConnectionSuspended(paramInt);
        i = j;
      }
    }
    this.zzth.clear();
    this.zztl = false;
    AppMethodBeat.o(61338);
  }
  
  public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    AppMethodBeat.i(61340);
    Preconditions.checkNotNull(paramConnectionCallbacks);
    synchronized (this.mLock)
    {
      if (this.zztg.contains(paramConnectionCallbacks))
      {
        String str = String.valueOf(paramConnectionCallbacks);
        new StringBuilder(String.valueOf(str).length() + 62).append("registerConnectionCallbacks(): listener ").append(str).append(" is already registered");
        if (this.zztf.isConnected()) {
          this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramConnectionCallbacks));
        }
        AppMethodBeat.o(61340);
        return;
      }
      this.zztg.add(paramConnectionCallbacks);
    }
  }
  
  public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    AppMethodBeat.i(61343);
    Preconditions.checkNotNull(paramOnConnectionFailedListener);
    synchronized (this.mLock)
    {
      if (this.zzti.contains(paramOnConnectionFailedListener))
      {
        paramOnConnectionFailedListener = String.valueOf(paramOnConnectionFailedListener);
        new StringBuilder(String.valueOf(paramOnConnectionFailedListener).length() + 67).append("registerConnectionFailedListener(): listener ").append(paramOnConnectionFailedListener).append(" is already registered");
        AppMethodBeat.o(61343);
        return;
      }
      this.zzti.add(paramOnConnectionFailedListener);
    }
  }
  
  public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    AppMethodBeat.i(61342);
    Preconditions.checkNotNull(paramConnectionCallbacks);
    synchronized (this.mLock)
    {
      if (!this.zztg.remove(paramConnectionCallbacks))
      {
        paramConnectionCallbacks = String.valueOf(paramConnectionCallbacks);
        new StringBuilder(String.valueOf(paramConnectionCallbacks).length() + 52).append("unregisterConnectionCallbacks(): listener ").append(paramConnectionCallbacks).append(" not found");
      }
      while (!this.zztl)
      {
        AppMethodBeat.o(61342);
        return;
      }
      this.zzth.add(paramConnectionCallbacks);
    }
  }
  
  public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    AppMethodBeat.i(61345);
    Preconditions.checkNotNull(paramOnConnectionFailedListener);
    synchronized (this.mLock)
    {
      if (!this.zzti.remove(paramOnConnectionFailedListener))
      {
        paramOnConnectionFailedListener = String.valueOf(paramOnConnectionFailedListener);
        new StringBuilder(String.valueOf(paramOnConnectionFailedListener).length() + 57).append("unregisterConnectionFailedListener(): listener ").append(paramOnConnectionFailedListener).append(" not found");
      }
      AppMethodBeat.o(61345);
      return;
    }
  }
  
  @VisibleForTesting
  public static abstract interface GmsClientEventState
  {
    public abstract Bundle getConnectionHint();
    
    public abstract boolean isConnected();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.GmsClientEventManager
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zzbd
  implements zzbp, zzq
{
  private final Context mContext;
  private final Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> zzdh;
  final zzav zzfq;
  private final Lock zzga;
  private final ClientSettings zzgf;
  private final Map<Api<?>, Boolean> zzgi;
  private final GoogleApiAvailabilityLight zzgk;
  final Map<Api.AnyClientKey<?>, Api.Client> zzil;
  private final Condition zziz;
  private final zzbf zzja;
  final Map<Api.AnyClientKey<?>, ConnectionResult> zzjb;
  private volatile zzbc zzjc;
  private ConnectionResult zzjd;
  int zzje;
  final zzbq zzjf;
  
  public zzbd(Context paramContext, zzav paramzzav, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> paramMap, ClientSettings paramClientSettings, Map<Api<?>, Boolean> paramMap1, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> paramAbstractClientBuilder, ArrayList<zzp> paramArrayList, zzbq paramzzbq)
  {
    AppMethodBeat.i(11308);
    this.zzjb = new HashMap();
    this.zzjd = null;
    this.mContext = paramContext;
    this.zzga = paramLock;
    this.zzgk = paramGoogleApiAvailabilityLight;
    this.zzil = paramMap;
    this.zzgf = paramClientSettings;
    this.zzgi = paramMap1;
    this.zzdh = paramAbstractClientBuilder;
    this.zzfq = paramzzav;
    this.zzjf = paramzzbq;
    paramContext = (ArrayList)paramArrayList;
    int j = paramContext.size();
    int i = 0;
    while (i < j)
    {
      paramzzav = paramContext.get(i);
      i += 1;
      ((zzp)paramzzav).zza(this);
    }
    this.zzja = new zzbf(this, paramLooper);
    this.zziz = paramLock.newCondition();
    this.zzjc = new zzau(this);
    AppMethodBeat.o(11308);
  }
  
  @GuardedBy("mLock")
  public final ConnectionResult blockingConnect()
  {
    AppMethodBeat.i(11312);
    connect();
    while (isConnecting()) {
      try
      {
        this.zziz.await();
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
        localConnectionResult = new ConnectionResult(15, null);
        AppMethodBeat.o(11312);
        return localConnectionResult;
      }
    }
    if (isConnected())
    {
      localConnectionResult = ConnectionResult.RESULT_SUCCESS;
      AppMethodBeat.o(11312);
      return localConnectionResult;
    }
    if (this.zzjd != null)
    {
      localConnectionResult = this.zzjd;
      AppMethodBeat.o(11312);
      return localConnectionResult;
    }
    ConnectionResult localConnectionResult = new ConnectionResult(13, null);
    AppMethodBeat.o(11312);
    return localConnectionResult;
  }
  
  @GuardedBy("mLock")
  public final ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(11313);
    connect();
    for (paramLong = paramTimeUnit.toNanos(paramLong); isConnecting(); paramLong = this.zziz.awaitNanos(paramLong))
    {
      if (paramLong <= 0L) {}
      try
      {
        disconnect();
        paramTimeUnit = new ConnectionResult(14, null);
        AppMethodBeat.o(11313);
        return paramTimeUnit;
      }
      catch (InterruptedException paramTimeUnit)
      {
        Thread.currentThread().interrupt();
        paramTimeUnit = new ConnectionResult(15, null);
        AppMethodBeat.o(11313);
        return paramTimeUnit;
      }
    }
    if (isConnected())
    {
      paramTimeUnit = ConnectionResult.RESULT_SUCCESS;
      AppMethodBeat.o(11313);
      return paramTimeUnit;
    }
    if (this.zzjd != null)
    {
      paramTimeUnit = this.zzjd;
      AppMethodBeat.o(11313);
      return paramTimeUnit;
    }
    paramTimeUnit = new ConnectionResult(13, null);
    AppMethodBeat.o(11313);
    return paramTimeUnit;
  }
  
  @GuardedBy("mLock")
  public final void connect()
  {
    AppMethodBeat.i(11311);
    this.zzjc.connect();
    AppMethodBeat.o(11311);
  }
  
  @GuardedBy("mLock")
  public final void disconnect()
  {
    AppMethodBeat.i(11314);
    if (this.zzjc.disconnect()) {
      this.zzjb.clear();
    }
    AppMethodBeat.o(11314);
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    AppMethodBeat.i(11325);
    String str = String.valueOf(paramString).concat("  ");
    paramPrintWriter.append(paramString).append("mState=").println(this.zzjc);
    Iterator localIterator = this.zzgi.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      paramPrintWriter.append(paramString).append(localApi.getName()).println(":");
      ((Api.Client)this.zzil.get(localApi.getClientKey())).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    AppMethodBeat.o(11325);
  }
  
  @GuardedBy("mLock")
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT)
  {
    AppMethodBeat.i(11309);
    paramT.zzx();
    paramT = this.zzjc.enqueue(paramT);
    AppMethodBeat.o(11309);
    return paramT;
  }
  
  @GuardedBy("mLock")
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT)
  {
    AppMethodBeat.i(11310);
    paramT.zzx();
    paramT = this.zzjc.execute(paramT);
    AppMethodBeat.o(11310);
    return paramT;
  }
  
  @GuardedBy("mLock")
  public final ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    AppMethodBeat.i(11315);
    paramApi = paramApi.getClientKey();
    if (this.zzil.containsKey(paramApi))
    {
      if (((Api.Client)this.zzil.get(paramApi)).isConnected())
      {
        paramApi = ConnectionResult.RESULT_SUCCESS;
        AppMethodBeat.o(11315);
        return paramApi;
      }
      if (this.zzjb.containsKey(paramApi))
      {
        paramApi = (ConnectionResult)this.zzjb.get(paramApi);
        AppMethodBeat.o(11315);
        return paramApi;
      }
    }
    AppMethodBeat.o(11315);
    return null;
  }
  
  public final boolean isConnected()
  {
    return this.zzjc instanceof zzag;
  }
  
  public final boolean isConnecting()
  {
    return this.zzjc instanceof zzaj;
  }
  
  public final boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener)
  {
    return false;
  }
  
  public final void maybeSignOut() {}
  
  public final void onConnected(Bundle paramBundle)
  {
    AppMethodBeat.i(11321);
    this.zzga.lock();
    try
    {
      this.zzjc.onConnected(paramBundle);
      return;
    }
    finally
    {
      this.zzga.unlock();
      AppMethodBeat.o(11321);
    }
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    AppMethodBeat.i(11322);
    this.zzga.lock();
    try
    {
      this.zzjc.onConnectionSuspended(paramInt);
      return;
    }
    finally
    {
      this.zzga.unlock();
      AppMethodBeat.o(11322);
    }
  }
  
  public final void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean)
  {
    AppMethodBeat.i(11320);
    this.zzga.lock();
    try
    {
      this.zzjc.zza(paramConnectionResult, paramApi, paramBoolean);
      return;
    }
    finally
    {
      this.zzga.unlock();
      AppMethodBeat.o(11320);
    }
  }
  
  final void zza(zzbe paramzzbe)
  {
    AppMethodBeat.i(11323);
    paramzzbe = this.zzja.obtainMessage(1, paramzzbe);
    this.zzja.sendMessage(paramzzbe);
    AppMethodBeat.o(11323);
  }
  
  final void zzb(RuntimeException paramRuntimeException)
  {
    AppMethodBeat.i(11324);
    paramRuntimeException = this.zzja.obtainMessage(2, paramRuntimeException);
    this.zzja.sendMessage(paramRuntimeException);
    AppMethodBeat.o(11324);
  }
  
  final void zzbc()
  {
    AppMethodBeat.i(11316);
    this.zzga.lock();
    try
    {
      this.zzjc = new zzaj(this, this.zzgf, this.zzgi, this.zzgk, this.zzdh, this.zzga, this.mContext);
      this.zzjc.begin();
      this.zziz.signalAll();
      return;
    }
    finally
    {
      this.zzga.unlock();
      AppMethodBeat.o(11316);
    }
  }
  
  final void zzbd()
  {
    AppMethodBeat.i(11317);
    this.zzga.lock();
    try
    {
      this.zzfq.zzaz();
      this.zzjc = new zzag(this);
      this.zzjc.begin();
      this.zziz.signalAll();
      return;
    }
    finally
    {
      this.zzga.unlock();
      AppMethodBeat.o(11317);
    }
  }
  
  final void zzf(ConnectionResult paramConnectionResult)
  {
    AppMethodBeat.i(11318);
    this.zzga.lock();
    try
    {
      this.zzjd = paramConnectionResult;
      this.zzjc = new zzau(this);
      this.zzjc.begin();
      this.zziz.signalAll();
      return;
    }
    finally
    {
      this.zzga.unlock();
      AppMethodBeat.o(11318);
    }
  }
  
  @GuardedBy("mLock")
  public final void zzz()
  {
    AppMethodBeat.i(11319);
    if (isConnected()) {
      ((zzag)this.zzjc).zzap();
    }
    AppMethodBeat.o(11319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzbd
 * JD-Core Version:    0.7.0.1
 */
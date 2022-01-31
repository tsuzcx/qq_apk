package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.zze;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzaav
  implements zzaah, zzabc
{
  private final Context mContext;
  private final Lock zzaAG;
  final zzg zzaAL;
  final Map<Api<?>, Boolean> zzaAO;
  private final zze zzaAQ;
  final zzaat zzaAw;
  final Map<Api.zzc<?>, Api.zze> zzaBQ;
  private final Condition zzaCd;
  private final zzaav.zzb zzaCe;
  final Map<Api.zzc<?>, ConnectionResult> zzaCf = new HashMap();
  private volatile zzaau zzaCg;
  private ConnectionResult zzaCh = null;
  int zzaCi;
  final zzabc.zza zzaCj;
  final Api.zza<? extends zzbai, zzbaj> zzazo;
  
  public zzaav(Context paramContext, zzaat paramzzaat, Lock paramLock, Looper paramLooper, zze paramzze, Map<Api.zzc<?>, Api.zze> paramMap, zzg paramzzg, Map<Api<?>, Boolean> paramMap1, Api.zza<? extends zzbai, zzbaj> paramzza, ArrayList<zzaag> paramArrayList, zzabc.zza paramzza1)
  {
    this.mContext = paramContext;
    this.zzaAG = paramLock;
    this.zzaAQ = paramzze;
    this.zzaBQ = paramMap;
    this.zzaAL = paramzzg;
    this.zzaAO = paramMap1;
    this.zzazo = paramzza;
    this.zzaAw = paramzzaat;
    this.zzaCj = paramzza1;
    paramContext = paramArrayList.iterator();
    while (paramContext.hasNext()) {
      ((zzaag)paramContext.next()).zza(this);
    }
    this.zzaCe = new zzaav.zzb(this, paramLooper);
    this.zzaCd = paramLock.newCondition();
    this.zzaCg = new zzaas(this);
  }
  
  public ConnectionResult blockingConnect()
  {
    connect();
    while (isConnecting()) {
      try
      {
        this.zzaCd.await();
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
        return new ConnectionResult(15, null);
      }
    }
    if (isConnected()) {
      return ConnectionResult.zzayj;
    }
    if (this.zzaCh != null) {
      return this.zzaCh;
    }
    return new ConnectionResult(13, null);
  }
  
  public ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    connect();
    for (paramLong = paramTimeUnit.toNanos(paramLong); isConnecting(); paramLong = this.zzaCd.awaitNanos(paramLong))
    {
      if (paramLong <= 0L) {}
      try
      {
        disconnect();
        return new ConnectionResult(14, null);
      }
      catch (InterruptedException paramTimeUnit)
      {
        Thread.currentThread().interrupt();
        return new ConnectionResult(15, null);
      }
    }
    if (isConnected()) {
      return ConnectionResult.zzayj;
    }
    if (this.zzaCh != null) {
      return this.zzaCh;
    }
    return new ConnectionResult(13, null);
  }
  
  public void connect()
  {
    this.zzaCg.connect();
  }
  
  public void disconnect()
  {
    if (this.zzaCg.disconnect()) {
      this.zzaCf.clear();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    String str = String.valueOf(paramString).concat("  ");
    paramPrintWriter.append(paramString).append("mState=").println(this.zzaCg);
    Iterator localIterator = this.zzaAO.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      paramPrintWriter.append(paramString).append(localApi.getName()).println(":");
      ((Api.zze)this.zzaBQ.get(localApi.zzvg())).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    paramApi = paramApi.zzvg();
    if (this.zzaBQ.containsKey(paramApi))
    {
      if (((Api.zze)this.zzaBQ.get(paramApi)).isConnected()) {
        return ConnectionResult.zzayj;
      }
      if (this.zzaCf.containsKey(paramApi)) {
        return (ConnectionResult)this.zzaCf.get(paramApi);
      }
    }
    return null;
  }
  
  public boolean isConnected()
  {
    return this.zzaCg instanceof zzaaq;
  }
  
  public boolean isConnecting()
  {
    return this.zzaCg instanceof zzaar;
  }
  
  public void onConnected(Bundle paramBundle)
  {
    this.zzaAG.lock();
    try
    {
      this.zzaCg.onConnected(paramBundle);
      return;
    }
    finally
    {
      this.zzaAG.unlock();
    }
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    this.zzaAG.lock();
    try
    {
      this.zzaCg.onConnectionSuspended(paramInt);
      return;
    }
    finally
    {
      this.zzaAG.unlock();
    }
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzaad.zza<R, A>> T zza(T paramT)
  {
    paramT.zzvI();
    return this.zzaCg.zza(paramT);
  }
  
  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean)
  {
    this.zzaAG.lock();
    try
    {
      this.zzaCg.zza(paramConnectionResult, paramApi, paramBoolean);
      return;
    }
    finally
    {
      this.zzaAG.unlock();
    }
  }
  
  void zza(zzaav.zza paramzza)
  {
    paramzza = this.zzaCe.obtainMessage(1, paramzza);
    this.zzaCe.sendMessage(paramzza);
  }
  
  void zza(RuntimeException paramRuntimeException)
  {
    paramRuntimeException = this.zzaCe.obtainMessage(2, paramRuntimeException);
    this.zzaCe.sendMessage(paramRuntimeException);
  }
  
  public boolean zza(zzabq paramzzabq)
  {
    return false;
  }
  
  public <A extends Api.zzb, T extends zzaad.zza<? extends Result, A>> T zzb(T paramT)
  {
    paramT.zzvI();
    return this.zzaCg.zzb(paramT);
  }
  
  void zzh(ConnectionResult paramConnectionResult)
  {
    this.zzaAG.lock();
    try
    {
      this.zzaCh = paramConnectionResult;
      this.zzaCg = new zzaas(this);
      this.zzaCg.begin();
      this.zzaCd.signalAll();
      return;
    }
    finally
    {
      this.zzaAG.unlock();
    }
  }
  
  public void zzvM()
  {
    if (isConnected()) {
      ((zzaaq)this.zzaCg).zzwd();
    }
  }
  
  public void zzvn() {}
  
  void zzws()
  {
    this.zzaAG.lock();
    try
    {
      this.zzaCg = new zzaar(this, this.zzaAL, this.zzaAO, this.zzaAQ, this.zzazo, this.zzaAG, this.mContext);
      this.zzaCg.begin();
      this.zzaCd.signalAll();
      return;
    }
    finally
    {
      this.zzaAG.unlock();
    }
  }
  
  void zzwt()
  {
    this.zzaAG.lock();
    try
    {
      this.zzaAw.zzwp();
      this.zzaCg = new zzaaq(this);
      this.zzaCg.begin();
      this.zzaCd.signalAll();
      return;
    }
    finally
    {
      this.zzaAG.unlock();
    }
  }
  
  void zzwu()
  {
    Iterator localIterator = this.zzaBQ.values().iterator();
    while (localIterator.hasNext()) {
      ((Api.zze)localIterator.next()).disconnect();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.zzaav
 * JD-Core Version:    0.7.0.1
 */
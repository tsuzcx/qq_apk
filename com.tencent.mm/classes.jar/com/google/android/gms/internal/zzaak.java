package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.support.v4.f.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zzd;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzg.zza;
import com.google.android.gms.common.zze;
import com.google.android.gms.tasks.Task;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzaak
  implements zzabc
{
  private final Lock zzaAG;
  private final zzg zzaAL;
  private final Map<Api.zzc<?>, zzaaj<?>> zzaAM = new HashMap();
  private final Map<Api.zzc<?>, zzaaj<?>> zzaAN = new HashMap();
  private final Map<Api<?>, Boolean> zzaAO;
  private final zzaat zzaAP;
  private final zze zzaAQ;
  private final Condition zzaAR;
  private final boolean zzaAS;
  private final boolean zzaAT;
  private final Queue<zzaad.zza<?, ?>> zzaAU = new LinkedList();
  private boolean zzaAV;
  private Map<zzzz<?>, ConnectionResult> zzaAW;
  private Map<zzzz<?>, ConnectionResult> zzaAX;
  private zzaak.zzb zzaAY;
  private ConnectionResult zzaAZ;
  private final zzaax zzayX;
  private final Looper zzrs;
  
  public zzaak(Context paramContext, Lock paramLock, Looper paramLooper, zze paramzze, Map<Api.zzc<?>, Api.zze> paramMap, zzg paramzzg, Map<Api<?>, Boolean> paramMap1, Api.zza<? extends zzbai, zzbaj> paramzza, ArrayList<zzaag> paramArrayList, zzaat paramzzaat, boolean paramBoolean)
  {
    this.zzaAG = paramLock;
    this.zzrs = paramLooper;
    this.zzaAR = paramLock.newCondition();
    this.zzaAQ = paramzze;
    this.zzaAP = paramzzaat;
    this.zzaAO = paramMap1;
    this.zzaAL = paramzzg;
    this.zzaAS = paramBoolean;
    paramLock = new HashMap();
    paramzze = paramMap1.keySet().iterator();
    while (paramzze.hasNext())
    {
      paramMap1 = (Api)paramzze.next();
      paramLock.put(paramMap1.zzvg(), paramMap1);
    }
    paramzze = new HashMap();
    paramMap1 = paramArrayList.iterator();
    while (paramMap1.hasNext())
    {
      paramArrayList = (zzaag)paramMap1.next();
      paramzze.put(paramArrayList.zzaxf, paramArrayList);
    }
    int i = 0;
    int j = 1;
    int k = 0;
    paramMap = paramMap.entrySet().iterator();
    if (paramMap.hasNext())
    {
      paramMap1 = (Map.Entry)paramMap.next();
      paramzzaat = (Api)paramLock.get(paramMap1.getKey());
      paramArrayList = (Api.zze)paramMap1.getValue();
      if (paramArrayList.zzvh())
      {
        if (((Boolean)this.zzaAO.get(paramzzaat)).booleanValue()) {
          break label475;
        }
        i = 1;
        k = 1;
      }
    }
    for (;;)
    {
      paramzzaat = new zzaaj(paramContext, paramzzaat, paramLooper, paramArrayList, (zzaag)paramzze.get(paramzzaat), paramzzg, paramzza);
      this.zzaAM.put((Api.zzc)paramMap1.getKey(), paramzzaat);
      if (paramArrayList.zzrd()) {
        this.zzaAN.put((Api.zzc)paramMap1.getKey(), paramzzaat);
      }
      int m = k;
      k = i;
      i = m;
      break;
      j = k;
      m = 0;
      k = i;
      i = j;
      j = m;
      continue;
      if ((k != 0) && (j == 0) && (i == 0)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.zzaAT = paramBoolean;
        this.zzayX = zzaax.zzww();
        return;
      }
      label475:
      m = 1;
      k = i;
      i = m;
    }
  }
  
  private boolean zza(zzaaj<?> paramzzaaj, ConnectionResult paramConnectionResult)
  {
    return (!paramConnectionResult.isSuccess()) && (!paramConnectionResult.hasResolution()) && (((Boolean)this.zzaAO.get(paramzzaaj.getApi())).booleanValue()) && (paramzzaaj.zzvU().zzvh()) && (this.zzaAQ.isUserResolvableError(paramConnectionResult.getErrorCode()));
  }
  
  private ConnectionResult zzb(Api.zzc<?> paramzzc)
  {
    this.zzaAG.lock();
    try
    {
      paramzzc = (zzaaj)this.zzaAM.get(paramzzc);
      if ((this.zzaAW != null) && (paramzzc != null))
      {
        paramzzc = (ConnectionResult)this.zzaAW.get(paramzzc.getApiKey());
        return paramzzc;
      }
      return null;
    }
    finally
    {
      this.zzaAG.unlock();
    }
  }
  
  private <T extends zzaad.zza<? extends Result, ? extends Api.zzb>> boolean zzd(T paramT)
  {
    Api.zzc localzzc = paramT.zzvg();
    ConnectionResult localConnectionResult = zzb(localzzc);
    if ((localConnectionResult != null) && (localConnectionResult.getErrorCode() == 4))
    {
      paramT.zzB(new Status(4, null, this.zzayX.zza(((zzaaj)this.zzaAM.get(localzzc)).getApiKey(), this.zzaAP.getSessionId())));
      return true;
    }
    return false;
  }
  
  private void zzvV()
  {
    if (this.zzaAL == null)
    {
      this.zzaAP.zzaBR = Collections.emptySet();
      return;
    }
    HashSet localHashSet = new HashSet(this.zzaAL.zzxL());
    Map localMap = this.zzaAL.zzxN();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      ConnectionResult localConnectionResult = getConnectionResult(localApi);
      if ((localConnectionResult != null) && (localConnectionResult.isSuccess())) {
        localHashSet.addAll(((zzg.zza)localMap.get(localApi)).zzakq);
      }
    }
    this.zzaAP.zzaBR = localHashSet;
  }
  
  private void zzvW()
  {
    while (!this.zzaAU.isEmpty()) {
      zzb((zzaad.zza)this.zzaAU.remove());
    }
    this.zzaAP.zzo(null);
  }
  
  private ConnectionResult zzvX()
  {
    Iterator localIterator = this.zzaAM.values().iterator();
    int k = 0;
    Object localObject3 = null;
    int i = 0;
    Object localObject1 = null;
    Object localObject2;
    int j;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject4 = (zzaaj)localIterator.next();
        localObject2 = ((zzaaj)localObject4).getApi();
        localObject4 = ((zzaaj)localObject4).getApiKey();
        localObject4 = (ConnectionResult)this.zzaAW.get(localObject4);
        if ((!((ConnectionResult)localObject4).isSuccess()) && ((!((Boolean)this.zzaAO.get(localObject2)).booleanValue()) || (((ConnectionResult)localObject4).hasResolution()) || (this.zzaAQ.isUserResolvableError(((ConnectionResult)localObject4).getErrorCode())))) {
          if ((((ConnectionResult)localObject4).getErrorCode() == 4) && (this.zzaAS))
          {
            j = ((Api)localObject2).zzve().getPriority();
            if ((localObject3 == null) || (k > j))
            {
              k = j;
              localObject3 = localObject4;
            }
          }
          else
          {
            int m = ((Api)localObject2).zzve().getPriority();
            localObject2 = localObject4;
            j = m;
            if (localObject1 != null)
            {
              if (i <= m) {
                break label238;
              }
              j = m;
              localObject2 = localObject4;
            }
          }
        }
      }
    }
    for (;;)
    {
      i = j;
      localObject1 = localObject2;
      break;
      if ((localObject1 != null) && (localObject3 != null) && (i > k)) {
        return localObject3;
      }
      return localObject1;
      label238:
      localObject2 = localObject1;
      j = i;
    }
  }
  
  public ConnectionResult blockingConnect()
  {
    connect();
    while (isConnecting()) {
      try
      {
        this.zzaAR.await();
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
    if (this.zzaAZ != null) {
      return this.zzaAZ;
    }
    return new ConnectionResult(13, null);
  }
  
  public ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    connect();
    for (paramLong = paramTimeUnit.toNanos(paramLong); isConnecting(); paramLong = this.zzaAR.awaitNanos(paramLong))
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
    if (this.zzaAZ != null) {
      return this.zzaAZ;
    }
    return new ConnectionResult(13, null);
  }
  
  public void connect()
  {
    this.zzaAG.lock();
    try
    {
      boolean bool = this.zzaAV;
      if (bool) {
        return;
      }
      this.zzaAV = true;
      this.zzaAW = null;
      this.zzaAX = null;
      this.zzaAY = null;
      this.zzaAZ = null;
      this.zzayX.zzvx();
      this.zzayX.zza(this.zzaAM.values()).addOnCompleteListener(new zzadb(this.zzrs), new zzaak.zza(this, null));
      return;
    }
    finally
    {
      this.zzaAG.unlock();
    }
  }
  
  public void disconnect()
  {
    this.zzaAG.lock();
    try
    {
      this.zzaAV = false;
      this.zzaAW = null;
      this.zzaAX = null;
      if (this.zzaAY != null)
      {
        this.zzaAY.cancel();
        this.zzaAY = null;
      }
      this.zzaAZ = null;
      while (!this.zzaAU.isEmpty())
      {
        zzaad.zza localzza = (zzaad.zza)this.zzaAU.remove();
        localzza.zza(null);
        localzza.cancel();
      }
      this.zzaAR.signalAll();
    }
    finally
    {
      this.zzaAG.unlock();
    }
    this.zzaAG.unlock();
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    return zzb(paramApi.zzvg());
  }
  
  /* Error */
  public boolean isConnected()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 63	com/google/android/gms/internal/zzaak:zzaAG	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 219 1 0
    //   9: aload_0
    //   10: getfield 179	com/google/android/gms/internal/zzaak:zzaAW	Ljava/util/Map;
    //   13: ifnull +25 -> 38
    //   16: aload_0
    //   17: getfield 176	com/google/android/gms/internal/zzaak:zzaAZ	Lcom/google/android/gms/common/ConnectionResult;
    //   20: astore_2
    //   21: aload_2
    //   22: ifnonnull +16 -> 38
    //   25: iconst_1
    //   26: istore_1
    //   27: aload_0
    //   28: getfield 63	com/google/android/gms/internal/zzaak:zzaAG	Ljava/util/concurrent/locks/Lock;
    //   31: invokeinterface 226 1 0
    //   36: iload_1
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_1
    //   40: goto -13 -> 27
    //   43: astore_2
    //   44: aload_0
    //   45: getfield 63	com/google/android/gms/internal/zzaak:zzaAG	Ljava/util/concurrent/locks/Lock;
    //   48: invokeinterface 226 1 0
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	zzaak
    //   26	14	1	bool	boolean
    //   20	2	2	localConnectionResult	ConnectionResult
    //   43	11	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	21	43	finally
  }
  
  /* Error */
  public boolean isConnecting()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 63	com/google/android/gms/internal/zzaak:zzaAG	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 219 1 0
    //   9: aload_0
    //   10: getfield 179	com/google/android/gms/internal/zzaak:zzaAW	Ljava/util/Map;
    //   13: ifnonnull +25 -> 38
    //   16: aload_0
    //   17: getfield 214	com/google/android/gms/internal/zzaak:zzaAV	Z
    //   20: istore_1
    //   21: iload_1
    //   22: ifeq +16 -> 38
    //   25: iconst_1
    //   26: istore_1
    //   27: aload_0
    //   28: getfield 63	com/google/android/gms/internal/zzaak:zzaAG	Ljava/util/concurrent/locks/Lock;
    //   31: invokeinterface 226 1 0
    //   36: iload_1
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_1
    //   40: goto -13 -> 27
    //   43: astore_2
    //   44: aload_0
    //   45: getfield 63	com/google/android/gms/internal/zzaak:zzaAG	Ljava/util/concurrent/locks/Lock;
    //   48: invokeinterface 226 1 0
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	zzaak
    //   20	20	1	bool	boolean
    //   43	11	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	21	43	finally
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzaad.zza<R, A>> T zza(T paramT)
  {
    if ((this.zzaAS) && (zzd(paramT))) {
      return paramT;
    }
    if (!isConnected())
    {
      this.zzaAU.add(paramT);
      return paramT;
    }
    this.zzaAP.zzaBW.zzb(paramT);
    return ((zzaaj)this.zzaAM.get(paramT.zzvg())).doRead(paramT);
  }
  
  public boolean zza(zzabq paramzzabq)
  {
    this.zzaAG.lock();
    try
    {
      if ((this.zzaAV) && (!zzvN()))
      {
        this.zzayX.zzvx();
        this.zzaAY = new zzaak.zzb(this, paramzzabq);
        this.zzayX.zza(this.zzaAN.values()).addOnCompleteListener(new zzadb(this.zzrs), this.zzaAY);
        return true;
      }
      return false;
    }
    finally
    {
      this.zzaAG.unlock();
    }
  }
  
  public <A extends Api.zzb, T extends zzaad.zza<? extends Result, A>> T zzb(T paramT)
  {
    Api.zzc localzzc = paramT.zzvg();
    if ((this.zzaAS) && (zzd(paramT))) {
      return paramT;
    }
    this.zzaAP.zzaBW.zzb(paramT);
    return ((zzaaj)this.zzaAM.get(localzzc)).doWrite(paramT);
  }
  
  public void zzvM() {}
  
  public boolean zzvN()
  {
    this.zzaAG.lock();
    try
    {
      boolean bool;
      if (this.zzaAV)
      {
        bool = this.zzaAS;
        if (bool) {}
      }
      else
      {
        return false;
      }
      Iterator localIterator = this.zzaAN.keySet().iterator();
      while (localIterator.hasNext())
      {
        ConnectionResult localConnectionResult = zzb((Api.zzc)localIterator.next());
        if (localConnectionResult != null)
        {
          bool = localConnectionResult.isSuccess();
          if (bool) {
            break;
          }
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    finally
    {
      this.zzaAG.unlock();
    }
  }
  
  public void zzvn()
  {
    this.zzaAG.lock();
    try
    {
      this.zzayX.zzvn();
      if (this.zzaAY != null)
      {
        this.zzaAY.cancel();
        this.zzaAY = null;
      }
      if (this.zzaAX == null) {
        this.zzaAX = new a(this.zzaAN.size());
      }
      ConnectionResult localConnectionResult = new ConnectionResult(4);
      Iterator localIterator = this.zzaAN.values().iterator();
      while (localIterator.hasNext())
      {
        zzaaj localzzaaj = (zzaaj)localIterator.next();
        this.zzaAX.put(localzzaaj.getApiKey(), localConnectionResult);
      }
      if (this.zzaAW == null) {
        break label155;
      }
    }
    finally
    {
      this.zzaAG.unlock();
    }
    this.zzaAW.putAll(this.zzaAX);
    label155:
    this.zzaAG.unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzaak
 * JD-Core Version:    0.7.0.1
 */
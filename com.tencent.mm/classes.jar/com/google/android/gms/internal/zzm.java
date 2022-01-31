package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class zzm
{
  private AtomicInteger zzX = new AtomicInteger();
  private final Map<String, Queue<zzl<?>>> zzY = new HashMap();
  private final Set<zzl<?>> zzZ = new HashSet();
  private final PriorityBlockingQueue<zzl<?>> zzaa = new PriorityBlockingQueue();
  private final PriorityBlockingQueue<zzl<?>> zzab = new PriorityBlockingQueue();
  private zzh[] zzac;
  private zzc zzad;
  private List<Object> zzae = new ArrayList();
  private final zzb zzi;
  private final zzo zzj;
  private final zzg zzy;
  
  public zzm(zzb paramzzb, zzg paramzzg)
  {
    this(paramzzb, paramzzg, 4);
  }
  
  public zzm(zzb paramzzb, zzg paramzzg, int paramInt)
  {
    this(paramzzb, paramzzg, paramInt, new zzf(new Handler(Looper.getMainLooper())));
  }
  
  public zzm(zzb paramzzb, zzg paramzzg, int paramInt, zzo paramzzo)
  {
    this.zzi = paramzzb;
    this.zzy = paramzzg;
    this.zzac = new zzh[paramInt];
    this.zzj = paramzzo;
  }
  
  public int getSequenceNumber()
  {
    return this.zzX.incrementAndGet();
  }
  
  public void start()
  {
    stop();
    this.zzad = new zzc(this.zzaa, this.zzab, this.zzi, this.zzj);
    this.zzad.start();
    int i = 0;
    while (i < this.zzac.length)
    {
      zzh localzzh = new zzh(this.zzab, this.zzy, this.zzi, this.zzj);
      this.zzac[i] = localzzh;
      localzzh.start();
      i += 1;
    }
  }
  
  public void stop()
  {
    if (this.zzad != null) {
      this.zzad.quit();
    }
    int i = 0;
    while (i < this.zzac.length)
    {
      if (this.zzac[i] != null) {
        this.zzac[i].quit();
      }
      i += 1;
    }
  }
  
  public <T> zzl<T> zze(zzl<T> paramzzl)
  {
    paramzzl.zza(this);
    synchronized (this.zzZ)
    {
      this.zzZ.add(paramzzl);
      paramzzl.zza(getSequenceNumber());
      paramzzl.zzc("add-to-queue");
      if (!paramzzl.zzn())
      {
        this.zzab.add(paramzzl);
        return paramzzl;
      }
    }
    for (;;)
    {
      String str;
      synchronized (this.zzY)
      {
        str = paramzzl.zzg();
        if (this.zzY.containsKey(str))
        {
          Queue localQueue = (Queue)this.zzY.get(str);
          ??? = localQueue;
          if (localQueue == null) {
            ??? = new LinkedList();
          }
          ((Queue)???).add(paramzzl);
          this.zzY.put(str, ???);
          if (zzt.DEBUG) {
            zzt.zza("Request for cacheKey=%s is in flight, putting on hold.", new Object[] { str });
          }
          return paramzzl;
        }
      }
      this.zzY.put(str, null);
      this.zzaa.add(paramzzl);
    }
  }
  
  <T> void zzf(zzl<T> paramzzl)
  {
    Object localObject2;
    synchronized (this.zzZ)
    {
      this.zzZ.remove(paramzzl);
      synchronized (this.zzae)
      {
        localObject2 = this.zzae.iterator();
        if (((Iterator)localObject2).hasNext()) {
          ((Iterator)localObject2).next();
        }
      }
    }
    if (paramzzl.zzn()) {
      synchronized (this.zzY)
      {
        paramzzl = paramzzl.zzg();
        localObject2 = (Queue)this.zzY.remove(paramzzl);
        if (localObject2 != null)
        {
          if (zzt.DEBUG) {
            zzt.zza("Releasing %d waiting requests for cacheKey=%s.", new Object[] { Integer.valueOf(((Queue)localObject2).size()), paramzzl });
          }
          this.zzaa.addAll((Collection)localObject2);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.zzm
 * JD-Core Version:    0.7.0.1
 */
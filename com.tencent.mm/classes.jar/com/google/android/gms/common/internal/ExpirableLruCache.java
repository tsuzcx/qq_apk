package com.google.android.gms.common.internal;

import android.support.v4.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ExpirableLruCache<K, V>
{
  public static int TIME_UNSET = -1;
  private final Object mLock;
  private final h<K, V> zzsn;
  private final long zzso;
  private final long zzsp;
  private HashMap<K, Long> zzsq;
  private HashMap<K, Long> zzsr;
  
  public ExpirableLruCache(int paramInt, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(4616);
    this.mLock = new Object();
    this.zzso = TimeUnit.NANOSECONDS.convert(paramLong1, paramTimeUnit);
    this.zzsp = TimeUnit.NANOSECONDS.convert(paramLong2, paramTimeUnit);
    if ((zzct()) || (zzcu())) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "ExpirableLruCache has both access and write expiration negative");
      this.zzsn = new zze(this, paramInt);
      if (zzct()) {
        this.zzsq = new HashMap();
      }
      if (zzcu()) {
        this.zzsr = new HashMap();
      }
      AppMethodBeat.o(4616);
      return;
    }
  }
  
  private final boolean zza(K paramK)
  {
    AppMethodBeat.i(4623);
    long l = System.nanoTime();
    if ((zzct()) && (this.zzsq.containsKey(paramK)) && (l - ((Long)this.zzsq.get(paramK)).longValue() > this.zzso))
    {
      AppMethodBeat.o(4623);
      return true;
    }
    if ((zzcu()) && (this.zzsr.containsKey(paramK)) && (l - ((Long)this.zzsr.get(paramK)).longValue() > this.zzsp))
    {
      AppMethodBeat.o(4623);
      return true;
    }
    AppMethodBeat.o(4623);
    return false;
  }
  
  private final boolean zzct()
  {
    return this.zzso >= 0L;
  }
  
  private final boolean zzcu()
  {
    return this.zzsp >= 0L;
  }
  
  protected V create(K paramK)
  {
    return null;
  }
  
  protected void entryRemoved(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  public void evictAll()
  {
    AppMethodBeat.i(4622);
    this.zzsn.evictAll();
    AppMethodBeat.o(4622);
  }
  
  public V get(K paramK)
  {
    AppMethodBeat.i(4618);
    synchronized (this.mLock)
    {
      if (zza(paramK)) {
        this.zzsn.remove(paramK);
      }
      Object localObject2 = this.zzsn.get(paramK);
      if ((localObject2 != null) && (this.zzso > 0L))
      {
        long l = System.nanoTime();
        this.zzsq.put(paramK, Long.valueOf(l));
      }
      AppMethodBeat.o(4618);
      return localObject2;
    }
  }
  
  public V put(K paramK, V paramV)
  {
    AppMethodBeat.i(4617);
    long l;
    if (zzcu()) {
      l = System.nanoTime();
    }
    synchronized (this.mLock)
    {
      this.zzsr.put(paramK, Long.valueOf(l));
      paramK = this.zzsn.put(paramK, paramV);
      AppMethodBeat.o(4617);
      return paramK;
    }
  }
  
  public V remove(K paramK)
  {
    AppMethodBeat.i(4619);
    paramK = this.zzsn.remove(paramK);
    AppMethodBeat.o(4619);
    return paramK;
  }
  
  public void removeExpired()
  {
    AppMethodBeat.i(4620);
    Iterator localIterator = this.zzsn.snapshot().keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = localIterator.next();
      synchronized (this.mLock)
      {
        if (zza(localObject3)) {
          this.zzsn.remove(localObject3);
        }
      }
    }
    AppMethodBeat.o(4620);
  }
  
  protected int sizeOf(K paramK, V paramV)
  {
    return 1;
  }
  
  public Map<K, V> snapshot()
  {
    AppMethodBeat.i(4621);
    removeExpired();
    Map localMap = this.zzsn.snapshot();
    AppMethodBeat.o(4621);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.internal.ExpirableLruCache
 * JD-Core Version:    0.7.0.1
 */
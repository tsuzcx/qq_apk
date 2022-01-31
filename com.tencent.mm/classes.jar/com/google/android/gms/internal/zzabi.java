package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.zzac;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public class zzabi
{
  private final Set<zzabh<?>> zzasL = Collections.newSetFromMap(new WeakHashMap());
  
  public static <L> zzabh.zzb<L> zza(L paramL, String paramString)
  {
    zzac.zzb(paramL, "Listener must not be null");
    zzac.zzb(paramString, "Listener type must not be null");
    zzac.zzh(paramString, "Listener type must not be empty");
    return new zzabh.zzb(paramL, paramString);
  }
  
  public static <L> zzabh<L> zzb(L paramL, Looper paramLooper, String paramString)
  {
    zzac.zzb(paramL, "Listener must not be null");
    zzac.zzb(paramLooper, "Looper must not be null");
    zzac.zzb(paramString, "Listener type must not be null");
    return new zzabh(paramLooper, paramL, paramString);
  }
  
  public void release()
  {
    Iterator localIterator = this.zzasL.iterator();
    while (localIterator.hasNext()) {
      ((zzabh)localIterator.next()).clear();
    }
    this.zzasL.clear();
  }
  
  public <L> zzabh<L> zza(L paramL, Looper paramLooper, String paramString)
  {
    paramL = zzb(paramL, paramLooper, paramString);
    this.zzasL.add(paramL);
    return paramL;
  }
  
  public <L> zzabh<L> zzb(L paramL, Looper paramLooper)
  {
    return zza(paramL, paramLooper, "NO_TYPE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzabi
 * JD-Core Version:    0.7.0.1
 */
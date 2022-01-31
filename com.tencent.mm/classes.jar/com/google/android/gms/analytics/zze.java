package com.google.android.gms.analytics;

import com.google.android.gms.common.internal.zzac;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zze
{
  private final zzg zzabU;
  private boolean zzabV;
  private long zzabW;
  private long zzabX;
  private long zzabY;
  private long zzabZ;
  private long zzaca;
  private boolean zzacb;
  private final Map<Class<? extends zzf>, zzf> zzacc;
  private final List<zzi> zzacd;
  private final com.google.android.gms.common.util.zze zzuP;
  
  zze(zze paramzze)
  {
    this.zzabU = paramzze.zzabU;
    this.zzuP = paramzze.zzuP;
    this.zzabW = paramzze.zzabW;
    this.zzabX = paramzze.zzabX;
    this.zzabY = paramzze.zzabY;
    this.zzabZ = paramzze.zzabZ;
    this.zzaca = paramzze.zzaca;
    this.zzacd = new ArrayList(paramzze.zzacd);
    this.zzacc = new HashMap(paramzze.zzacc.size());
    paramzze = paramzze.zzacc.entrySet().iterator();
    while (paramzze.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramzze.next();
      zzf localzzf = zzc((Class)localEntry.getKey());
      ((zzf)localEntry.getValue()).zzb(localzzf);
      this.zzacc.put((Class)localEntry.getKey(), localzzf);
    }
  }
  
  zze(zzg paramzzg, com.google.android.gms.common.util.zze paramzze)
  {
    zzac.zzw(paramzzg);
    zzac.zzw(paramzze);
    this.zzabU = paramzzg;
    this.zzuP = paramzze;
    this.zzabZ = 1800000L;
    this.zzaca = 3024000000L;
    this.zzacc = new HashMap();
    this.zzacd = new ArrayList();
  }
  
  private static <T extends zzf> T zzc(Class<T> paramClass)
  {
    try
    {
      paramClass = (zzf)paramClass.newInstance();
      return paramClass;
    }
    catch (InstantiationException paramClass)
    {
      throw new IllegalArgumentException("dataType doesn't have default constructor", paramClass);
    }
    catch (IllegalAccessException paramClass)
    {
      throw new IllegalArgumentException("dataType default constructor is not accessible", paramClass);
    }
  }
  
  public final <T extends zzf> T zza(Class<T> paramClass)
  {
    return (zzf)this.zzacc.get(paramClass);
  }
  
  public final void zza(zzf paramzzf)
  {
    zzac.zzw(paramzzf);
    Class localClass = paramzzf.getClass();
    if (localClass.getSuperclass() != zzf.class) {
      throw new IllegalArgumentException();
    }
    paramzzf.zzb(zzb(localClass));
  }
  
  public final <T extends zzf> T zzb(Class<T> paramClass)
  {
    zzf localzzf2 = (zzf)this.zzacc.get(paramClass);
    zzf localzzf1 = localzzf2;
    if (localzzf2 == null)
    {
      localzzf1 = zzc(paramClass);
      this.zzacc.put(paramClass, localzzf1);
    }
    return localzzf1;
  }
  
  public final zze zzmC()
  {
    return new zze(this);
  }
  
  public final Collection<zzf> zzmD()
  {
    return this.zzacc.values();
  }
  
  public final List<zzi> zzmE()
  {
    return this.zzacd;
  }
  
  public final long zzmF()
  {
    return this.zzabW;
  }
  
  public final void zzmG()
  {
    zzmK().zze(this);
  }
  
  public final boolean zzmH()
  {
    return this.zzabV;
  }
  
  final void zzmI()
  {
    this.zzabY = this.zzuP.elapsedRealtime();
    if (this.zzabX != 0L) {}
    for (this.zzabW = this.zzabX;; this.zzabW = this.zzuP.currentTimeMillis())
    {
      this.zzabV = true;
      return;
    }
  }
  
  final zzg zzmJ()
  {
    return this.zzabU;
  }
  
  final zzh zzmK()
  {
    return this.zzabU.zzmK();
  }
  
  final boolean zzmL()
  {
    return this.zzacb;
  }
  
  final void zzmM()
  {
    this.zzacb = true;
  }
  
  public final void zzq(long paramLong)
  {
    this.zzabX = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.analytics.zze
 * JD-Core Version:    0.7.0.1
 */
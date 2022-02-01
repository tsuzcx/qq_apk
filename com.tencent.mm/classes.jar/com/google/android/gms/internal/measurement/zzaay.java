package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzaay<K extends Comparable<K>, V>
  extends AbstractMap<K, V>
{
  private boolean zzbls;
  private final int zzbtx;
  private List<zzabd> zzbty;
  private Map<K, V> zzbtz;
  private volatile zzabf zzbua;
  private Map<K, V> zzbub;
  
  private zzaay(int paramInt)
  {
    AppMethodBeat.i(40157);
    this.zzbtx = paramInt;
    this.zzbty = Collections.emptyList();
    this.zzbtz = Collections.emptyMap();
    this.zzbub = Collections.emptyMap();
    AppMethodBeat.o(40157);
  }
  
  private final int zza(K paramK)
  {
    AppMethodBeat.i(40169);
    int j = 0;
    int i = this.zzbty.size() - 1;
    int k;
    if (i >= 0)
    {
      k = paramK.compareTo((Comparable)((zzabd)this.zzbty.get(i)).getKey());
      if (k > 0)
      {
        i = -(i + 2);
        AppMethodBeat.o(40169);
        return i;
      }
      if (k == 0)
      {
        AppMethodBeat.o(40169);
        return i;
      }
    }
    for (;;)
    {
      if (j <= i)
      {
        k = (j + i) / 2;
        int m = paramK.compareTo((Comparable)((zzabd)this.zzbty.get(k)).getKey());
        if (m < 0)
        {
          i = k - 1;
        }
        else if (m > 0)
        {
          j = k + 1;
        }
        else
        {
          AppMethodBeat.o(40169);
          return k;
        }
      }
      else
      {
        i = -(j + 1);
        AppMethodBeat.o(40169);
        return i;
      }
    }
  }
  
  static <FieldDescriptorType extends zzzo<FieldDescriptorType>> zzaay<FieldDescriptorType, Object> zzag(int paramInt)
  {
    AppMethodBeat.i(40156);
    zzaaz localzzaaz = new zzaaz(paramInt);
    AppMethodBeat.o(40156);
    return localzzaaz;
  }
  
  private final V zzai(int paramInt)
  {
    AppMethodBeat.i(40168);
    zzul();
    Object localObject = ((zzabd)this.zzbty.remove(paramInt)).getValue();
    if (!this.zzbtz.isEmpty())
    {
      Iterator localIterator = zzum().entrySet().iterator();
      this.zzbty.add(new zzabd(this, (Map.Entry)localIterator.next()));
      localIterator.remove();
    }
    AppMethodBeat.o(40168);
    return localObject;
  }
  
  private final void zzul()
  {
    AppMethodBeat.i(40171);
    if (this.zzbls)
    {
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(40171);
      throw localUnsupportedOperationException;
    }
    AppMethodBeat.o(40171);
  }
  
  private final SortedMap<K, V> zzum()
  {
    AppMethodBeat.i(40172);
    zzul();
    if ((this.zzbtz.isEmpty()) && (!(this.zzbtz instanceof TreeMap)))
    {
      this.zzbtz = new TreeMap();
      this.zzbub = ((TreeMap)this.zzbtz).descendingMap();
    }
    SortedMap localSortedMap = (SortedMap)this.zzbtz;
    AppMethodBeat.o(40172);
    return localSortedMap;
  }
  
  public void clear()
  {
    AppMethodBeat.i(40166);
    zzul();
    if (!this.zzbty.isEmpty()) {
      this.zzbty.clear();
    }
    if (!this.zzbtz.isEmpty()) {
      this.zzbtz.clear();
    }
    AppMethodBeat.o(40166);
  }
  
  public boolean containsKey(Object paramObject)
  {
    AppMethodBeat.i(40163);
    paramObject = (Comparable)paramObject;
    if ((zza(paramObject) >= 0) || (this.zzbtz.containsKey(paramObject)))
    {
      AppMethodBeat.o(40163);
      return true;
    }
    AppMethodBeat.o(40163);
    return false;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    AppMethodBeat.i(40170);
    if (this.zzbua == null) {
      this.zzbua = new zzabf(this, null);
    }
    zzabf localzzabf = this.zzbua;
    AppMethodBeat.o(40170);
    return localzzabf;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(40173);
    if (this == paramObject)
    {
      AppMethodBeat.o(40173);
      return true;
    }
    boolean bool;
    if (!(paramObject instanceof zzaay))
    {
      bool = super.equals(paramObject);
      AppMethodBeat.o(40173);
      return bool;
    }
    paramObject = (zzaay)paramObject;
    int j = size();
    if (j != paramObject.size())
    {
      AppMethodBeat.o(40173);
      return false;
    }
    int k = zzuj();
    if (k != paramObject.zzuj())
    {
      bool = entrySet().equals(paramObject.entrySet());
      AppMethodBeat.o(40173);
      return bool;
    }
    int i = 0;
    while (i < k)
    {
      if (!zzah(i).equals(paramObject.zzah(i)))
      {
        AppMethodBeat.o(40173);
        return false;
      }
      i += 1;
    }
    if (k != j)
    {
      bool = this.zzbtz.equals(paramObject.zzbtz);
      AppMethodBeat.o(40173);
      return bool;
    }
    AppMethodBeat.o(40173);
    return true;
  }
  
  public V get(Object paramObject)
  {
    AppMethodBeat.i(40164);
    paramObject = (Comparable)paramObject;
    int i = zza(paramObject);
    if (i >= 0)
    {
      paramObject = ((zzabd)this.zzbty.get(i)).getValue();
      AppMethodBeat.o(40164);
      return paramObject;
    }
    paramObject = this.zzbtz.get(paramObject);
    AppMethodBeat.o(40164);
    return paramObject;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(40174);
    int k = zzuj();
    int j = 0;
    int i = 0;
    while (j < k)
    {
      i += ((zzabd)this.zzbty.get(j)).hashCode();
      j += 1;
    }
    if (this.zzbtz.size() > 0) {
      i = this.zzbtz.hashCode() + i;
    }
    for (;;)
    {
      AppMethodBeat.o(40174);
      return i;
    }
  }
  
  public final boolean isImmutable()
  {
    return this.zzbls;
  }
  
  public V remove(Object paramObject)
  {
    AppMethodBeat.i(40167);
    zzul();
    paramObject = (Comparable)paramObject;
    int i = zza(paramObject);
    if (i >= 0)
    {
      paramObject = zzai(i);
      AppMethodBeat.o(40167);
      return paramObject;
    }
    if (this.zzbtz.isEmpty())
    {
      AppMethodBeat.o(40167);
      return null;
    }
    paramObject = this.zzbtz.remove(paramObject);
    AppMethodBeat.o(40167);
    return paramObject;
  }
  
  public int size()
  {
    AppMethodBeat.i(40162);
    int i = this.zzbty.size();
    int j = this.zzbtz.size();
    AppMethodBeat.o(40162);
    return i + j;
  }
  
  public final V zza(K paramK, V paramV)
  {
    AppMethodBeat.i(40165);
    zzul();
    int i = zza(paramK);
    if (i >= 0)
    {
      paramK = ((zzabd)this.zzbty.get(i)).setValue(paramV);
      AppMethodBeat.o(40165);
      return paramK;
    }
    zzul();
    if ((this.zzbty.isEmpty()) && (!(this.zzbty instanceof ArrayList))) {
      this.zzbty = new ArrayList(this.zzbtx);
    }
    i = -(i + 1);
    if (i >= this.zzbtx)
    {
      paramK = zzum().put(paramK, paramV);
      AppMethodBeat.o(40165);
      return paramK;
    }
    if (this.zzbty.size() == this.zzbtx)
    {
      zzabd localzzabd = (zzabd)this.zzbty.remove(this.zzbtx - 1);
      zzum().put((Comparable)localzzabd.getKey(), localzzabd.getValue());
    }
    this.zzbty.add(i, new zzabd(this, paramK, paramV));
    AppMethodBeat.o(40165);
    return null;
  }
  
  public final Map.Entry<K, V> zzah(int paramInt)
  {
    AppMethodBeat.i(40160);
    Map.Entry localEntry = (Map.Entry)this.zzbty.get(paramInt);
    AppMethodBeat.o(40160);
    return localEntry;
  }
  
  public void zzrg()
  {
    AppMethodBeat.i(40158);
    if (!this.zzbls)
    {
      if (!this.zzbtz.isEmpty()) {
        break label65;
      }
      localMap = Collections.emptyMap();
      this.zzbtz = localMap;
      if (!this.zzbub.isEmpty()) {
        break label76;
      }
    }
    label65:
    label76:
    for (Map localMap = Collections.emptyMap();; localMap = Collections.unmodifiableMap(this.zzbub))
    {
      this.zzbub = localMap;
      this.zzbls = true;
      AppMethodBeat.o(40158);
      return;
      localMap = Collections.unmodifiableMap(this.zzbtz);
      break;
    }
  }
  
  public final int zzuj()
  {
    AppMethodBeat.i(40159);
    int i = this.zzbty.size();
    AppMethodBeat.o(40159);
    return i;
  }
  
  public final Iterable<Map.Entry<K, V>> zzuk()
  {
    AppMethodBeat.i(40161);
    if (this.zzbtz.isEmpty())
    {
      localObject = zzaba.zzun();
      AppMethodBeat.o(40161);
      return localObject;
    }
    Object localObject = this.zzbtz.entrySet();
    AppMethodBeat.o(40161);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzaay
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.common.util;

import android.support.v4.f.a;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class zza<E>
  extends AbstractSet<E>
{
  private final a<E, E> zzaHS;
  
  public zza()
  {
    this.zzaHS = new a();
  }
  
  public zza(int paramInt)
  {
    this.zzaHS = new a(paramInt);
  }
  
  public zza(Collection<E> paramCollection)
  {
    this(paramCollection.size());
    addAll(paramCollection);
  }
  
  public boolean add(E paramE)
  {
    if (this.zzaHS.containsKey(paramE)) {
      return false;
    }
    this.zzaHS.put(paramE, paramE);
    return true;
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    if ((paramCollection instanceof zza)) {
      return zza((zza)paramCollection);
    }
    return super.addAll(paramCollection);
  }
  
  public void clear()
  {
    this.zzaHS.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.zzaHS.containsKey(paramObject);
  }
  
  public Iterator<E> iterator()
  {
    return this.zzaHS.keySet().iterator();
  }
  
  public boolean remove(Object paramObject)
  {
    if (!this.zzaHS.containsKey(paramObject)) {
      return false;
    }
    this.zzaHS.remove(paramObject);
    return true;
  }
  
  public int size()
  {
    return this.zzaHS.size();
  }
  
  public boolean zza(zza<? extends E> paramzza)
  {
    int i = size();
    this.zzaHS.a(paramzza.zzaHS);
    return size() > i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.util.zza
 * JD-Core Version:    0.7.0.1
 */
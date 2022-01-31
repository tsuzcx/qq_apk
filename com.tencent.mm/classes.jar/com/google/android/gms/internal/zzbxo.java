package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.List<Lcom.google.android.gms.internal.zzbxv;>;

public class zzbxo<M extends zzbxn<M>, T>
{
  public final int tag;
  protected final int type;
  protected final Class<T> zzckQ;
  protected final boolean zzcuB;
  
  private zzbxo(int paramInt1, Class<T> paramClass, int paramInt2, boolean paramBoolean)
  {
    this.type = paramInt1;
    this.zzckQ = paramClass;
    this.tag = paramInt2;
    this.zzcuB = paramBoolean;
  }
  
  public static <M extends zzbxn<M>, T extends zzbxt> zzbxo<M, T> zza(int paramInt, Class<T> paramClass, long paramLong)
  {
    return new zzbxo(paramInt, paramClass, (int)paramLong, false);
  }
  
  private T zzad(List<zzbxv> paramList)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localObject = (zzbxv)paramList.get(i);
      if (((zzbxv)localObject).zzbyd.length != 0) {
        zza((zzbxv)localObject, localArrayList);
      }
      i += 1;
    }
    int k = localArrayList.size();
    if (k == 0)
    {
      paramList = null;
      return paramList;
    }
    Object localObject = this.zzckQ.cast(Array.newInstance(this.zzckQ.getComponentType(), k));
    i = j;
    for (;;)
    {
      paramList = (List<zzbxv>)localObject;
      if (i >= k) {
        break;
      }
      Array.set(localObject, i, localArrayList.get(i));
      i += 1;
    }
  }
  
  private T zzae(List<zzbxv> paramList)
  {
    if (paramList.isEmpty()) {
      return null;
    }
    paramList = (zzbxv)paramList.get(paramList.size() - 1);
    return this.zzckQ.cast(zzaN(zzbxl.zzaf(paramList.zzbyd)));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzbxo)) {
        return false;
      }
      paramObject = (zzbxo)paramObject;
    } while ((this.type == paramObject.type) && (this.zzckQ == paramObject.zzckQ) && (this.tag == paramObject.tag) && (this.zzcuB == paramObject.zzcuB));
    return false;
  }
  
  public int hashCode()
  {
    int j = this.type;
    int k = this.zzckQ.hashCode();
    int m = this.tag;
    if (this.zzcuB) {}
    for (int i = 1;; i = 0) {
      return i + (((j + 1147) * 31 + k) * 31 + m) * 31;
    }
  }
  
  protected void zza(zzbxv paramzzbxv, List<Object> paramList)
  {
    paramList.add(zzaN(zzbxl.zzaf(paramzzbxv.zzbyd)));
  }
  
  void zza(Object paramObject, zzbxm paramzzbxm)
  {
    if (this.zzcuB)
    {
      zzc(paramObject, paramzzbxm);
      return;
    }
    zzb(paramObject, paramzzbxm);
  }
  
  protected Object zzaN(zzbxl paramzzbxl)
  {
    Object localObject;
    if (this.zzcuB) {
      localObject = this.zzckQ.getComponentType();
    }
    for (;;)
    {
      try
      {
        switch (this.type)
        {
        case 10: 
          int i = this.type;
          throw new IllegalArgumentException(24 + "Unknown type " + i);
        }
      }
      catch (InstantiationException paramzzbxl)
      {
        localObject = String.valueOf(localObject);
        throw new IllegalArgumentException(String.valueOf(localObject).length() + 33 + "Error creating instance of class " + (String)localObject, paramzzbxl);
        localObject = this.zzckQ;
        continue;
        zzbxt localzzbxt = (zzbxt)((Class)localObject).newInstance();
        paramzzbxl.zza(localzzbxt, zzbxw.zzrr(this.tag));
        return localzzbxt;
        localzzbxt = (zzbxt)((Class)localObject).newInstance();
        paramzzbxl.zza(localzzbxt);
        return localzzbxt;
      }
      catch (IllegalAccessException paramzzbxl)
      {
        localObject = String.valueOf(localObject);
        throw new IllegalArgumentException(String.valueOf(localObject).length() + 33 + "Error creating instance of class " + (String)localObject, paramzzbxl);
      }
      catch (IOException paramzzbxl)
      {
        throw new IllegalArgumentException("Error reading extension field", paramzzbxl);
      }
    }
  }
  
  int zzaU(Object paramObject)
  {
    if (this.zzcuB) {
      return zzaV(paramObject);
    }
    return zzaW(paramObject);
  }
  
  protected int zzaV(Object paramObject)
  {
    int m = Array.getLength(paramObject);
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (Array.get(paramObject, i) != null) {
        k = j + zzaW(Array.get(paramObject, i));
      }
      i += 1;
    }
    return j;
  }
  
  protected int zzaW(Object paramObject)
  {
    int i = zzbxw.zzrr(this.tag);
    switch (this.type)
    {
    default: 
      i = this.type;
      throw new IllegalArgumentException(24 + "Unknown type " + i);
    case 10: 
      return zzbxm.zzb(i, (zzbxt)paramObject);
    }
    return zzbxm.zzc(i, (zzbxt)paramObject);
  }
  
  final T zzac(List<zzbxv> paramList)
  {
    if (paramList == null) {
      return null;
    }
    if (this.zzcuB) {
      return zzad(paramList);
    }
    return zzae(paramList);
  }
  
  protected void zzb(Object paramObject, zzbxm paramzzbxm)
  {
    for (;;)
    {
      try
      {
        paramzzbxm.zzrj(this.tag);
        switch (this.type)
        {
        case 10: 
          i = this.type;
          throw new IllegalArgumentException(24 + "Unknown type " + i);
        }
      }
      catch (IOException paramObject)
      {
        throw new IllegalStateException(paramObject);
      }
      paramObject = (zzbxt)paramObject;
      int i = zzbxw.zzrr(this.tag);
      paramzzbxm.zzb(paramObject);
      paramzzbxm.zzN(i, 4);
      return;
      paramzzbxm.zzc((zzbxt)paramObject);
      return;
    }
  }
  
  protected void zzc(Object paramObject, zzbxm paramzzbxm)
  {
    int j = Array.getLength(paramObject);
    int i = 0;
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      if (localObject != null) {
        zzb(localObject, paramzzbxm);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzbxo
 * JD-Core Version:    0.7.0.1
 */
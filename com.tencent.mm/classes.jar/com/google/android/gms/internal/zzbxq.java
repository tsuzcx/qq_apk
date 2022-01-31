package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class zzbxq
  implements Cloneable
{
  private Object value;
  private zzbxo<?, ?> zzcuG;
  private List<zzbxv> zzcuH = new ArrayList();
  
  private byte[] toByteArray()
  {
    byte[] arrayOfByte = new byte[zzu()];
    zza(zzbxm.zzag(arrayOfByte));
    return arrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof zzbxq));
      paramObject = (zzbxq)paramObject;
      if ((this.value == null) || (paramObject.value == null)) {
        break;
      }
      bool1 = bool2;
    } while (this.zzcuG != paramObject.zzcuG);
    if (!this.zzcuG.zzckQ.isArray()) {
      return this.value.equals(paramObject.value);
    }
    if ((this.value instanceof byte[])) {
      return Arrays.equals((byte[])this.value, (byte[])paramObject.value);
    }
    if ((this.value instanceof int[])) {
      return Arrays.equals((int[])this.value, (int[])paramObject.value);
    }
    if ((this.value instanceof long[])) {
      return Arrays.equals((long[])this.value, (long[])paramObject.value);
    }
    if ((this.value instanceof float[])) {
      return Arrays.equals((float[])this.value, (float[])paramObject.value);
    }
    if ((this.value instanceof double[])) {
      return Arrays.equals((double[])this.value, (double[])paramObject.value);
    }
    if ((this.value instanceof boolean[])) {
      return Arrays.equals((boolean[])this.value, (boolean[])paramObject.value);
    }
    return Arrays.deepEquals((Object[])this.value, (Object[])paramObject.value);
    if ((this.zzcuH != null) && (paramObject.zzcuH != null)) {
      return this.zzcuH.equals(paramObject.zzcuH);
    }
    try
    {
      bool1 = Arrays.equals(toByteArray(), paramObject.toByteArray());
      return bool1;
    }
    catch (IOException paramObject)
    {
      throw new IllegalStateException(paramObject);
    }
  }
  
  public int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(toByteArray());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }
  
  void zza(zzbxm paramzzbxm)
  {
    if (this.value != null) {
      this.zzcuG.zza(this.value, paramzzbxm);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.zzcuH.iterator();
      while (localIterator.hasNext()) {
        ((zzbxv)localIterator.next()).zza(paramzzbxm);
      }
    }
  }
  
  void zza(zzbxv paramzzbxv)
  {
    this.zzcuH.add(paramzzbxv);
  }
  
  public final zzbxq zzaeJ()
  {
    zzbxq localzzbxq = new zzbxq();
    try
    {
      localzzbxq.zzcuG = this.zzcuG;
      if (this.zzcuH == null) {
        localzzbxq.zzcuH = null;
      }
      for (;;)
      {
        if (this.value == null) {
          return localzzbxq;
        }
        if (!(this.value instanceof zzbxt)) {
          break;
        }
        localzzbxq.value = ((zzbxt)((zzbxt)this.value).clone());
        return localzzbxq;
        localzzbxq.zzcuH.addAll(this.zzcuH);
      }
      if (!(this.value instanceof byte[])) {
        break label117;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
    localCloneNotSupportedException.value = ((byte[])this.value).clone();
    return localCloneNotSupportedException;
    label117:
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.value instanceof byte[][]))
    {
      localObject1 = (byte[][])this.value;
      localObject2 = new byte[localObject1.length][];
      localCloneNotSupportedException.value = localObject2;
      i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((byte[])localObject1[i].clone());
        i += 1;
      }
    }
    if ((this.value instanceof boolean[]))
    {
      localCloneNotSupportedException.value = ((boolean[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof int[]))
    {
      localCloneNotSupportedException.value = ((int[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof long[]))
    {
      localCloneNotSupportedException.value = ((long[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof float[]))
    {
      localCloneNotSupportedException.value = ((float[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof double[]))
    {
      localCloneNotSupportedException.value = ((double[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof zzbxt[]))
    {
      localObject1 = (zzbxt[])this.value;
      localObject2 = new zzbxt[localObject1.length];
      localCloneNotSupportedException.value = localObject2;
      i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((zzbxt)localObject1[i].clone());
        i += 1;
      }
    }
    return localCloneNotSupportedException;
  }
  
  <T> T zzb(zzbxo<?, T> paramzzbxo)
  {
    if (this.value != null)
    {
      if (!this.zzcuG.equals(paramzzbxo)) {
        throw new IllegalStateException("Tried to getExtension with a different Extension.");
      }
    }
    else
    {
      this.zzcuG = paramzzbxo;
      this.value = paramzzbxo.zzac(this.zzcuH);
      this.zzcuH = null;
    }
    return this.value;
  }
  
  int zzu()
  {
    int j;
    if (this.value != null)
    {
      j = this.zzcuG.zzaU(this.value);
      return j;
    }
    Iterator localIterator = this.zzcuH.iterator();
    for (int i = 0;; i = ((zzbxv)localIterator.next()).zzu() + i)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzbxq
 * JD-Core Version:    0.7.0.1
 */
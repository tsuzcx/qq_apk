package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class zzabz<M extends zzaby<M>, T>
{
  public final int tag;
  private final int type;
  protected final Class<T> zzbwx;
  protected final boolean zzbwy;
  private final zzzq<?, ?> zzbwz;
  
  private zzabz(int paramInt1, Class<T> paramClass, int paramInt2, boolean paramBoolean)
  {
    this(11, paramClass, null, 810, false);
  }
  
  private zzabz(int paramInt1, Class<T> paramClass, zzzq<?, ?> paramzzzq, int paramInt2, boolean paramBoolean)
  {
    this.type = paramInt1;
    this.zzbwx = paramClass;
    this.tag = paramInt2;
    this.zzbwy = false;
    this.zzbwz = null;
  }
  
  public static <M extends zzaby<M>, T extends zzace> zzabz<M, T> zza(int paramInt, Class<T> paramClass, long paramLong)
  {
    AppMethodBeat.i(3481);
    paramClass = new zzabz(11, paramClass, 810, false);
    AppMethodBeat.o(3481);
    return paramClass;
  }
  
  private final Object zzf(zzabv paramzzabv)
  {
    AppMethodBeat.i(3484);
    Object localObject;
    if (this.zzbwy) {
      localObject = this.zzbwx.getComponentType();
    }
    for (;;)
    {
      try
      {
        switch (this.type)
        {
        case 10: 
          int i = this.type;
          paramzzabv = new IllegalArgumentException(24 + "Unknown type " + i);
          AppMethodBeat.o(3484);
          throw paramzzabv;
        }
      }
      catch (InstantiationException paramzzabv)
      {
        localObject = String.valueOf(localObject);
        paramzzabv = new IllegalArgumentException(String.valueOf(localObject).length() + 33 + "Error creating instance of class " + (String)localObject, paramzzabv);
        AppMethodBeat.o(3484);
        throw paramzzabv;
        localObject = this.zzbwx;
        continue;
        zzace localzzace = (zzace)((Class)localObject).newInstance();
        paramzzabv.zza(localzzace, this.tag >>> 3);
        AppMethodBeat.o(3484);
        return localzzace;
        localzzace = (zzace)((Class)localObject).newInstance();
        paramzzabv.zza(localzzace);
        AppMethodBeat.o(3484);
        return localzzace;
      }
      catch (IllegalAccessException paramzzabv)
      {
        localObject = String.valueOf(localObject);
        paramzzabv = new IllegalArgumentException(String.valueOf(localObject).length() + 33 + "Error creating instance of class " + (String)localObject, paramzzabv);
        AppMethodBeat.o(3484);
        throw paramzzabv;
      }
      catch (IOException paramzzabv)
      {
        paramzzabv = new IllegalArgumentException("Error reading extension field", paramzzabv);
        AppMethodBeat.o(3484);
        throw paramzzabv;
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzabz)) {
        return false;
      }
      paramObject = (zzabz)paramObject;
    } while ((this.type == paramObject.type) && (this.zzbwx == paramObject.zzbwx) && (this.tag == paramObject.tag) && (this.zzbwy == paramObject.zzbwy));
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(3482);
    int j = this.type;
    int k = this.zzbwx.hashCode();
    int m = this.tag;
    if (this.zzbwy) {}
    for (int i = 1;; i = 0)
    {
      AppMethodBeat.o(3482);
      return i + (((j + 1147) * 31 + k) * 31 + m) * 31;
    }
  }
  
  protected final void zza(Object paramObject, zzabw paramzzabw)
  {
    AppMethodBeat.i(3485);
    for (;;)
    {
      try
      {
        paramzzabw.zzar(this.tag);
        switch (this.type)
        {
        case 10: 
          i = this.type;
          paramObject = new IllegalArgumentException(24 + "Unknown type " + i);
          AppMethodBeat.o(3485);
          throw paramObject;
        }
      }
      catch (IOException paramObject)
      {
        paramObject = new IllegalStateException(paramObject);
        AppMethodBeat.o(3485);
        throw paramObject;
      }
      int i = this.tag;
      ((zzace)paramObject).zza(paramzzabw);
      paramzzabw.zzg(i >>> 3, 4);
      AppMethodBeat.o(3485);
      return;
      paramzzabw.zzb((zzace)paramObject);
      AppMethodBeat.o(3485);
      return;
    }
  }
  
  final T zzi(List<zzacg> paramList)
  {
    int j = 0;
    AppMethodBeat.i(3483);
    if (paramList == null)
    {
      AppMethodBeat.o(3483);
      return null;
    }
    if (this.zzbwy)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        zzacg localzzacg = (zzacg)paramList.get(i);
        if (localzzacg.zzbrc.length != 0) {
          localArrayList.add(zzf(zzabv.zzi(localzzacg.zzbrc)));
        }
        i += 1;
      }
      int k = localArrayList.size();
      if (k == 0)
      {
        AppMethodBeat.o(3483);
        return null;
      }
      paramList = this.zzbwx.cast(Array.newInstance(this.zzbwx.getComponentType(), k));
      i = j;
      while (i < k)
      {
        Array.set(paramList, i, localArrayList.get(i));
        i += 1;
      }
      AppMethodBeat.o(3483);
      return paramList;
    }
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(3483);
      return null;
    }
    paramList = (zzacg)paramList.get(paramList.size() - 1);
    paramList = this.zzbwx.cast(zzf(zzabv.zzi(paramList.zzbrc)));
    AppMethodBeat.o(3483);
    return paramList;
  }
  
  protected final int zzv(Object paramObject)
  {
    AppMethodBeat.i(3486);
    int i = this.tag >>> 3;
    switch (this.type)
    {
    default: 
      i = this.type;
      paramObject = new IllegalArgumentException(24 + "Unknown type " + i);
      AppMethodBeat.o(3486);
      throw paramObject;
    case 10: 
      paramObject = (zzace)paramObject;
      i = zzabw.zzaq(i);
      int j = paramObject.zzvm();
      AppMethodBeat.o(3486);
      return (i << 1) + j;
    }
    i = zzabw.zzb(i, (zzace)paramObject);
    AppMethodBeat.o(3486);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzabz
 * JD-Core Version:    0.7.0.1
 */
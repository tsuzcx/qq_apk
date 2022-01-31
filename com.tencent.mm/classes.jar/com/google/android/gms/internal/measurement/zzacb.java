package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class zzacb
  implements Cloneable
{
  private Object value;
  private zzabz<?, ?> zzbxe;
  private List<zzacg> zzbxf;
  
  zzacb()
  {
    AppMethodBeat.i(3494);
    this.zzbxf = new ArrayList();
    AppMethodBeat.o(3494);
  }
  
  private final byte[] toByteArray()
  {
    AppMethodBeat.i(3501);
    byte[] arrayOfByte = new byte[zza()];
    zza(zzabw.zzj(arrayOfByte));
    AppMethodBeat.o(3501);
    return arrayOfByte;
  }
  
  private final zzacb zzvg()
  {
    AppMethodBeat.i(3502);
    zzacb localzzacb = new zzacb();
    for (;;)
    {
      AssertionError localAssertionError;
      try
      {
        localzzacb.zzbxe = this.zzbxe;
        if (this.zzbxf == null)
        {
          localzzacb.zzbxf = null;
          if (this.value != null)
          {
            if ((this.value instanceof zzace)) {
              localzzacb.value = ((zzace)((zzace)this.value).clone());
            }
          }
          else
          {
            AppMethodBeat.o(3502);
            return localzzacb;
          }
        }
        else
        {
          localzzacb.zzbxf.addAll(this.zzbxf);
          continue;
        }
        if (!(this.value instanceof byte[])) {
          break label138;
        }
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        localAssertionError = new AssertionError(localCloneNotSupportedException);
        AppMethodBeat.o(3502);
        throw localAssertionError;
      }
      localAssertionError.value = ((byte[])this.value).clone();
      continue;
      label138:
      Object localObject1;
      Object localObject2;
      int i;
      if ((this.value instanceof byte[][]))
      {
        localObject1 = (byte[][])this.value;
        localObject2 = new byte[localObject1.length][];
        localAssertionError.value = localObject2;
        i = 0;
        while (i < localObject1.length)
        {
          localObject2[i] = ((byte[])localObject1[i].clone());
          i += 1;
        }
      }
      else if ((this.value instanceof boolean[]))
      {
        localAssertionError.value = ((boolean[])this.value).clone();
      }
      else if ((this.value instanceof int[]))
      {
        localAssertionError.value = ((int[])this.value).clone();
      }
      else if ((this.value instanceof long[]))
      {
        localAssertionError.value = ((long[])this.value).clone();
      }
      else if ((this.value instanceof float[]))
      {
        localAssertionError.value = ((float[])this.value).clone();
      }
      else if ((this.value instanceof double[]))
      {
        localAssertionError.value = ((double[])this.value).clone();
      }
      else if ((this.value instanceof zzace[]))
      {
        localObject1 = (zzace[])this.value;
        localObject2 = new zzace[localObject1.length];
        localAssertionError.value = localObject2;
        i = 0;
        while (i < localObject1.length)
        {
          localObject2[i] = ((zzace)localObject1[i].clone());
          i += 1;
        }
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(3499);
    if (paramObject == this)
    {
      AppMethodBeat.o(3499);
      return true;
    }
    if (!(paramObject instanceof zzacb))
    {
      AppMethodBeat.o(3499);
      return false;
    }
    paramObject = (zzacb)paramObject;
    boolean bool;
    if ((this.value != null) && (paramObject.value != null))
    {
      if (this.zzbxe != paramObject.zzbxe)
      {
        AppMethodBeat.o(3499);
        return false;
      }
      if (!this.zzbxe.zzbwx.isArray())
      {
        bool = this.value.equals(paramObject.value);
        AppMethodBeat.o(3499);
        return bool;
      }
      if ((this.value instanceof byte[]))
      {
        bool = Arrays.equals((byte[])this.value, (byte[])paramObject.value);
        AppMethodBeat.o(3499);
        return bool;
      }
      if ((this.value instanceof int[]))
      {
        bool = Arrays.equals((int[])this.value, (int[])paramObject.value);
        AppMethodBeat.o(3499);
        return bool;
      }
      if ((this.value instanceof long[]))
      {
        bool = Arrays.equals((long[])this.value, (long[])paramObject.value);
        AppMethodBeat.o(3499);
        return bool;
      }
      if ((this.value instanceof float[]))
      {
        bool = Arrays.equals((float[])this.value, (float[])paramObject.value);
        AppMethodBeat.o(3499);
        return bool;
      }
      if ((this.value instanceof double[]))
      {
        bool = Arrays.equals((double[])this.value, (double[])paramObject.value);
        AppMethodBeat.o(3499);
        return bool;
      }
      if ((this.value instanceof boolean[]))
      {
        bool = Arrays.equals((boolean[])this.value, (boolean[])paramObject.value);
        AppMethodBeat.o(3499);
        return bool;
      }
      bool = Arrays.deepEquals((Object[])this.value, (Object[])paramObject.value);
      AppMethodBeat.o(3499);
      return bool;
    }
    if ((this.zzbxf != null) && (paramObject.zzbxf != null))
    {
      bool = this.zzbxf.equals(paramObject.zzbxf);
      AppMethodBeat.o(3499);
      return bool;
    }
    try
    {
      bool = Arrays.equals(toByteArray(), paramObject.toByteArray());
      AppMethodBeat.o(3499);
      return bool;
    }
    catch (IOException paramObject)
    {
      paramObject = new IllegalStateException(paramObject);
      AppMethodBeat.o(3499);
      throw paramObject;
    }
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(3500);
    try
    {
      int i = Arrays.hashCode(toByteArray());
      AppMethodBeat.o(3500);
      return i + 527;
    }
    catch (IOException localIOException)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException(localIOException);
      AppMethodBeat.o(3500);
      throw localIllegalStateException;
    }
  }
  
  final int zza()
  {
    int i = 0;
    AppMethodBeat.i(3497);
    Object localObject1;
    Object localObject2;
    if (this.value != null)
    {
      localObject1 = this.zzbxe;
      localObject2 = this.value;
      if (((zzabz)localObject1).zzbwy)
      {
        int m = Array.getLength(localObject2);
        int k = 0;
        for (i = 0;; i = j)
        {
          j = i;
          if (k >= m) {
            break;
          }
          j = i;
          if (Array.get(localObject2, k) != null) {
            j = i + ((zzabz)localObject1).zzv(Array.get(localObject2, k));
          }
          k += 1;
        }
      }
    }
    for (int j = ((zzabz)localObject1).zzv(localObject2);; j = i)
    {
      AppMethodBeat.o(3497);
      return j;
      localObject1 = this.zzbxf.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (zzacg)((Iterator)localObject1).next();
        j = zzabw.zzas(((zzacg)localObject2).tag);
        i = ((zzacg)localObject2).zzbrc.length + (j + 0) + i;
      }
    }
  }
  
  final void zza(zzabw paramzzabw)
  {
    AppMethodBeat.i(3498);
    Object localObject2;
    if (this.value != null)
    {
      localObject1 = this.zzbxe;
      localObject2 = this.value;
      if (((zzabz)localObject1).zzbwy)
      {
        int j = Array.getLength(localObject2);
        int i = 0;
        while (i < j)
        {
          Object localObject3 = Array.get(localObject2, i);
          if (localObject3 != null) {
            ((zzabz)localObject1).zza(localObject3, paramzzabw);
          }
          i += 1;
        }
        AppMethodBeat.o(3498);
        return;
      }
      ((zzabz)localObject1).zza(localObject2, paramzzabw);
      AppMethodBeat.o(3498);
      return;
    }
    Object localObject1 = this.zzbxf.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (zzacg)((Iterator)localObject1).next();
      paramzzabw.zzar(((zzacg)localObject2).tag);
      paramzzabw.zzk(((zzacg)localObject2).zzbrc);
    }
    AppMethodBeat.o(3498);
  }
  
  final void zza(zzacg paramzzacg)
  {
    AppMethodBeat.i(3495);
    if (this.zzbxf != null)
    {
      this.zzbxf.add(paramzzacg);
      AppMethodBeat.o(3495);
      return;
    }
    Object localObject;
    if ((this.value instanceof zzace))
    {
      paramzzacg = paramzzacg.zzbrc;
      localObject = zzabv.zza(paramzzacg, 0, paramzzacg.length);
      int i = ((zzabv)localObject).zzuy();
      if (i != paramzzacg.length - zzabw.zzao(i))
      {
        paramzzacg = zzacd.zzvh();
        AppMethodBeat.o(3495);
        throw paramzzacg;
      }
      paramzzacg = ((zzace)this.value).zzb((zzabv)localObject);
    }
    for (;;)
    {
      this.zzbxe = this.zzbxe;
      this.value = paramzzacg;
      this.zzbxf = null;
      AppMethodBeat.o(3495);
      return;
      if ((this.value instanceof zzace[]))
      {
        localObject = (zzace[])this.zzbxe.zzi(Collections.singletonList(paramzzacg));
        zzace[] arrayOfzzace = (zzace[])this.value;
        paramzzacg = (zzace[])Arrays.copyOf(arrayOfzzace, arrayOfzzace.length + localObject.length);
        System.arraycopy(localObject, 0, paramzzacg, arrayOfzzace.length, localObject.length);
      }
      else
      {
        paramzzacg = this.zzbxe.zzi(Collections.singletonList(paramzzacg));
      }
    }
  }
  
  final <T> T zzb(zzabz<?, T> paramzzabz)
  {
    AppMethodBeat.i(3496);
    if (this.value != null)
    {
      if (!this.zzbxe.equals(paramzzabz))
      {
        paramzzabz = new IllegalStateException("Tried to getExtension with a different Extension.");
        AppMethodBeat.o(3496);
        throw paramzzabz;
      }
    }
    else
    {
      this.zzbxe = paramzzabz;
      this.value = paramzzabz.zzi(this.zzbxf);
      this.zzbxf = null;
    }
    paramzzabz = this.value;
    AppMethodBeat.o(3496);
    return paramzzabz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzacb
 * JD-Core Version:    0.7.0.1
 */
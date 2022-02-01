package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class zzq
  implements Cloneable
{
  private Object value;
  private zzo<?, ?> zzhi;
  private List<zzv> zzhj;
  
  zzq()
  {
    AppMethodBeat.i(100742);
    this.zzhj = new ArrayList();
    AppMethodBeat.o(100742);
  }
  
  private final byte[] toByteArray()
  {
    AppMethodBeat.i(100748);
    byte[] arrayOfByte = new byte[zzg()];
    zza(zzl.zzb(arrayOfByte));
    AppMethodBeat.o(100748);
    return arrayOfByte;
  }
  
  private final zzq zzt()
  {
    AppMethodBeat.i(100749);
    zzq localzzq = new zzq();
    for (;;)
    {
      AssertionError localAssertionError;
      try
      {
        localzzq.zzhi = this.zzhi;
        if (this.zzhj == null)
        {
          localzzq.zzhj = null;
          if (this.value != null)
          {
            if ((this.value instanceof zzt)) {
              localzzq.value = ((zzt)((zzt)this.value).clone());
            }
          }
          else
          {
            AppMethodBeat.o(100749);
            return localzzq;
          }
        }
        else
        {
          localzzq.zzhj.addAll(this.zzhj);
          continue;
        }
        if (!(this.value instanceof byte[])) {
          break label135;
        }
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        localAssertionError = new AssertionError(localCloneNotSupportedException);
        AppMethodBeat.o(100749);
        throw localAssertionError;
      }
      localAssertionError.value = ((byte[])this.value).clone();
      continue;
      label135:
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
      else if ((this.value instanceof zzt[]))
      {
        localObject1 = (zzt[])this.value;
        localObject2 = new zzt[localObject1.length];
        localAssertionError.value = localObject2;
        i = 0;
        while (i < localObject1.length)
        {
          localObject2[i] = ((zzt)localObject1[i].clone());
          i += 1;
        }
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(100746);
    if (paramObject == this)
    {
      AppMethodBeat.o(100746);
      return true;
    }
    if (!(paramObject instanceof zzq))
    {
      AppMethodBeat.o(100746);
      return false;
    }
    paramObject = (zzq)paramObject;
    boolean bool;
    if ((this.value != null) && (paramObject.value != null))
    {
      if (this.zzhi != paramObject.zzhi)
      {
        AppMethodBeat.o(100746);
        return false;
      }
      if (!this.zzhi.zzhd.isArray())
      {
        bool = this.value.equals(paramObject.value);
        AppMethodBeat.o(100746);
        return bool;
      }
      if ((this.value instanceof byte[]))
      {
        bool = Arrays.equals((byte[])this.value, (byte[])paramObject.value);
        AppMethodBeat.o(100746);
        return bool;
      }
      if ((this.value instanceof int[]))
      {
        bool = Arrays.equals((int[])this.value, (int[])paramObject.value);
        AppMethodBeat.o(100746);
        return bool;
      }
      if ((this.value instanceof long[]))
      {
        bool = Arrays.equals((long[])this.value, (long[])paramObject.value);
        AppMethodBeat.o(100746);
        return bool;
      }
      if ((this.value instanceof float[]))
      {
        bool = Arrays.equals((float[])this.value, (float[])paramObject.value);
        AppMethodBeat.o(100746);
        return bool;
      }
      if ((this.value instanceof double[]))
      {
        bool = Arrays.equals((double[])this.value, (double[])paramObject.value);
        AppMethodBeat.o(100746);
        return bool;
      }
      if ((this.value instanceof boolean[]))
      {
        bool = Arrays.equals((boolean[])this.value, (boolean[])paramObject.value);
        AppMethodBeat.o(100746);
        return bool;
      }
      bool = Arrays.deepEquals((Object[])this.value, (Object[])paramObject.value);
      AppMethodBeat.o(100746);
      return bool;
    }
    if ((this.zzhj != null) && (paramObject.zzhj != null))
    {
      bool = this.zzhj.equals(paramObject.zzhj);
      AppMethodBeat.o(100746);
      return bool;
    }
    try
    {
      bool = Arrays.equals(toByteArray(), paramObject.toByteArray());
      AppMethodBeat.o(100746);
      return bool;
    }
    catch (IOException paramObject)
    {
      paramObject = new IllegalStateException(paramObject);
      AppMethodBeat.o(100746);
      throw paramObject;
    }
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(100747);
    try
    {
      int i = Arrays.hashCode(toByteArray());
      AppMethodBeat.o(100747);
      return i + 527;
    }
    catch (IOException localIOException)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException(localIOException);
      AppMethodBeat.o(100747);
      throw localIllegalStateException;
    }
  }
  
  final void zza(zzl paramzzl)
  {
    AppMethodBeat.i(100745);
    if (this.value != null)
    {
      paramzzl = new NoSuchMethodError();
      AppMethodBeat.o(100745);
      throw paramzzl;
    }
    Iterator localIterator = this.zzhj.iterator();
    while (localIterator.hasNext())
    {
      zzv localzzv = (zzv)localIterator.next();
      paramzzl.zzl(localzzv.tag);
      paramzzl.zzc(localzzv.zzhm);
    }
    AppMethodBeat.o(100745);
  }
  
  final void zza(zzv paramzzv)
  {
    AppMethodBeat.i(100743);
    if (this.zzhj != null)
    {
      this.zzhj.add(paramzzv);
      AppMethodBeat.o(100743);
      return;
    }
    if ((this.value instanceof zzt))
    {
      paramzzv = paramzzv.zzhm;
      zzk localzzk = zzk.zza(paramzzv, 0, paramzzv.length);
      int i = localzzk.zzk();
      if (i != paramzzv.length - zzl.zzi(i))
      {
        paramzzv = zzs.zzu();
        AppMethodBeat.o(100743);
        throw paramzzv;
      }
      paramzzv = ((zzt)this.value).zza(localzzk);
      this.zzhi = this.zzhi;
      this.value = paramzzv;
      this.zzhj = null;
      AppMethodBeat.o(100743);
      return;
    }
    if ((this.value instanceof zzt[]))
    {
      Collections.singletonList(paramzzv);
      paramzzv = new NoSuchMethodError();
      AppMethodBeat.o(100743);
      throw paramzzv;
    }
    Collections.singletonList(paramzzv);
    paramzzv = new NoSuchMethodError();
    AppMethodBeat.o(100743);
    throw paramzzv;
  }
  
  final int zzg()
  {
    AppMethodBeat.i(100744);
    if (this.value != null)
    {
      localObject = new NoSuchMethodError();
      AppMethodBeat.o(100744);
      throw ((Throwable)localObject);
    }
    Object localObject = this.zzhj.iterator();
    zzv localzzv;
    int j;
    for (int i = 0; ((Iterator)localObject).hasNext(); i = localzzv.zzhm.length + (j + 0) + i)
    {
      localzzv = (zzv)((Iterator)localObject).next();
      j = zzl.zzm(localzzv.tag);
    }
    AppMethodBeat.o(100744);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzq
 * JD-Core Version:    0.7.0.1
 */
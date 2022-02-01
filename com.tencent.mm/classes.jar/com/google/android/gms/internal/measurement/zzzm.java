package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

final class zzzm<FieldDescriptorType extends zzzo<FieldDescriptorType>>
{
  private static final zzzm zzbru;
  private boolean zzbls;
  private final zzaay<FieldDescriptorType, Object> zzbrs;
  private boolean zzbrt;
  
  static
  {
    AppMethodBeat.i(40370);
    zzbru = new zzzm(true);
    AppMethodBeat.o(40370);
  }
  
  private zzzm()
  {
    AppMethodBeat.i(40362);
    this.zzbrt = false;
    this.zzbrs = zzaay.zzag(16);
    AppMethodBeat.o(40362);
  }
  
  private zzzm(boolean paramBoolean)
  {
    AppMethodBeat.i(40363);
    this.zzbrt = false;
    this.zzbrs = zzaay.zzag(0);
    if (!this.zzbls)
    {
      this.zzbrs.zzrg();
      this.zzbls = true;
    }
    AppMethodBeat.o(40363);
  }
  
  private static void zza(zzabp paramzzabp, Object paramObject)
  {
    boolean bool = false;
    AppMethodBeat.i(40368);
    zzzr.checkNotNull(paramObject);
    switch (zzzn.zzbrv[paramzzabp.zzuv().ordinal()])
    {
    }
    while (!bool)
    {
      paramzzabp = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      AppMethodBeat.o(40368);
      throw paramzzabp;
      bool = paramObject instanceof Integer;
      continue;
      bool = paramObject instanceof Long;
      continue;
      bool = paramObject instanceof Float;
      continue;
      bool = paramObject instanceof Double;
      continue;
      bool = paramObject instanceof Boolean;
      continue;
      bool = paramObject instanceof String;
      continue;
      if (((paramObject instanceof zzyw)) || ((paramObject instanceof byte[])))
      {
        bool = true;
        continue;
        if (((paramObject instanceof Integer)) || ((paramObject instanceof zzzs)))
        {
          bool = true;
          continue;
          if (((paramObject instanceof zzaal)) || ((paramObject instanceof zzzu))) {
            bool = true;
          }
        }
      }
    }
    AppMethodBeat.o(40368);
  }
  
  private final void zza(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    AppMethodBeat.i(40367);
    if (paramFieldDescriptorType.zztk())
    {
      if (!(paramObject instanceof List))
      {
        paramFieldDescriptorType = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        AppMethodBeat.o(40367);
        throw paramFieldDescriptorType;
      }
      ArrayList localArrayList1 = new ArrayList();
      localArrayList1.addAll((List)paramObject);
      ArrayList localArrayList2 = (ArrayList)localArrayList1;
      int j = localArrayList2.size();
      int i = 0;
      for (;;)
      {
        paramObject = localArrayList1;
        if (i >= j) {
          break;
        }
        paramObject = localArrayList2.get(i);
        i += 1;
        zza(paramFieldDescriptorType.zztj(), paramObject);
      }
    }
    zza(paramFieldDescriptorType.zztj(), paramObject);
    if ((paramObject instanceof zzzu)) {
      this.zzbrt = true;
    }
    this.zzbrs.zza(paramFieldDescriptorType, paramObject);
    AppMethodBeat.o(40367);
  }
  
  public static <T extends zzzo<T>> zzzm<T> zzti()
  {
    return zzbru;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(40364);
    if (this == paramObject)
    {
      AppMethodBeat.o(40364);
      return true;
    }
    if (!(paramObject instanceof zzzm))
    {
      AppMethodBeat.o(40364);
      return false;
    }
    paramObject = (zzzm)paramObject;
    boolean bool = this.zzbrs.equals(paramObject.zzbrs);
    AppMethodBeat.o(40364);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(40365);
    int i = this.zzbrs.hashCode();
    AppMethodBeat.o(40365);
    return i;
  }
  
  public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator()
  {
    AppMethodBeat.i(40366);
    if (this.zzbrt)
    {
      localObject = new zzzx(this.zzbrs.entrySet().iterator());
      AppMethodBeat.o(40366);
      return localObject;
    }
    Object localObject = this.zzbrs.entrySet().iterator();
    AppMethodBeat.o(40366);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzzm
 * JD-Core Version:    0.7.0.1
 */
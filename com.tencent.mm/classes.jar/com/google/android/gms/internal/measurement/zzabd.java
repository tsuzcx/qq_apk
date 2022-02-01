package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map.Entry;

final class zzabd
  implements Comparable<zzabd>, Map.Entry<K, V>
{
  private V value;
  private final K zzbue;
  
  zzabd(K paramK, V paramV)
  {
    this.zzbue = paramV;
    Object localObject;
    this.value = localObject;
  }
  
  zzabd(Map.Entry<K, V> paramEntry)
  {
    this(paramEntry, (Comparable)localObject.getKey(), localObject.getValue());
    AppMethodBeat.i(40183);
    AppMethodBeat.o(40183);
  }
  
  private static boolean equals(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(40188);
    if (paramObject1 == null)
    {
      if (paramObject2 == null)
      {
        AppMethodBeat.o(40188);
        return true;
      }
      AppMethodBeat.o(40188);
      return false;
    }
    boolean bool = paramObject1.equals(paramObject2);
    AppMethodBeat.o(40188);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(40185);
    if (paramObject == this)
    {
      AppMethodBeat.o(40185);
      return true;
    }
    if (!(paramObject instanceof Map.Entry))
    {
      AppMethodBeat.o(40185);
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    if ((equals(this.zzbue, paramObject.getKey())) && (equals(this.value, paramObject.getValue())))
    {
      AppMethodBeat.o(40185);
      return true;
    }
    AppMethodBeat.o(40185);
    return false;
  }
  
  public final V getValue()
  {
    return this.value;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(40186);
    int i;
    if (this.zzbue == null)
    {
      i = 0;
      if (this.value != null) {
        break label43;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(40186);
      return i ^ j;
      i = this.zzbue.hashCode();
      break;
      label43:
      j = this.value.hashCode();
    }
  }
  
  public final V setValue(V paramV)
  {
    AppMethodBeat.i(40184);
    zzaay.zza(this.zzbuf);
    Object localObject = this.value;
    this.value = paramV;
    AppMethodBeat.o(40184);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(40187);
    String str1 = String.valueOf(this.zzbue);
    String str2 = String.valueOf(this.value);
    str1 = String.valueOf(str1).length() + 1 + String.valueOf(str2).length() + str1 + "=" + str2;
    AppMethodBeat.o(40187);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzabd
 * JD-Core Version:    0.7.0.1
 */
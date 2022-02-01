package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map.Entry;

final class zzzw<K>
  implements Map.Entry<K, Object>
{
  private Map.Entry<K, zzzu> zzbsu;
  
  private zzzw(Map.Entry<K, zzzu> paramEntry)
  {
    this.zzbsu = paramEntry;
  }
  
  public final K getKey()
  {
    AppMethodBeat.i(40384);
    Object localObject = this.zzbsu.getKey();
    AppMethodBeat.o(40384);
    return localObject;
  }
  
  public final Object getValue()
  {
    AppMethodBeat.i(40385);
    if ((zzzu)this.zzbsu.getValue() == null)
    {
      AppMethodBeat.o(40385);
      return null;
    }
    zzaal localzzaal = zzzu.zzto();
    AppMethodBeat.o(40385);
    return localzzaal;
  }
  
  public final Object setValue(Object paramObject)
  {
    AppMethodBeat.i(40386);
    if (!(paramObject instanceof zzaal))
    {
      paramObject = new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
      AppMethodBeat.o(40386);
      throw paramObject;
    }
    paramObject = ((zzzu)this.zzbsu.getValue()).zzc((zzaal)paramObject);
    AppMethodBeat.o(40386);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzzw
 * JD-Core Version:    0.7.0.1
 */
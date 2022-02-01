package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzabf
  extends AbstractSet<Map.Entry<K, V>>
{
  private zzabf(zzaay paramzzaay) {}
  
  public final void clear()
  {
    AppMethodBeat.i(40198);
    this.zzbuf.clear();
    AppMethodBeat.o(40198);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(40196);
    Object localObject = (Map.Entry)paramObject;
    paramObject = this.zzbuf.get(((Map.Entry)localObject).getKey());
    localObject = ((Map.Entry)localObject).getValue();
    if ((paramObject == localObject) || ((paramObject != null) && (paramObject.equals(localObject))))
    {
      AppMethodBeat.o(40196);
      return true;
    }
    AppMethodBeat.o(40196);
    return false;
  }
  
  public final Iterator<Map.Entry<K, V>> iterator()
  {
    AppMethodBeat.i(40194);
    zzabe localzzabe = new zzabe(this.zzbuf, null);
    AppMethodBeat.o(40194);
    return localzzabe;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(40197);
    paramObject = (Map.Entry)paramObject;
    if (contains(paramObject))
    {
      this.zzbuf.remove(paramObject.getKey());
      AppMethodBeat.o(40197);
      return true;
    }
    AppMethodBeat.o(40197);
    return false;
  }
  
  public final int size()
  {
    AppMethodBeat.i(40195);
    int i = this.zzbuf.size();
    AppMethodBeat.o(40195);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzabf
 * JD-Core Version:    0.7.0.1
 */
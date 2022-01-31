package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzzx<K>
  implements Iterator<Map.Entry<K, Object>>
{
  private Iterator<Map.Entry<K, Object>> zzbsv;
  
  public zzzx(Iterator<Map.Entry<K, Object>> paramIterator)
  {
    this.zzbsv = paramIterator;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(3597);
    boolean bool = this.zzbsv.hasNext();
    AppMethodBeat.o(3597);
    return bool;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(3598);
    this.zzbsv.remove();
    AppMethodBeat.o(3598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzzx
 * JD-Core Version:    0.7.0.1
 */
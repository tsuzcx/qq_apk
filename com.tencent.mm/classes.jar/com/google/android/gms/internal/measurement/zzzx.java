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
    AppMethodBeat.i(40387);
    boolean bool = this.zzbsv.hasNext();
    AppMethodBeat.o(40387);
    return bool;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(40388);
    this.zzbsv.remove();
    AppMethodBeat.o(40388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzzx
 * JD-Core Version:    0.7.0.1
 */
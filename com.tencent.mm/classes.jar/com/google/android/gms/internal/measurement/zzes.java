package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;

final class zzes
  implements Iterator<String>
{
  private Iterator<String> zzafz;
  
  zzes(zzer paramzzer)
  {
    AppMethodBeat.i(68740);
    this.zzafz = zzer.zza(this.zzaga).keySet().iterator();
    AppMethodBeat.o(68740);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(68741);
    boolean bool = this.zzafz.hasNext();
    AppMethodBeat.o(68741);
    return bool;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(68742);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Remove not supported");
    AppMethodBeat.o(68742);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzes
 * JD-Core Version:    0.7.0.1
 */
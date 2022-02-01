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
    AppMethodBeat.i(1263);
    this.zzafz = zzer.zza(this.zzaga).keySet().iterator();
    AppMethodBeat.o(1263);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(1264);
    boolean bool = this.zzafz.hasNext();
    AppMethodBeat.o(1264);
    return bool;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(1265);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Remove not supported");
    AppMethodBeat.o(1265);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzes
 * JD-Core Version:    0.7.0.1
 */
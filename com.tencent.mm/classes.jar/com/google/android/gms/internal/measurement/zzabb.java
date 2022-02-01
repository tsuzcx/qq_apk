package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzabb
  implements Iterator<Object>
{
  public final boolean hasNext()
  {
    return false;
  }
  
  public final Object next()
  {
    AppMethodBeat.i(40180);
    NoSuchElementException localNoSuchElementException = new NoSuchElementException();
    AppMethodBeat.o(40180);
    throw localNoSuchElementException;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(40181);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(40181);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzabb
 * JD-Core Version:    0.7.0.1
 */
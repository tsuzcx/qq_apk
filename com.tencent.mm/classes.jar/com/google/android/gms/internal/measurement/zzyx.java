package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzyx
  implements Iterator
{
  private final int limit;
  private int position;
  
  zzyx(zzyw paramzzyw)
  {
    AppMethodBeat.i(40338);
    this.position = 0;
    this.limit = this.zzbqz.size();
    AppMethodBeat.o(40338);
  }
  
  private final byte nextByte()
  {
    AppMethodBeat.i(40339);
    try
    {
      zzyw localzzyw = this.zzbqz;
      int i = this.position;
      this.position = (i + 1);
      byte b = localzzyw.zzae(i);
      AppMethodBeat.o(40339);
      return b;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      NoSuchElementException localNoSuchElementException = new NoSuchElementException(localIndexOutOfBoundsException.getMessage());
      AppMethodBeat.o(40339);
      throw localNoSuchElementException;
    }
  }
  
  public final boolean hasNext()
  {
    return this.position < this.limit;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(40340);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(40340);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzyx
 * JD-Core Version:    0.7.0.1
 */
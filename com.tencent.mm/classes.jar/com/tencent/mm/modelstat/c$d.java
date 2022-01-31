package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.Locale;

final class c$d
  implements Serializable, Comparable<d>
{
  String fSr = null;
  int left;
  long time = 0L;
  int top;
  int type = 0;
  
  public final String toString()
  {
    AppMethodBeat.i(78669);
    String str = String.format(Locale.getDefault(), "[%s,%s]", new Object[] { this.fSr, c.hb(this.time) });
    AppMethodBeat.o(78669);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.c.d
 * JD-Core Version:    0.7.0.1
 */
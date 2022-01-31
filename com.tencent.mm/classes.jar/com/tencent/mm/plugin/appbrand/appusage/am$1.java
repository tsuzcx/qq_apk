package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

final class am$1
  implements Iterator<Object[]>
{
  boolean hcS;
  final Object[] hcT;
  
  am$1(am paramam, Cursor paramCursor)
  {
    AppMethodBeat.i(129723);
    this.hcT = new Object[3];
    AppMethodBeat.o(129723);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(129724);
    if (this.hcS)
    {
      bool = this.hcU.moveToNext();
      if (!bool) {
        this.hcU.close();
      }
      AppMethodBeat.o(129724);
      return bool;
    }
    this.hcS = true;
    boolean bool = this.hcU.moveToFirst();
    AppMethodBeat.o(129724);
    return bool;
  }
  
  public final void remove() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.am.1
 * JD-Core Version:    0.7.0.1
 */
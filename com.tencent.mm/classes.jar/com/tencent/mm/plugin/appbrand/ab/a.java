package com.tencent.mm.plugin.appbrand.ab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ab.d.d;

public abstract interface a
{
  public abstract void b(d paramd);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(156600);
      lNo = new a("NOT_YET_CONNECTED", 0);
      lNp = new a("CONNECTING", 1);
      lNq = new a("OPEN", 2);
      lNr = new a("CLOSING", 3);
      lNs = new a("CLOSED", 4);
      lNt = new a[] { lNo, lNp, lNq, lNr, lNs };
      AppMethodBeat.o(156600);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab.a
 * JD-Core Version:    0.7.0.1
 */
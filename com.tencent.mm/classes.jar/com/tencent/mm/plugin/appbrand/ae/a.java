package com.tencent.mm.plugin.appbrand.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.d.d;

public abstract interface a
{
  public abstract void b(d paramd);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(156600);
      oid = new a("NOT_YET_CONNECTED", 0);
      oie = new a("CONNECTING", 1);
      oif = new a("OPEN", 2);
      oig = new a("CLOSING", 3);
      oih = new a("CLOSED", 4);
      oii = new a[] { oid, oie, oif, oig, oih };
      AppMethodBeat.o(156600);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae.a
 * JD-Core Version:    0.7.0.1
 */
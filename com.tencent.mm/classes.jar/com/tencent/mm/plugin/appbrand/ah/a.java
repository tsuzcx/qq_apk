package com.tencent.mm.plugin.appbrand.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ah.d.d;

public abstract interface a
{
  public abstract void b(d paramd);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(156600);
      uua = new a("NOT_YET_CONNECTED", 0);
      uub = new a("CONNECTING", 1);
      uuc = new a("OPEN", 2);
      uud = new a("CLOSING", 3);
      uue = new a("CLOSED", 4);
      uuf = new a[] { uua, uub, uuc, uud, uue };
      AppMethodBeat.o(156600);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ah.a
 * JD-Core Version:    0.7.0.1
 */
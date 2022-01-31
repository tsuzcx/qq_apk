package com.tencent.mm.plugin.appbrand.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.u.d.d;

public abstract interface a
{
  public abstract void b(d paramd);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(73203);
      iYy = new a("NOT_YET_CONNECTED", 0);
      iYz = new a("CONNECTING", 1);
      iYA = new a("OPEN", 2);
      iYB = new a("CLOSING", 3);
      iYC = new a("CLOSED", 4);
      iYD = new a[] { iYy, iYz, iYA, iYB, iYC };
      AppMethodBeat.o(73203);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(73206);
      iYE = new b("CLIENT", 0);
      iYF = new b("SERVER", 1);
      iYG = new b[] { iYE, iYF };
      AppMethodBeat.o(73206);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.a
 * JD-Core Version:    0.7.0.1
 */
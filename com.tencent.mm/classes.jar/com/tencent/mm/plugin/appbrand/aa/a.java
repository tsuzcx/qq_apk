package com.tencent.mm.plugin.appbrand.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.d.d;

public abstract interface a
{
  public abstract void b(d paramd);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(156600);
      mpo = new a("NOT_YET_CONNECTED", 0);
      mpp = new a("CONNECTING", 1);
      mpq = new a("OPEN", 2);
      mpr = new a("CLOSING", 3);
      mps = new a("CLOSED", 4);
      mpt = new a[] { mpo, mpp, mpq, mpr, mps };
      AppMethodBeat.o(156600);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(156603);
      mpu = new b("CLIENT", 0);
      mpv = new b("SERVER", 1);
      mpw = new b[] { mpu, mpv };
      AppMethodBeat.o(156603);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.a
 * JD-Core Version:    0.7.0.1
 */
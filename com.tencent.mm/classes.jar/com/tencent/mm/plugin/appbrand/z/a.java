package com.tencent.mm.plugin.appbrand.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.d.d;

public abstract interface a
{
  public abstract void b(d paramd);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(156600);
      mVd = new a("NOT_YET_CONNECTED", 0);
      mVe = new a("CONNECTING", 1);
      mVf = new a("OPEN", 2);
      mVg = new a("CLOSING", 3);
      mVh = new a("CLOSED", 4);
      mVi = new a[] { mVd, mVe, mVf, mVg, mVh };
      AppMethodBeat.o(156600);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.z.a
 * JD-Core Version:    0.7.0.1
 */
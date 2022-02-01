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
      mPT = new a("NOT_YET_CONNECTED", 0);
      mPU = new a("CONNECTING", 1);
      mPV = new a("OPEN", 2);
      mPW = new a("CLOSING", 3);
      mPX = new a("CLOSED", 4);
      mPY = new a[] { mPT, mPU, mPV, mPW, mPX };
      AppMethodBeat.o(156600);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.a
 * JD-Core Version:    0.7.0.1
 */
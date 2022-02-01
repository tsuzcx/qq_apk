package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface o
{
  public static enum a
  {
    static
    {
      AppMethodBeat.i(146954);
      iSO = new a("NONE", 0);
      iSP = new a("UNKNOWN", 1);
      iSQ = new a("MISSING_PARAMS", 2);
      iSR = new a("NO_SUCH_KEY", 3);
      iSS = new a("QUOTA_REACHED", 4);
      iST = new a("MEMORY_ISSUE", 5);
      iSU = new a[] { iSO, iSP, iSQ, iSR, iSS, iST };
      AppMethodBeat.o(146954);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.o
 * JD-Core Version:    0.7.0.1
 */
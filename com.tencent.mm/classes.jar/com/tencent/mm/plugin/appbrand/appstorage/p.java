package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface p
{
  public static enum a
  {
    static
    {
      AppMethodBeat.i(146954);
      kSP = new a("NONE", 0);
      kSQ = new a("UNKNOWN", 1);
      kSR = new a("MISSING_PARAMS", 2);
      kSS = new a("NO_SUCH_KEY", 3);
      kST = new a("QUOTA_REACHED", 4);
      kSU = new a("MEMORY_ISSUE", 5);
      kSV = new a[] { kSP, kSQ, kSR, kSS, kST, kSU };
      AppMethodBeat.o(146954);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.p
 * JD-Core Version:    0.7.0.1
 */
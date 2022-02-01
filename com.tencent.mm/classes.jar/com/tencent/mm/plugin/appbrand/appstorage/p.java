package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface p
{
  public static enum a
  {
    static
    {
      AppMethodBeat.i(146954);
      jQg = new a("NONE", 0);
      jQh = new a("UNKNOWN", 1);
      jQi = new a("MISSING_PARAMS", 2);
      jQj = new a("NO_SUCH_KEY", 3);
      jQk = new a("QUOTA_REACHED", 4);
      jQl = new a("MEMORY_ISSUE", 5);
      jQm = new a[] { jQg, jQh, jQi, jQj, jQk, jQl };
      AppMethodBeat.o(146954);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.p
 * JD-Core Version:    0.7.0.1
 */
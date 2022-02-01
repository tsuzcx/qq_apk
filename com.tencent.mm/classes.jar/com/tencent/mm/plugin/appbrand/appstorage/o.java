package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface o
{
  public static enum a
  {
    static
    {
      AppMethodBeat.i(146954);
      jMT = new a("NONE", 0);
      jMU = new a("UNKNOWN", 1);
      jMV = new a("MISSING_PARAMS", 2);
      jMW = new a("NO_SUCH_KEY", 3);
      jMX = new a("QUOTA_REACHED", 4);
      jMY = new a("MEMORY_ISSUE", 5);
      jMZ = new a[] { jMT, jMU, jMV, jMW, jMX, jMY };
      AppMethodBeat.o(146954);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.o
 * JD-Core Version:    0.7.0.1
 */
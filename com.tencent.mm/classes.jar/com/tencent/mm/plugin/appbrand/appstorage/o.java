package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface o
{
  public static enum a
  {
    static
    {
      AppMethodBeat.i(146954);
      jsZ = new a("NONE", 0);
      jta = new a("UNKNOWN", 1);
      jtb = new a("MISSING_PARAMS", 2);
      jtc = new a("NO_SUCH_KEY", 3);
      jtd = new a("QUOTA_REACHED", 4);
      jte = new a("MEMORY_ISSUE", 5);
      jtf = new a[] { jsZ, jta, jtb, jtc, jtd, jte };
      AppMethodBeat.o(146954);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.o
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum v$a
{
  static
  {
    AppMethodBeat.i(146954);
    qNg = new a("NONE", 0);
    qNh = new a("UNKNOWN", 1);
    qNi = new a("MISSING_PARAMS", 2);
    qNj = new a("NO_SUCH_KEY", 3);
    qNk = new a("QUOTA_REACHED", 4);
    qNl = new a("MEMORY_ISSUE", 5);
    qNm = new a[] { qNg, qNh, qNi, qNj, qNk, qNl };
    AppMethodBeat.o(146954);
  }
  
  private v$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.v.a
 * JD-Core Version:    0.7.0.1
 */
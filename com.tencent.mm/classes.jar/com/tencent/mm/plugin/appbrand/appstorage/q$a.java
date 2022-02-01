package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum q$a
{
  static
  {
    AppMethodBeat.i(146954);
    nNn = new a("NONE", 0);
    nNo = new a("UNKNOWN", 1);
    nNp = new a("MISSING_PARAMS", 2);
    nNq = new a("NO_SUCH_KEY", 3);
    nNr = new a("QUOTA_REACHED", 4);
    nNs = new a("MEMORY_ISSUE", 5);
    nNt = new a[] { nNn, nNo, nNp, nNq, nNr, nNs };
    AppMethodBeat.o(146954);
  }
  
  private q$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.q.a
 * JD-Core Version:    0.7.0.1
 */
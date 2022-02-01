package com.tencent.mm.plugin.appbrand.af;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$a
{
  static
  {
    AppMethodBeat.i(156600);
    rkr = new a("NOT_YET_CONNECTED", 0);
    rks = new a("CONNECTING", 1);
    rkt = new a("OPEN", 2);
    rku = new a("CLOSING", 3);
    rkv = new a("CLOSED", 4);
    rkw = new a[] { rkr, rks, rkt, rku, rkv };
    AppMethodBeat.o(156600);
  }
  
  private a$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af.a.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b$a
{
  static
  {
    AppMethodBeat.i(108106);
    igx = new a("NOT_YET_CONNECTED", 0);
    igy = new a("CONNECTING", 1);
    igz = new a("OPEN", 2);
    igA = new a("CLOSING", 3);
    igB = new a("CLOSED", 4);
    igC = new a[] { igx, igy, igz, igA, igB };
    AppMethodBeat.o(108106);
  }
  
  private b$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.b.a
 * JD-Core Version:    0.7.0.1
 */
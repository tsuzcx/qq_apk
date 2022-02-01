package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b$a
{
  static
  {
    AppMethodBeat.i(144273);
    pFK = new a("NOT_YET_CONNECTED", 0);
    pFL = new a("CONNECTING", 1);
    pFM = new a("OPEN", 2);
    pFN = new a("CLOSING", 3);
    pFO = new a("CLOSED", 4);
    pFP = new a[] { pFK, pFL, pFM, pFN, pFO };
    AppMethodBeat.o(144273);
  }
  
  private b$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.b.a
 * JD-Core Version:    0.7.0.1
 */
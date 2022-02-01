package com.tencent.mm.compatible.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c$a
{
  static
  {
    AppMethodBeat.i(155551);
    gCM = new a("PCM", 0);
    gCN = new a("AMR", 1);
    gCO = new a("SILK", 2);
    gCP = new a("SPEEX", 3);
    gCQ = new a("UNKNOWN", 4);
    gCR = new a[] { gCM, gCN, gCO, gCP, gCQ };
    AppMethodBeat.o(155551);
  }
  
  private c$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.b.c.a
 * JD-Core Version:    0.7.0.1
 */
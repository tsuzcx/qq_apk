package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum lf
{
  static
  {
    AppMethodBeat.i(222684);
    a = new lf("START", 0);
    b = new lf("RUNNING", 1);
    c = new lf("CANCEL", 2);
    d = new lf("FINISH", 3);
    e = new lf("ERROR", 4);
    f = new lf[] { a, b, c, d, e };
    AppMethodBeat.o(222684);
  }
  
  private lf() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.lf
 * JD-Core Version:    0.7.0.1
 */
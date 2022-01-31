package com.tencent.mm.plugin.appbrand.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$b
{
  public final int hkJ;
  
  static
  {
    AppMethodBeat.i(86909);
    hkD = new b("PORTRAIT", 0, 1);
    hkE = new b("UNSPECIFIED", 1, -1);
    hkF = new b("LANDSCAPE_SENSOR", 2, 6);
    hkG = new b("LANDSCAPE_LOCKED", 3, 0);
    hkH = new b("LANDSCAPE_LEFT", 4, 8);
    hkI = new b("LANDSCAPE_RIGHT", 5, 0);
    hkK = new b[] { hkD, hkE, hkF, hkG, hkH, hkI };
    AppMethodBeat.o(86909);
  }
  
  private a$b(int paramInt)
  {
    this.hkJ = paramInt;
  }
  
  public final boolean c(b paramb)
  {
    return (this == paramb) || ((this == hkF) && (paramb == hkG)) || ((this == hkG) && (paramb == hkF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.a.b
 * JD-Core Version:    0.7.0.1
 */
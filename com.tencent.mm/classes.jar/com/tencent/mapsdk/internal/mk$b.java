package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum mk$b
{
  public int g;
  
  static
  {
    AppMethodBeat.i(221816);
    a = new b("UnderMainMap", 0, 2);
    b = new b("Under3DBuiding", 1, 4);
    c = new b("UnderHandDraw", 2, 6);
    d = new b("UnderPoi", 3, 8);
    e = new b("UnderToplayer", 4, 10);
    f = new b("AboveToplayer", 5, 12);
    h = new b[] { a, b, c, d, e, f };
    AppMethodBeat.o(221816);
  }
  
  private mk$b(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mapsdk.internal.mk.b
 * JD-Core Version:    0.7.0.1
 */
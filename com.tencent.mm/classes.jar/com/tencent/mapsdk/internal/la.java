package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum la
{
  private final int j;
  
  static
  {
    AppMethodBeat.i(222730);
    a = new la("NONE", 0, -1);
    b = new la("SATELLITE", 1, 0);
    c = new la("MAP", 2, 1);
    d = new la("STREET_VIEW_ROAD", 3, 2);
    e = new la("TRAFFIC_NETWORK", 4, 3);
    f = new la("INDOOR_BUILDINGS", 5, 4);
    g = new la("LANDMARK", 6, 5);
    h = new la("TILE_OVERLAY", 7, 6);
    i = new la("NUM", 8, 7);
    k = new la[] { a, b, c, d, e, f, g, h, i };
    AppMethodBeat.o(222730);
  }
  
  private la(int paramInt)
  {
    this.j = paramInt;
  }
  
  private int a()
  {
    return this.j;
  }
  
  private static la a(int paramInt)
  {
    AppMethodBeat.i(222715);
    Object localObject = values();
    int n = localObject.length;
    int m = 0;
    while (m < n)
    {
      la localla = localObject[m];
      if (localla.j == paramInt)
      {
        AppMethodBeat.o(222715);
        return localla;
      }
      m += 1;
    }
    localObject = a;
    AppMethodBeat.o(222715);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mapsdk.internal.la
 * JD-Core Version:    0.7.0.1
 */
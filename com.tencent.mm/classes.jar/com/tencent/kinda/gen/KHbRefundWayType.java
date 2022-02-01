package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum KHbRefundWayType
{
  static
  {
    AppMethodBeat.i(219755);
    ORIGIN = new KHbRefundWayType("ORIGIN", 0);
    LQ = new KHbRefundWayType("LQ", 1);
    $VALUES = new KHbRefundWayType[] { ORIGIN, LQ };
    AppMethodBeat.o(219755);
  }
  
  private KHbRefundWayType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KHbRefundWayType
 * JD-Core Version:    0.7.0.1
 */
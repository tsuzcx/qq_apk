package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum n$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(132662);
    iHY = new a("GUIDE_EXPOSE", 0, 1);
    iHZ = new a("GUIDE_CLOSE", 1, 2);
    iIa = new a("TO_APP_LAUNCHER", 2, 3);
    iIb = new a("GUIDE_CLOSE_BY_BACK", 3, 4);
    iIc = new a[] { iHY, iHZ, iIa, iIb };
    AppMethodBeat.o(132662);
  }
  
  private n$a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.n.a
 * JD-Core Version:    0.7.0.1
 */
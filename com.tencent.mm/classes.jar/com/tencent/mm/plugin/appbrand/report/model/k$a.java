package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum k$a
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(132639);
    iHx = new a("NEARBY_H5", 0, 1);
    iHy = new a("EMPTY_PAGE", 1, 2);
    iHz = new a("LBS_NOT_ALLOW", 2, 3);
    iHA = new a("NEARBY_MINI_PROGRAM", 3, 4);
    iHB = new a[] { iHx, iHy, iHz, iHA };
    AppMethodBeat.o(132639);
  }
  
  private k$a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.k.a
 * JD-Core Version:    0.7.0.1
 */
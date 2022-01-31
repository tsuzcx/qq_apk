package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum k$b
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(132642);
    iHC = new b("DESKTOP_SEARCH", 0, 1);
    iHD = new b("RESUME_FROM_WEAPP_EXIT", 1, 2);
    iHE = new b("BOTTOM_ENTRANCE_IN_DESKTOP", 2, 3);
    iHF = new b("TOP_ENTRANCE_IN_DESKTOP", 3, 4);
    iHG = new b[] { iHC, iHD, iHE, iHF };
    AppMethodBeat.o(132642);
  }
  
  private k$b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.k.b
 * JD-Core Version:    0.7.0.1
 */
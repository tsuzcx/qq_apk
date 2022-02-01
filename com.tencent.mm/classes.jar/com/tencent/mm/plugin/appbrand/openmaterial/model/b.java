package com.tencent.mm.plugin.appbrand.openmaterial.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  private final int nlQ;
  
  static
  {
    AppMethodBeat.i(194365);
    nlM = new b("WEB_VIEW", 0, 1);
    nlN = new b("IMAGE", 1, 2);
    nlO = new b("VIDEO", 2, 2);
    nlP = new b("ATTACH", 3, 4);
    nlR = new b[] { nlM, nlN, nlO, nlP };
    AppMethodBeat.o(194365);
  }
  
  private b(int paramInt)
  {
    this.nlQ = paramInt;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    return (this.nlQ & paramInt) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.model.b
 * JD-Core Version:    0.7.0.1
 */
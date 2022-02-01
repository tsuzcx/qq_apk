package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum i
{
  static
  {
    AppMethodBeat.i(48224);
    muP = new i("CreateOnRuntimeInit", 0);
    muQ = new i("PreloadOnProcessCreated", 1);
    muR = new i("PreloadBeforeRuntimeInit", 2);
    muS = new i[] { muP, muQ, muR };
    AppMethodBeat.o(48224);
  }
  
  private i() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.i
 * JD-Core Version:    0.7.0.1
 */
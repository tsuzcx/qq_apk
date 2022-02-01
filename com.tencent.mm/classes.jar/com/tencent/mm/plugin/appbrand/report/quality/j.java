package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum j
{
  static
  {
    AppMethodBeat.i(48224);
    nKR = new j("CreateOnRuntimeInit", 0);
    nKS = new j("PreloadOnProcessCreated", 1);
    nKT = new j("PreloadBeforeRuntimeInit", 2);
    nKU = new j[] { nKR, nKS, nKT };
    AppMethodBeat.o(48224);
  }
  
  private j() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.j
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum i
{
  static
  {
    AppMethodBeat.i(48224);
    tRN = new i("CreateOnRuntimeInit", 0);
    tRO = new i("PreloadOnProcessCreated", 1);
    tRP = new i("PreloadBeforeRuntimeInit", 2);
    tRQ = new i[] { tRN, tRO, tRP };
    AppMethodBeat.o(48224);
  }
  
  private i() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.i
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum i
{
  static
  {
    AppMethodBeat.i(48224);
    lUZ = new i("CreateOnRuntimeInit", 0);
    lVa = new i("PreloadOnProcessCreated", 1);
    lVb = new i("PreloadBeforeRuntimeInit", 2);
    lVc = new i[] { lUZ, lVa, lVb };
    AppMethodBeat.o(48224);
  }
  
  private i() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.i
 * JD-Core Version:    0.7.0.1
 */
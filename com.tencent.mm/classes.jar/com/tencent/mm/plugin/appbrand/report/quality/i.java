package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum i
{
  static
  {
    AppMethodBeat.i(48224);
    ltf = new i("CreateOnRuntimeInit", 0);
    ltg = new i("PreloadOnProcessCreated", 1);
    lth = new i("PreloadBeforeRuntimeInit", 2);
    lti = new i[] { ltf, ltg, lth };
    AppMethodBeat.o(48224);
  }
  
  private i() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.i
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum i
{
  static
  {
    AppMethodBeat.i(48224);
    mzM = new i("CreateOnRuntimeInit", 0);
    mzN = new i("PreloadOnProcessCreated", 1);
    mzO = new i("PreloadBeforeRuntimeInit", 2);
    mzP = new i[] { mzM, mzN, mzO };
    AppMethodBeat.o(48224);
  }
  
  private i() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.i
 * JD-Core Version:    0.7.0.1
 */
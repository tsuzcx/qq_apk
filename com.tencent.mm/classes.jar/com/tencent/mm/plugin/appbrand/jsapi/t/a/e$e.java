package com.tencent.mm.plugin.appbrand.jsapi.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e$e
{
  public String state;
  
  static
  {
    AppMethodBeat.i(145948);
    ifM = new e("START", 0, "start");
    ifN = new e("PAUSE", 1, "pause");
    ifO = new e("STOP", 2, "stop");
    ifP = new e("ERROR", 3, "error");
    ifQ = new e("FRAMERECORDED", 4, "frameRecorded");
    ifR = new e("INTERRUPTIONBEGIN", 5, "interruptionBegin");
    ifS = new e("INTERUPTIONEND", 6, "interruptionEnd");
    ifT = new e[] { ifM, ifN, ifO, ifP, ifQ, ifR, ifS };
    AppMethodBeat.o(145948);
  }
  
  private e$e(String paramString)
  {
    this.state = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a.e.e
 * JD-Core Version:    0.7.0.1
 */
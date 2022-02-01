package com.tencent.mm.plugin.appbrand.jsapi.af.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c$a
{
  public int pEW;
  public String pEX;
  
  static
  {
    AppMethodBeat.i(137901);
    pEQ = new a("AUTO", 0, 0, "auto");
    pER = new a("MIC", 1, 1, "mic");
    pES = new a("CAMCORDER", 2, 5, "camcorder");
    pET = new a("VOICE_RECOGNITION", 3, 6, "voice_recognition");
    pEU = new a("VOICE_COMMUNICATION", 4, 7, "voice_communication");
    pEV = new a("UNPROCESSED", 5, 9, "unprocessed");
    pEY = new a[] { pEQ, pER, pES, pET, pEU, pEV };
    AppMethodBeat.o(137901);
  }
  
  private c$a(int paramInt, String paramString)
  {
    this.pEW = paramInt;
    this.pEX = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af.a.c.a
 * JD-Core Version:    0.7.0.1
 */
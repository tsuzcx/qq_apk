package com.tencent.mm.plugin.appbrand.jsapi.ab.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c$a
{
  public int lyL;
  public String lyM;
  
  static
  {
    AppMethodBeat.i(137901);
    lyF = new a("AUTO", 0, 0, "auto");
    lyG = new a("MIC", 1, 1, "mic");
    lyH = new a("CAMCORDER", 2, 5, "camcorder");
    lyI = new a("VOICE_RECOGNITION", 3, 6, "voice_recognition");
    lyJ = new a("VOICE_COMMUNICATION", 4, 7, "voice_communication");
    lyK = new a("UNPROCESSED", 5, 9, "unprocessed");
    lyN = new a[] { lyF, lyG, lyH, lyI, lyJ, lyK };
    AppMethodBeat.o(137901);
  }
  
  private c$a(int paramInt, String paramString)
  {
    this.lyL = paramInt;
    this.lyM = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.a.c.a
 * JD-Core Version:    0.7.0.1
 */
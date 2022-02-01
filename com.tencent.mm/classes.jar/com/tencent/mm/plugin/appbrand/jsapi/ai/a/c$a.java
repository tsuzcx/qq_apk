package com.tencent.mm.plugin.appbrand.jsapi.ai.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c$a
{
  public int sKh;
  public String sKi;
  
  static
  {
    AppMethodBeat.i(137901);
    sKb = new a("AUTO", 0, 0, "auto");
    sKc = new a("MIC", 1, 1, "mic");
    sKd = new a("CAMCORDER", 2, 5, "camcorder");
    sKe = new a("VOICE_RECOGNITION", 3, 6, "voice_recognition");
    sKf = new a("VOICE_COMMUNICATION", 4, 7, "voice_communication");
    sKg = new a("UNPROCESSED", 5, 9, "unprocessed");
    sKj = new a[] { sKb, sKc, sKd, sKe, sKf, sKg };
    AppMethodBeat.o(137901);
  }
  
  private c$a(int paramInt, String paramString)
  {
    this.sKh = paramInt;
    this.sKi = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.a.c.a
 * JD-Core Version:    0.7.0.1
 */
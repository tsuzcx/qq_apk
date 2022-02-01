package com.tencent.mm.plugin.appbrand.jsapi.x.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c$a
{
  public int kXn;
  public String kXo;
  
  static
  {
    AppMethodBeat.i(137901);
    kXh = new a("AUTO", 0, 0, "auto");
    kXi = new a("MIC", 1, 1, "mic");
    kXj = new a("CAMCORDER", 2, 5, "camcorder");
    kXk = new a("VOICE_RECOGNITION", 3, 6, "voice_recognition");
    kXl = new a("VOICE_COMMUNICATION", 4, 7, "voice_communication");
    kXm = new a("UNPROCESSED", 5, 9, "unprocessed");
    kXp = new a[] { kXh, kXi, kXj, kXk, kXl, kXm };
    AppMethodBeat.o(137901);
  }
  
  private c$a(int paramInt, String paramString)
  {
    this.kXn = paramInt;
    this.kXo = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.a.c.a
 * JD-Core Version:    0.7.0.1
 */
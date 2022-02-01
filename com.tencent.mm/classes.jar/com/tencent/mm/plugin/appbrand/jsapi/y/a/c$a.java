package com.tencent.mm.plugin.appbrand.jsapi.y.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c$a
{
  public int kvZ;
  public String kwa;
  
  static
  {
    AppMethodBeat.i(137901);
    kvT = new a("AUTO", 0, 0, "auto");
    kvU = new a("MIC", 1, 1, "mic");
    kvV = new a("CAMCORDER", 2, 5, "camcorder");
    kvW = new a("VOICE_RECOGNITION", 3, 6, "voice_recognition");
    kvX = new a("VOICE_COMMUNICATION", 4, 7, "voice_communication");
    kvY = new a("UNPROCESSED", 5, 9, "unprocessed");
    kwb = new a[] { kvT, kvU, kvV, kvW, kvX, kvY };
    AppMethodBeat.o(137901);
  }
  
  private c$a(int paramInt, String paramString)
  {
    this.kvZ = paramInt;
    this.kwa = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.a.c.a
 * JD-Core Version:    0.7.0.1
 */
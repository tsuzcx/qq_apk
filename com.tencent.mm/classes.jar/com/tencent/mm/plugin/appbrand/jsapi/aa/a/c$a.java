package com.tencent.mm.plugin.appbrand.jsapi.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c$a
{
  public int lum;
  public String lun;
  
  static
  {
    AppMethodBeat.i(137901);
    lug = new a("AUTO", 0, 0, "auto");
    luh = new a("MIC", 1, 1, "mic");
    lui = new a("CAMCORDER", 2, 5, "camcorder");
    luj = new a("VOICE_RECOGNITION", 3, 6, "voice_recognition");
    luk = new a("VOICE_COMMUNICATION", 4, 7, "voice_communication");
    lul = new a("UNPROCESSED", 5, 9, "unprocessed");
    luo = new a[] { lug, luh, lui, luj, luk, lul };
    AppMethodBeat.o(137901);
  }
  
  private c$a(int paramInt, String paramString)
  {
    this.lum = paramInt;
    this.lun = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.a.c.a
 * JD-Core Version:    0.7.0.1
 */
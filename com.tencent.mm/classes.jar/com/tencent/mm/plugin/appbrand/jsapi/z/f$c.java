package com.tencent.mm.plugin.appbrand.jsapi.z;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f$c
{
  public final String value;
  
  static
  {
    AppMethodBeat.i(137663);
    mtL = new c("None", 0, "none");
    mtM = new c("Mobile_2g", 1, "2g");
    mtN = new c("Mobile_3g", 2, "3g");
    mtO = new c("Mobile_4g", 3, "4g");
    mtP = new c("Mobile_5g", 4, "5g");
    mtQ = new c("Wifi", 5, "wifi");
    mtR = new c("Unknown", 6, "unknown");
    mtS = new c[] { mtL, mtM, mtN, mtO, mtP, mtQ, mtR };
    AppMethodBeat.o(137663);
  }
  
  private f$c(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.f.c
 * JD-Core Version:    0.7.0.1
 */
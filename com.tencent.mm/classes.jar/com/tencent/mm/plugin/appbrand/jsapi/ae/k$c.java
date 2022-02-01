package com.tencent.mm.plugin.appbrand.jsapi.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum k$c
{
  public final String value;
  
  static
  {
    AppMethodBeat.i(137663);
    swK = new c("None", 0, "none");
    swL = new c("Mobile_2g", 1, "2g");
    swM = new c("Mobile_3g", 2, "3g");
    swN = new c("Mobile_4g", 3, "4g");
    swO = new c("Mobile_5g", 4, "5g");
    swP = new c("Wifi", 5, "wifi");
    swQ = new c("Unknown", 6, "unknown");
    swR = new c[] { swK, swL, swM, swN, swO, swP, swQ };
    AppMethodBeat.o(137663);
  }
  
  private k$c(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.k.c
 * JD-Core Version:    0.7.0.1
 */
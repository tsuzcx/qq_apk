package com.tencent.mm.plugin.appbrand.jsapi.v;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e$c
{
  public final String value;
  
  static
  {
    AppMethodBeat.i(137663);
    klz = new c("None", 0, "none");
    klA = new c("Mobile_2g", 1, "2g");
    klB = new c("Mobile_3g", 2, "3g");
    klC = new c("Mobile_4g", 3, "4g");
    klD = new c("Mobile_5g", 4, "5g");
    klE = new c("Wifi", 5, "wifi");
    klF = new c("Unknown", 6, "unknown");
    klG = new c[] { klz, klA, klB, klC, klD, klE, klF };
    AppMethodBeat.o(137663);
  }
  
  private e$c(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.e.c
 * JD-Core Version:    0.7.0.1
 */
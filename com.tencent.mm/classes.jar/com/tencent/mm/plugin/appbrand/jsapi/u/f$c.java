package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f$c
{
  public final String value;
  
  static
  {
    AppMethodBeat.i(137663);
    kMR = new c("None", 0, "none");
    kMS = new c("Mobile_2g", 1, "2g");
    kMT = new c("Mobile_3g", 2, "3g");
    kMU = new c("Mobile_4g", 3, "4g");
    kMV = new c("Mobile_5g", 4, "5g");
    kMW = new c("Wifi", 5, "wifi");
    kMX = new c("Unknown", 6, "unknown");
    kMY = new c[] { kMR, kMS, kMT, kMU, kMV, kMW, kMX };
    AppMethodBeat.o(137663);
  }
  
  private f$c(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.f.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.x;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f$c
{
  public final String value;
  
  static
  {
    AppMethodBeat.i(137663);
    lnh = new c("None", 0, "none");
    lni = new c("Mobile_2g", 1, "2g");
    lnj = new c("Mobile_3g", 2, "3g");
    lnk = new c("Mobile_4g", 3, "4g");
    lnl = new c("Mobile_5g", 4, "5g");
    lnm = new c("Wifi", 5, "wifi");
    lnn = new c("Unknown", 6, "unknown");
    lno = new c[] { lnh, lni, lnj, lnk, lnl, lnm, lnn };
    AppMethodBeat.o(137663);
  }
  
  private f$c(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.f.c
 * JD-Core Version:    0.7.0.1
 */
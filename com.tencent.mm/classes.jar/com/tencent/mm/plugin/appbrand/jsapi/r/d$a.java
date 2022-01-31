package com.tencent.mm.plugin.appbrand.jsapi.r;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum d$a
{
  public final String value;
  
  static
  {
    AppMethodBeat.i(126409);
    iaJ = new a("None", 0, "none");
    iaK = new a("Mobile_2g", 1, "2g");
    iaL = new a("Mobile_3g", 2, "3g");
    iaM = new a("Mobile_4g", 3, "4g");
    iaN = new a("Wifi", 4, "wifi");
    iaO = new a("Unknown", 5, "unknown");
    iaP = new a[] { iaJ, iaK, iaL, iaM, iaN, iaO };
    AppMethodBeat.o(126409);
  }
  
  private d$a(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.d.a
 * JD-Core Version:    0.7.0.1
 */
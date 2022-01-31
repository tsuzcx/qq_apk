package com.tencent.luggage.sdk.customize.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.q.a;

public class b
  implements q.a
{
  public String vV()
  {
    return " Luggage/";
  }
  
  public final String version()
  {
    AppMethodBeat.i(114301);
    String str = String.format("%s-nano", new Object[] { "unknown" });
    AppMethodBeat.o(114301);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.b
 * JD-Core Version:    0.7.0.1
 */
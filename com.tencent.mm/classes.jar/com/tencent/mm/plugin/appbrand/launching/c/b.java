package com.tencent.mm.plugin.appbrand.launching.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum b
{
  final String hUu;
  final int scene;
  
  static
  {
    AppMethodBeat.i(47409);
    lpm = new b("WALLET", 0, "weapp://wallet/", 1019);
    lpn = new b("SEARCH_NATIVE_FEATURE", 1, "weapp://search/", 1005);
    lpo = new b[] { lpm, lpn };
    AppMethodBeat.o(47409);
  }
  
  private b(String paramString, int paramInt)
  {
    this.hUu = paramString;
    this.scene = paramInt;
  }
  
  static String boa()
  {
    return "";
  }
  
  static String bob()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c.b
 * JD-Core Version:    0.7.0.1
 */
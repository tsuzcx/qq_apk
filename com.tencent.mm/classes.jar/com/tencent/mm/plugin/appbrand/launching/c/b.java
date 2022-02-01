package com.tencent.mm.plugin.appbrand.launching.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum b
{
  final String htS;
  final int scene;
  
  static
  {
    AppMethodBeat.i(47409);
    kNN = new b("WALLET", 0, "weapp://wallet/", 1019);
    kNO = new b("SEARCH_NATIVE_FEATURE", 1, "weapp://search/", 1005);
    kNP = new b[] { kNN, kNO };
    AppMethodBeat.o(47409);
  }
  
  private b(String paramString, int paramInt)
  {
    this.htS = paramString;
    this.scene = paramInt;
  }
  
  static String bhg()
  {
    return "";
  }
  
  static String bhh()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c.b
 * JD-Core Version:    0.7.0.1
 */
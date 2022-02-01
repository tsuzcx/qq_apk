package com.tencent.mm.plugin.appbrand.openmaterial.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public final String tsa;
  public final int tsb;
  
  static
  {
    AppMethodBeat.i(323596);
    trW = new b("WEB_VIEW", 0, "webview", 1);
    trX = new b("IMAGE", 1, "image", 2);
    trY = new b("VIDEO", 2, "video", 2);
    trZ = new b("ATTACH", 3, "attach", 4);
    tsc = new b[] { trW, trX, trY, trZ };
    AppMethodBeat.o(323596);
  }
  
  private b(String paramString, int paramInt)
  {
    this.tsa = paramString;
    this.tsb = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.model.b
 * JD-Core Version:    0.7.0.1
 */
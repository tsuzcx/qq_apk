package com.tencent.mm.plugin.appbrand.openmaterial.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public final String qnt;
  private final int qnu;
  
  static
  {
    AppMethodBeat.i(192454);
    qnp = new b("WEB_VIEW", 0, "webview", 1);
    qnq = new b("IMAGE", 1, "image", 2);
    qnr = new b("VIDEO", 2, "video", 2);
    qns = new b("ATTACH", 3, "attach", 4);
    qnv = new b[] { qnp, qnq, qnr, qns };
    AppMethodBeat.o(192454);
  }
  
  private b(String paramString, int paramInt)
  {
    this.qnt = paramString;
    this.qnu = paramInt;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    return (this.qnu & paramInt) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.model.b
 * JD-Core Version:    0.7.0.1
 */
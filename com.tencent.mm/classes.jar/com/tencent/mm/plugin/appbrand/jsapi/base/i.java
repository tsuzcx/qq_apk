package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;

public final class i
{
  e oGr;
  int okO;
  
  public i(e parame, int paramInt)
  {
    this.oGr = parame;
    this.okO = paramInt;
  }
  
  public final void aho(String paramString)
  {
    AppMethodBeat.i(140655);
    this.oGr.j(this.okO, paramString);
    AppMethodBeat.o(140655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.i
 * JD-Core Version:    0.7.0.1
 */
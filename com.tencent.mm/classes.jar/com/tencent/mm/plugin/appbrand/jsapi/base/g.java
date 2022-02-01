package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;

public final class g
{
  c jGV;
  int joH;
  
  public g(c paramc, int paramInt)
  {
    this.jGV = paramc;
    this.joH = paramInt;
  }
  
  public final void HQ(String paramString)
  {
    AppMethodBeat.i(140655);
    this.jGV.h(this.joH, paramString);
    AppMethodBeat.o(140655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.g
 * JD-Core Version:    0.7.0.1
 */
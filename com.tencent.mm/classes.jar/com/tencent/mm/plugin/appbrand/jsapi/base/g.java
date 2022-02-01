package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;

public final class g
{
  int jOT;
  c khu;
  
  public g(c paramc, int paramInt)
  {
    this.khu = paramc;
    this.jOT = paramInt;
  }
  
  public final void LV(String paramString)
  {
    AppMethodBeat.i(140655);
    this.khu.h(this.jOT, paramString);
    AppMethodBeat.o(140655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.g
 * JD-Core Version:    0.7.0.1
 */
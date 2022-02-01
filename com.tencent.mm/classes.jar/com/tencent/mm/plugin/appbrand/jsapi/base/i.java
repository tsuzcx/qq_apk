package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;

public final class i
{
  c kCl;
  int kje;
  
  public i(c paramc, int paramInt)
  {
    this.kCl = paramc;
    this.kje = paramInt;
  }
  
  public final void Pr(String paramString)
  {
    AppMethodBeat.i(140655);
    this.kCl.h(this.kje, paramString);
    AppMethodBeat.o(140655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.i
 * JD-Core Version:    0.7.0.1
 */
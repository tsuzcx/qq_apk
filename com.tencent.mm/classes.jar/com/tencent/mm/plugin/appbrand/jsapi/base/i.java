package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;

public final class i
{
  c kFA;
  int kmu;
  
  public i(c paramc, int paramInt)
  {
    this.kFA = paramc;
    this.kmu = paramInt;
  }
  
  public final void PZ(String paramString)
  {
    AppMethodBeat.i(140655);
    this.kFA.h(this.kmu, paramString);
    AppMethodBeat.o(140655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.i
 * JD-Core Version:    0.7.0.1
 */
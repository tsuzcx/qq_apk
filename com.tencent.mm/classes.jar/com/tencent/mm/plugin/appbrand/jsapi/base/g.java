package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;

public final class g
{
  c hET;
  int hry;
  
  public g(c paramc, int paramInt)
  {
    this.hET = paramc;
    this.hry = paramInt;
  }
  
  public final void BS(String paramString)
  {
    AppMethodBeat.i(91048);
    this.hET.h(this.hry, paramString);
    AppMethodBeat.o(91048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.g
 * JD-Core Version:    0.7.0.1
 */
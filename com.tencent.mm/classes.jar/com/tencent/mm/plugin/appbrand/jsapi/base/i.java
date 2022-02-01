package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;

public final class i
{
  f lKb;
  int lqe;
  
  public i(f paramf, int paramInt)
  {
    this.lKb = paramf;
    this.lqe = paramInt;
  }
  
  public final void ZA(String paramString)
  {
    AppMethodBeat.i(140655);
    this.lKb.i(this.lqe, paramString);
    AppMethodBeat.o(140655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.i
 * JD-Core Version:    0.7.0.1
 */
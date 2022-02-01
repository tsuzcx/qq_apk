package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;

public final class i
{
  f rJq;
  int ror;
  
  public i(f paramf, int paramInt)
  {
    this.rJq = paramf;
    this.ror = paramInt;
  }
  
  public final void aal(String paramString)
  {
    AppMethodBeat.i(140655);
    this.rJq.callback(this.ror, paramString);
    AppMethodBeat.o(140655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.i
 * JD-Core Version:    0.7.0.1
 */
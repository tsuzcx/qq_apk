package com.tencent.mm.plugin.appbrand.widget.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.r;

public final class h
  extends d
{
  public h(String paramString, c paramc, r paramr)
  {
    super(paramString, paramc, paramr);
  }
  
  public final void aSq()
  {
    AppMethodBeat.i(87569);
    i locali = this.hxb.getRuntime();
    if ((locali != null) && (this.jxc != null)) {
      com.tencent.mm.sdk.g.d.h(new h.1(this, locali), "PackageIconLoader ").start();
    }
    AppMethodBeat.o(87569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i.h
 * JD-Core Version:    0.7.0.1
 */
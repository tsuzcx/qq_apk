package com.tencent.mm.plugin.appbrand.widget.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;

public final class i
  extends d
{
  public i(String paramString, c paramc, r paramr)
  {
    super(paramString, paramc, paramr);
  }
  
  public final void aSq()
  {
    AppMethodBeat.i(87571);
    if ((this.hxb.wX() != null) && (this.jxc != null))
    {
      com.tencent.mm.sdk.g.d.h(new i.1(this), "TempFileIconLoader").start();
      AppMethodBeat.o(87571);
      return;
    }
    this.jxd.a("Failed to load icon via temp file", this);
    AppMethodBeat.o(87571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i.i
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.widget.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends d
{
  public b(String paramString, c paramc)
  {
    super(paramString, paramc);
  }
  
  public final void aSq()
  {
    AppMethodBeat.i(87562);
    if (this.jxc != null)
    {
      com.tencent.mm.sdk.g.d.h(new b.1(this), "Base64IconLoader").start();
      AppMethodBeat.o(87562);
      return;
    }
    this.jxd.a("Failed to load icon via base64 icon", this);
    AppMethodBeat.o(87562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i.b
 * JD-Core Version:    0.7.0.1
 */
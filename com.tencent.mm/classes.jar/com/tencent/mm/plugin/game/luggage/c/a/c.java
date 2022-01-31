package com.tencent.mm.plugin.game.luggage.c.a;

import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;

public final class c
{
  f njV;
  b njW;
  public d njX;
  
  public c(f paramf, b paramb)
  {
    AppMethodBeat.i(135896);
    this.njV = paramf;
    this.njW = paramb;
    this.njX = new d(this.njV.mContext);
    this.njX.vnP = new c.1(this);
    this.njX.a(new c.2(this));
    this.njX.crd();
    AppMethodBeat.o(135896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.c
 * JD-Core Version:    0.7.0.1
 */
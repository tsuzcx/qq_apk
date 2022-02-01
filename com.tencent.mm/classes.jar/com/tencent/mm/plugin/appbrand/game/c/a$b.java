package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.magicbrush.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;

final class a$b
  implements d.a
{
  private int ciH = -1;
  
  public final void gS(int paramInt)
  {
    AppMethodBeat.i(45102);
    ad.i("MicroMsg.MBFontManagerRegistryWC", "mbfont idkey logid:" + this.ciH + ",key:" + paramInt);
    g.yhR.dD(this.ciH, paramInt);
    AppMethodBeat.o(45102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.a.b
 * JD-Core Version:    0.7.0.1
 */
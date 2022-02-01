package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.magicbrush.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;

final class a$b
  implements d.a
{
  private int ciJ = -1;
  
  public final void gT(int paramInt)
  {
    AppMethodBeat.i(45102);
    ae.i("MicroMsg.MBFontManagerRegistryWC", "mbfont idkey logid:" + this.ciJ + ",key:" + paramInt);
    g.yxI.dD(this.ciJ, paramInt);
    AppMethodBeat.o(45102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.a.b
 * JD-Core Version:    0.7.0.1
 */
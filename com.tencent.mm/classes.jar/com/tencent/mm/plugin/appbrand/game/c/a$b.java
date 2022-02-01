package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.magicbrush.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;

final class a$b
  implements d.a
{
  private int bYp = -1;
  
  public final void gN(int paramInt)
  {
    AppMethodBeat.i(45102);
    ac.i("MicroMsg.MBFontManagerRegistryWC", "mbfont idkey logid:" + this.bYp + ",key:" + paramInt);
    h.wUl.dB(this.bYp, paramInt);
    AppMethodBeat.o(45102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.a.b
 * JD-Core Version:    0.7.0.1
 */
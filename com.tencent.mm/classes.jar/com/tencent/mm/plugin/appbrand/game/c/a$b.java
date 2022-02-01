package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.magicbrush.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

final class a$b
  implements d.a
{
  private int ekI = -1;
  
  public final void mQ(int paramInt)
  {
    AppMethodBeat.i(45102);
    Log.i("MicroMsg.MBFontManagerRegistryWC", "mbfont idkey logid:" + this.ekI + ",key:" + paramInt);
    h.OAn.kJ(this.ekI, paramInt);
    AppMethodBeat.o(45102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.a.b
 * JD-Core Version:    0.7.0.1
 */
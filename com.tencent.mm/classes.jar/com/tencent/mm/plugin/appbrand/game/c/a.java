package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends com.tencent.luggage.game.c.a
{
  public static final a hsP;
  
  static
  {
    AppMethodBeat.i(143123);
    hsP = new a();
    AppMethodBeat.o(143123);
  }
  
  public final void a(MBRuntime paramMBRuntime, i parami)
  {
    AppMethodBeat.i(143122);
    super.a(paramMBRuntime, parami);
    com.tencent.magicbrush.a.a.a(new a.a((byte)0));
    com.tencent.magicbrush.handler.glfont.a.a(new b());
    AppMethodBeat.o(143122);
  }
  
  static final class b
    implements d.a
  {
    private int bAc = -1;
    
    public final void fI(int paramInt)
    {
      AppMethodBeat.i(143121);
      ab.i("MicroMsg.MBFontManagerRegistryWC", "mbfont idkey logid:" + this.bAc + ",key:" + paramInt);
      h.qsU.cT(this.bAc, paramInt);
      AppMethodBeat.o(143121);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.a
 * JD-Core Version:    0.7.0.1
 */
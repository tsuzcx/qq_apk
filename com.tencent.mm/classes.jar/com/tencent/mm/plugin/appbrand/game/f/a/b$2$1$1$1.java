package com.tencent.mm.plugin.appbrand.game.f.a;

import com.tencent.magicbrush.d;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.a.p;
import com.tencent.mm.plugin.appbrand.game.a.r;
import com.tencent.mm.sdk.platformtools.ae;

final class b$2$1$1$1
  implements b.c
{
  b$2$1$1$1(b.2.1.1 param1) {}
  
  public final void onDone()
  {
    AppMethodBeat.i(45200);
    if (this.kpY.kpX.kpW.kpR)
    {
      if (((Boolean)p.kok.att()).booleanValue())
      {
        ae.i("MicroMsg.GameGLSurfaceView", "hy: use main thread choreographer");
        if (((Boolean)r.kom.att()).booleanValue())
        {
          this.kpY.kpX.kpV.a(a.b.cAw);
          AppMethodBeat.o(45200);
          return;
        }
        this.kpY.kpX.kpV.a(a.b.cAt);
        AppMethodBeat.o(45200);
        return;
      }
      ae.i("MicroMsg.GameGLSurfaceView", "hy: use js thread choreographer");
      this.kpY.kpX.kpV.a(a.b.cAs);
      AppMethodBeat.o(45200);
      return;
    }
    this.kpY.kpX.kpV.a(a.b.cAu);
    AppMethodBeat.o(45200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.a.b.2.1.1.1
 * JD-Core Version:    0.7.0.1
 */
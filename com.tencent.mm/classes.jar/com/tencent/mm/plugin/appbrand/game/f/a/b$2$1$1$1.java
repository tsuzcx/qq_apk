package com.tencent.mm.plugin.appbrand.game.f.a;

import com.tencent.magicbrush.d;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.a.m;
import com.tencent.mm.plugin.appbrand.game.a.o;
import com.tencent.mm.sdk.platformtools.ac;

final class b$2$1$1$1
  implements b.c
{
  b$2$1$1$1(b.2.1.1 param1) {}
  
  public final void onDone()
  {
    AppMethodBeat.i(45200);
    if (this.jSu.jSt.jSs.jSn)
    {
      if (((Boolean)m.jQF.aqp()).booleanValue())
      {
        ac.i("MicroMsg.GameGLSurfaceView", "hy: use main thread choreographer");
        if (((Boolean)o.jQH.aqp()).booleanValue())
        {
          this.jSu.jSt.jSr.a(a.b.coY);
          AppMethodBeat.o(45200);
          return;
        }
        this.jSu.jSt.jSr.a(a.b.coV);
        AppMethodBeat.o(45200);
        return;
      }
      ac.i("MicroMsg.GameGLSurfaceView", "hy: use js thread choreographer");
      this.jSu.jSt.jSr.a(a.b.coU);
      AppMethodBeat.o(45200);
      return;
    }
    this.jSu.jSt.jSr.a(a.b.coW);
    AppMethodBeat.o(45200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.a.b.2.1.1.1
 * JD-Core Version:    0.7.0.1
 */
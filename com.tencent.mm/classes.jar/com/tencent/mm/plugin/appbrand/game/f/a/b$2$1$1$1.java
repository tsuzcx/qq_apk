package com.tencent.mm.plugin.appbrand.game.f.a;

import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.a.r;
import com.tencent.mm.plugin.appbrand.game.a.t;
import com.tencent.mm.sdk.platformtools.Log;

final class b$2$1$1$1
  implements b.c
{
  b$2$1$1$1(b.2.1.1 param1) {}
  
  public final void onDone()
  {
    AppMethodBeat.i(45200);
    if (this.ltG.ltF.ltE.ltz)
    {
      if (((Boolean)r.lrS.aLT()).booleanValue())
      {
        Log.i("MicroMsg.GameGLSurfaceView", "hy: use main thread choreographer");
        if (((Boolean)t.lrU.aLT()).booleanValue())
        {
          this.ltG.ltF.ltD.a(a.b.cOC);
          AppMethodBeat.o(45200);
          return;
        }
        this.ltG.ltF.ltD.a(a.b.cOz);
        AppMethodBeat.o(45200);
        return;
      }
      Log.i("MicroMsg.GameGLSurfaceView", "hy: use js thread choreographer");
      this.ltG.ltF.ltD.a(a.b.cOy);
      AppMethodBeat.o(45200);
      return;
    }
    this.ltG.ltF.ltD.a(a.b.cOA);
    AppMethodBeat.o(45200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.a.b.2.1.1.1
 * JD-Core Version:    0.7.0.1
 */